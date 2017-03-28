/**
 * @som_webster
 **/


import java.io.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

class Compresssion {

   public static void main(String[] args) throws IOException {

      File in= new File("image-name.jpg"); //input (original) image file
      BufferedImage image = ImageIO.read(in);

      File compressedImage = new File("compressed.jpg");//output (compressed) image file
      OutputStream out =new FileOutputStream(compressedImage);

      Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");//PNG doesnt work here
      ImageWriter writer = (ImageWriter) writers.next();

      ImageOutputStream imageOs = ImageIO.createImageOutputStream(out);
      writer.setOutput(imageOs);

      ImageWriteParam param = writer.getDefaultWriteParam();//describes how stream is to be encoded

      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      param.setCompressionQuality(0.5f);//float value (0-1), 0-highest compression & 1-highest image quality
      writer.write(null, new IIOImage(image, null, null), param);//

      os.close();
      ios.close();
      writer.dispose();
   }
}
