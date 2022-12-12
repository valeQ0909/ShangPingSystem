import { createStore } from 'vuex'
import ModuleUser from './user'

export default createStore({
    state: {
      currentpage:"",
    },
    mutations: {
      updatecurrentpage(state, currentpage){
        state.currentpage = currentpage
      }
    },
    actions: {
    },
    modules: {
      user: ModuleUser,
    }
  })