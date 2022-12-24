<template>
    <div class="dinghuodan">
        <div class="delivery_time item">{{delivery_time}}</div>
        <div class="goods_name item">{{goods_name}}</div>
        <div class="quantity item">{{quantity}}</div>
        <div class="unit item">{{unit}}</div>
        <div class="deadline item">{{deadline}}</div>
        <div class="state item">{{state}}</div>
    </div>
</template>

<script>

export default{

    props:['goods_name','delivery_time','quantity','unit','buyer','deadline', 'state', 'caigou_id'],

    setup(){

        return{

        }

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

.dinghuodan .delivery_time{
    margin-left: 2vw;
    font-size: 15px;
}

.dinghuodan .deadline{
    font-size: 15px;
}

.dinghuodan .state{
    cursor: pointer;
}

.dinghuodan .state:hover{
    background-color: rgba(37, 252, 177, 0.4);
}

</style>