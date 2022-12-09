import axios from 'axios';

export default {

  list() {
    return axios.get('/topics');
  },

  get(id) {
    return axios.get(`/topics/${id}`);
  },

  create(topic) {
    return axios.post(`/topics/`, topic);
  },

  update(id, topic) {
    return axios.put(`/topics/${id}`, topic);
  },

  delete(id) {
    return axios.delete(`/topics/${id}`);
  }

}
