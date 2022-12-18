<template>
    <div class="allpage">
        <div class="name item">{{name}}</div>
        <div class="current_quantity item">{{quantity}}</div>
        <div class="quantity_limit item">{{prize}}</div>
        <div class="purchaser item">{{qgp}}</div>
        <div class="purchase_time item">{{purchase_time}}</div>
        <div class="buyer item">{{buyer}}</div>
        <div class="supplier item">{{supplier}}</div>
        <div class="unit item">{{unit}}</div>
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
.allpage{
    justify-content: center; 
    align-items: center; 
}
.allpage .item{
    text-align:center; 
    line-height:5vh;
    font-size: 20px;
}
.allpage .name{
    margin-left: 0.3vw;

    height: 5vh;
    width: 10vw;
    float: left;
    border-width: 0.5px;
    border-style: solid;
}
.allpage .current_quantity{
    float: left;
    border-width: 0.5px;
    border-style: solid;
    border-left: 0;
    height: 5vh;
    width: 10vw;
}
.allpage .quantity_limit{
    float: left;
    border-width: 0.5px;
    border-style: solid;
    border-left: 0;
    height: 5vh;
    width: 10vw;
}

.allpage .purchaser{
    float: left;
    border-width: 0.5px;
    border-style: solid;
    border-left: 0;
    height: 5vh;
    width: 10vw;
}
.allpage .purchase_time{
    float: left;
    border-width: 0.5px;
    border-style: solid;
    border-left: 0;
    height: 5vh;
    width: 10vw;
}

</style>