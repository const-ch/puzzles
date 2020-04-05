import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class SmoothieMachine {

    final static Map<String,Set> menues = fillMenues();;
    public static final String DELIM_CHAR = ",";
    public static final String EXTRACT_CHAR = "-";

    public static String ingredients(String order) {
        if(order==null)
            throw new IllegalArgumentException();

        String[] orderArgs = order.split(DELIM_CHAR);
        if(orderArgs.length<0)
            throw new IllegalArgumentException();
        String menuName = orderArgs[0];
        if(!menues.containsKey(menuName))
            throw new IllegalArgumentException();

        HashSet<String> addons = new HashSet<>();

        for(int i = 1; i<orderArgs.length;i++){
            String arg = orderArgs[i];
            if(!arg.startsWith(EXTRACT_CHAR)){
                throw new IllegalArgumentException();
            } else {
                addons.add(arg.substring(1));
            }
        }

        Set resultSet = menues.get(menuName);
        resultSet.removeAll(addons);

        if(resultSet.isEmpty())
            return "";


        String result = resultSet.stream().
                sorted((Object s1, Object s2) -> ((String)s1).compareToIgnoreCase((String) s2)).
                collect(Collectors.joining(DELIM_CHAR)).toString();


        return result;
    }

    private static Map<String,Set> fillMenues(){
        HashMap<String,Set> menues = new HashMap<>();
        menues.put("Classic",new HashSet<>(Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")));
        menues.put("Freezie",new HashSet<>(Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")));
        menues.put("Greenie",new HashSet<>(Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")));
        menues.put("Just Desserts",new HashSet<>(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")));
        return menues;
    }

}