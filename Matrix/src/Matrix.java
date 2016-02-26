
class Matrix<T extends Number>{
	private int row;
	private int col;
	private Number[][] data;

	public Matrix(int row ,int col){
		this.row = row;
		this.col =  col;
        this.data = new Number[row][col];
    }
	public boolean isNullMatrix(){
		for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(data[i][j] != null){
                    return false;
                }
            }
        }
        return true;
	}
	public void addElement(Number value , int rowPosition , int colPosition){
        data[rowPosition][colPosition] = value;
	}
//
//	public Number getElement(int rowPos , int colPos){
//		return data[rowPos][colPos];
//	}
//    public void populateByRow(int position,int[] rowData){
//        System.arraycopy(rowData, 0, data[position], 0, col);
//    }
	public boolean isEqualsTo(Matrix matrix){
		for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(!data[i][j].equals(matrix.data[i][j])){
                	return false;
                }
            }
        }
        return true;
	}
    public String toString (){
        StringBuilder sb = new StringBuilder("");
        for (Object[] aData : data) {
            for (Object anAData : aData) {
                sb.append(anAData).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
//    private Number addNumbers(Number one, Number another) {
//        if(one instanceof Integer){
//            return new Integer(one.intValue() + another.intValue());
//        }else if (one instanceof Float){
//            return new Float(one.floatValue() + another.floatValue());
//        }else if (one instanceof Long){
//            return new Long(one.longValue() + another.longValue());
//        }else if (one instanceof Double){
//            return new Double(one.doubleValue()+ another.doubleValue());
//
//        }
//        return null;
//    }
//	public Matrix<T> add(Matrix<T> other) {
//        Matrix result = new Matrix(row, col);
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//
//                Number element = addNumbers(this.data[i][j],other.data[i][j]);
//                result.addElement(element, i, j);
//            }
//        }
//        return result;
//    }
//
//    public Matrix multiply(Matrix matrix) {
//        Matrix result = new Matrix(this.row, matrix.col);
//        for (int i = 0; i < result.row; i++){
//            for (int j = 0; j < result.col; j++){
//                for (int k = 0; k < col; k++){
//                	result.data[i][j] += this.data[i][k] * matrix.data[k][j];
//                }
//            }
//        }
//        return result;
//    }
//
//    public Matrix multiply(int scale) {
//        Matrix result = new Matrix(row,col);
//        for (int i = 0; i < result.row; i++){
//            for (int j = 0; j < result.col; j++){
//            	int element = data[i][j] * scale;
//            	result.addElement(element ,i ,j);
//            }
//        }
//        return result;
//    }
//    private Matrix getSubMatrix(int column, int rank){
//    	Matrix subMatrix = initializeMatrix(rank-1 ,rank-1);
//    	int subMatrixRow=0 , subMatrixCol=0;
//    	for(int i = 1;i < rank; i++){
//    		for(int j = 0; j < rank;j++){
//    			if(j != column){
//    				subMatrix.addElement(data[i][j] , subMatrixRow ,subMatrixCol++);
//    				if(subMatrixCol % (rank-1) == 0){
//    					subMatrixRow++;
//    					subMatrixCol=0;
//    				}
//    			}
//    		}
//    	}
//    	return subMatrix;
//    }
//    public Integer determinant(){
//    	int result = 0, sign = 1;
//    	if(row==1)
//    		return data[0][0];
//		for(int i = 0 ; i < row ; i++){
//			Matrix subMatrix  = getSubMatrix(i ,row);
//            result = result + data[0][i] * subMatrix.determinant() * sign;
//			sign = -sign;
//		}
//    	return result;
//    }
}
	
