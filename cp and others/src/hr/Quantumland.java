package hr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class qnodes{
	int sindex;
	int cindex;
	double ctocindex;
	boolean addedtocycle = false;
	int cycleindex=-1;
	
	public qnodes(int s,int c ,int cost){
		sindex = s;
		cindex = c;
		ctocindex = cost;
	}
}

public class Quantumland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n= s.nextInt();
		
		boolean visited[] = new boolean[n];
		List<qnodes> qlist=new ArrayList<qnodes>();
		
		for (int i = 0; i < n; i++) {
			int cindex = s.nextInt();
			int cost = s.nextInt();
			qnodes q= new qnodes(i,cindex-1,cost);
			qlist.add(q);
		}
		
		double rprob=0;
		double pdts[]= new double[n];
		Arrays.fill(pdts, 1);
		
		for (int i = 0; i < n; i++) {
			qnodes q1=qlist.get(i);
			double pdt=1;
			int flag=0;
			//if(visited[q1.sindex]==false && q1.addedtocycle==false) System.out.println(q1.sindex);
			while(visited[q1.sindex]==false && q1.addedtocycle==false){
				//System.out.println("Here---------");
				flag=1;
				visited[q1.sindex] =true;
				q1.addedtocycle = true;
				q1.cycleindex =i;
				pdt=pdt*(q1.ctocindex/100);
				if(pdt==0) {
					pdt=1;
				}
				qnodes temp= qlist.get(q1.cindex);
				if(temp.cycleindex !=-1 && temp.cycleindex !=q1.cycleindex) flag=0;
				q1=temp;
				if(visited[q1.sindex]==false) pdts[q1.sindex]=pdt;
			}
			if(flag==1) {
				rprob+=(pdt/pdts[q1.sindex]);
				//System.out.println(Arrays.toString(pdts)+"   "+q1.sindex+" rprob="+rprob);
			}
		}
		double roundOff = Math.round(rprob * 100.0) / 100.0;
	    System.out.println(String.format("%.2f", roundOff));

	}

}
