PulpoPaul
=========
PulpoPaul es la versión de InfoPool(Car Pooling) creada por Santiago Ruta y Axel Collard Bovy para la Cátedra de Taller de Tecnologías de Producción de Software, opción Java, de la Universidad Nacional de La Plata Argentina.

La misma permite a sus usuarios cargar eventos y recorridos y sumarse al recorrido de otros usuarios, para coordinar viajes hacia o desde la facultad, o hacia algun evento, para de esta forma ahorrar dinero, combustible, reducir la contaminación y tráfico producidos por la alta cantidad de vehículos en las calles.

El sistema tiene incorporado, además, un sistema de mensajería entre usuarios, y de recomendaciones y denuncias, las cuales deberán ser tratadas por un administrador.

IMPORTANTE
==========

->Ejecutar la consulta presente en el archivo WebContent/WEB-INF/SQL/scrip_inicial.sql para generar los usuarios para poder comenzar


ACLARACIONES
============

->Para loguearse como administrador usar el usuario "plokioRS@gmail.com" y password "1"

->Las funcionalidades no implementadas(que no se pedian para esta entrega) redireccionan a una pagina que indica esta situacion

->En la seccion de administradores:

-->En "Denuncias" se muestran las  denuncias de los viajeros a otros viajeros y a recorridos

-->En "Eventos Académicos" se muestran los eventos dados de alta y se pueden dar da alta mas eventos

->En la seccion de viajeros:

-->En "Buscar Recorridos" solo se muestran los recorridos en los cuales no participo y de los cuales no soy el propietario

-->En "Mis Recorridos" se muestran los recorridos de los cuales soy propietario

-->En "Historial" se muestran los recorridos de los cuales soy participante

-->En "Bandeja de entrada" se muestran los mensaje recibidos

->Cuando un pasajero solicita ser participante de un viaje, al propietario le llega un mensaje en la bandeja de entrada en el cual debe decidir si lo acepta o no

->Cuando el propietario acepta o rechaza al pasajero este es notificado con un mensaje en su bandeja de entrada

->Cada vez que se hace una denuncia se envia un mail a los administradores

->Para ver los mails se creo la cuenta de correo "plokioRS@gmail.com" con password "qwerty1234."

->Un propietario puede denunciar a las personas que viajan en sus recorridos

->Un pasajero puede denunciar a las personas que viajan con ella y a los recorridos en los que es participante
