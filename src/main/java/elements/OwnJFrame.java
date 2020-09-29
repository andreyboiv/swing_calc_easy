package elements;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class OwnJFrame extends JFrame {

    public OwnJFrame(int width, int height, LayoutManager layoutManager) {
        //  String lookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();

        String lookAndFeelClassName = "com.jtattoo.plaf.smart.SmartLookAndFeel";
        try {
            UIManager.setLookAndFeel(lookAndFeelClassName);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        super.setDefaultLookAndFeelDecorated(true);

        // make the frame half the height and width
  /*      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        super.setSize(width / 2, height / 2);
*/

           super.setSize(width,height);
        //   jFrame.setPreferredSize(new Dimension(300,300));
        super.setMinimumSize(new Dimension(width , height ));
        super.setResizable(false);
        super.setLayout(layoutManager);


        super.setLocationRelativeTo(null);

        URL url = getClass().getClassLoader().getResource("img/me.jpg");
        super.setIconImage(new ImageIcon(url).getImage());

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
