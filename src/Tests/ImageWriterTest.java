package Tests;

import org.junit.Test;

import Renderer.ImageWriter;
import java.awt.Color;

public class ImageWriterTest
{

    @Test
    public void test1()
    {
        ImageWriter w=new ImageWriter("picture",500,500,1,1);
        for(int i=0;i<500;i++)
        {

            for(int j=0;j<500;j++)
            {
                if(i%100==0||j%100==0)
                {
                    w.writePixel(i,j,255,255,255);
                }
            }
        }
        w.writeToimage();
    }
    @Test
    public void test2()
    {
        //image number one
        ImageWriter image=new ImageWriter("image1",500,500,5,5);
        // this is the frame of the image
        for (int j=0;j<500;j++)
        {
            for (int i=0;i<10;i++)
            {
                image.writePixel(i, j, Color.pink);
            }
        }
        for (int j=0;j<500;j++)
        {
            for (int i=0;i<10;i++)
            {
                image.writePixel(j, i, Color.pink);
            }
        }
        for (int j=0;j<500;j++)
        {
            for (int i=490;i<500;i++)
            {

                image.writePixel(i, j, Color.pink);
            }
        }
        for (int j=0;j<500;j++)
        {
            for (int i=490;i<500;i++)
            {

                image.writePixel(j, i, Color.pink);
            }
        }
        // this is the higher part of the left part of the X
        for(int i=100;i<400;i++)
        {
            image.writePixel(i, i, Color.red);

        }
        // this is the lower part of the left part of the X
        for(int i=399;i>100;i--)
        {
            image.writePixel(i, 500-i, Color.red);

        }
        image.writeToimage();

        //image number 2
        ImageWriter image2=new ImageWriter("image2",500,500,5,5);
        //the left and down
        for(int i=25;i<225;i++)
        {
            for(int j=275;j<475;j++)
                image2.writePixel(i, j, 45,27,119);
        }
        //the the right and up
        for(int i=275;i<475;i++)
        {
            for(int j=25;j<225;j++)
                image2.writePixel(i, j, 70,30,100);
        }
        //the left and up
        for(int i=25;i<225;i++)
        {
            for(int j=25;j<225;j++)
                image2.writePixel(i, j, 50,25,20);
        }
        //the right and down
        for(int i=275;i<475;i++)
        {
            for(int j=275;j<475;j++)
                image2.writePixel(i, j, 127,96,50);
        }
        image2.writeToimage();

        //image number 3
        ImageWriter image3=new ImageWriter("image3",500,500,5,5);
        int[] arr= {127,127,127};
        //the left side of the triangle
        for(int i=50;i<250;i++)
        {
            image3.writePixel(i, 500-i, arr);
        }
        //the right side of the triangle
        for(int i=249;i<450;i++)
        {
            image3.writePixel(i, i, arr);
        }
        //the straight line of the triangle
        for(int i=50;i<450;i++)
        {
            image3.writePixel(i, 450, arr);
        }
        image3.writeToimage();

        //image number 2
        ImageWriter image4=new ImageWriter("image4",250,250,5,5);
        for (int i=25;i<image4.getWidth();i+=25)
        {
            for (int j=0;j<image4.getHeight();j++)
            {
                image4.writePixel(i,j, 127,127,127);
            }
        }
        for (int i=25;i<image4.getHeight();i+=25)
        {
            for (int j=0;j<image4.getWidth();j++)
            {
                image4.writePixel(j,i, 127,127,127);
            }
        }
        image4.writeToimage();
    }


}







