import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;
import java.util.*;

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
	public void testinitializeMatrix(){
		Matrix matrix1 = Matrix.initializeMatrix(3,3);
		assertTrue(matrix1.isNullMatrix());
	}
	@Test
	public void testPopulateMatrix(){
		Matrix matrix1 = Matrix.initializeMatrix(3,3);
		//siganture addElement(value ,rowPosition ,columnPosition);
		matrix1.addElement(1,0,0);
		matrix1.addElement(3,0,2);
		matrix1.addElement(7,2,0);
		matrix1.addElement(9,2,2);

		assertEquals(matrix1.getElement(0,0) ,1);	
		assertEquals(matrix1.getElement(0,2) ,3);	
		assertEquals(matrix1.getElement(2,0) ,7);	
		assertEquals(matrix1.getElement(2,2) ,9);

		assertEquals(matrix1.getElement(1,1) ,0);	
		assertEquals(matrix1.getElement(1,2) ,0);	
		assertEquals(matrix1.getElement(1,0) ,0);	
		assertEquals(matrix1.getElement(2,1) ,0);			
	}
	@Test
	public void testEqualityOfMatrices() {
		Matrix matrix1 = Matrix.initializeMatrix(3,3);
		Matrix matrix2 = Matrix.initializeMatrix(3,3);

		fillMatrixWithSampleValues(matrix1);
		fillMatrixWithSampleValues(matrix2);

		assertTrue(matrix1.isEqualsTo(matrix2));
	}
	@Test
	public void testAddTwoMatrices(){

		Matrix matrix1 = Matrix.initializeMatrix(3,3);
		fillMatrixWithSampleValues(matrix1);

		Matrix matrix2 = matrix1.multiply(10);

		//add two matrices
		Matrix addition = matrix2.add(matrix1);

		Matrix expected = Matrix.initializeMatrix(3,3);

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
	public void testMultiplyTwoMatrices(){

		Matrix matrix1 = Matrix.initializeMatrix(3,3);
		fillMatrixWithSampleValues(matrix1);

		Matrix matrix2 = matrix1.multiply(10);

		//multiply two matrices
		Matrix product = matrix2.multiply(matrix1);

		Matrix expected = Matrix.initializeMatrix(3,3);

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
	public void testScalerMultiplication(){

		Matrix matrix1 = Matrix.initializeMatrix(3,3);
		fillMatrixWithSampleValues(matrix1);

		Matrix scaledMatrix = matrix1.multiply(10);

		Matrix expected = Matrix.initializeMatrix(3,3);

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
		Matrix matrix1 = Matrix.initializeMatrix(3,3);
		fillMatrixWithSampleValues(matrix1);

		int determinant = matrix1.determinant();
		assertEquals(determinant , 0);
	}
}