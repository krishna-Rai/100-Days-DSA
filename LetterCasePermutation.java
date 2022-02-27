class Solution {
    public List<String> permute(String s,int start,int end,String op,List<String> ans){
        if(start>end){
            ans.add(op);
            return ans;
        }
        if(Character.isDigit(s.charAt(start))){
            permute(s,start+1,end,op+s.charAt(start),ans);
        }else{
            permute(s,start+1,end,op+Character.toLowerCase(s.charAt(start)),ans);
            permute(s,start+1,end,op+Character.toUpperCase(s.charAt(start)),ans);
        }
        return ans;
    }
    public List<String> letterCasePermutation(String s) {
        return permute(s,0,s.length()-1,"",new ArrayList<String>());
    }
}
