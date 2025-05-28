import java.util.ArrayList;

public class Boards {
    public int column0;
    public int column1;
    public int column2;
    public int column3;
    public int column4;
    public int column5;
    public int column6;
    public int column7;
    public int column8;
    public boolean win;
    public int column9;
    public int row;
    public int col;
    public String name;
    public ArrayList<Boards> winBoards;



    public Boards(int pColumn0, int pColumn1, int pColumn2, int pColumn3, int pColumn4, int pColumn5, int pColumn6, int pColumn7, int pColumn8, int pColumn9,int pRow, int pCol){
        row = pRow;
        col = pCol;
        column1=pColumn1;
        column0=pColumn0;
        column2=pColumn2;
        column3 = pColumn3;
        column4 = pColumn4;
        column5 = pColumn5;
        column6 = pColumn6;
        column7 = pColumn7;
        column8 = pColumn8;
        column9 = pColumn9;
        winBoards = new ArrayList<>();
    }

//    public void getResultingBoards(){
//        int a=column0;
//        int b=column1;
//        int c=column2;
//
//        if(a>=b && b>=c) {
//
//            int d = c;
//            int e = b;
//            int f = a;
//
//
//            for(int C=c;C>0;C--) {
//                if (c > 0&&d>0) {
//                    d = d - 1;
//                    Boards board = new Boards(a,b,d,0,0);
//                    board.printBoards();
//
////                    if(board.column0==2&&board.column1==1&&board.column2==0){
////                        System.out.println("Lose Board");
////                    }
//                    // System.out.println(a + ", " + b + ", " + d);
//                }
//            }
//            d=c;
//
//            for(int B=b;B>0;B--) {
//                if (c <= b && b > 0 && c>=0&& e>=0&&d>=0) {
//                    e = e - 1;
//                    if(e<d) {
//                        d = d - 1;
//                    }
//                    Boards board = new Boards(a,e,d,0,0);
//                    board.printBoards();
////                    if(board.column0==2&&board.column1==1&&board.column2==0){
////                        System.out.println("Lose Board");
////                    }
//                    // System.out.println(a + ", " + e + ", " + d);
//                }
//            }
//            d=c;
//            e=b;
//
//            for(int A=a;A>0;A--) {
//                if (b <= a && a > 0 && b>=0 && c>=0&&e>=0&&d>=0&&f>0) {
//                    f = f - 1;
//                    if(f<e) {
//                        e = e - 1;
//                    }
//                    if(e<d) {
//                        d = d - 1;
//                    }
//                    Boards board = new Boards(f,e,d,0,0);
//                    board.printBoards();
//                    if(board.column0==2&&board.column1==1&&board.column2==0){
//                        System.out.println("Lose Board");
//                    }
//
//                }
//            }
//    }
//    }

    public void printBoards(){
        System.out.println("win? " +win+ " " + column0 + ", " + column1 + ", " + column2 + ", " + column3 + ", " + column4 + ", " + column6 + ", " + column6+ ", " + column7 + ", " + column8+ ", " + column9);
    }
    public void printBoard(){
        System.out.print(column0 + ", " + column1 + ", " + column2 + ", " + column3 + ", " + column4 + ", " + column6 + ", " + column6+ ", " + column7 + ", " + column8+ ", " + column9);
    }
    public void printBoardMove(){
        System.out.println("win? " +win+ " " + column0 + ", " + column1 + ", " + column2 + ", " + column3 + ", " + column4 + ", " + column6 + ", " + column6+ ", " + column7 + ", " + column8+ ", " + column9 + " right move: (" +col + "," + row + ")" );
    }
}
