package cz.fku.designPatterns.structural.adapter;

public class KmHMovableAdapter implements MovableAdapter {
    private Movable movable;

    public KmHMovableAdapter(Movable movable) {
        this.movable = movable;
    }


    @Override
    public double adaptSpeed() {
        return convertMpHToKmH(movable.getSpeed());
    }

    private double convertMpHToKmH(double mph) {
        return mph * 1.60934;
    }
}
