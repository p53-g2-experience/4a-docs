<template>
<div class="contenedor-global-registro">
 
    <div class="container_signUp_user">
      <h2>Registrarse</h2>
 <div class="signUp_user">
      <form v-on:submit.prevent="processSignUp">
        <label for="Username">Nombre de usuario</label>
        <input type="text" v-model="user.username" placeholder="Usuario" />
        <br />
        <label for="password">contraseña</label>
        <input
          type="password"
          v-model="user.password"
          placeholder="Contraseña"
        />
        <br />
        <label for="nombre">Nombre</label>
        <input type="text" v-model="user.name" placeholder="Nombre" />
        <br />
        <label for="email">E-mail</label>
        <input type="email" v-model="user.email" placeholder="Correo" />
        <br />
        <label for="telefono">Teléfono</label>
        <input
          type="text"
          v-model="user.balance"
          placeholder="Saldo Inicial"
        />
        <br />

        <button type="submit" class="registro">Registrarse</button>
      </form>
    </div>
  </div>
</div>
</template>


<script>
import gql from "graphql-tag";

export default {
  name: "SignUp",

  data: function () {
    return {
      user: {
        username: "",
        password: "",
        name: "",
        email: "",
        balance: 0,
      },
    };
  },

  methods: {
    processSignUp: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($userInput: SignUpInput!) {
              signUpUser(userInput: $userInput) {
                refresh
                access
              }
            }
          `,
          variables: {
            userInput: this.user,
          },
        })
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.signUpUser.access,
            token_refresh: result.data.signUpUser.refresh,
          };

          this.$emit("completedSignUp", dataLogIn);
        })
        .catch((error) => {
          alert("ERROR: Fallo en el registro.");
        });
    },
  },
};
</script>


<style>

 .signUp_user {
  margin: 0;
  padding: 0%;
  height: 100%;
  width: 90%;
  margin: auto;

} 



.signUp_user h2 {
  color: #0068d6;
  text-align: center;
}


.signUp_user button:hover {
  color: #e5e7e9;
  background: rgb(20, 113, 220);
  border: 1px solid #283747;
} 



.contenedor-global-registro{
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
.container_signUp_user{
    background-color: white;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 500px;
    height: 500px;
   /*  margin-top: 100px; */
    margin-left: 400px;
    border-radius: 10px;
    padding-top: -50px;
    position:absolute;
}
.container_signUp_user h2{
    padding: 5px;
}
.container_signUp_user label{
    font-size: 18px;  
    display: flex;
    flex-direction: column;
    padding-top: 15px;
    width: 100%;
}

.container_signUp_user input{
    width: 100%;
    height: 20px;
}

.registro{
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

 .registro {
    text-decoration: none;
    color: white;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 20px;
    font-weight: 700;
} 

</style>