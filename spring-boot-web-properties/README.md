# Spring Boot Configuration Properties	

Este es un ejemplo de la configuracion de los diferentes tipos de properties y archivos yml con Spring Boot

## Como iniciar la aplicacion

Estas son las instrucciones para levantar el proyecto de manera correcta


### Inicia el proyecto desde Maven 
```
$ mvn spring-boot:run

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.2.RELEASE)

2016-12-03 14:04:07.203  INFO 7180 --- [  restartedMain] com.mkyong.SpringBootWebApplication      : Starting SpringBootWebApplication on MKYONG-WIN10 with PID 7180 (C:\spring-boot\spring-boot-examples\spring-boot-web-thymeleaf\target\classes started by mkyong in C:\spring-boot\spring-boot-examples\spring-boot-web-thymeleaf)
2016-12-03 14:04:07.205  INFO 7180 --- [  restartedMain] com.mkyong.SpringBootWebApplication      : No active profile set, falling back to default profiles: default
2016-12-03 14:04:07.392  INFO 7180 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@67af925a: startup date [Sat Dec 03 14:04:07 SGT 2016]; root of context hierarchy
2017-04-27 11:18:06.053 DEBUG 22591 --- [nio-8080-exec-1] com.mkyong.WelcomeController            : 
		Welcome AppProperties{
			error='/error/', 
			menus=[Menu{name='Home', 
			path='/', title='Home'}, 
			Menu{
				name='Login', 
				path='/login', 
				title='Login'}], 
			compiler=Compiler{
				timeout='5', 
				outputFolder='/temp/'}}, 
			GlobalProperties{
				threadPool=5, 
				email='test@mkyong.com'
				}

```



### Accede a tu http://localhost:8080

### Construye un ejecutable JAR

```
$ mvn clean package

...
[INFO] ------------------------------------------------------------------------
[INFO] Building Spring Boot Web Thymeleaf Example 1.0
[INFO] ------------------------------------------------------------------------
...
[INFO] --- maven-jar-plugin:2.6:jar (default-jar) @ spring-boot-web-thymeleaf ---
[INFO] Building jar: C:\spring-boot\spring-boot-examples\spring-boot-web-thymeleaf\target\spring-boot-web-thymeleaf-1.0.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:1.4.2.RELEASE:repackage (default) @ spring-boot-web-thymeleaf ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.797 s
[INFO] Finished at: 2016-12-03T14:06:45+08:00
[INFO] Final Memory: 21M/437M
[INFO] ------------------------------------------------------------------------
```

### Ejecuta el siguiente comando y vuelve a ingresar a tu http://localhost:8080

```
$ java -jar target/spring-boot-web-thymeleaf-1.0.jar
```


## Construido con:

* [Maven](https://maven.apache.org/) - Manejador de Dependencias
* [Spring y Spring Boot](https://spring.io/) - Contenedor de inversión de control

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Mkyong](https://github.com/DjSystemBPM/Mkyong). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*
