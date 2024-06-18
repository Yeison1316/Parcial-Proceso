API de Tienda
Descripción
Esta API permite gestionar una tienda en línea con funcionalidades para manejar artículos, categorías y usuarios. Ofrece endpoints para crear, leer, actualizar y eliminar artículos y categorías, así como para gestionar el registro y autenticación de usuarios.

Tabla de Contenidos
Instalación
Configuración
Uso
Autenticación
Endpoints de Usuarios
Endpoints de Categorías
Endpoints de Artículos
Ejemplos de Solicitudes
Licencia
Instalación
Clona el repositorio:

bash
Copiar código
git clone https://github.com/usuario/tienda-api.git
Navega al directorio del proyecto:

bash
Copiar código
cd tienda-api
Instala las dependencias:

bash
Copiar código
npm install
# o
pip install -r requirements.txt
Configuración
Crea un archivo .env en la raíz del proyecto y configura las variables de entorno necesarias:

env
Copiar código
DATABASE_URL=postgres://usuario:contraseña@localhost:5432/tienda
SECRET_KEY=tu_secreto
JWT_EXPIRATION=3600
Ejecuta las migraciones de la base de datos:

bash
Copiar código
npm run migrate
# o
python manage.py migrate
Inicia el servidor:

bash
Copiar código
npm start
# o
python manage.py runserver
Uso
Autenticación
La API utiliza autenticación basada en tokens JWT. Para acceder a la mayoría de los endpoints, es necesario incluir un token de autorización en el encabezado de la solicitud.

Registro de usuario: /api/register
Inicio de sesión: /api/login
El token recibido tras el inicio de sesión debe incluirse en el encabezado de las solicitudes como:

http
Copiar código
Authorization: Bearer <token>
Endpoints de Usuarios
Registro de Usuario: POST /api/register

Descripción: Registra un nuevo usuario.
Datos del cuerpo:
json
Copiar código
{
  "username": "usuario",
  "email": "email@example.com",
  "password": "contraseña"
}
Inicio de Sesión: POST /api/login

Descripción: Autentica un usuario y devuelve un token JWT.
Datos del cuerpo:
json
Copiar código
{
  "email": "email@example.com",
  "password": "contraseña"
}
Endpoints de Categorías
Obtener Categorías: GET /api/categories

Descripción: Devuelve una lista de todas las categorías.
Crear Categoría: POST /api/categories

Descripción: Crea una nueva categoría.
Datos del cuerpo:
json
Copiar código
{
  "name": "nombre_categoria",
  "description": "descripción de la categoría"
}
Actualizar Categoría: PUT /api/categories/{id}

Descripción: Actualiza una categoría existente.
Datos del cuerpo:
json
Copiar código
{
  "name": "nuevo_nombre",
  "description": "nueva_descripción"
}
Eliminar Categoría: DELETE /api/categories/{id}

Descripción: Elimina una categoría.
Endpoints de Artículos
Obtener Artículos: GET /api/articles

Descripción: Devuelve una lista de todos los artículos.
Crear Artículo: POST /api/articles

Descripción: Crea un nuevo artículo.
Datos del cuerpo:
json
Copiar código
{
  "title": "nombre_artículo",
  "description": "descripción del artículo",
  "price": 29.99,
  "category_id": 1
}
Actualizar Artículo: PUT /api/articles/{id}

Descripción: Actualiza un artículo existente.
Datos del cuerpo:
json
Copiar código
{
  "title": "nuevo_nombre",
  "description": "nueva_descripción",
  "price": 39.99,
  "category_id": 2
}
Eliminar Artículo: DELETE /api/articles/{id}

Descripción: Elimina un artículo.
Ejemplos de Solicitudes
Crear Usuario
http
Copiar código
POST /api/register
Content-Type: application/json

{
  "username": "usuario",
  "email": "usuario@example.com",
  "password": "contraseña"
}
Iniciar Sesión
http
Copiar código
POST /api/login
Content-Type: application/json

{
  "email": "usuario@example.com",
  "password": "contraseña"
}
Obtener Categorías
http
Copiar código
GET /api/categories
Authorization: Bearer <token>
Crear Artículo
http
Copiar código
POST /api/articles
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Nuevo Artículo",
  "description": "Descripción del artículo",
  "price": 19.99,
  "category_id": 1
}
