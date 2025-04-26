import { BaseService } from './BaseService'

export class FuncionarioService extends BaseService {
    constructor() {
        super('/employees')
    }
}