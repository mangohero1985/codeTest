package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mangohero on 2018/04/05.
 */
class smTest1 {

  public int solution(int[] A) {
    int res = Integer.MIN_VALUE;
    // If input is null or array size less than 2, return -1
    if (A.length < 2 || A == null) {
      return -1;
    }
    //read all elements and index into Map in form of <value, index>
    Map<Integer, ArrayList<Integer>> pairMap = new TreeMap<Integer, ArrayList<Integer>>();
    for (int i = 0; i < A.length; i++) {
      if (pairMap.get(A[i]) != null) {
        ArrayList<Integer> indexList = pairMap.get(A[i]);
        indexList.add(i);
        pairMap.put(A[i], indexList);
      } else {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(i);
        pairMap.put(A[i], indexList);
      }
    }
    // sort input array in order to find the pairs of index
    Arrays.sort(A);
    ArrayList<Integer> left = new ArrayList();
    ArrayList<Integer> right = new ArrayList();
    //scan adjacent values and get their index to compute difference.
    for (int i = 0; i < A.length - 1; i++) {
      //get index of those adjacent value who are not equal
      if (A[i] != A[i + 1]) {
        left = pairMap.get(A[i]);
        right = pairMap.get(A[i + 1]);
      } else { //get index of those adjacent value who are equal, and step jump to next value by size
        left = pairMap.get(A[i]);
        int size = left.size();
        if (size == A.length) {
          return 0;
        }
        right = pairMap.get(A[i + size]);
        i += (size - 1);
      }
      //only compute the difference between left.first and right.last, because the pairMap were read by index order.
      if (res < Math.abs(left.get(0) - right.get(right.size() - 1))) {
        res = Math.abs(left.get(0) - right.get(right.size() - 1));
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] A = {0, 3, 3, 7, 5, 3, 11, 1};
    smTest1 solution = new smTest1();
    solution.solution(A);
  }
}