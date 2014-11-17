import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by liudingyu on 14/11/17.
 */
public class TestItem {

    /**
     * 测试WeakHashmap
     * 注：WeakHashmap会释放只有自己饮用的对象
     */
    public void testWeakHaskmap() {
        TestInnerClass a = new TestInnerClass("aa");
        TestInnerClass b = new TestInnerClass("bb");

        HashMap<TestInnerClass, String> hashMap = new HashMap<TestInnerClass, String>();
        WeakHashMap<TestInnerClass, String> weakHashMap = new WeakHashMap<TestInnerClass, String>();
        hashMap.put(a, "aaa");
        hashMap.put(b, "bbb");

        weakHashMap.put(a, "aaa");
        weakHashMap.put(b, "bbb");

        hashMap.remove(a);
        a = null;
        b = null;

        System.gc();

        for (Object o : hashMap.entrySet()) {
            Map.Entry en = (Map.Entry) o;
            System.out.println("map:" + en.getKey() + ":" + en.getValue());
        }

        for (Object o : weakHashMap.entrySet()) {
            Map.Entry en = (Map.Entry) o;
            System.out.println("weakhashmap:" + en.getKey() + ":" + en.getValue());
        }
    }

    /**
     * 注：Class.newInstance()必须要有一个
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public void testReflection() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String className = TestInnerClass.class.getName();
        System.out.println("Class Name: " + className);
        Class<?> clazz = null;
        clazz = Class.forName(className);

        System.out.println("调用无参");
        Method method = clazz.getMethod("printInfo");
        method.invoke(clazz.newInstance());

        System.out.println("调用无有参");
        method = clazz.getMethod("printInfo", String.class);
        method.invoke(clazz.newInstance(), "有参数");

        System.out.println("调用非空构造函数");
        Constructor constructor = clazz.getConstructor(String.class);
        TestInnerClass class1 = (TestInnerClass) constructor.newInstance("Test");
        class1.printInfo("hello");

    }
}
