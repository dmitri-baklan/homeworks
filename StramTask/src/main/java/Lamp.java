public class Lamp implements ElectricityConsumer {
    @Override
    public void electricityOn(Object obj) {
        System.out.println("Lamp is on!");
    }
}
