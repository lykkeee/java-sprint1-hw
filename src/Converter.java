public class Converter {
    double convertDistance(int steps) {
        double oneStepDistance = 0.00075;
        double distance = steps * oneStepDistance;
        return distance;
    }
    double convertKkal(int steps) {
        double oneStepKkal = 0.05;
        double kkal = steps * oneStepKkal;
        return kkal;
    }
}
