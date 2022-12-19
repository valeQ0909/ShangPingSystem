<template>
    <div class="platform">
        <div class="name item">商品名称</div>
        <div class="quantity item">商品数量</div>
        <div class="price item">单价</div>
        <div class="unit item">单位</div>
        <div class="qgp item">保质期</div>
        <div class="purchase_time item">采购时间</div>
        <div class="buyer item">采购员</div>
        <div class="supplier item">供应商</div>
        <div class="describe item">描述</div>
        <KuCunDan v-for="m in kucunlist" :key="m.id"
                                            :name="m.name"
                                            :quantity="m.quantity"
                                            :price="m.price"
                                            :unit="m.unit"
                                            :qgp="m.qgp"
                                            :purchase_time="m.purchase_time"
                                            :buyer="m.buyer"
                                            :supplier="m.supplier"
                                            :describe="m.describe"
        ></KuCunDan>
    </div>
</template>

<script>
import { ref } from "vue";
import KuCunDan from "../../components/KuCunDan.vue"

export default{
    components: {
        KuCunDan
    },

    setup() {
        let kucunlist = ref([
            {
                id:0,
                name:"德芙巧克力",
                quantity:2000,
                price:2,
                unit:"元/袋",
                qgp:"2023年12月24日",
                purchase_time:"2022年12月5日",
                buyer:"002",
                supplier:"湖南长兴县",
                describe:"无"
            },
            {
                id:1,
                name:"旺旺沙琪玛",
                quantity:2000,
                price:3,
                unit:"元/袋",
                qgp:"2023年12月24日",
                purchase_time:"2022年12月5日",
                buyer:"002",
                supplier:"湖南长兴县",
                describe:"无"
            },
            ])

        return{
            kucunlist,
        }
    },

}
</script>

<style scoped>
.platform{
    height: 90vh;
    width: 100%;
    background-color: rgba(118,234,211, 0.5);
}
.platform .item{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 10vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}
.platform .name{
    margin-left: 5vw;
}

</style>