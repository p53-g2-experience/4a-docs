<template>
<div class="contenedor-global">

<div class="slide" >
          
        </div>
    
 <div class="container">
      

         <h1>¡Experiencias Imperdibles!</h1>  
               
        <div v-for="pet in allPets.slice(0,12)"  v-bind:key="pet.pet_id" class="target">
            <button class="btn-adoptar" v-on:Click="loadSolicitud(pet.pet_id)">
                <div class="colum1pets">
            <img :src="pet.pet_image"/>
            </div>
            <div class="colum2pets">
            <div class="nombre"><p>{{pet.pet_name}}</p></div>
            <div class="info"><p>{{pet.pet_age}} Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? </p></div>
            
            <div class="costo"><b><p>{{pet.pet_description}}</p></b></div>
            <div class="decorate"></div>
            </div>
            
            </button>
            
            </div>
        </div> 

        <button class="banner"> 
        <div class="banner1">
            <div class="col1">
                <h2>Experiencias  Gastronomicas</h2>
                <p>Una nueva alternativa de turismo pensada para que todos puedan vivir mas que un momento una  experiencia de vida</p>
            </div>
            <div class="col2">
                
            </div>
        </div>
        </button>

        <button class="banner"> 
        <div class="banner2">
            <div class="col2">
               
            </div>
            <div class="col1">
                 <h2>Experiencias  Naturales</h2>
                <p>Una nueva alternativa de turismo pensada para que todos puedan vivir mas que un momento una  experiencia de vida</p>
            </div>
        </div>
        </button>


      <button class="banner"> 
        <div class="banner3">
            <div class="col1">
                <h2>Experiencias Artisticas</h2>
                <p>Una nueva alternativa de turismo pensada para que todos puedan vivir mas que un momento una  experiencia de vida</p>
            </div>
            <div class="col2">
                
            </div>
        </div>
        </button> 
 
</div>
</template>

<script> 
    import axios from 'axios'

    export default {
        name: 'Home',  

        data: function(){
            return {                
                allPets:"",                               
            }
        },

        methods:{
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
            this.getAllPets();
        }
    }
</script>

<style>

.slide{
    background-image: url(../assets/banner.jpg);
    background-position: center;
    background-size: cover;
    height: 400px;
    margin-top: -50px;
}

    ul{
        display:flex;
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

    .banner{
        border: none;
        width: 100%;
        background-color: white;
    }

    .banner1{
        width: 100%;
        height: 300px;
        background-color: #B81010;
        display: flex;
         flex-wrap: wrap; 
        align-items: flex-start;
         justify-content: space-around; 
         margin-bottom: 50px;
         font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
         cursor: pointer;
    }

    .col1{
width: 50%;
color: #ffffff;
font-size: 20px;
text-align: center;
padding-top: 50px;

    }
.col1 p{
    padding-left: 50px;
    padding-right: 50px;
}

 .banner1   .col2{
width: 50%;
height: 300px;
background: url(../assets/Gastronomía-1.jpg);
background-size: cover;
    }

.banner2{
        width: 100%;
        height: 300px;
        background-color: #262626;
        display: flex;
         flex-wrap: wrap; 
        align-items: flex-start;
         justify-content: space-around; 
         margin-bottom: 50px;
         font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
         cursor: pointer;
    }

     .banner2   .col2{
width: 50%;
height: 300px;
background: url(../assets/excursionista.jpg);
background-size: cover;
    }

    .banner3{
        width: 100%;
        height: 300px;
        background-color: #0079D0;
        display: flex;
         flex-wrap: wrap; 
        align-items: flex-start;
         justify-content: space-around; 
         margin-bottom: 50px;
         font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
         cursor: pointer;
    }

     .banner3   .col2{
width: 50%;
height: 300px;
background: url(../assets/imagesart.jpg);
background-size: cover;
    }

</style>