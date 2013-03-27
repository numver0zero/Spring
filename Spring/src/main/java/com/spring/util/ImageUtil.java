package com.spring.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @FileName	 : ImageUtil.java
 * @Project      : cla-madame-core
 * @Date         : 2010. 4. 8. 
 * @작성자       : 김성복
 * @변경이력	 : 
 * @프로그램설명 : 이미지 관련 유틸
 */
public class ImageUtil {
	
	public static final int SAME = -1;
	public static final int RATIO = 0;

	/**
	 * @MethodName : getImageHeight
	 * @작성일	   : 2010. 4. 8. 
	 * @작성자	   : 김성복
	 * @변경이력   : 
	 * @Method설명 : 이미지의 Height 값을 구함
	 * @param src
	 * @return int
	 * @throws IOException
	 */
	public static int getImageHeight(File file) {
		
		FileInputStream srcls = null;
		
		try{
			
			BufferedImage srcImg = ImageIO.read(file);
			return srcImg.getHeight();
			
		} catch (IOException e) {
			e.printStackTrace(System.out);
			return 0;
		} finally {
			if(srcls!=null) {
				try{
					srcls.close();
				} catch(IOException ex) {
					ex.printStackTrace(System.out);
				}
			}
		}
	}
	
	/**
	 * @MethodName : getImageWidth
	 * @작성일	   : 2010. 4. 8. 
	 * @작성자	   : 김성복
	 * @변경이력   : 
	 * @Method설명 : 이미지의 Width 값을 구함
	 * @param src
	 * @return int
	 * @throws IOException
	 */
	public static int getImageWidth(File file) {
		
		FileInputStream srcls = null;
		
		try{
			
			BufferedImage srcImg = ImageIO.read(file);
			return srcImg.getWidth();
		
		} catch (IOException e) {
			e.printStackTrace(System.out);
			return 0;
		} finally {
			if(srcls!=null) {
				try{
					srcls.close();
				} catch(IOException ex) {
					ex.printStackTrace(System.out);
				}
			}
		}
	}
	
	/**
	 * @MethodName : resize
	 * @작성일	   : 2010. 5. 22. 
	 * @작성자	   : 김성복
	 * @변경이력   : 
	 * @Method설명 : 썸네일이미지생성
	 * @param src
	 * @param dest
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void resize(File src, File dest, int width, int height) throws IOException {
		
		FileInputStream srcls = null;
		
		try{
			srcls = new FileInputStream(src);
			/* 원본이미지를 File로 전달받은 경우 InputStream 으로 변환하여 resize메소드를 호출한다 */
			ImageUtil.resize(srcls, dest, width, height);
		} finally {
			if(srcls!=null) {
				try{
					srcls.close();
				} catch(IOException ex) {
					ex.printStackTrace(System.out);
				}
			}
		}
	}
	
	/**
	 * @MethodName : resize
	 * @작성일	   : 2010. 5. 22. 
	 * @작성자	   : 김성복
	 * @변경이력   : 
	 * @Method설명 : 썸네일이미지생성
	 * @param src
	 * @param dest
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void resize(InputStream src, File dest, int width, int height) throws IOException {
		
		/* 원본 이미지에 해당하는 BufferedImage 객체를 생성해서 srcImg에 할당한다 */
		BufferedImage srcImg = ImageIO.read(src);
		
		/* 원본 이미지의 폭과 높이를 구한다 */
		int srcWidth = srcImg.getWidth();
		int srcHeight = srcImg.getHeight();
		
		/* 새로 생성할 이미지의 폭과 높이를 구한다 */
		int destWidth = -1;
		int destHeight = -1;
		
		if(width==SAME) {
			destWidth = srcWidth;
		} else if(width > 0) {
			destWidth = width;
		}
		
		if(height==SAME) {
			destHeight = srcHeight;
		} else if(height > 0) {
			destHeight = height;
		}
		
		if(width==RATIO && height==RATIO) {
			destWidth = srcWidth;
			destHeight = srcHeight;
		} else if(width==RATIO) {
			double ratio = ((double)destHeight) / ((double)srcHeight);
			destWidth = (int)((double)srcWidth * ratio);
		} else if(height==RATIO) {
			double ratio = ((double)destWidth) / ((double)srcWidth);
			destHeight =(int)((double)srcHeight * ratio);
		}
		
		/* 새로 생성할 이미지에 해당하는 BufferedImage 객체를 생성해서 destImg에 할당한다 */
		BufferedImage destImg = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_3BYTE_BGR);
		
		/* destImg에 그림을 그릴 수 있는 Grahpics2D 객체를 구한다 */
		Graphics2D g = destImg.createGraphics();
		/* Grahpics2D를 사용해서 srcImg를 destImg에 그린다 */
		g.drawImage(srcImg, 0, 0, destWidth, destHeight, null);
		
		/* 새로 생성한 이미지인 destImg를 지정한 파일에 저장한다 */
		ImageIO.write(destImg, "jpg", dest);
	}
}
