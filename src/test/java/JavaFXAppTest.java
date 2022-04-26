import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaFXAppTest {
    static JavaFXApp app = new JavaFXApp();

    @Test
    void computeDivideTest() {
        //arrange1
        int expected = 3;
        //act1
        int actual = app.computeDivide(5,2);
        //assert1
        assertEquals(expected,actual); // Tests round up

        //arrange2
        expected = 1;
        //act2
        actual = app.computeDivide(10,8);
        //assert2
        assertEquals(expected, actual); // Tests round down
    }
  
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
  
    @Test
        //arrange
        void plusTest () {
        int expected = 3;
        //act
        int actual =app.computeAdd(1,2);
        //assert
        assertEquals(expected,actual);
    }
}
