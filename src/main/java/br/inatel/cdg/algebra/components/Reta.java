package br.inatel.cdg.algebra.components;

public class Reta {

    private Ponto p1 = new Ponto();
    private Ponto p2 = new Ponto();


    public void setPoints(double p1x, double p1y, double p2x, double p2y){
        p1.setX(p1x);
        p2.setX(p2x);
        p1.setY(p1y);
        p2.setY(p2y);
    }

    public double angularCoef(){
        double p2y = p2.getY();
        double p2x = p2.getX();
        double p1y = p1.getY();
        double p1x = p1.getX();

        return (p2y-p1y)/(p2x-p1x);
    }

    public double linearCoef() {
        double p1y = p1.getY();
        double p1x = p1.getX();
        double ca = angularCoef();

        return p1y - (ca*p1x);
    }

}
