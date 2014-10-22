
package ab.vision;

import ab.demo.other.ActionRobot;
import ab.demo.other.Shot;
import ab.planner.TrajectoryPlanner;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ab.demo.Stability;


public class Heuristic {
    public static List<ABObject> Destroyed;
    public static List<ABObject> getShelter(ABObject pig,ABObject[] list){
        List<ABObject> left=new ArrayList<ABObject>();
        List<ABObject> right=new ArrayList<ABObject>();
        List<ABObject> supporters=new ArrayList<ABObject>();
        List<ABObject> supportees=new ArrayList<ABObject>();
        List<ABObject> shelter=new ArrayList<ABObject>();

        for (int i=0;i<list.length;i++){
            if(Stability.isLeftShelter(list[i],pig))
                left.add(list[i]);
            else if(Stability.isRightShelter(list[i],pig))
                right.add(list[i]);
        }
        //getClosestLeft(left,true);
        //getClosestRight(right,false);

        return shelter;
    }

    public static List<ABObject> getLeftObjects(ABObject o,List<ABObject> obj) {
        List<ABObject> left = new ArrayList<ABObject>();
        for (ABObject o1:obj) {
            if (Stability.isLeftShelter(o1, o))
                left.add(o1);
        }
        return left;
    }

    public static List<ABObject> getRightObjects(ABObject o, List<ABObject> obj)
    {
        List<ABObject> right = new ArrayList<ABObject>();
        for (ABObject o1:obj) {
            if (Stability.isRightShelter(o1, o))
                right.add(o1);
        }
        return right;
    }

    //List <ABObject> getAffected(ABObject obj)
    //{

    //}
    public static List<ABObject> getSupporters(ABObject x , List<ABObject> obj){
        List<ABObject> supporters=new ArrayList<ABObject>();
        for (ABObject y:obj) {
            if (isSupport(x, y)) {
                supporters.add(y);

            }
        }
        return supporters;
    }

    public static List<ABObject> getSupportees(ABObject x , List<ABObject> obj){
        List<ABObject> supportees=new ArrayList<ABObject>();
        for (ABObject y:obj) {
            if (isSupport(y, x)) {
                supportees.add(y);

            }
        }
        return supportees;
    }

    public static boolean isSupport(ABObject a,ABObject b){
        ERA algebra=new ERA();
        if((algebra.isLd(a, b)||algebra.isCd(a, b)||algebra.isRd(a, b)||algebra.isLdi(a, b)||algebra.isCdi(a, b)||algebra.isRdi(a, b)||algebra.isMom(a, b)||algebra.isMol(a,b)||algebra.isLom(a, b)||algebra.isLol(a, b)||algebra.isMomi(a, b)||algebra.isMoli(a,b)||algebra.isLomi(a, b)||algebra.isLoli(a, b)||algebra.isMs(a, b)||algebra.isLs(a, b)||algebra.isMsi(a, b)||algebra.isLsi(a, b)||algebra.isMf(a, b)||algebra.isLf(a, b)||algebra.isMfi(a, b)||algebra.isLfi(a, b)||algebra.isEq(a, b))&&algebra.isM(a, b))
            return true;
        else return false;
    }

    public static List<ABObject> getallSupportees(ABObject x, List<ABObject> obj){
        List<ABObject> directSupportees=getSupportees(x, obj);
        List<ABObject> allsupportees= new ArrayList<ABObject>();
        if(!allsupportees.containsAll(directSupportees))
            allsupportees.addAll(directSupportees);
        for(ABObject o:directSupportees){
            getallSupporters(o,obj);
        }
        return allsupportees;
    }

    public static List<ABObject> getallSupporters(ABObject x, List<ABObject> obj){
        List<ABObject> directSupporters=getSupporters(x, obj);
        List<ABObject> allsupporters= new ArrayList<ABObject>();
        if(!allsupporters.containsAll(directSupporters))
            allsupporters.addAll(directSupporters);
        for(ABObject o:directSupporters){
            getallSupporters(o,obj);
        }
        return allsupporters;
    }


    static List<ABObject> getNeighbours(ABObject x, List<ABObject> obj){
        List<ABObject> neighbours=new ArrayList<ABObject>();
        List<ABObject> left=getLeftObjects(x,obj);
        List<ABObject> right=getRightObjects(x,obj);
        neighbours.addAll(getClosestLeft(left));
        //neighbours.addAll(getClosestRight(right));
        return neighbours;
    }

    public static List<ABObject> getClosestLeft(List<ABObject> obj){
        {
            List<ABObject> removedList = new ArrayList<ABObject>();
            Iterator<ABObject> index = obj.iterator();
            ERA algebra=new ERA();
            for (int i = 0; i < obj.size(); i++)
            {
                ABObject y = obj.get(i);
                for (int j = 0; j < obj.size(); j++)
                {
                    ABObject z = obj.get(j);
                    if (y.id != z.id)
                    {
                        if ((algebra.isB(y,z)||algebra.isLd(y,z)||algebra.isCd(y,z)||algebra.isRd(y,z)||algebra.isMom(y,z)||algebra.isMol(y,z)||algebra.isLom(y,z)||algebra.isLol(y,z)||algebra.isM(y,z)||algebra.isLs(y,z)||algebra.isMs(y,z))&&(algebra.isB(y,z) || algebra.isA(y,z) || algebra.isM(y,z) || algebra.isMi(y,z) || algebra.isMom(y,z) || algebra.isMomi(y,z) || algebra.isLol(y,z) || algebra.isLoli(y,z) || algebra.isMol(y,z) || algebra.isMoli(y,z) || algebra.isLom(y,z) || algebra.isLomi(y,z) || algebra.isMs(y,z) || algebra.isMsi(y,z) || algebra.isLs(y,z)) || algebra.isLsi(y,z) || algebra.isLd(y,z) || algebra.isLdi(y,z) || algebra.isRd(y,z) || algebra.isRdi(y,z) || algebra.isCd(y,z) || algebra.isCdi(y,z) || algebra.isMf(y,z) || algebra.isMfi(y,z) || algebra.isLf(y,z) || algebra.isLfi(y,z) || algebra.isEq(y,z))
                        {
                            //System.out.println("delete " + y.id + " remain " + z.id);
                            removedList.add(y);
                        }
                        else if ((algebra.isB(y,z)||algebra.isLd(y,z)||algebra.isCd(y,z)||algebra.isRd(y,z)||algebra.isMom(y,z)||algebra.isMol(y,z)||algebra.isLom(y,z)||algebra.isLol(y,z)||algebra.isM(y,z)||algebra.isLs(y,z)||algebra.isMs(y,z))&&(algebra.isB(y,z) || algebra.isA(y,z) || algebra.isM(y,z) || algebra.isMi(y,z) || algebra.isMom(y,z) || algebra.isMomi(y,z) || algebra.isLol(y,z) || algebra.isLoli(y,z) || algebra.isMol(y,z) || algebra.isMoli(y,z) || algebra.isLom(y,z) || algebra.isLomi(y,z) || algebra.isMs(y,z) || algebra.isMsi(y,z) || algebra.isLs(y,z)) || algebra.isLsi(y,z) || algebra.isLd(y,z) || algebra.isLdi(y,z) || algebra.isRd(y,z) || algebra.isRdi(y,z) || algebra.isCd(y,z) || algebra.isCdi(y,z) || algebra.isMf(y,z) || algebra.isMfi(y,z) || algebra.isLf(y,z) || algebra.isLfi(y,z) || algebra.isEq(y,z))
                        {
                            //System.out.println("delete " + z.id + " remain " + y.id);
                            removedList.add(z);
                        }

                    }
                }
            }

            while (index.hasNext())
            {
                ABObject x = index.next();
                for (int i = 0; i < removedList.size(); i++)
                {
                    ABObject y = removedList.get(i);
                    if (x.id == y.id)
                    {
                        index.remove();
                        break;
                    }
                }
            }

            return obj;
        }
    }

    public static List<ABObject> getClosestRight(List<ABObject> obj){
        {
            List<ABObject> removedList = new ArrayList<ABObject>();
            Iterator<ABObject> index = obj.iterator();
            ERA algebra=new ERA();
            for (int i = 0; i < obj.size(); i++)
            {
                ABObject y = obj.get(i);
                for (int j = 0; j < obj.size(); j++)
                {
                    ABObject z = obj.get(j);
                    if (y.id != z.id)
                    {
                        if ((algebra.isB(y,z)||algebra.isLd(y,z)||algebra.isCd(y,z)||algebra.isRd(y,z)||algebra.isMom(y,z)||algebra.isMol(y,z)||algebra.isLom(y,z)||algebra.isLol(y,z)||algebra.isM(y,z)||algebra.isLs(y,z)||algebra.isMs(y,z))&&(algebra.isB(y,z) || algebra.isA(y,z) || algebra.isM(y,z) || algebra.isMi(y,z) || algebra.isMom(y,z) || algebra.isMomi(y,z) || algebra.isLol(y,z) || algebra.isLoli(y,z) || algebra.isMol(y,z) || algebra.isMoli(y,z) || algebra.isLom(y,z) || algebra.isLomi(y,z) || algebra.isMs(y,z) || algebra.isMsi(y,z) || algebra.isLs(y,z)) || algebra.isLsi(y,z) || algebra.isLd(y,z) || algebra.isLdi(y,z) || algebra.isRd(y,z) || algebra.isRdi(y,z) || algebra.isCd(y,z) || algebra.isCdi(y,z) || algebra.isMf(y,z) || algebra.isMfi(y,z) || algebra.isLf(y,z) || algebra.isLfi(y,z) || algebra.isEq(y,z))
                        {
                            //System.out.println("delete " + y.id + " remain " + z.id);
                            removedList.add(z);
                        }
                        else if ((algebra.isB(y,z)||algebra.isLd(y,z)||algebra.isCd(y,z)||algebra.isRd(y,z)||algebra.isMom(y,z)||algebra.isMol(y,z)||algebra.isLom(y,z)||algebra.isLol(y,z)||algebra.isM(y,z)||algebra.isLs(y,z)||algebra.isMs(y,z))&&(algebra.isB(y,z) || algebra.isA(y,z) || algebra.isM(y,z) || algebra.isMi(y,z) || algebra.isMom(y,z) || algebra.isMomi(y,z) || algebra.isLol(y,z) || algebra.isLoli(y,z) || algebra.isMol(y,z) || algebra.isMoli(y,z) || algebra.isLom(y,z) || algebra.isLomi(y,z) || algebra.isMs(y,z) || algebra.isMsi(y,z) || algebra.isLs(y,z)) || algebra.isLsi(y,z) || algebra.isLd(y,z) || algebra.isLdi(y,z) || algebra.isRd(y,z) || algebra.isRdi(y,z) || algebra.isCd(y,z) || algebra.isCdi(y,z) || algebra.isMf(y,z) || algebra.isMfi(y,z) || algebra.isLf(y,z) || algebra.isLfi(y,z) || algebra.isEq(y,z))
                        {
                            //System.out.println("delete " + z.id + " remain " + y.id);
                            removedList.add(y);
                        }

                    }
                }
            }

            while (index.hasNext())
            {
                ABObject x = index.next();
                for (int i = 0; i < removedList.size(); i++)
                {
                    ABObject y = removedList.get(i);
                    if (x.id == y.id)
                    {
                        index.remove();
                        break;
                    }
                }
            }

            return obj;
        }
    }

    public static boolean isReachable(Vision vision,Point target,Shot shot){
        // System.out.println("hi");
        TrajectoryPlanner tp = new TrajectoryPlanner();
        Point releasePoint = new Point(shot.getX()+shot.getDx(),shot.getY()+shot.getDy());
        int trajY=tp.getYCoordinate(vision.findSlingshotMBR(),releasePoint,target.x);
        //if (Math.abs(trajY - target.y) > 100)
        //{
        //    return false;
        //}
        boolean result = true;
        // System.out.println("hi");
        List<Point> points = tp.predictTrajectory(vision.findSlingshotMBR(),
                releasePoint);
        for (Point point : points) {
            if (point.x < 840 && point.y < 480 && point.y > 100
                    && point.x > 400)
                for (ABObject ab : vision.findBlocksMBR()) {
                    if (((ab.contains(point) && !ab.contains(target)) || Math
                            .abs(vision.getMBRVision()._scene[point.y][point.x] - 72) < 10)
                            && point.x < target.x)
                        return false;
                }

        }
        //System.out.println(result);
        return result;

    }

    public static int getHeuristicValue(ABObject obj)
    {
        int h = 0;
        List <ABObject> affectedObjects =new ArrayList<ABObject>();
        BufferedImage screenshot = ActionRobot.doScreenShot();
        Vision vision = new Vision(screenshot);
        List<ABObject> pig=vision.findPigsMBR();
        List<ABObject> block=vision.findBlocksMBR();
        List<ABObject> blocks=new ArrayList<ABObject>();
        blocks.addAll(pig);
        blocks.addAll(block);
        affectedObjects.add(obj);
        affectedObjects.addAll(getallSupporters(obj,blocks));
        affectedObjects.addAll(getallSupportees(obj,blocks));
        List<ABObject> neighbours=new ArrayList<ABObject>();
        for(ABObject o:affectedObjects){
            neighbours.addAll(getNeighbours(o, blocks));
        }
        affectedObjects.addAll(neighbours);
        for(ABObject o:affectedObjects)
        {
            if(o.getType() == ABType.Pig)
            {
                h += 10;
            }
            else
            {
                h += 1;
            }
            h +=Stability.stabilityFactor(o);
        }
        return h;
    }
    public static ABObject getTarget(){
        int score,max=0;
        ABObject target=new ABObject();
        BufferedImage screenshot = ActionRobot.doScreenShot();
        Vision vision = new Vision(screenshot);
        List<ABObject> blocks=vision.findBlocksMBR();

        //System.out.println(blocks.size());
        Shot shot=new Shot();
        List<ABObject> reachable=new ArrayList<ABObject>();
        for(ABObject o:blocks){
            Point target1=o.getCenter();
            Point target2=o.getTop();
            if(isReachable(vision,target1,shot)||isReachable(vision,target2,shot)){
                reachable.add(o);
            }
        }
        //System.out.println("No of blocks reachable:" + reachable.size());
        for(ABObject o:reachable){
            //if (o.getType()==ABType.Stone) {
            // return o;
            // }
            score=getHeuristicValue(o);
            //System.out.println(o);
            // System.out.println(score);
            if(score>max){
                max=score;
                target=o;
            }
        }
        System.out.println(max);
        return target;
    }



}


