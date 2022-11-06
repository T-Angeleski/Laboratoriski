package Labs3;


import java.io.FilterOutputStream;
import java.util.Scanner;

public class MinDistance {
    //d = √[| y2 –  y1|² + | x2 –  x1|²]

    public static float minimalDistance(float points[][]) {
        //x [i][0]  y[i][1]
        float q1 = (float) Math.pow(Math.abs(points[1][1] - points[0][1]), 2);
        float q2 = (float) Math.pow(Math.abs(points[1][0] - points[0][0]), 2);
        float min = (float) Math.sqrt(q1 + q2);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                float newDistance = (float) Math.sqrt(Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2));
                if(newDistance < min)
                    min = newDistance;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        float points[][] = new float[N][2];

        for (int i = 0; i < N; i++) {
            points[i][0] = input.nextFloat();
            points[i][1] = input.nextFloat();
        }

        System.out.printf("%.2f\n", minimalDistance(points));
    }
}
