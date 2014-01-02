import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {

	public CalculatorController() {
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonPressed = e.getActionCommand();
		String operator1 = "";
		String operator2 = "";
		String operand = "";
		String equals = "";
		boolean receivedOp1 = false;
		boolean receivedOp2 = false;
		boolean receivedOperand = false;
		
		
		if(isInt(buttonPressed) && !receivedOp1){
			operator1 += Integer.parseInt(buttonPressed);
		}else if (!isInt(buttonPressed)){
			receivedOp1 = true;
			operand = buttonPressed;
			receivedOperand = true;
		}else if(isInt(buttonPressed) && receivedOp1 && !receivedOp1 ){
			operator2 += Integer.parseInt(buttonPressed);
		}else if(!isInt(buttonPressed) && buttonPressed.equals("=")){
			equals = 
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

	public static void main(String[] args) {
		CalculatorController controller = new CalculatorController();

	}
}
