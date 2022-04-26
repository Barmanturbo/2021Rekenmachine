public class DivideComputation implements IComputation{
    @Override
    public int compute(int num1, int num2) {
        double result = (double) num1 / num2;
        result = Math.round(result);
        return (int) result;
    }
}
