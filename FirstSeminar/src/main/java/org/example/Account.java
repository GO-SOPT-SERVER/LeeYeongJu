package org.example;

class Account {
    private int accountNumber;
    private int total;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.total = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getTotal() {
        return total;
    }

    public void deposit(int money) {
        total += money;
        System.out.println(money + "원이 입금되었습니다.");
    }

    public void withdraw(int money) {
        if (total >= money) {
            total -= money;
            System.out.println(money + "원이 출금되었습니다.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}