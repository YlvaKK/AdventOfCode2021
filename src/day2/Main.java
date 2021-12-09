package day2;

public class Main {

    public static void main(String[] args) {
        Vehicle submarine = new Vehicle();
        Navigator navigator = new Navigator(submarine);
        navigator.readDirections("submarineDirections.txt");

        System.out.println(submarine.getProductCoordinate());
    }
}
