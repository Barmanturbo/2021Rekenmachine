import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaFXAppTest {
    static JavaFXApp app = new JavaFXApp();

    @Test
    void computeDivideTest() {
        int expected = 3;
        int actual = app.computeDivide(5,2);
        assertEquals(expected,actual);
        expected = 1;
        actual = app.computeDivide(10,8);
        assertEquals(expected, actual);
    }
}