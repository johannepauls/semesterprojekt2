package semesterprojekt2ekg;

public class SensorTest implements Runnable {

    private Queue ko;
    private String text;
    private int range = (1024-0)+1;
    private Double value;
    

    public SensorTest(Queue q) {
        ko = q;
    }

    public void run() {
        for(;;){
            for(int i=0 ; i < 10 ; i++){ 
                value = (Math.random() * range);
                
                text = new Double(value).toString();
            }
            ko.addToQueue(text);
        }
    }

}
