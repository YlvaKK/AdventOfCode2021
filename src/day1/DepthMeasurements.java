package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DepthMeasurements {
    private Scanner fileReader;
    private final ArrayList<Integer> listOfMeasurements = new ArrayList<>();

    public DepthMeasurements(String fileName){
        File file = new File(fileName);

        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: invalid file name, " + fileName + " does not exist");
        }

        addToList();
    }

    private void addToList(){
        while (fileReader.hasNextLine()){
            listOfMeasurements.add(fileReader.nextInt());
            fileReader.nextLine();
        }
    }

    public int countIncreases(){
        int increases = 0;
        for (int i = 1; i < listOfMeasurements.size(); i++) {
            if (listOfMeasurements.get(i) > listOfMeasurements.get(i-1)){
                increases++;
            }
        }
        return increases;
    }

    public int countIncreasesSlidingWindow(){
        int increases = 0;
        for (int i = 0; i < listOfMeasurements.size() - 3; i++){

            int a = listOfMeasurements.get(i) + listOfMeasurements.get(i+1)
                    + listOfMeasurements.get(i+2);
            int b = listOfMeasurements.get(i+1) + listOfMeasurements.get(i+2)
                    + listOfMeasurements.get(i+3);

            if (b > a){
                increases++;
            }
        }
        return increases;
    }
}
