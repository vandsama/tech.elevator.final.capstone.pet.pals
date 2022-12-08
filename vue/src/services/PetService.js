import axios from "axios";



export default {

    register(pet) {
        return axios.post('/pets/register', pet)
    },

    get(id) {
        return axios.get(`/pets/${id}`)
    },
    list() {
        return axios.get(`/pets/`)
    }

}