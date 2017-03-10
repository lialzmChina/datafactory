package org.fluttercode.datafactory;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by A on 2017/3/9.
 */
public class ConnToolsTest {

    @Test
    public void connectionTest() {
        ConnTools.makeConnection();
    }

    @Test
    public void batchUpdate() {
        Connection connection = ConnTools.makeConnection();
        QueryRunner queryRunner = new QueryRunner();
        Object[][] params = new Object[1000][];
        for (int i = 0; i < 1000; i++) {
            params[i] = new Object[]{i,"a",""};
        }
        try {
            queryRunner.insertBatch(connection, "insert into BOOK values(?,?)", new ColumnListHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbUtils.closeQuietly(connection);
    }

}
