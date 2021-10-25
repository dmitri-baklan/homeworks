import java.util.Arrays;

public class Main {
    public static void main(String... args) {

        int[] arr = new int[20];
        for (int a = 0; a < arr.length; a++) {
            int rand = (int) (Math.random() * 10);
            arr[a] = rand;
        }
        System.out.println(arr);
        Arrays.stream(arr).forEach(System.out::println);
        double avaerage = Arrays.stream(arr).average().getAsDouble();
        System.out.println("Avarage: " + avaerage);
        int min = Arrays.stream(arr).min().getAsInt();

        System.out.println("Min: " + min);

        int equals_0 = Arrays.stream(arr).filter(s -> s == 0).toArray().length;
        System.out.println("Number of 0: " + equals_0);
        int bigger_0 = Arrays.stream(arr).filter(s -> s > 0).toArray().length;
        System.out.println("Number of bigger than 0: " + bigger_0);
        Arrays.stream(arr).forEach(s -> Math.multiplyExact(s, 10));
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void switcherWork() {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Computer computer = new Computer();

        switcher.addConsumer(lamp);
        switcher.addConsumer(computer);

        switcher.addConsumer(o -> System.out.println("Hello there!"));

        switcher.switchOn();
    }
}
