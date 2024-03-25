# clientManagerSystem

#Jhonatan Samuel Martinez Hernandez 

Projecto de escritorio con operaciones CRUD para manipular informacion en la base de datos el cual he desarrollado con java 8, swing y el driver de mariaDB 3.2.2.
Evidencia GA7-220501096-AA2-EV01 de la fase Ejecucion. Carrera Analisis y desarrollo de Software.

# How to run 

En el projecto busque el package con el nombre Client. Dentro de este paquete encontrará una clase llamada CientView.java, el cual es un formulario donde el usuario puede realizar operaciones de crear, eliminar, borrar y visualizar los clientes que se encuentran registrados en la base de datos.


![find the ClientView class](https://github.com/dev-jsmh/clientManagerSystem/assets/112201008/379252e7-e4e6-483e-8fac-c675d8016242)


Luego de haber encontrado el archivo ClientView ejecutelo con la opción "Run File". Despues de esto podra visualzar la interfaz grafica de uruario.

# Notes:

I have added the sql script for the data base so you can replicate it. The data base url is set by default to "jdbc:mariadb://localhost:3306/" + name of data base in the Connector class to return the connection of the data base.

#Have in mind

If you don't stablish the connection to the data base correctly the project won't run as it makes a query at start up to get all registered clients from the data base and display them in the table.

In order to avoid this problem initialize first the data base and then run the project. if the problem persists check the data base url path in the "Connector.java" file so you make sure the project connects successfully to data base.
