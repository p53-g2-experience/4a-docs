<template>
  <div id="Experiencias">
    
    <div class="slide"></div>
    <div class="contenedor_planes">
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
                <button v-on:Click="selectPet" type="submit" class="buscarPlan" id="buscarPlan"><b>Buscar</b></button> 
                </div>                
      

        
               
        <div id="planes" v-for="item in items" v-bind:key="item.id" class="target">
            <button class="btn-adoptar" v-on:click="loadTransaction">
                <div class="colum1pets">
            <img :src="item.plan_image_path"/>
            </div>
            <div class="colum2pets">
                <div class="nombreypuntuacion">
            <div class="nombre"><p>{{item.plan_title}}</p></div>
            <div class="puntuacion_home">
                <img src="../assets/estrella.png" style="width:25px; height:25px" alt="puntuacion">
                <p>{{item.plan_estrellas}}</p></div>
                </div>
            <div class="info"><p>{{item.plan_description}}  </p></div>
            
            <div class="costo"><b><p>{{item.valor_plan}}</p></b></div>
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
import gql from "graphql-tag";

export default {
  name: "Experiencias",

data: function () {
    return {
items: [
      { id: 1,
        plan_title: 'Experiencia Cafetera en la Tarde',
        plan_region: 'Andina',
        plan_category: 'Gatronomica',
        valor_plan: 70000,
        plan_image_path: "https://i.postimg.cc/BZVrq0p8/34aefd12-45c0-42e4-af2c-81b5a65ced81-1.jpg",
        plan_description: 'Esta una experiencia enriquecedora en la cual vas a aprender a hacer tinto campesino y veras las formas tracionales para filtrarlo. Es de lo mejor no te lo pierdas.',
        plan_host_name:'Juan Salgado',
        plan_estrellas: 5

      },
       { id: 2,
        plan_title: 'Experiencia De Chocolatera Campesina',
        plan_region: 'Andina',
        plan_category: 'Gatronomica',
        valor_plan: 7120000,
        plan_image_path: 'https://i.postimg.cc/QM7Q4q56/chcolate.jpg',
        plan_description: 'Esta experiencia te da la oportunidad de consumir algo nuevo para tu paladar chocolate con gran contenido de cacao tradicional campesino. arriesgate a probar algo nuevo.',
        plan_host_name:'Andres salderriaga',
        plan_estrellas: 4

      },
       { id: 3,
        plan_title: 'Hacia la basilica de Monserrate',
        plan_region: 'Andina',
        plan_category: 'Turistica',
        valor_plan: 120000,
        plan_image_path: 'https://i.postimg.cc/9XPYG1t1/monserrate.jpg',
        plan_description: 'Date la oportunidad de realizar un tour a las alturas, El santuario de monserate en su recorrido encontrarastiendas locales con artesanias y gastronomia.',
        plan_host_name:'Juan Salgado',
        plan_estrellas: 3

      },
        { id: 4,
        plan_title: 'Revela tradiciones y cocteleria artesanal',
        plan_region: 'Andina',
        plan_category: 'Turistica',
        valor_plan: 150000,
        plan_image_path: 'https://i.postimg.cc/mDbRDBY7/coctel.jpg',
        plan_description: 'Retate a probar productos cocteleros artesanales en lugares que representan la cultura colombiana',
        plan_host_name:'Juan Salgado',
        plan_estrellas: 5

      },
        { id: 5,
        plan_title: 'Glaping en la naturaleza Boyaca',
        plan_region: 'Andina',
        plan_category: 'Turistica',
        valor_plan: 250000,
        plan_image_path: 'https://i.postimg.cc/25DThJLk/Glaping.jpg',
        plan_description: 'Ven date la experiencia de vivir en la ruralidad, rodeado de naturaleza con gran diversidad de plantas que explorar.',
        plan_host_name:'Juan Salgado',
        plan_estrellas: 4

      },
        { id: 6,
        plan_title: 'Conociendo los Andes desde un caballo colombiano',
        plan_region: 'Andina',
        plan_category: 'Turistica',
        valor_plan: 350000,
        plan_image_path: 'https://i.postimg.cc/VLjJdLMV/caballo.jpg',
        plan_description: 'Aprender a montar caballo.  mientras, exploras las montañas de los andes en un majestuoso caballo Colombiano.',
        plan_host_name:'Juan Salgado',
        plan_estrellas: 5

      },
        { id: 7,
        plan_title: 'Recorrido en cuatrimoto',
        plan_region: 'Caribe',
        plan_category: 'Turistica',
        valor_plan: 400000,
        plan_image_path: 'https://i.postimg.cc/6qKNSw38/cuatrimoto.jpg',
        plan_description: 'Viaja en una poderosa cuatrimoto por las montañas para conocer las zonas del caribe y su naturaleza',
        plan_host_name:'Juan Salgado',
        plan_estrellas: 2

      },
        { id: 8,
        plan_title: 'Tour privado Yate',
        plan_region: 'Pacifico',
        plan_category: 'Turistica',
        valor_plan: 450000,
        plan_image_path: 'https://i.postimg.cc/wxnW9Fck/yate.jpg',
        plan_description: 'Atraviesa  los mares con un yate con una vista en al oceano y la playa',
        plan_host_name:'Juan Salgado',
        plan_estrellas: 3

      },
    ]
    }},

    methods: {
      loadTransaction: function(id){                
                localStorage.setItem('item',id)
                this.$emit('loadTransaction')
            },
    },

/*   data: function () {
    return {
      codigoPlan: localStorage.getItem("username") || "none",
      planesById: {
        codigoPlan: "",
        authorPlan: "",
        plan_title: "",
        plan_region: "",
        plan_city: "",
        plan_address: "",
        plan_category: "",
        valorPlan: "",
        plan_start_date: "",
        plan_end_date: "",
        plan_image_path: "",
        plan_image2_path: "",
        plan_description: "",
        plan_requirements: "",
        plan_availability: "",
      },
    };
  },

  apollo: {
    planesById: {
      query: gql`
        query PlanesById($codigoPlan: String!) {
          planesById(codigoPlan: $codigoPlan) {
            codigoPlan
            authorPlan
            plan_title
            plan_region
            plan_city
            plan_address
            plan_category
            valorPlan
            plan_start_date
            plan_end_date
            plan_image_path
            plan_image2_path
            plan_description
            plan_requirements
            plan_availability
          }
        }
      `,
      variables() {
        return {
          codigoPlan: this.codigoPlan,
        };
      },
    },

    userDetailById: {
      query: gql`
        query UserDetailById($userId: Int!) {
            userDetailById(userId: $userId) {
              id
              username
              password
              name
              email
              telefono
            }
          }
      `,
      variables() {
        return {
          username: this.username,
        };
      },
    },
  },

  loadSolicitud: function (codigoPlan) {
    localStorage.setItem("plan", codigoPlan);
    this.$emit("loadSolicitud");
  },

  created: function () {
    this.$apollo.queries.planesById.refetch();
    this.$apollo.queries.comentariosByUsername.refetch();
  },
}; */
};


</script>


<style>

.contenedor_planes{
  width: 80%;
  margin: auto;
}


.formularioFilt label{
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
   
}

#Experiencias  .formularioFilt p{
    width: 100%;
    display: flex;
    flex-direction: row;
    
}

#Experiencias .formularioFilt input{
    display: inline-block;
position: relative;
top: 5px;
border: 2px solid #ccc;
width: 18px;
height: 18px;
background: #fff;
}


#Experiencias .formularioBusqueda{
    width: 100%;
 display: flex;
    justify-content: space-around;
    margin: auto;
}
#Experiencias .buscarPlan{
  
cursor: pointer;    
        background-color:#c50808;
        width: 50%;
        padding: 8px;

        bottom: 15px;
   border-radius: 5px;
   border-style: none;
    
   
}

#Experiencias .buscarPlan b {
text-decoration: none;
        color: white;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 20px;
        font-weight: 700;
}
#Experiencias .botonbuscar{
   
    width: 80%;
    margin-left: 30%;
    margin-top: 10px;
    margin-bottom: 10px;

}



.slide {
  background-image: url(../assets/banner.jpg);
  background-position: center;
  background-size: cover;
  height: 400px;
  margin-top: -50px;
}
 ul {
  display: flex;
}
.container {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-around;
  margin: auto;
  width: 80%;
  padding-bottom: 100px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

h1 {
  width: 100%;
  color: #e73b3b;
  text-align: center;
  margin-top: 50px;
}
.target {
  display: flex;
  width: 45%;
height:180px;
 
   margin: 10px;
  padding: 10px; 
  border-radius: 3px;
  flex-direction: row;
  float: left;
  -webkit-box-shadow: 8px 8px 15px -17px rgba(0, 0, 0, 0.65);
  -moz-box-shadow: 8px 8px 15px -17px rgba(0, 0, 0, 0.65);
  box-shadow: 8px 8px 15px -17px rgba(0, 0, 0, 0.65);
  position: relative; 
  
}
.colum1pets {
  width: 30%;
  margin-left: 5px;
  margin-right: 25px;
}
.colum2pets {
  width: 70%;
  text-align: left;
  margin-right: 10px;
}
.nombreypuntuacion {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  height: 60px;
  align-items: flex-start;
}
.target img {
  width: 100%;
  float: left;
}

.nombre {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 20px;
  color: #202020;
  margin-top: 0px; 
  padding: 0;
}
.nombre p {
  padding-top: 0px;
  margin-top: 0px;
 
}
.puntuacion_home {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: flex-start;
  background-color: rgb(255, 217, 0);
  height: 30px;
  margin-top: 0px;
  padding-left: 15px;
  padding-right: 15px;
  border-radius: 5px;
  margin-top: -3px;
}
.puntuacion_home p {
  color: white;
  padding-top: 0px;
  margin-top: -2px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  padding-left: 5px;
}
.info {
  color: #606060;
  padding: 0;
  margin-top: -10px;
}
.costo {
  color: #606060;
  padding: 0;
  text-align: right;
  font-size: 20px;
}
.btn-adoptar {
 
  border-style: none;
  display: flex;

  flex-direction: row;
}
.decorate {
  display: flex;
  align-content: flex-end;
  width: 100%;
  height: 5px;
  background-color: #00a3fe;
  margin-bottom: 0px;
}
.target button:hover {

  cursor: pointer;
} 
.banner {
  border: none;
  width: 100%;
  background-color: white;
}
.banner1 {
  width: 100%;
  height: 300px;
  background-color: #b81010;
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-around;
  margin-bottom: 50px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  cursor: pointer;
}
.col1 {
  width: 50%;
  color: #ffffff;
  font-size: 20px;
  text-align: center;
  padding-top: 50px;
}
.col1 p {
  padding-left: 50px;
  padding-right: 50px;
}
.banner1 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/Gastronomía-1.jpg);
  background-size: cover;
}
.banner2 {
  width: 100%;
  height: 300px;
  background-color: #262626;
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-around;
  margin-bottom: 50px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  cursor: pointer;
}
.banner2 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/excursionista.jpg);
  background-size: cover;
}
.banner3 {
  width: 100%;
  height: 300px;
  background-color: #0079d0;
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-around;
  margin-bottom: 50px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  cursor: pointer;
}
.banner3 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/imagesart.jpg);
  background-size: cover;
} 
</style>