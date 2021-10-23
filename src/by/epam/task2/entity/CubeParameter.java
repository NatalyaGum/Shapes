package by.epam.task2.entity;


public class CubeParameter implements Cloneable {

    private double perimeter;
    private double area;
    private double volume;
    private double diagonal;

    public CubeParameter(double perimeter, double area, double volume, double diagonal) {
        this.volume = volume;
        this.area = area;
        this.perimeter = perimeter;
        this.diagonal = diagonal;
    }


    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public int hashCode() {
        int hash = 1111;
        hash = hash * (Double.hashCode(perimeter) +
                Double.hashCode(area) +
                Double.hashCode(volume) +
                Double.hashCode(diagonal));
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        CubeParameter parameters = (CubeParameter) object;
        boolean result = perimeter == parameters.perimeter &&
                area == parameters.area &&
                volume == parameters.volume &&
                diagonal == parameters.diagonal;
        return result;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", perimeter= ").append(perimeter);
        stringBuilder.append(", area= ").append(area);
        stringBuilder.append(", volume= ").append(volume);
        stringBuilder.append(", diagonal= ").append(diagonal);
        return stringBuilder.toString();
    }
}
