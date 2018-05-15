package com.matritellabs.utama.jbd;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    // Class constructor
    public Screen() throws HeadlessException {
        initializeGUI();
    }

    // Initialize GUI
    public void initializeGUI() {

        // New content frame to hold label and text input
        JPanel contentFrame = new JPanel();
        contentFrame.setLayout(new BorderLayout());
        this.getContentPane().add(contentFrame);

        // Frame styles
        contentFrame.setBackground(Color.BLACK);

        // Frame attributes

        // Set frame window size
        this.setSize(1024, 768);
        // Close button
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }


}
