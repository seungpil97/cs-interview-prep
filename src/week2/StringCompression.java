package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열을 앞에서부터 같은 문자가 연속으로 반복되는 경우
 * 반복 횟수 + 문자로 압축하세요.
 * 1개인 경우 숫자 생략
 * <p>
 * 입력: String s
 * 출력: String
 * <p>
 * 예시)
 * "aabbaab" → "2a2b2a1b" (X) → "2a2b2ab"
 * "aaabbcc" → "3a2b2c"
 * "abc"     → "abc"
 * "aaaa"    → "4a"
 */
public class StringCompression {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    StringBuilder sb = new StringBuilder();
    char currentToken = input.charAt(0);
    int count = 1;
    for (int i = 1; i < input.length(); i++) {

      char token = input.charAt(i);

      if (currentToken == token) {
        count++;
      } else {
        flush(sb, count, currentToken);
        count = 1;
        currentToken = token;
      }
    }

    flush(sb, count, currentToken);

    System.out.println(sb);


  }

  private static void flush(StringBuilder sb, int count, char ch) {
    if (count > 1) sb.append(count);
    sb.append(ch);
  }
}
