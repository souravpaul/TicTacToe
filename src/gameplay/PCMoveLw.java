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
public class PCMoveLw {
    private int x=0,y=0,SIZE=3,comp=0;
    private MainTable mainTable;
    public PCMoveLw(MainTable mt)
    {
        mainTable=mt;
      //  SIZE=mainTable.SIZE;
    }
    
    public long ResetAxis(int[][] board,int level,int player)
    {
        long max=-999999999; 
        int[][] table=new int[SIZE][SIZE];
        long priority=0;
        if(level<=8)
        {
            comp=player;
            x=0;y=0;int pos=0;
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
                    priority+=mainTable.isWin(table)*comp;
                    if(level<=8)
                    {                        
                        priority=0;
                        if( priority*player==1)
                         {
                            x=i;y=j;flag=1;break;
                        }
                        else
                        {
                            if(level<SIZE*SIZE-1 )
                                priority+=ResetAxis(table,10,-player)*player;
                            priority*=player;
                            if(priority>max)
                            {
                                max=priority;x=i;y=j;
                            }                        
                            
                        }
                    }                    
                }
            }
            if(flag==1)
                break;
        }
        if(level<9)
        {
            mainTable.setTable(x, y,player);          
        }
        //else
            // System.out.println("("+x+";"+y+ ")->"+priority+"__"+max);
        return priority;
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
