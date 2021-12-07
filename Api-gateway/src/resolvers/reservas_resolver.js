const reservasResolver = {

    Query: {
        reservasByUsername: async(_, { username }, { dataSources, userIdToken}) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
        if (username == usernameToken)
            return dataSources.planesAPI.reservasByUsername(username)
        else
            return null
        }
    },

   Mutation: {
        createReservas: async(_, { transaction }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
        if (transaction.usernameOrigin == usernameToken)
            return dataSources.accountAPI.createTransaction(transaction)
        else
            return null
            } 

            
        }
    };

    module.exports = reservasResolver;