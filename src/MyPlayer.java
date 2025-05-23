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



                                                    int z = a;
                                                    int y = b;
                                                    int w = c;
                                                    int v = d;
                                                    int u = e;
                                                    int t = f;
                                                    int s = g;
                                                    int r = h;
                                                    int q = i;
                                                    int p = j;


                                                    for (int P = j; P > 0; P--) {
                                                        if (j > 0 && p > 0) {
                                                            p = p - 1;
                                                            Boards board = new Boards(a, b, c,d,e,f,g,h,i,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                        System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
                                                        }
                                                    }
                                                    p= j;

                                                    for (int I = i; I > 0; I--) {
                                                        if (j <= i && i > 0 && j >= 0 && q >= 0 && p >= 0) {
                                                            q = q - 1;
                                                            if (q < p) {
                                                                p = p - 1;
                                                            }
                                                            Boards board = new Boards(a,b,c,d,e,f,g,h,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }
                                                    }
                                                    p = j;
                                                    q = i;

                                                    for (int H = h; H > 0; H--) {
                                                        if (i <= h && h > 0 && i >= 0 && j >= 0 && q >= 0 && p >= 0 && r > 0) {
                                                            r = r - 1;
                                                            if (r < q) {
                                                                q = q - 1;
                                                            }
                                                            if (q < p) {
                                                                p = p - 1;
                                                            }
                                                            Boards board = new Boards(a,b,c,d,e,f,g,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }
                                                    p = j;
                                                    q = i;
                                                    r=h;

                                                    for (int G = g; G > 0; G--) {
                                                        if (h <= g && g > 0 && h >= 0 && j >= 0 && q >= 0 && p >= 0 && r >= 0 && s>0) {
                                                            s = s - 1;
                                                            if (s < r) {
                                                                r = r - 1;
                                                            }
                                                            if (r < q) {
                                                                q = q - 1;
                                                            }
                                                            if(q<p){
                                                                p=p-1;
                                                            }
                                                            Boards board = new Boards(a,b,c,d,e,f,s,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }

                                                    p = j;
                                                    q = i;
                                                    r=h;
                                                    s=g;

                                                    for (int F = f; F > 0; F--) {
                                                        if (g <= f && g > 0 && j >= 0 && i>0 && h>0 && g>=0 && q >= 0 && p >= 0 && r >= 0 && s>=0 && t>0) {
                                                            t = t - 1;
                                                            if (t < s) {
                                                                s = s - 1;
                                                            }
                                                            if (s < r) {
                                                                r = r - 1;
                                                            }
                                                            if(r<q){
                                                                q=q-1;
                                                            }
                                                            if(q<p){
                                                                p=p-1;
                                                            }
                                                            Boards board = new Boards(a,b,c,d,e,t,s,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }

                                                    p = j;
                                                    q = i;
                                                    r=h;
                                                    s=g;
                                                    t=f;

                                                    for (int E = e; E > 0; E--) {
                                                        if (f <= e && j > 0 && i>0 && h>0 && g>0 &&f>=0 && q >= 0 && p >= 0 && r >= 0 && s>=0 && t>=0 && u>0) {
                                                            u = u - 1;
                                                            if(u<t){
                                                                t=t-1;
                                                            }
                                                            if (t < s) {
                                                                s = s - 1;
                                                            }
                                                            if (s < r) {
                                                                r = r - 1;
                                                            }
                                                            if(r<q){
                                                                q=q-1;
                                                            }
                                                            if(q<p){
                                                                p=p-1;
                                                            }
                                                            Boards board = new Boards(a,b,c,d,u,t,s,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }

                                                    p = j;
                                                    q = i;
                                                    r=h;
                                                    s=g;
                                                    t=f;
                                                    u =e;

                                                    for (int D = d; D > 0; D--) {
                                                        if (e <= d && j > 0 && i>0 && h>0 && g>0 && f>0 &&f>=0 && q >= 0 && p >= 0 && r >= 0 && s>=0 && t>=0 && u>=0 && v>0) {
                                                            v = v - 1;
                                                            if(v<u){
                                                                u=u-1;
                                                            }
                                                            if(u<t){
                                                                t=t-1;
                                                            }
                                                            if (t < s) {
                                                                s = s - 1;
                                                            }
                                                            if (s < r) {
                                                                r = r - 1;
                                                            }
                                                            if(r<q){
                                                                q=q-1;
                                                            }
                                                            if(q<p){
                                                                p=p-1;
                                                            }
                                                            Boards board = new Boards(a,b,c,v,u,t,s,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }

                                                    p = j;
                                                    q = i;
                                                    r=h;
                                                    s=g;
                                                    t=f;
                                                    u =e;
                                                    v=d;

                                                    for (int C = c; C > 0; C--) {
                                                        if (d <= c && j > 0 && i>0 && h>0 && g>0 && f>0 && e>0 && q >= 0 && p >= 0 && r >= 0 && s>=0 && t>=0 && u>=0 && v>=0 && w>0) {
                                                            w = w - 1;
                                                            if(w<v){
                                                                v=v-1;
                                                            }
                                                            if(v<u){
                                                                u=u-1;
                                                            }
                                                            if(u<t){
                                                                t=t-1;
                                                            }
                                                            if (t < s) {
                                                                s = s - 1;
                                                            }
                                                            if (s < r) {
                                                                r = r - 1;
                                                            }
                                                            if(r<q){
                                                                q=q-1;
                                                            }
                                                            if(q<p){
                                                                p=p-1;
                                                            }
                                                            Boards board = new Boards(a,b,w,v,u,t,s,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }

                                                    p = j;
                                                    q = i;
                                                    r=h;
                                                    s=g;
                                                    t=f;
                                                    u =e;
                                                    v=d;
                                                    w=c;

                                                    for (int B = b; B > 0; B--) {
                                                        if (c <= b && j > 0 && i>0 && h>0 && g>0 && f>0 && e>0 && d>0&& q >= 0 && p >= 0 && r >= 0 && s>=0 && t>=0 && u>=0 && v>=0 && w>=0 && y>0) {
                                                            y = y - 1;
                                                            if(y<w){
                                                                w=w-1;
                                                            }
                                                            if(w<v){
                                                                v=v-1;
                                                            }
                                                            if(v<u){
                                                                u=u-1;
                                                            }
                                                            if(u<t){
                                                                t=t-1;
                                                            }
                                                            if (t < s) {
                                                                s = s - 1;
                                                            }
                                                            if (s < r) {
                                                                r = r - 1;
                                                            }
                                                            if(r<q){
                                                                q=q-1;
                                                            }
                                                            if(q<p){
                                                                p=p-1;
                                                            }
                                                            Boards board = new Boards(a,y,w,v,u,t,s,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }

                                                    p = j;
                                                    q = i;
                                                    r=h;
                                                    s=g;
                                                    t=f;
                                                    u =e;
                                                    v=d;
                                                    w=c;
                                                    y=b;

                                                    for (int A = a; A > 0; A--) {
                                                        if (b <= a && j > 0 && i>0 && h>0 && g>0 && f>0 && e>0 && d>0&& c>0 && q >= 0 && p >= 0 && r >= 0 && s>=0 && t>=0 && u>=0 && v>=0 && w>=0 && y>=0 && z>0) {
                                                            z = z - 1;
                                                            if(z<y){
                                                                y=y-1;
                                                            }
                                                            if(y<w){
                                                                w=w-1;
                                                            }
                                                            if(w<v){
                                                                v=v-1;
                                                            }
                                                            if(v<u){
                                                                u=u-1;
                                                            }
                                                            if(u<t){
                                                                t=t-1;
                                                            }
                                                            if (t < s) {
                                                                s = s - 1;
                                                            }
                                                            if (s < r) {
                                                                r = r - 1;
                                                            }
                                                            if(r<q){
                                                                q=q-1;
                                                            }
                                                            if(q<p){
                                                                p=p-1;
                                                            }
                                                            Boards board = new Boards(z,y,w,v,u,t,s,r,q,p,0,0);
                                                            board.printBoards();
                                                            for (int x = 0; x < loseBoards.size(); x++) {
                                                                if (board.column0 == (loseBoards.get(x).column0) && board.column1 == (loseBoards.get(x).column1) && board.column2 == (loseBoards.get(x).column2) && board.column3==(loseBoards.get(x).column3) && board.column4==(loseBoards.get(x).column4) && board.column5==(loseBoards.get(x).column5) && board.column6==(loseBoards.get(x).column6) && board.column7==(loseBoards.get(x).column7) && board.column8 == (loseBoards.get(x).column8) && board.column9==(loseBoards.get(x).column9)){
                                                                    System.out.println("yay!");
                                                                    saysYay = true;
                                                                    Boards subBoard = new Boards(a - board.column0, b - board.column1, c - board.column2,d-board.column3,e-board.column4,f-board.column5,g-board.column6,h-board.column7,i-board.column8,j-board.column9,0,0);
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
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3>0){
                                                                        col = 3;
                                                                        row = board.column3;
                                                                    }
                                                                    else if(subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4>0){
                                                                        col = 4;
                                                                        row = board.column4;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5>0){
                                                                        col = 5;
                                                                        row = subBoard.column5;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6>0) {
                                                                        col = 6;
                                                                        row = subBoard.column6;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7>0) {
                                                                        col = 7;
                                                                        row = subBoard.column7;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8>0) {
                                                                        col = 8;
                                                                        row = subBoard.column8;
                                                                    }
                                                                    else if (subBoard.column0==0 && subBoard.column1==0 && subBoard.column2==0 && subBoard.column3==0 && subBoard.column4==0 && subBoard.column5==0 && subBoard.column6==0 && subBoard.column7==0 && subBoard.column8==0 && subBoard.column9>0) {
                                                                        col = 9;
                                                                        row = subBoard.column9;
                                                                    }

                                                                    System.out.println("move: (" +col + "," + row + ")");

                                                                }
                                                            }
//
                                                        }

                                                    }
                                                    if (saysYay == true) {
                                                        Boards b1= new Boards(a,b,c,d,e,f,g,h,i,j,row,col);
                                                        winBoards.add(b1);
                                                    } else {
                                                        Boards b1 = new Boards(a,b,c,d,e,f,g,h,i,j,row,col);
                                                        loseBoards.add(b1);
                                                    }

                                                    startingBoard.col=col;
                                                    startingBoard.row=row;

                                                    withMoves.add(startingBoard);

                                                    System.out.println();
                                                    Boards b1 = new Boards(a,b,c,d,e,f,g,h,i,j,row,col);
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