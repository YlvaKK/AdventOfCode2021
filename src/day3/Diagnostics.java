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

    public Diagnostics(String fileName){
        gammaBinary = "";
        epsilonBinary = "";
        readFile(fileName);
    }

    public ArrayList<String> getDiagnosticList(){
        ArrayList<String> copy = (ArrayList<String>) diagnosticList.clone();
        return copy;
    }

    public String getGammaBinary() {
        return gammaBinary;
    }

    public String getEpsilonBinary() {
        return epsilonBinary;
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
        int[] ones = new int[12];

        for (String line : diagnosticList) {
            for (int i = 0; i < 12; i++) {
                ones[i] += Integer.parseInt(Character.toString(line.charAt(i)));
            }
        }

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
}
