import {login} from '../../api/userApi';
import {setJwt, deleteJwt} from '../../api/axoisConfig';
import MUTATION_TYPE from '../../common/mutationType';

const {LOADING_MUTATION_TYPE, ERROR_MUTATION_TYPE, LOGIN_MUTATION_TYPE} = MUTATION_TYPE;
export default {
  state: {
    jwt: '',
    authentication: null,
    isLogin: false
  },
  mutations: {
    [LOGIN_MUTATION_TYPE.LOGIN_SUCCESS](state, payload) {
      const {authentication, jwt} = payload;
      setJwt(jwt);
      state.authentication = authentication;
      state.jwt = jwt;
      state.isLogin = true;
    },
    [LOGIN_MUTATION_TYPE.LOGIN_LOGOUT](state) {
      deleteJwt();
      state.jwt = '';
      state.isLogin = false;
      state.authentication = null;
    }
  },
  actions: {
    login({commit}, user) {
      commit(LOADING_MUTATION_TYPE.IS_LOADING);
      login(user)
        .then((userResponse) => {
          commit(LOGIN_MUTATION_TYPE.LOGIN_SUCCESS, userResponse);
          commit(LOADING_MUTATION_TYPE.STOP_LOADING);
          commit(ERROR_MUTATION_TYPE.ERROR_RESET);
        })
        .catch((error) => {
          commit(ERROR_MUTATION_TYPE.ERROR_HAS_ERROR, error);
          commit(LOADING_MUTATION_TYPE.STOP_LOADING);
        })
    },
    logout({commit}) {
      commit(LOGIN_MUTATION_TYPE.LOGIN_LOGOUT);
    }
  },
  getters: {
    getIsLogin(state) {
      return {
        isLogin: state.isLogin,
        jwt: state.jwt
      }
    }
  }
}