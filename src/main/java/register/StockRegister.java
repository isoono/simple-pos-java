package register;

import repository.MenuRepository;

import java.util.Scanner;

public class StockRegister {
    Scanner scanner = new Scanner(System.in);
    MenuRepository repo = new MenuRepository();
    public void menuManage() {
        System.out.println("1. 재고 추가 | 2. 재고 삭제 | 3. 총 매출액 ");
        System.out.print("> ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 3) {
            switch (num) {
                case 1:
                    addStock();
                    break;
                case 2:
                    deleteStock();
                    break;
                case 3:
                    getSafeBox();
                    break;
            }
        } else {
            System.out.println("다시 선택해 주세요.");
        }
    }

    public void addStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("추가할 항목의 정보를 입력하세요.");
        System.out.print("메뉴 이름 > ");
        String name = scanner.next();
        System.out.print("가격 > ");
        double price = scanner.nextDouble();
        System.out.print("수량 > ");
        int quantity = scanner.nextInt();
        repo.addMenu(name, price, quantity);
    }

    public void deleteStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 항목의 이름을 입력하세요.");
        System.out.print("이름 > ");
        String name = scanner.next();
        repo.deleteMenu(name);
    }

    public void getSafeBox() {
        System.out.println("총 매출액은 " + MenuRepository.safeBox + "원 입니다.");
    }

}
