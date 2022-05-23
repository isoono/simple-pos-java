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
                    repo.addStock();
                    break;
                case 2:
                    repo.deleteStock();
                    break;
                case 3:
                    repo.getSales();
                    break;
            }
        } else {
            System.out.println("다시 선택해 주세요.");
        }
    }






}
