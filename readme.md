# Distributor Project

## Routes

### Supplier Done
- /supplier/ - Trás todas as empresas registradas com informações parciais.
```JSON
[
    {
        "id": 1,
        "name": "Coca-Cola",
        "cnpj": 45997418001710
    },
    {
        "id": 2,
        "name": "Ambev S.A.",
        "cnpj": 7526557000100
    }
]
```
- /supplier/{id} - Trás todos os dados de uma empresa especificada.
```JSON
{
    "id": 1,
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