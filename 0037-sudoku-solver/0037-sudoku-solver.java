class Solution {

    public boolean findEmptyCell(char[][] board,int[] emptyCell ){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    emptyCell[0]=i;
                    emptyCell[1]=j;
                    return true;
                }
            }
        }return false;
    }

    public boolean solveSudokuHelper(char[][] board) {
        int[] emptyCell=new int[2];
        if(!findEmptyCell(board,emptyCell)){
            return true;
        }

        int rowIndex=emptyCell[0];
        int colIndex=emptyCell[1];

        for(int value=1;value<=9;value++){
            char charValue=(char)(value +'0');
            if(isSafeToPlace(board,charValue,rowIndex,colIndex)){
                board[rowIndex][colIndex]=charValue;
                if(solveSudokuHelper(board)==true){
                    return true;
                }
                board[rowIndex][colIndex]='.';
            }
        }return false;
        
    }
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    

    public boolean isSafeToPlace(char[][] board,char charValue,int rowIndex,int colIndex){
        // row
        for(int i=0;i<board.length;i++){
            if(board[rowIndex][i]==charValue){
                return false;
            }
        }
        //col
        for(int i=0;i<board.length;i++){
            if(board[i][colIndex]==charValue){
                return false;
            }
        }
        //box
        int startRow=rowIndex-rowIndex%3;
        int startCol=colIndex-colIndex%3;

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == charValue) {
                    return false;
                }
            }
        }

        return true;
    }
}