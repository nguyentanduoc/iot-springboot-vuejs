import {register} from '../../api/userApi';
import MUTATION_TYPE from '../../common/mutationType';

const {REGISTER_MUTATION_TYPE, LOADING_MUTATION_TYPE, ALERT_MUTATION_TYPE} = MUTATION_TYPE;
export default {
  state: {
    registerCreateSuccess: false,
  },
  actions: {
    register({commit}, user) {
      if (user.password !== user.confirmPassword) {
        commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, {
          alertContent: `Passwords don't match`,
          componentName: "Register"
        });
      } else {
        commit(LOADING_MUTATION_TYPE.IS_LOADING);
        register(user)
          .then(() => {
            commit(REGISTER_MUTATION_TYPE.REGISTER_SUCCESS);
            commit(LOADING_MUTATION_TYPE.STOP_LOADING);
            commit(ALERT_MUTATION_TYPE.ERROR_RESET);
          })
          .catch((err) => {
            commit(LOADING_MUTATION_TYPE.STOP_LOADING);
            commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, {
              alertContent: err,
              componentName: "Register"
            });
          });
      }
    },
  },
  mutations: {
    [REGISTER_MUTATION_TYPE.REGISTER_SUCCESS](state) {
      state.registerCreateSuccess = true;
    },
  },
  getters: {
    getRegisterCreateSuccess(state) {
      return state.registerCreateSuccess;
    }
  }
}