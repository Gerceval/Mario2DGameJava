package com.julien.game;
import javax.swing.*;

public class Main {

    public static Scene scene;

    public static void main(String[] args) {

        // Création de la fenêtre de l'application
        JFrame window = new JFrame("Super Mario Bros - par Gerceval");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 360);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        // Instanciation de l'objet scene
        scene = new Scene();

        window.setContentPane(scene); // On associe la scene à la fenêtre de l'application
        window.setVisible(true);

    }
}
