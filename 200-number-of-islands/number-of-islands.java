class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int numisland=0;
        int row=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    numisland++;
                    dfs(grid,i,j);
                }
            }
        }
        return numisland;
    }
    private void dfs(char[][]grid ,int i, int j){
        int row = grid.length;
        int cols = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j]='0';
        dfs(grid, i - 1, j); 
        dfs(grid, i + 1, j); 
        dfs(grid, i, j - 1); 
        dfs(grid, i, j + 1);
    }
}