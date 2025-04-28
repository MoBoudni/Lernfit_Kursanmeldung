package de.lernfit;

import java.util.Scanner;

public class LuftWasser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        int kursNummer = 0;
        String kursBezeichnung = "";
        int kursDauer = 0;
        String bundesLand = "";
        int abstandWasser = 60;

        while (true) {
            System.out.println("Hallo lieber Kursteilnehmer. Bitte verrate mir Deinen Namen, tippe "
                    + "ihn in die Konsole ein: ");
            name = scanner.nextLine();

            if (isValidName(name)) {
                break;
            } else {
                System.out.println("Ungültiger Name. Bitte geben Sie nur Buchstaben ein.");
            }
        }

        System.out.println("\nHallo " + name + "!" + "\nSchön, dass Du hier bist! Welchen Kurs hast Du den gewählt?");
        System.out.println("Tippe 1 für Java");
        System.out.println("Tippe eine beliebige Zahl für Python");
        kursNummer = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (kursNummer == 1) {
            kursBezeichnung = "Java";
            kursDauer = 30;
            System.out.println("\nSchön, dass Du Dich für den Java-Kurs entschieden hast.");

        } else {
            kursBezeichnung = "Python";
            kursDauer = 60;
            System.out.println("\nSchön, dass Du Dich für den Python-Kurs entschieden hast.");
        }

        System.out.println("\nNun gib bitte das Bundesland an, in dem Du den Kurs absolvierst");
        bundesLand = scanner.nextLine();

        System.out.println("\nIn welchen Abständen möchstest Du an das Wassertrinken erinnert werden. Bitte mache Deine Angaben in Minuten.");
        abstandWasser = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("\nHallo " + name + ",\n");
        System.out.println("Du hast dich für den " + kursBezeichnung + "-Kurs entschieden.");
        System.out.println("Die Veranstaltung findet in " + bundesLand + " statt und geht " + kursDauer + " Werktage (MO - FR) lang.");
        System.out.println("Du möchtest alle " + abstandWasser + " Minuten höflich daran erinnert werden, dass Du Wasser trinken solltest.\n");
        System.out.println("Wenn diese Angaben korrekt sind, gib bitte eine \"1\" ein.");
        System.out.println("Möchtest Du die Angaben korrigieren, so gib eine andere Zahl ein.");

        if (scanner.nextInt() == 1) {
            System.out.println("\nViel Erfolg, " + name + " !");
        } else {
            LuftWasser.main(args);
        }

        scanner.close();
    }

    private static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }
}




//import java.util.Scanner;
//
//public class LuftWasser {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String name = " ";
//        int kursNummer = 0;
//        String kursBezeichnung = "";
//        int kursDauer = 0;
//        String bundesLand = "";
//        int abstandWasser = 60;
//
//        System.out.println("Hallo lieber Kursteilnehmer. Bitte verrate mir Deinen Namen, tippe "
//                + "ihn in die Konsole ein: ");
//        name = scanner.nextLine();
//
//        System.out.println("\nHallo " + name + "!"+"\nSchön, dass Du hier bist! Welchen Kurs hast Du den gewählt?");
//        System.out.println("Tippe 1 für Java");
//        System.out.println("Tippe eine beliebige Zahl für Python");
//        kursNummer = scanner.nextInt();
//        scanner.nextLine(); // Consume newline left-over
//
//        if (kursNummer == 1) {
//            kursBezeichnung = "Java";
//            kursDauer = 30;
//            System.out.println("\nSchön, dass Du Dich für den Java-Kurs entschieden hast.");
//
//        } else {
//            kursBezeichnung = "Python";
//            kursDauer = 60;
//            System.out.println("\nSchön, dass Du Dich für den Python-Kurs entschieden hast.");
//        }
//
//        System.out.println("\nNun gib bitte das Bundesland an, in dem Du den Kurs absolvierst");
//        bundesLand = scanner.nextLine();
//
//        System.out.println("\nIn welchen Abständen möchstest Du an das Wassertrinken erinnert werden. Bitte mache Deine Angaben in Minuten.");
//        abstandWasser = scanner.nextInt();
//        scanner.nextLine(); // Consume newline left-over
//
//        System.out.println("\nHallo " + name + ",\n");
//        System.out.println("Du hast dich für den " + kursBezeichnung + "-Kurs entschieden.");
//        System.out.println("Die Veranstaltung findet in " + bundesLand + " statt und geht " + kursDauer + " Werktage (MO - FR) lang.");
//        System.out.println("Du möchtest alle " + abstandWasser + " Minuten höflich daran erinnert werden, dass Du Wasser trinken solltest.\n");
//        System.out.println("Wenn diese Angaben korrekt sind, gib bitte eine \"1\" ein.");
//        System.out.println("Möchtest Du die Angaben korrigieren, so gib eine andere Zahl ein.");
//
//        if (scanner.nextInt() == 1) {
//            System.out.println("\nViel Erfolg, "+ name + " !");
//        } else {
//            LuftWasser.main(args);
//        }
//
//        scanner.close();
//    }
//}
