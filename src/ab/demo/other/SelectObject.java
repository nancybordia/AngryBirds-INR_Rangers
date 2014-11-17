package ab.demo.other;

import java.awt.Rectangle;


import ab.planner.TrajectoryPlanner;
import ab.vision.ABObject;
import ab.vision.Algebra;
import ab.vision.Heuristic;
import ab.vision.Vision;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by Jeet on 28-09-2014.
 */
public class SelectObject {
    Heuristic heuristic = new Heuristic();




    public List<ABObject> reachable(){
        BufferedImage screenshot = ActionRobot.doScreenShot();
        Vision vision = new Vision(screenshot);
        // Algebra algebra = new Algebra();
        List<ABObject> _block = vision.findBlocksMBR();
        List<ABObject> _pigs=vision.findPigsMBR();
        // List<ABObject> _pigs=vision.findPigsMBR();
        // List<ABObject> _wood=vision.findWoodMBR();
        // List<ABObject> _pigs=vision.findPigsMBR();
        List<ABObject> blocks=new ArrayList<ABObject>();
        //blocks.addAll(block);
        //blocks.addAll(pigs);

        ArrayList<ABObject> allRect = new ArrayList<ABObject>(0);
        if(_pigs != null)
            allRect.addAll(_pigs);
        //if(_wood != null)
        // allRect.addAll(_wood);
        // if(_ice != null)
        //   allRect.addAll(_ice);
        if(_block != null)
            allRect.addAll(_block);

        ArrayList<ABObject> result = new ArrayList<ABObject>(0);
        for(ABObject r: allRect)
        {
            ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>(0);
            for(int i=1;i<=30;i++)
            {
                Point2D.Double point = new Point2D.Double(r.getX()-i,r.getY()+(r.height/2));
                points.add(point);
            }
            for(int i=1;i<=30;i++)
            {
                Point2D.Double point = new Point2D.Double(r.getX()-30,r.getY()+i);
                points.add(point);
            }

            boolean inside = false;
            for(Rectangle s: allRect)
            {
                boolean temp = false;
                for(Point2D p:points)
                {
                    if(s.contains(p))
                    {
                        temp = true;
                        break;
                    }
                    else
                        temp = false;
                }

                if(temp)
                {
                    inside = false;
                    break;
                }
                else
                    inside = true;
            }

            if(inside)
                result.add(r);
        }
        //return findConnectedOuterBlocks(allRect);
        result.addAll(_pigs);

        System.out.println("reachable:"+result.size());
        return result;


    }
}
