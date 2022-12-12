import axios from 'axios';

export default {
    
getPets(id) {
    return axios.get(`users/${id}/pets`)
}

}