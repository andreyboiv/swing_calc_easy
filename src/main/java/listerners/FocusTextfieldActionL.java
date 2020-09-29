package listerners;

import entrypoint.InitialCalcGUI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class FocusTextfieldActionL implements FocusListener {

    public FocusTextfieldActionL() {
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField jTextField = (JTextField) e.getSource();
        if (jTextField.getText().equals(InitialCalcGUI.INPUT_NUMBER)) {
            jTextField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField jTextField = (JTextField) e.getSource();
        if (jTextField.getText().equals("")) {
            jTextField.setText(InitialCalcGUI.INPUT_NUMBER);
        }
    }
}
