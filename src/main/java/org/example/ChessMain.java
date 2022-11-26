package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class ChessMain {
    public static void main(String[] args) {

        ChessMain main = new ChessMain();
        ArrayList<Player> players = main.createPlayers();
        for (Player player: players) {
            System.out.println(player);

        }
        System.out.println();
        HashMap<String,Piece>  pieceHashMap = main.createPiece();
        System.out.println(pieceHashMap);
        System.out.println();
        main.play(players,pieceHashMap);


    }

    public ArrayList<Player> createPlayers (){
        Player whitePlayer = new Player("Beth Harmon", "harmon@rut.com"
                , true, 2000, 30);
        Player blackPlayer = new Player("Vasily Borgov", "vasborg@yandex.ru"
                , false,2500,45);
        ArrayList<Player> result = new ArrayList<>();
        result.add(whitePlayer);
        result.add(blackPlayer);
        return result;
    }
    public HashMap<String,Piece> createPiece(){
        King whiteKing = new King(new Spot("h",7),"white_king",true);
        King blackKing = new King(new Spot("d",8),"black_king",false);
        Rook whiteRook1 = new Rook(new Spot("a",7),"white_rook1",true);
        Rook whiteRook2 = new Rook(new Spot("g",7),"white_rook2",true);
        Knight blackKnight1 = new Knight( new Spot("d",6),"black_knight1",false);

        HashMap<String,Piece> pieceHashMap = new HashMap<>();
        pieceHashMap.put(whiteKing.getId(),whiteKing);
        pieceHashMap.put(blackKing.getId(),blackKing);
        pieceHashMap.put(whiteRook1.getId(),whiteRook1);
        pieceHashMap.put(whiteRook2.getId(),whiteRook2);
        pieceHashMap.put(blackKnight1.getId(),blackKnight1);

        return pieceHashMap;
    }
    public void play(ArrayList<Player> players, HashMap<String,Piece> hashMap){
      // move 1
        try {
            players.get(0).movePiece(hashMap.get("white_rook1"), new Spot("a", 8));

        }catch ( IllegalArgumentException error){
            System.out.println("The move is not correct, please try again!");
            // retry functional
        }
        players.get(1).movePiece(hashMap.get("black_knight1"), new Spot("c", 8));
    }
}