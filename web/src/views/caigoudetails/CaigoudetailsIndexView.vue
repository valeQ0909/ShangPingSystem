<template>
    <div class="allpage">
        <div class="title">采购任务详情</div>
        <div class="delivery_time item">发布时间</div>
        <div class="goods_name item">商品名称</div>
        <div class="quantity item">数量</div>
        <div class="unit item">单位</div>
        <div class="deadline item">截止时间</div>
        <div class="state item">采购状态</div>
        <CaigouDan v-for="m in caigoulist" :key="m.id" 
                                         :delivery_time="m.delivery_time"
                                         :goods_name="m.goods_name" 
                                         :quantity="m.quantity" 
                                         :unit="m.unit" 
                                         :deadline="m.deadline"
                                         :state="m.state"
                                         :caigou_id="m.caigou_id"
        ></CaigouDan>

        <form>
        <div id="in_name" class="input name" >
            <input v-model="price" placeholder="商品单价" type="text" />
        </div>
        <div id="in_quantity" class="input">
            <input v-model="supplier" placeholder="供应商" type="text" />
        </div>
        <div id="in_unit" class="input" >
            <input v-model="qgp" placeholder="保质期"  type="text" />
        </div>
        <div id="in_deadline" class="input" >
            <input v-model="describe_info" placeholder="描述" type="text" />
        </div>
        <div class="input subbmit" @click="caigourenwu">完成采购任务</div>
        </form>
        <div class="error_msg">{{error_msg}}</div>


    </div>
</template>

<script>
import { ref } from "vue";
import { useRouter } from "vue-router";
import CaigouDan from "../../components/CaigouDan.vue"

import axios from "axios";
export default{
    components: {
        CaigouDan
    },
    setup() {
        let caigoulist = ref([])
        let price =ref("")
        let supplier = ref("")
        let qgp = ref("")
        let describe_info = ref("")
        let error_msg = ref("")
        const router = useRouter();
        console.log('router',router.currentRoute.value.name)
        console.log("parms", router.currentRoute.value)


        let caigou_id = router.currentRoute.value.query.id
        const caigou = () =>{
            axios({
                header:{
                    'Content-Type':'application/x-www-form-urlencoded'
                },
                method: 'POST',
                url: "http://127.0.0.1:3000/buyer/caigoudetails/",
                data: {
                    'caigou_id': caigou_id,
                }
                }).then(resp => {
                    caigoulist.value.push(resp.data);
                    console.log(resp.data);
                    console.log(caigoulist.value)
                });
        }

        const caigourenwu = ()=>{
            if(price.value === "" ||supplier.value === "" ||qgp.value === ""||describe_info.value === ""){
                error_msg.value = "请将采购内容填写完整"
            }
            else{
                axios({
                    header:{
                        'Content-Type':'application/x-www-form-urlencoded'
                    },
                    method: 'POST',
                    url: "http://127.0.0.1:3000/buyer/caigoufinish/",
                    data: {
                        'caigou_id': caigou_id,
                        'price': price.value,
                        'supplier': supplier.value,
                        'qgp': qgp.value,
                        'describe_info': describe_info.value,
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
                    price.value = "";
                    supplier.value = "";
                    qgp.value = "";
                    describe_info.value = "";
            }
        }


        caigou();
        return{
            caigoulist,
            price,
            supplier,
            qgp,
            describe_info,
            error_msg,
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

.allpage .title{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;
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

.allpage .delivery_time{
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
    background-color: rgba(37, 252, 177, 0.4);
}

.allpage .error_msg{
    margin-left: 40vw;
    font-size: 20px;
    color: red;
}

</style>