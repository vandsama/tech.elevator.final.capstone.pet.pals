import axios from "axios";



export default {
    register(pet) {
        return axios.post('/pets/register',pet)
    }
}