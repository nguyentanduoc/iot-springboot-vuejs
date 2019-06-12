import LOADING_MUTATION_TYPE from '../../common/mutationType/loadingMutationType';

const {IS_LOADING, STOP_LOADING} = LOADING_MUTATION_TYPE;
export default {
  state: {
    isLoading: false,
  },
  actions: {},
  mutations: {
    [IS_LOADING](state) {
      state.isLoading = true;
    },
    [STOP_LOADING](state) {
      state.isLoading = false;
    }
  },
  getters: {
    getLoading(state) {
      return state.isLoading
    }
  }
}