package elements;

import interfaces.CalcOperatoinsButtons;

import javax.swing.*;

public class JButtonDiv extends JButton implements CalcOperatoinsButtons {

    public JButtonDiv(String text, int width, int height) {
        super.setText(text);
        super.setSize(width, height);
    }

    @Override
    public String action(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division 0");
        }
        return String.valueOf(a / b);
    }
}
