import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaFXAppTest {
    @Test
    void computeDivideTest() {
        IComputation calc = new DivideComputation();
        //arrange1
        int expected = 3;
        //act1
        int actual = calc.compute(5,2);
        //assert1
        assertEquals(expected,actual); // Tests round up
        //arrange2
        expected = 1;
        //act2
        actual = calc.compute(10,8);
        //assert2
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
        //arrange
        void plusTest () {
        IComputation calc = new PlusComputation();
        int expected = 3;
        //Act
        int actual = calc.compute(1,2);
        //assert
        assertEquals(expected,actual);
    }
}
