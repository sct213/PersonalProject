public class ParentClass {
	private String mother;
	private String father;
	
	public ParentClass(){
		this.mother = "mother";
		this.father = "father";
	}
	
	public ParentClass(String mother, String father){
		this.mother = mother;
		this.father = father;
	}
	
	public String toString(){
		return this.father + "/" + this.mother;
	}
}