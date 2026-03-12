package throwCalculatorAllOverAgain;

import java.awt.*;

public class CalculatorPanel extends Panel {

    @Override
    public void paint(Graphics g){

        int x = 0;
        int y = 0;
        while (x < 100) {
            y=x;
            g.drawRect(10, 10, 100, 100);
            x = x + 10;

        }

        super.paint(g);
    }

}
