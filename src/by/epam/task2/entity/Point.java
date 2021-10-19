package by.epam.task2.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Point implements Cloneable {
    static Logger logger = LogManager.getLogger();

    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode() {
        int hash = 111;
        Double x = this.x;
        Double y = this.y;
        Double z = this.z;
        hash = hash + x.hashCode() + y.hashCode() + z.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Point{");
        builder.append(x).append(", ");
        builder.append(y).append(", ");
        builder.append(z).append("}");
        return builder.toString();

    }

    @Override
    public Point clone() {
        Point point = null;
        try {
            point = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            logger.error("Clone is not supported for Point", e);
        }
        return point;
    }

}
