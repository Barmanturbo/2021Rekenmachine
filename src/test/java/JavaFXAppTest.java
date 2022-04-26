import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaFXAppTest {
    @Test
    void computeDivideTest() {
        IComputation calc = new DivideComputation();
        int expected = 3;
        int actual = calc.compute(5,2);
        assertEquals(expected,actual); // Tests round up
        expected = 1;
        actual = calc.compute(10,8);
        assertEquals(expected, actual); // Tests round down
    }
  
    @Test
    void testComputeMultiply(){
        IComputation calc = new MultiplyComputation();
        //arrange
        int a = 9;
        int b = 7;
        int expectedResult = 63;
        //act
        int realResult = calc.compute(a, b);
        //assert
        assertEquals(realResult, expectedResult);
    }
  
    @Test
        void plusTest () {
        int expected = 3;
        int actual = app.computeAdd(1,2);
        assertEquals(expected,actual);
    }
}
