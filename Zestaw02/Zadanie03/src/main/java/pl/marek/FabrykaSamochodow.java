package pl.marek;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FabrykaSamochodow {

    private List<String> samochody = new ArrayList<>();

    public FabrykaSamochodow() {
        Reflections reflections = new Reflections();
        Set<Class<? extends ISamochod>> classes = reflections.getSubTypesOf(ISamochod.class);
        classes.forEach(c -> samochody.add(c.getSimpleName()));
    }

    public List<String> getSamochody() {
        return samochody;
    }

    public Object createInstance(String name) throws Exception {
        Class<?> clazz = Class.forName(ISamochod.class.getPackage().getName() + "." + name);
        return clazz.getConstructor().newInstance();
    }
}
