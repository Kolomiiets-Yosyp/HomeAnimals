import java.util.jar.Attributes;

public class NameAnimal <T> extends AddAnimals{
    public T Name;
    public NameAnimal(T animal, T name) {
        super(animal);
        this.Name= name;
    }

    @Override
    public String toString() {
        return " Animal: " + Animal +
                "  Name: "+ Name+ "\n";
    }
}
