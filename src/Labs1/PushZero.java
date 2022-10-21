package Labs1;

import java.util.Scanner;

public class PushZero {
    static void pushZerosToEnd(int[] arr, int n) {
        int swapIndex;
        for (int i = 0; i < n; i++) {

            if (arr[i] == 0) {

                if (checkOnlyZeroLeft(arr, i)) break;

                swapIndex = i + 1;
                while (true) {
                    if (swapIndex == n) break;
                    if (arr[swapIndex] != 0) {
                        arr[i] = arr[swapIndex];
                        arr[swapIndex] = 0;
                        break;
                    }
                    swapIndex++;
                }
            }
        }

        printArray(arr, n);

    }

    static boolean checkOnlyZeroLeft(int[] a, int startIndex) {
        for (int i = startIndex; i < a.length; i++) {
            if (a[i] != 0) return false;
        }
        return true;
    }

    static void printArray(int[] arr, int n) {
        System.out.println("Transformiranata niza e:");
        for (int j = 0; j < n; j++)
            System.out.print(arr[j] + " ");
    }

    public static void main(String[] args) {

        int[] arr = new int[100];
        int n;

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = input.nextInt();
        input.close();

        pushZerosToEnd(arr, n);

    }
}
