const { gql } = require('apollo-server');
const reservasTypeDefs = gql `
    type Reservas {
        username                    : String!
        codigoPlan                  : String!
        cantidadIntegrantes    : Integer!
        fechaInicio                   : Date!
        fechaFin                      : Date!
        valorReserva               : Integer!
    }

    type ReservasInput {
        usernameOrigin           : String!
        usernameDestiny        : String!
        cantidadIntegrantes    : Integer!
        fechaInicio                   : Date!
        fechaFin                      : Date!
        valorReserva               : Integer!
    }

    type ReservasUpdate {
        id                                  :String!
        usernameOrigin           : String!
        usernameDestiny        : String!
        cantidadIntegrantes    : Integer!
        fechaInicio                   : Date!
        fechaFin                      : Date!
        valorReserva               : Integer!
    }

    type ReservasDelete {
        id                                  :String!
        usernameOrigin           : String!
        usernameDestiny        : String!
        cantidadIntegrantes    : Integer!
        fechaInicio                   : Date!
        fechaFin                      : Date!
        valorReserva               : Integer!
    }

    extend type Query {
        reservasByUsername(username: String!): Reservas
    }

    extend type Mutation{
        createReservas (reservas:ReservasInput!): Reservas
        updateReservas (reservas:ReservasUpdate!): Reservas
        deleteReservas (username:String!): String!
    }


`;
module.exports = reservasTypeDefs;