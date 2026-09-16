
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] nutrients; // 겨울마다 추가되는 양분
    static int[][] land;      // 현재 양분 상태
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static Queue<Tree> trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nutrients = new int[n][n];
        land = new int[n][n];
        trees = new LinkedList<>();

        // 겨울에 추가될 양분 입력 + 초기 양분 5 설정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nutrients[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = 5;
            }
        }

        // 초기 나무 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }

        // 나이 순 정렬
        List<Tree> sorted = new ArrayList<>(trees);
        Collections.sort(sorted);
        trees = new LinkedList<>(sorted);

        // k년 반복
        for (int year = 0; year < k; year++) {
            List<Tree> dead = new ArrayList<>();
            Queue<Tree> newTrees = new LinkedList<>();

            // 봄
            int size = trees.size();
            while (size-- > 0) {
                Tree tree = trees.poll();
                if (land[tree.x][tree.y] >= tree.age) {
                    land[tree.x][tree.y] -= tree.age;
                    newTrees.add(new Tree(tree.x, tree.y, tree.age + 1));
                } else {
                    dead.add(tree);
                }
            }

            // 여름 - 죽은 나무 양분화
            for (Tree tree : dead) {
                land[tree.x][tree.y] += tree.age / 2;
            }

            // 가을 - 번식
            List<Tree> breeding = new ArrayList<>();
            for (Tree tree : newTrees) {
                breeding.add(tree);
                if (tree.age % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int nx = tree.x + dx[d];
                        int ny = tree.y + dy[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            trees.add(new Tree(nx, ny, 1));
                        }
                    }
                }
            }

            // 부모 나무 다시 추가
            trees.addAll(breeding);

            // 겨울 - 양분 추가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    land[i][j] += nutrients[i][j];
                }
            }
        }

        System.out.println(trees.size());
    }

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}