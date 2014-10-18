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
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
public class gamePlay extends JFrame{
    int ply=-1,getX=0,getY=0,up=0;
    Scanner scan=new Scanner(System.in);
    graphics colorJPanel = new graphics();
    MouseHandler handler = new MouseHandler();
    public gamePlay()
    {   
        super("TIC TAC TOE");
        colorJPanel.addMouseListener(handler);
        colorJPanel.addMouseMotionListener(handler);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        this.add( colorJPanel ); // add colorJPanel to frame
        this.setSize( 430,500 ); // set frame size
        this.setVisible(true);
        this.setResizable(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }        
    
    public void play()
    {
        MainTable mainTable=new MainTable(3);
        PCMove pcMove=new PCMove(mainTable);
        PCMoveLw pcMoveLw=new PCMoveLw(mainTable);
        int level=-1,player=ply,state=0;
            colorJPanel.repaintIt(mainTable.getTable(),0,-1,up);
        while(true)
        {            
            player=-player;
            if(player==1)
            {
                if(up==1)
                    pcMove.ResetAxis(mainTable.getTable(),++level,player,0);
                else if(up==0)
                    pcMoveLw.ResetAxis(mainTable.getTable(),++level,player);
            }
            else
            {
                level++;
               colorJPanel.repaintIt(mainTable.getTable(),1,-1,up);
                while(userInput(mainTable))
                {                    
                }
            }
            state=mainTable.isWin(mainTable.getTable());
           // pcMove.print_board(mainTable.getTable(),level,player);   
            colorJPanel.repaintIt(mainTable.getTable(),0,-1,up);
            if(state!=0 || level==8)
                break;
        }
        if(state!=0)
         colorJPanel.repaintIt(mainTable.getTable(),0,mainTable.no,up);
        else if(level==8)
            colorJPanel.repaintIt(mainTable.getTable(),0,8,up);
    }
    
    public boolean userInput(MainTable mt)
    {
        int[][] table=mt.getTable();
        if((getX>=0 && getX<=140) &&(getY>=20 && getY<= 140))
        {
            if(table[0][0]!=0)
                return true;
             mt.setTable(0,0,-1);
        }
        else if((getX>=150 && getX<=270) &&(getY>=20 && getY<= 140))
        {
            if(table[0][1]!=0)
                return true;
            mt.setTable(0,1,-1);
        }
        else if((getX>=280 && getX<=400) &&(getY>=20 && getY<= 140))
        {
            if(table[0][2]!=0)
                return true;
            mt.setTable(0,2,-1);
        }
        else if((getX>=0 && getX<=140) &&(getY>=150 && getY<= 270))
        {
            if(table[1][0]!=0)
                return true;
            mt.setTable(1,0,-1);
        }
        else if((getX>=150 && getX<=270) &&(getY>=150 && getY<= 270))
        {
            if(table[1][1]!=0)
                return true;
            mt.setTable(1,1,-1);
        }
        else if((getX>=280 && getX<=400) &&(getY>=150 && getY<= 270))
        {
            if(table[1][2]!=0)
                return true;
            mt.setTable(1,2,-1);
        }
        else if((getX>=0 && getX<=140) &&(getY>=280 && getY<= 400))
        {
            if(table[2][0]!=0)
                return true;
            mt.setTable(2,0,-1);
        }
        else if((getX>=150 && getX<=270) &&(getY>=280 && getY<= 400))
        {
            if(table[2][1]!=0)
                return true;
            mt.setTable(2,1,-1);
        }
        else if((getX>=280 && getX<400) &&(getY>=280 && getY<= 400))
        {
            if(table[2][2]!=0)
                return true;
            mt.setTable(2,2,-1);
        }
        else 
            return true;
        getX=0;getY=0;
        return false;
        
    }
    
    private  class MouseHandler implements MouseListener,MouseMotionListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            getX=e.getX();getY=e.getY();
        }
        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        @Override
        public void mouseMoved(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
