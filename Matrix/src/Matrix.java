class Matrix<T extends Number> {
    private int row;
    private int col;
    private Number[][] data;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.data = new Number[row][col];
    }

    public boolean isNullMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (data[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addElement(Number value, int rowPosition, int colPosition) {
        data[rowPosition][colPosition] = value;
    }

    public void populateByRow(int position, T[] rowData) {
        System.arraycopy(rowData, 0, data[position], 0, col);
    }

    public boolean isEqualsTo(Matrix<T> matrix) {
        if (isUnequalRowColumn(matrix))
            return false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!data[i][j].equals(matrix.data[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isUnequalRowColumn(Matrix<T> matrix) {
        return (this.row != matrix.row || this.col != matrix.row);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Object[] aData : data) {
            for (Object anAData : aData) {
                sb.append(anAData).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    private void initializeWithZero(Matrix<T> matrix) {
        for (int i = 0; i < matrix.data.length; i++) {
            for (int j = 0; j < matrix.data[i].length; j++) {
                matrix.data[i][j] = 0;
            }
        }
    }

    private Number addNumbers(Number one, Number another) {
        if (one instanceof Integer) {
            return one.intValue() + another.intValue();
        } else if (one instanceof Float) {
            return one.floatValue() + another.floatValue();
        } else if (one instanceof Long) {
            return one.longValue() + another.longValue();
        } else if (one instanceof Double) {
            return one.doubleValue() + another.doubleValue();
        }
        return null;
    }

    private Number multiplyNumbers(Number one, Number another) {
        if (one instanceof Integer) {
            return one.intValue() * another.intValue();
        } else if (one instanceof Float) {
            return one.floatValue() * another.floatValue();
        } else if (one instanceof Long) {
            return one.longValue() * another.longValue();
        } else if (one instanceof Double) {
            return one.doubleValue() * another.doubleValue();
        }
        return null;
    }

    private Number changeSign(Number one) {
        if (one instanceof Integer) {
            return -one.intValue();
        } else if (one instanceof Float) {
            return -one.floatValue();
        } else if (one instanceof Long) {
            return -one.longValue();
        } else if (one instanceof Double) {
            return -one.doubleValue();
        }
        return null;
    }

    public Matrix<T> add(Matrix<T> other) {
        if (isUnequalRowColumn(other))
            throw new RuntimeException("unequal row or col length");
        Matrix<T> result = new Matrix<>(row, col);
        initializeWithZero(result);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Number element = addNumbers(this.data[i][j], other.data[i][j]);
                result.addElement(element, i, j);
            }
        }
        return result;
    }

    public Matrix<T> multiply(Matrix<T> matrix) {
        if(!canMultiply(matrix))
            throw new RuntimeException("inoperable row and column length");
        Matrix<T> result = new Matrix<>(this.row, matrix.col);
        initializeWithZero(result);
        for (int i = 0; i < result.row; i++) {
            for (int j = 0; j < result.col; j++) {
                for (int k = 0; k < col; k++) {
                    Number product = multiplyNumbers(this.data[i][k], matrix.data[k][j]);
                    result.data[i][j] = addNumbers(result.data[i][j], product);
                }
            }
        }
        return result;
    }

    private boolean canMultiply(Matrix<T> matrix) {
        return this.col == matrix.row;
    }

    public Matrix<T> multiply(Number scale) {
        Matrix<T> result = new Matrix<>(row, col);
        for (int i = 0; i < result.row; i++) {
            for (int j = 0; j < result.col; j++) {
                Number element = multiplyNumbers(data[i][j], scale);
                result.addElement(element, i, j);
            }
        }
        return result;
    }

    private Matrix<T> getSubMatrix(int column, int rank) {
        Matrix<T> subMatrix = new Matrix<>(rank - 1, rank - 1);
        int subMatrixRow = 0, subMatrixCol = 0;
        for (int i = 1; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                if (j != column) {
                    subMatrix.addElement(data[i][j], subMatrixRow, subMatrixCol++);
                    if (subMatrixCol % (rank - 1) == 0) {
                        subMatrixRow++;
                        subMatrixCol = 0;
                    }
                }
            }
        }
        return subMatrix;
    }

    public Number determinant() {
        Number result = 0;
        Number sign = 1;
        if (!isSquareMatrix())
            throw new RuntimeException("can't compute determinant of a non-square matrix");
        if (row == 1)
            return data[0][0];
        for (int i = 0; i < row; i++) {
            Matrix subMatrix = getSubMatrix(i, row);
            Number product = multiplyNumbers(data[0][i], subMatrix.determinant());
            result = addNumbers(result, multiplyNumbers(product, sign));
            sign = changeSign(sign);
        }
        return result;
    }

    public boolean isSquareMatrix() {
        return (this.row == this.col);
    }
}

