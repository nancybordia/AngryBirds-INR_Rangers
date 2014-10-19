package ab.vision;

import java.util.List;
import java.awt.Rectangle;

import ab.demo.other.ActionRobot;
import ab.vision.ABObject;
import ab.vision.Algebra;
import ab.vision.Vision;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 * Created by Nancy on 10/15/2014.
 */
public class Stability {
    static Algebra algebra = new Algebra();
    public static boolean isLeftShelter(ABObject a,ABObject b){
        if((algebra.isB(a, b)||algebra.isLd(a, b)||algebra.isCd(a, b)||algebra.isRd(a, b)||algebra.isLdi(a, b)||algebra.isCdi(a, b)||algebra.isRdi(a, b)||algebra.isMom(a, b)||algebra.isMol(a,b)||algebra.isLom(a, b)||algebra.isLol(a, b)||algebra.isM(a, b)||algebra.isMfi(a, b)||algebra.isLfi(a, b))&&(algebra.isLd(a, b)||algebra.isCd(a, b)||algebra.isRd(a, b)||algebra.isLdi(a, b)||algebra.isCdi(a, b)||algebra.isRdi(a, b)||algebra.isMom(a, b)||algebra.isMol(a,b)||algebra.isLom(a, b)||algebra.isLol(a, b)||algebra.isMomi(a, b)||algebra.isMoli(a,b)||algebra.isLomi(a, b)||algebra.isLoli(a, b)||algebra.isMs(a, b)||algebra.isLs(a, b)||algebra.isMsi(a, b)||algebra.isLsi(a, b)||algebra.isMf(a, b)||algebra.isLf(a, b)||algebra.isMfi(a, b)||algebra.isLfi(a, b)||algebra.isEq(a, b)))
            return true;
        else return false;

    }
    public static boolean isRightShelter(ABObject a,ABObject b){
        if((algebra.isA(a, b)||algebra.isLd(a, b)||algebra.isCd(a, b)||algebra.isRd(a, b)||algebra.isLdi(a, b)||algebra.isCdi(a, b)||algebra.isRdi(a, b)||algebra.isMomi(a, b)||algebra.isMoli(a,b)||algebra.isLomi(a, b)||algebra.isLoli(a, b)||algebra.isMi(a, b)||algebra.isMf(a, b)||algebra.isLf(a, b))&&(algebra.isLd(a, b)||algebra.isCd(a, b)||algebra.isRd(a, b)||algebra.isLdi(a, b)||algebra.isCdi(a, b)||algebra.isRdi(a, b)||algebra.isMom(a, b)||algebra.isMol(a,b)||algebra.isLom(a, b)||algebra.isLol(a, b)||algebra.isMomi(a, b)||algebra.isMoli(a,b)||algebra.isLomi(a, b)||algebra.isLoli(a, b)||algebra.isMs(a, b)||algebra.isLs(a, b)||algebra.isMsi(a, b)||algebra.isLsi(a, b)||algebra.isMf(a, b)||algebra.isLf(a, b)||algebra.isMfi(a, b)||algebra.isLfi(a, b)||algebra.isEq(a, b)))
            return true;
        else return false;
    }



}
