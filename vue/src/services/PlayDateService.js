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

    listPlaydateUsers(playDateId) {
        return axios.get(`/playdates/${playDateId}/users`)
    },
    schedule(playDate) {
        return axios.post(`/playdates/schedule`, playDate)
    }

}