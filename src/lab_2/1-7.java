// 7. Ввести n слов с консоли. Найти слово, состоящее только из различных символов.
// Если таких слов несколько, найти первое из них.

import java.util.Date;
import java.util.Scanner;
import java.util.HashSet;

class Lab1_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();

        in.nextLine();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }

        System.out.println("Слово, состоящее только из различных символов");

        for (String str : arr) {
            if (Lab1_7.consistsOfDifferentChars(str)) {
                System.out.println(str);

                Lab1_7.printMetaInfo();
                return;
            }
        }

        Lab1_7.printMetaInfo();
    }

    /**
     * Возвращает true, слово состоит только из раличных символов
     * @param str - слово для проверки
     */
    protected static boolean consistsOfDifferentChars(String str) {
        HashSet<Character> charSet = new HashSet<Character>();

        for (int i = 0; i < str.length(); i++) {
            charSet.add(str.charAt(i));
        }

        return charSet.size() == str.length();
    }

    protected static void printMetaInfo() {
        System.out.println("\n\nРазработчик: Дикарев");
        System.out.println("Дата и время получения задания: 12 февраля 2021 года, 19:00");
        System.out.println("Дата и время сдачи задания: " + new Date());
    }
}