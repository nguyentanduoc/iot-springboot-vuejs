import {login, register} from '../../api/userApi';

export default {
  state: {
    isLogin: false,
    user: null,
    isErrored: false,
    errorMessage: '',
    loading: false,
    createSuccess: false
  },
  mutations: {
    createSuccess(state) {
      state.isLogin = false;
      state.loading = false;
      state.createSuccess = true;
    },
    setUser(state, payload) {
      state.user = payload;
      state.isLogin = true;
      state.loading = false;
    },
    setErrored(state, payload) {
      state.isErrored = true;
      state.errorMessage = payload;
      state.loading = false;
    },
    setLoading(state, payload) {
      state.loading = payload;
    }
  },
  actions: {
    register({commit}, user) {
      commit('setLoading', true);
      register(user)
        .then(() => {
          commit('createSuccess');
        })
        .catch((err) => {
          if (err.response && err.response.data && err.response.data.message) {
            commit('setErrored', err.response.data.message);
          } else {
            commit('setErrored', err.message);
          }
        });
    },
  },
  getters: {
    getIsLogin(state) {
      return state.loading
    },
    getCreateSuccess(state) {
      return state.createSuccess
    },
    getMessageError(state) {
      return state.errorMessage;
    },
    getIsErrored(state) {
      return state.isErrored;
    }
  }
}