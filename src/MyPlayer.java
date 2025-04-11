import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<String> boards;


    public MyPlayer() {
        columns = new int[10];


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

    public void toColumns(){
        for(int x=0;x<10;x++) {
            columns[x]=0;
        }
        for(int x=0;x<gameBoard.length;x++){
            for(int y=0; y< gameBoard[x].length;y++){
                if(gameBoard[x][y].isAlive) {
                    System.out.println("(" + x + "," + y + ")");

                    columns[y] +=1;

                }

            }
        }
        for(int x=0;x<10;x++) {
            System.out.print(columns[x] + ",");
        }
    }

    public void allBoards(){

        System.out.println("All 19 Boards: ");
        for(int a=0;a<4;a++){
            for(int b=0;b<4;b++){
                for(int c=0;c<4;c++){
                   if(a>=b && b>=c) {
                       System.out.println(a + ", " + b + ", " + c);
                   }
                }
            }
        }
    }

    public void resultingBoards(){
        System.out.println("Resulting Boards: ");
        for(int a=0;a<4;a++){
            for(int b=0;b<4;b++) {
                for (int c = 0; c < 4; c++) {

                    System.out.println("Starting Board: " + a + ", " + b + ", " + c);
                    System.out.println("Resulting Boards: ");

                    int d=c;

                        if (c > 0) {
                            d = d - 1;
                            System.out.println(a + ", " + b + ", " + d);
                        }
//
//                    if (c == 0 && b > 0) {
//                        b = b - 1;
//                        System.out.println(a + ", " + b + ", " + c);
//                    }
//                    if (b == 0 && a > 1) {
//                        a = a - 1;
//                        System.out.println(a + ", " + b + ", " + c);
//                    }

            }

            }
        }
    }

}
