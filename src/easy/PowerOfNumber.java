package easy;

public class PowerOfNumber {
    public static void main(String[] args) {
        int x = 3;
        int n = 3;

        PowerOfNumber obj = new PowerOfNumber();
        System.out.println(obj.power(x, n));
    }

    // find x^n --> this is basic approach
    /*int power(int x, int n) {
        if(n == 0)
            return 1;
        int partialAns = power(x, n-1);
        return x * partialAns;
    }*/

    // better approach --> calculating x^n/2 * x^n/2
    int power(int x, int n) {
        if(n == 0)
            return 1;

       int partialAns = power(x, n/2);

       if(n % 2 != 0)
           return x * partialAns * partialAns;
       return partialAns * partialAns;
    }
}
