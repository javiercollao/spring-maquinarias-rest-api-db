### README - API RESTful Maquinarias (Spring Boot)

Esta es una API diseñada para almacenar y gestionar datos relacionales de maquinarias, operarios, ordenes de trabajo, entre otras entidades en una base de datos. La API se implementa utilizando el framework Spring Boot y proporciona endpoints para crear, leer, actualizar y eliminar los diferentes registros correspondientes al área de negocio, así como también representar las relaciones entre ellos.

### Endpoints

...

#### Características

Objetivo: Este proyecto es desarrollado con el fin de minimizar los tiempos muertos al
momento de hacer un mantenimiento a la maquinaria.

Hay roles:
* Jefe de mantenimiento: Es el encargado de recibir crear cada orden de trabajo en el taller. Deberiamos subdividirlos por areas o faenas.
 
Cabe destacar que:
* Mecanico: pueden ver la hoja de vida de la maquina, y pueden ver documentacion manuales, y tambien historial.

* Por lo tanto se puede ingresar con roles al sistema.

Entidad Operario:
* Como jefe de mantenimiento, Podemos buscar al operario quien solicita la orden de trabajo.
* Como jefe de mantenimiento, podemos crear a un operario el cual tiene permiso para agregar ordenes de trabajo.
* Como jefe de mantenimiento, podemos asignar a un mecanico, la resolucion del problema en el taller. 

Entidad Ot
* Como jefe de mantenimiento, podemos crear las ordenes de trabajo, y consultar por ellas segun la patente.

Entidad Maquinaria
* Como jefe de mantenimiento, podemos crear y actualizar la hoja de vida de una maquinaria, y consultar por ellas segun la patente. Cada vez que se daña o se compra una.
* Como jefe de mantenimiento, se encarga de actualizar el estado funcionamiento actual de la maquina.

Entidad repuesto
* Como jefe de mantenimiento, se encarga de agregar en la ficha de mantemiento los repuestos utilizados.

Entidad Proveedor
* Como jefe de mantenimiento, se encarga de poder ver los precios de cada proveedor disponible.

Entidad documentacion
* Como jefe de mantenimiento, se encargar de tener un registro de la documentacion que cuenta el taller.



 