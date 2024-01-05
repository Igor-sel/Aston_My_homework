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

        public void getInfo() {
            System.out.printf("Наименование аттракциона: %s Время работы: %s Стоимость: %s \n",
                    name, time, cost);
        }
    }
}
