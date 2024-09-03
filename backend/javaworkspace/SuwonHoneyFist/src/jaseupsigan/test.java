public class ConditionTest {

    public static void main(String[] args) {
        int iterations = 1000000;
        int testValue = 50;

        // Measure time for if-else
        long startTimeIfElse = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            ifElseTest(testValue);
        }
        long endTimeIfElse = System.nanoTime();
        long durationIfElse = endTimeIfElse - startTimeIfElse;
        System.out.println("if-else duration: " + durationIfElse + " ns");

        // Measure time for switch
        long startTimeSwitch = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            switchTest(testValue);
        }
        long endTimeSwitch = System.nanoTime();
        long durationSwitch = endTimeSwitch - startTimeSwitch;
        System.out.println("switch duration: " + durationSwitch + " ns");
    }

    public static void ifElseTest(int value) {
        if (value == 0) {
            // do something
        } else if (value == 1) {
            // do something
        } else if (value == 2) {
            // do something
        } else if (value == 3) {
            // do something
        } else if (value == 4) {
            // do something
        } else if (value == 50) {
            // do something
        } else {
            // default case
        }
    }

    public static void switchTest(int value) {
        switch (value) {
            case 0:
                // do something
                break;
            case 1:
                // do something
                break;
            case 2:
                // do something
                break;
            case 3:
                // do something
                break;
            case 4:
                // do something
                break;
            case 50:
                // do something
                break;
            default:
                // default case
                break;
        }
    }
}
