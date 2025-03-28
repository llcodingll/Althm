import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Contact {
    
    static ArrayList<Integer>[] contact;
    static boolean[] visited;
      
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
        int T = 10;
        for(int t = 1; t<= T; t++) {
              
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
       
            contact = new ArrayList[101];
            visited = new boolean[101];
              
            for(int i = 0; i <= 100; ++i) {
                contact[i] = new ArrayList<>();
            }
              
            st = new StringTokenizer(br.readLine());
              
              
            for(int i = 0; i < N/2;i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
  
                contact[a].add(b);    
            }
              
            System.out.println("#" + t + " " + bfs(M));
              
        }
    }
      
    private static int bfs(int start) {
        ArrayDeque<Integer> dque = new ArrayDeque<>();
        dque.add(start);
        visited[start] = true;
          
        while (true) {
            int size = dque.size();
            int num = 0;
              
            for(int i = 0; i < size; ++i) {
                int curr = dque.poll();
                num = Math.max(curr, num);
                  
                for (int next : contact[curr]) {
                    if(visited[next]) continue;
                      
                    visited[next] = true;
                    dque.add(next);
                }
            }
              
            if(dque.isEmpty()) {
                return num;
            }
        }
    }
}