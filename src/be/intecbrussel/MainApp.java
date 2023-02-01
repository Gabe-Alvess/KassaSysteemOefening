package be.intecbrussel;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("---- Oefening - KassaSysteem ----");

        Random random = new Random();
        Scanner myScanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        StringBuilder producten = new StringBuilder("");

        double broodPrijs = random.nextDouble(1, 3);
        double melkPrijs = random.nextDouble(1, 5);
        double waterPrijs = random.nextDouble(1, 3);
        double chocoPrijs = random.nextDouble(1, 7);

        int stockBrood = 5;
        int stockMelk = 5;
        int stockWater = 5;
        int stockChoco = 5;


        System.out.println("Producten: ");
        System.out.println("brood: " + df.format(broodPrijs) + "€");
        System.out.println("melk: " + df.format(melkPrijs) + "€");
        System.out.println("water: " + df.format(waterPrijs) + "€");
        System.out.println("choco: " + df.format(chocoPrijs) + "€");

        double total = 0;
        int number = 0;
        boolean afrekenen = false;

        while (afrekenen == false) {
            number++;
            if (number == 1) {
                System.out.println("Voeg een product uit de bovenstaande lijst toe aan uw winkelwagen!");
                System.out.println("Typ afrekenen als u klaar bent!!!");
            }

            String product = myScanner.nextLine();
            switch (product) {
                case "brood":
                    stockBrood--;
                    if (stockBrood >= 0) {
                        total += broodPrijs;
                        System.out.println("Brood was toegevoegd aan uw winkelwagen.");
                    } else {
                        System.out.println("Sorry, we hebben geen brood meer in onze stock!");
                    }
                    producten.append(" brood -> " + df.format(broodPrijs) + "€ ->");
                    break;
                case "melk":
                    stockMelk--;
                    if (stockMelk >= 0) {
                        total += melkPrijs;
                        System.out.println("Melk was toegevoegd aan uw winkelwagen.");
                    } else {
                        System.out.println("Sorry, we hebben geen melk meer in onze stock!");
                    }
                    producten.append(" melk -> " + df.format(melkPrijs) + "€ ->");
                    break;
                case "water":
                    stockWater--;
                    if (stockWater >= 0) {
                        total += waterPrijs;
                        System.out.println("Water was toegevoegd aan uw winkelwagen.");
                    } else {
                        System.out.println("Sorry, we hebben geen water meer in onze stock!");
                    }
                    producten.append(" water -> " + df.format(waterPrijs) + "€ ->");
                    break;
                case "choco":
                    stockChoco--;
                    if (stockChoco >= 0) {
                        total += chocoPrijs;
                        System.out.println("Choco was toegevoegd aan uw winkelwagen.");
                    } else {
                        System.out.println("Sorry, we hebben geen choco meer in onze stock!");
                    }
                    producten.append(" choco -> " + df.format(chocoPrijs) + "€ ->");
                    break;
                case "afrekenen":
                    afrekenen = true;
                    break;
                default:
                    System.out.println("We hebben dit product niet. Sorry!!!");
            }
        }
        if (total == 0) {
            System.out.println("Geen producten gekocht -> " + "Totale prijs = " + df.format(total) + "€.");
        } else {
            System.out.println("Producten:" + producten + " Totale prijs = " + df.format(total) + "€");
            System.out.println("Bedankt voor uw aankoop!");
            System.out.println("Kom snel terug!");
        }
    }
}
