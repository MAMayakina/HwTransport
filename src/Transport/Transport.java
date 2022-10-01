package Transport;

import java.util.Objects;

public abstract class Transport {
    public static final String UNKNOW_VALUES = "неизвестно";

    private String brand;
    private String model;
    private int yearOfProduction;
    private String countryOfProduction;
    private int maxSpeed;
    protected String refill;

    public Transport(String brand, String model, int yearOfProduction, String countryOfProduction, int maxSpeed, String refill) {
        this.brand = checkParametr(brand);
        this.model = checkParametr(model);
        if (yearOfProduction < 1950) {
            this.yearOfProduction = 0;
        } else {
            this.yearOfProduction = yearOfProduction;
        }
        this.countryOfProduction = checkParametr(countryOfProduction);
        if (maxSpeed < 0) {
            this.maxSpeed = 0;
        } else {
            this.maxSpeed = maxSpeed;
        }
        this.refill=UNKNOW_VALUES;
    }

    private String checkParametr(String parametr) {
        if (parametr == null || parametr.isBlank()) {
            parametr = UNKNOW_VALUES;
        }
        return parametr;
    }

    public abstract void InformationAboutTransport();

    public abstract void Refill(String refill);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return yearOfProduction == transport.yearOfProduction && maxSpeed == transport.maxSpeed && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) && Objects.equals(countryOfProduction, transport.countryOfProduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfProduction, countryOfProduction, maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (this.brand.equals(UNKNOW_VALUES) && brand != null && !brand.isBlank()) {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (this.model.equals(UNKNOW_VALUES) && model != null && !model.isBlank()) {
            this.model = model;
        }
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        if (this.yearOfProduction == 0 && yearOfProduction >1950) {
            this.yearOfProduction = yearOfProduction;
        }
    }

    public String getCountryOfProduction() {
        return countryOfProduction;
    }

    public void setCountryOfProduction(String countryOfProduction) {
        if (this.countryOfProduction.equals(UNKNOW_VALUES) && countryOfProduction != null && !countryOfProduction.isBlank()) {
            this.countryOfProduction = countryOfProduction;
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        }
    }

    public String getRefill() {
        return refill;
    }


}
