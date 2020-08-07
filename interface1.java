class CalculatorDummy {
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public void sum() {
		return this.left + this.right;
	}
	public void avg() {
		return (this.left + this.right)/2;
	}
}

public class interface1 {
	public static void main(String[] args) {
		CalculatorDummy c = new CalculatorDummy();
		c.setOprands(10, 20, 30);
		System.out.println(c.sum() + c.avg());
	}
}
