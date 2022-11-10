package Labs4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {

        int max = 1, count = 1;
        boolean alternateSign;
        for (int i = 0; i < a.length - 1; i++) {
            alternateSign = getSign(a[i]); // Get current number's sign
            if (a[i] == 0) { // if num is zero, stop count ( not negative nor positive )
                count = 0;
            }
            if (alternateSign != getSign(a[i + 1]) && a[i + 1] != 0) {
                count++;
            } else {
                count = 1;
            }
            if (count > max) {
                max = count;
            }

        }

        return max;
    }

    private static boolean getSign(int num) {
        return num >= 0;
    }


    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i = 0; i < N; i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
