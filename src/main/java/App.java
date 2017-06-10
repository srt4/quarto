import controller.CliPlayer;
import controller.DillyPlayer;
import controller.Player;
import controller.QuartoGame;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new QuartoGame(getPlayer("Player 1", scanner), getPlayer("Player 2", scanner)).play();
    }

    private static Player getPlayer(final String playerName, final Scanner scanner) {
        do {
            System.out.println("Enter player type for " + playerName + ": {CliPlayer, DillyPlayer}");
            final String playerType = scanner.nextLine();
            if (playerType.equalsIgnoreCase(CliPlayer.class.getSimpleName())) {
                return new CliPlayer(new Scanner(System.in), playerName);
            }
            else if (playerType.equalsIgnoreCase(DillyPlayer.class.getSimpleName())) {
                return new DillyPlayer();
            }
        }
        while (true);
    }

}
