package minhahorta;

import javax.swing.*;
import java.awt.*;

public class TemaController {

    private static boolean darkMode = false;

    // cores do tema claro
    private static final Color LIGHT_BG = new Color(204, 255, 204);
    private static final Color LIGHT_LABEL = Color.BLACK;
    private static final Color LIGHT_FIELD_BG = Color.WHITE;
    private static final Color LIGHT_BUTTON_BG = null;
    private static final Color LIGHT_BUTTON_FG = Color.BLACK;

    // cores do tema escuro
    private static final Color DARK_BG = new Color(30, 70, 30);
    private static final Color DARK_LABEL = new Color(220, 255, 220);
    private static final Color DARK_FIELD_BG = new Color(50, 110, 50);
    private static final Color DARK_BUTTON_BG = new Color(70, 140, 70);
    private static final Color DARK_BUTTON_FG = DARK_LABEL;

    public static boolean isDarkMode() {
        return darkMode;
    }

    public static void setDarkMode(boolean value) {
        darkMode = value;
    }

    public static void aplicarTema(JFrame tela) {
        if (tela == null) {
            return;
        }
        Container root = tela.getContentPane();
        if (darkMode) {
            applyToComponent(root, true);
        } else {
            applyToComponent(root, false);
        }
        
        SwingUtilities.updateComponentTreeUI(tela);
        tela.repaint();
    }

    private static void applyToComponent(Component comp, boolean dark) {
        if (comp instanceof JPanel) {
            comp.setBackground(dark ? DARK_BG : LIGHT_BG);
            ((JPanel) comp).setOpaque(true);
        } else if (comp instanceof JLabel) {
            ((JLabel) comp).setForeground(dark ? DARK_LABEL : LIGHT_LABEL);
            ((JLabel) comp).setOpaque(false);
        } else if (comp instanceof JButton) {
            JButton b = (JButton) comp;
            b.setBackground(dark ? DARK_BUTTON_BG : LIGHT_BUTTON_BG);
            b.setForeground(dark ? DARK_BUTTON_FG : LIGHT_BUTTON_FG);
            b.setOpaque(true);
            b.setBorderPainted(true);
        } else if (comp instanceof JTextField) {
            JTextField t = (JTextField) comp;
            t.setBackground(dark ? DARK_FIELD_BG : LIGHT_FIELD_BG);
            t.setForeground(dark ? DARK_LABEL : LIGHT_LABEL);
            t.setOpaque(true);
        } else if (comp instanceof JTextArea) {
            JTextArea t = (JTextArea) comp;
            t.setBackground(dark ? DARK_FIELD_BG : LIGHT_FIELD_BG);
            t.setForeground(dark ? DARK_LABEL : LIGHT_LABEL);
            t.setOpaque(true);
        } else if (comp instanceof JComboBox) {
            JComboBox cb = (JComboBox) comp;
            cb.setBackground(dark ? DARK_FIELD_BG : LIGHT_FIELD_BG);
            cb.setForeground(dark ? DARK_LABEL : LIGHT_LABEL);
            cb.setOpaque(true);
        } else if (comp instanceof JScrollPane) {
            JScrollPane sp = (JScrollPane) comp;
            JViewport vp = sp.getViewport();
            if (vp != null && vp.getView() != null) {
                applyToComponent(vp.getView(), dark);
            }
            sp.setBackground(dark ? DARK_BG : LIGHT_BG);
            sp.setOpaque(true);
        } else if (comp instanceof JViewport) {

            ((JComponent) comp).setBackground(dark ? DARK_BG : LIGHT_BG);
        } else if (comp instanceof JTabbedPane) {
            ((JTabbedPane) comp).setBackground(dark ? DARK_BG : LIGHT_BG);
        } else {

            if (comp instanceof JComponent) {
                ((JComponent) comp).setOpaque(false);
            }
        }

        if (comp instanceof Container) {
            for (Component child : ((Container) comp).getComponents()) {
                applyToComponent(child, dark);
            }
        }
    }
}
