/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

/**
 *
 * @author SOURAV
 */
public class MainTable {
    private int[][] board;
    int SIZE=0,no=-1;
    public MainTable(int size)
    {
        SIZE=size;
        board=new int[size][size];
    }
    
    public int[][] getTable()
    {
        int[][] table=new int[SIZE][SIZE];
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
                table[i][j]=board[i][j];
        return table;
    }
    
    public void setTable(int i,int j,int val)
    {
        board[i][j]=val;        
    }
    
    public int isWin(int[][] table)
    {        
        int sum1,sum2,cut1=0,cut2=0;
        no=-1;
        for(int i=0;i<SIZE;i++)
        {
            sum1=0;sum2=0;
            for(int j=0;j<SIZE;j++)
            {    
                sum1+=table[i][j];
                sum2+=table[j][i];
            }
            if(sum1==3 || sum1==-3)
                no=i;
            else if(sum2==3 || sum2==-3)
                no=3+i;
            if(sum1==3 || sum2==3)
                return 1;
            else if(sum1==-3 || sum2==-3)
                return -1;
        }
        sum1=0;sum2=0;cut1=-1;cut2=-1;
        for(int i=0;i<SIZE;i++)
        {
            sum1+=table[i][i];
            sum2+=table[i][SIZE-i-1];
        }   
            if(sum1==3 || sum1==-3)
                no=6;
            else if(sum2==3 || sum2==-3)
                no=7; 
        if(sum1==3 || sum2==3)
            return 1;
        else if(sum1==-3 || sum2==-3)
            return -1;    
        else
            return 0;
    }
    
  /*  public static void main(String args[])
    {
        MainTable mainTable=new  MainTable(3);
        int[][] board={{1,-1,0},{0,-1,0},{1,-1,0}};   
        System.out.println(mainTable.isWin(board));
    }  */  
}
