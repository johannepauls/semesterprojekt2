package semesterprojekt2ekg;

public class SensorTest implements Runnable {

    private Queue ko;

    public SensorTest(Queue q) {
        ko = q;
    }

    public void run() {
        int[] valueArray = {1, 2, 3, 4, 5};
        ko.addToQueue(valueArray);

    }

}
