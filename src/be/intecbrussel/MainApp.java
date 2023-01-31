package be.intecbrussel;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("---- Oefening - KassaSysteem ----");

        Random random = new Random();

        double broodPrijs = random.nextDouble(1, 3);
        double melkPrijs = random.nextDouble(1, 5);
        double waterPrijs = random.nextDouble(1, 3);
        double chocoPrijs = random.nextDouble(1, 7);

        int stockBrood = 5;
        int stockMelk = 5;
        int stockWater = 5;
        int stockChoco = 5;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Producten: ");
        System.out.println("brood: " + Math.round(broodPrijs) + "€");
        System.out.println("melk: " + Math.round(melkPrijs) + "€");
        System.out.println("water: " + Math.round(waterPrijs) + "€");
        System.out.println("choco: " + Math.round(chocoPrijs) + "€");

        double total = 0;
        StringBuilder gekozenProducten = new StringBuilder("");
        boolean afrekenen = false;

        while (afrekenen == false) {
            System.out.println("Voeg een product uit de bovenstaande lijst toe aan uw winkelwagen!");
            System.out.println("Typ klaar om af te rekenen !!!");
            String product = myScanner.nextLine();
            switch (product) {
                case "brood":
                    stockBrood -= 1;
                    if (stockBrood >= 0) {
                        total += Math.round(broodPrijs);
                    } else {
                        System.out.println("Sorry, we hebben geen brood meer in onze stock!");
                    }
                    gekozenProducten.insert(0, " brood: " + Math.round(broodPrijs) + "€ ->");
                    break;
                case "melk":
                    stockMelk -= 1;
                    if (stockMelk >= 0) {
                        total += Math.round(melkPrijs);
                    } else {
                        System.out.println("Sorry, we hebben geen melk meer in onze stock!");
                    }
                    gekozenProducten.insert(0, " melk: " + Math.round(melkPrijs) + "€ ->");
                    break;
                case "water":
                    stockWater -= 1;
                    if (stockWater >= 0) {
                        total += Math.round(waterPrijs);
                    } else {
                        System.out.println("Sorry, we hebben geen water meer in onze stock!");
                    }
                    gekozenProducten.insert(0, " water: " + Math.round(waterPrijs) + "€ ->");
                    break;
                case "choco":
                    stockChoco -= 1;
                    if (stockChoco >= 0) {
                        total += Math.round(chocoPrijs);
                    } else {
                        System.out.println("Sorry, we hebben geen choco meer in onze stock!");
                    }
                    gekozenProducten.insert(0, " choco: " + Math.round(chocoPrijs) + "€ ->");
                    break;
                case "klaar":
                    afrekenen = true;
                    break;
                default:
                    System.out.println("We hebben dit product niet. Sorry!!!");
            }
        }
        System.out.println("Gekozen producten =>" + gekozenProducten + " Totale prijs = " + Math.round(total) + "€");
    }
}
