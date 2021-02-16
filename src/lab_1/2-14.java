// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
// Элементы, которые равны полусумме соседних элементов.

import java.util.Scanner;

class Lab2_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Элементы, которые равны полусумме соседних элементов");

        for (int i = 1; i < n - 1; i++) {
            int el = arr[i];

            if (el * 2 == arr[i - 1] + arr[i + 1]) {
                System.out.println(el);
            }
        }
    }
}