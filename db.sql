DROP DATABASE IF EXISTS cinecampus;

CREATE DATABASE cinecampus;
USE cinecampus;

CREATE TABLE tipoactor(
    id INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    CONSTRAINT pk_tipoActor PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE genero(
    id INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    CONSTRAINT pk_tipogenero PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE pais(
    id INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    CONSTRAINT pk_tipopais PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE formato(
    id INT AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    CONSTRAINT pk_tipoformato PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE pelicula(
    id INT AUTO_INCREMENT NOT NULL,
    codinterno VARCHAR(5) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    duracion VARCHAR(20) NOT NULL,
    sinopsis TEXT NULL,
    CONSTRAINT pk_pelicula PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE peliculaformato(
    idpelicula INT(11) NOT NULL,
    idformato INT(11) NOT NULL,
    cantidad INT(3) NOT NULL,
    CONSTRAINT pk_peliculaformato PRIMARY KEY(idpelicula, idformato),
    CONSTRAINT fk_peliculaformato FOREIGN KEY (idpelicula) REFERENCES pelicula(id),
    CONSTRAINT fk_formatopelicula FOREIGN KEY(idformato) REFERENCES formato(id) 
)ENGINE=InnoDb;

CREATE TABLE actor(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    idnacionalidad INT(11) NOT NULL,
    edad INT(3) NOT NULL,
    idgenero INT(11) NOT NULL,
    CONSTRAINT pk_actor PRIMARY KEY(id),
    CONSTRAINT fk_nacionalidad FOREIGN KEY (idnacionalidad) REFERENCES pais(id),
    CONSTRAINT fk_genero FOREIGN KEY (idgenero) REFERENCES genero(id)
)ENGINE=InnoDb;

CREATE TABLE peliculaprotagonista(
    idpelicula INT(11) NOT NULL,
    idprotagonista INT(11) NOT NULL, 
    idtipoactor INT(11) NOT NULL,
    CONSTRAINT pk_pelicualprogagonista PRIMARY KEY (idpelicula, idprotagonista),
    CONSTRAINT fk_pelicualprogagonista  FOREIGN KEY (idpelicula) REFERENCES pelicula(id),
    CONSTRAINT fk_protagonistapelicula FOREIGN KEY (idprotagonista) REFERENCES actor(id),
    CONSTRAINT fk_tipoactor FOREIGN KEY (idtipoactor) REFERENCES tipoactor(id)
)ENGINE=InnoDb;