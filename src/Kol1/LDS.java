package Kol1;

import java.util.Arrays;
import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {
        int length = a.length;
        int[] longestSequence = new int[length];
        Arrays.fill(longestSequence, 1);

        for(int i = 1 ; i < length ; i++) {
            for(int j = 0; j <= i ; j++) {
                if(a[i] < a[j]  && longestSequence[i] < longestSequence[j]+1) {
                    longestSequence[i] = longestSequence[j] + 1;
                }
            }
        }


        return Arrays.stream(longestSequence).max().orElse(1);

    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }

        //10
        //-5 -6 0 -10 4 3 2 -13 -15 -20
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
