package de.lernfit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class LuftWasserTest {

    public static void main(String[] args) {
    	
        // Simuliere Benutzereingaben
        String input = "Mohamed\n1\nBerlin\n30\n1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Fange die Ausgabe ab
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Führe das Programm aus
        LuftWasser.main(args);

        // Überprüfe die Ausgabe
        String output = outputStream.toString();
        System.setOut(System.out); // Stelle die Standardausgabe wieder her

        // Erwartete Ausgabe
        String expectedOutput = "Hallo lieber Kursteilnehmer. Bitte verrate mir Deinen Namen, tippe " +
                "ihn in die Konsole ein: \n" +
                "Hallo Mohamed!\n" +
                "Schön, dass Du hier bist! Welchen Kurs hast Du den gewählt?\n" +
                "Tippe 1 für Java\n" +
                "Tippe eine beliebige Zahl für Python\n" +
                "Schön, dass Du Dich für den Java-Kurs entschieden hast.\n" +
                "Nun gib bitte das Bundesland an, in dem Du den Kurs absolvierst\n" +
                "In welchen Abständen möchstest Du an das Wassertrinken erinnert werden. Bitte mache Deine Angaben in Minuten.\n" +
                "Hallo Mohamed,\n" +
                "\n" +
                "Du hast dich für den Java-Kurs entschieden.\n" +
                "Die Veranstaltung findet in Berlin statt und geht 30 Werktage (MO - FR) lang.\n" +
                "Du möchtest alle 30 Minuten höflich daran erinnert werden, dass Du Wasser trinken solltest.\n" +
                "\n" +
                "Wenn diese Angaben korrekt sind, gib bitte eine \"1\" ein.\n" +
                "Möchtest Du die Angaben korrigieren, so gib eine andere Zahl ein.\n" +
                "Viel Erfolg, Mohamed!\n";

        // Vergleiche die tatsächliche Ausgabe mit der erwarteten Ausgabe
        if (output.equals(expectedOutput)) {
            System.out.println("Test erfolgreich!");
        } else {
            System.out.println("Test fehlgeschlagen!");
            System.out.println("Erwartete Ausgabe:\n" + expectedOutput);
            System.out.println("Tatsächliche Ausgabe:\n" + output);
        }
    }
}



//package de.lernfit;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//import java.util.Scanner;
//
//public class LuftWasserTest {
//
//    public static void main(String[] args) {
//        // Simuliere Benutzereingaben
//        String input = "Mohamed\n1\nBerlin\n30\n1\n";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//
//        // Fange die Ausgabe ab
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        // Führe das Programm aus
//        LuftWasser.main(args);
//
//        // Überprüfe die Ausgabe
//        String output = outputStream.toString();
//        System.setOut(System.out); // Stelle die Standardausgabe wieder her
//
//        // Erwartete Ausgabe
//        String expectedOutput = "Hallo lieber Kursteilnehmer. Bitte verrate mir Deinen Namen, tippe " +
//                "ihn in die Konsole ein: \n" +
//                "Hallo Mohamed!\n" +
//                "Schön, dass Du hier bist! Welchen Kurs hast Du den gewählt?\n" +
//                "Tippe 1 für Java\n" +
//                "Tippe eine beliebige Zahl für Python\n" +
//                "Schön, dass Du Dich für den Java-Kurs entschieden hast.\n" +
//                "Nun gib bitte das Bundesland an, in dem Du den Kurs absolvierst\n" +
//                "In welchen Abständen möchstest Du an das Wassertrinken erinnert werden. Bitte mache Deine Angaben in Minuten.\n" +
//                "Hallo Mohamed,\n" +
//                "\n" +
//                "Du hast dich für den Java-Kurs entschieden.\n" +
//                "Die Veranstaltung findet in Berlin statt und geht 30 Werktage (MO - FR) lang.\n" +
//                "Du möchtest alle 30 Minuten höflich daran erinnert werden, dass Du Wasser trinken solltest.\n" +
//                "\n" +
//                "Wenn diese Angaben korrekt sind, gib bitte eine \"1\" ein.\n" +
//                "Möchtest Du die Angaben korrigieren, so gib eine andere Zahl ein.\n" +
//                "Viel Erfolg, Mohamed !\n";
//
//        // Vergleiche die tatsächliche Ausgabe mit der erwarteten Ausgabe
//        if (output.equals(expectedOutput)) {
//            System.out.println("Test erfolgreich!");
//        } else {
//            System.out.println("Test fehlgeschlagen!");
//            System.out.println("Erwartete Ausgabe:\n" + expectedOutput);
//            System.out.println("Tatsächliche Ausgabe:\n" + output);
//        }
//    }
//}
