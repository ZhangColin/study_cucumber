package nickbank;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/28.
 */
public class AccountRepository {
    public static Account get(int number){
        try {
            Connection conn = ConnTools.makeConnection();
            QueryRunner runner = new QueryRunner();
            Map<String, Object> result = null;
            result = runner.query(conn, "select * from accounts where number=?", new MapHandler(), number);
            DbUtils.closeQuietly(conn);
            BigDecimal balance = (BigDecimal)result.get("balance");
            Account account = new Account(number);
            account.setBalance(new Money(balance.toString()));
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static void insert(Account account){
        try {
            Connection conn = ConnTools.makeConnection();
            QueryRunner runner = new QueryRunner();
            runner.update(conn, "insert into accounts(number, balance) values("+
                    account.getNumber()+", "
                    +account.getBalance().yuans()+"."+
                    account.getBalance().cents()+")");
            DbUtils.closeQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Account account){
        try {
            Connection conn = ConnTools.makeConnection();
            QueryRunner runner = new QueryRunner();
            runner.update(conn, "update accounts set balance="+
                    account.getBalance().yuans()+"."+account.getBalance().cents()+
                    " where number="+account.getNumber());
            DbUtils.closeQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAll(){
        try {
            Connection conn = ConnTools.makeConnection();
            QueryRunner runner = new QueryRunner();
            runner.update(conn, "delete from accounts");
            DbUtils.closeQuietly(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
