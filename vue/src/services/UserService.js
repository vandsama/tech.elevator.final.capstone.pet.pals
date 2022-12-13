import axios from 'axios';

export default {
    
get(id) {
    return axios.get(`/users/${id}`)
},

getPets(id) {
    return axios.get(`/users/${id}/pets`)
},

getMyPetsNotAttending(playdateId) {
    return axios.get(`myplaydates/${playdateId}/pets/absent`)
}

}