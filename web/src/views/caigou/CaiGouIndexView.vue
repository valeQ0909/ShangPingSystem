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
import axios from "axios";
import store from "../../store";

export default{

    components: {
        CaigouDan
    },
    setup() {
        let caigoulist = ref([])
        const caigou = () =>{
            axios({
              headers: {
                Authorization:"Bearer " + store.state.user.token,
              },
              method: "GET",
              url: "http://127.0.0.1:3000/buyer/caigou/",
            }).then((resp)=>{
                if(resp.data.error_message === "success") {
                    caigoulist.value = resp.data.caigou;
                }
            });
        }

        caigou();
        return{
            caigoulist,
            caigou,
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