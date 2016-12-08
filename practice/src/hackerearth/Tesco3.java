//look at code http://ideone.com/wrfw7C
package hackerearth;

import java.util.*;

public class Tesco3 {

	/**
	 * @param args
	 */
	static int n;
	static int m;
	static String[] mat;
	static char[][] matrix;
	static int maxCount = -999999;
	static int[] rows = {0,1,0,-1};
	static int[] cols = {-1,0,1,0};
	static char[] dir = {'L','D','R','U'};
	static ArrayList<Character> resList = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.next());
		m = Integer.parseInt(in.next());
		mat = new String[n];
		matrix = new char[n][m];
		int startRow =0;
		int startCol =0;
		for(int i=0; i<n; i++){
			mat[i] = in.next();
		}
		
		for (int i = 0; i < mat.length; i++) {
			int idx = mat[i].indexOf('S');
			if(idx!=-1){
				startRow = i;
				startCol = idx;
			}
//			matrix[i] = mat[i].toCharArray();
			//System.out.println(Arrays.toString(matrix[i]));
			for(int i1=0; i1<n;i1++){
				for(int j=0; j<m; j++){
					matrix[i1][j] = mat[i1].charAt(j);
				}
			}
		}
		//System.out.println(matrix[3][4]);
		ArrayList<Character> alist = new ArrayList<>();
		int count =0;
		for(int i=0; i<4; i++){
			if(isvalid(startRow+rows[i],startCol+cols[i]) && !isBad(startRow+rows[i],startCol+cols[i])){
				int tmp = count;
				if(matrix[startRow+rows[i]][startCol+cols[i]] == '.'){
					count++;
				}
				//System.out.println(i+" "+dir[i]);
				alist.add(dir[i]);
				char cc = matrix[startRow+rows[i]][startCol+cols[i]];
				if(cc != 'F'){
					matrix[startRow+rows[i]][startCol+cols[i]] = 'A';
				}
				dfs(startRow+rows[i],startCol+cols[i], alist, count);
				count = tmp;
				matrix[startRow+rows[i]][startCol+cols[i]] = cc;
				alist.remove(alist.size()-1);
			}
		}
		
		for(Character c: resList){
			System.out.print(c);
		}
		
		
		

	}
	private static void dfs(int k, int l, ArrayList<Character> alist, int count) {
		//System.out.println("here1 "+count);
//		if(k==3 && l==4){
//			System.out.println(matrix[k][l]+" "+count);
//		}
		
		if(matrix[k][l] == 'F'){
			//System.out.println("here");
			if(count > maxCount){
				maxCount = count;
				//System.out.println(alist.toString());
				resList = new ArrayList<>(alist);
			}
			return;
		}
		
		for(int i=0; i<4; i++){
			if(isvalid(k+rows[i],l+cols[i]) && !isBad(k+rows[i],l+cols[i])){
				int tmp = count;
				if(matrix[k+rows[i]][l+cols[i]] == '.'){
					count++;
				}
				alist.add(dir[i]);
				char cc = matrix[k+rows[i]][l+cols[i]];
				if(cc != 'F'){
					matrix[k+rows[i]][l+cols[i]] = 'A';
				}
				dfs(k+rows[i],l+cols[i], alist, count);
				count = tmp;
				matrix[k+rows[i]][l+cols[i]] = cc;
				alist.remove(alist.size()-1);
			}
		}
		
	}
	static boolean isBad(int i, int j) {
		if(matrix[i][j] == 'A' || matrix[i][j] == '#' || matrix[i][j] == 'S'){
			return true;
		}
		return false;
	}
	static boolean isvalid(int i, int j) {
		if(i <0 || i >=n || j <0 || j >=m){
			return false;
		}
		return true;
	}

}
