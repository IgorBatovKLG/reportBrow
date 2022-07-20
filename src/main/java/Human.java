public class Human implements Run,Swim  {
    static final int MAX_RANGE_RUN = 300;
    static final int MAX_RANGE_SWIM = 150;
    private boolean statusRun = true;
    private boolean statusSwim = true;

    @Override
    public void running(Treadmill treadmill) {
        if (MAX_RANGE_RUN > treadmill.length & statusRun == true){
            System.out.println("Человек пробежал " + treadmill.length);
        } else if (statusRun == false){
        } else {
            System.out.println("Человек - я так много не пробегу");
            statusRun = false;
        }
    }

    @Override
    public void swimming(Wall wall) {
        if (MAX_RANGE_SWIM > wall.height && statusSwim == true){
            System.out.println("Человек прыгнул " + wall.height);
        } else if (statusSwim == false){

        }else {
            System.out.println("Человек - я так высоко не прыгну");
            statusSwim = false;
        }

    }
}
