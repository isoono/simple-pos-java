package register;

import repository.MenuRepository;

public class MenuRegister {
    MenuRepository repo = new MenuRepository();
    public void connection() {
        repo.connection();
    }

    public boolean exit() {
        return repo.exit();
    }

    public void getAllMenu() {
        repo.getAllMenuList();
    }

}
