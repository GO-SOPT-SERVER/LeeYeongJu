package org.example;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("개설된 계좌가 없습니다.");
        } else {
            System.out.println("==== 전체 계좌 조회 ====");
            for (Account account : accounts) {
                System.out.println("계좌번호: " + account.getAccountNumber() + ", 잔액: " + account.getTotal() + "원");
            }
        }
    }

    public void openAccount(int accountNumber) {
        Account account = new Account(accountNumber);
        accounts.add(account);
        System.out.println("계좌가 개설되었습니다. 계좌번호: " + accountNumber);
    }

    public void depositToAccount(int accountNumber, int money) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(money);
        } else {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        }
    }

    public void withdrawFromAccount(int accountNumber, int money) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(money);
        } else {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        }
    }

    public void displayAccountBalance(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("계좌번호: " + account.getAccountNumber() + ", 잔액: " + account.getTotal() + "원");
        } else {
            System.out.println("해당 계좌를 찾을 수 없습니다.");
        }
    }

    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}