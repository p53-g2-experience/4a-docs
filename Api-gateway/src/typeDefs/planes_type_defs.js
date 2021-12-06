const { gql } = require('apollo-server');
const planesTypeDefs = gql `
    type Planes {
        codigoPlan: String!
        plan_title: String!
        plan_region: String!
        plan_city: String
        plan_address: String!
        plan_category: String!
        valorPlan: Integer!
        plan_host_id: Integer!
        plan_host_name: String!
        plan_start_date: Date!
        plan_end_date: Date!
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