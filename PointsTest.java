/*
 Elanna Grossman
 Application that uses listens to mouse input to draw points in a window and then determines the two closets points.
 */

import javax.swing.*;

public class PointsTest extends JFrame
{
   private PointsTestPanel panel = new PointsTestPanel();
   
   public PointsTest()
   {
      add(panel);
   }//end PointsTest
   
   public static void main(String[] args)
   {
      JFrame frame = new PointsTest();
      frame.setTitle("PointsTest program");
      frame.setSize(250, 250);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }//end main
}//end PointsTest