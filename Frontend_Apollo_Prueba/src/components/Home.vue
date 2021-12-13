<template>
  <div class="contenedor-global">
    <div class="slide"></div>

    <div class="container">
      <h1>¡Experiencias Imperdibles!</h1>

      <div
        v-for="plan in allPlan.slice(0, 12)"
        v-bind:key="plan.codigoPlan"
        class="target"
      >
        <!-- Trae un plan por ID y revisa todos los leanes -->
        <button class="btn-adoptar" v-on:Click="loadSolicitud(planesById.codigoPlan)">
          <!-- Identifica un plan por ID -->
          <div class="colum1pets">
            <img :src="planesById.plan_image_path" />
            <!-- Dirección de la IMAGEN 1 miniatura del plan -->
          </div>
          <div class="colum2pets">
            <div class="nombreypuntuacion">
              <!-- NOMBRE del plan -->
              <div class="nombre">
                <p>{{ planesById.plan_title }}</p>
              </div>

              <!-- NOMBRE desde la tabla COMENTARIOS -->

              <!-- DESCRIPCIÓN plan -->
              <div class="puntuacion_home">
                <img
                  src="../assets/estrella.png"
                  style="width: 25px; height: 25px"
                  alt="puntuacion"
                />
                <p>{{ comentariosByUsername.calificacion }}</p>
              </div>
            </div>
            <div class="info">
              <p>{{ planesById.plan_description }}</p>
            </div>
            <!-- DESCRIPCIÓN plan -->

            <div class="costo">
              <b
                ><p>{{ planesById.plan_category }}</p></b
              >
            </div>
            <!-- CATEGORÍA plan -->
            <div class="decorate"></div>
          </div>
        </button>
      </div>
    </div>

    <button class="banner">
      <div class="banner1">
        <div class="col1">
          <h2>Experiencias Gastronomicas</h2>
          <p>
            Una nueva alternativa de turismo pensada para que todos puedan vivir
            mas que un momento una experiencia de vida
          </p>
        </div>
        <div class="col2"></div>
      </div>
    </button>

    <button class="banner">
      <div class="banner2">
        <div class="col2"></div>
        <div class="col1">
          <h2>Experiencias Naturales</h2>
          <p>
            Una nueva alternativa de turismo pensada para que todos puedan vivir
            mas que un momento una experiencia de vida
          </p>
        </div>
      </div>
    </button>

    <button class="banner">
      <div class="banner3">
        <div class="col1">
          <h2>Experiencias Artisticas</h2>
          <p>
            Una nueva alternativa de turismo pensada para que todos puedan vivir
            mas que un momento una experiencia de vida
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
  name: "Home",

  data: function () {
    return {
      allPlan: "",
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

    comentariosByUsername: {
      query: gql`
        query ComentariosByUsername($username: String!) {
          comentariosByUsername(username: $username) {
            idComentario
            username
            codigoPlan
            calificacion
            opinion
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
};
</script>

<style>
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
  font-size: 25px;
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
  margin-top: -25px;
}
.costo {
  color: #606060;
  padding: 0;
  text-align: right;
  font-size: 20px;
}
.btn-adoptar {
  background: white;
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
  border: 1px solid #ffffff;
  margin: -10px;
  border-radius: 3px;
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