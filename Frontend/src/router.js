import { createRouter, createWebHashHistory } from 'vue-router'
import App from './App.vue'
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
    path:'/donaciones',
    name:'Donaciones',
    component: Donaciones
  },  

  {
    path:'/planes',
    name: 'Planes',
    component: Planes
  },

  {
    path:'/administrador',
    name: 'Administrador',
    component: Administrador
  },

  {
    path:'/admin_solicitudes',
    name:'Administrador_solicitudes',
    component: Administrador_solicitudes
  },

  {
    path:'/formulario_reservas',
    name: 'Formulario_reservas',
    component: Formulario_reservas
  }, 

  
  {
    path:'/registro',
    name: 'Registro',
    component: Registro
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
