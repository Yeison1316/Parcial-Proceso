# API de Tienda

## Descripción

Esta API permite gestionar una tienda en línea con funcionalidades para manejar artículos, categorías y usuarios. Ofrece endpoints para crear, leer, actualizar y eliminar artículos y categorías, así como para gestionar el registro y autenticación de usuarios.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
  - [Autenticación](#autenticación)
  - [Endpoints de Usuarios](#endpoints-de-usuarios)
  - [Endpoints de Categorías](#endpoints-de-categorías)
  - [Endpoints de Artículos](#endpoints-de-artículos)

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/usuario/tienda-api.git
    ```

2. Instala las dependencias:

    ```bash
    Instalar la extension o plugin de lombok

## Configuración

1. En el archivo `.properties` en la raíz del proyecto, configura las variables de entorno necesarias:

    ```properties
    server.port = 8081
    spring.datasource.url=jdbc:mysql://localhost:3306/nombreBasededatos
    spring.datasource.password=*****
    spring.datasource.username=root
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    ```

2. Crea la base de datos en tu administrador de base de datos de tu preferencia:

3. Inicia el servicio
   Configurar la variable global en postman http://localhost:8081/
## Uso

### Autenticación

La API utiliza autenticación basada en tokens JWT. Para acceder a la mayoría de los endpoints, es necesario incluir un token de autorización en el encabezado de la solicitud.

- **Registro de usuario**: `auth/register`
- **Inicio de sesión**: `auth/login`

El token recibido tras el inicio de sesión debe incluirse en el encabezado de las solicitudes como:

### Authorization: Bearer <token>
### Registro de Usuario
1. Método: POST
2. Endpoint: auth/register
3. Descripción: Registra un nuevo usuario.
4. Datos del cuerpo:
```json
{
  "fullName": "Yeison Mestra",
  "birthDay": "1990-01-01",
  "document": "12345678",
  "phoneNumber": "1234567890",
  "email": "yeison@example.com",
  "password": "pas123",
  "role": "ADMIN"
}
```
5. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "User register"
    ],
    "statusCode": "SUCESSFULL",
}
```
### Inicio de Sesión
1. Método: POST
2. Endpoint: auth/login
3. Descripción: Autentica un usuario y devuelve un token JWT.
4. Datos del cuerpo:
```json
{
"email": "email@example.com",
"password": "contraseña"
}
```
5. Respuesta:
```json
{
"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
### Endpoints de Categorías
### Obtener Categorías
1. Método: GET
2. Endpoint: category/all
3. Descripción: Devuelve una lista de todas las categorías.
4. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Successful category query"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 1,
            "nameCategory": "Zapatos"
        },
        {
            "id": 2,
            "nameCategory": "Ropa"
        }
    ]
}
```
### Crear Categoría
1. Método: POST
2. Endpoint: category/create
3. Descripción: Crea una nueva categoría.
4. Datos del cuerpo:
```json
{
  "nameCategory": "nombre_categoria"
}
```
5. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Category create!"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 3,
            "nameCategory": "Buzos"
        }
    ]
}
```
### Actualizar Categoría
1. Método: PUT
2. Endpoint: category/{id}
3. Descripción: Actualiza una categoría existente.
4. Datos del cuerpo:
```json
{
"nameCategory": "nuevo_nombre",
}
```
5. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Update Caegory!"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 3,
            "nameCategory": "Camisas"
        }
    ]
}
```
### Eliminar Categoría
1. Método: DELETE
2. Endpoint: /api/categories/{id}
3. Descripción: Elimina una categoría.
4. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Category successful removal"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 3,
            "nameCategory": "Camisas"
        }
    ]
}
```
### Endpoints de Artículos
### Obtener Artículos
1. Método: GET
2. Endpoint: article/all
3. Descripción: Devuelve una lista de todos los artículos.
4. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Successful article query"
    ],
    "statusCode": "200",
    "article": [
        {
            "id": 2,
            "name": "Zapato",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        },
        {
            "id": 3,
            "name": "Tacon",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        },
        {
            "id": 4,
            "name": "carro",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        },
        {
            "id": 5,
            "name": "Buzote",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        }
    ]
}
```
### Crear Artículo
1. Método: POST
2. Endpoint: article/create
3. Descripción: Crea un nuevo artículo.
4. Datos del cuerpo:
```json
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
```
5. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Article create!"
    ],
    "statusCode": "201",
    "article": [
        {
            "id": 7,
            "name": "Cocina",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": null
            }
        }
    ]
}
```
### Actualizar Artículo
1. Método: PUT
2. Endpoint: article/{id}
3. Descripción: Actualiza un artículo existente.
4. Datos del cuerpo:
```json
{
  "name": "Sudadera",
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
```
5. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Update Aricle OK!"
    ],
    "statusCode": "200",
    "article": [
        {
            "id": 2,
            "name": "Sudadera",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 30,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 2,
                "nameCategory": null
            }
        }
    ]
}
```
### Eliminar Artículo
1. Método: DELETE
2. Endpoint: article/{id}
3. Descripción: Elimina un artículo.
4. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Article successful removal"
    ],
    "statusCode": "200",
    "article": [
        {
            "id": 5,
            "name": "Buzote",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        }
    ]
}
```

