# TallerMicroservicios

Link parte #1 del taller: https://youtu.be/FQmoRAPW2Zs

Link parte #2 del taller: https://youtu.be/cyno281aiHA

# Integrantes

Andrés Felipe Duarte Leal, Juan Fernando Jaimes Zuluaga

# AVISO

Para revisar el codigo implementado porfavor ingresar a la rama MASTER

Para la primera parte del taller las carpetas correspondientes son SERVER y CLIENTECOUNTRIES

# Instrucciones para la primera parte del taller

Como se puede ver en el video. Se tiene que correr cliente y el servidor

Dentro del cliente va a aparecer un menu para realizar las operaciones correspondientes 
(Consultar, Agregar, Eliminar y Modificar)

Para agregar un paseo se debera digitar por consola la ciudad de origen y de destino, la duracion del viaje y su precio. Lo que debera devolver el servidor un mensaje de que si se pudo agregar o si no se pudo agregar

Para eliminar un paseo se debera poner el ID del paseo para poderlo eliminar, mostrara un mensaje si se pudo eliminar correctamente o no

Para modificar el mensaje se tendra que poner el ID, el destino y origen que se deseean modificar

# Instrucciones segunda parte del taller

Para la segunda parte del taller primero se tiene que instanciar el servidor de eureka, este correra en el puerto 8761

Luego instanciaremos las demas operaciones. Para este caso nosotros instanciamos el SUMADOR en el puerto 9091, el RESTADOR en el puerto 2020, el multiplicador en el 3030 y el divisor en el 4040

Por ultimo instanciamos la CALCULADORA en el puerto 8888

Estas son las operaciones a realizar en el navegador:

-localhost:9091/suma?a=10&b=23&nombre=Andres

-Localhost:2020/resta?a=10&b=5&nombre=Juan

-Localhost:3030/multiplicar?a=10&b=20&nombre=Ana

-Localhost:2020/dividir?a=20&b=2&nombre=Humberto

-Localhost:8888/calculadora/suma?a=10&b=23&nombre=Andres

-Localhost:8888/calculadora/resta?a=10&b=5&nombre=Andres

-Localhost:8888/calculadora/multiplicar?a=10&b=23&nombre=Andres

-Localhost:8888/calculadora/dividir?a=10&b=2&nombre=Andres










