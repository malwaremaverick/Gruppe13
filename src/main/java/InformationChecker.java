public class InformationChecker {
    public static int controlAge(int age)
    {
        if (age > 120) {
            return 120;
        } else if (age < 0) {
            return 0;
        }
        return age;
    }
}
