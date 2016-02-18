class Matrix{

	public int row;
	public int col;
	private int[][] data;

	private Matrix(int row ,int col){
		this.row = row;
		this.col =  col;
		this.data = new int[row][col];
	}
	public static Matrix createMatrix(int row ,int col){
		return new Matrix(row ,col);
	}
	public void addElement(int value ,int rowPosition ,int colPosition){
		this.data[rowPosition][colPosition] = value;
	}
	public int getElement(int rowPos ,int colPos){
		return this.data[rowPos][colPos];
	}
	public Matrix add(Matrix other) {
        Matrix result = new Matrix(this.row, this.col);
        for (int i = 0; i < this.row; i++){
            for (int j = 0; j < this.col; j++){
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }
}
	
