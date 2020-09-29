package elements;

import java.awt.*;

import javax.swing.*;

public class OwnJPanel extends JPanel {

    public OwnJPanel(LayoutManager layoutManager) {
        super.setSize(100, 100);
        //    jPanel3.setMinimumSize(new Dimension(200,50));
        super.setPreferredSize(new Dimension(200, 50));
        super.setLayout(new FlowLayout(FlowLayout.LEFT));
        super.setBorder(BorderFactory.createEtchedBorder());


        super.setVisible(true);
    }
}
