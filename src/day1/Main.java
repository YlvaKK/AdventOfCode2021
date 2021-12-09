package day1;

public class Main {

    public static void main(String[] args){
       DepthMeasurements sonar = new DepthMeasurements("depthMeasurements.txt");
       int increases = sonar.countIncreases();
       int windowIncreases = sonar.countIncreasesSlidingWindow();



        System.out.println("increases: " + increases);

        System.out.println("sliding window increases: " + windowIncreases);
    }
}
