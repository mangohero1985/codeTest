package codility;

/**
 * Created by mangohero on 2018/04/04.
 */
public class TapeEquilibrium {

  public int solution(int[] A) {
    // write your code in Java SE 8
    int numDiff = A.length - 1;
    int diff = 0;
    long firstPart = 0;
    long sum = 0;
    for (int i = 0; i < numDiff + 1; i++) {
      sum += A[i];
    }
    for (int i = 0; i < numDiff; i++) {
      firstPart += A[i];
      long secondPart = sum - firstPart;
      long tempDiff = 0;
      if (firstPart > secondPart) {
        tempDiff = firstPart - secondPart;
      } else {
        tempDiff = secondPart - firstPart;
      }
      if (tempDiff < diff || i == 0) {
        diff = (int) tempDiff;
      }
    }

    return diff;
  }

  public static void main(String[] args) {
    TapeEquilibrium test = new TapeEquilibrium();
    int[] input = {-3, -1, -2, -4, -3};
    test.solution(input);
  }

}
