const reservasResolver = {

    Query: {
        reservasByUsername: async(_, { username }, {dataSources, userIdToken}) => {
            usernameGet = (await dataSources.authAPI.getUser(userIdToken)).username
            console.log("paso 1", username,usernameGet,userIdToken)
        if (username == usernameGet)
        {
            console.log("paso 2")
            return dataSources.planesAPI.reservasByUsername(username)
        }
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