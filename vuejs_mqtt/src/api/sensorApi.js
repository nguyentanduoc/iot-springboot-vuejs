import {instance} from './axoisConfig';

export function initCreate() {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.get("/sensor/init-create");
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  });
}

export function createSensor(data) {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.post("/sensor/save", data);
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  })
}

export function getSensorOfUser(request) {
  return new Promise(async (resolve, reject) => {
    try {
      let params = {
        page: request && request.page ? request.page : 0,
        userId: request && request.userId ? request.userId : null,
      };
      const response = await instance.get("/sensor/sensor-of-user", {params});
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  })
}