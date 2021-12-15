const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');


class PlanesAPI extends RESTDataSource {

    constructor() {
        super();
        this.baseURL = serverConfig.planes_api_url;
    }


//>>> TABLA PLANES 

    //GETPLANTODOS
    async getPlanes() {
        return await this.get(`/planes/`);
    }

    //GETPLAN
    async getPlanes(codigoPlan) {
        return await this.get(`/planes/${codigoPlan}`);
    }

    //CREATEPLAN
    async createPlanes(plan) {
        plan = new Object(JSON.parse(JSON.stringify(plan)));
        return await this.post(`/planes/`, plan);
    }

    //UPDATE_PLAN
    async updatePlanes(plan){
        plan = new Object(JSON.parse(JSON.stringify(plan)));
        let codigoPlan = plan.codigoPlan;
        return await this.put(`/planes/${codigoPlan}`, plan); //mejorar esto en el microservicio
    }

    //DELETE_PLAN
    async deletePlanes(codigoPlan){
        return await this.delete(`/planes/${codigoPlan}`); //mejorar esto en el microservicio
    }

//>>> TABLA COMENTARIOS

    //>>> TENER EN CUENTA COMENTARIOSBYUSERNAME

    //GETCOMENTARIOSTODOS
    async getComentarios() {
        return await this.get(`/comentarios/`);
    }

    async comentariosByUsername(username) {
        return await this.get(`/comentarios/${username}`);
    }

    //CREATECOMENTARIOS
    async createComentarios(comentario) {
        comentario = new Object(JSON.parse(JSON.stringify(comentario)));
        return await this.post(`/comentarios/`, comentario);
    }

    //UPDATE_COMENTARIOS
    async updateComentarios(comentario){
        comentario = new Object(JSON.parse(JSON.stringify(comentario)));
        let username = comentario.username;
        return await this.put(`/comentarios/${username}`, comentario); //mejorar esto en el microservicio
    }

    //DELETE_COMENTARIOS
    async deleteComentarios(username){
        return await this.delete(`/comentarios/${username}`); //mejorar esto en el microservicio
    }
 

//>>> TABLA RESERVAS

    //GETRESERVAS
    async getReservas() {
        return await this.get(`/reservas/`);
    }
    //>>> TENER EN CUENTA RESERVABYUSERNAME
    async reservasByUsername(username) {
        let primerReserva=await this.get(`/reservas/${username}`);
        console.log ("Paso 3 DS: ", primerReserva)
        return primerReserva
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
    async deleteReservas(username){
        return await this.delete(`/reservas/${username}`); //mejorar esto en el microservicio
    }
}

module.exports = PlanesAPI;