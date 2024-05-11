import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainelDesenho2 extends JPanel {

  // Armazenar o Desenho Anterior
  private int ax1[] = new int[1];
  private int ax2[] = new int[1];
  private int ay1[] = new int[1];
  private int ay2[] = new int[1]; 
  private int aForma[] = new int[1];
  private Color aCor[] = new Color[1];
  // Armazenar novo Desenho
  private int x1 = 0, x2 = 0, y1 = 0, y2 = 0, forma = 1;
  private Color cor = Color.black;
  private Color corF = Color.white;
	// Mostrar o código draw
  private boolean mostra = false;

  public PainelDesenho2() {
    super();
		this.setBackground(corF);  
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent event) {
				aoPressionarMouse(event);
			}
			@Override
			public void mouseReleased(MouseEvent event) {
				aoSoltarMouse(event);
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent event) {
				aoArrastarMouse(event);
			}
			@Override
			public void mouseMoved(MouseEvent event){
			}
		});  
  }	 
  
	public void aoPressionarMouse(MouseEvent event) {
    mostra = false;
    x1 = event.getX();
    y1 = event.getY();
    x2 = event.getX();
    y2 = event.getY();
  }

	public void aoSoltarMouse(MouseEvent event) {
    mostra = true;
    x2 = event.getX();
    y2 = event.getY();
    desenhoFixo();
    repaint();
  }
  
	public void aoArrastarMouse(MouseEvent event) {
		x2 = event.getX();
		y2 = event.getY();
		if (forma == 1) {
			desenhoFixo();
		}
	 	repaint();
  }

  public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(cor);
		switch (forma) {
		 case 0:
		   apagar();
		   break;
		 case 1:
		   g.drawLine(x2, y2, x2, y2);
		   System.out.println("g.drawLine(" + x2 + ", " + y2 + ", " + x2 + ", " + y2 + ");");
		   break;   
		 case 2:
		   g.drawLine(x1, y1, x2, y2);
		   if (mostra)
		     System.out.println("g.drawLine(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ");");
		   break;   
		 case 3:
		   g.fillRect(x1, y1, x2-x1, y2-y1);
		   if (mostra)
		     System.out.println("g.fillRect(" + x1 + ", " + y1 + ", " + (x2-x1) + ", " + (y2-y1) + ");");
		   break;   
		 case 4:
		   g.drawRect(x1, y1, x2-x1, y2-y1);    
		   if (mostra)
		     System.out.println("g.drawRect(" + x1 + ", " + y1 + ", " + (x2-x1) + ", " + (y2-y1) + ");");
		   break;   
		 case 5:
		   g.fillOval(x1,y1, x2-x1, y2-y1);
		   if (mostra)
		     System.out.println("g.fillOval(" + x1 + ", " + y1 + ", " + (x2-x1) + ", " + (y2-y1) + ");");
		   break;   
		 case 6:
		   g.drawOval(x1,y1, x2-x1, y2-y1);
		   if (mostra)
		     System.out.println("g.drawOval(" + x1 + ", " + y1 + ", " + (x2-x1) + ", " + (y2-y1) + ");");
		   break;   
		 case 7:
		   g.fillRoundRect(x1,y1, x2-x1, y2-y1, 25, 25);
		   if (mostra)
		     System.out.println("g.fillRoundRect(" + x1 + ", " + y1 + ", " + (x2-x1) + ", " + (y2-y1) + ", 25, 25);");
		   break;  
		 case 8:
		   g.drawRoundRect(x1,y1, x2-x1, y2-y1, 25, 25);
		   if (mostra)
		     System.out.println("g.drawRoundRect(" + x1 + ", " + y1 + ", " + (x2-x1) + ", " + (y2-y1) + ", 25, 25);");
			 break;
		}
			
		// Refaz o Desenho Anterior	
		int limite = ax1.length-1;
		for (int i=0; i<limite; i++){
			g.setColor(aCor[i]);
			switch (aForma[i]) {
				case 1:
					g.drawLine(ax2[i], ay2[i], ax2[i], ay2[i]);
					break;   
				case 2:
					g.drawLine(ax1[i], ay1[i], ax2[i], ay2[i]);
					break;   
				case 3:
					g.fillRect(ax1[i], ay1[i], ax2[i]-ax1[i], ay2[i]-ay1[i]);
					break;   
				case 4:
					g.drawRect(ax1[i], ay1[i], ax2[i]-ax1[i], ay2[i]-ay1[i]);    
					break;   
				case 5:
					g.fillOval(ax1[i],ay1[i], ax2[i]-ax1[i], ay2[i]-ay1[i]);
					break;   
				case 6:
					g.drawOval(ax1[i],ay1[i], ax2[i]-ax1[i], ay2[i]-ay1[i]);
					break;   
				case 7:
					g.fillRoundRect(ax1[i],ay1[i], ax2[i]-ax1[i], ay2[i]-ay1[i], 25, 25);
					break;  
				case 8:
					g.drawRoundRect(ax1[i],ay1[i], ax2[i]-ax1[i], ay2[i]-ay1[i], 25, 25);
			 	break;
			}
		}
  }
  
  private void desenhoFixo() {
    int tp[];
    Color tpC[];
    ax1[ax1.length-1] = x1;
    ay1[ay1.length-1] = y1;
    ax2[ax2.length-1] = x2;
    ay2[ay2.length-1] = y2;
    aCor[aCor.length-1] = cor;
    aForma[aForma.length-1] = forma;
    
    tp = ax1;
    ax1 = new int[tp.length+1];
    for (int i=0; i< tp.length; ++i) {
      ax1[i] = tp[i];
    }
    ax1[ax1.length-1] = 0;
    
    tp = ay1;
    ay1 = new int[tp.length+1];
    for (int i=0; i< tp.length; i++) {
      ay1[i] = tp[i];
    }
    ay1[ay1.length-1] = 0;
    
    tp = ax2;
    ax2 = new int[tp.length+1];
    for (int i=0; i< tp.length; i++) {
      ax2[i] = tp[i];
    }
    ax2[ax2.length-1] = 0;
    
    tp = ay2;
    ay2 = new int[tp.length+1];
    for (int i=0; i< tp.length; i++) {
      ay2[i] = tp[i];
    }
    ay2[ay2.length-1] = 0;

    tp = aForma;
    aForma = new int[tp.length+1];
    for (int i=0; i< tp.length; i++) {
      aForma[i] = tp[i];
    }
    aForma[aForma.length-1] = 1;
    
    tpC = aCor;
    aCor = new Color[tpC.length+1];
    for (int i=0; i< tp.length; i++) {
      aCor[i] = tpC[i];
    }
  }
  
  public int getX1(){
    return x1;	
  }
  
  public void setX1(int x){
    x1=x;	
  }
  
  public int getY1(){
    return y1;	
  }
  
  public void setY1(int y){
    y1 = y;	
  }
  
  public int getX2(){
    return x2;	
  }
  
  public void setX2(int x){
    x2=x;	
  }
  
  public int getY2(){
    return y2;	
  }
  
  public void setY2(int y){
    y2 = y;	
  }
  
  public int getForma(){
    return forma;	
  }
  
  public void setForma(int f){
    forma = f;	
  }  
  
  public Color getCor(){
    return cor;	
  }
  
  public void setCor(Color c){
    cor = c;	
  } 
  
  private void apagar(){
     ax1 = new int[1];
     ay1 = new int[1];
     ax2 = new int[1];
     ay2 = new int[1];
     aForma = new int[1];
     aCor = new Color[1];
  }
}
