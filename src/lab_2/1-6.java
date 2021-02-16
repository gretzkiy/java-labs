// 6. Ввести n слов с консоли. Найти слово, символы в котором идут в строгом порядке возрастания их кодов.
// Если таких слов несколько, найти первое из них.

import java.util.Scanner;

class Lab1_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();

        in.nextLine();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }

        System.out.println("Слово, символы в котором идут в строгом порядке возрастания их кодов");

        for (String str : arr) {
            if (Lab1_6.hasAscendingChars(str)) {
                System.out.println(str);
                return;
            }
        }
    }

    /**
     * Возвращает true, если символы в слове идут в строго возрастающем порядке
     * @param str - строка для проверки
     */
    protected static boolean hasAscendingChars(String str) {
        for (int i = 1; i < str.length(); i++) {
            if ((int)str.charAt(i) <= (int)str.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }
}