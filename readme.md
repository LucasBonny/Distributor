# Distributor Project

## Routes GET

### Supplier Done
- /supplier/ - Trás todas as empresas registradas com informações parciais.
```JSON
[
    {
        "name": "Coca-Cola",
        "cnpj": 45997418001710
    },
    {
        "name": "Ambev S.A.",
        "cnpj": 7526557000100
    }
]
```
- /supplier/{id} - Trás todos os dados de uma empresa especificada.
```JSON
{
    "name": "Coca-Cola",
    "cnpj": 45997418001710,
    "address": "St. de Habitações Individuais Sul QL 14 - Lago Sul, Brasília - DF",
    "cep": 71640085,
    "phoneNumber": 61984481420
}
```
- /supplier/{id}/products/ - Trás todos os produtos de uma empresa especificada pelo id.
```JSON
[
	{
	    "barCode": 845116286,
	    "name": "Energético Monster Energy 473ml",
	    "price": 11.0,
	    "quantity": 23
	},
	{
	    "barCode": 823124633,
	    "name": "Coca-Cola Original 350ml",
	    "price": 3.5,
	    "quantity": 54
	}
]
```

### Product Done
- /product - Trás todos os produtos cadastrados com dados parciais.

```JSON
[
  {
    "barCode": 675123490,
    "name": "Energético TNT 269ml"
  },
  {
    "barCode": 734567890,
    "name": "Guaraná Antarctica 600ml"
  },
  {
    "barCode": 735612098,
    "name": "Schweppes Citrus 1L"
  }
]
```
- /product/{id} - Trás todos os dados do produto especificado pelo id.

```JSON
{
  "barCode": 675123490,
  "name": "Energético TNT 269ml",
  "price": 14,
  "stock": 18,
  "imgUrl": "https://example.com/image8.png",
  "supplier": {
    "id": 2,
    "name": "Ambev S.A.",
    "cnpj": 7526557000100
  }
}
```
### Employee Done
- /employee - Trás todos os funcionários registrados no sistema.

```JSON
[
  {
    "id": 1,
    "name": "Lucas Bonifacio",
    "email": "lucasbonnyb8@gmail.com",
    "phoneNumber": 61983333333
  },
  {
    "id": 2,
    "name": "Gabriel Souza",
    "email": "gabrielsouza@gmail.com",
    "phoneNumber": 61940028922
  },
  {
    "id": 3,
    "name": "Nicoly Raissa",
    "email": "nicolyraissa@gmail.com",
    "phoneNumber": 61999999999
  }
]
```
- /employee/{id} - Trás todos os dados do funcionário especificado pelo id.

```JSON
{
  "id": 1,
  "name": "Lucas Bonifacio",
  "email": "lucasbonnyb8@gmail.com",
  "password": "123456",
  "cpf": 1178715745,
  "birthDate": "2001-05-13",
  "phoneNumber": 61983333333
}
```

### SaleItem Done

- /sale/item - Trás todos os produtos registrados em algum pedido.

```JSON
[
  {
    "product": 823124633,
    "sale": 1,
    "quantity": 6,
    "price": 151
  },
  {
    "product": 845116286,
    "sale": 2,
    "quantity": 4,
    "price": 842
  }
]
```

### Sale Done

- /sale/{id} - Trás todas as informações da venda.

```JSON

```

## Routes POST

### Sale Done

- /supplier/create - Cria uma nova empresa passando os parâmetros.

```JSON
{
    "name": "Bunge Alimentos",
    "cnpj": 84046101037194,
    "address": "Setor de Industria e Abastecimento - Trecho 05 - Lote 01 Setor Industrial, Sia",
    "cep": 71205050,
    "phoneNumber": 6134037500
}
```