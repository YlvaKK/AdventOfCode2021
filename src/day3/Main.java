package day3;

public class Main {

    public static void main(String[] args) {
        Diagnostics diagnostics = new Diagnostics("diagnosticReport.txt");

        System.out.println(diagnostics.getDiagnosticList().toString());

        diagnostics.calculateGammaAndEpsilonRates();
        System.out.println("gamma: " + diagnostics.getGamma());
        System.out.println("epsilon: " + diagnostics.getEpsilon());
        System.out.println("power consumption: " + diagnostics.getPowerConsumption() + "\n");

        diagnostics.calculateLifeSupport();
        System.out.println("Oxygen generator rating: " + diagnostics.getOxygenGeneratorRating());
        System.out.println("CO2 scrubber rating: " + diagnostics.getCO2ScrubberRating());
        System.out.println("Life support rating: " + diagnostics.getLifeSupportRating());

    }
}
