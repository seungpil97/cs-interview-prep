package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 🟡 문제: 소수 찾기
 * <p>
 * 패키지: week3 / 클래스명: PrimeNumbers
 * <p>
 * 문제 설명
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수를 완성하세요.
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다. (1은 소수가 아닙니다.)
 * 입출력 예시
 * <p>
 * n = 10  →  4   // 2, 3, 5, 7
 * n = 5   →  3   // 2, 3, 5
 */
public class PrimeNumbers {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);

    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {

      // 만약 i가 소수 혹은 아직 지워지지 않았다면
      if (isPrime[i]) {
        // i의 배수 j들에 대해 isPrime[j] = false; 로 둔다.
        // i*i미만의 배수는 이미 지워졌으므로 신경쓰지 않는다.
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }


    }

    int count = 0;

    for (int i = 2; i <= n; i++) {  // 1 → 2로 변경
      if (isPrime[i]) count++;
    }
  }
}
