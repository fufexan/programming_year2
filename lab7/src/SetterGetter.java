/*
 * Lab 7, Fufezan Mihai, ex 3
 * 3. Build an application which contains a generic class SetterGetter which
 * allows the user to set() and get() the attribute values for different types
 * of objects. For example, given the classes Kid, Adult and Retired, enable
 * the class to set and get the names and ages of the associated objects.
 * Create collections with unique entries of type Kid, Adult and Retired, and
 * which are populated with data read from the console. Print the read data
 * using different methods.
 */

public class SetterGetter<T2, T1 extends Number, String> {
    public static T2 get(T1 obj, T2 key) {
        return (T2) obj.get(key);
    }

    public static void set(T1 obj, T2 data) {
        obj.set(data);
    }
}
