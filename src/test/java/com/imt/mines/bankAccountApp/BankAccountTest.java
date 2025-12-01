package com.imt.mines.bankAccountApp;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;


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
        // dépôt normal
        bankAccount.depositMoney(200);
        assertEquals(5200, bankAccount.getBalance(), 0f);
    }

    @Test
    public void test_withdraw_happy_path() {
        // retrait valide
        boolean success = bankAccount.withdrawMoney(200);
        assertTrue(success);
        assertEquals(4800, bankAccount.getBalance(), 0f);
    }

    @Test
    public void test_deposit_edge_case() {
        // dépôt négatif -> rien ne change
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

    @Test
    public void test_constructor_with_params() throws Exception {
        String personData = "Alice\nF\n30\n170.0\n65.0\nblonde\nblue\nalice@example.com";

        BankAccount acc = new BankAccount(1, 1000.0, 500.0, "01/01/2020", personData);

        assertNotNull(acc);
        assertEquals(1, acc.getAccountNumber());
        assertEquals(1000.0, acc.getBalance(), 0.01);
        assertEquals(500.0, acc.getWithdrawLimit(), 0.01);
        assertEquals("01/01/2020", acc.getDateCreated());

        Person holder = acc.getAccountHolder();
        assertNotNull(holder);
        assertEquals("Alice", holder.getName());
        assertEquals('F', holder.getGender());
        assertEquals(30, holder.getAge());
        assertEquals(170.0f, holder.getHeight(), 0.01f);
        assertEquals(65.0f, holder.getWeight(), 0.01f);
        assertEquals("blonde", holder.getHairColor());
        assertEquals("blue", holder.getEyeColor());
        assertEquals("alice@example.com", holder.getEmail());
    }

    @Test
    public void test_setWithdrawLimit() {
        BankAccount account = new BankAccount();
        account.setWithdrawLimit(1000.0);
        assertEquals(1000.0, account.getWithdrawLimit(), 0.001);
    }

    //@Test
    /*public void test_loadFromText_shouldLoadAccounts() {
        BankAccount bankAccount = new BankAccount();
        String path = Paths.get("src/test/java/com/imt/mines/bankAccountApp/testAccounts.txt").toAbsolutePath().toString();
        System.out.println("Chemin absolu fichier : " + path);
        File f = new File(path);
        System.out.println("Fichier existe ? " + f.exists());
        int result = bankAccount.loadFromText(path);

        assertEquals(1, result); // on attend 1 compte chargé
    }*/
}
