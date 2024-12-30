package br.com.login.view.swing;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class CustomTextArea extends JTextArea {

    private static final int MAX_LINES = 6; // Limite máximo de linhas
    private final int lineHeight; // Altura de uma linha (baseado na fonte)

    public CustomTextArea(int rows, int columns) {
        super(rows, columns);
        setLineWrap(true);
        setWrapStyleWord(true);

        // Calcula a altura de uma linha
        lineHeight = getFontMetrics(getFont()).getHeight();

        // Adiciona o listener para ajustar o tamanho
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                adjustSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                adjustSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                adjustSize();
            }

            private void adjustSize() {
                // Verifica o número de caracteres
                int textLength = getText().length();

                // Verifica o número de linhas
                int lineCount = getLineCount();

                // Calcula a nova altura (baseado no número de linhas)
                int newHeight = Math.min(lineCount * lineHeight, MAX_LINES * lineHeight);

                // Atualiza a altura do componente
                Dimension size = getPreferredSize();
                setPreferredSize(new Dimension(size.width, newHeight));
                revalidate(); // Atualiza o layout
                repaint(); // Redesenha o componente

                
            }
        });
    }
}
