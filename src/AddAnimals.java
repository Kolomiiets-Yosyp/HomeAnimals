import java.io.*;
import java.util.ArrayList;

public class AddAnimals <T>{
   public T Animal;


    public AddAnimals(T animal) {
        Animal = animal;
    }

    @Override
    public String toString() {
        return "AddAnimals{" +
                "Animal=" + Animal +
                '}';
    }
}
