package listerners;

import entrypoint.InitialCalcGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseTextfieldL extends MouseAdapter {

    @Override
    public void mouseEntered(MouseEvent e) {
        JTextField jTextField = (JTextField) e.getSource();
        if (jTextField.getText().equals(InitialCalcGUI.INPUT_NUMBER)) {
            jTextField.setText("");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JTextField jTextField = (JTextField) e.getSource();
        if (jTextField.getText().equals("")) {
            jTextField.setText(InitialCalcGUI.INPUT_NUMBER);
        }
    }
}
