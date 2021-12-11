const { gql } = require('apollo-server');
const reservasTypeDefs = gql `
    type Reservas {
        idReserva                   : String!
        username                    : String!
        codigoPlan                  : String!
        cantidadIntegrantes    : Int!
        fechaInicio                   : String!
        fechaFin                      : String!
        valorReserva               : Int!
    }

    input ReservasInput {
        username                    : String!
        codigoPlan                  : String!
        cantidadIntegrantes    : Int!
        fechaInicio                   : String!
        fechaFin                      : String!
        valorReserva               : Int!
    }

    extend type Query {
        reservasByUsername(username: String!): Reservas
    }

    extend type Mutation{
        createReservas (reservas:ReservasInput!): Reservas
        updateReservas (reservas:ReservasInput!): Reservas
        deleteReservas (username:String!): String!
    }

`;
module.exports = reservasTypeDefs;