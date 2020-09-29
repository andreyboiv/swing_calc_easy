package elements;

import javax.swing.*;

public class JMyMenuItem extends JMenuItem {

    private String name;
    private String pfadFullName;

    public JMyMenuItem(String name, String pfadFullName){
        super.setText(name);
        this.name = name;
        this.pfadFullName = pfadFullName;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPfadFullName() {
        return pfadFullName;
    }
}
