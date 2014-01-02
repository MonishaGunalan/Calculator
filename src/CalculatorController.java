import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {

	private String operator1 = "";
	private String operator2 = "";
	private String operand;
	private String equals;
	private boolean receivedOp1 = false;
	private boolean receivedOp2 = false;
	private boolean receivedOperand = false;
	private boolean receivedEquals = false;
	private CalculatorModel model;

	public CalculatorController() {
		model = new CalculatorModel(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonPressed = e.getActionCommand();

		if (isInt(buttonPressed) && !receivedOp1) {
			this.operator1 += buttonPressed;
			model.display(operator1);
		
		} else if (validOperand(buttonPressed) && !operator1.equals("")) {
			receivedOp1 = true;
			this.operand = buttonPressed;
			receivedOperand = true;

		} else if (isInt(buttonPressed) && receivedOp1 && !receivedOp2) {
			this.operator2 += buttonPressed;
			model.display(operator2);

		} else if (buttonPressed.equals("=") && receivedOp1 && !operator2.equals("") && receivedOperand) {
			receivedOp2 = true;
			this.equals = buttonPressed;
			receivedEquals = true;
			performOperation();
			reset();

		} else if (buttonPressed.equals("C")) {
			System.out.println("Reset. Ready for next calculation");
			reset();
			model.display("0");
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
	
	public void performOperation(){
		System.out.print(operator1 + operand + operator2 + equals);
		model.setOperator1(operator1);
		model.setOperator2(operator2);
		model.setOperand(operand);
		model.performCalculation();
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
