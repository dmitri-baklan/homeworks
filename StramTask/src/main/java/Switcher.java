import java.util.ArrayList;

public class Switcher {
    ArrayList<ElectricityConsumer> consumers = new ArrayList<ElectricityConsumer>();

    Switcher() {

    }

    public void addConsumer(ElectricityConsumer consumer) {
        consumers.add(consumer);
    }

    public void switchOn() {
        for (ElectricityConsumer c : consumers) {
            c.electricityOn(new Object());
        }
    }
}
