import axios from "axios";


export default {

    list() {
        return axios.get(`/playdates`);
    },

    get(id) {
        return axios.get(`/playdates/${id}`)
    },

    listOwn() {
        return axios.get('/myplaydates')
    },

    listPlaydatePets(id) {
        return axios.get(`/playdates/${id}/pets`)
    },

    listPlaydateUsers(id) {
        return axios.get(`/playdates/${id}/users`)
    },

    addPets(id,petIds) {
        return axios.post(`/playdates/${id}/join`, petIds)
    },

    

}