import { axiosInstance, BaseService } from './BaseService'

export class FuncionarioService extends BaseService {
    constructor() {
        super('/employees')
    }
    status() {
        return axiosInstance.get('/employees/status')
    }
}