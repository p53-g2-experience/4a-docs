const planesResolver = {
/* 
    Query: {
        planesByUsername: async(_, { usernameSend }, {dataSources, userIdToken}) => {
            usernameGet = (await dataSources.authAPI.getUser(userIdToken)).username
        if (usernameSend == usernameGet)
            return dataSources.planesAPI.planesByUsername(usernameSend)
        else
            return null
        }
    }, */

   Mutation: {

            createPlanes: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.createPlanes(reservaSend)
            else
                return null 
            } ,

            updatePlanes: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.updatePlanes(reservaSend)
            else
                return null 
            } ,

            deletePlanes: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.deletePlanes(reservaSend)
            else
                return null 
        } 
    }
};
module.exports = planesResolver;