package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n쌍의 괄호로 만들 수 있는 모든 올바른 괄호 조합을 반환하세요.
 * <p>
 * 입력: int n
 * 출력: List<String>
 * <p>
 * 예시)
 * n=1 → ["()"]
 * n=2 → ["(())", "()()"]
 * n=3 → ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */
public class ValidParenthesesCombinations {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    generate(0, 0, n,  sb);


  }

  private static void generate(int open, int close, int n, StringBuilder sb) {

    if (open == n && close == n) {
      System.out.println(sb);  // ← 완성된 문자열 출력!
      return;
    }

    if (open < n) {
      sb.append("(");
      generate(open + 1, close, n, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (close < open) {
      sb.append(")");
      generate(open, close + 1, n, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
