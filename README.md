### README - API REST Maquinarias (Spring Boot)

Esta es una API diseñada para almacenar y gestionar datos relacionales de maquinarias, operarios, ordenes de trabajo, entre otras entidades en una base de datos. La API se implementa utilizando el framework Spring Boot y proporciona endpoints para crear, leer, actualizar y eliminar los diferentes registros correspondientes al área de negocio, así como también representar las relaciones entre ellos.

#### Diseño de base de datos
 
<img src="https://drive.google.com/uc?id=1lAKrE3O5vQF_VNPzgYPJrbZqVPQYNVQr" alt="drawing" style="width:500px;"/>

#### Requisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

* Un IDE (como IntelliJ IDEA, Eclipse o NetBeans)
* Java Development Kit (JDK) 8 o superior
* PostgreSQL y pgAdmin (opcional)

#### Instalación

Debes clonar el repositorio del proyecto en tu máquina local:
```
git clone https://github.com/javiercollao/spring-maquinarias-rest-api-db.git
```

Importa el proyecto en tu IDE como un proyecto de Spring Boot y asegurate de instalar todas las dependencias desde el archivo pom.xml.

Configura la conexión a la base de datos modificando el archivo application.properties. 

Proporciona los detalles de conexión a tu base de datos relacional.

Podras ver los endpoints en:

```
http://localhost:PORT/swagger-ui/index.html
```





 