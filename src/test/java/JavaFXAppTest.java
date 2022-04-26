import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaFXAppTest {
    static JavaFXApp app = new JavaFXApp();

    @Test
    void testComputeMultiply(){
        //arrange
        int a = 9;
        int b = 7;
        int expectedResult = 63;
        //act
        int realResult = app.computeMultiply(a, b);
        //assert
        assertEquals(realResult, expectedResult);
    }
}
