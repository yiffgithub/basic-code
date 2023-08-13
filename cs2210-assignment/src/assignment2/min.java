package assignment2;
public class min
{
    // Returns the minimum number of coins
    // to make V cents. If not possible returns -1
   public static int minCoins(int coins[], int m, int V)
    {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V-coins[i]);
                /*System.out.println(sub_res);
                System.out.println("--");
                System.out.println(res);*/
               // System.out.println(sub_res);
                // Check for INT_MAX to avoid overflow and see if
                // result can be minimized
                if (sub_res != Integer.MAX_VALUE
                        && sub_res + 1 < res)
                    res = sub_res + 1;
               // System.out.println("---");
            }

        }
        return (res==Integer.MAX_VALUE)? -1 : res;
    }

    public static void main(String args[])
    {
        int coins[] = {25, 10, 5};
        int m = coins.length;
        int V = 30;
        System.out.println("value of coins are 25 10 5");
        System.out.println("Minimum coins required is "+ minCoins(coins, m, V));
    }
}
