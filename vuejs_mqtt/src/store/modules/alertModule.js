import MUTATION_TYPE from '../../common/mutationType';

const {ALERT_MUTATION_TYPE} = MUTATION_TYPE;
const {ERROR_HAS_ERROR, ERROR_RESET, ACTION_SUCCESS} = ALERT_MUTATION_TYPE;

export default {
  state: {
    message: '',
    color: '',
    isShow: false,
    showOnComponent: ''
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
        if (payload.alertContent && payload.alertContent.response && payload.alertContent.response.data && payload.alertContent.response.data.message) {
          message = payload.alertContent.response.data.message
        } else {
          message = payload.alertContent.message;
        }
      }
      state.color = 'error';
      state.message = message;
      state.isShow = true;
      state.showOnComponent = payload.componentName;
    },
    [ERROR_RESET](state) {
      state.message = '';
      state.isShow = false;
    },
    [ACTION_SUCCESS](state, payload) {
      state.color = 'success';
      state.message = payload.alertContent;
      state.showOnComponent = payload.componentName;
      state.isShow = true;
      setTimeout(() => {
        state.color = 'success';
        state.message = '';
        state.isShow = false;
        state.showOnComponent = '';
      }, 2000)
    }
  },
  getters: {
    getAlert(state) {
      return {
        color: state.color,
        isShow: state.isShow,
        message: state.message,
        showOnComponent: state.showOnComponent
      }
    }
  }
}