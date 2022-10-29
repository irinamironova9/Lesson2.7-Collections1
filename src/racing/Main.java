package racing;

import racing.people.drivers.DriverB;
import racing.people.drivers.DriverC;
import racing.people.drivers.DriverD;
import racing.transport.*;

import java.util.ArrayList;

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
        DriverB alexander = new DriverB<>("Александр", 4, audi);
        DriverB mary = new DriverB<>("Мария", 3, bmw);
        DriverB john = new DriverB<>("John", 5, kia);

        DriverC oleg = new DriverC<>("Олег", 8, volvo);
        DriverC katya = new DriverC<>("Екатерина", 6, gaz);
        DriverC jack = new DriverC<>("Jack", 5, kamaz);
        DriverC alisa = new DriverC<>("Алиса", 7, iveco);

        DriverD petr = new DriverD<>("Пётр", 7, bus1);
        DriverD liza = new DriverD<>("Лиза", 9, bus2);
        DriverD maxim = new DriverD<>("Максим", 8, bus3);
        DriverD anna = new DriverD<>("Анна", 10, bus4);



        bus1.doCheckup();
        kia.doCheckup();
        iveco.doCheckup();

        doCheckupForAll(lada, audi, bmw, kia,
                volvo, gaz, kamaz, iveco,
                bus1, bus2, bus3, bus4);

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

    }

    public static void doCheckupForAll(Transport... vehicles)
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
