/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.view.swing;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
/**
 *
 * @author giovanni
 */
public class CustomTextAreaPanel extends JPanel{


    private JTextArea textArea;
    private static final int MAX_CHARACTERS = 100; // Quantidade limite de caracteres

    public CustomTextAreaPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
        textArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Define o tamanho da fonte
        textArea.setMargin(new Insets(10, 10, 10, 10)); // Adiciona margens internas

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                adjustTextAreaSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                adjustTextAreaSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                adjustTextAreaSize();
            }

            private void adjustTextAreaSize() {
                int textLength = textArea.getText().length();
                if (textLength > MAX_CHARACTERS) {
                    Dimension size = textArea.getSize();
                    textArea.setPreferredSize(new Dimension(size.width, size.height + 20));
                    textArea.revalidate();
                    textArea.repaint();
                }
            }
            
        });
    }
}

