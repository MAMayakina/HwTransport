package Transport;

public class Train extends Transport {
    private int priceOfTrip;
    private String startStation;
    private String finalStation;
    private int numberWagon;

    public Train(String brand, String model, int yearOfProduction, String countryOfProduction, int maxSpeed) {
        this(brand, model, yearOfProduction, countryOfProduction, maxSpeed, 0, null, null, 0);
    }

    public Train(String brand, String model, int yearOfProduction, String countryOfProduction, int maxSpeed, int priceOfTrip, String startStation, String finalStation, int numberWagon) {
        super(brand, model, yearOfProduction, countryOfProduction, maxSpeed, UNKNOW_VALUES);
        if (priceOfTrip <= 0) {
            this.priceOfTrip = 0;
        } else {
            this.priceOfTrip = priceOfTrip;
        }
        this.startStation = checkParametr(startStation);
        this.finalStation = checkParametr(finalStation);
        if (numberWagon <= 0) {
            this.numberWagon = 0;
        } else {
            this.numberWagon = numberWagon;
        }
    }

    private String checkParametr(String parametr) {
        if (parametr != null && !parametr.isEmpty() && !parametr.isBlank()) {
            return parametr;
        } else return UNKNOW_VALUES;
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
        if (priceOfTrip != 0) {
            System.out.print(", цена поездки " + priceOfTrip);
        }
        if (!startStation.equals(UNKNOW_VALUES)) {
            System.out.print(", станция отправления " + startStation);
        }
        if (!finalStation.equals(UNKNOW_VALUES)) {
            System.out.print(", конечная остановка " + finalStation);
        }
        if (numberWagon != 0) {
            System.out.print(", кол-во вагонов " + numberWagon);
        }
        System.out.println();
    }

    public void Refill(String refill) {
        //дизель
        if (refill.equals("дизель")) {
            this.refill = refill;
            System.out.println("Метод заправки поезда - " + refill);
        } else {
            System.out.println("Для поездов доступен только метод заправки - дизель");
        }
    }

    public int getPriceOfTrip() {
        return priceOfTrip;
    }

    public void setPriceOfTrip(int priceOfTrip) {
        if (priceOfTrip > 0) {
            this.priceOfTrip = priceOfTrip;
        }
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        if (startStation != null && !startStation.isEmpty() && !startStation.isBlank()) {
            this.startStation = startStation;
        }
    }

    public String getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(String finalStation) {
        if (finalStation != null && !finalStation.isEmpty() && !finalStation.isBlank()) {
            this.finalStation = finalStation;
        }
    }

    public int getNumberWagon() {
        return numberWagon;
    }

    public void setNumberWagon(int numberWagon) {
        if (numberWagon > 0) {
            this.numberWagon = numberWagon;
        }
    }
}
