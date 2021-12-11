const planesResolver = require('./planes_resolver');
const comentariosResolver = require('./comentarios_resolver');
const reservasResolver = require('./reservas_resolver');
const authResolver = require('./auth_resolver');

const lodash = require('lodash');

const resolvers = lodash.merge(reservasResolver, planesResolver, comentariosResolver, authResolver);

module.exports = resolvers;