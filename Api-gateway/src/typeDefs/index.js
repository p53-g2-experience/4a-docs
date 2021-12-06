//Se llama al typedef (esquema) de cada submodulo
const authTypeDefs = require('./auth_type_defs');
const planesTypeDefs = require('./planes_type_defs');
const comentariosTypeDefs = require('./comentarios_type_defs');
const reservasTypeDefs = require('./reservas_type_defs');

//Se unen
const schemasArrays = [authTypeDefs, planesTypeDefs, comentariosTypeDefs, reservasTypeDefs];
//Se exportan
module.exports = schemasArrays;