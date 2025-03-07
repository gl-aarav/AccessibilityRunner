import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccessibilityRunner 
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Accessibility Healthcare Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.add(new Accessibility());
		frame.setVisible(true);
	}
}

class Accessibility extends JPanel implements KeyListener, MouseListener 
{
	private Color backgroundColor;
	private int fontSize;
	private int colorParameterVar;

	public Accessibility() 
	{
		colorParameterVar = 100;
		backgroundColor = new Color(colorParameterVar, colorParameterVar, colorParameterVar);
		setBackground(backgroundColor);
		fontSize = 12;
		addKeyListener(this);
		addMouseListener(this);
	}

	public void drawRectanglesWithLabels(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(10, 10, 100, 20);
		g.fillRect(115, 10, 100, 20);
		g.setColor(Color.BLACK);
		g.drawString("brighter", 35, 25);
		g.drawString("darker", 140, 25);
	}

	public void medicalPageContent(Graphics g) 
	{
		g.drawString("Healthcare content goes here...", 50, 150);
	}

	public void writeDirections(Graphics g) 
	{
		g.drawString("Press mouse on the panel. To increase the font size, press the UP arrow. " +
				"To decrease the font size, press the DOWN arrow. " +
				"To make the screen brighter, click the box labelled brighter. " +
				"To make the screen darker, click the box labelled darker.",
				50, 300);
	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		drawRectanglesWithLabels(g);
		g.setColor(Color.BLACK);
		Font font = new Font("Serif", Font.PLAIN, fontSize);
		g.setFont(font);
		medicalPageContent(g);
		writeDirections(g);
	}


	public void keyPressed(KeyEvent evt) 
	{
		if (evt.getKeyCode() == KeyEvent.VK_UP && fontSize < 80) 
		{
			fontSize += 5;
		} 
		else if (evt.getKeyCode() == KeyEvent.VK_DOWN && fontSize > 8) 
		{
			fontSize -= 5;
		}
		repaint();
	}


	public void keyReleased(KeyEvent evt) {}


	public void keyTyped(KeyEvent evt) {}


	public void mousePressed(MouseEvent evt) 
	{
		requestFocus();
	}

	public void mouseClicked(MouseEvent evt)
	{
		int x = evt.getX();
		int y = evt.getY();
		if (x >= 10 && x <= 110 && y >= 10 && y <= 30) 
		{ 
			if (colorParameterVar < 255 - 3) 
			{
				colorParameterVar += 3;
			}
		} 
		else if (x >= 115 && x <= 215 && y >= 10 && y <= 30) 
		{ 
			if (colorParameterVar > 34 + 3) 
			{
				colorParameterVar -= 3;
			}
		}
		backgroundColor = new Color(colorParameterVar, colorParameterVar, colorParameterVar);
		setBackground(backgroundColor);
		repaint();
	}


	public void mouseReleased(MouseEvent evt) {}

	public void mouseEntered(MouseEvent evt) {}

	public void mouseExited(MouseEvent evt) {}
}
