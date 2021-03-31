// И 4 лаба, и 5 лаба в одном файле
// Вариант 3. Создать класс Mobile с внутренним классом, с помощью объектов которого
// можно хранить информацию о моделях телефонов и их свойствах.

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Lab_4_1_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Mobile.Model> models = new ArrayList<Mobile.Model>();

        for (int i = 0; i < 1; i++) {
            System.out.println("Как называется модель телефона");
            String type = in.nextLine();

            int simCount = 0;

            try {
                System.out.println("Сколько в телефоне сим-карт?");
                simCount = in.nextInt();
                in.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Значение останется базовым");
            }

            boolean bluetooth = true;

            try {
                System.out.println("Есть ли в телефоне Bluetooth?");
                bluetooth = in.nextBoolean();
                in.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Значение останется базовым");
            }

            try {
                Mobile.Model model = new Mobile.Model(type, simCount, bluetooth);
                models.add(model);

            } catch (Exception e) {
                System.out.println("Введены некорректные данные. " + e.getMessage());
            }
        }
    }
}

class Mobile {
    public static class Model {
        protected String name;
        protected int sim_count = 1;
        protected boolean bluetooth = true;

        public Model(String name) throws IllegalArgumentException {
            if (name.length() <= 1) {
                throw new IllegalArgumentException("Название модели должно содержать более 1 символа");
            }

            this.name = name;
        }

        public Model(String name, int sim_count, boolean bluetooth) throws IllegalArgumentException {
            this(name);

            if (sim_count < 1) {
                throw new IllegalArgumentException("Количество сим-карт должно быть >= 1");
            }

            this.sim_count = sim_count;
            this.bluetooth = bluetooth;
        }
    }
}