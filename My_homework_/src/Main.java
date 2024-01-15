import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Task_1 (WordList)
        List<String> wordArray = new ArrayList<String>();
        wordArray = ArrayOperation.fillTheArray(wordArray);
        System.out.println("\n" + "All List\n************************");
        System.out.println(wordArray);
        System.out.println("\nUnique words\n************************");
        ArrayOperation.printUniqueWords(wordArray);

        // Task_2 (Phonebook)
        Phonebook phonebook = new Phonebook();
        phonebook.add("291117771","Ivanov");
        phonebook.add("292227772","Ivanov");
        phonebook.add("293337773","Petrov");
        phonebook.add("294447774","Petrov");
        phonebook.add("295557775","Pavlov");
        phonebook.add("296667776","Sidorov");
        phonebook.add("297777777","Sidorov");
        phonebook.add("298887778","Pavlov");
        phonebook.add("299997779","Sidorov");
        phonebook.add("290007770","Sidorov");

        System.out.println("Requests from the Phonebook\n************************");
        phonebook.get("Ivanov");
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
        phonebook.get("Pavlov");
        phonebook.get("Semenov");
    }
}