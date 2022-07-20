public class MainApp {
    public static void main(String[] args) {
        Run[] runs = new Run[]{
          new Cat(),
          new Robot(),
          new Human(),
        };
        Swim[] swims = new Swim[]{
                new Cat(),
                new Robot(),
                new Human(),
        };
        Wall[] walls = new Wall[]{
                new Wall(100),
                new Wall(200),
                new Wall(300),
                new Wall(400),
                new Wall(500),
        };
        Treadmill[] treadmills = new Treadmill[]{
                new Treadmill(100),
                new Treadmill(200),
                new Treadmill(300),
                new Treadmill(400),
                new Treadmill(500),
        };
        for (Run r : runs){
            for (Treadmill t : treadmills){
                r.running(t);
            }
            System.out.println("---");
        }
        System.out.println("---------------------------");
        for (Swim s : swims){
            for (Wall w : walls){
                s.swimming(w);
            }
            System.out.println("---");
        }
    }
}
