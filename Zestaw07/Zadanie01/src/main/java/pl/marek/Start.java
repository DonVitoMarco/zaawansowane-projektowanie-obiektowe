package pl.marek;

import pl.marek.ui.AppFrame;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppFrame::new);
    }
}
