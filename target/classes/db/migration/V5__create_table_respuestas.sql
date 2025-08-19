CREATE TABLE respuestas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR (1025) NOT NULL,
    topico VARCHAR (100) NOT NULL,
    fechaCreacion datetime NOT NULL,
    autor VARCHAR (100) NOT NULL,
    solucion BIGINT NOT NULL,
    PRIMARY KEY(id)

    );