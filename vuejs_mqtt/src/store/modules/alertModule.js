import MUTATION_TYPE from '../../common/mutationType';

const {ERROR_MUTATION_TYPE} = MUTATION_TYPE;
const {ERROR_HAS_ERROR, ERROR_RESET} = ERROR_MUTATION_TYPE;

export default {
  state: {
    isErrored: false,
    message: '',
    color: '',
    isShow: false
  },
  actions: {
    resetErrored({commit}) {
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
      state.color = 'error';
      state.message = message;
      state.isShow = true;
    },
    [ERROR_RESET](state) {
      state.isErrored = false;
      state.message = '';
      state.isShow = false;
    }
  },
  getters: {
    getAlert(state) {
      return {
        color: state.color,
        isShow: state.isShow,
        message: state.message
      }
    }
  }
}