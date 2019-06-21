import {createTypeOfSensor} from '../../api/typeOfSensorApi';
import MUTATION_TYPES from '../../common/mutationType';

const {ACTION_SUCCESS, ERROR_HAS_ERROR} = MUTATION_TYPES.ALERT_MUTATION_TYPE;

export default {
  state: {},
  mutations: {},
  actions: {
    saveTypeOfSensor({commit}, payload) {
      const {componentName, data} = payload;
      createTypeOfSensor(data)
        .then(() => {
          commit(ACTION_SUCCESS, {
            alertContent: "Create Success!",
            componentName
          })
        })
        .catch((err) => {
          commit(ERROR_HAS_ERROR, {
            alertContent: err,
            componentName
          })
        })
    }
  },
  getters: {}
}