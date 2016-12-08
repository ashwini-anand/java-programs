package hackerearth;

import java.util.*;

public class Tesco3_2 {

	/**
	 * @param args
	 */
	static int n;
	static int m;
	static String[] mat;
	static char[][] matrix;
	static int maxCount = -999999;
//	static int[] rows = {0,1,0,-1};
//	static int[] cols = {-1,0,1,0};
	static int rowMat[][] = {{0,1,0,-1}, {0,1,-1,0}, {0,0,1,-1}, {0,0,-1,1}, {0,-1,0,1}, {0,-1,1,0}, {1,0,0,-1}, {1,0,-1,0}, {1,0,0,-1}, {1,0,-1,0}, {1,-1,0,0}, {1,-1,0,0}, {0,1,0,-1}, {0,1,-1,0}, {0,0,1,-1}, {0,0,-1,1}, {0,-1,0,1}, {0,-1,1,0}, {-1,1,0,0}, {-1,1,0,0}, {-1,0,1,0}, {-1,0,0,1}, {-1,0,0,1}, {-1,0,1,0}};
	static int colMat[][] = {{-1,0,1,0}, {-1,0,0,1}, {-1,1,0,0}, {-1,1,0,0}, {-1,0,1,0}, {-1,0,0,1}, {0,-1,1,0}, {0,-1,0,1}, {0,1,-1,0}, {0,1,0,-1}, {0,0,1,-1}, {0,0,-1,1}, {1,0,-1,0}, {1,0,0,-1}, {1,-1,0,0}, {1,-1,0,0}, {1,0,-1,0}, {1,0,0,-1}, {0,0,1,-1}, {0,0,-1,1}, {0,1,0,-1}, {0,1,-1,0}, {0,-1,1,0}, {0,-1,0,1}};
	//static char[] dir = {'L','D','R','U'};
	static ArrayList<Character> resList = new ArrayList<>();
	static int comp = 0;
	static Random rand = new Random();
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
			matrix[i] = mat[i].toCharArray();
			//System.out.println(Arrays.toString(matrix[i]));
		}
		//System.out.println(matrix[3][4]);
		ArrayList<Character> alist = new ArrayList<>();
		int count =0;
		int rNum = rand.nextInt(24);
		for(int i=0; i<4; i++){
			if(isvalid(startRow+rowMat[rNum][i],startCol+colMat[rNum][i]) && !isBad(startRow+rowMat[rNum][i],startCol+colMat[rNum][i])){
				int tmp = count;
				count++;
				//System.out.println(i+" "+dir[i]);
				alist.add(getDirection(rowMat[rNum][i],colMat[rNum][i]));
				char cc = matrix[startRow+rowMat[rNum][i]][startCol+colMat[rNum][i]];
				if(cc != 'F'){
					matrix[startRow+rowMat[rNum][i]][startCol+colMat[rNum][i]] = 'A';
				}
				dfs(startRow+rowMat[rNum][i],startCol+colMat[rNum][i], alist, count);
				count = tmp;
				matrix[startRow+rowMat[rNum][i]][startCol+colMat[rNum][i]] = cc;
				alist.remove(alist.size()-1);
			}
		}
		
		for(Character c: resList){
			System.out.print(c);
		}
		
		
		

	}
	private static Character getDirection(int i, int j) {
		if(i==0 && j== -1){
			return 'L';
		}else if(i==1 && j==0){
			return 'D';
		}else if(i==0 && j==1){
			return 'R';
		}else{
			return 'U';
		}
		
	}
	private static void dfs(int k, int l, ArrayList<Character> alist, int count) {
		//System.out.println("here1 "+count);
//		if(k==3 && l==4){
//			System.out.println(matrix[k][l]+" "+count);
//		}
		comp++;
		if(comp==100000000){
			for(Character c: resList){
				System.out.print(c);
			}
			System.exit(0);
		}
		if(matrix[k][l] == 'F'){
			//System.out.println("here");
			if(count > maxCount){
				maxCount = count;
				//System.out.println(alist.toString());
				resList = new ArrayList<>(alist);
			}
			return;
		}
		int rNum = rand.nextInt(24);
		for(int i=0; i<4; i++){
			if(isvalid(k+rowMat[rNum][i],l+colMat[rNum][i]) && !isBad(k+rowMat[rNum][i],l+colMat[rNum][i])){
				int tmp = count;
				count++;
				alist.add(getDirection(rowMat[rNum][i], colMat[rNum][i]));
				char cc = matrix[k+rowMat[rNum][i]][l+colMat[rNum][i]];
				if(cc != 'F'){
					matrix[k+rowMat[rNum][i]][l+colMat[rNum][i]] = 'A';
				}
				dfs(k+rowMat[rNum][i],l+colMat[rNum][i], alist, count);
				count = tmp;
				matrix[k+rowMat[rNum][i]][l+colMat[rNum][i]] = cc;
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
