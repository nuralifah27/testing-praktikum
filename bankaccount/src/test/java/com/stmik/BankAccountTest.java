package com.stmik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Budi", 100000);
    }

    @Test
    void constructor_validData_setsOwnerAndBalance() {
        assertEquals("Budi", account.getOwner());
        assertEquals(100000, account.getBalance());
    }

    @Test
    void constructor_negativeInitialBalance_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("Budi", -1));
    }

    @Test
    void deposit_validAmount_increasesBalance() {
        account.deposit(50000);
        assertEquals(150000, account.getBalance());
    }

    @Test
    void deposit_zeroAmount_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    void withdraw_validAmount_decreasesBalance() {
        account.withdraw(40000);
        assertEquals(60000, account.getBalance());
    }

    @Test
    void withdraw_exactBalance_resultsInZero() {
        account.withdraw(100000);
        assertEquals(0, account.getBalance());
    }

    @Test
    void withdraw_moreThanBalance_throwsException() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(200000));
    }

    @Test
    void withdraw_negativeAmount_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5));
    }
}