package codility;

/**
 * Created by mangohero on 2018/04/04.
 */
public class ChocolatesByNumbers {

  public int solution(int N, int M) {
    // write your code in Java SE 8
    if (M == 0) {
      return 1;
    } else {
      long result = 0;
      long eat = 0;
      do {
        eat = (eat + M) % N;
        result++;
      } while (eat > 0);
      return (int) result;
    }
  }

  public static void main(String[] args) {
    ChocolatesByNumbers cho = new ChocolatesByNumbers();
    cho.solution(10, 4);
  }

}
