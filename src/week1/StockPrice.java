package week1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [스택 활용] 주식 가격
 * 초 단위로 기록된 주식 가격 배열이 주어질 때,
 * 각 시점에서 가격이 떨어지지 않은 기간(초)을 구하세요.
 * <p>
 * 입력: int[] prices
 * 출력: int[]
 * <p>
 * 예시)
 * prices = [1, 2, 3, 2, 3]
 * 결과   = [4, 3, 1, 1, 0]
 * <p>
 * 설명)
 * prices[0] = 1 → 이후 4초간 안 떨어짐
 * prices[1] = 2 → 이후 3초간 안 떨어짐
 * prices[2] = 3 → 1초 후 2로 떨어짐
 * prices[3] = 2 → 1초 후 3으로 오름 (안 떨어짐)
 * prices[4] = 3 → 마지막이라 0초
 */
public class StockPrice {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    // myMethod(input);

    int[] prices = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      prices[i] = Integer.parseInt(input[i]);
    }

    int[] result = new int[prices.length];
    Deque<Integer> stack = new ArrayDeque<>();

    // prices
    // 0 1 2 3 4  - index
    // 1 2 3 2 3 - prices
    // 0 1 2 3
    // 0 1        - stack
    for (int i = 0; i < prices.length; i++) {

      // 현재 가격이 스택 top의 가격보다 작으면 → 떨어진 것
      while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
        int idx = stack.pop();
        result[idx] = i - idx;
      }

      stack.push(i);
    }

    // 스택에 남은 건 끝까지 안 떨어진 것
    while (!stack.isEmpty()) {
      int idx = stack.pop();
      result[idx] = prices.length - 1 - idx;
    }

    for (int r : result) {
      System.out.println(r);
    }
  }

  private static void myMethod(String[] input) {
    int[] prices = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      prices[i] = Integer.parseInt(input[i]);
    }

    int[] results = new int[prices.length];

    for (int i = 0; i < results.length; i++) {

      int price = prices[i];
      int count = 0;

      for (int j = i + 1; j < results.length; j++) {

        count++;
        if (prices[j] < price) break;
      }
      results[i] = count;
    }

    for (int result : results) {
      System.out.println(result);
    }
  }
}
