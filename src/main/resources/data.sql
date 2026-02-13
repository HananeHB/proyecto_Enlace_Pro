INSERT INTO IDIOMAS (nombre, fecha_creacion) VALUES
('Árabe', CURRENT_TIMESTAMP),
('Rumano', CURRENT_TIMESTAMP),
('Chino Mandarín', CURRENT_TIMESTAMP);

INSERT INTO ALUMNOS (nombre, apellidos, email, numero_telefono, fecha_creacion, direccion, idioma_id) VALUES
('Mohamed', 'Al-Sayed', 'mohamed.alsayed@example.com', '600123456', CURRENT_TIMESTAMP, 'Calle del Desierto 12', 1),
('Fatima', 'Hassan', 'fatima.hassan@example.com', '600234567', CURRENT_TIMESTAMP, 'Avenida del Oasis 34', 1),
('Juan', 'Pérez', 'juan.perez@example.com', '600345678', CURRENT_TIMESTAMP, 'Calle Europa 56', 2),
('Elena', 'Popescu', 'elena.popescu@example.com', '600456789', CURRENT_TIMESTAMP, 'Avenida Transilvania 78', 2),
('Li', 'Wei', 'li.wei@example.com', '600567890', CURRENT_TIMESTAMP, 'Calle Dragón 90', 3),
('Mei', 'Ling', 'mei.ling@example.com', '600678901', CURRENT_TIMESTAMP, 'Avenida Flor de Loto 21', 3),
('Omar', 'Khalid', 'omar.khalid@example.com', '600789012', CURRENT_TIMESTAMP, 'Calle Palmeras 15', 1),
('Andrei', 'Ionescu', 'andrei.ionescu@example.com', '600890123', CURRENT_TIMESTAMP, 'Avenida Dacia 8', 2),
('Zhang', 'Hua', 'zhang.hua@example.com', '600901234', CURRENT_TIMESTAMP, 'Calle del Bambú 33', 3);

INSERT INTO USUARIOS (id, firstname, lastname, email, password, role ) VALUES 
(1,'user', 'user', 'user@a.com', '$2a$12$PB6GwcJCu44g/T895VObduyyMGsX.Rl/QN0kU/IY0l9HOPokGJBpe', 'USER'),
(2,'admin', 'admin', 'admin@a.com', '$2a$12$crH/Tuxn/3in7inhgLzoiOTfaXm2sLQy5alm0pwlBXu2z./MzwTMW', 'ADMIN');

ALTER TABLE ALUMNOS ALTER COLUMN id RESTART WITH 10;
ALTER TABLE IDIOMAS ALTER COLUMN id RESTART WITH 4;