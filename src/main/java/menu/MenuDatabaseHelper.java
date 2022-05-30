package menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDatabaseHelper implements MenuDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/menu";
    private static final String USER = "posuser";
    private static final String PWD = "posUser!!";

    private Connection conn;

    @Override
    public void connection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean executeResult(final PreparedStatement pstmt) {
        try {
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Menu getMenu(final String name) {
        Menu menu = null;
        try (
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM menu where name = ?");
        ) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            String resultName = rs.getString("name");
            double resultPrice = rs.getDouble("price");
            int resultQuantity = rs.getInt("quantity");
            menu = new Menu(resultName, resultPrice, resultQuantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public List<Menu> getAllMenuList() {
        List<Menu> menuList = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM menu");
             ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                Menu menu = new Menu(name, price, quantity);
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public boolean addMenu(final Menu menu) {
        boolean result = false;
        try (
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO menu (name, price, quantity) VALUES (?, ?, ?)")
        ) {
            pstmt.setString(1, menu.getName());
            pstmt.setDouble(2, menu.getPrice());
            pstmt.setInt(3, menu.getQuantity());
            result = executeResult(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteMenu(final String name) {
        boolean result = false;
        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM menu where name = ?")) {
            pstmt.setString(1, name);
            result = executeResult(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public double getSales(final String name) {
        double sales = 0;
        try (
                PreparedStatement pstmt = conn.prepareStatement("SELECT sales FROM menu WHERE name = ?")
        ) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            sales = rs.getDouble("sales");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

    @Override
    public boolean addSales(final double sales, final String name) {
        boolean result = false;
        try (
                PreparedStatement pstmt = conn.prepareStatement("UPDATE menu SET sales = ? WHERE name = ?");
        ) {
            pstmt.setDouble(1, sales);
            pstmt.setString(2, name);
            result = executeResult(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public double getPrice(final String name) {
        double price = 0;
        try (
                PreparedStatement pstmt = conn.prepareStatement("SELECT price FROM menu WHERE name = ?");
        ) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            return rs.getDouble("price");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean exit() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
