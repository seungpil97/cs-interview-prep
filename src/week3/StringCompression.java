package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    System.out.println(solution(s));
  }

  private static int solution(String s) {
    int min = s.length();
    for (int k = 1; k <= s.length() / 2; k++) {
      min = Math.min(min, compress(s, k));
    }
    return min;
  }

  private static int compress(String s, int k) {
    StringBuilder sb = new StringBuilder();
    String prev = s.substring(0, k);
    int count = 1;

    for (int i = k; i < s.length(); i += k) {
      String curr = s.substring(i, Math.min(i + k, s.length()));

      if (curr.equals(prev)) {
        count++;
      } else {
        if (count > 1) {
          sb.append(count).append(prev);
        } else {
          sb.append(prev);
        }
        count = 1;
      }
      prev = curr;
    }

    // 마지막 조각 처리
    if (count > 1) {
      sb.append(count).append(prev);
    } else {
      sb.append(prev);
    }

    return sb.length();
  }
}