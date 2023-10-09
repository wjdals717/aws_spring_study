import axios from "axios"

const api = axios.create({              //공통된 속성들(기본적인 파리미터)을 담아줌
    baseURL: "http://localhost:8080"
});

export default api;