import java.util.Scanner;

public class Start {
    MenuRegister register = new MenuRegister();

    public void start() {
        int num;
        boolean run = true;
//        System.out.println("==================================");
//        System.out.println("POS기를 실행합니다.");
        register.connection();
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
                        register.getAllMenu();
                        break;
                    case 2:
                        register.menuManage();
                        break;
                    case 3:
                        register.calculate();
                        break;
                    case 4:
                        break;
                    case 5:
                        run = register.exit();
                        break;
                }
            } else {
                System.out.println("다시 선택해 주세요.");
            }
        }
    }
}
