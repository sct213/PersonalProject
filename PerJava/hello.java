interface calculator {
  public int plus();
  public int minus();
}
public class hello {
    @Override
    public int plus(int v1, int v2){
      System.out.println("결과: " + v1 + v2);
    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      int num1 = sc.nextInt();
      plus(num, num1);
    }
  }
}






