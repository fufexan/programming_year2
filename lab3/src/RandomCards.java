/*
 * 9. Define an array of String variables that will be populated with all the
 * playing cards from a complete package. A series of randomly picked cards
 * will be extracted until the current card will have the clubs sign and a
 * value greater than 8. At each step, the current card and the number of
 * already extracted cards will be displayed.
 * Hint: Use a random numbers generator. The cards which were already used are
 * eliminated.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCards {
    public static void main(String[] args) {
        String[] numbers = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};

        Random rand = new Random();

        List<String> deck = new ArrayList<String>();
        for (String s : suits) {
            for (String n : numbers)
                deck.add(n + " of " + s);
        }

        String currentCard = "";
        boolean found = false;
        do {
            int cardNum = rand.nextInt(deck.size());
            currentCard = deck.get(cardNum);
            deck.remove(cardNum);

            String[] c = currentCard.split(" ");

            if (checkSuite(c[2]) && checkNumber(c[0]))
                found = true;

            printCard(currentCard);
        } while (!found);
    }

    private static void printCard(String currentCard) {
        System.out.println(currentCard);
    }

    private static boolean checkNumber(String n) {
        boolean r = false;
        switch (n) {
            case "Nine", "Ten", "Jack", "Queen", "King", "Ace" -> r = true;
            default -> {
            }
        }
        return r;
    }

    private static boolean checkSuite(String s) {
        return s.equals("Clubs");
    }
}
