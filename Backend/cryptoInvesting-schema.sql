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
    BTC float NOT NULL DEFAULT 0,
    ETH float NOT NULL DEFAULT 0,
    BNB float NOT NULL DEFAULT 0,
    ADA float NOT NULL DEFAULT 0,
    SOL float NOT NULL DEFAULT 0,
    DOGE float NOT NULL DEFAULT 0,
    CONSTRAINT fk_user_portfolio 
    	FOREIGN KEY (userId)
    	REFERENCES user(userId)
		ON DELETE CASCADE
);

CREATE TABLE orders (
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    portfolioId INT,
    cName CHAR(3),
    price FLOAT,
    amount FLOAT,
    date DATETIME,
    CONSTRAINT fk_portfolio_orders 
    	FOREIGN KEY (portfolioId)
    	REFERENCES portfolio(portfolioId)
		ON DELETE CASCADE
);