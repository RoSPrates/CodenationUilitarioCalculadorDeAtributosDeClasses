import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Test {
    BigDecimal b;

    public static void main(String args[]) throws IllegalAccessException {
        AnotherTest anotherTest = new AnotherTest();
        Test t = new Test();
        t.b = new BigDecimal("0");
        anotherTest.setA(10);
        System.out.println(t.test(t, 0, anotherTest));
        System.out.println(t.b);
        BigDecimal big1 = BigDecimal.ZERO;
        BigDecimal big2 = new BigDecimal("10");
        System.out.println(big1 == big2);
        System.out.println(big1.subtract(big2));

    }

    public Integer test(Test t, Integer a, Object o) throws IllegalAccessException {
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (0 < (Integer) field.get(o)) {
                System.out.println((Integer) field.get(o));
                t.b = b.add(new BigDecimal(((Integer) field.get(o))));
                System.out.println(b);
            } else a++;
        }
        return a;
    }
}
