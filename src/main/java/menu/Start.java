package menu;

import calculate.CalculateRegister;
import stock.StockRegister;

import java.util.Scanner;

public class Start {

    MenuDB menuDB = new MenuDatabaseHelper();
    BasketRegister basketRegister = new BasketRegister(menuDB);
    CalculateRegister calculateRegister = new CalculateRegister(menuDB);
    StockRegister stockRegister = new StockRegister(menuDB);

    public void run() {
        int num;
        boolean run = true;
        menuDB.connection();
        while (run) {
            System.out.println("==================================");
            System.out.println("==================================");
            System.out.println("1. 메뉴 보기 | 2. 재고 관리 |\n3. 계산하기 | 4. 장바구니 | 5. 종료");
            System.out.println("==================================");
            Scanner scanner = new Scanner(System.in);
            System.out.print("> ");
            num = scanner.nextInt();
            if (num >= 1 && num <= 5) {
                switch (num) {
                    case 1:
                        System.out.println(menuDB.getAllMenuList());
                        break;
                    case 2:
                        stockRegister.menuManage();
                        break;
                    case 3:
                        calculateRegister.calculate();
                        break;
                    case 4:
                        basketRegister.basketMenu();
                        break;
                    case 5:
                        run = menuDB.exit();
                        break;
                }
            } else {
                System.out.println("다시 선택해 주세요.");
            }
        }
    }
}
