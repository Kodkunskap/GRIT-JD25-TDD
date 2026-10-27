package se.apiva;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockTestingExamples {

    @Test
    public void testPlaceOrderWithoutMockito() {

        // Assemble
        OrderService orderService = new OrderService(new InventoryService() {
            @Override
            public Boolean checkAvailability(long productId, int quantity) {
                return true;
            }
        });

        // Act
        Boolean response = orderService.placeOrder(4, 12);

        // Assert
        assertTrue(response);

    }

    @Test
    public void testPlaceOrderWithoutMockitoFunctionInterface() {
        OrderService orderService = new OrderService((prouctidId, quantity) -> true);

        Boolean response = orderService.placeOrder(4, 12);

        assertTrue(response);
    }

    @Test
    public void testOrderServiceCheckAvailability() {

        // 1. Skapa en mock-instans av InventoryService
        InventoryService inventoryService = mock(InventoryService.class);

        // 2. Definiera mockens beteende
        when(inventoryService.checkAvailability(4, 33))
            .thenReturn(true);
        when(inventoryService.checkAvailability(4, 50))
            .thenReturn(false);

        // 3. Skapa en instans av order servicen och injicera mocken
        OrderService orderService = new OrderService(inventoryService);

        // 4. Anropar kod under test och kontrollerar beteendet
        assertTrue(orderService.placeOrder(4, 33));
        assertFalse(orderService.placeOrder(4, 50));

        // 5. Kontrollera att metoder i mocken har blivit anropade
        verify(inventoryService, times(1)).checkAvailability(4, 33);
        verify(inventoryService, times(1)).checkAvailability(4, 50);
        verify(inventoryService, never()).checkAvailability(1, 1);

    }

    @Test
    public void testExceptionFromInventoryService() {
        // Arrange
        InventoryService inventoryService = mock(InventoryService.class);
        doThrow(new RuntimeException("Invalid ID")).when(inventoryService).checkAvailability(-1, 2);
        OrderService orderService = new OrderService(inventoryService);

        // Act && Assert
        assertThrows(
                RuntimeException.class,
                () -> orderService.placeOrder(-1, 2)
        );
    }

    @Test
    public void testAdvancedMockResponseWithdoAnswer() {

        // Arrange
        InventoryService inventoryService = mock(InventoryService.class);
        doAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                long productId = invocationOnMock.getArgument(0);
                int quantity = invocationOnMock.getArgument(1);

                if(productId == 4){
                    return quantity <= 10;
                }

                if(productId == 2) {
                    return quantity <= 3;
                }

                return false;
            }
        }).when(inventoryService).checkAvailability(anyLong(), anyInt());
        OrderService orderService = new OrderService(inventoryService);

        assertTrue(orderService.placeOrder(4, 6));
        assertTrue(orderService.placeOrder(2, 3));
        assertFalse(orderService.placeOrder(4, 11));
        assertFalse(orderService.placeOrder(1, 11));

    }


    @Test
    public void exampleStaticTesting() {

        try(MockedStatic<MathUtil> mockedStaticMathUtils = mockStatic(MathUtil.class)) {

            mockedStaticMathUtils.when(() -> MathUtil.isPrime(7)).thenReturn(true);
            mockedStaticMathUtils.when(() -> MathUtil.isPrime(8)).thenReturn(false);

            assertTrue(MathUtil.isPrime(7));
            assertFalse(MathUtil.isPrime(8));

            mockedStaticMathUtils.verify(() -> MathUtil.isPrime(7), times(1));
            mockedStaticMathUtils.verify(() -> MathUtil.isPrime(8));

        }

    }


}
