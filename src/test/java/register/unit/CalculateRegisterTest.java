//package register.unit;
//
//import calculate.CalculateRegister;
//import menu.Menu;
//import menu.MenuDatabaseHelper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CalculateRegisterTest {
//
//    private final MenuDatabaseHelper helper = new MenuDatabaseHelper();
//    private final CalculateRegister register = new CalculateRegister(helper);
//
//    @DisplayName("계산 성공 테스트")
//    @Test
//    void calculate() {
//        List<Menu> basket = new ArrayList();
//        basket.add(new Menu("콜라", 200, 2));
//        basket.add(new Menu("사이다", 100, 1));
//        basket.add(new Menu("환타", 300, 3));
//
//        register.calculateWithCash();
//        assertEquals(sum, 500);
//    }
//}
