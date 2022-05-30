package menu;

import common.Register;

import java.util.ArrayList;
import java.util.List;

public class BasketRegister extends Register {

//    private final List<Menu> basket = new ArrayList<>();

    BasketRegister(MenuDB menuDB) {
        this.menuDB = menuDB;
    }

    public void basketMenu() {
        System.out.println("============메뉴 목록============");
        System.out.println(menuDB.getAllMenuList());
        System.out.println("=================================");
        System.out.println("1. 장바구니 추가 | 2. 장바구니 리스트 | 3. 장바구니 삭제 | 4. 뒤로");
        System.out.print("> ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 4) {
            switch (num) {
                case 1:
                    System.out.print("이름을 입력하세요 > ");
                    String name = scanner.next();
                    addBasket(name);
                    break;
                case 2:
                    System.out.println(basket);
                    break;
                case 3:
                    basket.clear();
                    System.out.println("삭제되었습니다.");
                    break;
                case 4:
                    break;
            }
        }
    }

    private void addBasket(String name) {
        Menu menu = menuDB.getMenu(name);
        if (menu == null) {
            System.out.println("다시 입력하세요.");
        } else if (menu.getQuantity() == 0) {
            System.out.println("재고가 부족합니다.");
        } else {
            int quantity = menu.getQuantity();
            int count = 0;
            for (Menu value : basket) {
                if (value.getName().equals(name)) {
                    count++;
                }
            }
            confirmQuantity(menu, quantity, count);
        }
    }

    // TODO 이름 무조건 바꿀 것
    private void confirmQuantity(Menu menu, int quantity, int count) {
        if (quantity <= count) {
            System.out.println("재고가 부족합니다.");
        } else {
            System.out.println(menu);
            basket.add(menu);
            System.out.println("추가되었습니다.");
        }
    }

}
