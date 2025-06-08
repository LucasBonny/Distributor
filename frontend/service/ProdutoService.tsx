import { axiosInstance, BaseService } from './BaseService'


export class ProdutoService extends BaseService {
    constructor() {
        super('/products')
    }

      listarForncecedores() {
        return axiosInstance.get(this.url + '/suppliers')
      }
      editarFornecedor(id: any, objeto: any) {
        return axiosInstance.patch(this.url + '/'+ id, objeto)
      }
}