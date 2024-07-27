public class Park {

    public class Attraction {

        private String name;
        private int price;
        private String workStart;
        private String workFinish;

        public Attraction(String name, int price, String workStart, String workFinish) {
            this.name = name;
            this.price = price;
            this.workStart = workStart;
            this.workFinish = workFinish;
        }

        @Override
        public String toString() {
            return name + ": время работы - с " + workStart + " до " + workFinish + ", цена - " + price + " рублей";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getWorkStart() {
            return workStart;
        }

        public void setWorkStart(String workStart) {
            this.workStart = workStart;
        }

        public String getWorkFinish() {
            return workFinish;
        }

        public void setWorkFinish(String workFinish) {
            this.workFinish = workFinish;
        }
    }
}