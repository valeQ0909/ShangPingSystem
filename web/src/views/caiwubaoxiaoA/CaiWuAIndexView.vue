<template>
    <div class="caiwu">
        <div class="invoice_id item">报销单号</div>
        <div class="invoice_bill item">发票单据</div>
        <div class="state item">审核状态</div>

        <CaiwubaoxiaoADan v-for="m in billlist" :key="m.id"
                                                :invoice_id="m.bill_id"
                                                :invoice_bill="m.invoice_bill"
                                                :invoice_state="m.state"
        >
        </CaiwubaoxiaoADan>

        <form>
        <div class="input billurl" >
            <input v-model="billurl" placeholder="发票链接" type="text" />
        </div>
        <div class="input subbmit" @click="subbmitbill">提交</div>
        </form>
        
        <div class="error_msg">{{error_msg}}</div>
        
    </div>
</template>

<script>
import { ref } from 'vue';
import CaiwubaoxiaoADan from '../../components/CaiwubaoxiaoADan.vue';

export default{
    components: {
        CaiwubaoxiaoADan
    },
    setup() {
        let billurl = ref("")  //用于接收输入框内的输入内容
        let error_msg = ref("")
        let billlist = ref([
            {
                bill_id: 2,
                invoice_bill: "https://i.328888.xyz/2022/12/23/AqkHq.png",
                state: "审核合格"
            },
            {
                bill_id: 3,
                invoice_bill: "https://i.328888.xyz/2022/12/23/AqkHq.png",
                state: "待审核"
            },
        ])

        const subbmitbill = () =>{
            if(billurl.value === ""){
                error_msg.value = "请填写完整错误信息"
            }
        }

        return{
            billurl,
            billlist,
            error_msg,
            subbmitbill,
        }
    }
}

</script>

<style scoped>
.caiwu{
    height: 90vh;
    width: 100%;
    background-color: rgba(118,234,211, 0.5);
}

.caiwu .item{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 25vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}
.caiwu .invoice_id{
    margin-left: 10vw;
    border-left: 2px;
    border-style: solid;
}


/*输入框*/
.caiwu .input{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 25vw;
    float: left;
    border-width: 0.5px;
    border-bottom: 2px;
    border-style: solid;
}

.caiwu .input input{
    height: 80%;
    width: 98%;
    background-color:transparent;
    border:0;
}
.caiwu .billurl{
    margin-left: 10vw;
    border-left: 2px;
    border-style: solid;
}


.caiwu .input input::-webkit-input-placeholder {
    font-size: 20px;
    text-align:center; 
}

.caiwu .subbmit{
    cursor: pointer;
    background-color: #69de21;
}
.caiwu .subbmit:hover{
    color: rgba(138, 143, 255, 0.4);
}


.caiwu .error_msg{
    float: left;
    margin-left: 40vw;
    font-size: 20px;
    color: red;
}
</style>