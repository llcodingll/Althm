import java.util.Scanner;

public class Bridge_P {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[][] map = new int[n][n];
        
        // 지도 정보 입력 받기
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        // 최대값 저장
        int maxDistance = 0;
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                // 지금 위치가 섬인지 검사
                if (map[i][j] == 1) {
                    // 동쪽 방향 검사
                    for (int d = 1; d < map.length; d++) {
                        if (j + d < map.length && map[i][j + d] == 1) {
                            maxDistance = Math.max(maxDistance, d);
                            break;
                        }
                    }
                    
                    // 서쪽 방향 검사
                    for (int d = 1; d < map.length; d++) {
                        if (j - d >= 0 && map[i][j - d] == 1) {
                            maxDistance = Math.max(maxDistance, d);
                            break;
                        }
                    }
                    
                    // 북쪽 방향 검사
                    for (int d = 1; d < map.length; d++) {
                        if (i - d >= 0 && map[i - d][j] == 1) {
                            maxDistance = Math.max(maxDistance, d);
                            break;
                        }
                    }
                    
                    // 남쪽 방향 검사
                    for (int d = 1; d < map.length; d++) {
                        if (i + d < map.length && map[i + d][j] == 1) {
                            maxDistance = Math.max(maxDistance, d);
                            break;
                        }
                    }
                }
            }
        }
        
        System.out.println(maxDistance);
    }
}