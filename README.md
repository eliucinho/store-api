# API de Consulta de Precios

Esta API proporciona un servicio para consultar precios de productos según ciertos criterios, como la marca, la fecha de inicio y el id del producto.

## Configuración

La aplicación utiliza Spring Boot y la documentación de la API está generada con springdoc-openapi-ui.

### Requisitos

- Java 1.8
- Maven

### Configuración Local

1. Asegúrate de tener Java 1.8 instalado. Puedes verificarlo con: `java -version`
2. Compila el proyecto con Maven: `mvn clean install`
3. Ejecuta la aplicación: `mvn spring-boot:run`

## Swagger UI

Accede a la documentación de la API utilizando Swagger UI. Aquí está la URL:

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/price-controller/getPrices)

## Endpoint de Consulta de Precios

#### `POST /query-prices`

Endpoint para obtener precios según los parámetros especificados.

**Parámetros:**
- `brandId` (requerido): ID de la marca.
- `startDate` (requerido): Fecha de inicio en formato "yyyy-MM-dd HH:mm:ss".
- `productId` (requerido): ID del producto.

**Ejemplo de Solicitud:**
```json
{
    "brandId": 1,
    "startDate": "2020-06-14 15:00:00",
    "productId": 35455
}
```
**Ejemplo de Respuesta:**

```json
[
    {
        "brandId": 1,
        "startDate": "2020-06-14T21:00:00.000+00:00",
        "productId": 35455,
        "endDate": "2020-06-15T00:30:00.000+00:00",
        "priceList": 2,
        "priority": 1,
        "price": 25.45,
        "curr": "EUR"
    }
]
```

