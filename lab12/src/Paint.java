import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;


class MyFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    MyCanvas canvas;

    MyFrame(String title) {
        super(title);

        setLayout(new FlowLayout());
        canvas = new MyCanvas();
        add(canvas);

        setSize(1280, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyCanvas extends Canvas {
    @Serial
    private static final long serialVersionUID = 1L;

    int oldx = 0;
	int oldy = 0;

    MyCanvas() {
        this.setSize(new Dimension(1280, 800));
        this.setBackground(Color.BLACK);
        this.addMouseMotionListener((new MouseAdapter() {
            public void mouseDragged(MouseEvent mouseEvent) {
                MyCanvas app = (MyCanvas) mouseEvent.getSource();
                //cast catre sursa de eveniment
                Graphics g = app.getGraphics();
                g.setColor(new Color(255, 255, 255));
                int x, y;
                x = mouseEvent.getX();
                y = mouseEvent.getY();

				if(oldx == 0 && oldy == 0) {
					oldx = x;
					oldy = y;
				}
                g.drawLine(oldx, oldy, x, y);
				oldx = x;
				oldy = y;
            }

			public void mouseReleased(MouseEvent me) {
				oldx = 0;
				oldy = 0;
			}
        }));
    }

}

public class Paint {
    public static void main(String... strings) {
        MyFrame frame = new MyFrame("Mouse events");
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
