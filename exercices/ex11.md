package com.imt.mines.bankAccountApp;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    String name = "John";
    char gender = 'm';
    int age = 22;
    int weight = 190;
    float height = 172;
    String hairColor = "brown";
    String eyeColor = "green";
    String email = "jufm@gmail.com";

    int assignAccountNumber = 0;
    int initMoneyAmount = 5000;
    int withdrawLimit = 700;
    String dateCreated = "05/21/2019";
    BankAccount bankAccount = null;
    Person accountHolder = null;

    @Before
    public void setup() {
        try {
            accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bankAccount = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
    }

    @Test
    public void test_deposit_happy_path() {
        //dépot normal
        bankAccount.depositMoney(200);
        assertEquals(5200, bankAccount.getBalance(), 0f);
    }

    @Test
    public void test_withdraw_happy_path() {
        //retrait valide
        boolean success = bankAccount.withdrawMoney(200);
        assertTrue(success);
        assertEquals(4800, bankAccount.getBalance(), 0f);
    }

    @Test
    public void test_deposit_edge_case() {
        // dépot négatif -> rien ne change
        bankAccount.depositMoney(-100);
        assertEquals(5000, bankAccount.getBalance(), 0f);
    }

    @Test
    public void test_withdraw_edge_case() {
        // retrait supérieur au solde
        boolean success = bankAccount.withdrawMoney(6000);
        assertFalse(success);
        assertEquals(5000, bankAccount.getBalance(), 0f);
    }

}
