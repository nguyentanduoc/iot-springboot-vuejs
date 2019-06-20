import {initCreate, createSensor, getSensorOfUser} from '../../api/sensorApi';
import MUTATION_TYPE from '../../common/mutationType';

const {INIT_CREATE_SUCCESS, GET_SENSOR_OF_USER_SUCCESS} = MUTATION_TYPE.SENSOR_MUTATION_TYPE;
const {ERROR_HAS_ERROR, ACTION_SUCCESS} = MUTATION_TYPE.ALERT_MUTATION_TYPE;

export default {
  state: {
    accountsSensorSelection: [],
    typeSensorSelection: [],
    sensors: []
  },
  mutations: {
    [INIT_CREATE_SUCCESS](state, payload) {
      state.accountsSensorSelection = payload && payload.accounts ? payload.accounts : [];
      state.typeSensorSelection = payload && payload.typeSensors ? payload.typeSensors : [];
    },
    [GET_SENSOR_OF_USER_SUCCESS](state, payload) {
      state.sensors = payload;
    }
  },
  actions: {
    initCreateSensor({commit}, payload) {
      const {componentName} = payload;
      initCreate()
        .then(data => {
          commit(INIT_CREATE_SUCCESS, data);
        })
        .catch(err => {
          commit(ERROR_HAS_ERROR, {
            alertContent: err,
            componentName
          });
        });
    },
    createSensor({commit}, payload) {
      const {data, componentName} = payload;
      createSensor(data)
        .then(() => {
          commit(ACTION_SUCCESS, {
            alertContent: "Create success!",
            componentName
          })
        })
        .catch((err) => {
          commit(ERROR_HAS_ERROR, {
            alertContent: err,
            componentName
          });
        });
    },
    getSensorOfUser({commit}, payload) {
      const {data, componentName} = payload;
      getSensorOfUser(data)
        .then(response => {
          commit(GET_SENSOR_OF_USER_SUCCESS, response);
        })
        .catch(err => {
          commit(ERROR_HAS_ERROR, {
            alertContent: err,
            componentName
          });
        })
    }
  },
  getters: {
    accountsSensorSelection: state => state.accountsSensorSelection,
    typeSensorSelection: state => state.typeSensorSelection,
    sensors: state => state.sensors
  }
}