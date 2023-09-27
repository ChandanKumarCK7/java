package FunctionalInterface.Function;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

class FunctionImpl implements Function<String, String>{
    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}





public class FunctionExampleWithoutLamda {






    public static void main(String[] args){
        List<String> l = new ArrayList<>(Arrays.asList("alpha", "utyr"));
        ArrayList<String> copyL = new ArrayList<>(l);

        Function<String, String> f = new FunctionImpl();
        l= l.stream().map(f).collect(Collectors.toList());

        System.out.println("Filtered list: " + l+" normal list "+copyL);

    }

}
