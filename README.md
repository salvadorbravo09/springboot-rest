# API REST SPRING BOOT 3

## Descripción

Esta es una API RESTful creada con Spring Boot para manejar `Maker` y `Product`. Proporciona funcionalidades CRUD para ambos recursos. Ademas, utiliza DTOs y DAOs para la gestión de datos.

## Requisitos previos

- Java 17 o superior
- Spring Boot 3
- Maven

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/salvadorbravo09/springboot-rest.git
    cd springboot-rest
    ```

## Uso

Una vez que la aplicación esté en ejecución, puedes acceder a la API en `http://localhost:8080`. A continuación se muestran algunos de los endpoints disponibles:

### Endpoints

#### Maker

- `GET /api/v1/maker/findAll` - Obtiene una lista de makers.
- `GET /api/v1/maker/find/{id}` - Obtiene un maker específico por ID.
- `POST /api/v1/maker/save` - Crea un nuevo maker.
- `PUT /api/v1/maker/update/{id}` - Actualiza un maker existente por ID.
- `DELETE /api/v1/maker/delete/{id}` - Elimina un maker por ID.

#### Product

- `GET /api/v1/product/findAll` - Obtiene una lista de productos.
- `GET /api/v1/product/find/{id}` - Obtiene un producto específico por ID.
- `POST /api/v1/product/save` - Crea un nuevo producto.
- `PUT /api/v1/product/update/{id}` - Actualiza un producto existente por ID.
- `DELETE /api/v1/product/delete/{id}` - Elimina un producto por ID.
