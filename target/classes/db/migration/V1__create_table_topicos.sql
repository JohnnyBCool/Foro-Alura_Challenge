CREATE TABLE topicos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR (255) NOT NULL,
    mensaje VARCHAR (1025) NOT NULL,
    fechaCreacion datetime NOT NULL,
    status VARCHAR (100) NOT NULL,
    autor VARCHAR (100) NOT NULL,
    curso VARCHAR (100) NOT NULL,
    respuestas VARCHAR (225) NOT NULL,
    tag VARCHAR (100) NOT NULL,
    PRIMARY KEY(id)

    );