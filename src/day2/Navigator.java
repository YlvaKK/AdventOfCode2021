package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Navigator {
    private Scanner fileReader;
    private ArrayList<String> directions = new ArrayList<>();
    private Vehicle vehicle;

    public Navigator(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void readDirections(String fileName){
        File file = new File(fileName);

        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: invalid file name, " + fileName + " does not exist");
        }

        String nextDirection;
        while (fileReader.hasNextLine()){
            executeNavigation(fileReader.nextLine());
        }
    }

    public void executeNavigation(String direction){
        String[] directionArray = direction.split(" ");

        switch (directionArray[0]){
            case "up":
                vehicle.adjustVertical(- Integer.parseInt(directionArray[1]));
                break;
            case "down":
                vehicle.adjustVertical(Integer.parseInt(directionArray[1]));
                break;
            case "forward":
                vehicle.adjustHorizontal(Integer.parseInt(directionArray[1]));
                break;
        }
    }


}
