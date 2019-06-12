import Axios from 'axios';

export const instance = Axios.create({
  baseURL: 'http://localhost:8080/api/',
  timeout: 1000,
});

export const setJwt = (jwt) => {
  instance.defaults.headers.common['Authorization'] = `Bearer ${jwt}`;
};

export const deleteJwt = () => {
  delete instance.defaults.headers.common.Authorization;
};