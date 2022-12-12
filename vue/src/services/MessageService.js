import axios from 'axios';


export default {

  get(id) {
    return axios.get(`/topics/${id}`);
  },

  create(topicId, message) {
    return axios.post(`/topics/${topicId}/create`, message);
  },

  update(id, message) {
    return axios.put(`/messages/${id}`, message);
  },

  delete(id) {
    return axios.delete(`/messages/${id}`);
  }

}