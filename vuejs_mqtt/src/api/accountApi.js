import {instance} from './axoisConfig';

export const saveAccount = (request) => {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.post("/account/create", request);
      return resolve(response);
    } catch (e) {
      return reject(e);
    }
  })
};
export const getAccount = (request) => {
  return new Promise(async (resovle, reject) => {
    try {
      const response = await instance.get("/account/get", request);
      return resovle(response.data);
    } catch (e) {
      return reject(e);
    }
  })
};