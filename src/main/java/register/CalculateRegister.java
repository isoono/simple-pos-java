package register;

import repository.MenuRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateRegister {
    Scanner scanner = new Scanner(System.in);
    MenuRepository repo = new MenuRepository();

    public void calculate() {
        System.out.println("계산 방법을 선택하세요.");
        System.out.println("1. 현금 | 2. 카드");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 2) {
            switch (num) {
                case 1:
                    repo.calculateWithCash();
                    break;
                case 2:
                    repo.calculateWithCreditCard();
                    break;
            }
            repo.addSales();
        } else {
            System.out.println("다시 선택하세요.");
        }
    }



}
