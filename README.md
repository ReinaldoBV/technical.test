# README #
El proyecto es un servicio Rest lado servidor creado con spring boot y un cliente java que consume ese servicio, para mostrar una lista paginable desarrollado en jsp

**Ejecutar**

	mvn spring-boot:run

**Navegar en el browser la url**

	http://localhost:8080/list
	
Nota:
Es importante que sea localhost y puerto 8080 porque asi se codifico el llamado del cliente Rest

Consultar por postman o browser

	Method: GET, URL: http://localhost:8080/people

Hacer insert en app:

	Method: POST, URL: http://localhost:8080/people
	Body: {"firstName": "Karly", "lastName": "Bustamante"}
	Content-Type: "application/json"