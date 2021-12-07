<template>
    <div class="contenedor-global-log">

        <img v-on:Click="endSesion" src='../assets/close.png' alt="" class="close">
        <div class="login_admin">
            <h1>Login</h1>
            <form >
                <label for="usuario">Usuario</label>
                <input type="text" v-model="user.username">
                <label for="contraseña">Contraseña</label>
                <input type="password" v-model="user.password">
                <button v-on:Click="loadAdministrador" class="ingresar" id="ingresar">Ingresar</button> 
            </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    
    name: 'Login',

    data: function(){
        return{
            user:{
                username:"",
                password:""
            }
        }
    },

    methods:{
        loadAdministrador: async function(){            
            await axios.post('https://backend-compatitas.herokuapp.com/user/login', this.user,{headers: {}})
            .then((result) => {                                  
            let datalogin={
                    username:this.user.username,
                    token_data:result.data.access,
                    token_refresh:result.data.refresh
                }                    
                this.$emit('loadAdministrador') 
            })
            .catch((error) => {
                if (error.response.status == "401")
                    alert("ERROR 401: Credenciales Incorrectas.");               
            });           
            
        },

        endSesion: async function(){
            this.$emit('endSesion')
        },


    },
}

</script>

<style>


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
.login_admin{
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
.login_admin h1{
    padding: 5px;
}
.login_admin label{
    font-size: 18px;  
    display: flex;
    flex-direction: column;
    padding-top: 15px;
}

.login_admin input{
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

.close {    
    width: 30px;
    height: 30px;
    margin-top: -80px;
    margin-left: 30px;
    position: absolute;
    display: flex;
} </style>



