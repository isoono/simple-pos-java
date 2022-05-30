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
        if (menu == null) {
            return false;
        } else {
            for (int i = 0; i < fakeMenus.size(); i++) {
                if (menu.getName().equals(fakeMenus.get(i).getName())) {
                    return false;
                }
            }
            fakeMenus.add(menu);
            return true;
        }
    }

    @Override
    public boolean deleteMenu(String name) {
        for (int i = 0; i < fakeMenus.size(); i++) {
            if (fakeMenus.get(i).getName().equals(name)) {
                fakeMenus.remove(i);
                return true;
            }
        }
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
    public double getPrice(String name) {
        return 0;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
