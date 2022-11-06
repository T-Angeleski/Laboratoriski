package Labs3;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyCoins {

    public static int minNumCoins(int coins[], int sum) {
        //sort to get the smallest first
        Arrays.sort(coins);
        int j = coins.length - 1; //start at the end
        int counter = 0;
        int tmp = sum;
        while (tmp != 0) {
            if (tmp - coins[j] >= 0) {
                tmp -= coins[j];
                counter++; // how many coins used
            } else {
                j--;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String coinsStringLine = input.nextLine();
        String coinsString[] = coinsStringLine.split(" ");
        int coins[] = new int[coinsString.length];
        for (int i = 0; i < coinsString.length; i++) {
            coins[i] = Integer.parseInt(coinsString[i]);
        }

        int sum = input.nextInt();

        System.out.println(minNumCoins(coins, sum));
    }
}
