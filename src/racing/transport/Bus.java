package racing.transport;

import java.util.concurrent.ThreadLocalRandom;

public final class Bus extends Transport implements Competing {

    public enum CapacityType {

        VERY_SMALL("особо малая (до 10 мест)"),
        SMALL("малая (до 25 мест)"),
        REGULAR("средняя (40-50 мест)"),
        LARGE("большая (60-80 мест)"),
        VERY_LARGE("особо большая (100-120 мест)");

        private final String capacityTypeName;

        CapacityType(String capacityTypeName) {
            this.capacityTypeName = capacityTypeName;
        }

        public static void displayBusCapacityType(Bus bus) {
            if (bus.getCapacityType() == null) {
                System.out.printf("Нет данных о типе вместимости автобуса %s %s.\n",
                        bus.getBrand(), bus.getModel());
                return;
            }
            for (int i = 0; i < CapacityType.values().length; i++) {
                if (bus.getCapacityType().equals(CapacityType.values()[i])) {
                    System.out.printf("Тип вместимости автобуса %s %s - %s.\n",
                            bus.getBrand(), bus.getModel(),
                            CapacityType.values()[i].getCapacityTypeName());
                }
            }
        }

        @Override
        public String toString() {
            return capacityTypeName;
        }

        public String getCapacityTypeName() {
            return capacityTypeName;
        }
    }

    private final CapacityType capacityType;

    public Bus(String brand,
               String model,
               Double engineVolume,
               CapacityType capacityType) {

        super(brand, model, engineVolume);
        this.capacityType = capacityType;
    }

    @Override
    public void startMoving() {
        System.out.printf("Автобус %s %s начал движение.\n", getBrand(), getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Автобус %s %s закончил движение.\n", getBrand(), getModel());
    }

    @Override
    public void doCheckup() {
        System.out.printf("Автобус %s %s не нуждается в диагностике.\n",
                getBrand(),
                getModel());
    }

    @Override
    public String toString() {
        return "Автобус " +
                super.toString() + " и вместимостью типа '" +
                capacityType + "'";
    }

    @Override
    public void pitStop() {
        System.out.printf("Автобус %s %s совершил пит-стоп.\n", getBrand(), getModel());
    }

    @Override
    public void getBestLapTime() {
        System.out.printf("Лучшее время круга автобуса %s %s - %s секунд.\n",
                getBrand(),
                getModel(),
                ThreadLocalRandom.current().nextInt(1, 1000));
    }

    @Override
    public void getMaxSpeed() {
        System.out.printf("Максимальная скорость автобуса %s %s - %s км/ч.\n",
                getBrand(),
                getModel(),
                ThreadLocalRandom.current().nextInt(1, 300));
    }

    public CapacityType getCapacityType() {
        return capacityType;
    }
}
