declare namespace Projeto {

    type Usuario = {
        id?: number;
        nome: string;
        login: string;
        senha: string;
        email: string;
        perfil: Perfil;
    };

    type Fornecedor = {
        id?: string;
        name: string;
        cnpj: string;
        address: string;
        cep: string;
        phoneNumber: string;
    };

    type Produto = {
        id: string;
        barCode: string;
        name: string;
        price: number;
        stock: number;
        imgUrl: string;
        supplier: string;
      }

    type Recurso = {
        id?: number;
        nome: string;
        chave: string;
    }

    type Perfil = {
        id?: number;
        descricao: string;
    }

}