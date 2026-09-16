import java.io.*;
import java.util.*;

// 스도쿠
class Snode{
	int r; 
	int c;
	public Snode(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main {

	private static int[][] map;
	private static List<Snode> list;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String in = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = in.charAt(j) - '0';

				if(map[i][j] == 0) list.add(new Snode(i,j));
			}
		}
		sdoku(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.deleteCharAt(sb.length()-1).toString());
	}
	
	static boolean end = false;
	static void sdoku(int idx) {
		
		if(idx == list.size()) {
			end = true;
			return;
		}
		
		for (int n = 1; n < 10; n++) {
			int row = list.get(idx).r;
			int col = list.get(idx).c;
			
			if(checkRC(row,col,n) && check33(row, col, n)) {
				map[row][col] = n;
				sdoku(idx+1);
				
				
				if(end) {
					return;
				}
				
				map[row][col] = 0;
			}
		}
	}
	
	/**
	 * 가로, 세로에 num 값이 존재하는지 체크
	 */
	static boolean checkRC(int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if(map[row][i] == num) return false; // 가로 체크 (해당 숫자가 존재하면 false)
			if(map[i][col] == num) return false; // 세로 체크 (해당 숫자가 존재하면 false)
		}	
		
		return true;
	}
	
	/**
	 * 3*3에 num 값이 존재하는지 체크
	 */
	static boolean check33(int row, int col, int num) {
		
		int nr = row / 3*3;
		int nc = col / 3*3;
		
		for (int i = nr; i < nr+3; i++) {
			for (int j = nc; j < nc+3; j++) {
				if(map[i][j] == num) { // 해당 숫자가 존재하면 false
					return false;
				}
			}
		}
		return true;
	}
}
