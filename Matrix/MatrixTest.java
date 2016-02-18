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
	public void fillMatrixWithAnotherSampleValues(Matrix matrix){
		matrix.addElement(10,0,0);
		matrix.addElement(20,0,1);
		matrix.addElement(30,0,2);
		matrix.addElement(40,1,0);
		matrix.addElement(50,1,1);
		matrix.addElement(60,1,2);
		matrix.addElement(70,2,0);
		matrix.addElement(80,2,1);
		matrix.addElement(90,2,2);
	}
	@Test
	public void testCreateMatrix(){
		Matrix matrix1 = Matrix.createMatrix(3,3);

		assertEquals(matrix1.getElement(0,0) ,0);
		assertEquals(matrix1.getElement(0,1) ,0);
		assertEquals(matrix1.getElement(0,2) ,0);
		assertEquals(matrix1.getElement(1,0) ,0);
		assertEquals(matrix1.getElement(1,1) ,0);
		assertEquals(matrix1.getElement(1,2) ,0);
		assertEquals(matrix1.getElement(2,0) ,0);
		assertEquals(matrix1.getElement(2,1) ,0);
		assertEquals(matrix1.getElement(2,2) ,0);
	}
	@Test
	public void testPopulateMatrix(){
		Matrix matrix1 = Matrix.createMatrix(3,3);
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
		Matrix matrix1 = Matrix.createMatrix(3,3);
		Matrix matrix2 = Matrix.createMatrix(3,3);

		fillMatrixWithSampleValues(matrix1);
		fillMatrixWithSampleValues(matrix2);

		assertTrue(matrix1.isEqualsWith(matrix2));
	}
	@Test
	public void testAddTwoMatrices(){

		Matrix matrix1 = Matrix.createMatrix(3,3);
		fillMatrixWithSampleValues(matrix1);

		Matrix matrix2 = Matrix.createMatrix(3,3);
		fillMatrixWithAnotherSampleValues(matrix2);

		//add two matrices
		Matrix addition = matrix2.add(matrix1);

		Matrix excepted = Matrix.createMatrix(3,3);

		excepted.addElement(11,0,0);
		excepted.addElement(22,0,1);
		excepted.addElement(33,0,2);
		excepted.addElement(44,1,0);
		excepted.addElement(55,1,1);
		excepted.addElement(66,1,2);
		excepted.addElement(77,2,0);
		excepted.addElement(88,2,1);
		excepted.addElement(99,2,2);

		assertTrue(addition.isEqualsWith(excepted));
		
	}
}