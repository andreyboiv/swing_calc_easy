package listerners;

import elements.DialogsWindow;
import interfaces.CalcOperatoinsButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonActionL implements ActionListener {

    private JTextField firstNumberTextfield;
    private JTextField secondNumberTextfield;
    private JTextField resultNumberTextfield;

    public ButtonActionL(JTextField firstNumberTextfield,
                         JTextField secondNumberTextfield,
                         JTextField resultNumberTextfield) {
        this.firstNumberTextfield = firstNumberTextfield;
        this.secondNumberTextfield = secondNumberTextfield;
        this.resultNumberTextfield = resultNumberTextfield;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof CalcOperatoinsButtons) {
            try {
                double firstNumberDouble = Double.parseDouble(firstNumberTextfield.getText());
                double secondNumberDouble = Double.parseDouble(secondNumberTextfield.getText());
                resultNumberTextfield.setText(((CalcOperatoinsButtons) e.getSource()).action(firstNumberDouble, secondNumberDouble));
            }
            catch (RuntimeException ex) {
                String errorMessage = "";
                if (ex instanceof NumberFormatException) {
                    errorMessage = "Input valid number fields";
                } else if (ex instanceof ArithmeticException) {
                    errorMessage = ex.getMessage();
                }
                resultNumberTextfield.setText("");

                DialogsWindow dialogsWindow = new DialogsWindow();
                JOptionPane.showMessageDialog(dialogsWindow,
                        errorMessage, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
