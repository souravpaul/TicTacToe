/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

/**
 *
 * @author SOURAV
 */
import java.util.Scanner;
public class PCMove {
    private int x=0,y=0,SIZE=3,comp=0;
    private MainTable mainTable;
    public PCMove(MainTable mt)
    {
        mainTable=mt;
      //  SIZE=mainTable.SIZE;
    }
    
    public long ResetAxis(int[][] board,int level,int player,int pos)
    {
        long max=-2; 
        int[][] table=new int[SIZE][SIZE];
        long priority=0;
        if(pos==0)
        {
            comp=player;
            x=0;y=0;
        }
        for(int i=0;i<SIZE;i++)
        {
            int flag=0;
            for(int j=0;j<SIZE;j++)
            {                
                table=arrayCopy(board);
                if(table[i][j]==0)
                {
                    table[i][j]=player;      
                    priority=mainTable.isWin(table)*comp;    
                    if(priority==1 && pos==0)
                    {
                        x=i;y=j;flag=1;break;
                    }
                    if(priority==0 && level<8)
                       priority=search(table,level+1,-player,pos)*player;
                    if(priority>max)
                    {
                        max=priority;
                        if(pos==0)
                            {x=i;y=j;}
                    }               
                }
            }
            if(flag==1)
                break;
        }
        if(pos==0)
            mainTable.setTable(x, y,player);     
        /*
                if(pos==0)
                    System.out.println("("+i+";"+j+")priority_max->"+max+"_level: "+level);   */
        return max;
    }
    
   public long search(int[][] board,int level,int player,int pos)
    {
        int[][] table=new int[SIZE][SIZE];
        long priority=0;
        long min=2;
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {          
                
                table=arrayCopy(board);
                if(table[i][j]==0)
                {
                    table[i][j]=player;      
                    priority=mainTable.isWin(table)*comp;     
                    if(priority==0 && level<8)
                        priority=ResetAxis(table,level+1,-player,1)*comp;               
                    if(min>priority)
                        min=priority;
                }
            }
        }
        return min;
    }
    
    public int[][] arrayCopy(int[][]source)
    {
        int[][] table=new int[SIZE][SIZE];
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
                table[i][j]=source[i][j];
        return table;
    }
    
    public void print_board(int[][] board,int level,int player)
    {
        System.out.println("\n\nlevel- "+level+"   player- "+player+"\n");
        for(int i=0;i<SIZE;i++)
        {
            System.out.println();
            for(int j=0;j<SIZE;j++)
            {                
                if(board[i][j]==-1)
                System.out.print("  0  ");
                else if(board[i][j]==1)
                    System.out.print("  *  ");
                else
                    System.out.print("  .  ");
            }
        }
    }
    
    public int getX()
    {
        return x;
    }  
    
    public int getY()
    {
        return y;
    }
}
