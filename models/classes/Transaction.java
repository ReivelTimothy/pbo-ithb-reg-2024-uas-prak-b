package models.classes;

public class Transaction {
    private int id, customer_id, expected_weight, total_cost;
    private String deliver_type, receipt_address, receipt_phone;

    public Transaction(int id, int customer_id, int expected_weight, int total_cost, String deliver_type,
            String receipt_address, String receipt_phone) {
        this.id = id;
        this.customer_id = customer_id;
        this.expected_weight = expected_weight;
        this.total_cost = total_cost;
        this.deliver_type = deliver_type;
        this.receipt_address = receipt_address;
        this.receipt_phone = receipt_phone;
    }

    public Transaction(int customer_id, int expected_weight, int total_cost, String deliver_type,
            String receipt_address, String receipt_phone) {
        this.customer_id = customer_id;
        this.expected_weight = expected_weight;
        this.total_cost = total_cost;
        this.deliver_type = deliver_type;
        this.receipt_address = receipt_address;
        this.receipt_phone = receipt_phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getExpected_weight() {
        return expected_weight;
    }

    public void setExpected_weight(int expected_weight) {
        this.expected_weight = expected_weight;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public String getDeliver_type() {
        return deliver_type;
    }

    public void setDeliver_type(String deliver_type) {
        this.deliver_type = deliver_type;
    }

    public String getReceipt_address() {
        return receipt_address;
    }

    public void setReceipt_address(String receipt_address) {
        this.receipt_address = receipt_address;
    }

    public String getReceipt_phone() {
        return receipt_phone;
    }

    public void setReceipt_phone(String receipt_phone) {
        this.receipt_phone = receipt_phone;
    }

}
