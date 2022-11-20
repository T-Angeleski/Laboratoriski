package Kol1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka

        calculatePrices(N, M);

    }

    private static void calculatePrices(int numAdults, int numChildren) {
        //ticket price = 100$ per person
        // adult can take k-children and pays for k-1 (one gets a free ride)

        long min, max;
        if (numAdults == 1) {
            // 1 adult takes all the children, price is 100 * N + 100 * M - 1 free ticket
            // 0 children, only adults and no discount
            System.out.println(numChildren * 100); // min
            System.out.println(numChildren * 100); // max
        } else if (numChildren == 0) {
            System.out.println(numAdults * 100);
            System.out.println(numAdults * 100);
        } else if (numAdults > numChildren) {
            System.out.println(numAdults * 100);
            System.out.println(((numAdults + numChildren) * 100) - 100);
        } else {
            System.out.println(numChildren * 100);
            System.out.println(((numAdults + numChildren) * 100) - 100);
        }
    }

}

