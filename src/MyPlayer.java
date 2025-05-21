import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<Boards> boards;
    public ArrayList<Boards> loseBoards;
    public ArrayList<Boards> winBoards;
    public ArrayList<Boards> withMoves;
    //Boards board = new Boards(1,0,0);
    public boolean saysYay;
    public int row;
    public int col;


    public MyPlayer() {
        columns = new int[10];
        boards = new ArrayList<>();
        loseBoards = new ArrayList<>();
        withMoves = new ArrayList<>();

        //loseBoards.add(board);
        for (int x = 0; x < loseBoards.size(); x++) {
            loseBoards.get(x).printBoards();
        }

        winBoards = new ArrayList<>();


        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        allBoards();
        resultingBoards();
        System.out.println();
        System.out.println();
        //classifyBoards();
        System.out.println();
        System.out.println("win boards: ");
        for (int x = 0; x < winBoards.size(); x++) {
            winBoards.get(x).printBoards();
        }
        System.out.println();
        System.out.println("lose boards: ");
        for (int x = 0; x < loseBoards.size(); x++) {
            loseBoards.get(x).printBoards();
        }
        System.out.println();
        boardWithRightMove();
        System.out.println();

    }

    public Point move(Chip[][] pBoard) {

        System.out.println();
        System.out.println("MyPlayer Move");


        gameBoard = pBoard;
        int column = 0;
        int row = 0;
        toColumns();

        for(int x=0;x<withMoves.size();x++) {
            if (columns[0] == withMoves.get(x).column0 && columns[1]==withMoves.get(x).column1&& columns[2]==withMoves.get(x).column2) {
                withMoves.get(x).printBoardMove();
                row=withMoves.get(x).row;
                column = withMoves.get(x).col;
            }
        }


        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;

    }

    public void toColumns() {
        for (int x = 0; x < 10; x++) {
            columns[x] = 0;
        }
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[x].length; y++) {
                if (gameBoard[x][y].isAlive) {
                  System.out.println("(" + x + "," + y + ")");

                    columns[y] += 1;

                }

            }
        }
        for (int x = 0; x < 10; x++) {
            System.out.print(columns[x] + ",");
        }
    }

    public void allBoards() {
        System.out.println();
        System.out.println("All Boards: ");
        for (int a = 1; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    for (int d = 0; d < 10; d++) {
                        for (int e = 0; e < 10; e++) {
                            for (int f = 0; f < 10; f++) {
                                for (int g = 0; g < 10; g++) {
                                    for (int h = 0; h < 10; h++) {
                                        for (int i = 0; i < 10; i++) {
                                            for (int j = 0; j < 10; j++) {
                                                if (a >= b && b >= c && c >= d && d >= e && e >= f && f >= g && g >= h && h >= i && i>=j) {
                                                    Boards board = new Boards(a, b, c, d, e, f, g, h, i, j, 0, 0);
                                                    boards.add(board);
                                                    System.out.println(a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ", " + j);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void resultingBoards() {
        System.out.println("Resulting Boards: ");
        System.out.println();
        for (int a = 1; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    for (int d = 0; d < 10; d++) {
                        for (int e = 0; e < 10; e++) {
                            for (int f = 0; f < 10; f++) {
                                for (int g = 0; g < 10; g++) {
                                    for (int h = 0; h < 10; h++) {
                                        for (int i = 0; i < 10; i++) {
                                            for (int j = 0; j < 10; j++) {
                                                if (a >= b && b >= c && c >= d && d >= e && e >= f && f >= g && g >= h && h >= i && i>=j) {

                                                    Boards startingBoard = new Boards(a,b,c,d,e,f,g,h,i,j,0,0);
                                                    System.out.println("Starting Board: " + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ", " + j);
                                                    saysYay = false;
                                                    System.out.println("Resulting Boards: ");

                                                    int w = c;
                                                    int e = b;
                                                    int f = a;


                                                    for (int C = c; C > 0; C--) {
                                                        if (c > 0 && w > 0) {
                                                            w = w - 1;
                                                            Boards board = new Boards(a, b, w,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2)) {
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,0,0);
                                                                    System.out.println("sub =");
                                                                    subBoard.printBoards();
                                                                    if(subBoard.column0>0){
                                                                        col = 0;
                                                                        row = board.column0;
                                                                    }else if(subBoard.column0==0 && subBoard.column1>0){
                                                                        col = 1;
                                                                        row = board.column1;
                                                                    }else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2>0){
                                                                        col = 2;
                                                                        row = board.column2;
                                                                    }
                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
                                                        }
                                                    }
                                                    d = c;

                                                    for (int B = b; B > 0; B--) {
                                                        if (c <= b && b > 0 && c >= 0 && e >= 0 && w >= 0) {
                                                            e = e - 1;
                                                            if (e < w) {
                                                                w = w - 1;
                                                            }
                                                            Boards board = new Boards(a, e, w,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2)) {
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,0,0);
                                                                    System.out.println("sub =");
                                                                    subBoard.printBoards();
                                                                    if(subBoard.column0>0){
                                                                        col = 0;
                                                                        row = board.column0;
                                                                    }else if(subBoard.column0==0 && subBoard.column1>0){
                                                                        col = 1;
                                                                        row = board.column1;
                                                                    }else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2>0){
                                                                        col = 2;
                                                                        row = board.column2;
                                                                    }
                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//                                if (board.column0 == 2 && board.column1 == 1 && board.column2 == 0) {
//                                    System.out.println("Lose Board");
//                                }
                                                            // System.out.println(a + ", " + e + ", " + d);
                                                        }
                                                    }
                                                    d = c;
                                                    e = b;

                                                    for (int A = a; A > 0; A--) {
                                                        if (b <= a && a > 0 && b >= 0 && c >= 0 && e >= 0 && w >= 0 && f > 0) {
                                                            f = f - 1;
                                                            if (f < e) {
                                                                e = e - 1;
                                                            }
                                                            if (e < w) {
                                                                w = w - 1;
                                                            }
                                                            Boards board = new Boards(f, e, w,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2)) {
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,0,0);
                                                                    System.out.println("sub =");
                                                                    subBoard.printBoards();
                                                                    if(subBoard.column0>0){
                                                                        col = 0;
                                                                        row = board.column0;
                                                                    }else if(subBoard.column0==0 && subBoard.column1>0){
                                                                        col = 1;
                                                                        row = board.column1;
                                                                    }else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2>0){
                                                                        col = 2;
                                                                        row = board.column2;
                                                                    }
                                                                    System.out.println("move: (" +col + "," + row + ")");
                                                                }
                                                            }
//
                                                        }

                                                    }
                                                    if (saysYay == true) {
                                                        Boards b1= new Boards(a,b,c,row,col);
                                                        winBoards.add(b1);
                                                    } else {
                                                        Boards b1 = new Boards(a,b,c,row,col);
                                                        loseBoards.add(b1);
                                                    }

                                                    startingBoard.col=col;
                                                    startingBoard.row=row;

                                                    withMoves.add(startingBoard);

                                                    System.out.println();
                                                    Boards b1 = new Boards(a,b,c,row,col);
                                                    b1.printBoardMove();
                                                    System.out.print(" (" + col + "," + row + ")");
                                                    System.out.println();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void boardWithRightMove(){
        for(int x=0;x<withMoves.size();x++){
            withMoves.get(x).printBoardMove();
        }
    }
}