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

    listPlaydatePets(playDateId) {
        return axios.get(`/playdates/${playDateId}/pets`)
    },
    schedule(playDate) {
        return axios.post(`/playdates/schedule`, playDate)
    },
    listPlaydateUsers(id) {
        return axios.get(`/playdates/${id}/users`)
    },

    addPets(id, petIds) {
        return axios.post(`/playdates/${id}/join`, petIds)
    },



}