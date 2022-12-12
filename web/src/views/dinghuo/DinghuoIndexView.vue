<template>
    <div class="allpage">
        <div class="err">订货系统。。。。。。还在施工当中</div>
    </div>
</template>

<script>
import { useRouter } from "vue-router";
import { useStore } from 'vuex';
export default{

    components: {

    },
    setup() {
        const router = useRouter();
        const store = useStore();
        const currentpage = router.currentRoute.value.name;
        store.commit("updatecurrentpage", currentpage);
        console.log(currentpage)
        console.log("store: ", store.state.currentpage)
    }
}

</script>

<style scoped>
.allpage{
    height: 60vh;
    width: 100%;
}
.allpage .err{
    font-size: 50px;
    color: white;
    margin-top: 20vh;
    margin-left: 20vw;
}

</style>