package ab.vision;

import java.awt.*;

/**
 * Created by Naincy on 10/22/2014.
 */
public class Equations {
    public static LineEquation lineEqCompute (int x1, int y1, int x2, int y2)
    {
        double[] arr = new double[7];

        // Cramer's Rule to solve system of equation ( 2 x 2 )
        if (x1 - x2 != 0)
        {
            // y = ax + b
            arr[0] = (double)(y1 - y2) / (double)(x1 - x2);
            arr[1] = (double)(x1*y2 - y1*x2) / (double)(x1 - x2);
            arr[2] = 0;
        }
        else
        {
            // line equation based on x = ay + b
            arr[0] = 0;
            arr[1] = x1;
            arr[2] = 1;
        }
        if (x1 < x2)
        {
            arr[3] = x1;
            arr[5] = x2;
            arr[4] = y1;
            arr[6] = y2;
        }
        else if (x1 > x2)
        {
            arr[3] = x2;
            arr[5] = x1;
            arr[4] = y2;
            arr[6] = y1;
        }
        else if (x1 == x2)
        {
            if (y1 < y2)
            {
                arr[3] = x1;
                arr[5] = x2;
                arr[4] = y1;
                arr[6] = y2;
            }
            else
            {
                arr[3] = x2;
                arr[5] = x1;
                arr[4] = y2;
                arr[6] = y1;
            }
        }

        LineEquation leq = new LineEquation(arr[0], arr[1], new Point((int)arr[3], (int)arr[4]),
                new Point((int)arr[5], (int)arr[6]), (arr[2] == 1) ? true : false);

        return leq;
    }
}
