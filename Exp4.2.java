/* Easy Level:
Medium Level:
 Create a program to collect and store all the cards to assist the users in finding all the cards in a given symbol using Collection interface.
 */
import java.util.*;

public class Card_Collection {
    static Map<String, List<String>> cardsBySymbol = new HashMap<>();

    public static void main(String[] args) {
        addCard("Heart", "Ace");
        addCard("Heart", "King");
        addCard("Spade", "Queen");
        addCard("Diamond", "Jack");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter symbol to search (Heart/Spade/Diamond/Club): ");
        String symbol = scanner.nextLine();

        List<String> cards = cardsBySymbol.get(symbol);
        if (cards != null) {
            System.out.println("Cards in " + symbol + ": " + cards);
        } else {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }

    static void addCard(String symbol, String cardName) {
        cardsBySymbol.computeIfAbsent(symbol, k -> new ArrayList<>()).add(cardName);
    }
}
