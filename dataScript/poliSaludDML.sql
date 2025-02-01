-- database: ../database/PoliSalud.db

/* 
Autor: Grupo G2 2025 
Clase: Programacion 2
Este script inserta valores escenciales y ejemplos respectivos
en las tablas principales de la base de datos del PoliSalud
*/

INSERT INTO CatalogoPersonaTipo(nombre,fechaModificacion)
    VALUES   ('Sexo', DATETIME('now', 'localtime'))
            ,('Estado Civil', DATETIME('now', 'localtime'))
            ,('Rol', DATETIME('now', 'localtime'))
            ,('Especialidad', DATETIME('now', 'localtime'));

INSERT INTO CatalogoPersona(nombre,idCatalogoPersonaTipo,fechaModificacion)
    VALUES   ('Masculino', 1, DATETIME('now', 'localtime'))
            ,('Feminido', 1, DATETIME('now', 'localtime'))
            ,('No definido', 1, DATETIME('now', 'localtime'))
            ,('Soltero', 2, DATETIME('now', 'localtime'))
            ,('Casado', 2, DATETIME('now', 'localtime'))
            ,('Viudo', 2, DATETIME('now', 'localtime'))
            ,('Divorciado', 2, DATETIME('now', 'localtime'))
            ,('Union Libre', 2, DATETIME('now', 'localtime'))
            ,('Paciente', 3, DATETIME('now', 'localtime'))
            ,('Doctor', 3, DATETIME('now', 'localtime'))
            ,('Administrativo', 3, DATETIME('now', 'localtime'))
            ,('Alergologia', 4, DATETIME('now', 'localtime'))
            ,('Anestesiologia', 4, DATETIME('now', 'localtime'))
            ,('Dermatologia', 4, DATETIME('now', 'localtime'))
            ,('Medicina de Emergencias', 4, DATETIME('now', 'localtime'))
            ,('Medicina General', 4, DATETIME('now', 'localtime'))
            ,('Neurologia', 4, DATETIME('now', 'localtime'))
            ,('Obestetricia y Ginecologia', 4, DATETIME('now', 'localtime'))
            ,('Cirugia', 4, DATETIME('now', 'localtime'))
            ,('Pediatria', 4, DATETIME('now', 'localtime'))
            ,('Gastroenterologia', 4, DATETIME('now', 'localtime'))
            ,('No Especialidad', 4, DATETIME('now', 'localtime'));

INSERT INTO Persona (nombre, apellido, cedula, idSexo, idEstadoCivil, idRol, edad, direccion, fechaModificacion, idEspecialidad)
    VALUES  ('Juan', 'Carlos', '0000000001', 1, 4, 10, 25, 'Calle 1', DATETIME('now', 'localtime'), 12),
            ('María', 'González', '0000000002', 2, 5, 10, 30, 'Calle 2', DATETIME('now', 'localtime'),13),
            ('Pedro', 'Pérez', '0000000003', 1, 6, 11, 22, 'Calle 3', DATETIME('now', 'localtime'), 22),
            ('Ana', 'Martínez', '0000000004', 2, 7, 9, 28, 'Calle 4', DATETIME('now', 'localtime'), 22),
            ('Luis', 'Hernández', '0000000005', 1, 8, 10, 35, 'Calle 5', DATETIME('now', 'localtime'), 14),
            ('Laura', 'López', '0000000006', 3, 4, 11, 40, 'Calle 6', DATETIME('now', 'localtime'), 22),
            ('Carlos', 'García', '0000000007', 1, 5, 9, 19, 'Calle 7', DATETIME('now', 'localtime'), 22),
            ('Sofía', 'Rodríguez', '0000000008', 2, 6, 10, 23, 'Calle 8', DATETIME('now', 'localtime'), 15),
            ('Javier', 'Fernández', '0000000009', 1, 7, 11, 32, 'Calle 9', DATETIME('now', 'localtime'), 22),
            ('Isabel', 'Martín', '0000000010', 2, 8, 9, 29, 'Calle 10', DATETIME('now', 'localtime'), 22),
            ('Andrés', 'Jiménez', '0000000011', 1, 4, 10, 27, 'Calle 11', DATETIME('now', 'localtime'), 16),
            ('Claudia', 'Mendoza', '0000000012', 3, 5, 11, 21, 'Calle 12', DATETIME('now', 'localtime'), 22),
            ('Diego', 'Castillo', '0000000013', 1, 6, 9, 34, 'Calle 13', DATETIME('now', 'localtime'), 22),
            ('Valentina', 'Salazar', '0000000014', 2, 7, 10, 26, 'Calle 14', DATETIME('now', 'localtime'),17),
            ('Fernando', 'Morales', '0000000015', 1, 8, 11, 31, 'Calle 15', DATETIME('now', 'localtime'), 22),
            ('Camila', 'Rojas', '0000000016', 2, 4, 9, 24, 'Calle 16', DATETIME('now', 'localtime'), 22),
            ('Gabriel', 'Cruz', '0000000017', 1, 5, 10, 20, 'Calle 17', DATETIME('now', 'localtime'),18),
            ('Natalia', 'Vargas', '0000000018', 2, 6, 11, 33, 'Calle 18', DATETIME('now', 'localtime'), 22),
            ('Ricardo', 'Ponce', '0000000019', 1, 7, 9, 36, 'Calle 19', DATETIME('now', 'localtime'), 22),
            ('Lucía', 'Soto', '0000000020', 2, 8, 10, 38, 'Calle 20', DATETIME('now', 'localtime'),19),
            ('Samuel', 'Díaz', '0000000021', 1, 4, 11, 39, 'Calle 21', DATETIME('now', 'localtime'), 22),
            ('Mariana', 'Cano', '0000000022', 2, 5, 9, 22, 'Calle 22', DATETIME('now', 'localtime'), 22),
            ('Hugo', 'Ceballos', '0000000023', 1, 6, 10, 30, 'Calle 23', DATETIME('now', 'localtime'),20),
            ('Paola', 'Gómez', '0000000024', 3, 7, 11, 27, 'Calle 24', DATETIME('now', 'localtime'), 22),
            ('Esteban', 'Pérez', '0000000025', 1, 8, 9, 28, 'Calle 25', DATETIME('now', 'localtime'), 22),
            ('Tatiana', 'Ríos', '0000000026', 2, 4, 10, 31, 'Calle 26', DATETIME('now', 'localtime'), 21),
            ('Jorge', 'Salinas', '0000000027', 1, 5, 11, 35, 'Calle 27', DATETIME('now', 'localtime'), 22),
            ('Diana', 'Córdoba', '0000000028', 2, 6, 9, 23, 'Calle 28', DATETIME('now', 'localtime'), 22),
            ('Felipe', 'Quintero', '0000000029', 1, 7, 10, 29, 'Calle 29', DATETIME('now', 'localtime'),12),
            ('Santiago', 'Alvarez', '0000000031', 1, 4, 9, 26, 'Calle 30', DATETIME('now', 'localtime'), 22),
            ('Valeria', 'Cárdenas', '0000000032', 2, 5, 10, 24, 'Calle 31', DATETIME('now', 'localtime'),13),
            ('Nicolás', 'Bermúdez', '0000000033', 1, 6, 11, 30, 'Calle 32', DATETIME('now', 'localtime'), 22),
            ('Gabriela', 'Patiño', '0000000034', 2, 7, 9, 22, 'Calle 33', DATETIME('now', 'localtime'), 22),
            ('Cristian', 'Gonzalez', '0000000035', 1, 8, 10, 29, 'Calle 34', DATETIME('now', 'localtime'),14),
            ('Marisol', 'Castaño', '0000000036', 2, 4, 11, 31, 'Calle 35', DATETIME('now', 'localtime'), 22),
            ('Leonardo', 'Sierra', '0000000037', 1, 5, 9, 33, 'Calle 36', DATETIME('now', 'localtime'), 22),
            ('Mónica', 'Pérez', '0000000038', 2, 6, 10, 25, 'Calle 37', DATETIME('now', 'localtime'),15),
            ('Julián', 'Cruz', '0000000039', 1, 7, 11, 34, 'Calle 38', DATETIME('now', 'localtime'), 22),
            ('Silvia', 'Hernández', '0000000040', 2, 8, 9, 36, 'Calle 39', DATETIME('now', 'localtime'), 22),
            ('Emilio', 'Rivas', '0000000041', 1, 4, 10, 38, 'Calle 40', DATETIME('now', 'localtime'),16),
            ('Patricia', 'Salas', '0000000042', 2, 5, 11, 39, 'Calle 41', DATETIME('now', 'localtime'), 22),
            ('Alberto', 'Maldonado', '0000000043', 1, 6, 9, 40, 'Calle 42', DATETIME('now', 'localtime'), 22),
            ('Claudia', 'Ceballos', '0000000044', 2, 7, 10, 41, 'Calle 43', DATETIME('now', 'localtime'),17),
            ('Ricardo', 'González', '0000000045', 1, 8, 11, 42, 'Calle 44', DATETIME('now', 'localtime'), 22),
            ('Verónica', 'Sánchez', '0000000046', 2, 4, 9, 43, 'Calle 45', DATETIME('now', 'localtime'), 22),
            ('Héctor', 'Mora', '0000000047', 1, 5, 10, 44, 'Calle 46', DATETIME('now', 'localtime'),18),
            ('Lina', 'Rojas', '0000000048', 2, 6, 11, 45, 'Calle 47', DATETIME('now', 'localtime'), 22),
            ('Diego', 'Cruz', '0000000049', 1, 7, 9, 46, 'Calle 48', DATETIME('now', 'localtime'), 22),
            ('Natalia', 'García', '0000000050', 2, 8, 10, 47, 'Calle 49', DATETIME('now', 'localtime'),19),
            ('Timmy', 'Turner', '0000000030', 2, 8, 10, 47, 'Calle 50', DATETIME('now', 'localtime'),20);

INSERT INTO Telefono (numero, idPersona, fechaModificacion) 
    VALUES  (0903908201, 1, DATETIME('now', 'localtime')),
            (0903908202, 2, DATETIME('now', 'localtime')),
            (0903908203, 3, DATETIME('now', 'localtime')),
            (0903908204, 4, DATETIME('now', 'localtime')),
            (0903908205, 5, DATETIME('now', 'localtime')),
            (0903908206, 6, DATETIME('now', 'localtime')),
            (0903908207, 7, DATETIME('now', 'localtime')),
            (0903908208, 8, DATETIME('now', 'localtime')),
            (0903908209, 9, DATETIME('now', 'localtime')),
            (0903908210, 10, DATETIME('now', 'localtime')),
            (0903908211, 11, DATETIME('now', 'localtime')),
            (0903908212, 12, DATETIME('now', 'localtime')),
            (0903908213, 13, DATETIME('now', 'localtime')),
            (0903908214, 14, DATETIME('now', 'localtime')),
            (0903908215, 15, DATETIME('now', 'localtime')),
            (0903908216, 16, DATETIME('now', 'localtime')),
            (0903908217, 17, DATETIME('now', 'localtime')),
            (0903908218, 18, DATETIME('now', 'localtime')),
            (0903908219, 19, DATETIME('now', 'localtime')),
            (0903908220, 20, DATETIME('now', 'localtime')),
            (0903908221, 21, DATETIME('now', 'localtime')),
            (0903908222, 22, DATETIME('now', 'localtime')),
            (0903908223, 23, DATETIME('now', 'localtime')),
            (0903908224, 24, DATETIME('now', 'localtime')),
            (0903908225, 25, DATETIME('now', 'localtime')),
            (0903908226, 26, DATETIME('now', 'localtime')),
            (0903908227, 27, DATETIME('now', 'localtime')),
            (0903908228, 28, DATETIME('now', 'localtime')),
            (0903908229, 29, DATETIME('now', 'localtime')),
            (0903908230, 30, DATETIME('now', 'localtime')),
            (0903908231, 31, DATETIME('now', 'localtime')),
            (0903908232, 32, DATETIME('now', 'localtime')),
            (0903908233, 33, DATETIME('now', 'localtime')),
            (0903908234, 34, DATETIME('now', 'localtime')),
            (0903908235, 35, DATETIME('now', 'localtime')),
            (0903908236, 36, DATETIME('now', 'localtime')),
            (0903908237, 37, DATETIME('now', 'localtime')),
            (0903908238, 38, DATETIME('now', 'localtime')),
            (0903908239, 39, DATETIME('now', 'localtime')),
            (0903908240, 40, DATETIME('now', 'localtime')),
            (0903908241, 41, DATETIME('now', 'localtime')),
            (0903908242, 42, DATETIME('now', 'localtime')),
            (0903908243, 43, DATETIME('now', 'localtime')),
            (0903908244, 44, DATETIME('now', 'localtime')),
            (0903908245, 45, DATETIME('now', 'localtime')),
            (0903908246, 46, DATETIME('now', 'localtime')),
            (0903908247, 47, DATETIME('now', 'localtime')),
            (0903908248, 48, DATETIME('now', 'localtime')),
            (0903908249, 49, DATETIME('now', 'localtime')),
            (0903908250, 50, DATETIME('now', 'localtime'));

INSERT INTO CorreoElectronico (correo, idPersona, fechaModificacion) 
    VALUES  ('juanito123@epn.edu.ec', 1, DATETIME('now', 'localtime')),
            ('maria_gonzalez@epn.edu.ec', 2, DATETIME('now', 'localtime')),
            ('pedro.perez@epn.edu.ec', 3, DATETIME('now', 'localtime')),
            ('ana.martinez@epn.edu.ec', 4, DATETIME('now', 'localtime')),
            ('luis_hernandez@epn.edu.ec', 5, DATETIME('now', 'localtime')),
            ('sofia.rodriguez@epn.edu.ec', 6, DATETIME('now', 'localtime')),
            ('carlos.garcia@epn.edu.ec', 7, DATETIME('now', 'localtime')),
            ('valentina.sanchez@epn.edu.ec', 8, DATETIME('now', 'localtime')),
            ('javier.fernandez@epn.edu.ec', 9, DATETIME('now', 'localtime')),
            ('isabel.martin@epn.edu.ec', 10, DATETIME('now', 'localtime')),
            ('andres.jimenez@epn.edu.ec', 11, DATETIME('now', 'localtime')),
            ('claudia.mendoza@epn.edu.ec', 12, DATETIME('now', 'localtime')),
            ('diego.castillo@epn.edu.ec', 13, DATETIME('now', 'localtime')),
            ('rayuela1980@epn.edu.ec', 14, DATETIME('now', 'localtime')),
            ('elquijote1605@epn.edu.ec', 15, DATETIME('now', 'localtime')),
            ('fede.morales@epn.edu.ec', 16, DATETIME('now', 'localtime')),
            ('camila.rojas@epn.edu.ec', 17, DATETIME('now', 'localtime')),
            ('gabriel.cruz@epn.edu.ec', 18, DATETIME('now', 'localtime')),
            ('natalia.vargas@epn.edu.ec', 19, DATETIME('now', 'localtime')),
            ('ricardo.ponce@epn.edu.ec', 20, DATETIME('now', 'localtime')),
            ('lucia.soto@epn.edu.ec', 21, DATETIME('now', 'localtime')),
            ('samuel.diaz@epn.edu.ec', 22, DATETIME('now', 'localtime')),
            ('mariana.cano@epn.edu.ec', 23, DATETIME('now', 'localtime')),
            ('hugo.ceballos@epn.edu.ec', 24, DATETIME('now', 'localtime')),
            ('paola.gomez@epn.edu.ec', 25, DATETIME('now', 'localtime')),
            ('esteban.perez@epn.edu.ec', 26, DATETIME('now', 'localtime')),
            ('tatiana.rios@epn.edu.ec', 27, DATETIME('now', 'localtime')),
            ('jorge.salinas@epn.edu.ec', 28, DATETIME('now', 'localtime')),
            ('diana.cordoba@epn.edu.ec', 29, DATETIME('now', 'localtime')),
            ('felipe.quintero@epn.edu.ec', 31, DATETIME('now', 'localtime')),
            ('carolina.mora@epn.edu.ec', 32, DATETIME('now', 'localtime')),
            ('santiago.alvarez@epn.edu.ec', 32, DATETIME('now', 'localtime')),
            ('valeria.cardenas@epn.edu.ec', 34, DATETIME('now', 'localtime')),
            ('nicolas.bermudez@epn.edu.ec', 35, DATETIME('now', 'localtime')),
            ('gabriela.patino@epn.edu.ec', 36, DATETIME('now', 'localtime')),
            ('cristian.gonzalez@epn.edu.ec', 37, DATETIME('now', 'localtime')),
            ('monica.perez@epn.edu.ec', 38, DATETIME('now', 'localtime')),
            ('julian.cruz@epn.edu.ec', 39, DATETIME('now', 'localtime')),
            ('silvia.hernandez@epn.edu.ec', 40, DATETIME('now', 'localtime')),
            ('emilio.rivas@epn.edu.ec', 41, DATETIME('now', 'localtime')),
            ('patricia.salas@epn.edu.ec', 42, DATETIME('now', 'localtime')),
            ('alberto.maldonado@epn.edu.ec', 43, DATETIME('now', 'localtime')),
            ('claudia.ceballos@epn.edu.ec', 44, DATETIME('now', 'localtime')),
            ('ricardo.gonzalez@epn.edu.ec', 45, DATETIME('now', 'localtime')),
            ('veronica.sanchez@epn.edu.ec', 46, DATETIME('now', 'localtime')),
            ('hector.mora@epn.edu.ec', 47, DATETIME('now', 'localtime')),
            ('lina.rojas@epn.edu.ec', 48, DATETIME('now', 'localtime')),
            ('diego.cruz@epn.edu.ec', 49, DATETIME('now', 'localtime')),
            ('natalia.garcia@epn.edu.ec', 50, DATETIME('now', 'localtime')),
            ('timmy.turner@epn.edu.ec', 30, DATETIME('now', 'localtime'));

INSERT INTO HoraCita (hora, fechaModificacion)
    VALUES  ('8:00 TO 8:30', DATETIME('now', 'localtime')),
            ('8:30 TO 9:00', DATETIME('now', 'localtime')),
            ('9:00 TO 9:30', DATETIME('now', 'localtime')),
            ('9:30 TO 10:00', DATETIME('now', 'localtime')),
            ('10:00 TO 10:30', DATETIME('now', 'localtime')),
            ('10:30 TO 11:00', DATETIME('now', 'localtime')),
            ('11:00 TO 11:30', DATETIME('now', 'localtime')),
            ('11:30 TO 12:00', DATETIME('now', 'localtime')),
            ('12:00 TO 12:30', DATETIME('now', 'localtime')),
            ('12:30 TO 13:00', DATETIME('now', 'localtime')),
            ('13:00 TO 13:30', DATETIME('now', 'localtime')),
            ('13:30 TO 14:00', DATETIME('now', 'localtime')),
            ('14:00 TO 14:30', DATETIME('now', 'localtime')),
            ('14:30 TO 15:00', DATETIME('now', 'localtime')),
            ('15:00 TO 15:30', DATETIME('now', 'localtime')),
            ('15:30 TO 16:00', DATETIME('now', 'localtime')),
            ('16:00 TO 16:30', DATETIME('now', 'localtime')),
            ('16:30 TO 17:00', DATETIME('now', 'localtime'));

INSERT INTO EstadoCita (nombre, descripcion,fechaModificacion) 
    VALUES  ('A', 'Agendada', DATETIME('now', 'localtime')),
            ('C', 'Cumplida' , DATETIME('now', 'localtime')),
            ('N', 'No Cumplida', DATETIME('now', 'localtime'));

INSERT INTO Cita (idPersonaPaciente, idPersonaDoctor, fechaCita, idHoraCita, observacion, idEstadoCita, fechaModificacion) 
    VALUES   (4, 1,  '2023-01-01', 1,  NULL, 2, DATETIME('now', 'localtime'))
            ,(7, 2,  '2023-01-02', 2,  NULL, 1, DATETIME('now', 'localtime'))
            ,(10, 5,  '2023-01-03', 3,  NULL, 3, DATETIME('now', 'localtime'))
            ,(13, 8,  '2023-01-04', 4,  NULL, 2, DATETIME('now', 'localtime'))
            ,(16, 11,  '2023-01-05', 5,  NULL, 1, DATETIME('now', 'localtime'))
            ,(19, 14,  '2023-01-06', 6,  NULL, 2, DATETIME('now', 'localtime'))
            ,(22, 17,  '2023-01-07', 7,  NULL, 3, DATETIME('now', 'localtime'))
            ,(25, 20,  '2023-01-08', 8,  NULL, 1, DATETIME('now', 'localtime'))
            ,(28, 23,  '2023-01-09', 9,  NULL, 2, DATETIME('now', 'localtime'))
            ,(30, 26, '2023-01-10', 10, NULL, 3, DATETIME('now', 'localtime'))
            ,(33, 29, '2023-01-11', 11, NULL, 1, DATETIME('now', 'localtime'))
            ,(36, 31, '2023-01-12', 12, NULL, 2, DATETIME('now', 'localtime'))
            ,(39, 34, '2023-01-13', 13, NULL, 3, DATETIME('now', 'localtime'))
            ,(42, 37, '2023-01-14', 14, NULL, 1, DATETIME('now', 'localtime'))
            ,(45, 40, '2023-01-15', 15, NULL, 2, DATETIME('now', 'localtime'))
            ,(48, 43, '2023-01-16', 16, NULL, 3, DATETIME('now', 'localtime'))
            ,(4, 46, '2023-01-17', 17, NULL, 1, DATETIME('now', 'localtime'))
            ,(7, 49, '2023-01-18', 18, NULL, 2, DATETIME('now', 'localtime'))
            ,(10, 50, '2023-01-19', 1,  NULL, 3, DATETIME('now', 'localtime'))
            ,(13, 1, '2023-01-20', 2,  NULL, 1, DATETIME('now', 'localtime'))
            ,(16, 2, '2023-01-21', 3,  NULL, 2, DATETIME('now', 'localtime'))
            ,(19, 5, '2023-01-22', 4,  NULL, 3, DATETIME('now', 'localtime'))
            ,(22, 8, '2023-01-23', 5,  NULL, 1, DATETIME('now', 'localtime'))
            ,(25, 11, '2023-01-24', 6,  NULL, 2, DATETIME('now', 'localtime'))
            ,(28, 14, '2023-01-25', 7,  NULL, 3, DATETIME('now', 'localtime'))
            ,(30, 17, '2023-01-26', 8,  NULL, 1, DATETIME('now', 'localtime'))
            ,(33, 20, '2023-01-27', 9,  NULL, 2, DATETIME('now', 'localtime'))
            ,(36, 23, '2023-01-28', 10, NULL, 3, DATETIME('now', 'localtime'))
            ,(39, 26, '2023-01-29', 11, NULL, 1, DATETIME('now', 'localtime'))
            ,(42, 29, '2023-01-30', 12, NULL, 2, DATETIME('now', 'localtime'))
            ,(45, 31, '2023-01-31', 13, NULL, 3, DATETIME('now', 'localtime'))
            ,(48, 34, '2023-02-01', 14, NULL, 1, DATETIME('now', 'localtime'))
            ,(4, 37, '2023-02-02', 15, NULL, 2, DATETIME('now', 'localtime'))
            ,(7, 40, '2023-02-03', 16, NULL, 3, DATETIME('now', 'localtime'))
            ,(10, 43, '2023-02-04', 17, NULL, 1, DATETIME('now', 'localtime'))
            ,(13, 46, '2023-02-05', 18, NULL, 2, DATETIME('now', 'localtime'))
            ,(16, 49, '2023-02-06', 1,  NULL, 3, DATETIME('now', 'localtime'))
            ,(19, 50, '2023-02-07', 2,  NULL, 1, DATETIME('now', 'localtime'))
            ,(22, 1, '2023-02-08', 3,  NULL, 2, DATETIME('now', 'localtime'))
            ,(25, 2, '2023-02-09', 4, NULL, 3, DATETIME('now', 'localtime'))
            ,(28, 5,  '2023-02-10', 5,  NULL, 1, DATETIME('now', 'localtime'))
            ,(30, 8,  '2023-02-11', 6,  NULL, 2, DATETIME('now', 'localtime'))
            ,(33, 11,  '2023-02-12', 7,  NULL, 3, DATETIME('now', 'localtime'))
            ,(36, 14,  '2023-02-13', 8,  NULL, 1, DATETIME('now', 'localtime'))
            ,(39, 17,  '2023-02-14', 9,  NULL, 2, DATETIME('now', 'localtime'))
            ,(42, 20,  '2023-02-15', 10 ,NULL, 3, DATETIME('now', 'localtime'))
            ,(45, 23,  '2023-02-16', 11 ,NULL, 1, DATETIME('now', 'localtime'))
            ,(48, 26,  '2023-02-17', 12 ,NULL, 2, DATETIME('now', 'localtime'))
            ,(48, 29,  '2023-02-18', 13, NULL, 3, DATETIME('now', 'localtime'))
            ,(48, 31, '2023-02-19', 14, NULL, 1, DATETIME('now', 'localtime'));

SELECT idHoraCita
        ,hora
        ,estado
        ,fechaCreacion        ,fechaModificacion
        FROM HoraCita
        WHERE   Estado ='A';

DROP VIEW IF EXISTS vista_tabla_cita;
CREATE VIEW vista_tabla_cita AS
SELECT
    c.idCita            as Cita,
    idD.nombre          as NombreDoctor,
    idD.apellido        as ApellidoDoctor,
    idP.nombre          as NombrePaciente,
    idP.apellido        as ApellidoPaciente,
    ho.hora             as HoraCita,
    c.observacion       as Observacion,
    ec.nombre           as EstadoCita
FROM Cita c
INNER JOIN Persona as idD ON c.idPersonaDoctor = idD.idPersona
INNER JOIN Persona as idP ON c.idPersonaPaciente = idP.idPersona
INNER JOIN HoraCita as ho ON c.idHoraCita = ho.idHoraCita
INNER JOIN EstadoCita as ec ON c.idEstadoCita = ec.idEstadoCita;