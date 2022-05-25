package register.unit;

import menu.Menu;
import menu.MenuDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FakeMenuDatabaseHelper implements MenuDB {

    List<Menu> fakeMenus = new ArrayList<>();
    private boolean isError = false;

    public void executeError(boolean value) {
        isError = true;
    }

    @Override
    public void connection() {
        // no-op
    }

    @Override
    public Menu getMenu(String name) {
        Menu findMenu = null;
        for (Menu menu : fakeMenus) {
            if (menu.getName().equals(name)) {
                findMenu = menu;
            }
        }
        if (isError) {

        }
        return findMenu;
    }

    @Override
    public List<Menu> getAllMenuList() {
        return null;
    }

    @Override
    public boolean addMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean deleteMenu(String name) {
        return false;
    }

    @Override
    public double getSales(String name) {
        return 0;
    }

    @Override
    public boolean addSales(double sales, String name) {
        return false;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
