package day3;

public class Main {

    public static void main(String[] args) {
        Diagnostics diagnostics = new Diagnostics("diagnosticReport.txt");

        System.out.println(diagnostics.getDiagnosticList().toString());

        diagnostics.calculateGammaAndEpsilonRates();
        System.out.println(diagnostics.getGamma());
        System.out.println(diagnostics.getEpsilon());
        System.out.println(diagnostics.getPowerConsumption());

        diagnostics.calculateOAndCOrates();
        System.out.println(diagnostics.getOxygenGeneratorRating());
        System.out.println(diagnostics.getCO2ScrubberRating());
        System.out.println(diagnostics.getLifeSupportRating());

    }
}
