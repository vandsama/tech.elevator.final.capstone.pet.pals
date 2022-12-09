import axios from "axios";


export default {

    list() {
        return axios.get(`/playdates`);
    },

    get(id) {
        return axios.get(`/playdates/${id}`)
    }

}