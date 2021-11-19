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
        return null;
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
