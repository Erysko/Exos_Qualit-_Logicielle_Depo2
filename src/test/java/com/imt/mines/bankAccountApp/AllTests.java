package com.imt.mines.bankAccountApp;

import com.imt.mines.bankAccountApp.ACHServiceTest;
import com.imt.mines.bankAccountApp.BankAccountTest;
import com.imt.mines.bankAccountApp.BankTest;
import com.imt.mines.bankAccountApp.PersonTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ACHServiceTest.class, BankAccountTest.class, BankTest.class, PersonTest.class })
public class AllTests {

}
