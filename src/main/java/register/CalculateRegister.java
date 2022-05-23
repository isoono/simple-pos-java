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
                    System.out.print("총 가격 > ");
                    System.out.println(MenuRepository.totalPrice);
                    System.out.print("받은 현금을 입력하세요 > ");
                    double receiveMoney = scanner.nextInt();
                    if (receiveMoney - MenuRepository.totalPrice == 0) {
                        System.out.println("총 " + MenuRepository.totalPrice + "원 결제되었습니다.");
                        MenuRepository.safeBox += MenuRepository.totalPrice;
                        MenuRepository.totalPrice = 0;
                        repo.menuName.clear();
                    } else if (receiveMoney > MenuRepository.totalPrice) {
                        System.out.println("총 " + MenuRepository.totalPrice + "원 결제되었습니다.");
                        System.out.println("거스름돈 " + (receiveMoney - MenuRepository.totalPrice) + "원 입니다.");
                        MenuRepository.safeBox += MenuRepository.totalPrice;
                        MenuRepository.totalPrice = 0;
                        repo.menuName.clear();
                    } else if (receiveMoney <= MenuRepository.totalPrice) {
                        System.out.println("현금이 부족합니다.");
                    }
                    break;
                case 2:
                    System.out.println("총 " + MenuRepository.totalPrice + "원 결제되었습니다.");
                    MenuRepository.safeBox += MenuRepository.totalPrice;
                    MenuRepository.totalPrice = 0;
                    repo.menuName.clear();
                    break;
            }
        } else {
            System.out.println("다시 선택하세요.");
        }
    }

}
