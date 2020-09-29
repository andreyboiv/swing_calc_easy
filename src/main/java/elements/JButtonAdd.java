package elements;

import interfaces.CalcOperatoinsButtons;

import javax.swing.*;

public class JButtonAdd extends JButton implements CalcOperatoinsButtons {

    public JButtonAdd(String text, int width, int height) {
        super.setText(text);
        super.setSize(width, height);
    }

    @Override
    public String action(double a, double b) {
        return String.valueOf(a + b);
    }
}
