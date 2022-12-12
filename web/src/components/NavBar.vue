<template>
    <div class="container">
        <div class="logo">
            <img src="../assets/images/logo.png" alt="logo" />
        </div>
        
        <div class="motto">
            <span class="motto-item"
                v-for="(item, index) in motto"
                :key="index"
                v-show="n === index"
            >
                {{ item }}
            </span>
        </div>

       
        <router-link to="/kucun/" @click="changeColor1" class="item1 item">库存</router-link>
  
        <router-link to="/dinghuo/" @click="changeColor2" class="item2 item">订货</router-link>

        <div class="avatar">
            <img src="../assets/images/avatar.png" alt="avatar"/>
        </div>

    </div>
  </template>
  
<script>
console.log("乘风好去，长空万里，直下看山河。\n斫去桂婆娑，人道是、清光更多。\n                   -- 辛弃疾");
import { reactive} from "vue"
import { useStore } from 'vuex';
import { useRouter } from "vue-router";

export default {
    setup(){
        const store = useStore();
        const router = useRouter();
        const currentpage = router.currentRoute.value.name;
        store.commit("updatecurrentpage", currentpage);

        const theme1 = reactive({
            color: 'rgb(141, 139, 139)'
        });
        const theme2 = reactive({
            color: 'rgb(141, 139, 139)'
        });

        if (store.state.currentpage === "kucun_index"){
            theme1.color = "white"
        }
        else if(store.state.currentpage === "dinghuo_index"){
            theme2.color = "white"
        }

        const changeColor1 = ()=>{
            theme1.color = "white"
            theme2.color = "rgb(141, 139, 139)"
        };
        const changeColor2 = ()=>{
            theme2.color="white"
            theme1.color="rgb(141, 139, 139)"
        };
        return {
            theme1,
            theme2,
            changeColor1,
            changeColor2,
       };
    },

    data() {
    return {
      motto: [
        "我见青山多妩媚，料青山见我应如是。",
        "不恨古人吾不见，恨古人不见吾狂耳。",
        "我最怜君中宵舞，道“男儿到死心如铁”。看试手，补天裂。",
        "吾庐小，在龙蛇影外，风雨声中。",
        "乘风好去，长空万里，直下看山河。",
        "斫去桂婆娑，人道是、清光更多。",
        "鸿鹄一再高举，天地睹方圆。",
      ],
      n: 0,
    };
  },

    methods: {
        go() {
        //从开始改变变量n
        setInterval(() => {
            this.n++;
            if (this.n === this.motto.length) this.n = 0;
        }, 6000);
        },
    },

    mounted(){
        this.go();
    }

  };
</script>
  
<style scoped>
.router-link-active{
text-decoration: none;
}
a {
 text-decoration: none;
}
.container{
    height: 10vh;
    width: 100%;
    background-color: rgba(34,34,34);
}
.container .logo{
    float: left;
    height: 5vh;
    width: 5vh;
    margin-left: 5vw;
    margin-top: 2.5vh;

}
.container .logo img{
    width: 100%;
    height: 100%;
}


.container .motto{
    color: white;
    float: left;
    width: 500px;
    margin-left: 10vw;
    margin-top: 3vh;
}

.container .item1{
    cursor: pointer;
    float: left;
    margin-left: 5vw;
    margin-top: 2vh;
    color: v-bind('theme1.color');
    font-size: 4vh;
}
.container .item2{
    cursor: pointer;  
    float: left;
    margin-left: 8vw;
    margin-top: 2vh;
    color: v-bind('theme2.color');;
    font-size: 4vh;
}
.container .item:hover{
    color: white;
}

.container .avatar{
    margin-top: 1vh;
    margin-right: 5vw;
    float: right;
    height: 8vh;
    width: 8vh;
}

.container .avatar img{
    width: 100%;
    height: 100%;
}
</style>



