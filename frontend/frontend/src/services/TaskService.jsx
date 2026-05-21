import axios from "axios"

const API_URL = "http://localhost:8080/tasks";

export const getTasks = async () => {
    const response = await axios.get(API_URL);
    return response.data;
}