package assignment2;

public class fib  {
    public static void main(String[] args) {
        System.out.println("the value of fib(10) is "+fib(10));  // Output: 55
    }

    static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}

