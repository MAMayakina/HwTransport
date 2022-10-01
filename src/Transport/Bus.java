package Transport;

public class Bus extends Transport {
    public Bus(String brand, String model, int yearOfProduction, String countryOfProduction, int maxSpeed) {
       super(brand, model, yearOfProduction, countryOfProduction, maxSpeed, UNKNOW_VALUES);
    }

    public void InformationAboutTransport() {
        if (!getBrand().equals(UNKNOW_VALUES)) {
            System.out.print("марка " + getBrand());
        }
        if (!getModel().equals(UNKNOW_VALUES)) {
            System.out.print(", модель " + getModel());
        }
        if (getYearOfProduction() != 0) {
            System.out.print(", год выпуска " + getYearOfProduction());
        }
        if (!getCountryOfProduction().equals(UNKNOW_VALUES)) {
            System.out.print(", страна производства " + getCountryOfProduction());
        }
        if (getMaxSpeed() != 0) {
            System.out.print(", макс.скорость " + getMaxSpeed() + " км/ч");
        }
        System.out.println();
    }

    public void Refill(String refill) {
        //бензин, дизель
        if (refill.equals("бензин") || refill.equals("дизель")) {
            this.refill=refill;
            System.out.println("Метод заправки автобуса - " +refill);
        } else {
            System.out.println("Для автобусов доступны методы заправки - бензин, дизель");
        }
    }
}
