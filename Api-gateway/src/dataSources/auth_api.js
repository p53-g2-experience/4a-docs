const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');


class AuthAPI extends RESTDataSource {

    constructor() {
        super();
        this.baseURL = serverConfig.auth_api_url;
    }


    //CREATEUSER
    async createUser(user) {
        user = new Object(JSON.parse(JSON.stringify(user)));
        return await this.post(`/user/`, user);
    }

    //GETUSER
    async getUser(userId) {
        return await this.get(`/user/${userId}/`);
    }

    //AUTHREQUEST
    async authRequest(credentials) {
        credentials = new Object(JSON.parse(JSON.stringify(credentials)));
        return await this.post(`/login/`, credentials);
    }

    //REFRESHTOKEN
    async refreshToken(token) {
        token = new Object(JSON.parse(JSON.stringify({ refresh: token })));
        return await this.post(`/refresh/`, token);
    }

    //UPDATE_USER
    async updateUser(user){
        user = new user(JSON.parse(JSON.stringify(user)));
        let userId = user.id;
        return await this.put(`/user/update/${userId}/`, user); //mejorar esto en el microservicio
    }


    //DELETE_USER
    async deleteUser(userId){
        return await this.delete(`/user/delete/${userId}/`, user); //mejorar esto en el microservicio
    }
}

module.exports = AuthAPI;