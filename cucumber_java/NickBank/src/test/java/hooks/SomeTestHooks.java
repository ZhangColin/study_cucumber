package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SomeTestHooks {
    @Before
    public void beforeCallingScenario(){
        System.out.println("********** 场景开始 **********");
    }

    @After
    public void afterRunningScenario(Scenario scenario){
        System.out.println("********** 场景结束 "+scenario.getStatus()+" **********");
    }

    @Before("@admin")
    public void logInAsAdmin(){
        System.out.println("********** logInAsAdmin **********");
    }
}
