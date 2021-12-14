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
                if (line.charAt(i) == '1'){
                    ones[i] ++;
                }
            }
        }
        return ones;
    }

    //PART 2
    public void calculateLifeSupport(){
        ArrayList<String> oxygenList = (ArrayList<String>) diagnosticList;
        ArrayList<String> carbonList = (ArrayList<String>) diagnosticList;

        oxygenGeneratorRatingBinary = findLifeSupportElementRating(oxygenList, '1');
        CO2ScrubberRatingBinary = findLifeSupportElementRating(carbonList, '0');


    }

    private String findLifeSupportElementRating(ArrayList<String> list, char bitToKeepIfEqual){
        //loopa genom bitpositionerna (horisontellt)

        while (list.size() > 0){
            for (int i = 0; i < list.get(0).length(); i++) {
                //loopa genom listan (vertikalt)
                int ones = 0;
                for (String value : list) {
                    if (value.charAt(i) == '1') {
                        ones++;
                    }
                }

                // calculate which bit to keep in this position
                char bitToKeep = bitToKeep(ones, list.size() - ones, bitToKeepIfEqual);

                //remove the values with the wrong bit in this position
                list = new ArrayList<>(removeWrongBitValues(i, bitToKeep, list));
                if (list.size() == 1){
                    break;
                }
            }
        }
        return list.get(0);
    }

    private ArrayList<String> removeWrongBitValues(int bitIndex, char bitToKeep, ArrayList<String> list){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).charAt(bitIndex) != bitToKeep){
                list.remove(i);
                i--; //counting up then down is ugly but i'm tired
            }
        }
        return list;
    }

    private char bitToKeep(int ones, int zeroes, char bitToKeepIfEqual){
        if (ones >= zeroes){
            return bitToKeepIfEqual;
        } else {
            return bitToKeepIfEqual == '0' ? '1' : '0';
        }
    }
}
