package lecture11.zachet;

/**
 * задание 1
 * Написть enum, который перечисляет планеты и возвращает массу планеты, ее радиус и радиус орбиты
 */



public class PlanetEnum{
    public static void main(String[] args) {
        for (Planet planet : Planet.values()) {
            System.out.println(planet.toString());
        }
    }
}

enum Planet {
    PLANET1(3.33022e23, 2439.7, 87.969),
    PLANET2(4.8675e24, 6051.8, 224.698),
    PLANET3(5.9726e24, 6371, 365.256366004),
    PLANET4(6.4171e23, 3389.5, 686.98),
    PLANET5(1.8986e27, 69911, 4332.589),
    PLANET6(5.6846e26, 58232, 10759.22),
    PLANET7(8.6832e25, 25362, 30685.4),
    PLANET8(1.0243e26, 24622, 60190.03);


    private final double mass;
    private final double radius;
    //заменила радиус орбиты на орбитальный(сидерический) период
    private final double orbitalPeriod;
    Planet(double mass, double radius, double orbitalPeriod){
        this.mass = mass;
        this.radius = radius;
        this.orbitalPeriod = orbitalPeriod;
    }

    @Override
    public String toString() {
        return this.name() + " Mass " + mass + " kg, Mean radius " + radius +
                " km, Orbital period " + orbitalPeriod + " days";
    }
}
