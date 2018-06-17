# REST-assured

## Levantar servidor mock
Acceder a carpeta `\src\test\mock` y ejecutar:
```shell
java -jar wiremock-standalone-2.9.0.jar
```  
Por defecto se levanta el puerto 8080. Si queremos levantarlo en otro puerto, como el 8081 debemos ejecutar: 
```shell
java -jar wiremock-standalone-2.9.0.jar --port 8081
```