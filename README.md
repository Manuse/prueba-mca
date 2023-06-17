# Proyecto Productos MCA

### Requerimientos

1. Java 20
2. Maven 3.9
3. Tener instalado Docker

### Pasos para compilar y ejecutar

En la misma carpeta del proyecto:

1. Ejecutar el script ```build.sh``` (Este script compilará y creará el contenedor en docker)
2. Acceder a la url http://localhost:5000/swagger-ui/index.html para poder realizar las pruebas de Swagger

### Pasos para ejecutar los test

En la misma carpeta del proyecto ejecutar el siguiente comando:

1. ```mvn test```

#### *Importante tener los puertos 5000 y 3001 liberados para realizar la ejecucion de los test
