<template>
  <div id="Categorias">
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
  name: "Categorias",

  data: function () {
    return {
      codigoPlan: localStorage.getItem("codigoPlan") || "none",
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

  loadSolicitud: function(codigoPlan){                
    localStorage.setItem('plan', codigoPlan)
    this.$emit('loadSolicitud')
  },

  created: function () {
    this.$apollo.queries.planesById.refetch();
    this.$apollo.queries.comentariosByUsername.refetch();
  },
};
</script>


<style>
#Categorias .formularioFilt label {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}

#Categorias .formularioFilt p {
  width: 100%;
  display: flex;
  flex-direction: row;
}

#Categorias .formularioFilt input {
  display: inline-block;
  position: relative;
  top: 5px;
  border: 2px solid #ccc;
  width: 18px;
  height: 18px;
  background: #fff;
}

#Categorias .formularioBusqueda {
  width: 100%;
  display: flex;
  justify-content: space-around;
  margin: auto;
}

#Categorias .buscarMascota {
  cursor: pointer;
  background-color: #9d84b7;
  width: 50%;
  padding: 8px;
  margin: auto;
  bottom: 15px;
  border-radius: 5px;
  border-style: none;
}

#Categorias .buscarMascota b {
  text-decoration: none;
  color: white;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 20px;
  font-weight: 700;
}

#Categorias .botonbuscar {
  width: 80%;
  margin-left: 40%;
  margin-top: 10px;
  margin-bottom: 10px;
}

#Categorias .container {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-around;
  margin: auto;
  width: 80%;
  padding-bottom: 100px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

#Categorias h1 {
  width: 100%;
  color: #e73b3b;
  text-align: center;
  margin-top: 50px;
  margin-bottom: 50px;
}

#Categorias .target {
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

#Categorias .colum1pets {
  width: 30%;
  margin-left: 5px;
  margin-right: 25px;
}

#Categorias .colum2pets {
  width: 70%;
  text-align: left;
  margin-right: 10px;
}

#Categorias .target img {
  width: 100%;
  float: left;
}

#Categorias .nombre {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 25px;
  color: #202020;
  margin-top: 0px;
  padding: 0;
}

#Categorias .nombre p {
  padding-top: 0px;
  margin-top: 0px;
}

#Categorias .info {
  color: #606060;
  padding: 0;
  margin-top: -25px;
}

#Categorias .costo {
  color: #606060;
  padding: 0;
  text-align: right;
  font-size: 20px;
}

#Categorias .btn-adoptar {
  background: white;
  border-style: none;
  display: flex;

  flex-direction: row;
}

#Categorias .decorate {
  display: flex;
  align-content: flex-end;
  width: 100%;
  height: 5px;
  background-color: #00a3fe;
  margin-bottom: 0px;
}

#Categorias .target button:hover {
  border: 1px solid #ffffff;
  margin: -10px;
  border-radius: 3px;
  cursor: pointer;
}
</style>