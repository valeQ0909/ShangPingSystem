<template>
    <div class="allpage">
        <div class="invoice_id item">报销单号</div>
        <div class="invoice_bill item">发票单据</div>
        <div class="state item">审核状态</div>
        <CaiwubaoxiaoBDan v-for="m in billlist" :key="m.id"
                                                :invoice_id="m.bill_id"
                                                :invoice_bill="m.invoice_bill"
                                                :invoice_state="m.state"
        >
        </CaiwubaoxiaoBDan>
    </div>
</template>

<script>
import CaiwubaoxiaoBDan from '../../components/CaiwubaoxiaoBDan.vue';
import { ref } from 'vue';
import axios from 'axios';
import store from '../../store';

export default{

    components: {
        CaiwubaoxiaoBDan
    },
    setup() {
        let billlist = ref([])

        const getbill = () => {
            axios({
              headers: {
                Authorization:"Bearer " + store.state.user.token,
              },
              method: "GET",
              url: "http://127.0.0.1:3000/finance/getallbill/",
            }).then((resp)=>{
                console.log(resp)
                if(resp.data.error_message === "success") {
                    
                    billlist.value = resp.data.all_bill;
                }
            });
        }

        getbill();
        return{
            billlist,
            getbill,
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
    width: 25vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}
.allpage .invoice_id{
    margin-left: 10vw;
    border-left: 2px;
    border-style: solid;
}

</style>