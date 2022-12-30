<template>
    <div class="personalpage">
        <div class="left">
            <div class="Pidentity">{{identity}}</div>
            <div class="Pname">{{nickname}}</div>
        </div>

        <div class="right">
            <img  alt="" :src='imgStr'>
            <div class="Pavatar">头像链接</div>
            <div id="in_avatar" class="input" >
                <input v-model="newavatar" placeholder="请输入头像链接" type="text" />
            </div>
            
            <div class="Pnickname">用户昵称</div>
            <div id="in_nickname" class="input" >
                <input v-model="newnickname" placeholder="请输入新昵称" type="text" />
            </div>
            <div class="sure_change" @click="updateinfo"><p>确认修改</p></div>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import store from '../../store';
import axios from 'axios';

export default{


    setup(){
        let identity = ref("")
        let nickname = ref("")
        let imgStr = ref("")
        let newavatar = ref("")
        let newnickname = ref("")
        imgStr.value = store.state.user.photo
        identity.value = store.state.user.identity
        nickname.value = store.state.user.nickname

        const updateinfo = () =>{
            if(newavatar.value === ""){
                newavatar.value = store.state.user.photo
            }
            if(newnickname.value === ""){
                newnickname.value = store.state.user.nickname
            }

            axios({
                header:{
                    'Content-Type':'application/x-www-form-urlencoded'
                },
                method: 'POST',
                url: "http://127.0.0.1:3000/user/updateInfo/",
                data: {
                    'username':store.state.user.username,
                    'avatar': newavatar.value,
                    'nickname':newnickname.value,
                }
                }).then(resp => {
                    store.dispatch("getinfo",{
                        success(){
                            imgStr.value = store.state.user.photo
                            identity.value = store.state.user.identity
                            nickname.value = store.state.user.nickname
                            store.commit("updatePullingInfo", false);
                        },
                        error(){
                            store.commit("updatePullingInfo", false);
                        }
                    })
                    console.log(resp)

                });
            newavatar.value = ""
            newnickname.value = ""
        }

 
        return{
            imgStr,
            identity,
            nickname,
            newavatar,
            newnickname,
            updateinfo,
        }
    }
}
</script>

<style scoped>
.personalpage{
    height: 90vh;
    width: 100%;
    background-color: rgba(118,234,211, 0.5);
}
.personalpage .left{
    float: left;
    height: 90vh;
    width: 25vw;
}

.personalpage .Pidentity{
    width: 20vw;
    text-align:center; 
    line-height:5vh;
    font-size: 40px;
    margin-top: 20vh;
    margin-left: 5vw;
}

.personalpage .Pname{
    width: 20vw;
    text-align:center; 
    line-height:5vh;
    font-size: 30px;

    margin-top: 20vh;
    margin-left: 5vw;
}

.personalpage .right{
    float: left;
    height: 90vh;
    width: 75vw;
}

.personalpage .right img{
    padding-top: 5vh;
    display: block;
    width: 200px;
    height: 200px;

    margin-left: 20vw;
}


.personalpage .right .Pavatar{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    width: 20vw;
    margin-top: 3vh;
    margin-left: 17vw;
}

.personalpage .right  .Pnickname{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    width: 20vw;
    margin-top: 3vh;
    margin-left: 17vw;
}

.personalpage .right .input{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 20vw;
    border-width: 0.5px;
    border-style: solid;

    margin-left: 17vw;
}

.personalpage .right .input input{
    height: 80%;
    width: 98%;
    background-color:transparent;
    border:0;
}

.personalpage .right .input input::-webkit-input-placeholder {
    font-size: 20px;
    text-align:center; 
}

.personalpage .right .sure_change{
    margin-top: 3vh;
    font-size: 20px;
    line-height:8vw;
    text-align:center; 

    width: 8vw;
    height: 8vw;
    border-radius: 50px;
    cursor: pointer;
    background-color: rgb(76, 251, 12);

    margin-left: 23vw;
}

.personalpage .right .sure_change:hover{
    background-color: rgba(144, 249, 158, 0.4);
}

</style>