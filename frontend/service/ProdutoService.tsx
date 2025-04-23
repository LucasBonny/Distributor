import { BaseService } from './BaseService'

export class ProdutoService extends BaseService {
    constructor() {
        super('/products')
    }
}