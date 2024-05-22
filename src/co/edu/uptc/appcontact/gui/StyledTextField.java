package co.edu.uptc.appcontact.gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StyledTextField extends JTextField {
	private static final long serialVersionUID = 1L;

	public StyledTextField() {
        initializeUI();
    }

    public StyledTextField(String text) {
        super(text);
        initializeUI();
    }

    public StyledTextField(int columns) {
        super(columns);
        initializeUI();
    }

    public StyledTextField(String text, int columns) {
        super(text, columns);
        initializeUI();
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(250, 40));
        setFont(new Font("Roboto", Font.PLAIN, 16));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY),
                new EmptyBorder(10, 10, 10, 10)
        ));
        setCaretColor(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g2d);
        g2d.dispose();
    }
}