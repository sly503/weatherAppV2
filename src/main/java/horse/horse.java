package horse;
import model.City;
import service.JpaService;
import java.util.List;


public class horse {
    private static JpaService jpaService = JpaService.getInstance();

    public static void main(String[] args) {
        try{
            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(new City("Tirana","123","123"));
                return null;
            });
            printCities();
        }finally {
            jpaService.shutdown();
        }
    }
    private static void printCities() {
        List<City> cities = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery("select c from City c", City.class).getResultList());
        cities.stream()
                .map(city -> city.getCityName() + ": " + city.getCityLon() + ":" + city.getCityLat())
                .forEach(System.out::println);
    }
}
