package Transport;

import java.time.LocalDate;
import java.util.Objects;

import static java.lang.Character.isDigit;

public class Car extends Transport {

    public static class Key {
        private String remoteEngineStart;
        private String keylessAccess;

        public Key(String remoteEngineStart, String keylessAccess) {
            if (remoteEngineStart == null || remoteEngineStart.isEmpty() || remoteEngineStart.isBlank()) {
                this.remoteEngineStart = UNKNOW_VALUES;
            } else {
                this.remoteEngineStart = remoteEngineStart;
            }
            if (keylessAccess == null || keylessAccess.isEmpty() || keylessAccess.isBlank()) {
                this.keylessAccess = UNKNOW_VALUES;
            } else {
                this.keylessAccess = keylessAccess;
            }
        }

        @Override
        public String toString() {
            return "удаленный запуск двигателя " + remoteEngineStart + ", бесключевой доступ " + keylessAccess;
        }

        public String getRemoteEngineStart() {
            return remoteEngineStart;
        }

        public String getKeylessAccess() {
            return keylessAccess;
        }
    }

    public class Insurance {
        private String validityPeriod;
        private int cost;
        private String number;

        public Insurance(String validityPeriod, int cost, String number) {
            if (validityPeriod == null || validityPeriod.isEmpty() || validityPeriod.isBlank()) {
                this.validityPeriod = UNKNOW_VALUES;
            } else {
                this.validityPeriod = validityPeriod;
            }
            this.cost = cost;
            this.number = number;
        }

        @Override
        public String toString() {
            return "срок действия страховки " + validityPeriod + ", стоимость страховки " + cost + ", номер страховки " + number;
        }

        public String getValidityPeriod() {
            return validityPeriod;
        }

        public int getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }
    }

    private String color;
    private double engineVolume;
    private String transmission;
    private String carBodyType;
    private String registrationNumber;
    private int numberOfSeats;
    private String typeOfTires;
    private Key key;
    private Insurance insurance;

    public Car(String brand, String model, int yearOfProduction, String countryOfProduction, int maxSpeed, String color) {
        this(brand, model, yearOfProduction, countryOfProduction, maxSpeed, color, 0, null, null, null, 0);
    }

    public Car(String brand, String model, int yearOfProduction, String countryOfProduction, int maxSpeed, String color, double engineVolume, String transmission, String carBodyType, String registrationNumber, int numberOfSeats) {
        super(brand, model, yearOfProduction, countryOfProduction, maxSpeed, UNKNOW_VALUES);
        this.color = checkParametr(color);
        if (engineVolume <= 0) {
            this.engineVolume = 0;
        } else {
            this.engineVolume = engineVolume;
        }
        this.transmission = checkParametr(transmission);
        this.carBodyType = checkParametr(carBodyType);

        if (registrationNumber != null && !registrationNumber.isEmpty() && !registrationNumber.isBlank() && registrationNumber.length() == 9 && !isDigit(registrationNumber.charAt(0)) && !isDigit(registrationNumber.charAt(4)) && !isDigit(registrationNumber.charAt(5)) && isDigit(registrationNumber.charAt(1)) && isDigit(registrationNumber.charAt(2)) && isDigit(registrationNumber.charAt(3)) && isDigit(registrationNumber.charAt(6)) && isDigit(registrationNumber.charAt(7)) && isDigit(registrationNumber.charAt(8))) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = UNKNOW_VALUES;
        }

        if (numberOfSeats <= 0 || numberOfSeats > 20) {
            this.numberOfSeats = 0;
        } else {
            this.numberOfSeats = numberOfSeats;
        }

       changeCarTires();
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
        if (!getColor().equals(UNKNOW_VALUES)) {
            System.out.print(", цвет " + getColor());
        }
        if (getMaxSpeed() != 0) {
            System.out.print(", макс.скорость " + getMaxSpeed() + " км/ч");
        }
        if (engineVolume != 0) {
            System.out.print(", объем двигателя " + engineVolume);
        }
        if (!transmission.equals(UNKNOW_VALUES)) {
            System.out.print(", коробка передач " + transmission);
        }
        if (!carBodyType.equals(UNKNOW_VALUES)) {
            System.out.print(", тип кузова " + carBodyType);
        }
        if (!registrationNumber.equals(UNKNOW_VALUES)) {
            System.out.print(", рег.номер " + registrationNumber);
        }
        if (numberOfSeats != 0) {
            System.out.print(", кол-во мест " + numberOfSeats);
        }
        if (!typeOfTires.equals(UNKNOW_VALUES)) {
            System.out.print(", шины " + typeOfTires);
        }
        if (key != null) {
            System.out.print(", ключ (" + key + ")");
        }
        if (insurance != null) {
            System.out.print(", страховка (" + insurance + ")");
        }
        System.out.println();
    }

    public void Refill(String refill) {
        //бензин, дизель, электричество
        if (refill.equals("бензин") || refill.equals("дизель") || refill.equals("электричество")) {
            this.refill = refill;
            System.out.println("Метод заправки автомобиля - " + refill);
        } else {
            System.out.println("Для автомобилей доступны методы заправки - бензин, дизель, электричество");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && numberOfSeats == car.numberOfSeats && Objects.equals(transmission, car.transmission) && Objects.equals(carBodyType, car.carBodyType) && Objects.equals(registrationNumber, car.registrationNumber) && Objects.equals(typeOfTires, car.typeOfTires) && Objects.equals(key, car.key) && Objects.equals(insurance, car.insurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineVolume, transmission, carBodyType, registrationNumber, numberOfSeats, typeOfTires, key, insurance);
    }

    public void changeCarTires() {
        String month = String.valueOf(LocalDate.now().getMonth());
        if (month.equals("DECEMBER") || month.equals("JANUARY") || month.equals("FEBRUARY") || month.equals("MARCH")) {
            typeOfTires = "зимние";
        } else {
            typeOfTires = "летние";
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isBlank()) {
            this.color = color;
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission.equals("механическая") || transmission.equals("автоматическая")) {
            this.transmission = transmission;
        } else {
            this.transmission = UNKNOW_VALUES;
        }
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(String carBodyType) {
        if (carBodyType != null && !carBodyType.isBlank()) {
            this.carBodyType = carBodyType;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.isEmpty() && !registrationNumber.isBlank() && registrationNumber.length() == 9 && !isDigit(registrationNumber.charAt(0)) && !isDigit(registrationNumber.charAt(4)) && !isDigit(registrationNumber.charAt(5)) && isDigit(registrationNumber.charAt(1)) && isDigit(registrationNumber.charAt(2)) && isDigit(registrationNumber.charAt(3)) && isDigit(registrationNumber.charAt(6)) && isDigit(registrationNumber.charAt(7)) && isDigit(registrationNumber.charAt(8))) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = UNKNOW_VALUES;
        }
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0 || numberOfSeats > 20) {
            this.numberOfSeats = 0;
        } else {
            this.numberOfSeats = numberOfSeats;
        }
    }

    public String getTypeOfTires() {
        return typeOfTires;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        try {
            LocalDate date = LocalDate.parse(insurance.validityPeriod);
            int result = date.compareTo(LocalDate.now());
            if (result < 0) {
                insurance.validityPeriod = "просрочен";
            }
        } catch (Exception e) {
            insurance.validityPeriod = "некорректен";
        }
        if (insurance.cost < 0) {
            insurance.cost = 0;
        }

        if (insurance.number.length() != 9) {
            insurance.number = "некорректный";
        }

        this.insurance = new Insurance(insurance.validityPeriod, insurance.cost, insurance.number);
    }
}


