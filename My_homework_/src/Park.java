public class Park {
    public static class Atractions {

        private String name;
        private String time;
        private double cost;

        public Atractions(String name, String time, double cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }
        public double getCost() {
            return cost;
        }
        public void setCost(double cost) {
            this.cost = cost;
        }
    }
}
