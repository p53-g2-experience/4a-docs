<template>
  <div id="app" class="app">
    <div class="header">

      <h1>Life Experiences</h1>
      <nav>

       <!--  <button v-if="is_auth" v-on:click="loadHome">Inicio</button>
        <button v-if="is_auth" v-on:click="loadAccount">Cuenta</button>
        <button v-if="is_auth" v-on:click="loadPlanes">Planes</button>
        <button v-if="is_auth" v-on:click="loadCategorias">Categorias</button>        
        <button v-if="is_auth" v-on:click="loadTransaction">Transacción</button> -->
        <button v-if="is_auth" v-on:click="logOut">Cerrar Sesión</button>


        <button v-if="!is_auth" v-on:click="loadExperiencias">Experiencias</button>
        <button v-if="!is_auth" v-on:click="loadLogIn">Iniciar Sesión</button>
        <button v-if="!is_auth" v-on:click="loadSignUp">Registrarse</button>
      </nav>
    </div>


    <div class="main-component">
      <router-view
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
      >
      </router-view>
    </div>


    <div class="footer">
        <div class="container_footer">
          <div class="red">  
              <img src="./assets/facebook.png" alt="">              
              <h4>Facebook</h4>
          </div>
          <div class="red"> 
              <img src="./assets/instagram.png" alt="">
              <h4>Instagram</h4>                
          </div>
          <div class="red"> 
              <img src="./assets/twitter.png" alt="">
               <h4>Twitter</h4>
          </div>          
        </div>
        <p class="copy">Copyright © 2021 | MisionTic2022 </p>
    </div>


  </div>
</template>


<script>
export default {
  name: "App",

  computed: {
    is_auth: {
      get: function () {
        return this.$route.meta.requiresAuth;
      },
      set: function () {},
    },
  },

  methods: {
    loadLogIn: function () {
      this.$router.push({ name: "logIn" });
    },

    loadSignUp: function () {
      this.$router.push({ name: "signUp" });
    },

    completedLogIn: function (data) {
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      alert("Autenticación Exitosa");
      this.loadHome();
    },

    completedSignUp: function (data) {
      alert("Registro Exitoso");
      this.completedLogIn(data);
    },

    loadHome: function () {
      this.$router.push({ name: "home" });
    },

    loadAccount: function () {
      this.$router.push({ name: "account" });
    },

    loadPlanes: function () {
      this.$router.push({ name: "planes" });
    },

    loadExperiencias: function () {
      this.$router.push({ name: "experiencias" });
    },    

    loadCategorias: function () {
      this.$router.push({ name: "categorias" });
    },    

    loadTransaction: function () {
      this.$router.push({ name: "transaction"});
    },

    logOut: function () {
      localStorage.clear();
      alert("Sesión Cerrada");
      this.loadLogIn();
    },
    
  },
};
</script>


<style>


body{
    margin: 0;
    padding: 0;
    width: 100%;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;   
  }

.header {
  margin: 0%;
  padding: 0;
  width: 100%;
  height: 20vh;

  min-height: 100px;

  background-color: #222222;
  color: #e5e7e9;

  display: flex;
  justify-content: space-around;
  align-items: center;
}

.header h1 {
  width: 20%;
  text-align: center;
  margin-top: -35px;
  margin-left: 35px;
  color: white;
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.header nav {
  height: 100%;
  width: 30%;

  display: flex;
  justify-content: space-around;
  align-items: center;

  font-size: 35px;
}

.header nav button {
  color: #e5e7e9;
  background: #222222;
  border: none;

  border-radius: 5px;
  padding: 10px 20px;
  margin-top: -35px;
}

.header nav button:hover {
  color: #222222;
  background: #e5e7e9;
 
}






.footer{
  width: 100%;
  height: 120px;
  bottom: 0;
  background-color: #262626;   
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-size: 14px;
}

.container_footer{
  display: flex;
  width: 80%;
  margin: auto;
  padding-top: 20px;
  padding-bottom: 0px;
  justify-content: space-around;  
}

.copy{
  margin-left: 30px;
  color: white;
  text-align: center;
}

.red img{
  float: left;
  width: 20px;
}

.red h4{
  float: left;
  color: white;
  margin-top: 3px;
  padding-left: 10px;
  cursor: pointer;
}

/* ul {
  display: flex;
  list-style-type: none;
  width: 98%;
  margin: auto;
  margin-bottom: 40px;
  justify-content: space-around;
  background-color:  #262626;
  padding: 15px;


} */

/* li a{
  text-decoration: none;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: white;
  font-size: 18px;
}

li a:hover {
  color: #B2F9FC;
  font-weight: 600;
} */


</style>
