class Main {
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