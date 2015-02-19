DELIMITER $$

INSERT INTO 
Rol(borrado, nombre)
VALUES
(0, 'administrador'),
(0, 'viajero');

INSERT INTO 
Usuario(borrado, apellido, clave, email, nombres, telefono, rol_id)
VALUES
(0,'Perez', '1', '1', 'adminNumero1', 12341234, 1),
(0,'Gomez', 'adminpassw', 'admin@admin', 'adminNumero2', 29384742, 1),
(0, 'Diaz', '2', '2', 'viajeroNumero2', 43214321, 2),
(0, 'Rodriguez', 'viajeropassw', 'viajero@viajero', 'viajeroNumero2', 43214321, 2);

INSERT INTO
Evento(borrado, descripcion, fecha, horaComienzo, horaFin, latLng, lugar, nombre)
VALUES
(0, 'Evento anual que se hace una vez por año', '2015-05-01', '12:00:00', '17:30:00', '(-34.9270629, -57.949481)', 'Un Lugar', 'JAIIO'),
(0, 'Lo mejor que podes pedir', '2015-10-01', '08:00:00', '12:00:00', '(-34.9245066, -57.9478665)', 'Otro Lugar', 'PHP Conference');
$$