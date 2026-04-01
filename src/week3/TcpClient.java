package week3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {
  public static void main(String[] args) throws IOException {

    // 서버에 연결 요청 - SYN 보내는 순간!
    Socket socket = new Socket("localhost", 8080);
    System.out.println("서버에 연결됨!");

    // 데이터 송신
    PrintWriter out = new PrintWriter(
      new OutputStreamWriter(socket.getOutputStream())
    );

    out.println("Hello Server!");
    out.flush(); // 버퍼 비우기 - 안 하면 메시지 안 감

    // 자원 해제
    out.close();
    socket.close();

  }
}
