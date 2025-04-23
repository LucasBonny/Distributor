import { BaseService } from './BaseService'

export class FornecedorService extends BaseService {
    constructor() {
        super('/suppliers')
    }
}