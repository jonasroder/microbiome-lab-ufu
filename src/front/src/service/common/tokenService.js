const TOKEN_KEY = 'userToken';

export const saveToken = (token) => {
	const expiresAt = new Date().getTime() + (480 * 60 * 1000); // 8 horas em milissegundos
	localStorage.setItem(TOKEN_KEY, token);
	localStorage.setItem('tokenExpiresAt', expiresAt.toString());
	decodeTokenAndStoreSession(token);
};


export const isTokenExpired = () => {
	const expiresAt = localStorage.getItem('tokenExpiresAt');
	const now = new Date().getTime();
	const isExpired = now >= parseInt(expiresAt, 10);
	return isExpired;
};


export const getToken = () => {
	return localStorage.getItem(TOKEN_KEY);
};


export const getSessionUserData = () => {
	return localStorage.getItem('userData');
};



export const removeToken = () => {
	localStorage.removeItem(TOKEN_KEY);
	localStorage.removeItem('cachedRoutes');
	localStorage.removeItem('cachedMenu');
	localStorage.removeItem('userData');
};


const decodeTokenAndStoreSession = (token) => {
	const base64Url = token.split('.')[1];
	const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
	const payload = JSON.parse(atob(base64));
	const dataUser = JSON.parse(payload.sub);
	localStorage.removeItem('userData');
	sessionStorage.setItem('userData', JSON.stringify(dataUser));

	return dataUser;
};