package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Diagnostics {
    private Scanner fileReader;
    private ArrayList<String> diagnosticList = new ArrayList<>();
    private String gammaBinary;
    private String epsilonBinary;

    //part 2
    private String oxygenGeneratorRatingBinary;
    private String CO2ScrubberRatingBinary;

    public Diagnostics(String fileName){
        gammaBinary = "";
        epsilonBinary = "";
        readFile(fileName);

        // part 2
        oxygenGeneratorRatingBinary = "";
        CO2ScrubberRatingBinary = "";
    }

    public ArrayList<String> getDiagnosticList(){
        ArrayList<String> copy = (ArrayList<String>) diagnosticList.clone();
        return copy;
    }

    public int getGamma() {
        return Integer.parseInt(gammaBinary, 2);
    }

    public int getEpsilon() {
        return Integer.parseInt(epsilonBinary, 2);
    }

    public int getPowerConsumption(){
        return getGamma() * getEpsilon();
    }

    public int getOxygenGeneratorRating() { return Integer.parseInt(oxygenGeneratorRatingBinary, 2); }

    public int getCO2ScrubberRating() { return Integer.parseInt(CO2ScrubberRatingBinary, 2); }

    public int getLifeSupportRating() { return getOxygenGeneratorRating() * getCO2ScrubberRating(); }

    public void readFile(String fileName){
        File file = new File(fileName);

        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: invalid file name, " + fileName + " does not exist");
        }

        while (fileReader.hasNextLine()){
            diagnosticList.add(fileReader.nextLine());
        }
    }

    public void calculateGammaAndEpsilonRates(){
        int[] ones = findNumberOfOnesPerPosition();

        for (int i = 0; i < ones.length; i++) {
            if (ones[i] > diagnosticList.size()/2){
                gammaBinary += 1;
                epsilonBinary += 0;
            } else {
                gammaBinary += 0;
                epsilonBinary += 1;
            }
        }
    }

    public int[] findNumberOfOnesPerPosition(){
        int bites = diagnosticList.get(0).length();
        int[] ones = new int[bites];

        for (String line : diagnosticList) {
            for (int i = 0; i < bites; i++) {
                //ones[i] += Integer.parseInt(Character.toString(line.charAt(i)));
                if (line.charAt(i) == '1'){
                    ones[i] ++;
                }
            }
        }

        return ones;
    }

    // part 2
    public void calculateOAndCOrates(){
        ArrayList<String> oxygen = (ArrayList<String>) diagnosticList.clone();
        ArrayList<String> carbonDioxide = (ArrayList<String>) diagnosticList.clone();

        // goes through every bit
        for (int i = 0; i < diagnosticList.get(0).length(); i++) {
            int ones = 0;
            int zeroes = 0;

            // goes through every line, counting the ones and calculating the zeroes
            for (int j = 0; j < diagnosticList.size(); j++) {
                if (diagnosticList.get(j).charAt(i) == '1'){
                    ones++;
                }
            }

            // TODO: 2021-12-13 calculate value to be kept for both lists (they're not each others pure inverse!)
            // TODO: 2021-12-13 loop through the list once for each copy, maybe that's a helper method?

        }
    }
}
