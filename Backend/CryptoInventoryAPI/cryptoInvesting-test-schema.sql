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
                        BTC FLOAT NOT NULL DEFAULT 0,
                        ETH FLOAT NOT NULL DEFAULT 0,
                        BNB FLOAT NOT NULL DEFAULT 0,
                        ADA FLOAT NOT NULL DEFAULT 0,
                        DOGE FLOAT NOT NULL DEFAULT 0
);

insert into market (BTC, ETH, BNB, ADA, DOGE) values (0,0,0,0,0);