const comentariosResolver = {

    Query: {
        comentariosByUsername: async(_, { usernameSend }, {dataSources, userIdToken}) => {
            usernameGet = (await dataSources.authAPI.getUser(userIdToken)).username
        if (usernameSend == usernameGet)
            return dataSources.planesAPI.comentariosByUsername(usernameSend)
        else
            return null
        }
    },

   Mutation: {

            createComentarios: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.createComentarios(reservaSend)
            else
                return null 
            } ,

            updateComentarios: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.updateComentarios(reservaSend)
            else
                return null 
            } ,

            deleteComentarios: async(_, { reservaSend }, { dataSources, userIdToken }) => {
                usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (reservaSend.username == usernameToken)
                return dataSources.planesAPI.deleteComentarios(reservaSend)
            else
                return null 
        } 
    }
};
module.exports = comentariosResolver;