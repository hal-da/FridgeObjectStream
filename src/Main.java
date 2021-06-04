import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILELOCATION = "fridge.bin";

    public static void main(String[] args) {

        // Create
        FoodProduct gouda = new FoodProduct("Gouda", 200, LocalDate.of(2021, 6,30), 40, 12);
        FoodProduct butter = new FoodProduct("Butter", 250, LocalDate.of(2021, 9,20), 80, 10);
        FoodProduct milk = new FoodProduct("Milk", 1200, LocalDate.of(2021, 6,20), 3, 10);
        FoodProduct beer = new FoodProduct("Beer", 500, LocalDate.of(2021, 10,15), 20, 40);
        FoodProduct meet = new FoodProduct("Meet", 750,  LocalDate.of(2021, 12,24), 70, 12);

        ArrayList<FoodProduct> foodProducts = new ArrayList<>(
                List.of(gouda,butter,milk,beer,meet)
        );
        ArrayList<FoodProduct> foodProductsFromFile = new ArrayList<>();

        //Write to file
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILELOCATION))) {
            objectOutputStream.writeObject(foodProducts);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Read from file
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILELOCATION))) {

            //foodProductsFromFile =  (ArrayList<FoodProduct>) objectInputStream.readObject() throws unchecked cast error
            //unchecked cast error could have been suppressed via @SuppressWarnings("unchecked")
            //not sure whats better, but that works:

            ArrayList<?> foodProductsFromFileRaw = (ArrayList<?>) objectInputStream.readObject();
            foodProductsFromFileRaw.forEach(obj -> {
               if(obj instanceof FoodProduct) foodProductsFromFile.add((FoodProduct) obj);
            });

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        foodProductsFromFile.forEach(System.out::println);
    }
}
