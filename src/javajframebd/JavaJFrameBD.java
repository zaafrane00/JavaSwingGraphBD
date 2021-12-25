/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajframebd;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author zaafr
 */
public class JavaJFrameBD extends JFrame{
    
     static JButton b1 = new JButton("Ajouter");
    JTextField t1= new JTextField("");
    JTextField t= new JTextField("");
    MyConnection db;
    Canvas cv;
    Graphics g;
    JButton ligneLabel,cercleLabel,carrelabel,polyLabel,fLabel,f2Label,arcLabel,annulerLabel ;
    int x=0, x1=0, y=0, y1=0; 
    
    public JavaJFrameBD(){
        
  
             this.setTitle("TP Base");
             this.setSize(900, 900);
             this.setLocationRelativeTo(getParent());
             this.setDefaultCloseOperation(EXIT_ON_CLOSE);
             
              ligneLabel = new JButton("Ligne");
              cercleLabel = new JButton("Cercle");
              carrelabel= new JButton("Carre");
              polyLabel= new JButton("Poly");
              fLabel= new JButton("F(x1)");
              f2Label = new JButton("F(x2)");
              arcLabel = new JButton("Arc");
              annulerLabel = new JButton("Annuler");
             
          
             JPanel flowPanel = new JPanel();
             flowPanel.setLayout(new GridLayout(1,8));
             
             flowPanel.add(ligneLabel);
             flowPanel.add(cercleLabel);
             flowPanel.add(carrelabel);
             flowPanel.add(polyLabel);
             flowPanel.add(fLabel);
             flowPanel.add(fLabel);
             flowPanel.add(f2Label);
             flowPanel.add(arcLabel);
             flowPanel.add(annulerLabel);
             
               cv = new Canvas();
              cv.setBackground(Color.WHITE);
             
             //Container c=getContentPane();
             
             this.add(cv,BorderLayout.CENTER);
             this.add(flowPanel,BorderLayout.SOUTH);
              
               setVisible(true);
             
                g=cv.getGraphics();
               g.setColor(Color.BLACK);
              
              
//             JPanel pform=new JPanel(new GridLayout(2,2));
//             pform.add(l); pform.add(t);
//             pform.add(l1); pform.add(t1);
//             
//             JPanel pbtn=new JPanel(new GridLayout(1,3));
//             pbtn.add(b1);
//             
//             Container c=getContentPane();
//             c.setLayout(new BorderLayout());
//             c.add("Center", pform);
//             c.add("South", pbtn);
              
             // b1.addActionListener(e->ajouter());
                 try {
             db=new MyConnection();
                 } catch (SQLException ex) {
             Logger.getLogger(JavaJFrameBD.class.getName()).log(Level.SEVERE, null, ex);
         }
          
            ligneLabel.addActionListener(l->drawLine());
            cercleLabel.addActionListener(l->drawCercle());
            carrelabel.addActionListener(l->drawCarre());
            arcLabel.addActionListener(l->drawArc());
            polyLabel.addActionListener(l->drawPolygone2());
            fLabel.addActionListener(l->drawFunction());
            f2Label.addActionListener(l->drawFunction2());
            annulerLabel.addActionListener(l->resetCanvas());
            
        
    }
    
    
    void ajouter() {
         try {
             User u=new User(t.getText(), t1.getText());
             db.addUser(u);
         } catch (SQLException ex) {
             Logger.getLogger(JavaJFrameBD.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    void drawLine(){   
            x+=10;y+=10;
            x1+=100;y1+=100;
            g.drawLine(x, y, x1, y1);
         
    }
    
      void drawCercle(){
        if(this.isVisible()){
             g.drawOval(10, 20, 50, 150);
             g.fillOval(10, 20, 50, 150);
            
        }
    }
      
      void drawCarre(){
        if(this.isVisible()){
             g.drawRect(10, 20, 50, 150);
        }
    }
      
        void drawPolygone(int xTab[],int ytab[],int width){
        if(this.isVisible()){
             g.drawPolygon(xTab,ytab, width);
        }
    }
        
         void drawPolygone2(){
            int xtab []={100,200,300,150,100,50};
            int ytab []={50,50,200,100,700,100};
            if(this.isVisible()){
                Polygon p =new Polygon();
                for(int i=0;i<xtab.length;i++){
                    p.addPoint(xtab[i], ytab[i]);
                }
             g.drawPolygon(p);
        }
    }
        
          void drawArc(){
            if(this.isVisible()){
                 g.drawArc(500, 500, 150, 150, 225, 270);
            }
          }
          
          void drawFunction(){
              if(this.isVisible()){
              int x1=-500;
              int t1=4+(int)Math.pow(x1, 2);
              for (int x2 = -500; x2 <= 500; x2++) {
                  int t2=4*(int)Math.pow(x2,2)-3 *x2+5;
                  g.drawLine(x1+200, cv.getHeight()-t1, x2+200, cv.getHeight()-t2);
                  x1=x2;
                  t1=t2;
                }
              }
          }
          
          void resetCanvas(){
              cv.update(g);
          }
          
          //f(x)=cos(x/7)-cos(x/5)+3
          
          double f(double x){
              return (Math.cos(x/7)-Math.sin(x/5)+3)*100;
          }
          
          void drawFunction2(){
              for (int i = -500; i < 500; i++) {
                  g.drawLine(x,(int)f(x),x+1,(int)f(x+1));
              }
          }
  

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        new JavaJFrameBD();
         
    }

  }
    