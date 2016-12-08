package tc;

import java.util.*;
public class grafixMask {
  public int[] sortedAreas(String[] rectangles) {
    boolean[][] open = new boolean[400][600];
    for(int i = 0; i < open.length; i++){
      Arrays.fill(open[i],true);
      Arrays.f
    }
    for(int i = 0; i < rectangles.length; i++){
      StringTokenizer st = new StringTokenizer(rectangles[i]);
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      for(int j = x1; j <= x2; j++){
        for(int k = y1; k <= y2; k++){
          open[j][k] = false;
        }
      }
    }
    ArrayList al = new ArrayList();
    LinkedList que = new LinkedList();
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    for(int i = 0; i < open.length; i++){
      for(int j = 0; j < open[i].length; j++){
        int ret = 0;
        if(open[i][j])que.add(new State(i,j));
        open[i][j] = false;
        while(que.size() > 0){
          ret++;
          State s = (State)que.removeFirst();
          for(int k = 0; k < dx.length; k++){
            int x = s.x+dx[k];
            int y = s.y+dy[k];
            if(x < 0 || y < 0 || x >= 400 || y >= 600 || !open[x][y])continue;
            open[x][y] = false;
            que.add(new State(x,y));
          }
        }
        if(ret != 0) al.add(new Integer(ret));
      }
    }
    int[] ret = new int[al.size()];
    for(int i = 0; i < al.size(); i++){
      ret[i] = ((Integer)al.get(i)).intValue();
    }
    Arrays.sort(ret);
    return ret;
  }
  
  class State{
    int x, y;
    State(int xx, int yy){x = xx; y = yy;}
  }
}