package ab.vision;

public class ERA {

    public boolean isB (ABObject a,ABObject b)
    {
        if((a.x+a.width)<b.x)
            return true;
        else
            return false;
    }

    public boolean isA (ABObject a,ABObject b)
    {
        if((b.x+b.width)<a.x)
            return true;
        else
            return false;
    }

    public  boolean isD (ABObject  a,ABObject b)
    {
        if(a.x>b.x && (a.x+a.width)<(b.x+b.width))
            return true;
        else
            return false;
    }

    public boolean isDi(ABObject a,ABObject b)
    {
        if(isD(b,a))
            return true;
        else
            return false;
    }

    public boolean isM (ABObject a,ABObject b)
    {
        if((a.x+a.width)==b.x)
            return true;
        else
            return false;
    }

    public boolean isMi (ABObject a,ABObject b)
    {
        if(isM(b,a))
            return true;
        else
            return false;
    }

    public boolean isO(ABObject a, ABObject b)
    {
        int ea = a.x+a.width;
        int eb = b.x+b.width;
        if(a.x<b.x && ea>b.x && ea<eb)
            return true;
        else
            return false;
    }

    public boolean isOi (ABObject a,ABObject b)
    {
        if(isO(b,a))
            return true;
        else
            return false;
    }

    public boolean isF(ABObject a, ABObject b)
    {

        int ea = a.x+a.width;
        int eb = b.x+b.width;
        if(ea==eb)
            return true;
        else
            return false;
    }

    public boolean isFi (ABObject a,ABObject b)
    {
        if(isF(b,a))
            return true;
        else
            return false;
    }

    public boolean isMom (ABObject a,ABObject b)
    {
        int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(a.x<b.x && ca>=b.x && ea>=cb && ea<eb )
            return true;
        else
            return false;
    }

    public boolean isMomi (ABObject a,ABObject b)
    {
        if(isMom(b,a))
            return true;
        else
            return false;
    }

    public boolean isLol (ABObject a,ABObject b)
    {
        int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        //int eb = b.x+b.width;

        if(ca<b.x && ea>b.x && a.x<cb)
            return true;
        else
            return false;
    }

    public boolean isLoli (ABObject a,ABObject b)
    {
        if(isLol(b,a))
            return true;
        else
            return false;
    }

    public boolean isMol (ABObject a,ABObject b)
    {
        int ca = a.width/2;
        //int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(a.x<b.x && ca>=b.x && ea<eb)
            return true;
        else
            return false;
    }

    public boolean isMoli (ABObject a,ABObject b)
    {
        if(isMol(b,a))
            return true;
        else
            return false;
    }

    public boolean isLom (ABObject a,ABObject b)
    {
        int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(ca<b.x && ea>=cb && ea<eb)
            return true;
        else
            return false;
    }

    public boolean isLomi (ABObject a,ABObject b)
    {
        if(isLom(b,a))
            return true;
        else
            return false;
    }

    public boolean isMs (ABObject a,ABObject b)
    {
        //int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        //int eb = b.x+b.width;

        if(a.x==b.x && ea>=cb)
            return true;
        else
            return false;
    }

    public boolean isMsi (ABObject a,ABObject b)
    {
        if(isMs(b,a))
            return true;
        else
            return false;
    }

    public boolean isLs (ABObject a,ABObject b)
    {
        //int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        //int eb = b.x+b.width;

        if(a.x==b.x && ea>b.x && ea<cb)
            return true;
        else
            return false;
    }

    public boolean isLsi (ABObject a,ABObject b)
    {
        if(isLs(b,a))
            return true;
        else
            return false;
    }

    public boolean isLd (ABObject a,ABObject b)
    {
       // int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        //int eb = b.x+b.width;

        if(a.x>b.x && ea<=cb)
            return true;
        else
            return false;
    }

    public boolean isLdi (ABObject a,ABObject b)
    {
        if(isLd(b,a))
            return true;
        else
            return false;
    }

    public boolean isRd (ABObject a,ABObject b)
    {
        //int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(a.x>=cb && ea<eb)
            return true;
        else
            return false;
    }

    public boolean isRdi (ABObject a,ABObject b)
    {
        if(isRd(b,a))
            return true;
        else
            return false;
    }

    public boolean isCd (ABObject a,ABObject b)
    {
       //int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(a.x>b.x && a.x<cb && ea>cb && ea<eb)
            return true;
        else
            return false;
    }

    public boolean isCdi (ABObject a,ABObject b)
    {
        if(isCd(b,a))
            return true;
        else
            return false;
    }

    public boolean isMf (ABObject a,ABObject b)
    {
        //int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(a.x>b.x && a.x<=cb && ea==eb)
            return true;
        else
            return false;
    }

    public boolean isMfi (ABObject a,ABObject b)
    {
        if(isMf(b,a))
            return true;
        else
            return false;
    }

    public boolean isLf (ABObject a,ABObject b)
    {
        //int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(a.x>cb && a.x<eb && ea==eb)
            return true;
        else
            return false;
    }

    public boolean isLfi (ABObject a,ABObject b)
    {
        if(isLf(b,a))
            return true;
        else
            return false;
    }

    public boolean isEq (ABObject a,ABObject b)
    {
        int ca = a.width/2;
        int cb = b.width/2;
        int ea = a.x+a.width;
        int eb = b.x+b.width;

        if(a.x==b.x && ca==cb && ea==eb)
            return true;
        else
            return false;
    }
}
