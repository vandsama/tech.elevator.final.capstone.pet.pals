import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  get(id) {
    return http.get(`/topics/${id}`);
  },

  create(message,id) {
    return http.post(`/topics/${id}/create`, message);
  },

  update(id, message) {
    return http.put(`/messages/${id}`, message);
  },

  delete(id) {
    return http.delete(`/messages/${id}`);
  }

}