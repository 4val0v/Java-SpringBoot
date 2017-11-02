package com.codingdojo.bankaccount;

class BankAccountTest {

    public static void main(String []args) {
        BankAccount account = new BankAccount();
        System.out.println(account.getAccountNumber());
        account.deposit(200, "checking");
        account.deposit(2000, "savings");
        System.out.println(account.getCheckingBalance());
        System.out.println(account.getSavingsBalance());
        account.deposit(20000, "investment"); // print error
        account.withdraw(100, "checking");
        account.withdraw(1000, "savings");
        account.withdraw(1001, "savings"); // print error
        System.out.println(account.checkBalance());
    }

}
