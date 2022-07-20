public class Robot implements Run,Swim {
    static final int MAX_RANGE_RUN = 1000;
    static final int MAX_RANGE_SWIM = 440;
    private boolean statusRun = true;
    private boolean statusSwim = true;

    @Override
    public void running(Treadmill treadmill) {
        if (MAX_RANGE_RUN > treadmill.length & statusRun == true){
            System.out.println("Робот пробежал " + treadmill.length);
        } else if (statusRun == false){
        } else {
            System.out.println("Робот - я так много не пробегу");
            statusRun = false;
        }
    }

    @Override
    public void swimming(Wall wall) {
        if (MAX_RANGE_SWIM > wall.height && statusSwim == true){
            System.out.println("Робот прыгнул " + wall.height);
        } else if (statusSwim == false){

        } else {

            System.out.println("Робот - я так высоко не прыгну");
            statusSwim = false;
        }

    }
}
