package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 오늘 문제: 완주하지 못한 선수
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여했습니다.
 * 단 한 명의 선수를 제외하고는 모두 완주했습니다.
 * 완주하지 못한 선수의 이름을 반환하세요.
 * 제한 사항
 * <p>
 * 마라톤 참가자 수 : 1 ≤ participant.length ≤ 100,000
 * completion.length = participant.length - 1
 * 참가자 중 동명이인이 있을 수 있습니다
 * 참가자 이름은 알파벳 소문자만 사용, 길이 1~20
 * <p>
 * 입출력 예시
 * participant ["leo", "kiki", "eden"]
 * completion ["eden", "kiki"]
 * return "leo"
 */
public class MarathonSolver {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] participant = br.readLine().split(" ");
    String[] completion = br.readLine().split(" ");

    Map<String, Integer> map = new HashMap<>();

    // 1. 참가자 카운트 +1
    for (String p : participant) {
      map.put(p, map.getOrDefault(p, 0) + 1);
    }

    // 2. 완주자 카운트 -1
    for (String c : completion) {
      map.put(c, map.get(c) - 1);
    }

    // 3. 카운트가 1 남은 사람이 완주 못한 선수
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 0) {
        System.out.println(entry.getKey());
        break;
      }
    }
  }
}
