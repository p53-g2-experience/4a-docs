const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');


class PlanesAPI extends RESTDataSource {

    constructor() {
        super();
        this.baseURL = serverConfig.planes_api_url;
    }

/* 
//>>> TABLA PLANES 

    //CREATEPLAN
    async createPlanes(codigoPlan) {
        codigoPlan = new Object(JSON.parse(JSON.stringify(codigoPlan)));
        return await this.post(`/planes/`, codigoPlan);
    }

    //GETPLAN
    async getPlanes(codigoPlan) {
        return await this.get(`/planes/${codigoPlan}/`);
    }

    //UPDATE_PLAN
    async updatePlanes(codigoPlan){
        codigoPlan = new Object(JSON.parse(JSON.stringify(codigoPlan)));
        let codigoPlan = codigoPlan.id;
        return await this.put(`/planes/${codigoPlan}/`, codigoPlan); //mejorar esto en el microservicio
    }

    //DELETE_PLAN
    async deletePlanes(codigoPlan){
        return await this.delete(`/planes/${codigoPlan}/`, codigoPlan); //mejorar esto en el microservicio
    }

//>>> TABLA COMENTARIOS

    //>>> TENER EN CUENTA COMENTARIOSBYUSERNAME

    async comentariosByUsername(codigoPlan) {
        return await this.get(`/comentarios/${codigoPlan}`);
    }
    //CREATECOMENTARIOS
    async createComentarios(codigoPlan) {
        codigoPlan = new Object(JSON.parse(JSON.stringify(codigoPlan)));
        return await this.post(`/comentarios/`, codigoPlan);
    }

    //GETCOMENTARIOS
    async getComentarios(codigoPlan) {
        return await this.get(`/comentarios/${codigoPlan}/`);
    }

    //UPDATE_COMENTARIOS
    async updateComentarios(codigoPlan){
        codigoPlan = new Object(JSON.parse(JSON.stringify(codigoPlan)));
        let codigoPlan = codigoPlan.id;
        return await this.put(`/comentarios/${codigoPlan}/`, codigoPlan); //mejorar esto en el microservicio
    }

    //DELETE_COMENTARIOS
    async deleteComentarios(codigoPlan){
        return await this.delete(`/comentarios/${codigoPlan}/`, codigoPlan); //mejorar esto en el microservicio
    }
 */

//>>> TABLA RESERVAS

    //>>> TENER EN CUENTA RESERVABYUSERNAME
    async reservasByUsername(username) {
        return await this.get(`/reservas/${username}`);
    }

    //GETRESERVAS
    async getReservas() {
        return await this.get(`/reservas/`);
    }

    //CREATERESERVAS
    async createReservas(reserva) {
        reserva = new Object(JSON.parse(JSON.stringify(reserva)));
        return await this.post(`/reservas/`, reserva);
    }

    //UPDATE_RESERVAS
    async updateReservas(reserva){
        reserva = new Object(JSON.parse(JSON.stringify(reserva)));
            let username = reserva.username;
        return await this.put(`/reservas/${username}`, reserva); //mejorar esto en el microservicio
    }

    //DELETE_RESERVAS
    async deleteReservas(reserva){
        let username = reserva.username;
        return await this.delete(`/reservas/${username}`, reserva); //mejorar esto en el microservicio
    }

}

module.exports = PlanesAPI;