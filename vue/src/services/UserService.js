import axios from 'axios';

export default {
    
get(id) {
    return axios.get(`/users/${id}`)
},

getPets(id) {
    return axios.get(`/users/${id}/pets`)
}

}