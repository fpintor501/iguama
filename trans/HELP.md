# Para correr este proyecto.

En una base de datos MYSQL local, crear el schema iguama, y en este schema crear la tabla TRANSACCIONES usando el script crea_trasacciones.sql.
 
Correr el script insert_transacciones.sql para crear registros de prueba.

Crear un usuario iguama con password iguama que tenga acceso al schema iguama en MYSQL.

Desde eclipse, importar el proyecto "trans" usando el pom.xml de maven.

Configurar que el compilador de Java se version 15 en eclipse para este proyecto.

Si se utiliza otro usuario o schema que iguama en MYSQL, cambiar los atributos de datasource en "src/main/resources/application.properties"

Construir el proyecto con maven usando "mvn install".

Ejecutar el proyecto directamente utilizando el jar "trans-0.0.1-SNAPSHOT.jar" generado en target con Java v15 desde la linea de comando:

>java -jar trans-0.0.1-SNAPSHOT.jar

Aparece la consola de Spring Boot y eventualmente se levanta el sistema.

Aparece un mensaje para ejecutar los reportes:

"Tipo Reporte (1-consola/2-archivo): "

Introducir 1 y apareceran los dos reportes dependiendo de los registros que esten en la BD.

Tambien se puede acceder a un REST API CRUD para la tabla TRANSACCIONES usando un browser o Postman

ejemplos

http://localhost:8088/transaccions //Aparecen todos los registros que estan en la BD en formato JSON

http://localhost:8088/transaccions/10003  ??Aparece el registro correspondiente al id_orden = 10003

