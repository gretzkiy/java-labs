// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
// Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.

import java.util.Scanner;
import java.util.HashSet;

class Lab2_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Трехзначные числа, в десятичной записи которых нет одинаковых цифр");

        for (int i = 0; i < n; i++) {
            int el = arr[i];
            if (Lab2_6.shouldPrint(el)) {
                System.out.println(el);
            }
        }
    }

    /**
     * Возвращает true, если переданное число нужно напечатать в консоль
     * @param x - число для проверки
     */
    protected static boolean shouldPrint(int x) {
        if (x < 100 || x > 999) {
           return false;
        }

        HashSet<Integer> digits = new HashSet<Integer>();
        digits.add(x / 100);
        digits.add(x / 10 % 10);
        digits.add(x % 10);

        return digits.size() == 3;
    }
}