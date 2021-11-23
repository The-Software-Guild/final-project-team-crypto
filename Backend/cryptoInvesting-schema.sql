DROP DATABASE IF EXISTS cryptoInvesting;

CREATE DATABASE cryptoInvesting;

USE cryptoInvesting;

CREATE TABLE user (
	userId INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE portfolio (
    portfolioId INT PRIMARY KEY AUTO_INCREMENT,
    userId INT,
    BTC FLOAT NOT NULL DEFAULT 0,
    ETH FLOAT NOT NULL DEFAULT 0,
    BNB FLOAT NOT NULL DEFAULT 0,
    ADA FLOAT NOT NULL DEFAULT 0,
    DOGE FLOAT NOT NULL DEFAULT 0,
    CONSTRAINT fk_user_portfolio 
    	FOREIGN KEY (userId)
    	REFERENCES user(userId)
		ON DELETE CASCADE
);

CREATE TABLE orders (
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    portfolioId INT,
    cName VARCHAR(5),
    price FLOAT,
    amount FLOAT,
    purchaseDate DATETIME,
	dateSold DATETIME,
    CONSTRAINT fk_portfolio_orders 
    	FOREIGN KEY (portfolioId)
    	REFERENCES portfolio(portfolioId)
		ON DELETE CASCADE
);

CREATE TABLE market (
    ticker VARCHAR(5) NOT NULL,
    price FLOAT NOT NULL DEFAULT 0
    
);
insert into market (ticker, price) values ("BTC", 0);
insert into market (ticker, price) values ("ETH", 0);
insert into market (ticker, price) values ("BNB", 0);
insert into market (ticker, price) values ("ADA", 0);
insert into market (ticker, price) values ("DOGE", 0);

insert into user (username, password) values ("Miguel", "1234");
insert into user (username, password) values ("Chelsey", "9632");
insert into user (username, password) values ("Kristi", "54321");
insert into user (username, password) values ("Will", "54624");