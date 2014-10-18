/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

/**
 *
 * @author SOURAV
 */
public class game {
    int flag=0,player=1,up=0;
    gamePlay gp=new gamePlay();
class NewThread implements Runnable {
Thread t; 
myThread mt=mt=new myThread();           
NewThread(){
// Create a new, second thread
t = new Thread(this, "Demo Thread");
System.out.println("Child thread: " + t);
t.start(); // Start the thread
}
// This is the entry point for the second thread.
public void run() {     
    while(true)
        try{
        if((gp.getX>=280 && gp.getX<=410) &&(gp.getY>=425 && gp.getY<= 465))
        {   
            if(mt.t.isAlive())
                mt.t.stop();
            mt=new myThread();
            gp.getX=0;gp.getY=0;
        }
        else if((gp.getX>=170 && gp.getX<=270) &&(gp.getY>=425 && gp.getY<= 465))
        {
            if(mt.t.isAlive())
                mt.t.stop();
            up=(up+1)%2;
            mt=new myThread();
            gp.getX=0;gp.getY=0;
            
        }
        }
    catch(Exception e)
    {
        
    }
}
}

  class myThread implements Runnable {
Thread t;
myThread(){
// Create a new, second thread
t = new Thread(this, "myThread");
t.start(); // Start the thread
}
// This is the entry point for the second thread.
public void run() {
        try{
            player=-player;
            gp.ply=player;
            gp.up=up;
            gp.play();
        }
    catch(Exception e)
    {
        
    }
}
}
  public static void main(String args[])
  {
      game g=new game();
      g.new NewThread();
  }
}
