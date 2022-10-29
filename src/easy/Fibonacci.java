package easy;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;

        int n = 6;

        Fibonacci obj = new Fibonacci();

        if(n == 1) {
            System.out.println(a);
        } else  if(n == 2) {
            System.out.println(b);
        } else if(n > 2) {
            //System.out.println(obj.fibonacci(n, a, b, 3));
            System.out.println(obj.fibonacci(n));
        } else
            System.out.println("Invalid input");
    }

    //this approach is replication of what we do while using FOR loops --> This is my approach
    /*int fibonacci(int n, int a, int b, int pos) {
        int c = a + b;
        if(pos == n) {
            return c;
        }

        a = b;
        b = c;

        pos++;
        return fibonacci(n, a, b, pos);
    }*/

    //this approach is best approach --> it uses general logic
    //time complexity is 2^n here. which is bad, so we'll use DP to fix this
    int fibonacci(int n) {
        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 1;
        }

        int partialAns1 = fibonacci(n-1);
        int partialAns2 = fibonacci(n-2);

        return partialAns1 + partialAns2;
    }
}
