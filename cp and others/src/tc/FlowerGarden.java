package tc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Flower{
	int height;
	int bloom;
	int wilt;
	public Flower(int h, int b, int w){
		height = h;
		bloom = b;
		wilt = w;
	}
}


public class FlowerGarden {
	static List<Flower> fl = new ArrayList<Flower>();
	static List<Flower> axfl = new ArrayList<Flower>();
	public static void main(String[] args) {
        int[] ht = {1,2,5,4,3,8};
        int[] bloom = {1,90,30,40,12,40};
        int[] wilt =  {100,150,39,60,13,300};
        getOrdering(ht,bloom,wilt);
	}
	public static int[] getOrdering(int[] height, int[] bloom, int[] wilt){
		
		
		for (int i = 0; i < wilt.length; i++) {
			Flower f=new Flower(height[i], bloom[i], wilt[i]);
			fl.add(f);
		}
		axfl.add(fl.get(0));
		for(int i =1; i<fl.size();i++){
		//	System.out.println("i in get ="+i);
			Flower f = fl.get(i);
			insert(f,0);
		}
		int ht[] = new int[height.length];
		//System.out.println(axfl.size());
		for(int i=0;i<axfl.size();i++){
	//		System.out.println(axfl.get(i).height);
			ht[i] = axfl.get(i).height;
		}
		System.out.println(Arrays.toString(ht));
		return ht;
		
	}
	public static void insert(Flower f,int i){
		//System.out.println("i ="+i);
	//	System.out.println(f.height);
		if((f.height> axfl.get(i).height && !(block(f.bloom,f.wilt,axfl.get(i).bloom,axfl.get(i).wilt))) ||
				(f.height< axfl.get(i).height && (block(f.bloom,f.wilt,axfl.get(i).bloom,axfl.get(i).wilt))))	{
			axfl.add(i, f);
		}
		else if(i==axfl.size()-1) {axfl.add(f);}
		else if((f.height> axfl.get(i).height && (block(f.bloom,f.wilt,axfl.get(i).bloom,axfl.get(i).wilt))) ||
				(f.height< axfl.get(i).height && !(block(f.bloom,f.wilt,axfl.get(i).bloom,axfl.get(i).wilt)))){
			insert(f,++i);
		}
	}
	
	public static boolean block(int x1,int y1, int x2, int y2){
		boolean blk = false;
		for (int i = x1; i <= y1; i++) {
			for (int j = x2; j <= y2; j++) {
				if(i==j){blk = true; return blk;}
			}
		}
		return blk;
		
	}
}
