import java.util.Scanner;

public interface Tree {
  public String TreeName(String treeName);  
  public int TreeHeight(int treeHeight);
}
public class TreeInterface implements Tree {
  @Override
  public String TreeName(String treeName) {
    String name = treeName;
    System.out.println(name);
    return name;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    TreeName(sc.nextLine());
    System.out.println(TreeName);
  }
}
