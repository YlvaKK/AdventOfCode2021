import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
       DepthMeasurements sonar = new DepthMeasurements("depthMeasurements.txt");
       int increases = sonar.countIncreases();

        System.out.println("increases: " + increases);
    }
}
