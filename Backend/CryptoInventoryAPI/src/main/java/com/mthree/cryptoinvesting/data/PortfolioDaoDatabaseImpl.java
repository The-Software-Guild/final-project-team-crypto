package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */

@Repository
public class PortfolioDaoDatabaseImpl implements PortfolioDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getAllCryptos(int userId) {
        final String SQL_GET_USER_PORTFOLIO_BY_USER_ID = "SELECT * FROM portfolio WHERE userID = ?";
        try {
            Portfolio retrievedPortfolio = jdbcTemplate.queryForObject(SQL_GET_USER_PORTFOLIO_BY_USER_ID, new PortfolioMapper(), userId);
            List<String> allCryptos = cryptosAsString(retrievedPortfolio);
            return allCryptos;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private List<String> cryptosAsString(Portfolio portfolio) {
        List<String> cryptos = new ArrayList<>();
        cryptos.add("BTC : " + portfolio.getBTC());
        cryptos.add("ETH : " + portfolio.getETH());
        cryptos.add("BNB : " + portfolio.getBNB());
        cryptos.add("ADA : " + portfolio.getADA());
        cryptos.add("SOL : " + portfolio.getSOL());
        cryptos.add("DOGE : " + portfolio.getDOGE());
        return cryptos;
    }

    @Override
    @Transactional
    public Portfolio addPortfolio(Portfolio portfolio) {
        final String SQL_INSERT_PORTFOLIO = "INSERT INTO portfolio(userId) VALUES (?)";
        jdbcTemplate.update(SQL_INSERT_PORTFOLIO, portfolio.getUserId());

        int newPortfolioId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        portfolio.setPortfolioId(newPortfolioId);
        return portfolio;
    }

    @Override
    public Portfolio updatePortfolio(Orders order) {
        final String SQL_SELECT_PORTFOLIO = "SELECT * FROM portfolio WHERE portfolioId = ?";
        try {
            Portfolio retrievedPortfolio = jdbcTemplate.queryForObject(SQL_SELECT_PORTFOLIO, new PortfolioMapper(), order.getPortfolioId());
            String orderType = order.getCryptoName();
            switch (orderType) {
                case "BTC":
                    float currentBTC = retrievedPortfolio.getBTC();
                    retrievedPortfolio.setBTC(currentBTC + order.getAmount());
                    break;
                case "ETH":
                    float currentETH = retrievedPortfolio.getETH();
                    retrievedPortfolio.setETH(currentETH + order.getAmount());
                    break;
                case "BNB":
                    float currentBNB = retrievedPortfolio.getBNB();
                    retrievedPortfolio.setBNB(currentBNB + order.getAmount());
                    break;
                case "ADA":
                    float currentADA = retrievedPortfolio.getADA();
                    retrievedPortfolio.setADA(currentADA + order.getAmount());
                    break;
                case "SOL":
                    float currentSOL = retrievedPortfolio.getSOL();
                    retrievedPortfolio.setSOL(currentSOL + order.getAmount());
                    break;
                case "DOGE":
                    float currentDOGE = retrievedPortfolio.getDOGE();
                    retrievedPortfolio.setDOGE(currentDOGE + order.getAmount());
                    break;
                default:
                    return null;
            }
            final String SQL_UPDATE_PORTFOLIO = "UPDATE portfolio SET BTC = ?, ETH = ?, BNB = ?, ADA = ?, SOL = ?, DOGE = ? WHERE portfolioId = ?";
            jdbcTemplate.update(SQL_UPDATE_PORTFOLIO, retrievedPortfolio.getBTC(), retrievedPortfolio.getETH(), retrievedPortfolio.getBNB(), retrievedPortfolio.getADA(), retrievedPortfolio.getSOL(), retrievedPortfolio.getDOGE(), retrievedPortfolio.getPortfolioId());
            return retrievedPortfolio;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public Portfolio sellCrypto(Orders order) {
        final String SQL_SELECT_PORTFOLIO = "SELECT * FROM portfolio WHERE portfolioId = ?";
        try {
            Portfolio retrievedPortfolio = jdbcTemplate.queryForObject(SQL_SELECT_PORTFOLIO, new PortfolioMapper(), order.getPortfolioId());
            String orderType = order.getCryptoName();
            switch (orderType) {
                case "BTC":
                    float currentBTC = retrievedPortfolio.getBTC();
                    retrievedPortfolio.setBTC(currentBTC - order.getAmount());
                    break;
                case "ETH":
                    float currentETH = retrievedPortfolio.getETH();
                    retrievedPortfolio.setETH(currentETH - order.getAmount());
                    break;
                case "BNB":
                    float currentBNB = retrievedPortfolio.getBNB();
                    retrievedPortfolio.setBNB(currentBNB - order.getAmount());
                    break;
                case "ADA":
                    float currentADA = retrievedPortfolio.getADA();
                    retrievedPortfolio.setADA(currentADA - order.getAmount());
                    break;
                case "SOL":
                    float currentSOL = retrievedPortfolio.getSOL();
                    retrievedPortfolio.setSOL(currentSOL - order.getAmount());
                    break;
                case "DOGE":
                    float currentDOGE = retrievedPortfolio.getDOGE();
                    retrievedPortfolio.setDOGE(currentDOGE - order.getAmount());
                    break;
                default:
                    return null;
            }
            final String SQL_UPDATE_PORTFOLIO = "UPDATE portfolio SET BTC = ?, ETH = ?, BNB = ?, ADA = ?, SOL = ?, DOGE = ? WHERE portfolioId = ?";
            jdbcTemplate.update(SQL_UPDATE_PORTFOLIO, retrievedPortfolio.getBTC(), retrievedPortfolio.getETH(), retrievedPortfolio.getBNB(), retrievedPortfolio.getADA(), retrievedPortfolio.getSOL(), retrievedPortfolio.getDOGE(), retrievedPortfolio.getPortfolioId());
            return retrievedPortfolio;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public static final class PortfolioMapper implements RowMapper<Portfolio> {

        @Override
        public Portfolio mapRow(ResultSet rs, int index) throws SQLException {

            Portfolio portfolio = new Portfolio();
            portfolio.setPortfolioId(rs.getInt("portfolioId"));
            portfolio.setUserId(rs.getInt("userId"));
            portfolio.setBTC(rs.getFloat("BTC"));
            portfolio.setETH(rs.getFloat("ETH"));
            portfolio.setBNB(rs.getFloat("BNB"));
            portfolio.setADA(rs.getFloat("ADA"));
            portfolio.setSOL(rs.getFloat("SOL"));
            portfolio.setDOGE(rs.getFloat("DOGE"));
            return portfolio;

        }

    }

}
