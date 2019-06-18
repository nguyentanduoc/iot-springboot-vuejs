import {instance} from './axoisConfig';

export const getRole = () => {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await instance.get('/role/get');
      return resolve(response.data);
    } catch (e) {
      return reject(e);
    }
  })
};