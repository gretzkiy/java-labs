// И 4 лаба, и 5 лаба в одном файле
// Вариант 1. Создать класс City (город) с внутренним классом, с помощью объектов которого можно
// хранить информацию о проспектах, улицах, площадях.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

class Lab_4_1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<City.CityPart> cityParts = new ArrayList<City.CityPart>();

        for (int i = 0; i < 1; i++) {
            System.out.println("Что это?");
            String type = in.nextLine();

            System.out.println("Как называется " + type + "?");
            String name = in.nextLine();

            int housesCount = 0;

            try {
                System.out.println("Сколько там домов?");
                housesCount = in.nextInt();
                in.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Значение останется базовым");
            }

            boolean needRenovation = false;

            try {
                System.out.println("Требуется ли реновация?");
                needRenovation = in.nextBoolean();
                in.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Значение останется базовым");
            }

            try {
                City.CityPart cityPart = new City.CityPart(type, name, housesCount, needRenovation);
                cityParts.add(cityPart);

            } catch (Exception e) {
                System.out.println("Введены некорректные данные. Эта часть не будет добавлена в город. " + e.getMessage());
            }
        }

        System.out.println("Город состоит из:");
        for (City.CityPart part: cityParts) {
            System.out.println(part);
        }
    }
}

class City {
    public static class CityPart {
        protected String name;
        protected int housesCount = 0;
        protected boolean needRenovation = false;
        protected String type;

        public CityPart(String type, String name, int housesCount, boolean needRenovation) {
            this(type, name, housesCount);
            this.needRenovation = needRenovation;
        }

        public CityPart(String type, String name, int housesCount) throws IllegalArgumentException {
            this(type, name);

            if (housesCount < 0) {
                throw new IllegalArgumentException("Количество домов не может быть меньше нуля");
            }

            this.housesCount = housesCount;
        }

        public CityPart(String type, String name) throws IllegalArgumentException {
            HashSet<String> types = new HashSet<String>();
            types.add("Улица");
            types.add("Площадь");
            types.add("Проспект");

            if (!types.contains(type)) {
                throw new IllegalArgumentException("Тип " + type + " не поддерживатеся");
            }

            this.type = type;
            this.name = name;
        }

        public String getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public int getHousesCount() {
            return this.housesCount;
        }

        public boolean isNeedRenovation() {
            return this.needRenovation;
        }

        @Override
        public String toString() {
            String res = this.type + " " + this.name;

            if (this.housesCount > 0) {
                res += "\n\t" + this.housesCount + " домов";
            }

            if (this.isNeedRenovation()) {
                res += "\n\tтребуется реновация";
            }

            res += "\n";

            return res;
        }
    }
}