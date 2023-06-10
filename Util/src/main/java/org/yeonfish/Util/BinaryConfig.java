package org.yeonfish.Util;

import java.math.BigInteger;
import java.util.ArrayList;

public class BinaryConfig {
    private final logger log = new logger();

    private ArrayList<Boolean> Binary = new ArrayList<>();

    BinaryConfig() {}

    public void set(BigInteger i) {
        String temp = i.toString(2);
        int i2 = 1;
        for (String s : temp.split("")) {
            this.Binary.set(temp.length()-i2, s.equals("1")?true:false);
            i2++;
        }
    }

    public void set(int position, boolean value) {
        int add = this.Binary.toArray().length;
        if (position > this.Binary.toArray().length) {
            for (int i=0;i<position-this.Binary.toArray().length;i++) {
                this.Binary.add(0, false);
            }
        }
        this.Binary.set(this.Binary.toArray().length-position, value);
    }

    public BigInteger get() {
        String temp = "";
        for (Boolean b:this.Binary)
            temp += b?"1":"0";
        return new BigInteger(temp, 2);
    }

    public String getBinary() {
        String temp = "";
        for (Boolean b:this.Binary)
            temp += b?"1":"0";
        return temp;
    }
    public boolean get(int position) {
        return this.Binary.get(position-1);
    }
}
