package be.intecbrussel;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("---- Oefening - KassaSysteem ----");
        System.out.println(" ");

        Random random = new Random();
        Scanner myScanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        double broodPrijs = random.nextDouble(1, 3);
        double melkPrijs = random.nextDouble(1, 5);
        double waterPrijs = random.nextDouble(1, 3);
        double chocoPrijs = random.nextDouble(1, 7);
        double totalePrijs = 0;

        int stockBrood = 5;
        int stockMelk = 5;
        int stockWater = 5;
        int stockChoco = 5;
        int totaleStock = stockBrood + stockMelk + stockWater + stockChoco;

        int aantalBrood = 0;
        int aantalMelk = 0;
        int aantalWater = 0;
        int aantalChoco = 0;

        double totaalBrood = 0;
        double totaalMelk = 0;
        double totaalWater = 0;
        double totaalChoco = 0;


        System.out.println("Producten: ");
        System.out.println("Brood: " + df.format(broodPrijs) + "€");
        System.out.println("Melk: " + df.format(melkPrijs) + "€");
        System.out.println("Water: " + df.format(waterPrijs) + "€");
        System.out.println("Choco: " + df.format(chocoPrijs) + "€");
        System.out.println(" ");

        int number = 0;
        boolean afrekenen = false;

        while (!afrekenen) {
            number++;
            if (number == 1) {
                System.out.println("Voeg een product uit de bovenstaande lijst toe aan uw winkelwagen!");
                System.out.println("Typ afrekenen als u klaar bent!!!");
            }

            System.out.println(" ");
            String product = myScanner.nextLine();
            product = product.toLowerCase();
            System.out.println(" ");

            switch (product) {
                case "brood" -> {
                    stockBrood--;
                    totaleStock--;
                    if (stockBrood >= 0) {
                        aantalBrood++;
                        totaalBrood = broodPrijs * aantalBrood;
                        totalePrijs += broodPrijs;
                        System.out.println("Brood was toegevoegd aan uw winkelwagen.");
                    } else if (totaleStock <= 0) {
                        System.out.println("Het spijt ons, we hebben geen producten meer in onze stock! :(");
                    } else {
                        System.out.println("Sorry, we hebben geen brood meer in onze stock!");
                    }
                }
                case "melk" -> {
                    stockMelk--;
                    totaleStock--;
                    if (stockMelk >= 0) {
                        aantalMelk++;
                        totaalMelk = melkPrijs * aantalMelk;
                        totalePrijs += melkPrijs;
                        System.out.println("Melk was toegevoegd aan uw winkelwagen.");
                    } else if (totaleStock <= 0) {
                        System.out.println("Het spijt ons, we hebben geen producten meer in onze stock! :(");
                    } else {
                        System.out.println("Sorry, we hebben geen melk meer in onze stock!");
                    }
                }
                case "water" -> {
                    stockWater--;
                    totaleStock--;
                    if (stockWater >= 0) {
                        aantalWater++;
                        totaalWater = waterPrijs * aantalWater;
                        totalePrijs += waterPrijs;
                        System.out.println("Water was toegevoegd aan uw winkelwagen.");
                    } else if (totaleStock <= 0) {
                        System.out.println("Het spijt ons, we hebben geen producten meer in onze stock! :(");
                    } else {
                        System.out.println("Sorry, we hebben geen water meer in onze stock!");
                    }
                }
                case "choco" -> {
                    stockChoco--;
                    totaleStock--;
                    if (stockChoco >= 0) {
                        aantalChoco++;
                        totaalChoco = chocoPrijs * aantalChoco;
                        totalePrijs += chocoPrijs;
                        System.out.println("Choco was toegevoegd aan uw winkelwagen.");
                    } else if (totaleStock <= 0) {
                        System.out.println("Het spijt ons, we hebben geen producten meer in onze stock! :(");
                    } else {
                        System.out.println("Sorry, we hebben geen choco meer in onze stock!");
                    }
                }
                case "afrekenen" -> afrekenen = true;
                default -> System.out.println("We hebben dit product niet. Sorry!!!");
            }

        }
        if (totalePrijs == 0) {
            System.out.println("Geen producten gekocht!");
            System.out.println(" ");
            System.out.println("Het spijt ons dat we niet hebben wat je nodig had :(");
            System.out.println("De volgende keer hebben we zeker alles wat je nodig zou hebben!");
            System.out.println(" ");
            System.out.println("Kom snel terug!");
        } else {
            System.out.println("Producten:   Prijs:   Aantal:   Totaal: ");
            System.out.println("  Brood      " + df.format(broodPrijs) + "€" + "      " + aantalBrood + "x" + "       " + df.format(totaalBrood) + "€");
            System.out.println("  Melk       " + df.format(melkPrijs) + "€" + "      " + aantalMelk + "x" + "       " + df.format(totaalMelk) + "€");
            System.out.println("  Water      " + df.format(waterPrijs) + "€" + "      " + aantalWater + "x" + "       " + df.format(totaalWater) + "€");
            System.out.println("  Choco      " + df.format(chocoPrijs) + "€" + "      " + aantalChoco + "x" + "       " + df.format(totaalChoco) + "€");
            System.out.println("-----------------------------------------");
            System.out.println("Totale prijs = " + df.format(totalePrijs) + "€");
            System.out.println(" ");
            System.out.println("Bedankt voor uw aankoop!");
            System.out.println(" ");
            System.out.println("Kom snel terug!");
        }
    }
}
