<template>
<div class="contenedor-global-registro">


<div class="container_formulario_registro">
        <form id="contact">
            <div class="colum2">
                <h1>Registro de clientes </h1>
                <label for="nombre">Nombre</label>
                <input type="text" v-model="newRequest.document_id">
                <label for="edad">Edad</label>
                <input type="text" v-model="newRequest.applicant_age">

                <label for="telefono">Teléfono</label>
                <input type="text" v-model="newRequest.phone">
                <label for="email">E-mail</label>
                <input type="email" v-model="newRequest.email">
            
                <label for="Username">Nombre de usuario</label>
                <input type="text" v-model="newRequest.income">
                <label for="password">contraseña</label>
               <input type="password" v-model="newRequest.reason">
            
                
                <button v-if='!requestCreated' v-on:Click="completeRequest" class="enviar_solicitud" id="enviar_solicitud">Enviar</button> 
        </div>



        </form>
            <h2 v-if='requestCreated' >Gracias por tu solicitud</h2>
            <p v-if='requestCreated' >Puedes consultar el estado de tu solicitud usando el codigo <b>{{this.code}}</b> en la sección <b> Estado solicitudes</b></p>
            <button v-if='requestCreated' class="enviar_solicitud backHome" ><router-link to="/home">Volver a Home</router-link></button> 
       </div>
    </div>

</template>

<script> 
import axios from 'axios'
    export default {
        name: 'Formulario_adopcion',  

        data: function(){
            return{  
                 allPets:"", 
                charSet:['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'],
                requestCreated:false,
                pet:"",
                code:"", 
                newRequest:{                    
	                applicant_name:"",
	                applicant_last_name:"",
	                document_id:"",
	                applicant_age:"",
	                address:"",
	                phone:"",
	                email:"",
	                income:"",
	                activity:"",
	                reason:"",
	                request_status:"pendiente",
	                pet_id:"",
	                admin_id:"1"
                }
            }
        },

        methods:{
            
            getPet: async function(){    
                let id=localStorage.getItem('pet')
                await axios.get(`https://backend-compatitas.herokuapp.com/pet/${id}`, {headers: {}})
                .then((result) => {   
                this.pet=result.data  
                this.requestCreated=false 
                console.log('Pet cathed')   
                })
                .catch(() => {
                    alert('Error');
                });                
            },

            completeRequest: function(){
                this.newRequest.pet_id=this.pet.pet_id                
                this.newRequest.request_code= this.generateCode() 
                this.sendRequest()
            },

            sendRequest: async function(){                                 
                await axios.post('https://backend-compatitas.herokuapp.com/request', this.newRequest,{headers: {}})
                .then((result) => {   
                      this.requestCreated=true       
                      console.log("Request Uploaded")         
                })
                .catch(  (error) => {
                  console.log(error.response.data)
                  alert('Existe algún error con los datos ingresados. Verifique y vuelva a intentarlo')
                });          
            },

            generateCode: function(){
                let code=""
                for(var i=0;i<6;i++){
                    var index = Math.floor((Math.random() * (this.charSet.length)))
                    code+=this.charSet[index] 
                }   
                this.code=code             
                return code               
            },


            getAllPets: async function(){
                await axios.get('https://backend-compatitas.herokuapp.com/pet/all', {headers: {}})
                .then((result) => {                                  
                let auxAllPets=result.data.data;                
                this.randomPet(auxAllPets)                
                })
                .catch(() => {
                
                });
            },

            randomPet: function(data){
                let auxAllPets=data                
                let auxDict=[];
                while(auxAllPets.length>0){                    
                    var num = Math.floor((Math.random() * (auxAllPets.length)))                     
                    auxDict.push(auxAllPets[num])                                      
                    auxAllPets.splice(num,1)                    
                }

                let auxList=[]
                for (var i=0;i<auxDict.length;i++){                    
                    if (auxDict[i].pet_status!="adoptado"){                                               
                        auxList.push(auxDict[i])                        
                    }
                }    
                console.log('Pets loaded')            
                this.allPets=auxList;
            },
            
            loadSolicitud: function(id){                
                localStorage.setItem('pet',id)
                this.$emit('loadSolicitud')
            },
            
        },
        
        created: async function(){
            this.getPet() 
            this.getAllPets();           
        }
        
        
    }
</script>

<style>

.contenedor-global-registro{
    background-image: url(../assets/Fondo_registro.jpg);
    margin-top: -50px;
    background-size: cover;
    height: 100vh;
    padding-top: 100px;
    padding-bottom: 100px;
    display: flex;
    justify-content: flex-start;
    
}

.container_formulario_registro{

    margin: auto;
    background-color: white;
    width: 40%;
    height: 500px;
    color: #606060;
    text-align: left;
    border-radius: 30px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;  
    padding-bottom: 100px;

    
}

label{
    width: 100%;
    display: flex;
    align-items: flex-start;
    padding: 7px;
    color: #606060;
}
 input{
    width: 100%;
    padding: 3px;
} 

 .colum2{
float: left;
margin-top: 10px;
padding-right: 5%;
padding-left: 5%;
width: 90%;
margin: auto;
display: flex;
flex-direction: column;

}


.colum2 textarea{
width: 100%;
height: 80px;

} 

.enviar_solicitud{
    cursor: pointer;    
    background-color:#FFC700;
    width: 100%;
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



.backHome{
    margin-left:40%;
}



.tarjeta_formulario{
    display: flex;
    width: 100%;
    height: auto;
    margin-top: 60px;

    flex-direction: column;
    align-content: flex-start;
    align-items: left;
position: relative;


}
.tarjeta_formulario img{
    width: 100%
    
}

.nombre{
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-weight: 600;
    font-size: 25px;
    color:#1f1f1f;
    margin-top: -10px;
    padding: 0;
    }

    .info{
        color: #606060;
        padding: 0;
        margin-top: -25px;
    }

</style>