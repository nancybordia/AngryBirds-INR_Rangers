package ab.demo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import ab.demo.other.ActionRobot;
import ab.utils.ABUtil;
import ab.vision.ABObject;
import ab.vision.ERA;
import ab.vision.Vision;

public class Stability {

    /* Unstable = -1
       Maybe Unstable = 0
       Maybe Stable = 1
       Stable = 2
     */

    public static int stabilityFactor(ABObject a)
    {
        BufferedImage screenshot = ActionRobot.doScreenShot();
        Vision vision = new Vision(screenshot);
        Rectangle sling = vision.findSlingshotMBR();
        int ground = sling.y+sling.height;
        ERA check = new ERA();
        List<ABObject> allBlocks = vision.findBlocksMBR();
        allBlocks.addAll(vision.findPigsMBR());
        allBlocks.addAll(vision.findTNTs());
        List<ABObject> blocks = ABUtil.getSupporters(a,allBlocks);
        int flag = -1;
        ABObject x = a;

        // Rule 1.1 and 1.2
        for(int i=0;i<blocks.size();i++)
        {
            ABObject y = blocks.get(i);
            for(int j=0;j<blocks.size();j++)
            {
                ABObject z = blocks.get(j);
                if(i!=j)
                {
                    if(x.y+x.height == ground ||
                      ((check.isMomi(x,y) || check.isMoli(x,y) || check.isLomi(x,y) || check.isLoli(x,y) ||
                            check.isMsi(x,y) || check.isLsi(x,y) || check.isLdi(x,y)) &&
                      (check.isMom(x,z) || check.isMol(x,z) || check.isLom(x,z) || check.isLol(x,z) ||
                            check.isMfi(x,z)|| check.isLfi(x,z) || check.isRdi(x,z))) && !check.isEq(x,y) && !check.isEq(x,z))
                                flag = 2;
                }
            }
         }

        //Rule 1.3
        for(int i=0;i<blocks.size();i++)
        {
            ABObject y = blocks.get(i);
            if(!check.isEq(x,y) &&
              (check.isMs(x,y) || check.isMf(x,y) || check.isMf(x,y) || check.isMsi(x,y) ||
                check.isLs(x,y) || check.isMfi(x,y) || check.isLf(x,y) || check.isCd(x,y) ||
                check.isCdi(x,y) || check.isLd(x,y) || check.isRd(x,y) || check.isMom(x,y) ||
                check.isMomi(x,y) || check.isLomi(x,y) || check.isMol(x,y)))
                    flag = 2;
        }

        //Rule 1.4
        for(int i=0;i<blocks.size();i++)
        {
            ABObject y = blocks.get(i);
            for(int j=0;j<blocks.size();j++)
            {
                ABObject z = blocks.get(j);
                if(i!=j)
                {
                    if(!check.isEq(x,y) && !check.isEq(x,z) &&
                    ((check.isLd(x,y) || check.isCd(x,y)  || check.isRd(x,y) || check.isMs(x,y) ||
                            check.isLs(x,y) || check.isMf(x,y) || check.isLf(x,y))
                    ||((check.isMomi(x,y) || check.isMoli(x,y) || check.isLomi(x,y) ||
                            check.isLoli(x,y) || check.isMsi(x,y) || check.isLsi(x,y)) &&
                       (check.isMom(x,z) || check.isMol(x,z) || check.isLom(x,z) || check.isLol(x,z) ||
                        check.isMfi(x,z) || check.isLfi(x,z)))))
                            flag = 2;
                }
            }
        }

        //Rule 1.5
        for(int i=0;i<blocks.size();i++)
        {
            ABObject y = blocks.get(i);
            for(int j=0;j<blocks.size();j++)
            {
                ABObject z = blocks.get(j);
                for(int k=0;k<blocks.size();k++)
                {
                    ABObject u = blocks.get(k);
                    if(i!=j && j!=k && i!=k)
                    {
                        if((!check.isLd(x,y) || !check.isCd(x,y) || !check.isRd(x,y) || !check.isMomi(x,y) ||
                                !check.isMoli(x,y) || !check.isLoli(x,y) || !check.isLomi(x,y) || !check.isMsi(x,y) ||
                                !check.isMs(x,y) || !check.isLs(x,y) || !check.isLsi(x,y) || !check.isLf(x,y) ||
                                !check.isMf(x,y) || !check.isEq(x,y)) &&
                           (check.isLdi(x,y) || check.isCdi(x,y)) &&
                           (check.isMom(x,z) || check.isMol(x,z) || check.isLom(x,z) || check.isLol(x,z) ||
                                   check.isMfi(x,z) || check.isLfi(x,z) || check.isRdi(x,z)) &&
                           (check.isLdi(x,u) || check.isMoli(x, u) || check.isLsi(x, u)))
                                    flag = 0;
                    }
                }
            }
        }

        for(int i=0;i<blocks.size();i++)
        {
            ABObject y = blocks.get(i);
            for(int j=0;j<blocks.size();j++)
            {
                ABObject z = blocks.get(j);
                for(int k=0;k<blocks.size();k++)
                {
                    ABObject u = blocks.get(k);
                    for(int l =0;l<blocks.size();l++)
                    {
                        ABObject v = blocks.get(l);
                        if(i!=j && j!=k && k!=l && l!=i && i!=k && j!=l)
                        {
                            if((!check.isLd(x,y) || !check.isCd(x,y) || !check.isLdi(x,y) || !check.isCdi(x,y) ||
                                    !check.isMoli(x,y) || !check.isMomi(x,y) || !check.isLomi(x,y) || !check.isLoli(x,y) ||
                                    !check.isMs(x,y) || !check.isMsi(x,y) || !check.isLsi(x,y) || !check.isLs(x,y) ||
                                    !check.isMf(x,y) || !check.isLf(x,y) || !check.isEq(x,y)) &&
                              (check.isMom(x,z) || check.isMol(x,z) || check.isLom(x,z) || check.isLol(x,z) ||
                                     check.isMfi(x,z) || check.isLfi(x,z) || check.isRdi(x,z)) &&
                              (check.isMom(x,u) || check.isMol(x,u) || check.isLol(x,u)) &&
                              (check.isMs(x,v) || check.isMf(x,v) || check.isMsi(x,v) || check.isLs(x,v) ||
                                      check.isMfi(x,v) || check.isLf(x,v) || check.isCd(x,v) || check.isCdi(x,v) ||
                                      check.isLd(x,v) || check.isRd(x,v) || check.isMom(x,v) || check.isMomi(x,v) ||
                                      check.isLomi(x,v) || check.isMol(x,v)))
                                flag = 1;
                        }
                    }
                }
            }
        }

       return flag;
    }

    public static boolean isLeftShelter(ABObject a,ABObject b)
    {
        BufferedImage screenshot = ActionRobot.doScreenShot();
        Vision vision = new Vision(screenshot);
        Rectangle sling = vision.findSlingshotMBR();
        int ground = sling.y+sling.height;
        ERA check = new ERA();
        List<ABObject> allBlocks = vision.findBlocksMBR();
        allBlocks.addAll(vision.findPigsMBR());
        allBlocks.addAll(vision.findTNTs());
        List<ABObject> blocks = ABUtil.getSupporters(a,allBlocks);
        int flag = -1;
        ABObject x = a;

        for(int i=0;i<blocks.size();i++)
        {
            ABObject y = blocks.get(i);
            if((check.isB(x,y) || check.isD(x,y) || check.isDi(x,y) ||check.isO(x,y) ||check.isM(x,y) || check.isMi(x,y)) &&
               (check.isD(y,x) || check.isDi(y,x) || check.isO(y,x) || check.isOi(y,x) || check.isF(y,x) || check.isFi(y,x) ||
                       check.isFi(y,x)))
                return true;
        }

        return false;
    }

    public static boolean isRightShelter(ABObject a,ABObject b)
    {
        BufferedImage screenshot = ActionRobot.doScreenShot();
        Vision vision = new Vision(screenshot);
        Rectangle sling = vision.findSlingshotMBR();
        int ground = sling.y+sling.height;
        ERA check = new ERA();
        List<ABObject> allBlocks = vision.findBlocksMBR();
        allBlocks.addAll(vision.findPigsMBR());
        allBlocks.addAll(vision.findTNTs());
        List<ABObject> blocks = ABUtil.getSupporters(a,allBlocks);
        int flag = -1;
        ABObject x = a;

        for(int i=0;i<blocks.size();i++)
        {
            ABObject y = blocks.get(i);
            if((check.isB(y,x) || check.isD(y,x) || check.isDi(y,x) ||check.isO(y,x) ||check.isM(y,x) || check.isMi(y,x)) &&
                    (check.isD(x,y) || check.isDi(x,y) || check.isO(x,y) || check.isOi(x,y) || check.isF(x,y) || check.isFi(x,y) ||
                            check.isFi(x,y)))
                return true;
        }

        return false;
    }
}
