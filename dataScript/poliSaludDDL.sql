-- database: ../database/PoliSalud.db

/*
Autor: Chugá Juan 2025 
Clase: Programacion 2
Este script crea las tablas principales de la base de datos del PoliSalud
*/

    DROP TABLE IF EXISTS Cita;
    DROP TABLE IF EXISTS EstadoCita;
    DROP TABLE IF EXISTS HoraCita;
    DROP TABLE IF EXISTS CorreoElectronico;
    DROP TABLE IF EXISTS Telefono;
    DROP TABLE IF EXISTS Persona;
    DROP TABLE IF EXISTS CatalogoPersona;
    DROP TABLE IF EXISTS CatalogoPersonaTipo;

    CREATE TABLE CatalogoPersonaTipo (
    idCatalogoPersonaTipo INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre TEXT NOT NULL UNIQUE
    ,estado CHARACTER(1) DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    );

    CREATE TABLE CatalogoPersona (
    idCatalogoPersona INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre TEXT NOT NULL UNIQUE
    ,estado CHARACTER(1) DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    ,idCatalogoPersonaTipo INTEGER NOT NULL
    ,FOREIGN KEY (idCatalogoPersonaTipo) REFERENCES CatalogoPersonaTipo(idCatalogoPersonaTipo)
    );

    CREATE TABLE Persona (
    idPersona INTEGER PRIMARY KEY
    ,nombre TEXT NOT NULL 
    ,apellido TEXT NOT NULL 
    ,cedula TEXT NOT NULL UNIQUE
    ,idSexo INTEGER NOT NULL
    ,idEstadoCivil INTEGER NOT NULL
    ,idRol INTEGER NOT NULL
    ,idEspecialidad INTEGER DEFAULT(22)
    ,edad INTEGER NOT NULL
    ,direccion TEXT NOT NULL
    ,estado CHARACTER(1) DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    ,FOREIGN KEY (idSexo) REFERENCES CatalogoPersona(idCatalogoPersona)
    ,FOREIGN KEY (idEstadoCivil) REFERENCES CatalogoPersona(idCatalogoPersona)
    ,FOREIGN KEY (idRol) REFERENCES CatalogoPersona(idCatalogoPersona)
    ,FOREIGN KEY (idEspecialidad) REFERENCES CatalogoPersona(idCatalogoPersona)
    );

    CREATE TABLE Telefono(
    idTelefono INTEGER PRIMARY KEY AUTOINCREMENT
    ,numero TEXT NOT NULL UNIQUE
    ,idPersona INTEGER NOT NULL
    ,estado CHARACTER(1) DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    ,FOREIGN KEY (idPersona) REFERENCES Persona(idPersona)
    );

    CREATE TABLE CorreoElectronico(
    idCorreo INTEGER PRIMARY KEY AUTOINCREMENT
    ,correo TEXT NOT NULL UNIQUE
    ,idPersona INTEGER NOT NULL
    ,estado CHARACTER(1) DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    ,FOREIGN KEY (idPersona) REFERENCES Persona(idPersona)
    );

    CREATE TABLE HoraCita (
    idHoraCita INTEGER PRIMARY KEY AUTOINCREMENT
    ,hora TEXT NOT NULL UNIQUE
    ,estado CHARACTER(1) DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    );

    CREATE TABLE EstadoCita(
    idEstadoCita INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre CHARACTER(1) NOT NULL UNIQUE
    ,descripcion TEXT NOT NULL
    ,estado CHARACTER(1) DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    );

    CREATE TABLE Cita (
    idCita INTEGER PRIMARY KEY AUTOINCREMENT
    ,idPersonaDoctor INTEGER NOT NULL
    ,idPersonaPaciente INTEGER NOT NULL
    ,fechaCita DATETIME NOT NULL
    ,idHoraCita INTEGER NOT NULL
    ,observacion TEXT 
    ,idEstadoCita INTEGER DEFAULT('A')
    ,fechaCreacion DATETIME DEFAULT(DATETIME('now', 'localtime'))
    ,fechaModificacion DATETIME NOT NULL
    ,FOREIGN KEY (idPersonaDoctor) REFERENCES Persona(idPersona)
    ,FOREIGN KEY (idPersonaPaciente) REFERENCES Persona(idPersona)
    ,FOREIGN KEY (idHoraCita) REFERENCES HoraCita(idHoraCita)
    ,FOREIGN KEY (idEstadoCita) REFERENCES EstadoCita(idEstadoCita)
    );