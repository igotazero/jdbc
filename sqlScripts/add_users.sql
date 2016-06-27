INSERT INTO Users (Login, Password, Name, Adress) VALUES ('one', 'pass', 'Andrew', '753159');

CREATE TABLE dates (d DATE);

INSERT INTO dates (d) VALUES ('06.27.2016 15:49:26');
INSERT INTO dates (d) VALUES (SYSDATE);
SELECT TO_CHAR(d, 'DD.MM.YYYY HH24:MI:SS') FROM DATES;

SELECT * FROM Products;