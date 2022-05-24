//package calculate;
//
//
//import menu.Menu;
//import menu.MenuDB;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class CalculateRegister {
//    Scanner scanner = new Scanner(System.in);
//    private MenuDB menuDB;
//
//    public CalculateRegister(MenuDB menuDB) {
//        this.menuDB = menuDB;
//    }
//
//    public void calculate(List<Menu> menuList) {
//        System.out.println("계산 방법을 선택하세요.");
//        System.out.println("1. 현금 | 2. 카드");
//        int num = scanner.nextInt();
//        if (num >= 1 && num <= 2) {
//            switch (num) {
//                case 1:
//                    calculateWithCash();
//                    break;
//                case 2:
//                    calculateWithCreditCard();
//                    break;
//            }
//            repo.addSales();
//        } else {
//            System.out.println("다시 선택하세요.");
//        }
//    }
//
//    public void calculateWithCash() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("총 가격 > ");
//        System.out.println(repo.totalPrice);
//        System.out.print("받은 현금을 입력하세요 > ");
//        double receiveMoney = scanner.nextInt();
//        if (receiveMoney - repo.totalPrice == 0) {
//            System.out.println("총 " + repo.totalPrice + "원 결제되었습니다.");
//            repo.safeBox += repo.totalPrice;
//            repo.totalPrice = 0;
//            repo.menuName.clear();
//        } else if (receiveMoney > repo.totalPrice) {
//            System.out.println("총 " + repo.totalPrice + "원 결제되었습니다.");
//            System.out.println("거스름돈 " + (receiveMoney - repo.totalPrice) + "원 입니다.");
//            repo.safeBox += repo.totalPrice;
//            repo.totalPrice = 0;
//            repo.menuName.clear();
//        } else if (receiveMoney <= repo.totalPrice) {
//            System.out.println("현금이 부족합니다.");
//        }
//    }
//
//    public void calculateWithCreditCard() {
//        System.out.println("총 " + repo.totalPrice + "원 결제되었습니다.");
//        repo.safeBox += repo.totalPrice;
//        repo.totalPrice = 0;
//        repo.menuName.clear();
//    }
//
//
//}
