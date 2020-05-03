import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Test {

    Integer a;
    public static void main(String args[]) throws IllegalAccessException {
        BigDecimal b = new BigDecimal("0");
        Test t = new Test();
        t.a = 10;
        System.out.println(test(b,0,t));
        System.out.println(b.hashCode());

    }

    public static Integer test(BigDecimal b, Integer a, Object o) throws IllegalAccessException {
        for(Field field : o.getClass().getDeclaredFields()){
            if(0 < (Integer) field.get(o)) {
                System.out.println((Integer) field.get(o));
                b = b.add(new BigDecimal(((Integer) field.get(o))));
                System.out.println(b.hashCode());
            }else a++;
        }
        return a;
    }
}
