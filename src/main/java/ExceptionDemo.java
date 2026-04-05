public class ExceptionDemo {

    // ===================== EXCEPTION CLASSES =====================

    static class AppException extends RuntimeException {
        private final int status;
        private final String errorCode;

        public AppException(String message, int status, String errorCode) {
            super(message);
            this.status = status;
            this.errorCode = errorCode;
        }

        public int getStatus() { return status; }
        public String getErrorCode() { return errorCode; }
    }

    static class NotFoundException extends AppException {
        public NotFoundException(String resource, Long id) {
            super(resource + " not found with id: " + id, 404, "NOT_FOUND");
        }
    }

    static class BusinessRuleViolatedException extends AppException {
        public BusinessRuleViolatedException(String rule) {
            super("Business rule violated: " + rule, 409, "BUSINESS_RULE_VIOLATED");
        }
    }

    // ===================== FAKE ORDER =====================

    static class Order {
        private Long id;
        private boolean alreadyProcessed;

        public Order(Long id, boolean alreadyProcessed) {
            this.id = id;
            this.alreadyProcessed = alreadyProcessed;
        }

        public boolean isAlreadyProcessed() { return alreadyProcessed; }
        public Long getId() { return id; }
    }

    // ===================== FAKE REPOSITORY =====================

    static Order findById(Long id) {
        // simulate: order 1 exists, order 2 exists but already processed, order 99 doesn't exist
        if (id == 1) return new Order(1L, false);
        if (id == 2) return new Order(2L, true);
        return null; // not found
    }

    // ===================== SERVICE METHOD =====================

    static Order processOrder(Long orderId) {
        Order order = findById(orderId);

        if (order == null) {
            throw new NotFoundException("Order", orderId);
        }

        if (order.isAlreadyProcessed()) {
            throw new BusinessRuleViolatedException("Order already processed");
        }

        // happy path — just return the order
        System.out.println("Order " + orderId + " processed successfully");
        return order;
    }

    // ===================== FAKE GLOBAL HANDLER =====================

    static void handle(AppException ex) {
        System.out.println("--- Exception caught by handler ---");
        System.out.println("message   : " + ex.getMessage());
        System.out.println("status    : " + ex.getStatus());
        System.out.println("errorCode : " + ex.getErrorCode());
        System.out.println("-----------------------------------");
    }

    // ===================== MAIN =====================

    public static void main(String[] args) {

        // Test 1 — happy path
        System.out.println("=== Test 1: valid order ===");
        try {
            processOrder(1L);
        } catch (AppException ex) {
            handle(ex);
        }

        // Test 2 — order not found
        System.out.println("\n=== Test 2: order not found ===");
        try {
            processOrder(99L);
        } catch (AppException ex) {
            handle(ex);
        }

        // Test 3 — already processed
        System.out.println("\n=== Test 3: already processed ===");
        try {
            processOrder(2L);
        } catch (AppException ex) {
            handle(ex);
        }
    }
}