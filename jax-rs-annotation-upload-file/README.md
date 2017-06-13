![JAX-RS](https://javasail.com/wp-content/uploads/2017/01/glassfish_logo-2.png)

# TUTORIAL DE JAX-RS 	

Ejemplo de Oracle Jax Rs para aprender el uso de los siguientes componentes:

* Componente Uploap File con JaxRs


## PASOS PARA CONSTRUIR LA RUTA

Estas son las instrucciones para levantar el proyecto de manera correcta

### LIBRERIAS

* Maven 3.1.1 o superior
* JDK 1.7 o 1.8
* Jax Rs Nota: para que corra en Tomcat tu servicio tienes que agregar las librerias de http://repo1.maven.org/maven2/org/glassfish/jersey/bundles/jaxrs-ri/2.5/jaxrs-ri-2.5.zip a la carpeta lib de tu Tomcat.


### ARCHIVO DE DEPENDENCIAS MAVEN pom.xml

``` 
<project ...>

	<repositories>
		<repository>
			<id>maven2-repository.java.net</id>
			<name>Java.net Repository for Maven</name>
			<url>http://download.java.net/maven/2/</url>
			<layout>default</layout>
		</repository>
	</repositories>

	<dependencies>

		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-server</artifactId>
			<version>1.8</version>
		</dependency>

		<dependency>
			<groupId>com.sun.jersey.contribs</groupId>
			<artifactId>jersey-multipart</artifactId>
			<version>1.8</version>
		</dependency>

	</dependencies>

</project>

``` 


### 1.- CONSTRUYE EL HTML PARA SUBIR ARCHIVOS

``` 
<html>
<body>
	<h1>File Upload with Jersey</h1>

	<form action="rest/file/upload" method="post" enctype="multipart/form-data">

	   <p>
		Select a file : <input type="file" name="file" size="45" />
	   </p>

	   <input type="submit" value="Upload It" />
	</form>

</body>
</html>

``` 

### 2.- CREA EL SERVICIO EN REST


``` 

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/file")
public class UploadFileService {

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
```

### 3.- COMPILA TU PROYECTO Y COPIA EL WAR AL TOMCAT

En la carpeta de tu proyecto ejectuta el siguiente comando:
```
$ mvn clean install

$ cp $PROJECT_PATH/target/ejemplo.war $TOMCAT_HOME/webapps/

```

### 4.- VERIFICAMOS EL SERVICIO

En la siguiente URL: http://localhost:8080/RESTfulExample/FileUpload.html verificamos que nuestro servicio funcione.

![JAX-RS](http://www.mkyong.com/wp-content/uploads/2011/07/jersey-file-upload.png)



## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong.git). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*        
        
        
        
        
        
        
 
