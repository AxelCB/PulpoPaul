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
(0, 'otroApellido', 'viajeropassw', 'viajero@viajero', 'otroNombre', 43214321, 2);

$$