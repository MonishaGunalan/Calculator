import java.util.Observable;

public class CalculatorModel extends Observable {
	private double operator1, operator2, result;
	private char operand;

	public CalculatorModel(CalculatorController controller) {
		CalculatorView view = new CalculatorView(controller);	
		this.addObserver(view);
	}
	
	public void setOperator1(String operator1){
		this.operator1 = Double.parseDouble(operator1);
	}
	
	public void setOperator2(String operator2){
		this.operator2 = Double.parseDouble(operator2);
	}
	
	public void setOperand(String operand){
		this.operand = operand.charAt(0);
	}
	
	public void performCalculation(){
		switch(operand){
		case '+': result = operator1 + operator2;
				break;
		case '-': result = operator1 - operator2;
				break;
		case '*': result = operator1 * operator2;
				break;
		case '/': 
			try{
				result = operator1 / operator2;
				break;
			}catch(ArithmeticException e){
				display("Error");
				System.out.println("Error");
				return;
			}
		}			
		System.out.println(" "+ result);
		display("" + result);
	}
	
	public void display(String value){
		this.setChanged();
		this.notifyObservers(value);
	}
	
}
