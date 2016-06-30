DELETE FROM Users;
SELECT * FROM Users;

DELETE FROM Products;
SELECT * FROM Products;

DELETE FROM Bids;
SELECT * FROM Bids;

/*1) Add* all users*/
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('koshi', '753159', 'Koshi', 'Paris');
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('riemann', 'pass', 'Riemann', 'Paris');
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('fibonachi', '1.1.2.3.5.8', 'Fibonachi', 'Italy, Piza');

/*2) Create new user*/
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('perelmann', 'candy', 'Perelmann', 'Russia');

/*3) Get user by login*/
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('viett', 'myTheoremIsSoCool', 'Viett', 'Paris');

/*4) Change user data*/
INSERT INTO Users (LOGIN, PASSWORD, NAME, ADDRESS) VALUES ('agent', 'pass', '', '');

/*5) Add products*/
INSERT INTO Products (ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) 
VALUES (111, 'koshi', 'Mixer', 'Just mixer to mix everything', 1500, 100, 24, TO_DATE('2016-06-29 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 0);

INSERT INTO Products (ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) 
VALUES (112, 'koshi', 'Coca-Cola', 'If you want to drink', 50, 10, 24, TO_DATE('2016-06-29 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 0);

INSERT INTO Products (ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) 
VALUES (113, 'perelmann', 'Cat', 'Black cat. To avenge the enemies.', 2000, 100, 24, TO_DATE('2016-06-29 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 0);

/*6) Search by substring*/
INSERT INTO Products (ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) 
VALUES (113, 'riemann', 'Diesel generator', 'You want to be powerfull? By the diesel!', 5600, 100, 24, TO_DATE('2016-06-29 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 0);

/*7) Search Product by ID*/
INSERT INTO Products (ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) 
VALUES (114, 'koshi', 'Table', 'Just table', 1650, 50, 24, TO_DATE('2016-06-29 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

    /*8) Search Product by seller*/
INSERT INTO Products (ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) 
VALUES (115, 'agent', 'Table', 'Nothing', 1650, 50, 24, TO_DATE('2016-06-29 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

/*10) Get Bids by Product*/
INSERT INTO Bids (ID, USERLOGIN, PRODUCTID, BID) VALUES (111, 'koshi', 9, 1700);
INSERT INTO Bids (ID, USERLOGIN, PRODUCTID, BID) VALUES (112, 'koshi', 9, 1750);
INSERT INTO Bids (ID, USERLOGIN, PRODUCTID, BID) VALUES (113, 'koshi', 9, 1800);

/*13. Best Bid*/
INSERT INTO Bids (ID, USERLOGIN, PRODUCTID, BID) VALUES (116, 'koshi', 9, 2200);