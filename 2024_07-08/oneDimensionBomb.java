import java.util.*;

public class oneDimensionBomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> bombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bombs.add(sc.nextInt());
        }

        boolean isBang;
        do {
            isBang = false;
            int count = 1;
            List<Integer> newBombs = new ArrayList<>();

            for (int i = 0; i < bombs.size(); i++) {
                if (i < bombs.size() - 1 && bombs.get(i).equals(bombs.get(i + 1))) {
                    count++;
                } else {
                    if (count >= m) {
                        isBang = true;
                    } else {
                        for (int j = 0; j < count; j++) {
                            newBombs.add(bombs.get(i - j));
                        }
                    }
                    count = 1;
                }
            }

            bombs = new ArrayList<>(newBombs);

        } while (isBang);

        // 최종 결과 출력
        System.out.println(bombs.size());
        for (int bomb : bombs) {
            System.out.println(bomb);
        }
    }
}
