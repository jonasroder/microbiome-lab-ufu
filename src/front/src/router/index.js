import { createRouter, createWebHistory } from 'vue-router'
import { getToken } from '@/service/common/tokenService';

const routes = [
	{
		path: '/',
		name: 'Home',
		component: () => import("../views/main-page/main-page.vue"),
		meta: { title: 'Jonas e Denise' }
	},
	{
		path: '/login',
		name: 'Login-Page',
		component: () => import("../views/login/Login-Page.vue"),
		meta: { title: 'Saúde em Equilibrio - Login' }
	},
	{
		path: '/pessoa/edit',
		name: 'Pessoa-Page',
		component: () => import("../views/pessoa-page/edit.vue"),
		meta: { title: 'Saúde em Equilibrio - Cadastrar Pessoa' }
	},

];

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes,
})


router.beforeEach((to, from, next) => {
	if (to.name !== 'Login-Page' && !getToken()) {
		next({ name: 'Login-Page' });
	} else {
		next();
	}
});


router.afterEach((to) => {
	// Muda o título da aba com base na rota atual
	document.title = to.meta.title || 'Título Padrão';
});


export default router;
