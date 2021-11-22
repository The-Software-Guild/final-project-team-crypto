package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.TestApplicationConfiguration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class OrderDaoDatabaseImplTest {

    @Autowired
    private JdbcTemplate jdbcTest;

    @Autowired
    OrderDao orderTest;

    @Before
    public void setUp() {
        final String SQL_RUN_SCRIPT = "cryptoinvesting-test-schema.sql";
        jdbcTest.update(SQL_RUN_SCRIPT);
    }

}