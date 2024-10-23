import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args)
    {
        Board board= new Board();
        Scanner scan=new Scanner(System.in);
        do{

        
        System.out.println(board);
        System.out.println("enter pos:");
            int x=scan.nextInt();
            int y=scan.nextInt();
        switch (board.swapTile(x, y)) {
            case 0:
                System.out.println("enter valid position!");
                break;
            case 1:
            System.out.println("swapped!");
                break;
            case 2:
                System.out.println("you win!");
                return;
        
            default:
                break;
        }

        }while(true);

    }
}