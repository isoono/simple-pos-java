package common;

import menu.Menu;
import menu.MenuDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Register {

    protected List<Menu> basket = new ArrayList<>();
    protected MenuDB menuDB;
    protected Scanner scanner = new Scanner(System.in);
}
