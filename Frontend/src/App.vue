<template>
  <div class='main' id="main">

    <!-- <div class='header' id='header'>
      <img src="./assets/banner.jpg" alt="life experiences" srcset="">
      
        <button v-if="!isAuth" v-on:Click="loadLogin">Iniciar sesión</button>
        <button v-if="isAuth" v-on:Click="endSesion">Cerrar sesión</button>
      
    </div>  -->
<!--  -->
    <div v-if="!isAuth" class="menu">
      <ul>        
        <li><router-link to="/home">Home</router-link></li>
        <li><router-link to="/planes">Planes</router-link></li>
        <li><router-link to="/mision">Misión</router-link></li>
        <!-- <li><router-link to="/donaciones">Donaciones</router-link></li> -->
        <li ><router-link to="/registro">Registro</router-link></li>
        <li><div class="headerbot">
    <button v-if="!isAuth" v-on:Click="loadLogin"><img src="../src/assets/login.png" style="width:30px" alt="Iniciar sesión"></button>
        <button v-if="isAuth" v-on:Click="endSesion">Cerrar sesión</button>
</div></li>
      </ul>
    </div>  
    
    <router-view 
      v-on:endSesion="endSesion"
      v-on:loadAdministrador="loadAdministrador"
      v-on:loadSolicitud="loadSolicitud"
      v-on:loadHome="loadHome"      
    >
    </router-view>  
    
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
  
  name: 'App',

  data: function(){
    return{
      isAuth: false,            
    }
  },

  components:{
  },

  methods:{

    verify: function(data){      
      this.isAuth= data.value              
    },

    loadLogin: function(){          
      this.$router.push({name:'Login'})
    },

    endSesion: function(){
      let a={value:false}     
      this.$router.push({name:'root'})    
      this.verify(a)
    },

    loadHome: function(){
      this.$router.push({name: 'Home'})
    },

    loadAdministrador: function(){
      let a={value:true}  
      this.$router.push({name: 'Administrador'})
      this.verify(a)
    },

    loadSolicitud: function(){       
      this.$router.push({name: 'Formulario_adopcion'})
    },

    completedLogin: function(){
      console.log("completedLogin")
    },



  }
  
}

</script>


<style>

  body{
    margin: 0;
    padding: 0;
    width: 100%;   
  }

  

  .headerbot button{
   
    cursor: pointer;
    background-color: #262626 ;
    border: none;
    border-radius: 10px ;
    width: 20px;
    text-decoration: none;
    color: white;
  }

  .headerbot button:hover {
    color: #B2F9FC;
    font-weight: 600;
  }

  
.footer{
  width: 100%;
  height: 120px;
  margin: 0;
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

ul {
  display: flex;
  list-style-type: none;
  width: 98%;
  margin: auto;
  margin-bottom: 40px;
  justify-content: space-around;
  background-color:  #262626;
  padding: 15px;


}

li a{
  text-decoration: none;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: white;
  font-size: 18px;
}

li a:hover {
  color: #B2F9FC;
  font-weight: 600;
}

</style>