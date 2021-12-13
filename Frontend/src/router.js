import gql from "graphql-tag";
import { createRouter, createWebHashHistory } from 'vue-router'
import { ApolloClient, createHttpLink, InMemoryCache } from '@apollo/client/core'


import Login from './components/Login.vue'
import Home from './components/Home.vue'
import Mision from './components/Mision.vue'
import Donaciones from './components/Donaciones.vue'
import Planes from './components/Planes.vue'
import Administrador from './components/Administrador.vue'
import Administrador_solicitudes from './components/Administrador_solicitudes.vue'
import Formulario_reservas from './components/Formulario_reservas.vue'
import Registro from './components/Registro.vue'


const routes = [
  {
    path: '/',
    name: 'root',
    component: Home
  },

  {
    path: '/login',
    name: 'Login',
    component: Login
  },

  {
    path: '/home',
    name: 'Home',
    component: Home
  },

  {
    path: '/mision',
    name: 'Mision',
    component: Mision
  },

  {
    path: '/donaciones',
    name: 'Donaciones',
    component: Donaciones
  },

  {
    path: '/planes',
    name: 'Planes',
    component: Planes
  },

  {
    path: '/administrador',
    name: 'Administrador',
    component: Administrador
  },

  {
    path: '/admin_solicitudes',
    name: 'Administrador_solicitudes',
    component: Administrador_solicitudes
  },

  {
    path: '/formulario_reservas',
    name: 'Formulario_reservas',
    component: Formulario_reservas
  },


  {
    path: '/registro',
    name: 'Registro',
    component: Registro
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

const apolloClient = new ApolloClient({
  link: createHttpLink({ uri: 'https://api-gateway-p53-g2.herokuapp.com/' }),
  cache: new InMemoryCache()
})


/* async function isAuth() {
  if (localStorage.getItem("token_access") === null ||
    localStorage.getItem("token_refresh") === null) {
    return false;
  }
  try {
    var result = await apolloClient.mutate({
      mutation: gql`
        mutation ($refresh: String!) {
          refreshToken(refresh: $refresh) {
            access
          }
        }
      `,
      variables: {
        refresh: localStorage.getItem("token_refresh"),
      },
    })

    localStorage.setItem("token_access", result.data.refreshToken.access);
    return true;
  } catch {
    localStorage.clear();
    alert("Su sesión expiró, por favor vuelva a iniciar sesión");
    return false;
  }
}

router.beforeEach(async (to, from) => {
  var is_auth = await isAuth();
  if (is_auth == to.meta.requiresAuth) return true

  if (is_auth) return { name: "home" };
  return { name: "logIn" };
}) */

export default router;
