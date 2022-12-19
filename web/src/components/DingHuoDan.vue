<template>
    <div class="dinghuodan">
        <div class="goods_name item">{{goods_name}}</div>
        <div class="quantity item">{{quantity}}</div>
        <div class="unit item">{{unit}}</div>
        <div class="buyer item">{{buyer}}</div>
        <div class="deadline item">{{deadline}}</div>
        <div class="state item">{{state}}</div>
    </div>
</template>

<script>
export default{
    props:['goods_name','quantity','unit','buyer','deadline', 'state'],
    setup(){

    }
}
</script>

<style scoped>
.dinghuodan{
    justify-content: center; 
    align-items: center; 
}
.dinghuodan .item{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 16vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}

.dinghuodan .goods_name{
    margin-left: 2vw;
}

.dinghuodan .deadline{
    font-size: 15px;
}

</style>