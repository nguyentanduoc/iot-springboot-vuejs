import {editAccount, getAccount, saveAccount, deleteAccount} from '../../api/accountApi';
import MUTATION_TYPE from '../../common/mutationType';

const {ALERT_MUTATION_TYPE, ACCOUNT_MUTATION_TYPE} = MUTATION_TYPE;
export default {
  state: {
    accounts: null,
    updateAccountSuccess: false
  },
  actions: {
    saveAccount({commit}, request) {
      saveAccount(request)
        .then(() => commit(ALERT_MUTATION_TYPE.ACTION_SUCCESS, {
          alertContent: "Create Account Success",
          componentName: "FormCreateAccount"
        }))
        .catch((err) => commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, {
          alertContent: err,
          componentName: "FormCreateAccount"
        }));
    },
    getAccount({commit}, request) {
      getAccount(request)
        .then(data => commit(ACCOUNT_MUTATION_TYPE.GET_ACCOUNT_SUCCESS, data))
        .catch(err => commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, {
          alertContent: err,
          componentName: "ListAccount"
        }));
    },
    editAccount({commit}, request) {
      editAccount(request)
        .then((user) => {
          commit(ACCOUNT_MUTATION_TYPE.UPDATE_ACCOUNT_SUCCESS, user);
          commit(ALERT_MUTATION_TYPE.ACTION_SUCCESS, {
            alertContent: "Update Success",
            componentName: "DialogEditAccount"
          });
        })
        .catch(err => commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, {
          alertContent: err,
          componentName: "DialogEditAccount"
        }));
    },
    deleteAccount({commit}, request) {
      const {componentName, item, optionAction} = request;
      deleteAccount({item, optionAction})
        .then((response) => {
          commit(ALERT_MUTATION_TYPE.ACTION_SUCCESS, {
            alertContent: "Apply action success!", componentName
          });
        })
        .catch((err) =>
          commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, {
            alertContent: err, componentName
          })
        )
    }
  },
  mutations: {
    [ACCOUNT_MUTATION_TYPE.GET_ACCOUNT_SUCCESS](state, payload) {
      return state.accounts = payload;
    },
    async [ACCOUNT_MUTATION_TYPE.UPDATE_ACCOUNT_SUCCESS](state, payload) {
      let accounts = {...state.accounts};
      const index = accounts.content.findIndex((account) => account.id === payload.id);
      accounts.content[index] = payload;
      state.accounts = null;
      state.updateAccountSuccess = true;
      setTimeout(() => {
        state.accounts = accounts;
      }, 10);
    }
  },
  getters: {
    accounts(state) {
      return state.accounts;
    }
  }
}