import api from "./api";

export const registerUser = async (user) => {
    return api.post("/user", user); //axios.post() 하는 것과 동일, 기본 설정을 가져옴
};

export const getUserListAll = async () => {
    return api.get("/user/list");
}

export const updateUser = async (user) => { //put은 json만 받음!!
    return api.put(`/users/${user.userId}`, user);
}

export const deleteUser = async (userId) => {
    return api.delete(`/users/${userId}`);
}