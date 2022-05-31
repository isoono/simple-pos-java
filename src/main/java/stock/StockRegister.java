package stock;

import common.Register;
import menu.Menu;
import menu.MenuDB;

public class StockRegister extends Register {

    public StockRegister(MenuDB menuDB) {
        this.menuDB = menuDB;
    }

    public void menuManage() {
        System.out.println("1. 재고 추가 | 2. 재고 삭제 | 3. 매출액 ");
        System.out.print("> ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 3) {
            switch (num) {
                case 1:
                    System.out.println("추가할 항목의 정보를 입력하세요.");
                    System.out.print("메뉴 이름 > ");
                    String name = scanner.next();
                    System.out.print("가격 > ");
                    double price = scanner.nextDouble();
                    System.out.print("수량 > ");
                    int quantity = scanner.nextInt();
                    addStock(new Menu(name, price, quantity));
                    break;
                case 2:
                    System.out.println("삭제할 항목의 이름을 입력하세요.");
                    System.out.print("이름 > ");
                    String deletedName = scanner.next();
                    deleteStock(deletedName);
                    break;
                case 3:
                    System.out.print("이름 > ");
                    String salesName = scanner.next();
                    getSales(salesName);
                    break;
            }
        } else {
            System.out.println("다시 선택해 주세요.");
        }
    }

    public boolean addStock(final Menu menu) {
        boolean result = menuDB.addMenu(menu);
        System.out.println(result);
        if (result) {
            System.out.println("추가되었습니다.");
            return true;
        } else {
            System.out.println("다시 입력해주세요.");
            return false;
        }
    }

    public boolean deleteStock(final String name) {
        boolean result = menuDB.deleteMenu(name);
        if (result) {
            System.out.println("삭제되었습니다.");
            return true;
        } else {
            System.out.println("다시 입력해주세요.");
            return false;
        }
    }

    public double getSales(String name) {
        return menuDB.getSales(name);
    }

}
