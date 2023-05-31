package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();
        boolean isExit = false;

        do {
            System.out.println("==== 솝트 은행에 오신 것을 환영합니다! ====");
            System.out.println("0. 전체 계좌 조회");
            System.out.println("1. 계좌 개설");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 잔액 조회");
            System.out.println("5. 종료");
            System.out.print("번호를 입력하세요 : ");

            int selectedMenu = sc.nextInt();

            switch (selectedMenu) {
                case 0: // 전체 계좌 조회
                    bank.showAllAccounts();
                    break;
                case 1: // 계좌 개설
                    System.out.print("계좌번호를 입력하세요: ");
                    int accountNumber = sc.nextInt();
                    bank.openAccount(accountNumber);
                    break;
                case 2: // 입금
                    System.out.print("입금할 계좌번호를 입력하세요: ");
                    int depositAccountNumber = sc.nextInt();
                    System.out.print("입금할 금액을 입력하세요: ");
                    int depositAmount = sc.nextInt();
                    bank.depositToAccount(depositAccountNumber, depositAmount);
                    break;
                case 3: // 출금
                    System.out.print("출금할 계좌번호를 입력하세요: ");
                    int withdrawAccountNumber = sc.nextInt();
                    System.out.print("출금할 금액을 입력하세요: ");
                    int withdrawAmount = sc.nextInt();
                    bank.withdrawFromAccount(withdrawAccountNumber, withdrawAmount);
                    break;
                case 4: // 잔액 조회
                    System.out.print("잔액을 조회할 계좌번호를 입력하세요: ");
                    int balanceAccountNumber = sc.nextInt();
                    bank.displayAccountBalance(balanceAccountNumber);
                    break;
                case 5: //종료
                    isExit = true;
                    break;
            }
        } while (!isExit);
    }
}