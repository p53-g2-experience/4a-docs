<template>
     
      
      <div class="container_admin">  
        <h1>Reservas</h1>
        <table class="solicitudes">
          <tr>

            <th>Nombre Reserva</th>
            <th># de personas</th>
            <th>Plan</th>
            <th>Fecha</th>
            <th>Teléfono</th>

          </tr>

          <tr v-for="solicitud in allRequest"  v-bind:key="solicitud.request_id">
            
            <td>{{solicitud.applicant_name + " " + solicitud.applicant_last_name}}</td>
            <td>{{solicitud.applicant_age}}</td>
            <td>{{this.getPetName(solicitud.pet_id)}}</td><td>{{this.getPetName(solicitud.pet_id)}}</td>
            <!-- <td v-on:Click="loadDetails(solicitud.request_id, solicitud.pet_id)" class="link">Ver más...</td> -->
            <td>
              {{solicitud.request_status}}
              <!--<select name="estado" >
                <option value="1" :selected="verifyState('pendiente',solicitud.request_status)" >Pendiente</option> 
                <option value="2" :selected="verifyState('aceptada',solicitud.request_status)" >Aceptada </option> 
                <option value="3" :selected="verifyState('rechazada',solicitud.request_status)" >Rechazada</option>
                <option value="3" :selected="verifyState('finalizada',solicitud.request_status)" >Finalizada</option>
              </select>-->
            </td>
          </tr>
        </table>


      <form id="contact">
        <h1>Agregar Planes</h1>
            <div class="colum_planes">
                
                <label for="codigo_plan">Código Plan</label>
                 <input type="text"> <!--v-model="newRequest.applicant_name" -->
                
                <label for="ciudad_plan">Ciudad</label>
                <input type="text"> <!-- v-model="newRequest.applicant_age" -->
            
                <label for="valor_plan">Valor Por Persona</label>
                <input type="text"  >  <!--  v-model="newRequest.address"-->

                 <label for="descripcion">Descripción</label>
                <textarea> </textarea> <!--  v-model="newRequest.address"--> 

                </div>  
                 <div class="colum_planes"> 
                
                <label for="nombre_plan">Nombre Plan</label>
                 <input type="text"> <!--v-model="newRequest.applicant_name" -->
                
                <label for="direccion_plan">Dirección</label>
                <input type="text"> <!-- v-model="newRequest.applicant_age" -->
            
                <label for="imagen_plan">Link imagen</label>
                <input type="text"  >    <!--  v-model="newRequest.address"-->

                 <label for="requerimientos">Requerimientos</label>
                <textarea> </textarea> <!--  v-model="newRequest.address"--> 

                 </div>  
                 <div class="colum_planes">
                
                <label for="region_plan">Región</label>
                 <input type="text"> <!--v-model="newRequest.applicant_name" -->
                
              <label for="categoria_plan">Categoria</label>
                <select name="categoria">

                <option>Gastronomica</option>

                <option>Turistica</option>

                <option>Artistica</option>

                <option>Aire libre</option>

                <option>De aprendizaje</option>

                </select>
              
            
                <label for="banner_plan">Link Imagen Banner</label>
                <input type="text"  >    <!--  v-model="newRequest.address"-->
            
            </div>  
            
                
                <button v-if='!requestCreated' v-on:Click="completeRequest" class="crear_plan" id="crear_plan">Crear plan</button> 
        



        </form>
            <h2 v-if='requestCreated' >Gracias por tu reservar</h2>

            <form id="contact">
        <h1>Eliminar Planes</h1>
            <div class="colum_eliminar">
                
                <label for="nombre">Código Plan</label>
                 <input type="text"> <!--v-model="newRequest.applicant_name" -->
                
            </div>
            
                
                <button v-if='!requestCreated' v-on:Click="completeRequest" class="eliminar_plan" id="eliminar_plan">Borrar plan</button> 
        



        </form>
            <h2 v-if='requestCreated' >Plan eliminado</h2>

        
      </div> 
    
</template>

<script>

import axios from 'axios'

export default {

    name: 'Administrador',

    data: function(){
      return{        
        allRequest:"",
        pets:""
      }
    },

      
    methods:{

      getAllRequest: async function(){
              await axios.get('https://backend-compatitas.herokuapp.com/request/all', {headers: {}})
              .then((result) => {                                  
                this.allRequest=result.data.data; 
                this.endState=false;
              })
              .catch(() => {
                
              });

              await this.getAllPets()
      },

      getAllPets: async function(){
              await axios.get('https://backend-compatitas.herokuapp.com/pet/all', {headers: {}})
              .then((result) => {                                  
                this.pets=result.data.data; 
              })
              .catch(() => {
                
              });
      },      

      loadDetails: function(id,pet_id){        
        localStorage.setItem('request',id)
        localStorage.setItem('pet',pet_id)        
        this.$router.push({name:"Administrador_solicitudes"})
      },

      getPetName: function(id){
        for (var i=0;i<this.pets.length;i++){
          if (id==this.pets[i].pet_id){            
            return this.pets[i].pet_name
          }
        }
      },

      verifyState: function(sender,state){
        if (sender==state){
          return true
        }else{
          return false
        }

      },      

    },
   

    created: async function(){

      this.getAllRequest();

    }

}

</script>

<style>

 .colum_planes{
float: left;
margin-top: 10px;
margin-right: 0px;
padding-left: 3%;
width: 30%;
display: flex;
flex-direction: column;

}



 .container_admin{
    display: flex;
    flex-direction: column;
    margin: auto;
    width: 80%;
    padding-bottom: 100px ;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    
}

.container_admin form textarea{
  height: 100px;
}


.crear_plan{
    cursor: pointer;    
    background-color:#FFC700;
    width: 40%;
    margin-left: 30%;
    margin-top: 30px;
    margin-bottom: 50px;
    bottom: 15px;
    border-radius: 5px;
    border-style: none;  
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
    text-decoration: none; 
        font-size: 18px;
        font-weight: 700;
}

.logout{
cursor: pointer;
font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
font-size: 20px;
width: 80px;
padding: 10px;
margin-top: 20px;
margin-left: 20px;
display: flex;
flex-direction: row;
background-color: #091353 ;
border: none;
border-radius: 10px ;
-webkit-box-shadow: 9px 10px 28px -17px rgba(0,0,0,0.75);
-moz-box-shadow: 9px 10px 28px -17px rgba(0,0,0,0.75);
box-shadow: 9px 10px 28px -17px rgba(0,0,0,0.75);
}

.logout a{
    text-decoration: none;
    color: white;
}

.logout a:hover {
  color: #B2F9FC;
  font-weight: 600;
}
table{
  border-spacing: 0;
}
th{
  border:solid 1px white;
  background-color: #272727;
  color: white;
  margin: 0;
  padding: 10px;
}
td{
  border:solid 1px #272727;
  margin: 0;
  padding: 5px;
}
td a{
  text-decoration: none;
  color:darkcyan;
}
select{
  
  border: none;
  width: 100%;
     font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    font-size: 16px;
}

.colum_eliminar{
  width: 60%;
  margin-right: 5%;
  float: left;
}

.eliminar_plan{
    cursor: pointer;    
    background-color:#FFC700;
    width: 35%;
    margin-top: 30px;
    margin-bottom: 50px;
    bottom: 15px;
    border-radius: 5px;
    border-style: none;  
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
    text-decoration: none; 
        font-size: 18px;
        font-weight: 700;
        
}

</style>