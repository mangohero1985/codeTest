package codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mangohero on 2018/04/05.
 */
public class smTest2 {

  public int solution(int[] A) {
    int res = Integer.MIN_VALUE;
    // If input is null or array size less than 2, return -1
    if (A.length < 2 || A == null) {
      return -1;
    }
    int flag = 0;
    Set set = new HashSet();
    for (int i = 0; i < A.length; i++) {
      set.add(A[i]);
      if (set.size() < 3) {
        flag++;
      } else {
        set.clear();
        set.add(A[i]);
        flag = 1;
      }
      if (flag > res) {
        res = flag;
      }
    }
    if (res == A.length) {
      return 0;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] A = {5, 4, 4, 4, 5, 4, 4, 5, 5, 3, 3, 3, 3, 3, 3, 3, 0, 1, 1, 2, 2, 1, 12};
    smTest2 solution = new smTest2();
    solution.solution(A);
  }
}
