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
import axios from "axios";
import store from "../../store";
export default{
    components: {
        KuCunDan
    },

    setup() {
        let kucunlist = ref([])
        
        const getkucun = () =>{
            axios({
              headers: {
                Authorization:"Bearer " + store.state.user.token,
              },
              method: "GET",
              url: "http://127.0.0.1:3000/manager/kucun/",
            }).then((resp)=>{
                if(resp.data.error_message === "success") {
                    kucunlist.value = resp.data.stocks;

                }
          });
        }

        getkucun();

        console.log("hhh: ", kucunlist)
        return{
            kucunlist,
            getkucun,
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