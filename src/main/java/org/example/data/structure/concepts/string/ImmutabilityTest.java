package org.example.data.structure.concepts.string;

public class ImmutabilityTest {
    private String changingRef = "TEST_STRING";

    public static void main(String[] args) {
        ImmutabilityTest immutabilityTest = new ImmutabilityTest();
        System.out.println("changingRef for TEST_STRING OLD: " + immutabilityTest.changingRef.hashCode());

        immutabilityTest.changingRef = "NEW_TEST_STRING";
        System.out.println("changingRef for NEW_TEST_STRING: " + immutabilityTest.changingRef.hashCode());

        immutabilityTest.changingRef = "TEST_STRING";
        System.out.println("changingRef for TEST_STRING BACK: " + immutabilityTest.changingRef.hashCode());

        immutabilityTest.changingRef = "NEW_TEST_STRING";
        System.out.println("changingRef for NEW_TEST_STRING BACK: " + immutabilityTest.changingRef.hashCode());

        String str = new String("STRING1");
        System.out.println("String Class STRING1 : " + str.hashCode());

        str = new String("STRING2");
        System.out.println("String Class STRING2: " + str.hashCode());

        str = new String("STRING1");
        System.out.println("String Class STRING1 back: " + str.hashCode());

        str = new String("STRING2");
        System.out.println("String Class STRING2 back: " + str.hashCode());

    }
}
