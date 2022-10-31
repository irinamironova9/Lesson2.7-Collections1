package racing.people;

import racing.transport.Transport;

public class Sponsor<T extends Transport> {

    private final String nameOrCompany;
    private double money;

    public Sponsor(String nameOrCompany, double money) {
        this.nameOrCompany = Transport.parse(nameOrCompany);
        setMoney(money);
    }

    public void sponsorRacing(T vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Транспортное средство не может быть null!");
        }

        System.out.printf("%s проспонсировал(а) транспортное средство %s %s" +
                " на сумму %.2f руб.\n", getNameOrCompany(),
                vehicle.getBrand(), vehicle.getModel(), getMoney());
    }

    @Override
    public String toString() {
        return String.format("Спонсор %s, сумма поддержки - %.2f руб.",
                nameOrCompany, money);
    }

    public String getNameOrCompany() {
        return nameOrCompany;
    }

    public double getMoney() {
        return money;
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
