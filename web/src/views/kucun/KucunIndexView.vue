<template>
    <div class="allpage">
        <div class="platform">
            <KuCunDan ></KuCunDan>
        </div>
    </div>
</template>

<script>
import KuCunDan from "../../components/KuCunDan.vue"
import { useRouter } from "vue-router";
import { useStore } from 'vuex';
export default{

    components: {
        KuCunDan
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

.platform{
    margin-left: 20vw;
    height: 60vh;
    width: 51vw;
    background-color: rgba(118,234,211, 0.5);
    margin-top: 10vh;
}

</style>