## Necesidad:

Crear una aplicación en la cual, a partir de unos datos de entrada, fecha, brand y product, devuelva el precio
que se tiene en esa fecha para ese brand y ese producto.

## Ejecución:

Para la ejecución del proyecto, se puede hacer ejecutando directamente en Intellij por ejemplo, la clase
InditexConsumerApp.java
Otra manera es, desde línea de comandos, situarnos en la raíz de la carpeta y lanzar:
```
mvn clean package
```
Esto nos genera un jar dentro de target. Situándonos dentro de /target, lanzaríamos:
```
java -jar {{nuestro_directorio}}/inditex-consumer/target/inditexConsumer-0.0.1-SNAPSHOT.jar
```

## Realización de la prueba:

Para esta prueba, se ha utilizado como lenguaje de programación Java11, junto con Maven para la gestión de las
dependencias necesarias.
Para los test, se ha añadido JUnit para su ejecución así como Mockito.

Para el almacenamiento de los datos se guarda todo en una base de datos h2.

## Test de la aplicación:

Una vez arrancado nuestro programa, una manera de probarlo, es desde un postman, hacer una petición
de tipo get al endpoint /prices:

```
http://localhost:8080/prices
```

con un body como este:

```
{
"date":"2020-06-16 21:00",
"productId":35455,
"brandId":1
}
```

Esto nos devolverá el objeto price con toda la info que se solicita, incluído el precio. Ejemplo:

```
{
"product_id": 35455,
"brand_id": 1,
"price_list": 4,
"start_date": "2020-06-15T16:00:00",
"end_date": "2020-12-31T23:59:59",
"price": 38.95,
"currency": "EUR"
}
```

Si no queremos arrancar y probar mediantes postman, se ha creado un test que va a probar el endpoint /prices
con los datos que se han solicitado en la prueba.