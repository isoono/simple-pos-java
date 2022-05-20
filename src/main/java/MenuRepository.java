import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRepository {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private double totalPrice;

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

    public void calculate() {

    }

    public void addBasket() {
        //TODO
//        System.out.println("장바구니에 담을 메뉴의 이름을 입력하세요.");
//        System.out.print("> ");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.next();
//        List<ResultSet> list = new ArrayList<>();
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM menu where name = ?");
//            pstmt.setString(1, name);
//            rs = pstmt.executeQuery();
//            name = rs.getString("name");
//            double price = rs.getDouble("price");
//            totalPrice += price;
//
//            System.out.println("* " + name + " : " + price + "원");
//            System.out.println("총 금액 : " + totalPrice + "원");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        list.add(rs);
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
