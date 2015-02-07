DELIMITER $$

INSERT INTO 
Rol(borrado, nombre)
VALUES
(0, 'administrador'),
(0, 'viajero');

INSERT INTO 
Usuario(borrado, apellido, clave, email, nombres, telefono, rol_id)
VALUES
(0,'unApellido', 'adminpassw', 'admin@admin', 'unNombre', 12341234, 1),
(0, 'otroApellido', 'viajeropassw', 'viajero@viajero', 'otroNombre', 43214321, 2),
(0, 'xx', '1','1','xx', 121212, 2),
(0, 'admin', '2','2','admin',11221122,1);

INSERT INTO
Evento(borrado, descripcion, fecha, horaComienzo, horaFin, latLng, lugar, nombre)
VALUES
(0, 'reunion info-familiar', '2015-10-01', '12:00:00', '17:30:00', '(-34.9270629, -57.949481)', 'el quinchito papa', 'JAIIO'),
(0, 'muy divertido', '2015-10-01', '12:00:00', '17:30:00', '(-34.9245066, -57.9478665)', 'ese lugar', 'Otro evento');

$$