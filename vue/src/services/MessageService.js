import axios from 'axios';


export default {

  get(id) {
    return axios.get(`/messages/${id}`);
  },

  create(message, id) {
    return axios.post(`/topics/${id}/create`, message);
  },

  update(id, message) {
    return axios.put(`/messages/${id}`, message);
  },

  delete(id) {
    return axios.delete(`/messages/${id}`);
  }

}