package racing;

import racing.people.Mechanic;
import racing.people.Sponsor;
import racing.people.drivers.DriverB;
import racing.people.drivers.DriverC;
import racing.people.drivers.DriverD;
import racing.transport.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FailedCheckupException {

        Car lada = new Car("Lada", "Grande",1.7,
                Car.BodyType.SEDAN);
        Car audi = new Car("Audi", "A8 50 L TDI quattro",3.0,
                "   ");
        Car bmw = new Car("BMW", "Z8",3.0,
                "ПИКАП");
        Car kia = new Car("KIA", "Sportage 4",2.4,
                Car.BodyType.VAN);

        Truck volvo = new Truck("Volvo", "FH16", 7.0,
                Truck.LoadCapacityType.N1);
        Truck gaz = new Truck("ГАЗ", "3307", 8.0,
                Truck.LoadCapacityType.N2);
        Truck kamaz = new Truck("КАМАЗ", "65115", 6.5,
                null);
        Truck iveco = new Truck("Iveco", "S-Way", 9.4,
                Truck.LoadCapacityType.N3);

        Bus bus1 = new Bus("JHF", "B-43", 6.0,
                Bus.CapacityType.LARGE);
        Bus bus2 = new Bus("VLJHF", "hf 321", 6.3,
                Bus.CapacityType.SMALL);
        Bus bus3 = new Bus("Toyota", "Bus-157", 6.5,
                null);
        Bus bus4 = new Bus("PAZ", "3205", 6.5,
                Bus.CapacityType.VERY_LARGE);

        DriverB veronica = new DriverB<>("Вероника", 6, lada);
        lada.setDriver(veronica);
        DriverB alexander = new DriverB<>("Александр", 4, audi);
        audi.setDriver(alexander);
        DriverB mary = new DriverB<>("Мария", 3, bmw);
        bmw.setDriver(mary);
        DriverB john = new DriverB<>("John", 5, kia);
        kia.setDriver(john);

        DriverC oleg = new DriverC<>("Олег", 8, volvo);
        volvo.setDriver(oleg);
        DriverC katya = new DriverC<>("Екатерина", 6, gaz);
        gaz.setDriver(katya);
        DriverC jack = new DriverC<>("Jack", 5, kamaz);
        kamaz.setDriver(jack);
        DriverC alisa = new DriverC<>("Алиса", 7, iveco);
        iveco.setDriver(alisa);

        DriverD petr = new DriverD<>("Пётр", 7, bus1);
        bus1.setDriver(petr);
        DriverD liza = new DriverD<>("Лиза", 9, bus2);
        bus2.setDriver(liza);
        DriverD maxim = new DriverD<>("Максим", 8, bus3);
        bus3.setDriver(maxim);
        DriverD anna = new DriverD<>("Анна", 10, bus4);
        bus4.setDriver(anna);

//        bus1.doCheckup();
//        kia.doCheckup();
//        iveco.doCheckup();

        ArrayList<Transport> competingList = new ArrayList<>();
        competingList.add(lada);
        competingList.add(audi);
        competingList.add(bmw);
        competingList.add(kia);
        competingList.add(volvo);
        competingList.add(gaz);
        competingList.add(kamaz);
        competingList.add(iveco);
        competingList.add(bus1);
        competingList.add(bus2);
        competingList.add(bus3);
        competingList.add(bus4);

//        doCheckupForAll(competingList);

        Sponsor vladimir = new Sponsor("Владимир", 500_000);
        Sponsor hannah = new Sponsor("Hannah", 600_000);
        Sponsor jane = new Sponsor("Jane", 480_000);
        kia.getSponsors().add(vladimir);
        kia.getSponsors().add(hannah);
        kia.getSponsors().add(jane);

        Mechanic olga = new Mechanic<>("Ольга", "Wheels");
        Mechanic sasha = new Mechanic<>("Саша", "Fiery Motors");
        Mechanic susan = new Mechanic<>("Susan", "Browne`s");
        kia.getMechanics().add(olga);
        kia.getMechanics().add(sasha);
        kia.getMechanics().add(susan);

//        kia.printVehiclesPeople();

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addToQueue(lada);
        serviceStation.addToQueue(gaz);
        serviceStation.addToQueue(audi);
        serviceStation.addToQueue(volvo);
        serviceStation.addToQueue(kia);
        serviceStation.addToQueue(bus1);
        serviceStation.addToQueue(bmw);
        serviceStation.addToQueue(kamaz);
        serviceStation.addToQueue(iveco);

        serviceStation.service();
    }

    public static void doCheckupForAll(List<Transport> vehicles)
            throws FailedCheckupException {
        try {
            for (Transport transport : vehicles) {
                transport.doCheckup();
            }
        } catch (FailedCheckupException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Диагностика прекращена.");
        }
    }
}
