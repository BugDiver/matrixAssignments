class Matrix{

	private int row;
	private int col;
	private int[][] data;

	private Matrix(int row ,int col){
		this.row = row;
		this.col =  col;
		this.data = new int[row][col];
	}
	public static Matrix initializeMatrix(int row ,int col){
		return new Matrix(row ,col);
	}
	public boolean isNullMatrix(){
		for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(data[i][j] != 0)
                	return false;
            }
        }
        return true;
	}
	public void addElement(int value ,int rowPosition ,int colPosition){
		data[rowPosition][colPosition] = value;
	}
	public int getElement(int rowPos ,int colPos){
		return data[rowPos][colPos];
	}
    public void populateByRow(int position,int[] rowData){
        for (int i= 0;i<col ;i++ ) {
            data[position][i] = rowData[i];
        }
    }
	public boolean isEqualsTo(Matrix matrix){
		for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(data[i][j] !=  matrix.data[i][j]){
                	return false;
                }
            }
        }
        return true;
	}
	public Matrix add(Matrix other) {
        Matrix result = new Matrix(row, col);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
            	int element = data[i][j] + other.data[i][j];
                result.addElement(element ,i ,j); 
            }
        }
        return result;
    }
    public Matrix multiply(Matrix matrix) {
        Matrix result = new Matrix(this.row, matrix.col);
        for (int i = 0; i < result.row; i++){
            for (int j = 0; j < result.col; j++){
                for (int k = 0; k < col; k++){
                	result.data[i][j] += this.data[i][k] * matrix.data[k][j]; 
                }
            }
        }
        return result;
    }
    public Matrix multiply(int scale) {
        Matrix result = new Matrix(row,col);
        for (int i = 0; i < result.row; i++){
            for (int j = 0; j < result.col; j++){
            	int element = data[i][j] * scale;
            	result.addElement(element ,i ,j); 
            }
        }
        return result;
    }
    private Matrix getSubMatrix(int column, int rank){
    	Matrix subMatrix = initializeMatrix(rank-1 ,rank-1);
    	int subMtrixRow=0 , subMtrixCol=0;
    	for(int i = 1;i < rank; i++){
    		for(int j = 0; j < rank;j++){
    			if(j != column){
    				subMatrix.addElement(data[i][j] , subMtrixRow ,subMtrixCol++);
    				if(subMtrixCol % (rank-1) == 0){
    					subMtrixRow++;
    					subMtrixCol=0;
    				}
    			}
    		}
    	}
    	return subMatrix;
    }
    public int determinant(){
    	int result = 0, sign = 1;
    	if(row==1)
    		return data[0][0];
		for(int i = 0 ; i < row ; i++){
			Matrix subMatrix  = getSubMatrix(i ,row);
			result = result + data[0][i] * subMatrix.determinant() * sign;
			sign = -sign;
		}
    	return result;
    }
}
	
