<template>
    <div class="allpage">
        <div class="name item">名称</div>
        <div class="current_quantity item">现有数量</div>
        <div class="quantity_limit item">最低数量限制</div>
        <div class="purchaser item">采购人</div>
        <div class="purchase_time item">采购时间</div>
    </div>
</template>

<script>

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