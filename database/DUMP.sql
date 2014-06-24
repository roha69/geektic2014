CREATE SEQUENCE PUBLIC.GEEK_SEQ AS INTEGER START WITH 1000
CREATE MEMORY TABLE PUBLIC.GEEK(ID NUMERIC(128) NOT NULL PRIMARY KEY,GENRE VARCHAR(255) NOT NULL, NOM VARCHAR(255) NOT NULL,PRENOM VARCHAR(255) NOT NULL, AGE NUMERIC(3), MAIL VARCHAR(255) )

CREATE SEQUENCE PUBLIC.INTERET_SEQ AS INTEGER START WITH 1000
CREATE MEMORY TABLE PUBLIC.INTERET(ID NUMERIC(128) NOT NULL PRIMARY KEY,NOM VARCHAR(255) NOT NULL)

CREATE MEMORY TABLE PUBLIC.GEEK_INTERET(ID_GEEK NUMERIC(128), ID_INTERET NUMERIC(128), FOREIGN KEY(ID_GEEK) REFERENCES PUBLIC.GEEK(ID),FOREIGN KEY(ID_INTERET) REFERENCES PUBLIC.INTERET(ID))

