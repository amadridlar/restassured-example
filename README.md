# REST-assured

## Levantar servidor mock para ejecutar las pruebas
Acceder a carpeta `\src\test\mock` y ejecutar:
```shell
java -jar wiremock-standalone-2.9.0.jar
```  
Por defecto se levanta el puerto 8080. Si queremos levantarlo en otro puerto, como el 8081 debemos ejecutar: 
```shell
java -jar wiremock-standalone-2.9.0.jar --port 8081
```
## Configuracion servidor 

### GET 
#### Request
URL
```
http://localhost:8080/jsongetpath
```
Headers
```
"Content-Type" : "application/json"
"Accept"       : "application/json"
```

#### Response
Headers
```
"Content-Type" : "application/json"
```
Body
```json
"name":"Johny",
"lastName":"Reland",
"favourites":{
		"beer":"Jacobsen",
		"whiskey":"JohnCor"
 }
```

### POST
#### Request
URL
```
http://localhost:8080/jsonpostpath
```
Headers
```
"Content-Type" : "application/json"
"Accept"       : "application/json"
```
Body
```json
"name":"Johny",
"lastName":"Reland",
"favourites":{
		"beer":"Jacobsen",
		"whiskey":"JohnCor"
 }
```
#### Response
Headers
```
"Content-Type" : "application/json"
```
Body
```json
"status":200,
"message":"Your post was posted successfully :)"
```
