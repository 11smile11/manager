package com.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VideoUtils{
	
	/**
    *
    * @param filePath 视频路径
    * @param targerFilePath 第一帧图片存储位置
    * @param targetFileName 图片名称
    * @throws Exception
    */
   public static void randomGrabberFFmpegImage(String filePath, String targerFilePath, String targetFileName)
           throws Exception {

       FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
       ff.start();
       Frame f;
       int i = 0;
       while (i <1) {
           f =ff.grabImage();
           doExecuteFrame(f,targerFilePath,targetFileName);
           i++;
       }
       ff.stop();

   }
   public static void doExecuteFrame(Frame f, String targerFilePath, String targetFileName) {

       if (null ==f ||null ==f.image) {
           return;
       }
       Java2DFrameConverter converter =new Java2DFrameConverter();
       String imageMat ="jpg";
       String FileName =targerFilePath + File.separator +targetFileName +"." +imageMat;
       BufferedImage bi =converter.getBufferedImage(f);
       System.out.println("width:" + bi.getWidth());
       System.out.println("height:" + bi.getHeight());
       File output =new File(FileName);
       try {
           ImageIO.write(bi,imageMat,output);
       }catch (IOException e) {
           e.printStackTrace();
       }
   }
	
}


