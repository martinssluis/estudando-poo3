import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Paint$14 implements MouseMotionListener {
   Paint$14(Paint var1) {
      this.this$0 = var1;
   }

   public void mouseDragged(MouseEvent var1) {
      Paint.access$400(this.this$0);
      Paint.access$502(this.this$0, Paint.access$000(this.this$0).getX3());
      Paint.access$602(this.this$0, Paint.access$000(this.this$0).getY3());
      Paint.access$700(this.this$0).setText("  X:" + Paint.access$500(this.this$0));
      Paint.access$800(this.this$0).setText("  Y:" + Paint.access$600(this.this$0));
   }

   public void mouseMoved(MouseEvent var1) {
      Paint.access$400(this.this$0);
      Paint.access$502(this.this$0, Paint.access$000(this.this$0).getX3());
      Paint.access$602(this.this$0, Paint.access$000(this.this$0).getY3());
      Paint.access$700(this.this$0).setText("  X:" + Paint.access$500(this.this$0));
      Paint.access$800(this.this$0).setText("  Y:" + Paint.access$600(this.this$0));
   }
}