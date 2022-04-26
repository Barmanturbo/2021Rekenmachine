import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaFXAppTest {


        @Test
        void plusTest () {
            int expected = 3;
            JavaFXApp app= new JavaFXApp();
            int actual =app.computeAdd(1,2);

            assertEquals(expected,actual);
        }
    }