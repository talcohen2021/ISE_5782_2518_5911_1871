package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import primitives.Color;
import renderer.ImageWriter;

/**
 * @author Yaakovah
 *
 */
public class ImageWriterTest {

	/**
	 * Test method for {@link renderer.ImageWriter#writeToImage()}.
	 */
	@Test
	public void testWriteToImage() {
		/*
		 * ImageWriterTest that will build your first (initial)  image  – an image made up of one color 
		 * for the background and a second color for the grid. In this test you will build a grid 
		 * of 10x16 squares on a screen (ViewPlane) with a resolution of 500 x 800. 
		 * You may choose whichever colors you wish for the background and grid colors.
		 * */
		
		 int nX = 800;
		 int nY = 500;
		 
		 ImageWriter imageWriter = new ImageWriter("ImageWriterTest", nX, nY);
		 
		 for (int row = 0; row < nY; row++) 
		 	for (int col = 0; col < nX; col++) 
		 		if (col % 50 == 0 || row % 50 == 0) 
				 	imageWriter.writePixel(col, row, new Color(java.awt.Color.BLACK));
				 else 
				 	imageWriter.writePixel(col, row, new Color(java.awt.Color.GREEN));	
		      	
		   
		 imageWriter.writeToImage();
			  
		
		
		
	}

	
}

