const { gql } = require('apollo-server');
const comentariosTypeDefs = gql `
    type Comentarios {
        idComentario: String!
        username: String!
        codigoPlan: String!
        calificacion: Int!
        opinion: String!
    }

    input ComentariosInput {
        username: String!
        codigoPlan: String!
        calificacion: Int!
        opinion: String!
    }

    extend type Query {
        comentariosByUsername(username: String!): Comentarios
    }

    extend type Mutation{
        createComentarios (comentarios:ComentariosInput!): Comentarios
        updateComentarios (comentarios:ComentariosInput!): Comentarios
        deleteComentarios (username:String!): String!
    }

`;
module.exports = comentariosTypeDefs;