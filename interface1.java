class CalculatorDummy {
	int left, right;
	public void newSetOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public void setOprands(int first, int second, int third) {}
	public int sum() {
		return 60;
	}
	public int avg() {
		return 20;
	}
	
}

public class interface1 {
	public static void main(String[] args) {
		CalculatorDummy c = new CalculatorDummy();
		c.setOprands(10, 20, 30);
		System.out.println(c.sum() + c.avg());
	}
}
