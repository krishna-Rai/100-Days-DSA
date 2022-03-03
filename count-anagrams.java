class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            if(map.containsKey(p.charAt(i))){
                map.put(p.charAt(i),map.get(p.charAt(i))+1);
            }else{
                map.put(p.charAt(i),1);
            }
        }
        int i=0,j=0,count=map.size();
        List<Integer> ans = new ArrayList<Integer>();
        while(j<s.length()){
            char t = s.charAt(j);
            if(map.containsKey(t)){
                map.put(t,map.get(t)-1);
                if(map.get(t)==0)count--;
            }
            
            if(j-i+1 < p.length())j++;
            else
                if(j-i+1 == p.length()){
                    if(count==0)ans.add(i);
                    char f = s.charAt(i);
                    if(map.containsKey(f)){
                        map.put(f,map.get(f)+1);
                        if(map.get(f)==1)count++;
                    }
                    
                    i++;
                    j++;
                }
        }
        return ans;
    }
}
