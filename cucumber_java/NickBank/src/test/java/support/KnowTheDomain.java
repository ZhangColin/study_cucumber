package support;

import nickbank.Account;
import nickbank.AccountRepository;
import nickbank.CashSlot;
import nickbank.Teller;
import org.javalite.activejdbc.Base;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.sql.SQLException;


/**
 * Created by Administrator on 2016/3/19.
 */
public class KnowTheDomain {
    private Account _myAccount;

    public KnowTheDomain() throws SQLException {
        try{
            /*Instrumentation instrumentation = new Instrumentation();
            instrumentation.setOutputDirectory("target/classes");
            instrumentation.instrument();*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*if (!Base.hasConnection()){
            Base.open("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller",
                    "password");
            try {
                Base.connection().setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

        AccountRepository.deleteAll();
    }

    private static KnowTheDomain _helper;
    public static KnowTheDomain getHelper()  {
        if (_helper == null){
            try {
                _helper = new KnowTheDomain();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return _helper;
    }

    public Account getMyAccount() {
        if (_myAccount==null){
            _myAccount = new Account(1234);
            AccountRepository.insert(_myAccount);
        }
        else{
            _myAccount = AccountRepository.get(_myAccount.getNumber());
        }

        return _myAccount;
    }

    private CashSlot _cashSlot;

    public CashSlot getCashSlot(){
        if (_cashSlot==null){
            _cashSlot = new CashSlot();
        }

        return _cashSlot;
    }

    private Teller _teller;

    public Teller getTeller(){
        if (_teller==null){
            _teller = new AtmUserInterface();
        }

        return _teller;
    }

    private EventFiringWebDriver _webDriver;

    public EventFiringWebDriver getWebDriver(){
        if (_webDriver==null){
            _webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }

        return _webDriver;
    }
}
