/* 
				* This is a test program which 
				* 	loads the image file "imageA.jpg" using opencv,
				* 	and displays to window using BufferedImage.
				* by H.Ogawa on 24 Dec 2019
				*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class DisplayTest extends JFrame {
	BufferedImage bimage;
	Mat src;
	String filename = "imageA.jpg";

	public DisplayTest() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		setTitle("OpenCV2");
		setSize(660, 520);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		takeImage();
	}

	public void paint(Graphics g) {
		if (bimage != null) {
			g.drawImage(bimage, 10, 30, this);
		}
	}

	public void takeImage() {
		src = new Mat();
		src = Imgcodecs.imread(filename);
		bimage = matToBufferedImage(src);
		System.out.println("width = " + bimage.getWidth() + " height = " + bimage.getHeight());
		repaint();
	}

	public static void main(String[] args) {
		new DisplayTest();
	}

	public static BufferedImage matToBufferedImage(Mat matrix) {
		int cols = matrix.cols();
		int rows = matrix.rows();
		int elemSize = (int) matrix.elemSize();
		byte[] data = new byte[cols * rows * elemSize];
		int type;

		matrix.get(0, 0, data);

		switch (matrix.channels()) {
		case 1:
			type = BufferedImage.TYPE_BYTE_GRAY;
			break;
		case 3:
			type = BufferedImage.TYPE_3BYTE_BGR;
			byte b;
			for (int i = 0; i < data.length; i = i + 3) {
				b = data[i];
				data[i] = data[i + 2];
				data[i + 2] = b;
			}
			break;
		default:
			return null;
		}
		BufferedImage image2 = new BufferedImage(cols, rows, type);
		image2.getRaster().setDataElements(0, 0, cols, rows, data);
		return image2;
	}
}