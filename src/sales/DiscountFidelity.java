package sales;

import clients.Category;

public class DiscountFidelity {
    private Category category;
    private double discount;

    public DiscountFidelity(Category category, double discount) {
        this.category = category;
        this.discount = discount;
    }

    public double discount(Category category) {
        switch (category) {
                case GOLD:
                    return 0.2; // 20% discount
                case SILVER:
                    return 0.1; // 10% discount
                case BRONZE:
                    return 0.05; // 5% discount
                default:
                    return 0.0;
        }
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DiscountFidelity{" +
                "category=" + category +
                ", discount=" + discount +
                '}';
    }
}
