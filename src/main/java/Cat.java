public class Cat implements Run,Swim {
    static final int MAX_RANGE_RUN = 300;
    static final int MAX_RANGE_SWIM = 600;
    private boolean statusRun = true;
    private boolean statusSwim = true;

    @Override
    public void running(Treadmill treadmill) {
        if (MAX_RANGE_RUN > treadmill.length & statusRun == true){
            System.out.println("Кот пробежал " + treadmill.length);
        } else if (statusRun == false){
        } else {
            System.out.println("Кот - я так много не пробегу");
            statusRun = false;
        }

    }

    @Override
    public void swimming(Wall wall) {
        if (MAX_RANGE_SWIM > wall.height && statusSwim == true){
            System.out.println("Кот прыгнул " + wall.height);
        } else if (statusSwim == false){

        } else {
            System.out.println("Кот - я так высоко не прыгну");
            statusSwim = false;
        }
    }
}
