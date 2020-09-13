class ChildClass extends ParentClass {
	private String daughter;
	private String son;
	
	public ChildClass(){
		this("daughter", "son");
	}
	
	public ChildClass(String daughter, String son){
		this.daughter = daughter;
		this.son = son;
	}
	
	public String toString(){
		return super.getFather() + "/" + super.getMother() + "/" + this.daughter + "/" + this.son;
	}
	
	public static void main(String[] args) {
			ParentClass parentClass = new ParentClass();
			System.out.println(parentClass.getMother());
			System.out.println(parentClass.getFather());
			System.out.println(parentClass.toString());
			
			System.out.println();
			System.out.println();
			
			ChildClass childClass = new ChildClass();
			System.out.println(childClass.getDoughter());
			System.out.println(childClass.getSon());
			System.out.println(childClass.toString());
		}
}