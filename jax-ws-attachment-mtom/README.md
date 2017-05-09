# JAX-WS Attachment MTOM

Este es un ejemplo de un Web service SOAP con Jax-Ws con archivos adjuntos con MTOM

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta


### 1.- Creamos una interfaz para la descarga y carga del archivo

```
package com.mkyong.ws;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface ImageServer{

	//download a image from server
	@WebMethod Image downloadImage(String name);

	//update image to server
	@WebMethod String uploadImage(Image data);

}

```
### 2.- Creas la implementacion del ImageServerImpl.java

```
package com.mkyong.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

//Service Implementation Bean
@MTOM
@WebService(endpointInterface = "com.mkyong.ws.ImageServer")
public class ImageServerImpl implements ImageServer{

	@Override
	public Image downloadImage(String name) {

		try {

			File image = new File("c:\\images\\" + name);
			return ImageIO.read(image);

		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}
	}

	@Override
	public String uploadImage(Image data) {

		if(data!=null){
			//store somewhere
			return "Upload Successful";
		}

		throw new WebServiceException("Upload Failed!");

	}

}
	
```

### 3.- Creas la clase que publica el Endpoint ImagePublisher.java

```
package com.mkyong.endpoint;

import javax.xml.ws.Endpoint;
import com.mkyong.ws.ImageServerImpl;

//Endpoint publisher
public class ImagePublisher{

    public static void main(String[] args) {

	Endpoint.publish("http://localhost:9999/ws/image", new ImageServerImpl());

	System.out.println("Server is published!");

    }

}

```

### 4.- Creamos los clientes para descargar y cargar la imagen

```
package com.mkyong.client;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mkyong.ws.ImageServer;

public class ImageClientDownload {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9998/ws/image?wsdl");
		QName qname = new QName("http://ws.mkyong.com/", "ImageServerImplService");

		Service service = Service.create(url, qname);
		ImageServer imageServer = service.getPort(ImageServer.class);

		
		/************ test download ***************/
		Image image = imageServer.downloadImage("rss.png");

		// display it in frame
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		JLabel label = new JLabel(new ImageIcon(image));
		frame.add(label);
		frame.setVisible(true);

		System.out.println("imageServer.downloadImage() : Download Successful!");

	}

}




y 




package com.mkyong.client;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.mkyong.ws.ImageServer;

public class ImageClientUpload {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9998/ws/image?wsdl");
		QName qname = new QName("http://ws.mkyong.com/", "ImageServerImplService");

		Service service = Service.create(url, qname);
		ImageServer imageServer = service.getPort(ImageServer.class);

		/************ test upload ****************/
		Image imgUpload = ImageIO.read(new File("/home/acuevas/Imágenes/logo.gif"));

		// enable MTOM in client
		BindingProvider bp = (BindingProvider) imageServer;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);

		String status = imageServer.uploadImage(imgUpload);
		System.out.println("imageServer.uploadImage() : " + status);

	}

}
```

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*