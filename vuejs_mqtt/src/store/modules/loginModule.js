import {login} from '../../api/userApi';
import {setJwt, deleteJwt} from '../../api/axoisConfig';
import MUTATION_TYPE from '../../common/mutationType';

const {LOADING_MUTATION_TYPE, ALERT_MUTATION_TYPE, LOGIN_MUTATION_TYPE} = MUTATION_TYPE;
export default {
  state: {
    jwt: '',
    userDTO: {
      id: '',
      name: '',
      email: '',
      username: '',
      roles: [],
      menuDTOS: []
    },
    isLogin: false
  },
  mutations: {
    [LOGIN_MUTATION_TYPE.LOGIN_SUCCESS](state, payload) {
      const {userDTO, jwt} = payload;
      setJwt(jwt);
      state.userDTO = userDTO;
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
          commit(ALERT_MUTATION_TYPE.ERROR_RESET);
        })
        .catch((error) => {
          commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, error);
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
    },
    getMenu(state) {
      if (state.userDTO && state.userDTO.menuDTOS && state.userDTO.menuDTOS.length > 0) {
        return state.userDTO.menuDTOS;
      } else {
        return null;
      }
    }
  }
}