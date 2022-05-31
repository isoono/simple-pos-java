package register.unit;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stock.StockRegister;

import static org.junit.jupiter.api.Assertions.*;

public class StockRegisterTest {

    private FakeMenuDatabaseHelper helper;
    private StockRegister register;
    @BeforeEach
    private void initEach() {
        helper = new FakeMenuDatabaseHelper();
        register = new StockRegister(helper);
    }

    @DisplayName("재고 추가 성공 테스트")
    @Test
    public void addStockSuccess() {
        //Given
        Menu menu = new Menu("콜라TEST", 100000, 100000);

        //When
        boolean result = register.addStock(menu);

        //Then
        assertTrue(result);
    }

    @DisplayName("재고 추가 실패 테스트, 이름이 중복된 케이스")
    @Test
    public void addStockFailure() {
        //Given
        Menu originMenu = new Menu("콜라TEST", 100000.0, 100000);
        Menu additionalMenu = new Menu("콜라TEST", 200000.0, 200000);

        //When
        register.addStock(originMenu);
        boolean result = register.addStock(additionalMenu);

        //Then
        assertFalse(result);
    }

    @DisplayName("재고 삭제 성공 테스트")
    @Test
    public void deleteStockSuccess() {
        //Given
        Menu menu = new Menu("콜라TEST", 100000, 100000);

        //When
        register.addStock(menu);
        boolean result = register.deleteStock("콜라TEST");

        //Then
        assertTrue(result);
    }

    @DisplayName("재고 삭제 실패 테스트, 해당 재고가 존재하지 않는 케이스")
    @Test
    public void deleteStockFailure() {
        //Given
        Menu menu = new Menu("콜라TEST", 100000, 100000);

        //When
        register.addStock(menu);
        boolean result = register.deleteStock("콜라");

        //Then
        assertFalse(result);
    }

    @DisplayName("매출액 조회 성공 테스트")
    @Test
public void getSales() {
        //Given
        Menu menu = new Menu("콜라TEST", 100000, 100000, 200000);

        //When
        register.addStock(menu);
        double result = register.getSales("콜라TEST");

        //Then
        assertEquals(result, 200000);
    }
}
