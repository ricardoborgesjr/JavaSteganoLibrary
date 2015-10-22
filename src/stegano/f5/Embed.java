/**
*    Java Stegano Library
*    Copyright (C) 2014-2015  Ricardo Borges Jr.
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/

package stegano.f5;

import stegano.james.JpegEncoder;
import stegano.image.Bmp;
import java.awt.*;
import java.io.*;

/**
 *
 * @author Ricardo Borges Jr.
 * Based on the implementation of Andreas Westfeld 
 */


public class Embed
{

    private File image;
    private File file;
    private File stegImage;
    private String password;
    private int quality = 70;
    private String comment = "JPEG Encoder Copyright 1998, James R. Weeks and BioElectroMech.  ";

    public void setImage(File image)
    {
        this.image = image;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public void setStegImage(File stegImage)
    {
        this.stegImage = stegImage;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setQuality(int quality)
    {
        this.quality = quality;
    }

    public void setComment()
    {
        this.comment = comment;
    }

    public File getImage()
    {
        return this.image;
    }

    public File getFile()
    {
        return this.file;
    }

    public File getStegImage()
    {
        return this.stegImage;
    }

    public String getPassword()
    {
        return this.password;
    }
    public int getQuality()
    {
        return this.quality;
    }

    public String getComment()
    {
        return this.comment;
    }

    public void embed()
    {
        Image image;
        FileOutputStream dataOut = null;
        JpegEncoder jpg;
        int i;
        
        String inFileName = this.image.toString();
        String outFileName = this.stegImage.toString();
        String embFileName = this.file.toString();
        if (this.image.exists())
        {
            try 
            {
                dataOut = new FileOutputStream(this.stegImage);
            }
            catch(FileNotFoundException e) {}

            if (inFileName.endsWith(".bmp")) {
                Bmp bmp = new Bmp(inFileName);
                image = bmp.getImage();
            } else
                image = Toolkit.getDefaultToolkit().getImage(inFileName);
            
            jpg = new JpegEncoder(image, quality, dataOut, comment);
            if (false)
                jpg.Compress();
            else 
            {
                try
                {
                    if (embFileName==null)
                        jpg.Compress();
                    else
                        jpg.Compress(new FileInputStream(embFileName), password);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            try 
            {
                dataOut.close();
            }
            catch(IOException e) {}
        }
        else
        {
            System.out.println("I couldn't find " + inFileName + ". Is it in another directory?");
        }
    }
}