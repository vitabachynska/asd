package packageFiles;

class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public Engine createEngine(int hp) {
        return new Engine(hp);
    }

    public static class Engine {
        private int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }
        public String toString() {return "Двигун з " + horsepower + " кінськими силами";
        }
    }
}
