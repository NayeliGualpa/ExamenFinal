--database: ../database/GNEcuaFauna2K24A.sqlite

/*
CopyRight
autor : olivia_nay
fecha : 14agost2024
descripcion:crear el CRUD
*/

 INSERT INTO Pais
 (Nombre) VALUES
 ('Ecuador');

 INSERT INTO Region
 (IdPais, Nombre) VALUES
 ('1'   ,'Costa')
 ,('1'  , 'Sierra')
 ,('1'  , 'Oriente')
 ,('1'  , 'Galápagos');

 INSERT INTO Provincia
 (IdRegion, Nombre) VALUES
 ('1'  , 'Guayas')
 ,('2' , 'Pichincha')
 ,('3' , 'Pastaza')
 ,('4' , 'Galápagos');

 INSERT INTO Sexo
 (Genero) VALUES
 ('Macho')
 ,('Hembra')
 ,('Asexual');

INSERT INTO IngestaNativa
(TipoNombre)VALUES
('Carnívoro')
,('Herbívoro')
,('Omnívoro')
,('Insectívoro');

INSERT INTO GenoAlimento
(TipoGeno)VALUES
('X')
,('XX')
,('XY');

 INSERT INTO Alimento
 (IdIngestaNativa, IdGenoAlimento) VALUES
 ('1'  , '1')
 ,('2' , '2')
 ,('3' , '3')   
 ,('4' , '2');

 INSERT INTO Hormiga
 (IdSexo, IdProvincia, IdAlimento, TipoHormiga, EstadoHormiga) VALUES
 ('3'  , '1' ,'1'  , 'Soldado', 'Larva')
 ,('2' , '2' , '2' , 'Reina'  , 'Adulta')
 ,('1' , '4' , '3' ,'Zángano' , 'Adulta');

    