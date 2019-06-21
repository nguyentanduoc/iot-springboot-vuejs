import {instance} from "./axoisConfig";

export function createTypeOfSensor(data) {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.post("/type-sensor/save", data);
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  });
}