import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DepthMeasurements {
    private File file;
    private Scanner fileReader;
    private ArrayList<Integer> listOfMeasurements = new ArrayList<>();

    public DepthMeasurements(String filename){
        file = new File(filename);
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: invalid file name, " + filename + " does not exist");
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
}
