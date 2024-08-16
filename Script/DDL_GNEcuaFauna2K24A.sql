--database: ../database/GNEcuaFauna2K24A.sqlite

/*
CopyRight
autor : olivia_nay
fecha : 14agost2024
descripcion: Crear las entidades del sistema de un hormiguero
*/

DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS Alimento;
DROP TABLE IF EXISTS GenoAlimento;
DROP TABLE IF EXISTS IngestaNativa;
DROP TABLE IF EXISTS Sexo;
DROP TABLE IF EXISTS Provincia;
DROP TABLE IF EXISTS Region;
DROP TABLE IF EXISTS Pais;

-- Crear tablas

CREATE TABLE Pais
(
    IdPais                INTEGER PRIMARY KEY AUTOINCREMENT
   ,Nombre                VARCHAR(50) NOT NULL
   ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
   ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
   ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))
);

CREATE TABLE Region
(
   IdRegion              INTEGER PRIMARY KEY AUTOINCREMENT
   ,IdPais                INTEGER NOT NULL
   ,Nombre                VARCHAR(50) NOT NULL
   ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
   ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
   ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))
   -- Clave foránea
   ,FOREIGN KEY (IdPais) REFERENCES Pais (IdPais)
);

CREATE TABLE Provincia
(
   IdProvincia           INTEGER PRIMARY KEY AUTOINCREMENT
   ,IdRegion              INTEGER NOT NULL
   ,Nombre                VARCHAR(50) NOT NULL
   ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
   ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
   ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))

   -- Clave foránea
   ,FOREIGN KEY (IdRegion) REFERENCES Region (IdRegion)
);

CREATE TABLE Sexo
(
   IdSexo                INTEGER PRIMARY KEY AUTOINCREMENT
  ,Genero                VARCHAR(50) NOT NULL
  ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
  ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
  ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))
);

CREATE TABLE IngestaNativa
(
   IdIngestaNativa       INTEGER PRIMARY KEY AUTOINCREMENT
   ,TipoNombre            VARCHAR(30) NOT NULL
   ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
   ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
   ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))
);

CREATE TABLE GenoAlimento
(
   IdGenoAlimento        INTEGER PRIMARY KEY AUTOINCREMENT
   ,TipoGeno              VARCHAR(5) NOT NULL
   ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
   ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
   ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))
);

CREATE TABLE Alimento
(
   IdAlimento            INTEGER PRIMARY KEY AUTOINCREMENT
   ,IdIngestaNativa       INTEGER NOT NULL
   ,IdGenoAlimento        INTEGER NOT NULL
   ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
   ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
   ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))

   -- Claves foráneas
   ,FOREIGN KEY (IdIngestaNativa) REFERENCES IngestaNativa (IdIngestaNativa)
   ,FOREIGN KEY (IdGenoAlimento) REFERENCES GenoAlimento (IdGenoAlimento)
);

CREATE TABLE Hormiga
(
   IdHormiga             INTEGER PRIMARY KEY AUTOINCREMENT
   ,IdSexo                INTEGER NOT NULL
   ,IdProvincia           INTEGER NOT NULL
   ,IdAlimento            INTEGER NOT NULL
   ,TipoHormiga           VARCHAR(50) NOT NULL
   ,EstadoHormiga         VARCHAR(50) NOT NULL
   
   
   ,Estado                VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('A', 'X'))
   ,FechaCrea             DATETIME DEFAULT (datetime('now', '-5 hours'))
   ,FechaModificacion     DATETIME DEFAULT (datetime('now', '-5 hours'))

   -- Claves foráneas
   ,FOREIGN KEY (IdSexo) REFERENCES Sexo (IdSexo)
   ,FOREIGN KEY (IdProvincia) REFERENCES Provincia (IdProvincia)
   ,FOREIGN KEY (IdAlimento) REFERENCES Alimento (IdAlimento)
);
