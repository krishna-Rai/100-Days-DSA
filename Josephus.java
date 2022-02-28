class Solution {
    static int findSafe(ArrayList<Integer> pos,int start,int k){
        if(pos.size()==1){
            return pos.get(0);
            
        }
        int next =(start+k)%pos.size();
        pos.remove(next);
        return findSafe(pos,next,k);
    }
    static int safePos(int n, int k) {
        // code here
        ArrayList<Integer> pos = new  ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            pos.add(i);
        }
        return findSafe(pos,0,k-1);
        
    }
};
