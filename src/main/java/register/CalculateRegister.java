package register;

import java.util.Scanner;

public class CalculateRegister {
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

}
