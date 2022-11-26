import org.example.Spot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpotTest {
    // тест не выполняющийся если не выполняются заданные значения
    @Test
    public void validSpotTest(){
        Spot spot = new Spot("a",1);
        Assertions.assertNotNull(spot); // проверка на отсутсвия null
        Assertions.assertEquals("a",spot.getX());
        Assertions.assertEquals(1,spot.getY());
    }
    // тест выполняющийся при ошибке (тест ожидает ошибку)
    @Test
    public void invalidXValueTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Spot spot = new Spot("q",1);
        });
    }
    @Test
    public void invalidYValueTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Spot spot = new Spot("h", 10);
        });
    }
    // параметризированный тест
    @ParameterizedTest
    @ValueSource( ints = {-1,0,100})
    public void invalidYValueParamsTest(int y) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Spot spot = new Spot("h", y);
        });
    }
}
