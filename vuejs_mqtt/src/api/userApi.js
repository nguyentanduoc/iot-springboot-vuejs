import {instance} from './axoisConfig';

export const login = async (user) => {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.post('/auth/login', user);
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  })
};
export const register = async (user) => {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.post('/auth/register', user);
      return resolve(response.status);
    } catch (e) {
      return reject(e);
    }
  })
};