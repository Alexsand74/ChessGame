package org.example;

import java.util.ArrayList;

public class ChessMain {
    public static void main(String[] args) {
/*        Player whitePlayer = new Player("Beth Harmon", "harmon@rut.com"
                , true, 2000, 30);
        Player blackPlayer = new Player("Vasily Borgov", "vasborg@yandex.ru"
                , false,2500,45);

//       Beth Harmon "harmon@rut.com"

//        System.out.println("The Player 1 name is - " + whitePlayer.getName());
//        System.out.println( whitePlayer.getName() + " her mail - " + whitePlayer.getEmail());
//        System.out.println( whitePlayer.getName() + " has a rank - " + whitePlayer.getRank());
//        System.out.println( whitePlayer.getName() + " has an age - " + whitePlayer.getAge());
//        System.out.println( whitePlayer.getName() + " plays the color of the figures - " + whitePlayer.isWhite());
//        System.out.println("The Player 2 name is - " + blackPlayer.getName());
//        System.out.println( blackPlayer.getName() + " her mail - " + blackPlayer.getEmail());
//        System.out.println( blackPlayer.getName() + " has a rank - " + blackPlayer.getRank());
//        System.out.println( blackPlayer.getName() + " has an age - " + blackPlayer.getAge());
//        System.out.println( blackPlayer.getName() + " plays the color of the figures - " + blackPlayer.isWhite());

        System.out.println(whitePlayer);
        System.out.println();

//        Player testError = null;
//        testError.getName();

        System.out.println(blackPlayer);
        System.out.println();
// try {

    whitePlayer.setRank(3000);

// } catch ( IllegalArgumentException eer){
//    System.out.println("Please enter a new valid value ! in method ChessMain ");
// }
//        blackPlayer.setRank(-100);
        System.out.println(whitePlayer.getName() + " - " + whitePlayer.getRank());
        System.out.println();
        System.out.println(" The program has reached its end.");
*/

        ChessMain main = new ChessMain();
        ArrayList<Player> players = main.createPlayers();
        for (Player player: players) {
            System.out.println(player);
        }
    }

    public ArrayList<Player> createPlayers (){
        Player whitePlayer = new Player("Beth Harmon", "harmon@rut.com"
                , true, 2000, 30);
        Player blackPlayer = new Player("Vasily Borgov", "vasborg@yandex.ru"
                , false,2500,45);
        ArrayList<Player> result = new ArrayList<>();
        result.add(whitePlayer);
        result.add(whitePlayer);
        return result;
    }
}