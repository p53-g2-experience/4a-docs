<template>
  <div id="Experiencias">
    <div class="slide"></div>
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

      <button class="banner">
        <div class="banner3">
          <div class="col1">
            <h2>Experiencias Artisticas</h2>
            <p>
              Una nueva alternativa de turismo pensada para que todos puedan
              vivir mas que un momento una experiencia de vida
            </p>
          </div>
          <div class="col2"></div>
        </div>
      </button>
    </div>
</template>



<script>
import gql from "graphql-tag";

export default {
  name: "Experiencias",

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
#Experiencias .slide {
  background-image: url(../assets/banner.jpg);
  background-position: center;
  background-size: cover;
  height: 400px;
  margin-top: -50px;
}

#Experiencias ul {
  display: flex;
}

#Experiencias .container {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-around;
  margin: auto;
  width: 80%;
  padding-bottom: 100px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

#Experiencias h2 {
  width: 100%;
  color: #e73b3b;
  text-align: center;
  margin-top: 50px;
}

#Experiencias .target {
  display: flex;
  width: 45%;
  height: auto;
  margin: 10px;
  padding: 10px;
  border-radius: 3px;
  flex-direction: row;
  align-items: center;
  -webkit-box-shadow: 8px 8px 15px -17px rgba(0, 0, 0, 0.65);
  -moz-box-shadow: 8px 8px 15px -17px rgba(0, 0, 0, 0.65);
  box-shadow: 8px 8px 15px -17px rgba(0, 0, 0, 0.65);
  position: relative;
}

#Experiencias .colum1pets {
  width: 30%;
  margin-left: 5px;
  margin-right: 25px;
}

#Experiencias .colum2pets {
  width: 70%;
  text-align: left;
  margin-right: 10px;
}
#Experiencias .nombreypuntuacion {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  height: 60px;
  align-items: flex-start;
}

#Experiencias .target img {
  width: 100%;
  float: left;
}

#Experiencias .nombre {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  color: #202020;
  margin-top: 0px;
  padding: 0;
}

#Experiencias .nombre p {
  padding-top: 0px;
  margin-top: 0px;
}

#Experiencias .puntuacion_home {
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

#Experiencias .puntuacion_home p {
  color: white;
  padding-top: 0px;
  margin-top: -2px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  padding-left: 5px;
}

#Experiencias .info {
  color: #606060;
  padding: 0;
  margin-top: -25px;
}

#Experiencias .costo {
  color: #606060;
  padding: 0;
  text-align: right;
  font-size: 20px;
}

#Experiencias .btn-adoptar {
  background: white;
  border-style: none;
  display: flex;

  flex-direction: row;
}

#Experiencias .decorate {
  display: flex;
  align-content: flex-end;
  width: 100%;
  height: 5px;
  background-color: #00a3fe;
  margin-bottom: 0px;
}

#Experiencias .target button:hover {
  border: 1px solid #ffffff;
  margin: -10px;
  border-radius: 3px;
  cursor: pointer;
}

#Experiencias .banner {
  border: none;
  width: 100%;
  background-color: white;
}

#Experiencias .banner1 {
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

#Experiencias .col1 {
  width: 50%;
  color: #ffffff;
  font-size: 20px;
  text-align: center;
  padding-top: 50px;
}

#Experiencias .col1 p {
  padding-left: 50px;
  padding-right: 50px;
}

#Experiencias .banner1 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/Gastronomía-1.jpg);
  background-size: cover;
}
#Experiencias .banner2 {
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
#Experiencias .banner2 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/excursionista.jpg);
  background-size: cover;
}
#Experiencias .banner3 {
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
#Experiencias .banner3 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/imagesart.jpg);
  background-size: cover;
}
</style>