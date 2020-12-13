package com.mycompany.figures;

import java.math.BigDecimal;

public class MyTriangle {

    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1 = new MyPoint(x1,y1);
        v2 = new MyPoint(x2,y2);
        v3 = new MyPoint(x3,y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }

    public double getPerimenter() {
        double edge1 = v1.distance(v2);
        double edge2 = v2.distance(v3);
        double edge3 = v3.distance(v1);
        return edge1 + edge2 + edge3;
    }

    public TriangleType getType(){
        TriangleType triangleType = TriangleType.SCALENE;

        BigDecimal edge1 = new BigDecimal(v1.distance(v2));
        BigDecimal edge2 = new BigDecimal(v2.distance(v3));
        BigDecimal edge3 = new BigDecimal(v3.distance(v1));

        int equalEdges12 = edge1.compareTo(edge2);
        int equalEdges13 = edge1.compareTo(edge3);
        int equalEdges23 = edge2.compareTo(edge3);

        if (equalEdges12 == 0 || equalEdges13==0 || equalEdges23 == 0){
            triangleType = TriangleType.ISOSCELES;
        }

        if ( equalEdges12 == 0 && equalEdges13==0 && equalEdges23 == 0){
            triangleType = TriangleType.EQUILATERAL;
        }
        return triangleType;
    }

}
