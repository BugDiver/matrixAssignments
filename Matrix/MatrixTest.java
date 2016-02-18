import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;
import java.util.*;

public class MatrixTest{
	public Matrix matrix;
	@Before
	public void setUp(){
		matrix = Matrix.createMatrix(3,3);
	}

	@Test
	public void createMatrix(){
		assertEquals(matrix.row,3);
		assertEquals(matrix.col,3);
	}
	@Test
	public void populateMatrix(){
		//siganture addElement(value ,rowPosition ,columnPosition);
		matrix.addElement(1,0,0);
		matrix.addElement(2,0,1);
		matrix.addElement(3,0,2);
		matrix.addElement(4,1,0);
		matrix.addElement(5,1,1);
		matrix.addElement(6,1,2);
		matrix.addElement(7,2,0);
		matrix.addElement(8,2,1);
		matrix.addElement(9,2,2);

		assertEquals(matrix.getElement(0,0) ,1);	
	}
	@Test
	public void addTwoMatrices(){
		// populate 1st matrix
		matrix.addElement(1,0,0);
		matrix.addElement(2,0,1);
		matrix.addElement(3,0,2);
		matrix.addElement(4,1,0);
		matrix.addElement(5,1,1);
		matrix.addElement(6,1,2);
		matrix.addElement(7,2,0);
		matrix.addElement(8,2,1);
		matrix.addElement(9,2,2);

		// anther matrix
		Matrix newMatrix  = Matrix.createMatrix(3,3);
		newMatrix.addElement(10,0,0);
		newMatrix.addElement(20,0,1);
		newMatrix.addElement(30,0,2);
		newMatrix.addElement(40,1,0);
		newMatrix.addElement(50,1,1);
		newMatrix.addElement(60,1,2);
		newMatrix.addElement(70,2,0);
		newMatrix.addElement(80,2,1);
		newMatrix.addElement(90,2,2);

		//adding both matrices

		Matrix addition = newMatrix.add(matrix);
		assertEquals(addition.row ,3);
		assertEquals(addition.col ,3);

		assertEquals(addition.getElement(0,0) ,11);
		assertEquals(addition.getElement(0,1) ,22);
		assertEquals(addition.getElement(0,2) ,33);
		assertEquals(addition.getElement(1,0) ,44);
		assertEquals(addition.getElement(1,1) ,55);
		assertEquals(addition.getElement(1,2) ,66);
		assertEquals(addition.getElement(2,0) ,77);
		assertEquals(addition.getElement(2,1) ,88);
		assertEquals(addition.getElement(2,2) ,99);


	}
}