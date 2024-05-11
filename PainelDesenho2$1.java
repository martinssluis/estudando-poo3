import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class PainelDesenho2$1 extends MouseAdapter {
   PainelDesenho2$1(PainelDesenho2 var1) {
      this.this$0 = var1;
   }

   public void mousePressed(MouseEvent var1) {
      this.this$0.aoPressionarMouse(var1);
   }

   public void mouseReleased(MouseEvent var1) {
      this.this$0.aoSoltarMouse(var1);
   }
}
