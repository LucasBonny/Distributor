import { BaseService } from './BaseService'

export class EntregaService extends BaseService {
    constructor() {
        super('/deliveries')
    }
}