public class Computer implements ElectricityConsumer {
    @Override
    public void electricityOn(Object obj) {
        System.out.println("Computer is on!");
    }
}
