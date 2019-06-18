import {saveAccount, getAccount} from '../../api/accountApi';
import MUTATION_TYPE from '../../common/mutationType';

const {ALERT_MUTATION_TYPE, ACCOUNT_MUTATION_TYPE} = MUTATION_TYPE;
export default {
  state: {
    accounts: null,
  },
  actions: {
    saveAccount({commit}, request) {
      saveAccount(request)
        .then(() => {
          commit(ALERT_MUTATION_TYPE.ACTION_SUCCESS, "Create Account Success");
        }).catch((err) => {
        commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, err);
      })
    },
    getAccount({commit}, request) {
      getAccount(request)
        .then(data => {
          console.log(data);
          commit(ACCOUNT_MUTATION_TYPE.GET_ACCOUNT_SUCCESS, data);
        })
        .catch(err => {
          commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, err);
        });
    }
  },
  mutations: {
    [ACCOUNT_MUTATION_TYPE.GET_ACCOUNT_SUCCESS](state, payload) {
      return state.accounts = payload;
    }
  },
  getters: {
    accounts(state) {
      return state.accounts;
    }
  }
}