import java.util.*;
import java.io.*;

class Main {
    static int n;
    static String[] channels;
    static StringBuilder result = new StringBuilder();
    static int currentPos = 0; // 현재 화살표 위치

    // 특정 채널의 위치 찾기
    public static int findChannel(String channel) {
        for (int i = 0; i < n; i++) {
            if (channels[i].equals(channel)) {
                return i;
            }
        }
        return -1;
    }

    // 화살표를 특정 위치로 이동
    public static void moveArrowTo(int targetPos) {
        while (currentPos < targetPos) {
            result.append("1");
            currentPos++;
        }
        while (currentPos > targetPos) {
            result.append("2");
            currentPos--;
        }
    }

    // 현재 화살표 위치의 채널을 특정 위치로 이동
    public static void moveChannelToPosition(int targetPos) {
        while (currentPos > targetPos) {
            // 현재 채널을 위로 이동 (4번 버튼)
            String temp = channels[currentPos];
            channels[currentPos] = channels[currentPos - 1];
            channels[currentPos - 1] = temp;
            result.append("4");
            currentPos--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        channels = new String[n];

        for (int i = 0; i < n; i++) {
            channels[i] = br.readLine();
        }

        // 1. KBS1을 첫 번째로 이동
        int kbs1Pos = findChannel("KBS1");
        moveArrowTo(kbs1Pos);
        moveChannelToPosition(0);

        // 2. KBS2를 두 번째로 이동
        int kbs2Pos = findChannel("KBS2");
        moveArrowTo(kbs2Pos);
        moveChannelToPosition(1);

        System.out.print(result.toString());
    }
}