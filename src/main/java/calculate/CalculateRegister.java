package calculate;


import common.Register;
import menu.Menu;
import menu.MenuDB;

import java.util.List;
import java.util.Scanner;

public class CalculateRegister extends Register {
    public CalculateRegister(MenuDB menuDB) {
        this.menuDB = menuDB;
    }

    public void calculate() {
        System.out.println("계산 방법을 선택하세요.");
        System.out.println("1. 현금 | 2. 카드");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 2) {
            switch (num) {
                case 1:
                    calculateWithCash();
                    break;
                case 2:
                    calculateWithCreditCard();
                    break;
            }
        } else {
            System.out.println("다시 선택하세요.");
        }
    }

    public void calculateWithCash() {
        System.out.print("총 가격 > ");
        printTotalPrice();
        System.out.print("받은 현금을 입력하세요 > ");
        double receiveMoney = scanner.nextInt();
        if (receiveMoney - printTotalPrice() == 0) {
            System.out.println("총 " + printTotalPrice() + "원 결제되었습니다.");
            updateSales();
            basket.clear();
        } else if (receiveMoney > printTotalPrice()) {
            System.out.println("총 " + printTotalPrice() + "원 결제되었습니다.");
            System.out.println("거스름돈 " + (receiveMoney - printTotalPrice()) + "원 입니다.");
            updateSales();
            basket.clear();
        } else if (receiveMoney <= printTotalPrice()) {
            System.out.println("현금이 부족합니다.");
        }
    }

    public void calculateWithCreditCard() {
        System.out.println("총 " + printTotalPrice() + "원 결제되었습니다.");
        updateSales();
        basket.clear();
    }

    public double printTotalPrice() {
        double price = 0;
        for (int i = 0; i < basket.size(); i++) {
            price += menuDB.getPrice(basket.get(i).getName());
        }
        System.out.println("총 금액은 " + price + "원 입니다.");
        return price;
    }

    public void updateSales() {
        double price = 0;
        String name = "";
        for (int i = 0; i < basket.size(); i++) {
            name = basket.get(i).getName();
            price = menuDB.getPrice(name);
            menuDB.addSales(price, name);
        }
    }


}
