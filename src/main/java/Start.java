import register.BasketRegister;
import register.CalculateRegister;
import register.MenuRegister;
import register.StockRegister;

import java.util.Scanner;

public class Start {
    MenuRegister menuRegister = new MenuRegister();
    BasketRegister basketRegister = new BasketRegister();
    CalculateRegister calculateRegister = new CalculateRegister();
    StockRegister stockRegister = new StockRegister();

    public void start() {
        int num;
        boolean run = true;
        menuRegister.connection();
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
                        menuRegister.getAllMenu();
                        break;
                    case 2:
                        stockRegister.menuManage();
                        break;
                    case 3:
                        calculateRegister.calculate();
                        break;
                    case 4:
                        basketRegister.basket();
                        break;
                    case 5:
                        run = menuRegister.exit();
                        break;
                }
            } else {
                System.out.println("다시 선택해 주세요.");
            }
        }
    }
}
