/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stegano.f5;

import stegano.james.JpegEncoder;
import stegano.image.Bmp;
import java.awt.*;
import java.io.*;

/**
 *
 * @author ricardo
 */


public class Embed
{
    public static void embed(File file, File embFile, File outFile, String password, int quality) {
	Image image;
	FileOutputStream dataOut = null;
	//File file, outFile;
	JpegEncoder jpg;
	int i;
        // Check to see if the input file name has one of the extensions:
        //     .tif, .gif, .jpg
        // If not, print the standard use info.
	String comment="JPEG Encoder Copyright 1998, James R. Weeks and BioElectroMech.  ";
	//String password="abc123";
        String inFileName = file.toString();
        String outFileName = outFile.toString();
	String embFileName = embFile.toString();
	if (file.exists()) {
	    try {
		dataOut = new FileOutputStream(outFile);
	    } catch(FileNotFoundException e) {}
	    if (inFileName.endsWith(".bmp")) {
		Bmp bmp = new Bmp(inFileName);
		image = bmp.getImage();
	    } else
		image = Toolkit.getDefaultToolkit().getImage(inFileName);
	    jpg = new JpegEncoder(image, quality, dataOut, comment);
	    if (false)
		jpg.Compress();
	    else {
		try {
		    if (embFileName==null)
			jpg.Compress();
		    else
			jpg.Compress(new FileInputStream(embFileName), password);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	    try {
		dataOut.close();
	    } catch(IOException e) {}
	}
	else {
	    System.out.println("I couldn't find " + inFileName + ". Is it in another directory?");
	}
    }
}

