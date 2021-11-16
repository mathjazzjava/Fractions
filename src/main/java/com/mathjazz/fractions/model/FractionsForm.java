package com.mathjazz.fractions.model;

public class FractionsForm {
    private Integer a, b, c, x, y, z;
    private String operation;

//    public FractionsForm(Integer a, Integer b, Integer c, Integer x, Integer y, Integer z, String operation) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//        this.x = x;
//        this.y = y;
//        this.z = z;
//        this.operation = operation;
//    }
//
//    public FractionsForm() {
//    }

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public Integer getC() {
        return c;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public String getOperation() {
        return operation;
    }

    public void setA(Integer a) {
        if (a == null)
            this.a = 0;
        else
            this.a = a;
    }

    public void setB(Integer b) {
        if (b == null)
            this.b = 0;
        else
            this.b = b;
    }

    public void setC(Integer c) {
        if (c == null)
            this.c = 0;
        else
            this.c = c;
    }

    public void setX(Integer x) {
        if (x == null)
            this.x = 0;
        else
            this.x = x;
    }

    public void setY(Integer y) {
        if (y == null)
            this.y = 0;
        else
            this.y = y;
    }

    public void setZ(Integer z) {
        if (z == null)
            this.z = 0;
        else
            this.z = z;
    }

    public void setOperation(String operation) {
        if (operation.matches("[+, -, *, /]{1}"))
            this.operation = operation;
        else
            this.operation = "+";
    }
   
}
