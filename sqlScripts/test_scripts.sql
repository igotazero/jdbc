DELETE FROM Users;
SELECT * FROM Users;

/*1) Add* all users*/
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('koshi', '753159', 'Koshi', 'Paris');
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('riemann', 'pass', 'Riemann', 'Paris');
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('fibonachi', '1.1.2.3.5.8', 'Fibonachi', 'Italy, Piza');

/*2) Create new user*/
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('koshi', '753159', 'Koshi', 'Paris');

/*3) Get user by login*/
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('viett', 'myTheoremIsSoCool', 'Viett', 'Paris');