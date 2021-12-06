const { gql } = require('apollo-server');
const comentariosTypeDefs = gql `
    type Comentarios {
        username: String!
        codigoPlan: String!
        calificacion: Int!
        opinion: String!
    }
    extend type Query {
        comentariosByUsername(username: String!): Comentarios
    }
`;
module.exports = comentariosTypeDefs;