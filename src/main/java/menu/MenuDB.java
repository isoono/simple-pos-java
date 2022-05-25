package menu;

import java.util.List;

public interface MenuDB {

    void connection();

    Menu getMenu(final String name);

    List<Menu> getAllMenuList();

    boolean addMenu(final Menu menu);

    boolean deleteMenu(final String name);

    double getSales(final String name);

    boolean addSales(final double sales, final String name);

    boolean exit();

}
