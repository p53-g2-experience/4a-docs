<template>
<div class="contenedor-global-log">
  <div class="container_logIn_user">
    <div class="logIn_user">
    
      <h2>Iniciar sesión</h2>

      <form v-on:submit.prevent="processLogInUser">
        <label for="usuario">Usuario</label>
        <input type="text" v-model="user.username" placeholder="Usuario" />
        <br />
        <label for="contraseña">Contraseña</label>
        <input
          type="password"
          v-model="user.password"
          placeholder="Contraseña"
        />
        <br />
        <button type="submit"  class="ingresar">Iniciar Sesión</button>
      </form>
    </div>
  </div>
</div>
</template>


<script>
import gql from "graphql-tag";

export default {
  name: "LogIn",

  data: function () {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },

  methods: {
    processLogInUser: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($credentials: CredentialsInput!) {
              logIn(credentials: $credentials) {
                refresh
                access
              }
            }
          `,
          variables: {
            credentials: this.user,
          },
        })
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.logIn.access,
            token_refresh: result.data.logIn.refresh,
          };

          this.$emit("completedLogIn", dataLogIn);
        })
        .catch((error) => {
          alert("ERROR 401: Credenciales Incorrectas.");
        });
    },
  },
};
</script>


<style>
  .logIn_user {
  margin: 0;
  padding: 0%;
  height: 100%;
  width: 90%;
  margin: auto;

} 



.logIn_user h2 {
  color: #0068d6;
  text-align: center;
}


.logIn_user button:hover {
  color: #e5e7e9;
  background: rgb(20, 113, 220);
  border: 1px solid #283747;
} 



.contenedor-global-log{
    background-image: url(../assets/Fondo_registro.jpg);
    margin-top: -50px;
    background-size: cover;
    height: 100vh;
    padding-bottom: 100px;
    padding-top: 100px;
    display: flex;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    justify-content: flex-start;
    
}
.container_logIn_user{
    background-color: white;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 500px;
    height: 350px;
   /*  margin-top: 100px; */
    margin-left: 400px;
    border-radius: 10px;
    padding-top: -50px;
    position:absolute;
}
.container_logIn_user h2{
    padding: 5px;
}
.container_logIn_user label{
    font-size: 18px;  
    display: flex;
    flex-direction: column;
    padding-top: 15px;
    width: 100%;
}

.container_logIn_user input{
    width: 100%;
    height: 20px;
}

.ingresar{
    cursor: pointer;    
    background-color:rgb(39, 39, 39);
    width: 80%;
    padding: 8px;
    margin-top: 30px;
    margin-left: 10%;
    bottom: 15px;
    border-radius: 5px;
    border-style: none;
}

 .ingresar {
    text-decoration: none;
    color: white;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 20px;
    font-weight: 700;
} 


</style>