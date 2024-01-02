# Proyecto de Gestión de Archivos de Texto Plano (.txt) en Java con Patrón MVC

Este proyecto académico se centra en la gestión de archivos de texto plano utilizando Java y siguiendo el
patrón de arquitectura Modelo-Vista-Controlador (MVC).

<div align="center">
  <img src="https://github.com/ItsEddyGD666/gestion-de-archivos-planos/assets/50812964/5a26a086-7be0-4dac-b623-4ff8b020a9e1" height="310px"/> 
</div>


## Descripción

Este proyecto, desarrollado en Java, se enfoca en la gestión avanzada de registros de alumnos mediante el uso del patrón
arquitectónico Modelo-Vista-Controlador (MVC). La aplicación permite realizar operaciones eficientes, como la creación,
lectura y modificación de registros de alumnos almacenados en archivos de texto plano, así como exportar a PDF de manera
sencilla todo el archivo (.txt) de donde se estan leyendo los datos.

## Características

- Arquitectura MVC para separación clara de responsabilidades.
- Operaciones en archivos de texto plano (.txt).
- Hace uso de un archivo de texto plano (.txt) creado previamente y que al insertar un nuevo registro sigue el siguiente patron: `No de cuenta | Nombre(s) | Apellidos | Fecha de Nacimiento | RFC | Semestre | Licenciatura | Promedio`

  Quedando el archivo de la siguiente manera:
  <div align="center">    
    <img src="https://github.com/ItsEddyGD666/gestion-de-archivos-planos/assets/50812964/d8351f90-d0e8-4487-890f-d6891d026ef3" width="470px"/> 
  </div>
  

## Librerías

Este proyecto utiliza las siguientes librerías:

- [iTextPDF](https://itextpdf.com/): Es una potente librería en Java para la creación y manipulación de
  documentos PDF. Permite generar, modificar y extraer contenido de archivos PDF de manera eficiente, facilitando la
  integración de funcionalidades de generación de informes y documentos en aplicaciones Java.
- [RSMaterial Components](https://www.youtube.com/@DevelopersBross): Es una librería creada por el canal de
  YouTube `Developers Bross` que proporciona componentes para una interfaz de usuario más amigable, moderna y
  visualmente atractiva.

## Estructura del Proyecto

- `/src`: Contiene el código fuente del proyecto.
    - `/main`: Contiene la clase principal para iniciar el proyecto
- `/Librerias`: Contiene las librerias que le dan los estilos y la librería para exportar a PDF

## Uso

1. Clona el repositorio: `git clone https://github.com/ItsEddyGD666/gestion-de-archivos-planos.git`
2. Abre el proyecto en tu entorno de desarrollo preferido (Preferentemente Apache Netbeans IDE que fue donde se
   desarrollo).
3. Ejecuta la aplicación y explora las funcionalidades de gestión de archivos de texto.

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras mejoras o correcciones, no dudes en crear un *pull request*.


