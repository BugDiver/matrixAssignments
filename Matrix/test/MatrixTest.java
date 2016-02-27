import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest{
	public void fillMatrixWithSampleValues(Matrix matrix){
		matrix.addElement(1,0,0);
		matrix.addElement(2,0,1);
		matrix.addElement(3,0,2);
		matrix.addElement(4,1,0);
		matrix.addElement(5,1,1);
		matrix.addElement(6,1,2);
		matrix.addElement(7,2,0);
		matrix.addElement(8,2,1);
		matrix.addElement(9,2,2);
	}
	@Test
	public void testInitializeForIntegerTypeMatrix(){
		Matrix<Integer> matrix1 = new Matrix<>(3,3);
		assertTrue(matrix1.isNullMatrix());
	}
	@Test
	public void testInitializeForFloatTypeMatrix(){
		Matrix<Integer> matrix1 = new Matrix<>(3,3);
		assertTrue(matrix1.isNullMatrix());
	}
	@Test
	public void testPopulateMatrix(){
		Matrix<Integer> matrix1 = new Matrix<>(3,3);
		matrix1.addElement(1,0,0);
		matrix1.addElement(3,0,2);
		matrix1.addElement(7,2,0);
		matrix1.addElement(9,2,2);

		String expected = "1 null 3 \n"+
						  "null null null \n"+
						  "7 null 9";
		assertEquals(expected ,matrix1.toString());

	}

	@Test
	public void testPopulateMatrixForFloatType(){
		Matrix<Float> matrix1 = new Matrix<>(3,3);
		matrix1.addElement(1.2,0,0);
		matrix1.addElement(3.4,0,2);
		matrix1.addElement(7.5,2,0);
		matrix1.addElement(9.8,2,2);

		String expected = "1.2 null 3.4 \n"+
						  "null null null \n"+
						  "7.5 null 9.8";
		assertEquals(expected ,matrix1.toString());

	}
	@Test
	public void testEqualityOfMatrices() {
		Matrix<Integer> matrix1 =new  Matrix<>(3,3);
		Matrix<Float> matrix2 =new Matrix<>(3,3);

		fillMatrixWithSampleValues(matrix1);
		fillMatrixWithSampleValues(matrix2);

		assertTrue(matrix1.isEqualsTo(matrix2));
	}

	@Test
	public void test_isEquals_should_return_false_row_and_col_are_unequal() {
		Matrix<Integer> matrix1 =new  Matrix<>(3,2);
		Integer[] row1 = {1,2};
		Integer[] row2 = {2,4};
		Integer[] row3 = {4,6};


		matrix1.populateByRow(0,row1);
		matrix1.populateByRow(1,row2);
		matrix1.populateByRow(2,row3);

		Matrix<Integer> matrix2 =new Matrix<>(1,3);
		Integer[] sampleRow1 = {2,3,4};
		matrix2.populateByRow(0,sampleRow1);

		assertFalse(matrix1.isEqualsTo(matrix2));
		assertFalse(matrix2.isEqualsTo(matrix2));
	}

	@Test
	public void testAddTwoMatrices(){

		Matrix<Integer> matrix1 =new Matrix<>(3,3);
		fillMatrixWithSampleValues(matrix1);

		Matrix<Integer> matrix2 = matrix1.multiply(10);

		Matrix addition = matrix2.add(matrix1);

		Matrix<Integer> expected =new Matrix<>(3,3);

		expected.addElement(11,0,0);
		expected.addElement(22,0,1);
		expected.addElement(33,0,2);
		expected.addElement(44,1,0);
		expected.addElement(55,1,1);
		expected.addElement(66,1,2);
		expected.addElement(77,2,0);
		expected.addElement(88,2,1);
		expected.addElement(99,2,2);

		assertTrue(addition.isEqualsTo(expected));

	}
	@Test
	public void testRepresentationOfMatrix(){
		Matrix<Integer> matrix1 =new Matrix<>(3,3);
		fillMatrixWithSampleValues(matrix1);

		String expected  = "1 2 3 \n" +
						   "4 5 6 \n" +
						   "7 8 9";
		assertEquals(expected ,matrix1.toString());
	}


	@Test
	public void testMultiplyTwoMatrices(){

		Matrix<Integer> matrix1 =new  Matrix<>(3,3);
		fillMatrixWithSampleValues(matrix1);

		Matrix<Integer> matrix2 = matrix1.multiply(10);

		Matrix<Integer> product = matrix2.multiply(matrix1);

		Matrix<Integer> expected =new  Matrix<>(3,3);

		expected.addElement(300,0,0);
		expected.addElement(360,0,1);
		expected.addElement(420,0,2);
		expected.addElement(660,1,0);
		expected.addElement(810,1,1);
		expected.addElement(960,1,2);
		expected.addElement(1020,2,0);
		expected.addElement(1260,2,1);
		expected.addElement(1500,2,2);

		assertTrue(product.isEqualsTo(expected));
	}
	@Test
	public void testScalarMultiplication(){

		Matrix<Integer> matrix1 =new  Matrix<>(3,3);
		fillMatrixWithSampleValues(matrix1);

		Matrix<Integer> scaledMatrix = matrix1.multiply(10);

		Matrix<Integer> expected =new  Matrix<>(3,3);

		expected.addElement(10,0,0);
		expected.addElement(20,0,1);
		expected.addElement(30,0,2);
		expected.addElement(40,1,0);
		expected.addElement(50,1,1);
		expected.addElement(60,1,2);
		expected.addElement(70,2,0);
		expected.addElement(80,2,1);
		expected.addElement(90,2,2);

		assertTrue(scaledMatrix.isEqualsTo(expected));
	}
	@Test
	public void testDeterminantOfMatrix(){
		Matrix<Integer> matrix1 =new Matrix<>(3,3);
		fillMatrixWithSampleValues(matrix1);

		int determinant = (int)matrix1.determinant();
		assertEquals(determinant , 0);
	}

	@Test
	public void determinantTest4by4() {
		Matrix<Integer> matrix = new Matrix<>(4,4);
		Integer[] rowFirst = {1,2,3,4};
		Integer[] rowSecond = {2,3,4,5};
		Integer[] rowThird = {2,3,4,7};
		Integer[] rowFourth = {2,3,2,3};

		matrix.populateByRow(0,rowFirst);
		matrix.populateByRow(1,rowSecond);
		matrix.populateByRow(2,rowThird);
		matrix.populateByRow(3, rowFourth);


		int determinant =(int) matrix.determinant();
		assertEquals(-4,determinant);
	}

	@Test
	public void determinantTest5by5() {
		Matrix<Integer> matrix =new Matrix<>(5,5);
		Integer[] rowFirst = {1,2,3,4,3};
		Integer[] rowSecond = {2,3,4,5,4};
		Integer[] rowThird = {2,3,4,7,5};
		Integer[] rowFourth = {2,3,2,3,6};
		Integer[] rowFifth = {1,2,3,0,7};

		matrix.populateByRow(0,rowFirst);
		matrix.populateByRow(1,rowSecond);
		matrix.populateByRow(2,rowThird);
		matrix.populateByRow(3, rowFourth);
		matrix.populateByRow(4,rowFifth);

		int determinant =(int) matrix.determinant();
		assertEquals(-24,determinant);
	}

	@Test
	public void determinantTest10by10() {
		Matrix<Integer> matrix =new Matrix<>(10,10);

		Integer[] rowFirst = {1,2,3,4,3,2,3,4,5,6};
		Integer[] rowSecond = {2,3,4,5,4,1,1,4,6,7};
		Integer[] rowThird = {2,3,4,7,5,0,0,4,5,6};
		Integer[] rowFourth = {2,3,2,3,6,9,6,7,4,2};
		Integer[] rowFifth = {1,2,3,0,7,6,4,3,2,1};
		Integer[] rowSixth = {1,2,3,2,3,4,5,3,4,5 };
		Integer[] rowSeventh = {1,2,3,4,5,6,7,8,9,2};
		Integer[] rowEighth = {2,3,4,2,3,5,6,0,0,1};
		Integer[] rowNinth = {1,1,1,2,3,6,5,4,5,8};
		Integer[] rowTenth = {2,3,4,5,3,1,2,1,3,2};

		matrix.populateByRow(0,rowFirst);
		matrix.populateByRow(1,rowSecond);
		matrix.populateByRow(2,rowThird);
		matrix.populateByRow(3, rowFourth);
		matrix.populateByRow(4,rowFifth);
		matrix.populateByRow(5,rowSixth);
		matrix.populateByRow(6,rowSeventh);
		matrix.populateByRow(7,rowEighth);
		matrix.populateByRow(8,rowNinth);
		matrix.populateByRow(9,rowTenth);

		int determinant = (int)matrix.determinant();
		assertEquals(4464,determinant);
	}
}