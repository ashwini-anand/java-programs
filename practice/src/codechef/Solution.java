package codechef;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class Solution {
    // you may add more methods here
   static ArrayList<Integer> al = new ArrayList<>();
   static int[] tr;
   static int n;
   static int max;
    public static int maxDiameterSum(int nodes, int[] tree) {
        n = nodes;
        tr = tree;
        max =-999999999;
        
        findSum(tr[0],0);
        int tempMax = findMax();
        if(tempMax > max){
        	max = tempMax;
        }
        
        return max;
    }
    
    public static int findMax(){
    	int tmax = -99999999;
    	for(int i=0; i< al.size(); i++){
        	int sumi = al.get(i);
        	for(int j=i+1; j<al.size();j++){
        		if(sumi+al.get(j)-tr[0] > tmax){
        			tmax = sumi+al.get(j)-tr[0];
        		}
        	}
        }
    	return tmax;
    }
    
    public static void findSum(int sum,int i){
    	
    	if(2*i+1 >= n){
    		if(max < tr[i]){
    			max = tr[i];
    		}
    		al.add(sum);
    		return;
    	}
    	findSum(sum+tr[2*i+1], 2*i+1);
    	findSum(sum+tr[2*i+2], 2*i+2);
    }
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        
        for(int i=0;i<cases;i++){
            int nodes = Integer.parseInt(br.readLine());            
            
            String[] temp = br.readLine().split(" ");
            int[] tempArr = new int[temp.length];
            
            for(int j=0;j<temp.length;j++)
                tempArr[j]= Integer.parseInt(temp[j]);
            
            int answer = maxDiameterSum(nodes, tempArr);
            System.out.println(answer);
        }
    }
    
}
