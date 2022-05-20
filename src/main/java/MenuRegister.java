import java.sql.*;
import java.util.Scanner;

public class MenuRegister {
    MenuRepository repo = new MenuRepository();
    Scanner scanner = new Scanner(System.in);

    public void connection() {
        repo.connection();
    }

    public boolean exit() {
        return repo.exit();
    }

    public void getAllMenu() {
        repo.getAllMenuList();
    }

    public void menuManage() {
        System.out.println("1. 재고 추가 | 2. 재고 삭제 | 3. 뒤로 | 4. 종료");
        System.out.print("> ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 4) {
            switch (num) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    deleteMenu();
                    break;
                case 3:
                    break;
                case 4:
                    exit();
                    break;
            }
        } else {
            System.out.println("다시 선택해 주세요.");
        }
    }

    public void addMenu() {
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

    public void deleteMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 항목의 이름을 입력하세요.");
        System.out.print("이름 > ");
        String name = scanner.next();
        repo.deleteMenu(name);
    }

    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산 방법을 선택하세요.");
        System.out.println("1. 현금 | 2. 카드 | 3. 이체 | 4. 뒤로 | 5. 종료");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 5) {
            switch (num) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
            }
        } else {
            System.out.println("다시 선택하세요.");
        }
    }

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
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}
