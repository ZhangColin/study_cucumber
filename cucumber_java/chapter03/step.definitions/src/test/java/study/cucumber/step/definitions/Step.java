package study.cucumber.step.definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class Step {
	@Given("^I have deposited \\$(\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(int amount) throws Throwable {
	    new Account(amount);
	}

	@When("^I request \\$(\\d+)$")
	public void iRequest$(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	public class Account{
		public Account(int openingBalance){
			
		}
	}
}


