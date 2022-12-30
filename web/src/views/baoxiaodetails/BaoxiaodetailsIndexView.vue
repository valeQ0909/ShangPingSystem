<template>
    <div class="baoxiao">
        <div class="invoice_id item">报销单号</div>
        <div class="invoice_bill item">发票单据</div>
        <div class="state item">审核状态</div>

        <div class="caiwu_id item1" v-if="invoiceList.length === 1">{{invoiceList[0].invoice_id}}</div>
        <img  class="caiwu_bill" alt="caiwu_bill" :src="invoiceList[0].invoice_bill" @click="bill" v-if="invoiceList.length === 1">
        <div class="caiwu_state item1" v-if="invoiceList.length === 1">{{invoiceList[0].state}}</div>
        <form>
        <div id="in_billurl" class="input billurl" >
            <input v-model="billurl" placeholder="报销单据链接" type="text" />
        </div>
        <div class="input submit_pass" @click="submitpass">审核通过</div>
        <div class="input submit_unpass" @click="submitunpass">审核不通过</div>
        </form>

        <div class="error_msg">{{error_msg}}</div>
        
        <img class="reimbursement" v-if="reimbursementurl != ''" :src="reimbursementurl">

    </div>
</template>

<script>
import { useRouter } from "vue-router";
import axios from "axios";
import { ref } from "vue";
import store from "../../store";

export default{

    setup(){
        let invoiceList = ref([])
        let billurl = ref("")
        let error_msg = ref("")
        let reimbursementurl = ref("")

        const router = useRouter();
        let invoice_id = router.currentRoute.value.query.invoice_id

        const bill = () =>{
            localStorage.setItem("imgStr", invoiceList.value[0].invoice_bill);  //localStorage.setItem的增和改的写法是一摸一样的
            router.push({name: "bill_index" })
        }

        // 获取该报销任务的发票信息
        const getInvoiceInfo = () =>{
            axios({
                header:{
                    'Content-Type':'application/x-www-form-urlencoded'
                },
                method: 'POST',
                url: "http://127.0.0.1:3000/finance/getInvoiceInfo/",
                data: {
                    'invoice_id': invoice_id,
                }
                }).then(resp => {
                    invoiceList.value.push(resp.data);
                });
        }

        // 审核通过
        const submitpass = () =>{
            if(invoiceList.value[0].state === "审核合格"){
                error_msg.value = "该报销任务已审核合格"
            }
            else if(invoiceList.value[0].state === "审核不合格"){
                error_msg.value = "该报销任务已审核不合格"
            }
            else if(billurl.value === ""){
                error_msg.value = "请输入报销单据链接"
            }
            else {
                axios({
                    header:{
                        'Content-Type':'application/x-www-form-urlencoded'
                    },
                    method: 'POST',
                    url: "http://127.0.0.1:3000/finance/baoxiaoPass/",
                    data: {
                        'billurl': billurl.value,
                        'invoice_id': invoice_id,
                        'staff': store.state.user.username
                    }
                    }).then(resp => {
                        invoiceList.value.pop();
                        getInvoiceInfo(); //更新报销任务状态
                        getReimbursement(); //显示报销单据
                        console.log(resp)
                    });
            }


        }

        // 审核不通过
        const submitunpass = () =>{
            if(invoiceList.value[0].state === "审核合格"){
                error_msg.value = "该报销任务已审核合格"
            }
            else if(invoiceList.value[0].state === "审核不合格"){
                error_msg.value = "该报销任务已审核不合格"
            }
            else{
                axios({
                    header:{
                        'Content-Type':'application/x-www-form-urlencoded'
                    },
                    method: 'POST',
                    url: "http://127.0.0.1:3000/finance/baoxiaoUnpass/",
                    data: {
                        'invoice_id': invoice_id,
                    }
                    }).then(resp => {
                        invoiceList.value.pop();
                        getInvoiceInfo(); //更新报销任务状态
                        console.log(resp)
                });
            }

        }

        // 检查是否有该报销记录的报销单据
        const getReimbursement = () =>{
            axios({
                header:{
                    'Content-Type':'application/x-www-form-urlencoded'
                },
                method: 'POST',
                url: "http://127.0.0.1:3000/finance/getReimbursement/",
                data: {
                    'invoice_id': invoice_id,
                }
                }).then(resp => {
                    console.log(resp)
                    if(resp.data.code == 200){
                        reimbursementurl.value = resp.data.reimbursementUrl
                    }
                    else{
                        console.log("未接收到报销单据")
                    }
                    
                });
        }

        getInvoiceInfo();
        getReimbursement();
        return{
            error_msg,
            billurl,
            invoice_id,
            invoiceList,
            reimbursementurl,
            bill,
            getInvoiceInfo,
            submitpass,
            submitunpass,
            getReimbursement,
        }
    }
}
</script>

<style scoped>
.baoxiao{
    height: 90vh;
    width: 100%;
    background-color: rgba(118,234,211, 0.5);
}

.baoxiao .item{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 25vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}
.baoxiao .invoice_id{
    margin-left: 10vw;
    border-left: 2px;
    border-style: solid;
}


.baoxiao .item1{
    text-align:center; 
    line-height: 15vh;
    height: 15vh;
    width: 25vw;
    float: left;

    font-size: 25px;
    border-width: 0.5px;
    border-style: solid;
}
.baoxiao .caiwu_id{
    margin-left: 10vw;
    border-left: 2px;
    border-style: solid;
}
.baoxiao .caiwu_bill{
    display: block;

    cursor: pointer;
    height: 15vh;
    width: 25vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}

/*输入框*/
.baoxiao .input{
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

.baoxiao .input input{
    height: 80%;
    width: 98%;
    background-color:transparent;
    border:0;
}
.baoxiao .billurl{
    margin-left: 10vw;
    border-left: 2px;
    border-style: solid;
}

.baoxiao .input input::-webkit-input-placeholder {
    font-size: 20px;
    text-align:center; 
}

.baoxiao .submit_pass{
    cursor: pointer;
    background-color: #69de21;
}
.baoxiao .submit_pass:hover{
    color: rgba(138, 143, 255, 0.4);
}

.baoxiao .submit_unpass{
    cursor: pointer;
    background-color: #ff0303;
}
.baoxiao .submit_unpass:hover{
    background-color: rgba(232, 28, 28, 0.4);
}

.baoxiao .error_msg{
    margin-left: 40vw;
    padding-top: 30vh;
    font-size: 20px;
    color: red;
}

.baoxiao .reimbursement{
    display: block;
    height: 40vh;
    width: 60vw;

    padding-top: 10vh;
    margin-left: 20vw;
}
</style>