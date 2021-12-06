const { gql } = require('apollo-server');
const planesTypeDefs = gql `
    type Planes {
        codigoPlan: String!
        plan_title: String!
        plan_region: String!
        plan_city: String
        plan_address: String!
        plan_category: String!
        valorPlan: Int!
        plan_host_id: Int!
        plan_host_name: String!
        plan_start_date: String!
        plan_end_date: String!
        plan_image_path: String!
        plan_description: String!
        plan_requirements: String!
        plan_availability: Boolean!

    }
    extend type Query {
        planesById(codigoPlan: String!): Planes
    }
`;
module.exports = planesTypeDefs;