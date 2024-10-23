import java.util.Random;

public class Board {

    private int size=4;
    private int[][] board;
    private int MAX_NUMBER;
    private int[] coordinatesOfSpace;
    private int correctPosCount;

    public Board(){
        board=new int[size][size];
        MAX_NUMBER=size*size-1;
        coordinatesOfSpace=new int[2];
        arrangeBoard();
        correctPosCount=0;

    }


    public void arrangeBoard()
    {
        setNumbers();
        findGapCoordinates();
        findCorrectPosCount();
        System.out.println("corr "+correctPosCount);
    }

    private void findCorrectPosCount() {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j]==size*i+j+1)
                    correctPosCount++;
            }
        }
    }


    public int  swapTile(int x,int y)
    {
        if(x<0||y<0||x>=size||y>=size)
            return 0;
        if(!isValid(x,y))
            return 0;
        int posNeedValue=size*x+y+1;
        boolean isCorrectPosition=board[x][y]==posNeedValue;
        if(isCorrectPosition)
            correctPosCount--;
        else
        {
         posNeedValue=size*coordinatesOfSpace[0]+coordinatesOfSpace[1]+1;
         if(board[x][y]==posNeedValue)
            correctPosCount++;   
        }
        System.out.println("corrected values:"+correctPosCount);
        board[coordinatesOfSpace[0]][coordinatesOfSpace[1]]=board[x][y];
            board[x][y]=0;
            coordinatesOfSpace[0]=x;
            coordinatesOfSpace[1]=y;
        if(correctPosCount==MAX_NUMBER)
        {
            return 2;
        }
        return 1;

    }


    private boolean isValid(int x, int y) {
        int xAxis=coordinatesOfSpace[0];
        int yAxis=coordinatesOfSpace[1];
        if((xAxis-1>=0 && x==xAxis-1 &&y==yAxis)||(xAxis+1<size &&x==xAxis+1 && y==yAxis) || (yAxis-1>=0&&x==xAxis&&y==yAxis-1)|| (yAxis+1<size && x==xAxis&&y==yAxis+1))
            return true;
        return false;
        
    }


    private void findGapCoordinates() {

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j]==0)
                {
                    coordinatesOfSpace[0]=i;
                    coordinatesOfSpace[1]=j;
                    // System.out.println(i+" "+j);
                    return;
                }
            }
        }
    }


    private void setNumbers() {
        Random rand= new Random();
        
        for(int i=1;i<=MAX_NUMBER;i++)
        {
            int x,y;
            do{
                x=rand.nextInt(size);
                y=rand.nextInt(size);
            }while(board[x][y]!=0);
            board[x][y]=i;
        }


    }


    // private boolean isValid(int x, int y) {
        
    // }

    public String toString(){

        String str="";
        str+='\t';
        for(int i=0;i<size;i++)
            str+=i+"\t";
        str+="\n \n";
        for(int i=0;i<size;i++)
        {
            str+=i+"\t";
            for(int j=0;j<size;j++)
            {
                str+=(board[i][j]!=0?board[i][j]:" ")+"\t";
            }
            str+='\n';
        }
        return str;
    }


    
}
