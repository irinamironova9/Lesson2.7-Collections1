package racing.transport;

import racing.people.Mechanic;
import racing.people.Sponsor;
import racing.people.drivers.Driver;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Transport {
    private final String brand;
    private final String model;
    private double engineVolume;
    private Driver driver;
    private LinkedList<Mechanic> mechanics;
    private LinkedList<Sponsor> sponsors;

    public Transport(String brand,
                     String model,
                     Double engineVolume) {

        this.brand = parse(brand);
        this.model = parse(model);
        setEngineVolume(engineVolume);
        this.mechanics = new LinkedList<>();
        this.sponsors = new LinkedList<>();
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void doCheckup() throws FailedCheckupException;

    public static String parse(String value){
        return value != null && !value.isEmpty() && !value.isBlank() ?
                value : "(информация не указана)";
    }

    @Override
    public String toString() {
        return brand + " " + model +
                " с объёмом двигателя в " +
                engineVolume + " литров";
    }

    public final String getBrand() {
        return brand;
    }

    public final String getModel() {
        return model;
    }

    public final double getEngineVolume() {
        return engineVolume;
    }

    public final Driver getDriver() {
        return driver;
    }

    public final LinkedList<Mechanic> getMechanics() {
        return mechanics;
    }

    public final LinkedList<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume != null && engineVolume > 0 ? engineVolume : 1.5;
    }

    public void setDriver(Driver driver) {
        if (driver != null) {
            this.driver = driver;
        } else {
            throw new IllegalArgumentException("Водитель не может быть null!");
        }
    }
}
