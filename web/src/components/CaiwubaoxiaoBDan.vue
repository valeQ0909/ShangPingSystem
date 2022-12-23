<template>
    <div class="baoxiao">
        <div class="caiwu_id item1">{{invoice_id}}</div>
        <img  class="caiwu_bill" alt="caiwu_bill" :src="invoice_bill" @click="bill">
        <div class="caiwu_state item1" @click="details">{{invoice_state}}</div>
    </div>
</template>

<script>
import { useRouter } from "vue-router";
export default{
    props:['invoice_id', "invoice_bill", 'invoice_state'],
    setup(props){

        const bill = () =>{
            localStorage.setItem("imgStr", props.invoice_bill);  //localStorage.setItem的增和改的写法是一摸一样的
            router.push({name: "bill_index" })
        }

        const router = useRouter();

        const details = () =>{
            router.push({
                name: 'baoxiaodetails_index',
                query:{
                    invoice_id: props.invoice_id,
                }
            });
        }

        return{
            bill,
            details
        }
    }
}
</script>

<style scoped>
.baoxiao{
    justify-content: center; 
    align-items: center; 
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

.baoxiao .caiwu_state{
    cursor: pointer;
}

.baoxiao .caiwu_state:hover{
    background-color: rgba(37, 252, 177, 0.4);
}
</style>