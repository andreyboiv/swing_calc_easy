package elements;

import interfaces.CalcOperatoinsButtons;

import javax.swing.*;

public class JButtonMulti extends JButton implements CalcOperatoinsButtons {

    public JButtonMulti(String text, int width, int height) {
        super.setText(text);
        super.setSize(width, height);
    }

    @Override
    public String action(double a, double b) {
        return String.valueOf(a * b);
    }
}
