public class Boards {
    public int column0;
    public int column1;
    public int column2;
    public String name;

    public Boards(String pName, int pColumn0, int pColumn1, int pColumn2){
        name=pName;
        column1=pColumn1;
        column0=pColumn0;
        column2=pColumn2;
    }

    public void printBoards(){
        System.out.println("Name: " + name);
        System.out.println(column0 + ", " + column1 + ", " + column2);
    }
}
