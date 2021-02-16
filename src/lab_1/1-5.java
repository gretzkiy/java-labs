// 5. Создать программу ввода целых чисел как аргументов командной строки,
// подсчета их суммы (произведения) и вывода результата на консоль.

class Lab1_5 {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            try {
                int numericArg = Integer.parseInt(arg);
                sum += numericArg;

            } catch (NumberFormatException e) {
                System.err.println("Аругмент " + arg + " должен быть целым числом.");
                System.exit(1);
            }
        }

        System.out.println("Сумма: " + sum);
    }
}