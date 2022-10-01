import Transport.Bus;
import Transport.Car;
import Transport.Train;

public class Main {
    public static void main(String[] args) {

        //Работаем с классом Car
        Car car1 = new Car("Lada", "Lada Grante", 0, "Россия", 180, "желтый", 1.7, "механическая", "седан", "х231ао512", 5);
        Car car2 = new Car("Audi", "Audi A8 50 L TDI quattro", 2020, "Германия", 250, "черный");
        Car car3 = new Car("BMW", "BMW Z8", 2021, "Германия", 250, "черный");
        Car car4 = new Car("Kia", "Kia Sportage 4", 2018, "Южная Корея", 185, "красный");
        Car car5 = new Car("Hyundai", "Hyundai Avante", 2016, null, 195, "оранжевый");

        car2.setKey(new Car.Key("есть", "есть"));
        car3.setInsurance(car3.new Insurance("2020-09-10", 12000, "atk442021"));
        System.out.println("Информация об автомобилях:");
        car1.InformationAboutTransport();
        car2.InformationAboutTransport();
        car3.InformationAboutTransport();
        car4.InformationAboutTransport();
        car5.InformationAboutTransport();

        System.out.println("До смены шин car1: " + car1.getTypeOfTires());
        car1.changeCarTires();
        System.out.println("После смены шин car1: " + car1.getTypeOfTires());

        //работаем с классом Train
        Train train1 = new Train("Ласточка", "B-901", 2011, "Россия", 301, 3500, "Белорусский вокзал", "Минск-Пассажирский", 11);
        Train train2 = new Train("Ленинград", "D-125", 2011, "Россия", 270, 1700, "Ленинградский вокзал", "Ленинград-Пассажирский", 8);

        System.out.println("Информация о поездах:");
        train1.InformationAboutTransport();
        train2.InformationAboutTransport();

        //работаем с классом Bus
        Bus bus1 = new Bus("Вектор", "Вектор Next 8.8", 2020, "Россия", 100);
        Bus bus2 = new Bus("Лиаз", "Лиаз-6213", 2018, "Россия", 90);
        Bus bus3 = new Bus("Кавз", "Кавз-4270", 2019, "Россия", 2100);

        System.out.println("Информация об автобусах:");
        bus1.InformationAboutTransport();
        bus2.InformationAboutTransport();
        bus3.InformationAboutTransport();

        //refill
        System.out.println("Заправка:");

        //для автомобилей - бензин, дизель, электричество
        System.out.print("car1: ");
        car1.Refill("бензин");
        System.out.print("car2: ");
        car2.Refill("дизель");
        System.out.print("car3: ");
        car3.Refill("электричество");
        System.out.print("car4: ");
        car4.Refill("компот");

        //для поездов - дизель
        System.out.print("train1: ");
        train1.Refill("бензин");
        System.out.print("train2: ");
        train2.Refill("дизель");

        //для автобусов - бензин, дизель
        System.out.print("bus1: ");
        bus1.Refill("бензин");
        System.out.print("bus2: ");
        bus2.Refill("дизель");
        System.out.print("bus3: ");
        bus3.Refill("электричество");
    }
}