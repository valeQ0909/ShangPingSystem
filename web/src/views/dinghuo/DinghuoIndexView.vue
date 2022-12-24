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

        <div class="error_msg">{{error_msg}}</div>

    </div>
</template>

<script>
import DingHuoDan from "../../components/DingHuoDan.vue"
import {ref, reactive} from "vue"

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

        let dinghuolist = reactive([
            {
                goods_name:"旺旺雪饼",
                quantity: 2000,
                unit:"袋",
                buyer:"002",
                deadline:"2022-12-21 00:10:33",
                state: "待采购",
            },
            {

                goods_name:"旺旺小小酥",
                quantity: 2000,
                unit:"袋",
                buyer:"002",
                deadline:"2022-12-21 00:10:33",
                state: "待采购",
            },
            {
                goods_name:"旺旺摇滚冻",
                quantity: 2000,
                unit:"袋",
                buyer:"002",
                deadline:"2022-12-21 00:10:33",
                state: "待采购",
            }
        ])

        // 采购任务函数
        const caigourenwu = ()=>{

            if(goodsName.value === "" ||quantity.value === "" ||unit.value === ""||buyer.value === ""||deadline.value=== ""){
                // 如果没填写完整，则修改报错信息error_msg的值，并在html文件中展示该报错信息
                error_msg.value = "请将采购内容填写完整"
            }
            else{
                // 如果都填写了，则执行后续逻辑
                goodsName.value = "";
                quantity.value = "";
                unit.value = "";
                buyer.value = "";
                deadline.value = "";
                console.log("成功发布任务")
            }
        }

        return{
            dinghuolist,
            goodsName,
            quantity,
            unit,
            buyer,
            deadline,
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
    cursor: pointer;  /*鼠标放上去显示小手 */
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