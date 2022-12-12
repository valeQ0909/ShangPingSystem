import axios from "axios";

export default {
    state:{
        id: "",
        username: "",
        photo: "",
        token: "",
        is_login: false,
        pulling_info:true,   // 是否正在云端拉取信息
    },
    getters:{

    },
    mutations:{
        updateUser(state, user) {
            state.id = user.id;
            state.username = user.username;
            state.photo = user.photo;
            state.is_login = user.is_login;
        },
        updateToken(state, token) {
            state.token = token;
        },
        logout(state){
            state.id = "";
            state.username = "";
            state.photo = "";
            state.token = "";
            state.is_login = false;
        },
        updatePullingInfo(state, pulling_info){
            state.pulling_info = pulling_info;
        }
    },
    actions:{
      
        // 获取信息
        getinfo(context, data){
          axios({
              headers: {
                Authorization:"Bearer " + context.state.token,
              },
              method: "GET",
              url: "http://127.0.0.1:3000/user/info/",
          }).then((resp)=>{
                if(resp.data.error_message === "success") {
                    context.commit("updateUser", {
                        ...resp,
                        is_login: true,
                      });
                      data.success(resp);
                }
                else {
                    data.error(resp);
                }
          });
        },

        // 登录
        login(context, data){
            axios({
                header:{
                  'Content-Type':'application/x-www-form-urlencoded'
                },
                method: "POST",
                url: "http://127.0.0.1:3000/user/token/",
                data: {
                  'username': data.username,
                  'password': data.password,
                },
              }).then((resp) => {
                  if (resp.data.error_message === "success") {
                    localStorage.setItem("jwt_token", resp.data.token);
                    context.commit("updateToken", resp.data.token);
                    data.success(resp);
                  } else {
                      data.account = "";
                      data.password = "";
                      console.log(resp);
                      data.error(resp);
                      console.log(resp.data.error);
                  }
              });
        },

        //退出登录
        logout(context) {
            localStorage.removeItem("jwt_token");
            context.commit("logout");
        },


    },
    modules:{

    }
}