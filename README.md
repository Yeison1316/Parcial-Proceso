#Article
En esta colleción se realiza el crud de los articulos.

Para la variable global Local la url es http://localhost:8081/﻿

﻿

##GET
Get all article
{{local}}article/all
﻿

Authorization
Bearer Token
Token
<token>
POST
Create a article
{{local}}article/create
Nota: Debes tener creadas categorias con anterioridad para poder crear los articulos

﻿

Body
raw (json)
json
{
  "name": "Cocina",
  "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
  "stock": 50,
  "price": "39.99",
  "dateOfAdmission": "2024-04-09",
  "category": {
    "id": 1
  }
}
GET
Get a single article
{{local}}article/2
﻿

PUT
Update a article
{{local}}article/2
﻿

Body
raw (json)
View More
json
{
  "name": "Sudadera con Gorro",
  "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
  "stock": 30,
  "price": "39.99",
  "dateOfAdmission": "2024-04-09",
  "category": {
    "id": 2,
    "name": "Ropa",
    "description": "Artículos de vestir"
  }
}
DELETE
Delete a article
{{local}}article/6
