package blabla.ahlberg.language_learny;

import blabla.ahlberg.glossary.Glossary;
import blabla.ahlberg.glossary.Language;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    private static boolean appIsRunning = true;
    private static final Scanner scanner = new Scanner(System.in);
    private static String menu;
    private static ArrayList<Glossary> implClasses;

    public static void main(String[] args) {

        printWelcomeText();

        try {
            setAppState();
        } catch (Exception e) {
            appIsRunning = false;
            System.err.println("There was a problem in the initialization stage of the app. Make sure that the app has the necessary language glossary resources to function correctly.");
        }

        while (appIsRunning) {
            printMenu();
            handleMenuChoice(scanner.nextLine());
        }
    }

    private static void setAppState() {
        ArrayList<String> languages = new ArrayList<>();
        ArrayList<Glossary> implClasses = new ArrayList<>();
        ServiceLoader<Glossary> loader = ServiceLoader.load(Glossary.class);
        for (Glossary glossary : loader) {
            if (glossary.getClass().isAnnotationPresent(Language.class)) {
                languages.add(glossary.getClass().getAnnotation(Language.class).value());
                implClasses.add(glossary);
            }
        }
        createMenu(languages);
        Main.implClasses = implClasses;
    }

    private static void createMenu(ArrayList<String> languages) {
        if (languages.isEmpty()) throw new RuntimeException("No languages found");

        StringBuilder stringBuilder = new StringBuilder("Choose language:\n\n");
        for (int i = 0; i < languages.size(); i++) {
            stringBuilder.append(i + 1).append(". ").append(languages.get(i)).append("\n");
        }
        stringBuilder.append("0. Quit\n");
        menu = stringBuilder.toString();
    }

    private static void handleMenuChoice(String userInput) {
        try {
            int menuChoice = Integer.parseInt(userInput);

            if (menuChoice == 0) appIsRunning = false;
            else if (menuChoice < 0 || menuChoice > implClasses.size()) System.out.println("Incorrect input, please try again.");
            else System.out.println(implClasses.get(menuChoice - 1).getGlossary());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println(menu);
    }

    private static void printWelcomeText() {
        String welcomeText = """
            
            Language LearnY
                    
            A super duper mega simple app for learning some basic vocab in different languages.
                    
            """;
        System.out.println(welcomeText);
    }
}
