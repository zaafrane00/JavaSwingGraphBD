/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajframebd;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zaafr
 */
public class Courbe extends Thread{
    
    JavaJFrameBD tp;
    
    public Courbe(JavaJFrameBD tp){
        this.tp=tp;
    }
    
    public void run(){
            int x1=-500;
              int t1=4*(int)Math.pow(x1, 2)+3*x1-2;
              for (int x2 = -10; x2 <= 10; x2++) {
                try {
                    int t2=4*(int)Math.pow(x2, 2)+3*x2-2;
                    this.tp.g.drawLine(x1+200, this.tp.cv.getHeight()-t1, x2+200, this.tp.cv.getHeight()-t2);
                    
                    System.out.println(x1+" "+t1+" | "+x2+ " "+t2);
                    sleep(100);
               
                x1=x2;
                    t1=t2; } catch (InterruptedException ex) {
                    Logger.getLogger(Courbe.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
    }
}
