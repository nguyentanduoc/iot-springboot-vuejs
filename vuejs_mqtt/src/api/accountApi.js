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
  return new Promise(async (resolve, reject) => {
    try {
      let params = {
        page: request && request.page ? request.page : 0
      };
      const response = await instance.get("/account/get", {params});
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  })
};
export const editAccount = (request) => {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.post("/account/edit", request);
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  })
};
export const deleteAccount = (request) => {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.post("/account/delete", request);
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  })
};