const reservasResolver = {

    Query: {
        reservasByUsername: async(_, { usernameSend }, {dataSources, userIdToken}) => {
            usernameGet = (await dataSources.authAPI.getUser(userIdToken)).username
        if (usernameSend == usernameGet)
            return dataSources.planesAPI.reservasByUsername(usernameSend)
        else
            return null
        }
    },

   Mutation: {

            createReservas: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.createReservas(reservaSend)
            else
                return null 
            } ,

            updateReservas: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.updateReservas(reservaSend)
            else
                return null 
            } ,

            deleteReservas: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.deleteReservas(reservaSend)
            else
                return null 
        } 
    }
};
module.exports = reservasResolver;