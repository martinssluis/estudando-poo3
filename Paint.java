import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paint extends JFrame {

  private JButton btApagar = new JButton();
  private JButton btTraco = new JButton();
  private JButton btLinha = new JButton();
  private JButton btRetanC = new JButton();
  private JButton btRetanV = new JButton();
  private JButton btElipC = new JButton();
  private JButton btElipV = new JButton();
  private JButton btRetOC = new JButton();
  private JButton btRetOV = new JButton();
  private JButton btCor = new JButton();
  private JButton btCorF = new JButton();
  private JLabel lbX = new JLabel();
  private JLabel lbY = new JLabel();
  
  private Color cor = Color.black;
  private Color cor2 = Color.black;
  private Color corF = Color.white;
  private int x,y;
  
  private PainelDesenho2 dPainel = new PainelDesenho2();

  public Paint() {
    super("Paint");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setSize(583, 340);
    this.setResizable(true);
    this.setLocation((800-583)/2, (600-340)/2);

    this.btTraco.setBounds(new Rectangle(3, 5, 25, 20));
    this.add(btTraco, null);
    this.btTraco.setIcon(new ImageIcon(Paint.class.getResource("traco.gif")));
    this.btTraco.setToolTipText("Livre");
    this.btTraco.addActionListener (new ActionListener(){
      public void actionPerformed(ActionEvent e) { // Desenho livre
        mudarPara("Livre", 1);
	    }
		});    
    this.btLinha.setBounds(new Rectangle(28, 5, 25, 20));
    this.add(btLinha, null);
    this.btLinha.setIcon(new ImageIcon(Paint.class.getResource("linha.gif")));
    this.btLinha.setToolTipText("Linha");
    this.btLinha.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Linha
        mudarPara("Linha", 2);
    	}
    });
    this.btRetanC.setBounds(new Rectangle(3, 25, 25, 20));
    this.add(btRetanC, null);
    this.btRetanC.setIcon(new ImageIcon(Paint.class.getResource("RetanC.gif")));
    this.btRetanC.setToolTipText("Retângulo Cheio");
    this.btRetanC.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Retangulo cheio
        mudarPara("Retângulo Cheio", 3);
      }
    });
    this.btRetanV.setBounds(new Rectangle(28, 25, 25, 20));
    this.add(btRetanV, null);
    this.btRetanV.setIcon(new ImageIcon(Paint.class.getResource("RetanV.gif")));
    this.btRetanV.setToolTipText("Desenha Retângulo Vazio");
    this.btRetanV.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Retangulo vazio
        mudarPara("Retângulo Vazio", 4);
	    }
		});    
    this.btElipC.setBounds(new Rectangle(3, 45, 25, 20));
    this.add(btElipC, null);
    this.btElipC.setIcon(new ImageIcon(Paint.class.getResource("ElipsC.gif")));
    this.btElipC.setToolTipText("Elipse Cheia");
    this.btElipC.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Elipse Cheia
        mudarPara("Elipse Cheia", 5);
	    }
		});    
    this.btElipV.setBounds(new Rectangle(28, 45, 25, 20));
    this.add(btElipV, null);
    this.btElipV.setIcon(new ImageIcon(Paint.class.getResource("ElipsV.gif")));
    this.btElipV.setToolTipText("Elipse Vazia");
    this.btElipV.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Elipse Vazia
        mudarPara("Elipse Vazia", 6);
    	}
		});    
    this.btRetOC.setBounds(new Rectangle(03, 65, 25, 20));
    this.add(btRetOC, null);
    this.btRetOC.setIcon(new ImageIcon(Paint.class.getResource("RetanCR.gif")));
    this.btRetOC.setToolTipText("Retangulo Arredondado Cheio");
    this.btRetOC.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Retangulo Canto Arredondado Cheia
        mudarPara("Retangulo Arredondado Cheio", 7);
    	}
		});
    this.btRetOV.setBounds(new Rectangle(28, 65, 25, 20));
    this.add(btRetOV, null);
    this.btRetOV.setIcon(new ImageIcon(Paint.class.getResource("RetanVR.gif")));
    this.btRetOV.setToolTipText("Retangulo Arredondado Cheio");
    this.btRetOV.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Retangulo Canto Arredondado Vazio
         mudarPara("Retangulo Arredondado Cheio", 8);
    	}
		});
    this.btCor.setBounds(new Rectangle(3, 85, 50, 20));
    this.add(btCor, null);
    this.btCor.setBackground(cor);
    this.btCor.setToolTipText("Cor do Desenho");
    this.btCor.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // selecionar cor
        acCor();
    	}
    });
    this.btCorF.setBounds(new Rectangle(3, 105, 50, 20));
    this.add(btCorF, null);
    this.btCorF.setBackground(Color.white);
    this.btCorF.setToolTipText("Cor Fundo");
    this.btCorF.addActionListener (new ActionListener() {
      public void actionPerformed(ActionEvent e) { // selecionar cor Fundo
        acCorF();
    	}
    });    
    
    // this.lbX.setBounds(new Rectangle(3, 125, 50, 20));
    // this.add(lbX, null);
    // this.lbX.setText("  X: 0"); 
    // this.lbY.setBounds(new Rectangle(3, 145, 50, 20));
    // this.add(lbY, null);
    // this.lbY.setText("  Y:"+y);   
    this.btApagar.setBounds(new Rectangle(3, 165, 50, 20));
    this.add(btApagar, null);
    this.btApagar.setIcon(new ImageIcon(Paint.class.getResource("apagar.gif")));
    this.btApagar.setToolTipText("Apagar");
    this.btApagar.addActionListener (new ActionListener(){
      public void actionPerformed(ActionEvent e) {
         mudarPara("Borracha", 0); 
    	}
    });
    // Painel de Desenho
    this.dPainel.setBounds(new Rectangle(55,5,this.getWidth()-90,this.getHeight()-50));
    this.add(dPainel, null);
    this.addMouseMotionListener(new MouseMotionListener(){
	    // trata eventos de arrasto do mouse 	     
	    public void mouseDragged(MouseEvent event){
	      aoRedimensionar();
      }
	    // trata evento de mover mouse
	    public void mouseMoved(MouseEvent event){
	      aoRedimensionar();
	    }
	  });
		this.setVisible(true);
  }

	private void mudarPara(String ferramenta, int tipo) {
    dPainel.setForma(tipo);
    this.setTitle("Paint - Ferramenta Selecionada: " + ferramenta);
  }
  
  private void acCor(){
    cor2 = cor;
    cor = JColorChooser.showDialog(Paint.this, "Defina uma Cor", cor);
    if (cor == null) {
      cor = cor2;  
    } else {
      cor2 = cor;
    }
    dPainel.setCor(cor);
    btCor.setBackground(cor);
  }
  
  private void acCorF(){
    cor2 = corF;
    corF = JColorChooser.showDialog(Paint.this, "Defina uma Cor", corF);
    if (corF == null) {
      corF = cor2;  
    } else {
      cor2 = corF;
    }
    dPainel.setBackground(corF);
    btCorF.setBackground(corF);
  }
 
  private void aoFechar() {
    System.exit(0);
  }
 
  private void aoRedimensionar(){
    dPainel.setBounds(new Rectangle(55,5,this.getWidth()-90,this.getHeight()-50));
    this.add(dPainel, null);
  }
 
  public static void main(String args[]) {
    new Paint();
  }
}
