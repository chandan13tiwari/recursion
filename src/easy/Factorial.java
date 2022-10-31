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
        // in this we can also compare num == 1, because 1! is also 1 and 0! is also 1
        if(num == 0)
            return 1;

        // n! = n * n-1 * n-2 * ....
        int partialAns = findFactorial(num - 1);
        return num * partialAns;
    }
}
