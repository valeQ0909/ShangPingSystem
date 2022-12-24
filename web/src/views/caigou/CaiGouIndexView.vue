<template>
    <div class="allpage">
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
    </div>
</template>

<script>
import { ref } from "vue";
import CaigouDan from "../../components/CaigouDan.vue"
export default{

    components: {
        CaigouDan
    },
    setup() {
        let caigoulist = ref([
            {
                buyer: "002",
                caigou_id: 1,
                deadline: "2023-12-20 00:10:48",
                delivery_time: "2022-12-21 00:10:33",
                goods_name: "西瓜",
                quantity: 22,
                state: "待采购",
                unit:"斤",
            },
            {
                buyer: "004",
                caigou_id: 2,
                deadline: "2023-12-20 00:10:48",
                delivery_time: "2022-12-21 00:10:33",
                goods_name: "番茄",
                quantity: 300,
                state: "待采购",
                unit:"斤",
            },
        ])

        return{
            caigoulist,
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

.allpage .delivery_time{
    margin-left: 2vw;
}

</style>