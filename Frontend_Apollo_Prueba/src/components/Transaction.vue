<template>
  <div id="Transaction">
     <div id="planes" v-for="item in items.slice(0,1)" v-bind:key="item.id" class="imagen_plan"> 
     <img :src="item.plan_image_path" class="imagen" style="width:100%; height:300px" /> 
     </div>
    <!-- <div class="slide"></div> -->
    <div class="contenedor_planes">
      
                         
      

                <div class="colum1">         
               
               <div id="planes" v-for="item in items.slice(0,1)" v-bind:key="item.id" class="tarjeta_formulario">   
                <div class="nombreypuntuacion">
            <div class="nombre"><p>{{item.plan_title}}</p></div>
            <div class="puntuacion_home">
                <img src="../assets/estrella.png" style="width:25px; height:25px" alt="puntuacion">
                <p>{{item.plan_estrellas}}</p></div>
                </div>
                <div class="info"><p>{{item.plan_description}} Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? 
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? 
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? 
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? 
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? 
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? 
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur iusto ex reprehenderit architecto, sit debitis nisi? </p></div>
                
                <div class="costo"><p><b> Valor : {{item.valor_plan}}</b></p></div>  
            </div> 
               
        
                <h3>opiniones</h3>
            <form id="opinion">
               <textarea ></textarea>
               <p>En escala de 1 a 5 como calificaria su experiencia</p>
                <div class="puntaje">
                 <p><input type="radio" name="puntaje" id="1">1</p> 
                 <p><input type="radio" name="puntaje" id="2">2</p>
                 <p><input type="radio" name="puntaje" id="3">3</p> 
                 <p><input type="radio" name="puntaje" id="4">4</p>
                 <p><input type="radio" name="puntaje" id="5">5</p> 
                 </div>
                  <button  class="publicar" id="enviar_solicitud">Publicar</button>
            </form>

            <div  v-for="opinion in opiniones" v-bind:key="opinion.id" class="feed_opiniones">  
                <div class="imagen_opinion">
               <img :src="opinion.user_image_path" class="imagen" style="width:100%; border-radius:30px" />
                </div> 
                <div class="texto_opinion">
                <div class="puntuacion_home_comment">
                <img src="../assets/estrella.png" style="width:25px; height:25px" alt="puntuacion">
                <p>{{opinion.op_estrellas}}</p>
                </div>
                
                <div class="info_opinion"><p>{{opinion.opinion}} 
                    </p><hr> 
                    </div>
                    </div>
                
            </div> 
            
        </div>

       <div class="colum2">
                <form id="contact">
            
                <h1>Reservar</h1>
                <label for="nombre">Nombre</label>
                <input type="text" >
                
                <label for="personas">Catidad de integrantes</label>
                <input type="text" >
            
                <label for="fecha inicio">Fecha inicio</label>
                <input type="date" >
            
            
                
                <button class="enviar_solicitud" id="enviar_solicitud">Enviar</button> 
        



        </form>
            <!-- <h2 v-if='requestCreated' >Gracias por tu reservar</h2> -->
            
       </div>
     
    </div>
  </div>
</template>



<script>
import gql from "graphql-tag";

export default {
  name: "Transaction",

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
    ],
    opiniones: [
      { id: 1,
        
        user_image_path: "https://i.postimg.cc/rwH6RKLt/eb6591b54b2b6462b4c22ec1fc4c36ea-creador-de-avatar-femenino.jpg",
        opinion: "Me parece un plan exelebte para compartir con familia o amigos ademas que tienen un muy bien anfitrion, lo volveria a realizar",
        op_estrellas: 5,

      },
      { id: 2,
        
        user_image_path: "https://i.postimg.cc/mgywKnmZ/whatsapp-image-2020-06-19-at-5-01-04-pm.jpg",
        opinion: "El paln estuvo bien pero hubieron cosas que no me gsutaron tenia un poco mas de espectativa",
        op_estrellas: 3,

      },
      { id: 3,
        
        user_image_path: "https://i.postimg.cc/8Cybz68q/whatsapp-image-2020-06-19-at-3-43-53-pm.jpg",
        opinion: "El anfitrion es exelente muy buiena persona, en general me gusto0 el plan aunque un poco lejos de la ciudad principal",
        op_estrellas: 4,

      },
      ]
    }},

    methods: {
      loadTransaction: function(id){                
                localStorage.setItem('item',id)
                this.$emit('loadTransaction', id)
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



#Transaction .imagen_plan{
    width: 100%;
    height: 300px;
    margin-top: -40px;
  


}

#Transaction .container_formulario_adop{

    margin: auto;
    width: 80%;
    height: 1500px;
    color: #606060;
    text-align: left;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;  
    padding-bottom: 100px;

    
}

#Transaction label{
    width: 100%;
    display: flex;
    align-items: flex-start;
    padding: 7px;
    color: #606060;
}
#Transaction input{
    width: 100%;
    padding: 3px;
} 


#Transaction .colum1 textarea{

    width: 100%;
    height: 100px;

}

#Transaction .puntaje{
    display: flex;
    justify-content: space-around;
    width: 50%;
    margin-left: 30px;
}
#Transaction .puntuacion_home_comment {
  display: flex;
  width: 10%;
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
#Transaction .puntuacion_home_comment p {
  color: white;
  padding-top: 0px;
  margin-top: -2px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  padding-left: 5px;
}
#Transaction .puntaje input{
    width: 50px;
    margin-left: 30px;

       
}

#Transaction .puntaje p{
    display: flex;
    flex-direction: row;
}


#Transaction .publicar{
    cursor: pointer;    
    background-color:#00B2EA;
    width: 200px;
    padding: 8px;
    margin-top: 30px;
    margin-bottom: 50px;
    bottom: 15px;
    border-radius: 5px;
    border-style: none;  
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
    color: white;
    text-decoration: none; 
        font-size: 18px;
        font-weight: 700;
}

#Transaction .feed_opiniones{
    width: 100%;
    display: flex;
    flex-direction: row;
    margin-bottom: 30px;
}
#Transaction .imagen_opinion{
    width: 10%;
}
#Transaction .texto_opinion{
    width: 90%;
    padding-left: 20px;
    margin-top: -10px;
    
}


#Transaction .colum2 textarea{
width: 100%;
height: 80px;

} 

#Transaction .enviar_solicitud{
    cursor: pointer;    
    background-color:#FFC700;
    width: 200px;
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

#Transaction .colum1{
float: left;
width: 60%;



}
 #Transaction .colum2{
float: left;
margin-top: 60px;
margin-right: 0px;
margin-left: 60px;
width: 30%;
display: flex;
flex-direction: column;

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
    align-items: left;
position: relative;


}
.tarjeta_formulario img{
    width: 100%
    
}




.contenedor_planes{
  width: 80%;
  margin: auto;
  height: 1500px;
}


.formularioFilt label{
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
   
}

#Transaction  .formularioFilt p{
    width: 100%;
    display: flex;
    flex-direction: row;
    
}

#Transaction .formularioFilt input{
    display: inline-block;
position: relative;
top: 5px;
border: 2px solid #ccc;
width: 18px;
height: 18px;
background: #fff;
}


#Transaction .formularioBusqueda{
    width: 100%;
 display: flex;
    justify-content: space-around;
    margin: auto;
}
#Transaction .buscarPlan{
  
cursor: pointer;    
        background-color:#c50808;
        width: 50%;
        padding: 8px;

        bottom: 15px;
   border-radius: 5px;
   border-style: none;
    
   
}

#Transaction .buscarPlan b {
text-decoration: none;
        color: white;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 20px;
        font-weight: 700;
}
#Transaction .botonbuscar{
   
    width: 80%;
    margin-left: 30%;
    margin-top: 10px;
    margin-bottom: 10px;

}

/* 

.slide {
  background-image: url(../assets/banner.jpg);
  background-position: center;
  background-size: cover;
  height: 400px;
  margin-top: -50px;
}
 ul {
  display: flex;
} */
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
#Transaction .target {
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
/* .colum1pets {
  width: 30%;
  margin-left: 5px;
  margin-right: 25px;
}
.colum2pets {
  width: 70%;
  text-align: left;
  margin-right: 10px;
} */
#Transaction .nombreypuntuacion {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  height: 60px;
  align-items: flex-start;
}
#Transaction .target img {
  width: 100%;
  float: left;
}

#Transaction .nombre {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 20px;
  color: #202020;
  margin-top: 0px; 
  padding: 0;
}
#Transaction .nombre p {
  padding-top: 0px;
  margin-top: 0px;
 
}
#Transaction .puntuacion_home {
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
#Transaction .puntuacion_home p {
  color: white;
  padding-top: 0px;
  margin-top: -2px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  padding-left: 5px;
}
#Transaction .info {
  color: #606060;
  padding: 0;
  margin-top: -10px;
}
#Transaction .costo {
  color: #606060;
  padding: 0;
  text-align: right;
  font-size: 20px;
}
#Transaction .btn-adoptar {
  background: white;
  border-style: none;
  display: flex;

  flex-direction: row;
}
#Transaction .decorate {
  display: flex;
  align-content: flex-end;
  width: 100%;
  height: 5px;
  background-color: #00a3fe;
  margin-bottom: 0px;
}
#Transaction .target button:hover {

  cursor: pointer;
} 
/* .banner {
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
}   */
</style>