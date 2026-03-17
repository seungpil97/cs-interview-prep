package week1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 주어진 문자열이 올바른 괄호 문자열인지 확인하세요.
 * <p>
 * 올바른 괄호란:
 * - '(' 와 ')' 로만 이루어져 있고
 * - 모든 괄호가 올바르게 열리고 닫혀야 합니다
 * <p>
 * 입력: String s
 * 출력: boolean
 * <p>
 * 예시)
 * "(())()" → true
 * "(()" → false
 * ")(" → false
 * "(()())" → true
 */
public class BracketValidator {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    Deque<Character> stack = new ArrayDeque<>();

    // myMethod(input, stack);

    int count = 0;

    for (int i = 0; i < input.length(); i++) {

      char c = input.charAt(i);

      if (c == ')' && count == 0) {
        System.out.println(false);
        return;
      }

      if (c == '(') count++;
      else count--;
    }

    System.out.println(count == 0);
  }

  private static void myMethod(String input, Deque<Character> stack) {
    for (int i = 0; i < input.length(); i++) {

      char c = input.charAt(i);

      if (c == ')' && stack.isEmpty()) {
        System.out.println("false");
        return;
      }

      if (c == '(') {
        stack.push(c);
      } else {
        stack.pop();
      }
    }

    System.out.println(stack.isEmpty());
  }
}
