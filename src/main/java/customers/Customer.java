package customers;

import java.util.ArrayList;

public class Customer {

    private ArrayList<LoyaltyCard> loyaltyCard;

    public Customer() {
        this.loyaltyCard = new ArrayList<>();
    }

    public boolean hasLoyaltyCard() {
        return (loyaltyCard.size() > 0);
    }
}
