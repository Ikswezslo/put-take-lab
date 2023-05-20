import { createRouter, createWebHistory } from 'vue-router'
import PersonListView from '../views/PersonListView.vue'
import PersonAddView from '../views/PersonAddView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'list',
      component: PersonListView,
      props: { heading: 'List of persons' }
    },
    {
      path: '/new',
      name: 'new',
      component: PersonAddView,
      props: { heading: 'New person' }
    }
  ]
})

export default router
