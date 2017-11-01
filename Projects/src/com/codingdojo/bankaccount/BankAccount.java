package com.codingdojo.bankaccount;
import java.util.Random;
import java.lang.StringBuilder;

class BankAccount {

    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts;
    private static int accounts_total;

    public BankAccount() {
        accountNumber = generateAccountNumber();
        checkingBalance = 0;
        savingsBalance = 0;
        accounts++;
    }

    public String generateAccountNumber() {
        Random random = new Random();
        String digits = "0123456789";

        StringBuilder numbers = new StringBuilder(""); // better than concat
        for (int i = 0; i < 10; i++) {
            numbers.append(digits.charAt(random.nextInt(digits.length())));
        }

        return numbers.toString(); // converts SB object to String type
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(double amount, String account) {
        if (account == "checking") {
            this.checkingBalance += amount;
            accounts_total += amount;
        }
        else if (account == "savings") {
            this.savingsBalance += amount;
            accounts_total += amount;
        }
        else {
            System.out.println("Error: Unspecified account type (options are 'checking' or 'savings').");
        }
    }

    public double withdraw(double amount, String account) {
        double zero = 0;
        if (account == "checking") {
            if (this.checkingBalance < amount) {
                System.out.println("Error: Insufficient funds.");
                return zero;
            }
            else {
                this.checkingBalance -= amount;
                return amount;
            }
        }
        if (account == "savings") {
            if (this.savingsBalance < amount) {
                System.out.println("Error: Insufficient funds.");
                return zero;
            }
            else {
                this.savingsBalance -= amount;
                return amount;
            }
        }
        else {
            System.out.println("Error: Unspecified account type (use 'checking' or 'savings').");
            return zero;
        }
    }

    public String checkBalance() {
        return "Checking: " + checkingBalance + "; Savings: " + savingsBalance;
    }

}
