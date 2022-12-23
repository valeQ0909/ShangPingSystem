<template>
    <div class="bill">
        <img v-bind:src="imgStr" alt="单据详情">
    </div>
</template>
<script>
export default{

    setup(){
        let imgStr = localStorage.getItem("imgStr");
        console.log(imgStr)
        return{
            imgStr
        }

    }
}
</script>

<style scoped>
.bill{
    height: 90vh;
    width: 100%;
    background-color: rgba(118,234,211, 0.5);
}
.bill img{
    display: block;

    margin-left: 15vw;
    padding-top: 10vh;

    height: 65vh;
    width: 70vw;
}
</style>