// абстрактный класс машина
abstract class Machine {
    private String model;
    private int power;

    public Machine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public abstract void operate();

    public void checkFuel(int fuelLevel) {
        if (fuelLevel < 20) {
            System.out.println("Нужно заправиться!");
        } else {
            System.out.println("Топлива достаточно.");
        }
    }
}

// интерфейс для управления
interface Drivable {
    void drive();
}

// интерфейс для работы с навесным оборудованием
interface AttachEquipment {
    void attach();
}

// класс трактор с реализацией двух интерфейсов
class Tractor extends Machine implements Drivable, AttachEquipment {
    private boolean hasPlow;

    public Tractor(String model, int power, boolean hasPlow) {
        super(model, power);
        this.hasPlow = hasPlow;
    }

    @Override
    public void operate() {
        System.out.println("Трактор " + getModel() + " в работе.");
    }

    @Override
    public void drive() {
        System.out.println("Трактор едет.");
    }

    @Override
    public void attach() {
        if (hasPlow) {
            System.out.println("Навесное оборудование присоединено.");
        } else {
            System.out.println("Отсутствует навесное оборудование.");
        }
    }

    public static void checkEngine() {
        System.out.println("Проверка двигателя трактора.");
    }
}

// класс комбайн с реализацией одного интерфейса
class Harvester extends Machine implements Drivable {
    private int grainCapacity;

    public Harvester(String model, int power, int grainCapacity) {
        super(model, power);
        this.grainCapacity = grainCapacity;
    }

    @Override
    public void operate() {
        System.out.println("Комбайн " + getModel() + " убирает урожай.");
    }

    @Override
    public void drive() {
        System.out.println("Комбайн движется по полю.");
    }

    public void harvestGrain(int grainAmount) {
        if (grainAmount > grainCapacity) {
            System.out.println("Переполнение бункера!");
        } else {
            System.out.println("Урожай собран.");
        }
    }

    public static void checkBlades() {
        System.out.println("Проверка лезвий комбайна.");
    }
}

// тестирование модели
public class Main {
    public static void main(String[] args) {
        Tractor tractor = new Tractor("John Deere", 120, true);
        tractor.operate();
        tractor.drive();
        tractor.attach();
        Tractor.checkEngine();

        Harvester harvester = new Harvester("Claas", 300, 500);
        harvester.operate();
        harvester.drive();
        harvester.harvestGrain(600);
        Harvester.checkBlades();
    }
}