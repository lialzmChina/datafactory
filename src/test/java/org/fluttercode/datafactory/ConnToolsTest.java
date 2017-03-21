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
    public void insertBatchVcSanitation() {
        Connection connection = ConnTools.makeConnection();
        Long start = System.currentTimeMillis();

        QueryRunner queryRunner = new QueryRunner();
        Object[][] params = null;
        int j = 0;
        //分批插入
        for (int i = 0; i < 10000; i++) {
            if (i % 1000 == 0) {
                if (i != 0) {
                    try {
                        queryRunner.insertBatch(connection, "insert into HY_TAB_VC_SANITATION(id) values(sys_guid())", new ColumnListHandler(), params);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                params = new Object[1000][];
                j = 0;
            }
            params[j] = new Object[]{""};
            j++;
        }
        Long end = System.currentTimeMillis();
        System.out.println((end-start)/1000L);
        DbUtils.closeQuietly(connection);
    }

    @Test
    public void insertBatchVCCard(){
        Connection connection = ConnTools.makeConnection();
        Long start = System.currentTimeMillis();
        QueryRunner queryRunner = new QueryRunner();
        Object[][] params = null;
        int j = 0;
        //分批插入
        for (int i = 0; i < 2000000; i++) {
            if (i % 200000 == 0) {
                if (i != 0) {
                    try {
                        queryRunner.insertBatch(connection, "insert into HY_TAB_VC_CARD (ID, CARD_SEQ, MER_GID, CARD_NO, \n" +
                                "\tACTIVATE_BATCH_ID, MAKECARD_BATCH_ID, CARD_TYPE, VALID, \n" +
                                "\tTRACK, PIN, STATUS, PRELOADEDVALUE, REFILLABLE, \n" +
                                "\tCREATED_DATE, CREATER, MODIFIED_DATE, MODIFIED, \n" +
                                "\tEDITLOCK_DATE, EDITLOCK, ACTIVATE_DATE, ACTIVATION, \n" +
                                "\tORDER_ID, BALANCE, PENDING_BALANCE, IS_MASTERCARD,\n" +
                                "\t CARD_CLASS, CARD_LEVEL, MEM_ID, MER_ID, FAILEDCOUNT, MAXFAILEDATTEMPT, \n" +
                                "\t REMARKS, EXPIRE_DATE, VERIFICATION_CODE_STATUS, PIN_STATUS, DISCOUNTRATE, \n" +
                                "\t IS_DISCOUNT, CARD_IMAGE, RECHARGE_DISCOUNTRATE, GIVE_AMOUNT)\n" +
                                "values (sys_guid(), ?, \n" +
                                "\t'9356343f-7dce-41af-ad6c-67f2d22036f4', ?, null, '20170309132314', '1', '0', '8600003831083063=221299993589', null, '0', 0.00, '0', to_date('09-03-2017 13:23:14', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('14-03-2017 08:44:28', 'dd-mm-yyyy hh24:mi:ss'), '052edef8-956a-4f8e-a112-3e988a1f6eaa', null, null, null, null, '93bc72fb-7e3b-495e-a894-616be7ae320d', 460.47, null, null, '3', null, null, 'd8b9e156-4d7e-4127-b4a2-e0bbf48d9fbc', 0, 3, null, to_date('09-12-2022', 'dd-mm-yyyy'), \n" +
                                "\tnull, '2', 10.00, '1', null, 0.98, 10.00)", new ColumnListHandler(), params);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                params = new Object[200000][];
                j = 0;
            }
            params[j] = new Object[]{i,""+i,""};
            j++;
        }
        Long end = System.currentTimeMillis();
        System.out.println((end-start)/1000L);
        DbUtils.closeQuietly(connection);
    }


    @Test
    public void aa(){
        Connection connection = ConnTools.makeConnection();
        Long start = System.currentTimeMillis();
        QueryRunner queryRunner = new QueryRunner();
        Object[][] params = null;
        int j = 0;
        //分批插入
        for (int i = 0; i < 5000000; i++) {
            if (i % 10000 == 0) {
                if (i != 0) {
                    try {
                        queryRunner.insertBatch(connection, "insert into HY_TAB_VC_TRANS_DATA_FLOW (ID, TRANS_CODE, ORI_TRANS_CODE, CARD_ID, CARD_NO, MER_ID, MEM_ID, TRANS_AMOUNT, BALANCE, TRANS_TYPE, STATUS, TRANS_DATE, TRANS_TER_TYPE, CREATOR, PAY_TYPE, BATCH_NO, CVV2, TID, AUTH_NO, REF_NO, TRANS_NO, EMPID, ITEMID, PAY_AMOUNT, HRT_PAY_AMOUNT, GIVE_AMOUNT, MER_DISCOUNT, HRT_PAY_DATE, PRE_AMOUNT, VC_DISCOUNT)\n" +
                                "values (sys_guid(), " +
                                "'VC20170309145500272886', null, '9388c771-22fc-456e-82ff-7cf94e48a402'," +
                                "'8600001823813022', 'd8b9e156-4d7e-4127-b4a2-e0bbf48d9fbc', " +
                                "'4A349747AC91A3FDE050330A7A8418D5', 1.00, 492.00, '1', '0', to_date('09-03-2017 14:55:06', 'dd-mm-yyyy hh24:mi:ss'), '0', '无', '3', null, null, null, null, null, null, null, null, 1.00, null, null, null, null, 491.00, 0.0000 )", new ColumnListHandler(), params);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                params = new Object[10000][];
                j = 0;
            }
            params[j] = new Object[]{""};
            j++;
        }
        Long end = System.currentTimeMillis();
        System.out.println((end-start)/1000L);
        DbUtils.closeQuietly(connection);
    }

    @Test
    public void insertVcSanitation() {
        Connection connection = ConnTools.makeConnection();
        QueryRunner queryRunner = new QueryRunner();
        for (int i = 0; i < 10000; i++) {
            Object[] params = new Object[1];
            params[0] = "";
            try {
                queryRunner.insert(connection, "insert into HY_TAB_VC_SANITATION(id) values(sys_guid())", new ColumnListHandler(), params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DbUtils.closeQuietly(connection);
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
