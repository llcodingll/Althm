import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class UnionFind {
    static int[] parent;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            int[][] arr = new int[M][3];
            for (int i = 0; i < M; i++) {
                StringTokenizer inputs = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(inputs.nextToken());
                }
            }
             
            parent = make(N+1);
            System.out.print("#"+t+" ");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 3; j++) {
                    if(arr[i][0] == 0) {
                        union(arr[i][1], arr[i][2]);
                    } else if(arr[i][0] == 1) {
                        int a = find(arr[i][1]);
                        int b = find(arr[i][2]);
                        if(a == b) {
                            System.out.print(1);
                            break;
                        } else {
                            System.out.print(0);
                            break;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
     
    private static int[] make(int N) {
        int[] parent = new int[N];
        for (int i = 1; i < N; i++) {
            parent[i] = i;
        }
        return parent;
    }
     
    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
     
    private static void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
         
        parent[root_x] = root_y;
    }
}