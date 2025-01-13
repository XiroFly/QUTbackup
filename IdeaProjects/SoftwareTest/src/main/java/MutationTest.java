// MutationTest.java
public class MutationTest {

    public static void main(String[] args) {
        testMutation();
    }

    private static void testMutation() {
        OriginalClass original = new OriginalClass();

        // Test the original add method
        int result = original.add(2, 3);
        assert result == 5 : "Original add method failed";

        // Test the original isPositive method
        boolean positive = original.isPositive(5);
        assert positive : "Original isPositive method failed";

        // Test the original voidMethod
        original.voidMethod();
        System.out.println("Original void method test passed");
    }
}
