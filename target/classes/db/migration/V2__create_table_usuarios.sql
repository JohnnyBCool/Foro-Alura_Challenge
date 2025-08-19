CREATE TABLE usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR (255) NOT NULL,
    correoElectronico VARCHAR (100) NOT NULL UNIQUE,
    contrasena VARCHAR (100) NOT NULL unique ,
    perfiles BIGINT NOT NULL,
    PRIMARY KEY(id)

    );