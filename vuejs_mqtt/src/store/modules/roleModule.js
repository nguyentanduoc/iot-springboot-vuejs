import {getRole} from '../../api/roleApi';
import MUTATION_TYPE from '../../common/mutationType';

const {ROLE_MUTATION_TYPE, ALERT_MUTATION_TYPE} = MUTATION_TYPE;
export default {
  state: {
    roles: []
  },
  actions: {
    getRole({commit}) {
      getRole()
        .then((data) => {
          commit(ROLE_MUTATION_TYPE.GET_ROLE_SUCCESS, data);
        }).catch((err) => {
        commit(ALERT_MUTATION_TYPE.ERROR_HAS_ERROR, err);
      });
    }
  },
  mutations: {
    [ROLE_MUTATION_TYPE.GET_ROLE_SUCCESS](state, payload) {
      state.roles = payload
    }
  },
  getters: {
    roles(state) {
      return state.roles;
    }
  }
}