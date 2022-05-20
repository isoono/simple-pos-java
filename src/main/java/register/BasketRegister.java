package register;

import repository.MenuRepository;

import java.util.Scanner;

public class BasketRegister {
    MenuRepository repo = new MenuRepository();
    Scanner scanner = new Scanner(System.in);
    public void basket() {
        System.out.println("============메뉴 목록============");
        repo.getAllMenuList();
        System.out.println("=================================");
        System.out.println("1. 장바구니 추가 | 2. 장바구니 리스트 | 3. 장바구니 삭제 | 4. 뒤로");
        System.out.print("> ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 4) {
            switch (num) {
                case 1:
                    repo.addBasket();
                    break;
                case 2:
                    repo.basketList();
                    break;
                case 3:
                    repo.basketList();
                    repo.deleteBasket();
                    break;
                case 4:
                    break;
            }
        }
    }
}
