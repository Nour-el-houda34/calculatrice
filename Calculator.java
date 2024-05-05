import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener {
	JFrame frame;
	JTextField text;
	JButton[] numberButtons = new JButton[10];
	JButton addButton, subButton, divButton, mulButton, decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 500);
		frame.setLayout(null);

		text = new JTextField();
		text.setBounds(50, 30, 300, 50);
		text.setEditable(false);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
		}

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");

		JButton[] functionButtons = { addButton, subButton, mulButton, divButton, decButton, equButton, delButton,
				clrButton, negButton };

		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
		}

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(text);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == decButton) {
			text.setText(text.getText().concat("."));
		}

		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '+';
			text.setText("");
		}

		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '-';
			text.setText("");
		}

		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '*';
			text.setText("");
		}

		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '/';
			text.setText("");
		}

		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(text.getText());
			switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
			}
			text.setText(String.valueOf(result));
			num1 = result;
		}

		if (e.getSource() == clrButton) {
			text.setText("");
		}

		if (e.getSource() == delButton) {
			String str = text.getText();
			text.setText("");
			for (int i = 0; i < str.length() - 1; i++) {
				text.setText(text.getText() + str.charAt(i));
			}
		}

		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(text.getText());
			temp *= -1;
			text.setText(String.valueOf(temp));
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
