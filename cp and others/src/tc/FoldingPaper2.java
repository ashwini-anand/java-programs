package tc;

public class FoldingPaper2 {
	static final int inf = 1000000001;
	
	public static void main(String[] args) {

	}
	
	public static int min(int x , int y){
		return x>y? y: x;
	}
	
	public static int fold(int a,int b){
		if(a<b){
			return inf;
		}
		if(a==b) return 0;
		
		return (1+fold(a-min(a/2,a-b),b));
	}
	
	public static int solve(int W, int H, int A){
		
		int res = inf;
		for (int w = 1; w <= A; w++) {
			if(A%w ==0){
				int h = A/w;
				res = min(res,fold(W,w)+fold(H,h));
			}
			
		}
		return res >= inf ? -1 : res;
		
	}

}
