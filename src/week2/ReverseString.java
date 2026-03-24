package week2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열을 뒤집어서 반환하세요.
 * <p>
 * 입력: String s
 * 출력: String
 * <p>
 * 예시)
 * "hello" → "olleh"
 * "abcde" → "edcba"
 */
public class ReverseString {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    StringBuilder sb = new StringBuilder();

    sb.append(input);
    sb.reverse();

    System.out.println(sb);

  }
}
