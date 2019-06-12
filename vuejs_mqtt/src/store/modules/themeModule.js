export default {
  state: {
    drawer: true
  },
  mutations: {
    toggleDrawer(state) {
      state.drawer = !state.drawer;
    }
  },
  actions: {
    toggleDrawer({commit}) {
      commit('toggleDrawer')
    }
  },
  getters: {
    drawer: state => {
      return state.drawer;
    }
  }
}