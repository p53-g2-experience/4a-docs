<template>
  <div id="Planes">
    <div class="slide"></div>

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

  </div>
</template>



<script>
import gql from "graphql-tag";

export default {
  name: "Planes",

  data: function () {
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
};
</script>


<style>
#Planes .slide {
  background-image: url(../assets/banner.jpg);
  background-position: center;
  background-size: cover;
  height: 400px;
  margin-top: -50px;
}

#Planes ul {
  display: flex;
}

#Planes .container {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-around;
  margin: auto;
  width: 80%;
  padding-bottom: 100px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

#Planes h2 {
  width: 100%;
  color: #e73b3b;
  text-align: center;
  margin-top: 50px;
}

#Planes .target {
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

#Planes .colum1pets {
  width: 30%;
  margin-left: 5px;
  margin-right: 25px;
}

#Planes .colum2pets {
  width: 70%;
  text-align: left;
  margin-right: 10px;
}
#Planes .nombreypuntuacion {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  height: 60px;
  align-items: flex-start;
}

#Planes .target img {
  width: 100%;
  float: left;
}

#Planes .nombre {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  color: #202020;
  margin-top: 0px;
  padding: 0;
}

#Planes .nombre p {
  padding-top: 0px;
  margin-top: 0px;
}

#Planes .puntuacion_home {
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

#Planes .puntuacion_home p {
  color: white;
  padding-top: 0px;
  margin-top: -2px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  padding-left: 5px;
}

#Planes .info {
  color: #606060;
  padding: 0;
  margin-top: -25px;
}

#Planes .costo {
  color: #606060;
  padding: 0;
  text-align: right;
  font-size: 20px;
}

#Planes .btn-adoptar {
  background: white;
  border-style: none;
  display: flex;

  flex-direction: row;
}

#Planes .decorate {
  display: flex;
  align-content: flex-end;
  width: 100%;
  height: 5px;
  background-color: #00a3fe;
  margin-bottom: 0px;
}

#Planes .target button:hover {
  border: 1px solid #ffffff;
  margin: -10px;
  border-radius: 3px;
  cursor: pointer;
}

#Planes .banner {
  border: none;
  width: 100%;
  background-color: white;
}

#Planes .banner1 {
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

#Planes .col1 {
  width: 50%;
  color: #ffffff;
  font-size: 20px;
  text-align: center;
  padding-top: 50px;
}

#Planes .col1 p {
  padding-left: 50px;
  padding-right: 50px;
}

#Planes .banner1 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/Gastronomía-1.jpg);
  background-size: cover;
}
#Planes .banner2 {
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
#Planes .banner2 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/excursionista.jpg);
  background-size: cover;
}
#Planes .banner3 {
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
#Planes .banner3 .col2 {
  width: 50%;
  height: 300px;
  background: url(../assets/imagesart.jpg);
  background-size: cover;
}
</style>