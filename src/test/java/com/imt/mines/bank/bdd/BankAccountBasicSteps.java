package com.imt.mines.bank.bdd;

import static org.junit.Assert.assertEquals;
import com.imt.mines.bankAccountApp.BankAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class BankAccountBasicSteps {
    private BankAccount account;
    private double observedBalance;

    @Given("I have a new bank account")
    public void i_have_a_new_bank_account() {
        account = new BankAccount();
    }

    @When("I check its balance")
    public void i_check_its_balance() {
        observedBalance = account.getBalance();
    }

    @Then("the balance should be {int}")
    public void the_balance_should_be(Integer expected) {
        assertEquals(expected.doubleValue(), observedBalance, 0.0001);
    }
}
