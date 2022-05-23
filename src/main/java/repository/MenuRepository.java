package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuRepository {
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    public static double totalPrice = 0;
    public static double safeBox = 0;

    public List<String> menuName = new ArrayList<>();

    public void connection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        String url = "jdbc:postgresql://localhost:5432/menu";
        String user = "posuser";
        String pwd = "posUser!!";

        try {
            conn = DriverManager.getConnection(url, user, pwd);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT VERSION() as version");

            while (rs.next()) {
                String version = rs.getString("version");
                System.out.println("information(" + version + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMenu(final String name, final Double price, final int quantity) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO menu (name, price, quantity) VALUES (?, ?, ?)");
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, quantity);

            System.out.println("* " + name + " : " + price + "원 (수량:" + quantity + ") 추가되었습니다.");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMenu(final String name) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM menu where name = ?");
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("삭제 되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllMenuList() {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM menu");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                System.out.println("* " + name + " : " + price + "원 (수량:" + quantity + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //###########################
    //###########################
    //장바구니
    //###########################
    //###########################

    public void addBasket() {
        System.out.println("장바구니에 담을 메뉴의 이름을 입력하세요.");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int quantity = 0;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM menu where name = ?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
                double price = rs.getDouble("price");
                quantity = rs.getInt("quantity");
                totalPrice += price;
                System.out.println("* " + name + " : " + price + "원 추가되었습니다.");
                menuName.add(name);
            }
            System.out.println("총 금액 : " + totalPrice + "원");

            if (quantity <= 0) {
                System.out.println("재고가 부족합니다.");
            } else {
                int newQuantity = quantity - 1;

                pstmt = conn.prepareStatement("UPDATE menu SET quantity = ? WHERE name = ?");
                pstmt.setInt(1, newQuantity);
                pstmt.setString(2, name);
                pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void basketList() {
        try {
            for (int i = 0; i < menuName.size(); i++) {
                String name = menuName.get(i);
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM menu WHERE name = ?");
                pstmt.setString(1, name);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    String itemName = rs.getString("name");
                    double itemPrice = rs.getDouble("price");
                    System.out.println("* " + itemName + " : " + itemPrice + "원");
                }
            }
            System.out.println("* 총 금액 : " + totalPrice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBasket() {
        System.out.println("장바구니에서 삭제할 메뉴의 이름을 입력하세요.");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String nameToDelete;
        double priceToDelete = 0;
        int newQuantity = 0;
        for (int i = 0; i < menuName.size(); i++) {
            if (name.equals(menuName.get(i))) {
                nameToDelete = menuName.get(i);
                menuName.remove(i);
                System.out.println("삭제되었습니다.");
                try {
                    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM menu WHERE name = ?");
                    pstmt.setString(1, nameToDelete);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int quantity = rs.getInt("quantity");
                        newQuantity = quantity + 1;
                        priceToDelete = rs.getDouble("price");
                    }
                    PreparedStatement updatePstmt = conn.prepareStatement("UPDATE menu SET quantity = ? WHERE name = ?");
                    updatePstmt.setInt(1, newQuantity);
                    updatePstmt.setString(2, nameToDelete);
                    updatePstmt.executeUpdate();
                    totalPrice -= priceToDelete;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("해당 메뉴가 장바구니에 없습니다.");
            }
        }
    }

    public void addSales() {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE menu SET sales = ?");
            pstmt.setDouble(1, safeBox);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //###########################
    //###########################
    //재고 관리
    //###########################
    //###########################

    public void getSales() {
        double test = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT sales FROM menu");
            rs = pstmt.executeQuery();
            while(rs.next()){
                test = rs.getDouble("sales");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("총 매출액은 " + test + "원 입니다.");
    }

    public void addStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("추가할 항목의 정보를 입력하세요.");
        System.out.print("메뉴 이름 > ");
        String name = scanner.next();
        System.out.print("가격 > ");
        double price = scanner.nextDouble();
        System.out.print("수량 > ");
        int quantity = scanner.nextInt();
        addMenu(name, price, quantity);
    }

    public void deleteStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 항목의 이름을 입력하세요.");
        System.out.print("이름 > ");
        String name = scanner.next();
        deleteMenu(name);
    }


    public void calculateWithCreditCard() {
        System.out.println("총 " + MenuRepository.totalPrice + "원 결제되었습니다.");
        MenuRepository.safeBox += MenuRepository.totalPrice;
        totalPrice = 0;
        menuName.clear();
    }

    public void calculateWithCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("총 가격 > ");
        System.out.println(MenuRepository.totalPrice);
        System.out.print("받은 현금을 입력하세요 > ");
        double receiveMoney = scanner.nextInt();
        if (receiveMoney - MenuRepository.totalPrice == 0) {
            System.out.println("총 " + MenuRepository.totalPrice + "원 결제되었습니다.");
            MenuRepository.safeBox += MenuRepository.totalPrice;
            MenuRepository.totalPrice = 0;
            menuName.clear();
        } else if (receiveMoney > MenuRepository.totalPrice) {
            System.out.println("총 " + MenuRepository.totalPrice + "원 결제되었습니다.");
            System.out.println("거스름돈 " + (receiveMoney - MenuRepository.totalPrice) + "원 입니다.");
            MenuRepository.safeBox += MenuRepository.totalPrice;
            MenuRepository.totalPrice = 0;
            menuName.clear();
        } else if (receiveMoney <= MenuRepository.totalPrice) {
            System.out.println("현금이 부족합니다.");
        }
    }

    public boolean exit() {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }


}
