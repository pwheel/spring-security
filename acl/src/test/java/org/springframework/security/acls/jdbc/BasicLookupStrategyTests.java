package org.springframework.security.acls.jdbc;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Tests {@link BasicLookupStrategy} with Acl Class type id not specified.
 *
 * @author Andrei Stefan
 * @author Paul Wheeler
 */
public class BasicLookupStrategyTests extends AbstractBasicLookupStrategyTests {
    private static final BasicLookupStrategyTestsDbHelper DATABASE_HELPER = new BasicLookupStrategyTestsDbHelper();


    @BeforeClass
    public static void createDatabase() throws Exception {
        DATABASE_HELPER.createDatabase();
    }

    @AfterClass
    public static void dropDatabase() throws Exception {
        DATABASE_HELPER.getDataSource().destroy();
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return DATABASE_HELPER.getJdbcTemplate();
    }

    @Override
    public DataSource getDataSource() {
        return DATABASE_HELPER.getDataSource();
    }
}
