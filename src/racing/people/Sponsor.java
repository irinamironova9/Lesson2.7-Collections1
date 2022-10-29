package racing.people;

import org.w3c.dom.ls.LSOutput;
import racing.transport.Transport;

import java.util.LinkedList;

public class Sponsor<T extends Transport> {

    private final String nameOrCompany;
    private double money;
    private LinkedList<T> sponsoredVehicles;

    public Sponsor(String nameOrCompany, double money) {
        this.nameOrCompany = Transport.parse(nameOrCompany);
        setMoney(money);
        this.sponsoredVehicles = new LinkedList<>();
    }

    public void sponsorRacing() {
        System.out.printf("%s проспонсировал(а) транспортные средства ",
                getNameOrCompany());

        for (T vehicle : sponsoredVehicles) {
            System.out.printf("%s %s, ",
                    vehicle.getBrand(),
                    vehicle.getModel());
        }

        System.out.printf(" на сумму %.2f руб. каждое.\n", getMoney());
    }

    public String getNameOrCompany() {
        return nameOrCompany;
    }

    public double getMoney() {
        return money;
    }

    public LinkedList<T> getSponsoredVehicles() {
        return sponsoredVehicles;
    }

    public void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Сумма поддержки не может быть " +
                    "отрицательной или равной нулю.");
        }
    }
}
