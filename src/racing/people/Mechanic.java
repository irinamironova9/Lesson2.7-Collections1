package racing.people;

import racing.transport.Transport;

import java.util.LinkedList;

public class Mechanic<T extends Transport> {

    private final String fullName;
    private String company;
    private LinkedList<T> servicedVehicles;

    public Mechanic(String fullName, String company) {
        this.fullName = Transport.parse(fullName);
        setCompany(company);
        this.servicedVehicles = new LinkedList<>();
    }

    public void serviceVehicles() {
        System.out.printf("Механик %s от компании %s провел(а) техобслуживание " +
                "для транспортных средств ", getFullName(), getCompany());

        for (T vehicle : servicedVehicles) {
            System.out.printf("%s %s, ",
                    vehicle.getBrand(),
                    vehicle.getModel());
        }

        System.out.println(".");
    }

    public void fixVehicle(T vehicle) {

        if (vehicle == null) {
            throw new IllegalArgumentException("Транспортное средство не может быть null!");
        }

        System.out.printf("Механик %s от компании %s починил(а) " +
                "транспортное средство %s %s.\n",
                getFullName(),
                getCompany(),
                vehicle.getBrand(),
                vehicle.getModel());

        if (!servicedVehicles.contains(vehicle)) {
            servicedVehicles.add(vehicle);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompany() {
        return company;
    }

    public LinkedList<T> getServicedVehicles() {
        return servicedVehicles;
    }

    public void setCompany(String company) {
        this.company = Transport.parse(company);
    }
}
