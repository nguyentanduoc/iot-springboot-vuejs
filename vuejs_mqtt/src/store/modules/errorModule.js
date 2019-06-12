import MUTATION_TYPE from '../../common/mutationType';

const {ERROR_MUTATION_TYPE} = MUTATION_TYPE;
const {ERROR_HAS_ERROR, ERROR_RESET} = ERROR_MUTATION_TYPE;

export default {
  state: {
    isErrored: false,
    errorMessage: ''
  },
  actions: {
    resetErrored({commit}) {
      console.log('dadad');
      commit(ERROR_RESET);
    }
  },
  mutations: {
    [ERROR_HAS_ERROR](state, payload) {
      let message = '';
      if (typeof (payload) === 'string') {
        message = payload;
      } else {
        if (payload.response && payload.response.data && payload.response.data.message) {
          message = payload.response.data.message
        } else {
          message = payload.message;
        }
      }
      state.isErrored = true;
      state.errorMessage = message;
    },
    [ERROR_RESET](state) {
      state.isErrored = false;
      state.errorMessage = '';
    }
  },
  getters: {
    getErrored(state) {
      return {
        isErrored: state.isErrored,
        errorMessage: state.errorMessage
      }
    }
  }
}