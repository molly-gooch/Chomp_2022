import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<Boards> boards;


    public MyPlayer() {
        columns = new int[10];
        boards = new ArrayList<Boards>(20);


        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println();
        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        toColumns();
        allBoards();
        resultingBoards();
        System.out.println();
        System.out.println();
        classifyBoards();


        row = 1;
        column = 1;

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
        System.out.println("All 19 Boards: ");
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {
                    if (a >= b && b >= c) {
                        Boards board = new Boards(a,b,c);
                        boards.add(board);
                        System.out.println(a + ", " + b + ", " + c);
                    }
                }
            }
        }
    }

    public void resultingBoards() {
        System.out.println("Resulting Boards: ");
        System.out.println();
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {

                    if (a >= b && b >= c) {
                        //System.out.println(a + ", " + b + ", " + c);
                        System.out.println("Starting Board: " + a + ", " + b + ", " + c);
                        System.out.println("Resulting Boards: ");

                        int d = c;
                        int e = b;
                        int f = a;


                        for (int C = c; C > 0; C--) {
                            if (c > 0 && d > 0) {
                                d = d - 1;
                                Boards board = new Boards(a, b, d);
                                board.printBoards();
//                                if (board.column0 == 2 && board.column1 == 1 && board.column2 == 0) {
//                                    System.out.println("Lose Board");
//                                }
                                // System.out.println(a + ", " + b + ", " + d);
                            }
                        }
                        d = c;

                        for (int B = b; B > 0; B--) {
                            if (c <= b && b > 0 && c >= 0 && e >= 0 && d >= 0) {
                                e = e - 1;
                                if (e < d) {
                                    d = d - 1;
                                }
                                Boards board = new Boards(a, e, d);
                                board.printBoards();
//                                if (board.column0 == 2 && board.column1 == 1 && board.column2 == 0) {
//                                    System.out.println("Lose Board");
//                                }
                                // System.out.println(a + ", " + e + ", " + d);
                            }
                        }
                        d = c;
                        e = b;

                        for (int A = a; A > 0; A--) {
                            if (b <= a && a > 0 && b >= 0 && c >= 0 && e >= 0 && d >= 0 && f > 0) {
                                f = f - 1;
                                if (f < e) {
                                    e = e - 1;
                                }
                                if (e < d) {
                                    d = d - 1;
                                }
                                Boards board = new Boards(f, e, d);
                                board.printBoards();
//                                if (board.column0 == 2 && board.column1 == 1 && board.column2 == 0) {
//                                    System.out.println("Lose Board");
//                                }
                                //  System.out.println(f + ", " + e + ", " + d);
                            }
                        }

                    }

                }

            }
        }
    }

    public void classifyBoards() {
        System.out.println("classifying: ");
        System.out.println("Array List: ");
        for(int x=0;x<20;x++) {
            boards.get(x).printBoards();
        }
        System.out.println();

        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {
                    if (a >= b && b >= c) {
                        Boards board = new Boards(a,b,c);

                        System.out.println("new board: ");
                        board.printBoards();
                        System.out.println();
                        board.getResultingBoards();
                        System.out.println();
                    }
                }
            }
        }
    }
}