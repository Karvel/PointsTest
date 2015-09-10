/*
 Elanna Grossman
 Application that uses listens to mouse input to draw points in a window and then determines the two closets points.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Point;
import java.util.ArrayList;

public class PointsTestPanel extends JPanel
{
   private Point p1 = new Point(0, 0);
   private Point p2 = new Point(0, 0);
   final static int RADIUS = 5;
   double minDistance = Double.MAX_VALUE; //I decided to use the max value; finding a way to initialize with distance's value took too much code
   ArrayList<Point> pointsList = new ArrayList<Point>();
   
   protected PointsTestPanel()
   {
      this.addMouseListener(new MouseAdapter()
                               {
         public void mouseClicked(MouseEvent e)
         {
            pointsList.add(e.getPoint());
            if (pointsList.size() > 1)//only compares when pointsList has at least two values
            {
               checkPoint(e.getPoint());
            }//end if
            repaint();
         }//end mouseClicked
      });//end addMouseListener
   }//end PointsTestPanel
   
   //compare distances between all points to find the two points with the smallest distance
   private void checkPoint(Point point)
   {
      for(int i = 0; i < pointsList.size(); i++)
      {
         if(((Point)pointsList.get(i)).x != point.x && ((Point)pointsList.get(i)).y != point.y)//prevents comparing point against itself
         {
            double distance = pointDistance(((Point)pointsList.get(i)).x, ((Point)pointsList.get(i)).y, point.x, point.y);                  
            if(distance < minDistance)
            {
               minDistance = distance;
               p1.x = ((Point)pointsList.get(i)).x;
               p1.y = ((Point)pointsList.get(i)).y;
               p2.x = point.x;
               p2.y = point.y;
            }//end if
         }//end if
      }//end for
   }//end checkPoint
   
   //Calculate difference between two points
   private double pointDistance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
   }//end pointDistance
   
   @Override
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      for (int i = 0; i < pointsList.size(); i++)
      {
         g.drawOval(((Point) pointsList.get(i)).x - RADIUS, ((Point) pointsList.get(i)).y - RADIUS, 2 * RADIUS, 2 * RADIUS);
      }//end for
      if (pointsList.size() > 1)
      {
         g.fillOval(p1.x - RADIUS, p1.y - RADIUS, 2 * RADIUS, 2 * RADIUS);
         g.fillOval(p2.x - RADIUS, p2.y - RADIUS, 2 * RADIUS, 2 * RADIUS);
      }//end if
   }//end paintComponent
}//end PointsTestPanel