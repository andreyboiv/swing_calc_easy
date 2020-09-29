package entrypoint;

import elements.DialogsWindow;
import elements.JButtonAdd;
import elements.JButtonDiv;
import elements.JButtonMulti;
import elements.JButtonSub;
import elements.JMyMenuItem;
import elements.OwnJFrame;
import elements.OwnJPanel;
import interfaces.CalcOperatoinsButtons;
import listerners.ButtonActionL;
import listerners.MenuSkinsChangeL;
import listerners.MouseTextfieldL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.*;

import com.jtattoo.plaf.AbstractLookAndFeel;

import org.reflections.Reflections;


public class InitialCalcGUI {

    public static final String INPUT_NUMBER = "enter a number...";

    private JFrame mainFrame;

    private JPanel mainPanel1;
    private JPanel mainPanel2;
    private JPanel mainPanel3;

    private JTextField firstNumberTextfield;
    private JTextField secondNumberTextfield;
    private JTextField resultNumberTextfield;

    private JLabel firstNumberLabel;
    private JLabel secondNumberLabel;
    private JLabel resultNumberLabel;

    private CalcOperatoinsButtons addButtoon;
    private CalcOperatoinsButtons subtractionButton;
    private CalcOperatoinsButtons multiplicationButton;
    private CalcOperatoinsButtons divisionBuuton;

    private JMenuBar mb;
    private JMenu menu1;
    private List<JMenuItem> jMenuItems;

    private List<String> skins;

    public static void main(String[] args) {

        InitialCalcGUI caldGUI = new InitialCalcGUI();

        caldGUI.initialJFrame();

        caldGUI.addJMenu();
        caldGUI.addJMenuListerners();

        caldGUI.initialJPanel();
        caldGUI.initialJTextFields();
        caldGUI.initialJLabels();
        caldGUI.initialJButtons();

        caldGUI.addElementsToPanel();
        caldGUI.addPanelToMainFrame();

        caldGUI.addFocusTextfieldListerners();
        caldGUI.addButtonActionListerners();

        caldGUI.setMainFrameVisible();
    }

    private void addJMenuListerners() {
        MenuSkinsChangeL menuL = new MenuSkinsChangeL(this.mainFrame);
        for (JMenuItem jMenuItem : jMenuItems) {
            jMenuItem.addActionListener(menuL);
        }
    }

    private void addJMenu() {
        mb = new JMenuBar();
        menu1 = new JMenu("File");

        JMenu submenuSkins = new JMenu("Skins");
        skins = new ArrayList();

        Reflections reflections = new Reflections("com.jtattoo.plaf");
        Set<Class<? extends AbstractLookAndFeel>> classes = reflections.getSubTypesOf(com.jtattoo.plaf.AbstractLookAndFeel.class);
        for (Class<? extends AbstractLookAndFeel> aClass : classes) {
            skins.add(aClass.getName());
        }

        jMenuItems = new ArrayList<>();

        for (String skinFullName : skins) {
            JMenuItem jMenuItem = new JMyMenuItem(
                    skinFullName.substring(skinFullName.lastIndexOf(".") + 1),
                    skinFullName);
            jMenuItems.add(jMenuItem);
            submenuSkins.add(jMenuItem);
        }

        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu menu2 = new JMenu("Help");
        JMenuItem itemAbout = new JMenuItem("About");
        itemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogsWindow dialogsWindow = new DialogsWindow();
                JOptionPane.showMessageDialog(dialogsWindow,
                        "Hi, Das Programm hat Andrey B. programmiert", "Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        menu1.add(submenuSkins);
        menu1.add(itemExit);
        menu2.add(itemAbout);

        mb.add(menu1);
        mb.add(menu2);
        this.mainFrame.setJMenuBar(mb);
    }

    private void addFocusTextfieldListerners() {
 /*
        FocusTextfieldActionL focusActionL = new FocusTextfieldActionL();
        this.firstNumberTextfield.addFocusListener(focusActionL);
        this.secondNumberTextfield.addFocusListener(focusActionL);
 */
        MouseTextfieldL mouseL = new MouseTextfieldL();
        this.firstNumberTextfield.addMouseListener(mouseL);
        this.secondNumberTextfield.addMouseListener(mouseL);
    }

    private void addButtonActionListerners() {
        ButtonActionL buttonActionL = new ButtonActionL(
                this.firstNumberTextfield,
                this.secondNumberTextfield,
                this.resultNumberTextfield);

        ((JButtonAdd) this.addButtoon).addActionListener(buttonActionL);
        ((JButtonSub) this.subtractionButton).addActionListener(buttonActionL);
        ((JButtonMulti) this.multiplicationButton).addActionListener(buttonActionL);
        ((JButtonDiv) this.divisionBuuton).addActionListener(buttonActionL);
    }

    private void setMainFrameVisible() {
        this.mainFrame.setVisible(true);
    }

    private void initialJFrame() {
        this.mainFrame = new OwnJFrame(430,200,new BorderLayout());
    }

    private void initialJPanel() {
        this.mainPanel1 = new OwnJPanel(new FlowLayout(FlowLayout.LEFT));
        this.mainPanel2 = new OwnJPanel(new FlowLayout(FlowLayout.LEFT));
        this.mainPanel3 = new OwnJPanel(new FlowLayout(FlowLayout.LEFT));
    }

    private void initialJTextFields() {
        this.firstNumberTextfield = new JTextField(INPUT_NUMBER, 10);
        this.secondNumberTextfield = new JTextField(INPUT_NUMBER, 10);
        this.resultNumberTextfield = new JTextField(10);
        this.resultNumberTextfield.setEditable(false);
    }

    private void initialJLabels() {
        this.firstNumberLabel = new JLabel("Number 1: ");
        this.secondNumberLabel = new JLabel("Number 2: ");
        this.resultNumberLabel = new JLabel("Result: ");
    }

    private void initialJButtons() {
        this.addButtoon = new JButtonAdd("ADD", 100, 100);
        this.subtractionButton = new JButtonSub("SUB", 100, 100);
        this.multiplicationButton = new JButtonMulti("MULTI", 100, 100);
        this.divisionBuuton = new JButtonDiv("DIV", 100, 100);
    }

    private void addElementsToPanel() {
        this.mainPanel1.add(this.firstNumberLabel);
        this.mainPanel1.add(this.firstNumberTextfield);

        this.mainPanel1.add(this.secondNumberLabel);
        this.mainPanel1.add(this.secondNumberTextfield);

        this.mainPanel2.add((JButtonAdd) this.addButtoon);
        this.mainPanel2.add((JButtonSub) this.subtractionButton);
        this.mainPanel2.add((JButtonMulti) this.multiplicationButton);
        this.mainPanel2.add((JButtonDiv) this.divisionBuuton);

        this.mainPanel3.add(this.resultNumberLabel);
        this.mainPanel3.add(this.resultNumberTextfield);
    }

    private void addPanelToMainFrame() {
        this.mainFrame.getContentPane().add(this.mainPanel1, BorderLayout.NORTH);
        this.mainFrame.getContentPane().add(this.mainPanel2, BorderLayout.CENTER);
        this.mainFrame.getContentPane().add(this.mainPanel3, BorderLayout.SOUTH);
    }
}
