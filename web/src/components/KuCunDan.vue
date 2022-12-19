<template>
    <div class="kucundan">
        <div class="name item">{{name}}</div>
        <div class="quantity item">{{quantity}}</div>
        <div class="price item">{{price}}</div>
        <div class="unit item">{{unit}}</div>
        <div class="qgp item">{{qgp}}</div>
        <div class="purchase_time item">{{purchase_time}}</div>
        <div class="buyer item">{{buyer}}</div>
        <div class="supplier item">{{supplier}}</div>
        <div class="describe item">{{describe}}</div>
    </div>
</template>

<script>
export default{
    props:['name','quantity', 'price', 'qgp', 'purchase_time', 'buyer', 'supplier', 'unit', 'describe'],
    setup(){

    }
}
</script>

<style scoped>
.kucundan{
    justify-content: center; 
    align-items: center; 
}
.kucundan .item{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;

    height: 5vh;
    width: 10vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}
.kucundan .name{
    margin-left: 5vw;
}
.kucundan .qgp{
    font-size: 15px;
}
.kucundan .purchase_time{
    font-size: 15px;
}
</style>