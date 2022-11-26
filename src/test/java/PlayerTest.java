import org.example.ChessMain;
import org.example.Piece;
import org.example.Player;
import org.example.Spot;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class PlayerTest {

    public static ArrayList<Player> players;
    public static HashMap<String, Piece> pieceHashMap;

    // что бы в каждом тесте не делать заново играков, сообщество фигур, мы сделаем их общими для тестов с помощью  @BeforeAll
    // создав играков и создав фигуры. Ниже описанный метод @BeforeAll, будет выполняться один раз перед всеми тестами
    @BeforeAll
    public static void setUp(){
        ChessMain main = new ChessMain();
        players = main.createPlayers();
        pieceHashMap = main.createPiece();
        System.out.println(" Objects have been created ! ");
    }

    // @BeforeEach будет выполняться перед каждым выполняемым тестом
    @BeforeEach
    public void beforeEachTest(){
        System.out.println(" Running before Each ! ");
    };
    // если нам необходимо выполнять какое то действие после каждого теста @AfterEach
    @AfterEach
    public void afterEachTest(){
        System.out.println(" Running after Each ! ");
    };
    // если нам необходимо выполнять какое то действие после всех тестов  @AfterAll
    @AfterAll
    public static void tearDown(){
        System.out.println(" Running after All the test ! ");
    }

    @Test
    public void validMoveTest(){
        players.get(0).movePiece(pieceHashMap.get("white_king"),new Spot("h",8));
        Assertions.assertEquals(8, pieceHashMap.get("white_king").getSpot().getY());
    }

    @Test
    public  void invalidMovePieceColorTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(0).movePiece(pieceHashMap.get("black_king"),new Spot("h",8));
        });
    }

    @Test
    public  void invalidMoveBadSpotTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(0).movePiece(pieceHashMap.get("white_king"),new Spot("z",8));
        });
    }

    @Test
    public void playerCreationSuccessTest(){
        Player whitePlayer = new Player("Beth Harmon", "harmon@rut.com"
                , true, 2000, 30);
        Assertions.assertEquals("Beth Harmon", whitePlayer.getName());
        Assertions.assertEquals("harmon@rut.com", whitePlayer.getEmail());
        Assertions.assertTrue(whitePlayer.isWhite());
        Assertions.assertEquals(2000, whitePlayer.getRank());
        Assertions.assertEquals(30, whitePlayer.getAge());
    }

    @ParameterizedTest
    @MethodSource ("nameError")
     public void playerCreationIncorrectNameTest (String name){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Player whitePlayer = new Player(name, "harmon@rut.com", true, 2000, 30);
        });
    }
     static Stream<String> nameError(){
        return Stream.of("  ", "", null);
     }

    @ParameterizedTest
    @MethodSource ("emailError")
    public void playerCreationIncorrectEmailTest (String email){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Player whitePlayer = new Player("Beth Harmon", email, true, 2000, 30);
        });
    }

    static Stream<String> emailError(){
        return Stream.of("  ", "", null, "harmonrut.com", "harmon@rutcom", "harmonrutcom");
    }



}
