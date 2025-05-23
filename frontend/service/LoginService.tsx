import axios from 'axios'

export const axiosInstance = axios.create({
  baseURL: process.env.NEXT_PUBLIC_BACKEND_URL_API,
})

export class LoginService {
 
    insertUser(usuario: Projeto.Usuario) {
        return axiosInstance.post('/auth/register', usuario)
    }

    login(login: String, senha: String) {
        return axiosInstance.post('/auth/login', { username: login, password: senha })
    }
}