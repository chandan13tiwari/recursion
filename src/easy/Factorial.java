package easy;

public class Factorial {
    public static void main(String[] args) {

        Factorial obj = new Factorial();
        int num = 3;

        if(num > 0) {
            System.out.println(obj.findFactorial(num));
        } else {
            System.out.println("invalid number");
        }
    }

    int findFactorial(int num) {
        if(num == 0)
            return 1;

        // n! = n * n-1 * n-2 * ....
        int partialAns = findFactorial(num - 1);
        return num * partialAns;
    }
}
