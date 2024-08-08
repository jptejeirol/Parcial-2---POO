/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

/**
 *
 * @author Juan Pablo Tejeiro Londoño
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Catalogo extends JFrame {
    
    private JTabbedPane tabbedPane;
    private JDesktopPane desktopPane;
    
    public Catalogo(){
        setTitle("Ejemplo de Componentes Swing");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        
        crearPanelPrincipal();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Ventana cerrándose");
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Tecla presionada: " + e.getKeyChar());
            }
        });
        
        setFocusable(true); 
}
    
    private void crearPanelPrincipal() {
        // JTabbedPane: Panel con pestañas
        tabbedPane = new JTabbedPane();

        // Creación de pestañas
        tabbedPane.addTab("Selección de frutas y verduras", crearPanelSeleccion());

        // JInternalFrame: Ventana interna para MDI
        JInternalFrame internalFrame = new JInternalFrame("Panel Principal", true, true, true, true);
        internalFrame.setContentPane(tabbedPane);
        internalFrame.setSize(900, 700);  // Aumentar el tamaño del JInternalFrame
        internalFrame.setVisible(true);

        desktopPane.add(internalFrame);
    }    

    private JPanel crearPanelSeleccion(){

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton boton = new JButton("Registrar");
        boton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Registro Exitoso"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(boton, gbc);

        String[] productos = {"Lechuga", "Tomate", "Repollo", "Brocoli", "Colifrol", 
            "Pepino", "Aguacate", "Manzana", "Durazno", "Uva", "Mandarina", "Mora", "Fresa", "Pera", "Berenjena", "Calabacin", "Mazorca", "Zanahoria", "Banano", "Rabano"};
        JComboBox<String> comboBox = new JComboBox<>(productos);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(comboBox, gbc);

        return panel;
    }
    
    
}
