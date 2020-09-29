package listerners;

import elements.JMyMenuItem;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class MenuSkinsChangeL extends AbstractAction {

    private JFrame jFrame;

    public MenuSkinsChangeL(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        JMyMenuItem jMenuItem = (JMyMenuItem) ev.getSource();
        try {
            UIManager.setLookAndFeel(jMenuItem.getPfadFullName());
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

        jFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }
}
