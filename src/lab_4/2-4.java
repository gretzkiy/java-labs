// И 4 лаба, и 5 лаба в одном файле
// Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
// Вариант 4. interface Здание <- abstract class Общественное Здание <- class Театр.

import java.util.Scanner;

class Lab_4_2_4 {
    public static void main(String[] args) {
        String hours = null;

        try {
            hours = readWorkingHours();

        } catch (WorkingHoursException e) {
            e.printStackTrace();
            hours = "С 9 до 21";
        }

        Theater theater = new Theater(true, hours);

        System.out.println(theater.isOpened());
        System.out.println(theater.getWorkingHours());
        theater.close();
        System.out.println(theater.isOpened());
    }

    public static String readWorkingHours() throws WorkingHoursException {
        Scanner in = new Scanner(System.in);

        try {
            String hours = in.nextLine();
            return hours;

        } catch (Exception e) {
            throw new WorkingHoursException("Неверный ввод данных");
        }
    }
}

class WorkingHoursException extends Exception {
    public WorkingHoursException(String message) {
        super(message);
    }
}

class Theater extends PublicBuilding {
    public Theater(boolean isOpened, String workingHours) {
        super(isOpened, workingHours);
    }

    @Override
    String getName() {
        return "Театр";
    }

    @Override
    String getAddress() {
        return "Центральная площадь, д. 1";
    }
}

interface Building {
    void close();
    void open();
}

abstract class PublicBuilding implements Building {
    protected boolean isOpened = true;
    protected String workingHours;

    public PublicBuilding(boolean isOpened, String workingHours) {
        this.isOpened = isOpened;
        this.workingHours = workingHours;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public String getWorkingHours() {
        return this.workingHours;
    }

    abstract String getName();
    abstract String getAddress();

    @Override
    public void close() {
        this.isOpened = false;
    }

    @Override
    public void open() {
        this.isOpened = true;
    }
}