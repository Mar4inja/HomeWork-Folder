package Task_1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// Описать ситуацию, когда компания располагает техникой для строительства всех объектов одновременно,
// и нет никакой задержки старта строительства по времени. Подсказка: использовать такой пул потоков,
// который мы на занятии не использовали.
public class Main {

    public static void main(String[] args) {
        String[] stages = {
                "1. Projecting",
                "2. Start working",
                "3. Finish work",
                "4. Inner work",
                "5. Finish object"
        };
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(new Building("Dortmund", stages, true));
        service.execute(new Building("Osnabruck", stages, true));
        service.execute(new Building("Berlin", stages, true));
        service.execute(new Building("Hamburg", stages, true));

        service.shutdown();
    }
}
