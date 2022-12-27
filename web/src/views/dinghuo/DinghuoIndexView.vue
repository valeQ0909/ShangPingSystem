<template>
    <div class="allpage">
        <div class="goods_name item">商品名称</div>
        <div class="quantity item">数量</div>
        <div class="unit item">单位</div>
        <div class="buyer item">采购员</div>
        <div class="deadline item">截止时间</div>
        <div class="state item">采购状态</div>
        <DingHuoDan v-for="m in dinghuolist" :key="m.id" 
                                         :goods_name="m.goods_name" 
                                         :quantity="m.quantity" 
                                         :unit="m.unit" 
                                         :buyer="m.buyer"
                                         :deadline="m.deadline"
                                         :state="m.state"
        ></DingHuoDan>
        <form>
        <div id="in_name" class="input name" >
            <input v-model="goodsName" placeholder="商品名称" type="text" />
        </div>
        <div id="in_quantity" class="input">
            <input v-model="quantity" placeholder="数量" type="text" />
        </div>
        <div id="in_unit" class="input" >
            <input v-model="unit" placeholder="单位"  type="text" />
        </div>
        <div id="in_buyer" class="input">
            <input v-model="buyer" placeholder="采购员" type="text" />
        </div>
        <div id="in_deadline" class="input" >
            <input v-model="deadline" placeholder="截止时间" type="text" />
        </div>
        <div class="input subbmit" @click="caigourenwu">提交</div>
        </form>
        <div class="error_msg">{{error_msg}}</div>
    </div>
</template>

<script>
import DingHuoDan from "../../components/DingHuoDan.vue"
import {ref} from "vue"
import axios from "axios"
import store from "../../store"
export default{
    components: {
        DingHuoDan
    },
    setup() {
        let goodsName = ref("")
        let quantity = ref("")
        let unit = ref("")
        let buyer = ref("")
        let deadline = ref("")
        let error_msg = ref("")
        const dinghuolist = ref([
            {
                id:0,
                goods_name:"旺旺雪饼",
                quantity: 2000,
                unit:"袋",
                buyer:"002",
                deadline:"2022-12-13 16:01:30",
            }
        ])

        const caigou = () =>{
            axios({
              headers: {
                Authorization:"Bearer " + store.state.user.token,
              },
              method: "GET",
              url: "http://127.0.0.1:3000/manager/getDinghuo/",
            }).then((resp)=>{
                if(resp.data.error_message === "success") {
                    console.log("caigou: ", resp.data.dinghuo);
                    dinghuolist.value = resp.data.dinghuo;
                }
            });
        }

        const caigourenwu = ()=>{
            if(goodsName.value === "" ||quantity.value === "" ||unit.value === ""||buyer.value === ""||deadline.value=== ""){
                error_msg.value = "请将采购内容填写完整"
            }
            else{
                axios({
                    header:{
                        'Content-Type':'application/x-www-form-urlencoded'
                    },
                    method: 'POST',
                    url: "http://127.0.0.1:3000/manager/dinghuo/",
                    data: {
                        'name': goodsName.value,
                        'quantity': quantity.value,
                        'unit': unit.value,
                        'buyer': buyer.value,
                        'deadline': deadline.value,
                    }
                    }).then(response => {
                        if(response.data.code == 200){
                            caigou();
                            console.log("resp: ", response)
                            console.log("发布任务成功")
                        }
                        else{
                            console.log("发布失败")
                        }
                    });
                    goodsName.value = "";
                    quantity.value = "";
                    unit.value = "";
                    buyer.value = "";
                    deadline.value = "";
            }
        }

        caigou();

        return{
            dinghuolist,
            goodsName,
            quantity,
            unit,
            buyer,
            deadline,
            error_msg,
            caigou,
            caigourenwu,
        }
    }
}
</script>

<style scoped>
.allpage{
    height: 90vh;
    width: 100%;
    background-color: rgba(118,234,211, 0.5);
}
.allpage .item{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 16vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}

.allpage .goods_name{
    margin-left: 2vw;
}

.allpage .input{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 16vw;
    float: left;
    border-width: 0.5px;
    border-bottom: 2px;
    border-style: solid;
}
.allpage .input input{
    height: 80%;
    width: 98%;
    background-color:transparent;
    border:0;
}
.allpage .name{
    margin-left: 2vw;
}


.allpage .input input::-webkit-input-placeholder {
    font-size: 20px;
    text-align:center; 
}

.allpage .subbmit{
    cursor: pointer;
    background-color: #69de21;
}
.allpage .subbmit:hover{
    color: rgba(138, 143, 255, 0.4);
}

.allpage .error_msg{
    margin-left: 40vw;
    font-size: 20px;
    color: red;
}

</style>