const reservasResolver = require('./reservas_resolver');
const authResolver = require('./auth_resolver');
const lodash = require('lodash');
const resolvers = lodash.merge(reservasResolver, authResolver);
module.exports = resolvers;