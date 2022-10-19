import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;

public class ObjectManager {
    @Test
    public void createObjects() {
        Book book = new Book();
        book.setAuthor("George Orwell");
        book.setLanguage("English");
        book.setPrice(3.99);
        book.setTitle("Animal Farm");
        book.setPublicationDate(LocalDate.of(1945, Month.AUGUST,17));
        System.out.println(book.getTitle());

        Box box = new Box();
        box.setColor("Green");
        box.setHeigh(1.58);
        box.setMaterial("Paper");
        box.setWeight(0.39);
        box.setWidth(3.02);
        System.out.println(box.getMaterial());

        Cat cat = new Cat();
        cat.setColor("Beige");
        cat.setAge(3);
        cat.setWeight(7.12);
        cat.setName("Persik");
        cat.setSex("Male");
        System.out.println(cat.getName());

        Charger charger = new Charger();
        charger.setColor("White");
        charger.setBrand("LG");
        charger.setPower(50);
        charger.setPlugType("EU");
        charger.setSocketCount(2);
        System.out.println(charger.getPlugType());

        Cookies cookies = new Cookies();
        cookies.setBrand("Selga");
        cookies.setQuantity(2);
        cookies.setSmell("Vanilla");
        cookies.setTaste("Sweet");
        cookies.setWeight(0.005);
        System.out.println(cookies.getTaste());

        Film film = new Film();
        film.setDuration(2);
        film.setGenre("Fantasy");
        film.setTitle("The Lord of the Rings");
        film.setImdbRating(8.8);
        film.setReleaseDate(LocalDate.of(2001, Month.DECEMBER, 19));
        System.out.println(film.getGenre());

        Meal meal = new Meal();
        meal.setCalories(315);
        meal.setCarbs(78);
        meal.setFat(8);
        meal.setProtein(14);
        meal.setAllergenFree(true);
        System.out.println(meal.isAllergenFree());

        Pills pills = new Pills();
        pills.setBrand("Olainfarm");
        pills.setColor("White");
        pills.setQuantity(20);
        pills.setActiveIngredient("Ambroxoli hydrochloridum");
        pills.setBestBefore(LocalDate.of(2024, Month.APRIL, 23));
        System.out.println(pills.getBestBefore());

        Ring ring = new Ring();
        ring.setBrand("Zoye");
        ring.setColor("Gold");
        ring.setMaterial("Gold");
        ring.setPrice(44.99);
        ring.setSize(16.5);
        System.out.println(ring.getSize());

        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Samsung");
        smartphone.setModel("Galaxy S22");
        smartphone.setCameraResolution(108.0);
        smartphone.setOperatingSystem("Android");
        smartphone.setScreenSize(6.1);
        System.out.println(smartphone.getModel());

    }
}
