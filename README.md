![Encabezado del Proyecto](./header.png)
# Spring Batch Chunk

Esta es una aplicación de ejemplo que utiliza Spring Batch con un enfoque de Chunk para procesar datos personales por lotes. La aplicación recibe un archivo `persons.csv` que se encuentra en la carpeta `/files`. Luego, procesa los datos en varios pasos, lee el archivo `persons.csv`, extrae los datos, agrega la fecha de procesado y los escribe en una base de datos. Esta pensada para procesar grandes cantidades de datos, por lo que se ejecuta una sola vez, si hay que procesar otro fichero solo hay que cambiar el fichero y ejecutar el contenedor. 

### Requisitos

Para ejecutar esta aplicación, necesitarás tener instalado lo siguiente:

1. Docker
2. Docker Compose

### Ejecución

Para ejecutar la aplicación, sigue estos pasos:

1. Clona el repositorio desde GitHub:

```bash
https://github.com/agcadu/SpringBatch-Chunk.git
```

2. Ingresa al directorio del proyecto:

```bash
cd SpringBatchChunk
```

3. Ejecuta el comando `docker-compose` para levantar el contenedor de la aplicación y la base de datos:

```bash
docker compose up
```

4. Asegúrate de tener el archivo `persons.csv` que deseas procesar. Puedes utilizar el archivo proporcionado en la carpeta raiz `persons.csv` para pruebas.

### Descripción del Proceso

1. A continuación, leerá el archivo `persons.csv`, extraerá los datos
2. Agregará la fecha de procesado.
3. Los datos procesados se guardarán en una base de datos PostgreSQL que estara disponible en `localhost:5432/batch_chunk`.

### Estructura del Proyecto

La aplicación está construida con Spring Batch y sigue la estructura básica de un proyecto de Spring Boot. Los archivos y directorios clave son:

- `src/main/java/com/batch`: Contiene el código fuente de la aplicación, incluyendo los pasos de procesamiento.
- `src/main/resources`: Contiene los archivos de configuración de Spring, incluyendo `application.properties`.
- `Dockerfile`: Archivo de Docker para la creación de la imagen de la aplicación.
- `docker-compose.yml`: Archivo de Docker Compose para levantar los contenedores de la aplicación y la base de datos.

### Notas

- Esta aplicación es solo un ejemplo y no debe utilizarse en un entorno de producción sin las adecuadas consideraciones de seguridad y rendimiento.
- Si el contenedor de la aplicación falla al iniciar, asegúrate de que el contenedor de la base de datos se haya iniciado correctamente. Si no es así, intenta reiniciar el contenedor de la aplicación.
- Asegúrate de que el archivo `persons.csv` que se procesa en la aplicación contenga datos válidos en el formato esperado.
