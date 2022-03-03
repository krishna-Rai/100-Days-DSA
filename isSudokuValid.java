class Solution {
    public boolean checkRow(int i,char board[][]){
        HashSet<Character> set = new HashSet<>();
        
        for(int j=0;j<9;j++){
            if(board[i][j]=='.')continue;
            int val = board[i][j]-'0';
            if(val<0 || val >9)return false;
            if(set.contains(board[i][j]))return false;
            else
                set.add(board[i][j]);
        }
        return true;
    }
    public boolean checkCol(int i,char board[][]){
        HashSet<Character> set = new HashSet<>();
        
        for(int j=0;j<9;j++){
            if(board[j][i]=='.')continue;
            int val = board[j][i]-'0';
            if(val<0 || val >9)return false;
            if(set.contains(board[j][i]))return false;
            else
                set.add(board[j][i]);
                
        }
        return true;
    }
    public boolean isValidSq(char board[][]){
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashSet<Character> set = new HashSet<>();
                for(int r=i;r<i+3;r++){
                    for(int c=j;c<j+3;c++){
                        if(board[r][c]=='.')continue;
                        int val = board[r][c]-'0';
                        if(val<0 || val >9)return false;
                        if(set.contains(board[r][c]))return false;
                        else
                            set.add(board[r][c]);
                            
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean ans = true;
        for(int i=0;i<9;i++){
            ans = checkRow(i,board);
            if(!ans)return ans;
            ans = checkCol(i,board);
            if(!ans)return ans;  
        }
        return isValidSq(board);
    }
}
