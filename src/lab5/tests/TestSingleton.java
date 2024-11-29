package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test; // Use JUnit 5's Test annotation
import lab5.BorrowingServices;

class TestSingleton {
    @Test
    void TestingSingleton() {
        BorrowingServices service1 = BorrowingServices.getInstance();
        BorrowingServices service2 = BorrowingServices.getInstance();
        assertEquals(service1, service2, "Two Singleton instances detected");
    }
}
