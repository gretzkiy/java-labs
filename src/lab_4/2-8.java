// И 4 лаба, и 5 лаба в одном файле
// Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
// Вариант 8. interface Корабль <- class Грузовой Корабль <- class Танкер.

import java.util.Scanner;

class Lab_4_2_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String type = null;

        try {
            type = in.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
            type = "Fuel";
        }


        try {
            Tanker tanker = new Tanker(10, type);
            tanker.sail();
            tanker.honk();
            tanker.stop();
            tanker.refuel();

        } catch (CargoTypeException e) {
            System.out.println(e.getMessage());
        }

    }
}

class CargoTypeException extends Exception {
    public CargoTypeException(String message) {
        super(message);
    }
}

class Tanker extends CargoShip {
    protected String cargoType;

    public Tanker(int capacity, String cargoType) throws CargoTypeException {
        super(capacity);

        if (!cargoType.equals("Fuel")) {
            throw new CargoTypeException("Может быть только груз Fuel");
        }

        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}

class CargoShip implements Ship {
    protected int capacity;

    public CargoShip(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void sail() {
        System.out.println("Грузовой Корабль поплыл");
    }

    @Override
    public void stop() {
        System.out.println("Грузовой корабль остановился");
    }

    @Override
    public void refuel() {
        System.out.println("Грузовой корабль заправляется");
    }

    @Override
    public void honk() {
        System.out.println("Грузовой корабль гудит");
    }
}

interface Ship {
    void sail();
    void stop();
    void refuel();
    void honk();
}