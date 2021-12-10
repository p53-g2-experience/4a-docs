<template>
    <div>
        <div class="container">
            <h1>Vive una nueva experiencia</h1>
            <p>Selecciona una o varias de las siguientes opciones</p>
            <form action="" class="formularioBusqueda">
                <div class="formularioFilt">
                <label for="Tipo" >
                <h4> ¿Que tipo de experiencia quieres vivir?</h4>
                    <p><input type="radio" name="tipo" id="perro">Gastronomica</p> 
                    <p><input type="radio" name="tipo" id="turistica">Turistica </p>
                    <p><input type="radio" name="tipo" id="aireLibre">Al aire libre</p>
                    <p><input type="radio" name="tipo" id="turistica">Artistica</p>
                    <p><input type="radio" name="tipo" id="turistica">De aprendizaje</p>
                </label></div>
                <div class="formularioFilt">
                <label for="Region">
                <h4> ¿En que Región? </h4>
                    <p><input type="radio" name="region" id="amazonica">Amazonica</p> 
                    <p><input type="radio" name="region" id="andina">Andina</p>
                    <p><input type="radio" name="region" id="caribe">Caribe</p>
                    <p><input type="radio" name="region" id="orinoquia">Orinoquía</p>
                    <p><input type="radio" name="region" id="pacifico">Pacífico</p>
                </label></div>
                            
                
            </form> 
            <div class="botonbuscar">
                <button v-on:Click="selectPet" type="submit" class="buscarMascota" id="buscarMascota"><b>Buscar</b></button> 
                </div>                
      

        
               
        <div v-for="pet in somePets"  v-bind:key="pet.pet_id" class="target">
            <button class="btn-adoptar" v-on:Click="loadSolicitud(pet.pet_id)">
                <div class="colum1pets">
            <img :src="pet.pet_image"/>
            </div>
            <div class="colum2pets">
                <div class="nombreypuntuacion">
            <div class="nombre"><p>{{pet.pet_name}}</p></div>
            <div class="puntuacion_home">
                <img src="../assets/estrella.png" style="width:25px; height:25px" alt="puntuacion">
                <p>{{pet.pet_age}}</p></div>
                </div>
            <div class="info"><p>{{pet.pet_age}} Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? </p></div>
            
            <div class="costo"><b><p>{{pet.pet_description}}</p></b></div>
            <div class="decorate"></div>
            </div>
            
            </button>
            
            </div>
         
        </div>
    </div>
</template>

<script> 
import axios from 'axios'

    export default{
        name: 'Planes',    

    data: function(){
            return {                
                allPets:"",   
                somePets:"",                            
            }
        },

        methods:{
            getAllPets: async function(){
                await axios.get('https://backend-compatitas.herokuapp.com/pet/all', {headers: {}})
                .then((result) => {    
                let auxPets=result.data.data
                let auxList=[]
                for (var i=0;i<auxPets.length;i++){                    
                    if (auxPets[i].pet_status!="adoptado"){                                               
                        auxList.push(auxPets[i])                        
                    }
                }                               
                this.allPets=auxList;  
                this.somePets=auxList; 
                this.selectPet();                
                })
                .catch(() => {
                
                });
            },  
            
            selectPet: async function(){
                this.selectPetType()
                this.selectPetAge()
                this.selectPetSize()
            },

            selectPetType: async function(){                
                let type="" 
                this.somePets=[]
                if (document.getElementById('perro').checked){
                    type="perro"
                }
                else if (document.getElementById('gato').checked){
                    type="gato"
                }else{
                    this.somePets=this.allPets;
                    return                    
                }
                for(var i=0;i<this.allPets.length;i++){
                    if (this.allPets[i].pet_type==type){
                        this.somePets.push(this.allPets[i])
                    }
                }           
            },
            
            selectPetAge: async function(){                
                let age="";   
                let auxPets=[];             
                if (document.getElementById('cachorro').checked){
                    age="cachorro"
                }
                else if (document.getElementById('adulto').checked){
                    age="adulto"
                }else{                       
                    return                 
                }
                for(var i=0;i<this.somePets.length;i++){
                    if (this.somePets[i].pet_age==age){
                        auxPets.push(this.somePets[i])
                    }
                }        
                this.somePets=auxPets                        
            },

            selectPetSize: async function(){                
                let size="";   
                let auxPets=[];             
                if (document.getElementById('pequeño').checked){
                    size="pequeño"
                }
                else if (document.getElementById('mediano').checked){
                    size="mediano"
                }
                else if (document.getElementById('grande').checked){                       
                    size="grande"                
                }else{
                    return
                }
                for(var i=0;i<this.somePets.length;i++){
                    if (this.somePets[i].pet_size==size){
                        auxPets.push(this.somePets[i])
                    }
                }        
                this.somePets=auxPets                        
            },

            loadSolicitud: function(id){                
                localStorage.setItem('pet',id)
                this.$emit('loadSolicitud')
            },
        },
        
        created: async function(){
            this.getAllPets();
        }
    }
</script>



<style>

  .formularioFilt label{
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
   
}

  .formularioFilt p{
    width: 100%;
    display: flex;
    flex-direction: row;
    
}

.formularioFilt input{
    display: inline-block;
position: relative;
top: 5px;
border: 2px solid #ccc;
width: 18px;
height: 18px;
background: #fff;
}


.formularioBusqueda{
    width: 100%;
 display: flex;
    justify-content: space-around;
    margin: auto;
}
.buscarMascota{
  
cursor: pointer;    
        background-color:#9D84B7;
        width: 50%;
        padding: 8px;
        margin:auto;
        bottom: 15px;
   border-radius: 5px;
   border-style: none;
    
   
}

.buscarMascota b {
text-decoration: none;
        color: white;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 20px;
        font-weight: 700;
}
.botonbuscar{
   
    width: 80%;
    margin-left: 40%;
    margin-top: 10px;
    margin-bottom: 10px;

}



 .container{
        display: flex;
         flex-wrap: wrap; 
        align-items: flex-start;
         justify-content: space-around; 
        margin: auto; 
        width: 80%;
        padding-bottom: 100px ;   
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;         
    }
    
    h1{
        width: 100%;
        color: #E73B3B;
        text-align: center;
        margin-top: 50px;
        margin-bottom: 50px;
    }

    .target{
        display: flex;
        width: 45%;
        height: auto;
        margin: 10px;
        padding: 10px;
        border-radius: 3px;
        flex-direction:row;
        align-items: center;
        -webkit-box-shadow: 8px 8px 15px -17px rgba(0,0,0,0.65);
        -moz-box-shadow: 8px 8px 15px -17px rgba(0,0,0,0.65);
        box-shadow: 8px 8px 15px -17px rgba(0,0,0,0.65);
        position: relative; 
    }
    .colum1pets{
        width: 30%;
        margin-left: 5px;
        margin-right: 25px;
        
    }
    .colum2pets{
        width: 70%;
        text-align: left;
        margin-right: 10px;
        
    }
    .target img{
        width: 100% ;
        float: left;  
         
    }
  

    .nombre{
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-weight: 600;
        font-size: 25px;
        color: #202020;
        margin-top: 0px;
        padding: 0;
    }
    .nombre p {
        padding-top: 0px;
        margin-top: 0px;
    }

    .info{
        color: #606060;
        padding: 0;
        margin-top: -25px;
    }
    .costo{
        color: #606060;
        padding: 0;
        text-align: right;
        font-size: 20px;
        
    }

     .btn-adoptar{
    

       
        background: white;
        border-style: none;    
         display: flex;
        
        flex-direction:row;
        
    }
    .decorate{
        
        
        display: flex;
        align-content: flex-end;
        width: 100%;
        height: 5px;
        background-color: #00A3FE;
         margin-bottom: 0px; 
    }


    .target button:hover {
        border: 1px solid #ffffff;
        margin: -10px;
        border-radius: 3px;
        cursor: pointer;
     
    } 
</style>