import { createStore } from 'vuex'
import ModuleUser from './user'

export default createStore({
    state: {
      currentpage:"",
    },
    mutations: {

    },
    actions: {
    },
    modules: {
      user: ModuleUser,
    }
  })