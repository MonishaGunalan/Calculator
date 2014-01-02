import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CalculatorView extends JFrame implements Observer {
	private CalculatorController controller;
	private JLabel display;

	public CalculatorView(CalculatorController controller) {
		super("Calculator");
		this.controller = controller;
		createFrame();
	}

	public void createFrame() {
		JPanel outerPanel = new JPanel();
		// outerPanel.setLayout(new GridLayout(2,1));
		outerPanel.setLayout(new BorderLayout());
		this.add(outerPanel);

		display = new JLabel("0", JLabel.RIGHT);
		display.setBackground(new Color(238, 251, 191));
		display.setOpaque(true);
		display.setBorder(BorderFactory.createLoweredBevelBorder());
		display.setSize(15, 180);
		outerPanel.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4));

		// Create Buttons
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton zero = new JButton("0");

		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("/");
		JButton equals = new JButton("=");
		JButton decimal = new JButton(".");
		JButton on = new JButton("Reset");

		// Add buttons to action Listener
		one.addActionListener(controller);
		two.addActionListener(controller);
		three.addActionListener(controller);
		four.addActionListener(controller);
		five.addActionListener(controller);
		six.addActionListener(controller);
		seven.addActionListener(controller);
		eight.addActionListener(controller);
		nine.addActionListener(controller);
		zero.addActionListener(controller);

		add.addActionListener(controller);
		subtract.addActionListener(controller);
		multiply.addActionListener(controller);
		divide.addActionListener(controller);
		equals.addActionListener(controller);
		decimal.addActionListener(controller);
		on.addActionListener(controller);

		// Row 1
		buttonPanel.add(seven);
		buttonPanel.add(eight);
		buttonPanel.add(nine);
		buttonPanel.add(divide);

		// Row 2
		buttonPanel.add(four);
		buttonPanel.add(five);
		buttonPanel.add(six);
		buttonPanel.add(multiply);

		// Row 3
		buttonPanel.add(one);
		buttonPanel.add(two);
		buttonPanel.add(three);
		buttonPanel.add(subtract);

		// Row 4
		buttonPanel.add(zero);
		buttonPanel.add(decimal);
		buttonPanel.add(equals);
		buttonPanel.add(add);

		outerPanel.add(buttonPanel, BorderLayout.SOUTH);

		// Row 0
		outerPanel.add(on, BorderLayout.CENTER);

		setSize(200, 200);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void update(Observable model, Object o) {
		display.setText((String)o);		
	}

}
