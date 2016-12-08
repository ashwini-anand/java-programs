package gfg;

public class CuttingARod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight = {3,5,10,12,14};
		maxValue(weight);

	}

	public static int maxValue(int[] weight){
		int[] wt = new int[weight.length+1];
		wt[0] = 0;
		for (int i = 0; i < weight.length; i++) {
			wt[i+1] = weight[i];
		}
		for (int i = 1; i < wt.length; i++) {
			for (int j = 1; j < i; j++) {
				if(wt[i-j]+wt[j] > wt[i]) wt[i] = wt[i-j]+wt[j];
				//System.out.println(wt[i]+" "+i);
			}
		}
		System.out.println(wt[wt.length-1]);
		return 0;
		
	}
}
