// importar bibliotecas para criação de Ambientes Gráficos (GUI) em que * significa todos igual no sql, nesse caso todos os pacotes
import java.awt.*; // ABSTRACT WINDOW TOOKIT é uma api(conjunto de Classes prontas) suporte a criação de janelas
import java.awt.event.*; // para criar eventos como o nome sugere
import javax.swing.*; // barra, icones, caixas de texto (no netbeans é mais fácil de usar)

public class Paint extends JFrame { //define a classe Paint que herda de Jframe para criar a janela de desenho
//declaração dos botões que são variáveis de instancia da classe Paint (só podem ser acessados dentro da própria classe)
  private JButton btApagar = new JButton(); //JButton informa que a variável é um botão, e o new JButton() é um método para criar um novo botão com o nome da variável 
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
//declaração das labels
  private JLabel lbX = new JLabel(); // o mesmo conceito dos botões se aplicam aqui
  private JLabel lbY = new JLabel();
  // declaração das cores
  private Color cor = Color.black; 
  private Color cor2 = Color.black;
  private Color corF = Color.white;
  private int x,y;
  
  private PainelDesenho2 dPainel = new PainelDesenho2(); //declara a variável dPainel que é do tipo PainelDesenho2, dPainel será uma instancia dessa dessa classe
  // new PainelDesenho2() cria uma nova intancia da classe com mesmo nome e é construtor padrão da classe 

  public Paint() {
    super("Paint"); //define o titulo da janela como Paint
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define o comportamento padrão ao fechar a janela (ele sai ao fechar a janela)
    this.setLayout(null); //desativa o layout automatico da janela
    this.setSize(583, 340); // define o tamanho inicial da janela
    this.setResizable(true); //permite que o usuário redimensione a janela
    this.setLocation((800-583)/2, (600-340)/2); //centraliza a janela

    this.btTraco.setBounds(new Rectangle(3, 5, 25, 20)); //define a posição e tamanho do botão btTraco
    this.add(btTraco, null); // adiciona o botão à janela Paint
    this.btTraco.setIcon(new ImageIcon(Paint.class.getResource("traco.gif"))); //define o icone do botão que será o arquivo traco.gif
    this.btTraco.setToolTipText("Livre"); // define o texto de dica que será exibido ao passar o mouse sobre o botão btTraco
    this.btTraco.addActionListener (new ActionListener(){// adiciona um ouvinte de açã ao botão e define uma ação a ser executada quando for clicado
      public void actionPerformed(ActionEvent e) { // Desenho livre
        mudarPara("Livre", 1); //chama o metodo mudarPara com os parametros "Livre" e 1 para mudar o modo de desenho livre
	    }
		});    
    this.btLinha.setBounds(new Rectangle(28, 5, 25, 20)); //define a posição e tamanho do botão
    this.add(btLinha, null); //adiciona o botão à janela
    this.btLinha.setIcon(new ImageIcon(Paint.class.getResource("linha.gif"))); //define o icone do botão
    this.btLinha.setToolTipText("Linha"); //deixa o texto de dica do botão
    this.btLinha.addActionListener (new ActionListener() { //adiciona um ouvinte de ação ao botão, define uma ação a ser executada quado clicado
      public void actionPerformed(ActionEvent e) { // chama o método mudarPara com parametros linha e 2 para mudar para o modo de desenho de linha
        mudarPara("Linha", 2);
    	}
    });
    this.btRetanC.setBounds(new Rectangle(3, 25, 25, 20));//defineposiçã e tamanho do botão
    this.add(btRetanC, null);//adiciona botão à janela
    this.btRetanC.setIcon(new ImageIcon(Paint.class.getResource("RetanC.gif")));// define o icone do borão
    this.btRetanC.setToolTipText("Retângulo Cheio");// texto de dica
    this.btRetanC.addActionListener (new ActionListener() { //adiciona um ouvinte de ação ao botao, define ação quando clicado
      public void actionPerformed(ActionEvent e) { // Retangulo cheio método chamado quando clicado
        mudarPara("Retângulo Cheio", 3); //chama o método mudarPara com parametros retangulo cheio e 3 para mudar o modo de desenho
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
    this.btCor.setBounds(new Rectangle(3, 85, 50, 20));//define posição e tamanho do botão
    this.add(btCor, null);//adiciona o botão à janela
    this.btCor.setBackground(cor);// define cor de de fundo do botão como a cor atual (definida enteriomente na classe)
    this.btCor.setToolTipText("Cor do Desenho");// texto dica
    this.btCor.addActionListener (new ActionListener() { //método chamado quando clicado
      public void actionPerformed(ActionEvent e) { // selecionar cor
        acCor(); //chama o método para que o usuário selecione a cor
    	}
    });
    this.btCorF.setBounds(new Rectangle(3, 105, 50, 20)); //posição e tamanho do botão 
    this.add(btCorF, null); //adiciona o botão à janela
    this.btCorF.setBackground(Color.white); //define a cor de fundo como branco
    this.btCorF.setToolTipText("Cor Fundo"); //texto dica
    this.btCorF.addActionListener (new ActionListener() { 
      public void actionPerformed(ActionEvent e) { // selecionar cor Fundo
        acCorF(); //muda a cor de fundo
    	}
    });    
    
     this.lbX.setBounds(new Rectangle(3, 125, 50, 20));
     this.add(lbX, null);
     this.lbX.setText("  X: 0"); 
     this.lbY.setBounds(new Rectangle(3, 145, 50, 20));
     this.add(lbY, null);
     this.lbY.setText("  Y:"+y);   
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
