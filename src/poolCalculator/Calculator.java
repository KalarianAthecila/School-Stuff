package poolCalculator;

public class Calculator {

    public static void main(String[] args) {
        double plotLength = 12;
        double plotWidth = 10;
        double poolDepth = 1;

        double poolLength = plotLength * ((double)2/3);
        double poolWidth = plotWidth * ((double)3/4);
        double poolBase = poolLength * poolWidth;
        double sideA = poolLength * poolDepth;
        double sideB = poolWidth * poolDepth;
        double poolOuterArea = (plotLength * plotWidth) - poolBase;
        double poolVolume = poolBase * poolDepth;
        double costInterior = 2 * (sideA + sideB) + poolBase;
        double costExterior = poolOuterArea * 24;
        double costExcavation = poolVolume * 200;
        double totalCost = costInterior + costExterior + costExcavation;

        System.out.print("Total cost: ");
        System.out.print(totalCost);
        System.out.print(" €");
    }

}
