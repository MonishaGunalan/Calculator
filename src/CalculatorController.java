import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {

	private String operator1 = "";
	private String operator2 = "";
	private String operand = "";
	private String equals = "";
	private boolean receivedOp1 = false;
	private boolean receivedOp2 = false;
	private boolean receivedOperand = false;
	private boolean receivedEquals = false;

	public CalculatorController() {
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonPressed = e.getActionCommand();
		// System.out.println(buttonPressed);

		if (isInt(buttonPressed) && !receivedOp1) {
			operator1 += Integer.parseInt(buttonPressed);
			System.out.println("Operator1: " + operator1);

		} else if (validOperand(buttonPressed)) {
			receivedOp1 = true;
			operand = buttonPressed;
			receivedOperand = true;
			System.out.println("Operand: " + operand);

		} else if (isInt(buttonPressed) && receivedOp1 && !receivedOp2) {
			operator2 += Integer.parseInt(buttonPressed);
			System.out.println("Operator2: " + operator2);
			
		} else if (buttonPressed.equals("=")) {
			receivedOp2 = true;
			equals = buttonPressed;
			receivedEquals = true;
			System.out.println("Equals: " + equals);

		} else if (buttonPressed.equals("C")) {
			System.out.println("Reset. Ready for next calculation");
			reset();
		
		} else {
			System.out.println("Invalid Input");
		}
	}

	public boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validOperand(String buttonPressed) {
		if (buttonPressed.equals("+") || buttonPressed.equals("-")
				|| buttonPressed.equals("*") || buttonPressed.equals("/")) {
			return true;
		}
		return false;
	}

	public void reset() {
		operator1 = "";
		operator2 = "";
		operand = "";
		equals = "";
		receivedOp1 = false;
		receivedOp2 = false;
		receivedOperand = false;
		receivedEquals = false;
	}

	public static void main(String[] args) {
		CalculatorController controller = new CalculatorController();

	}
}
