DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE PRODUCTS CASCADE CONSTRAINTS;
DROP TABLE BIDS CASCADE CONSTRAINTS;

/*Create tables*/
CREATE TABLE Users(
login VARCHAR2(30),
password VARCHAR2(100) NOT NULL,
Name VARCHAR2(100),
Address VARCHAR2(100),
PRIMARY KEY (login));

CREATE TABLE Products (
id INT,
sellerID VARCHAR2(30),
Name VARCHAR2(200) NOT NULL,
Description VARCHAR2(400),
Price NUMBER NOT NULL,
Gap NUMBER,
Hours INT,
StartBiddingDate DATE,
BuyNow NUMBER,
PRIMARY KEY (id), 
FOREIGN KEY (sellerID) REFERENCES Users (login),
CONSTRAINT bool CHECK (BuyNow IN (0, 1)));

CREATE TABLE Bids(
id INT,
userLogin VARCHAR2(30) NOT NULL,
productId INT NOT NULL,
bid NUMBER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (userLogin) REFERENCES Users (login),
FOREIGN KEY (productId) REFERENCES Products (id),
CONSTRAINT unique_bid_string UNIQUE (userLogin, productId, bid));