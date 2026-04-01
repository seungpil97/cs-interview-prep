package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
  public static void main(String[] args) throws IOException {

    // 포트 8080에서 대기 — SYN 기다리는 상태
    ServerSocket serverSocket = new ServerSocket(8080);
    System.out.println("서버 시작 - 연결 대기 중...");

    // accept() - 클라이언트 SYN 오면 연결 수락 (SYN-ACK + ACK)
    Socket socket = serverSocket.accept();
    System.out.println("클라이언트 연결됨!");

    // 데이터 수신
    BufferedReader in = new BufferedReader(
      new InputStreamReader(socket.getInputStream())
    );

    String messgae = in.readLine();
    System.out.println("받은 메시지: " + messgae);

    // 자원 해제 (4-way Handshacke 발생!)
    in.close();
    socket.close();
    serverSocket.close();

  }
}
