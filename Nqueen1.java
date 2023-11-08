public class Nqueen1{
    static int n=4;

    static boolean isSafe(int [][]board,int row,int col){
        for(int i=0;i<col;i++){
            if(board[row][i]==1) return false;
        }
        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]==1) return false;
        }
        for(int i=row,j=col;i<n && j>=0;i++,j--){
            if(board[i][j]==1) return false;
        }
        return true;
    }
    static boolean solveNqueen(int [][]board,int col){
        if(col>=n) return true;

        for(int i=0;i<n;i++){
            if(isSafe(board,i,col)){
                board[i][col]=1;
                if(solveNqueen(board, col+1)) return true;
                board[i][col]=0;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int board[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        solveNqueen(board,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}