# API de Tienda

## Descripción

Esta API permite gestionar una tienda en línea con funcionalidades para manejar artículos, categorías y usuarios. Ofrece endpoints para crear, leer, actualizar y eliminar artículos y categorías, así como para gestionar el registro y autenticación de usuarios.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
  - [Autenticación](#autenticación)
      - [Registrar usuarios](#registro-de-usuario)
      - [Acceso de usuarios](#inicio-de-sesión)
  - [Endpoints de Usuarios](#endpoints-de-usuarios)
      - [Crear usuarios](#crear-usuarios)
      - [obtener usuarios](#obtener-usuarios)
      - [obtener un usuario](#obtener-un-usuario)
      - [Actualizar un usuario](#actualizar-un-usuario)
      - [Eliminar un usuario](#eliminar-un-usuario)
  - [Endpoints de Categorías](#endpoints-de-categorías)
      - [Crear categorías](#crear-categoría)
      - [obtener categorías](#obtener-categorías)
      - [obtener una categoría](#obtener-una-categoría)
      - [Actualizar una categoría](#actualizar-una-categoría)
      - [Eliminar un categoría](#eliminar-una-categoría)
  - [Endpoints de Artículos](#endpoints-de-artículos)
      - [Crear artículos](#crear-artículos)
      - [obtener artículos](#obtener-artículos)
      - [obtener un artículo](#obtener-un-artículo)
      - [Actualizar un artículo](#actualizar-un-artículo)
      - [Eliminar un artículo](#eliminar-un-artículo)

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

#### Authorization: Bearer <token>
##### Registro de Usuario
1. Método: POST
2. Endpoint: auth/register
3. Descripción: Registra un nuevo usuario.
4. Datos del cuerpo:
```json
{
  "fullName": "full name",
  "birthDay": "1990-01-01",
  "document": "12345678",
  "phoneNumber": "1234567890",
  "email": "example@example.com",
  "password": "1234",
  "role": "ADMIN"
}
```
5. Respuesta:
```json
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjYXJsb3NAZXhhbXBsZS5jb20iLCJpYXQiOjE3MTg3Mjg2MjAsImV4cCI6MTcxODcyODk4MH0._4lKmwyDgQgjrhlvHX9KMr2kvtgqH1_MjmdZmOxmNnGBFM_psXYapfahPk6cubS1FyVsobtvW4PuW8K6hrpNXQ"
}
```
##### Inicio de Sesión
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
#### Endpoints de Usuarios
##### Crear Usuarios
1. Método: POST
2. Endpoint: user/create
3. Descripción: Crear un nuevo usuario.
4. Datos del cuerpo:
```json
{
  "fullName": "full name",
  "birthDay": "1990-01-01",
  "document": "12345678",
  "phoneNumber": "1234567890",
  "email": "example@example.com",
  "password": "1234",
  "role": "ADMIN"
}
```
5. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "User create!"
    ],
    "statusCode": "201",
    "user": [
        {
            "id": 7,
            "fullName": "Carlos Mestra",
            "birthDay": "1990-01-01T00:00:00.000+00:00",
            "document": "1234418855",
            "phoneNumber": "1234567890",
            "email": "carlos@example.com",
            "password": "1234",
            "role": "ADMIN",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "username": "carlos@example.com",
            "authorities": [
                {
                    "authority": "ADMIN"
                }
            ],
            "accountNonLocked": true
        }
    ]
}
```
##### Obtener usuarios
1. Método: GET
2. Endpoint: user/all
3. Descripción: Devuelve una lista de todos los usuarios.
4. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Successful user query"
    ],
    "statusCode": "200",
    "user": [
        {
            "id": 6,
            "fullName": "user_name",
            "birthDay": "1990-01-01T00:00:00.000+00:00",
            "document": "1234418855",
            "phoneNumber": "1234567890",
            "email": "example@example.com",
            "password": "1234",
            "role": "ADMIN",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "username": "user@example.com",
            "authorities": [
                {
                    "authority": "ADMIN"
                }
            ],
            "accountNonLocked": true
        }
    ]
}
```
##### Obtener un usuario
1. Método: GET
2. Endpoint: user/id
3. Descripción: Devuelve el usuario por su id.
4. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Successful user query"
    ],
    "statusCode": "200",
    "user": [
        {
            "id": 6,
            "fullName": "user_name",
            "birthDay": "1990-01-01T00:00:00.000+00:00",
            "document": "1234418855",
            "phoneNumber": "1234567890",
            "email": "example@example.com",
            "password": "1234",
            "role": "ADMIN",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "username": "user@example.com",
            "authorities": [
                {
                    "authority": "ADMIN"
                }
            ],
            "accountNonLocked": true
        }
    ]
}
```
##### Actualizar un usuario
1. Método: PUT
2. Endpoint: user/id
3. Descripción: Actualiza un usuario existente.
4. Datos del cuerpo:
```json
  {
  "fullName": "full name",
  "birthDay": "1990-01-01",
  "document": "12345678",
  "phoneNumber": "1234567890",
  "email": "example@example.com",
  "password": "1234",
  "role": "ADMIN"
}
```
5. Respuestas
   ```json
   {
    "date": "2024-06-18",
    "message": [
        "Update user OK!"
    ],
    "statusCode": "200",
    "user": [
        {
            "id": 5,
            "fullName": "full name",
            "birthDay": "1990-01-01T00:00:00.000+00:00",
            "document": "12345678",
            "phoneNumber": "1234567890",
            "email": "example@example.com",
            "password": "pas123",
            "role": "ADMIN",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "username": "user@example.com",
            "authorities": [
                {
                    "authority": "ADMIN"
                }
            ],
            "accountNonLocked": true
        }
    ]
}
   ```
##### Eliminar un usuario
1. Método: DELETE
2. Endpoint: user/id
3. Descripción: Elimina un usuario existente.
4. Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "User successful removal"
    ],
    "statusCode": "200",
    "user": [
        {
            "id": 6,
            "fullName": "Carlos Mestra",
            "birthDay": "1990-01-01T00:00:00.000+00:00",
            "document": "1234418855",
            "phoneNumber": "1234567890",
            "email": "carlos@example.com",
            "password": "1234",
            "role": "ADMIN",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "username": "carlos@example.com",
            "authorities": [
                {
                    "authority": "ADMIN"
                }
            ],
            "accountNonLocked": true
        }
    ]
}
```
#### Endpoints de Categorías
##### Obtener Categorías
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
##### Crear Categoría
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
##### Actualizar una Categoría
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
##### Eliminar una Categoría
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
#### Endpoints de Artículos
##### Obtener Artículos
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
##### Crear Artículos
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
##### Actualizar un Artículo
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
##### Eliminar un Artículo
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

