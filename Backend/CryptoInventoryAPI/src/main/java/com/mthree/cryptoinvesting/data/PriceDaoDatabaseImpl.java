package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PriceDaoDatabaseImpl implements PriceDao{
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public boolean updatePrice(Price price) {
        final String sql = "UPDATE market SET "
                + "price = ? "
                + "WHERE ticker = ?;";
        return jdbcTemplate.update(sql, price.getPrice(), price.getTicker()) > 0;
    }

    @Override
    public List<Price> getAllPrices() {
        final String SQL_SELECT_ALL_PRICES = "SELECT * FROM market";
        return jdbcTemplate.query(SQL_SELECT_ALL_PRICES, new PriceMapper());
    }

    @Override
    public Price getPriceByTicker(String ticker) {
        final String SQL_SELECT_PRICE_BY_TICKER = "SELECT * FROM market WHERE ticker = ?";
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PRICE_BY_TICKER, new PriceMapper(), ticker);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public static final class PriceMapper implements RowMapper<Price> {

        @Override
        public Price mapRow(ResultSet rs, int index) throws SQLException {

            Price price = new Price();
            price.setTicker(rs.getString("ticker"));
            price.setPrice(rs.getFloat("price"));
            return price;

        }

    }
}
