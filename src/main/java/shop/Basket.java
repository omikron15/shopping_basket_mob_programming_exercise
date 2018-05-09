package shop;

import customers.Customer;
import products.Product;
import sun.java2d.loops.CustomComponent;

import java.util.ArrayList;

public class Basket {

    private double total;
    private ArrayList<Product> products;
    private Customer customer;

    public Basket(Customer customer) {
        this.total = 0.0;
        this.products = new ArrayList<>();
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public void addProduct(Product product) {
        this.products.add(product);

    }

    public void removeProduct(Product product) {
        this.products.remove(product);
        calculateTotal();
    }

    public void clearBasket() {
        this.products.clear();
        calculateTotal();
    }

    public void calculateTotal() {
        double runningTotal = 0.0;

        for (Product product : this.products) {
            runningTotal += product.getPrice();
        }

        runningTotal = bogofDiscount(runningTotal);
        runningTotal = tenPercentDiscount(runningTotal);
        runningTotal = twoPercentLoyaltyDiscount(runningTotal, this.customer);

        this.total = runningTotal;

    }

    public double tenPercentDiscount(double runningTotal){
        if(runningTotal > 20.00){
            runningTotal *= 0.9;
        }
        return runningTotal;
    }

    public double twoPercentLoyaltyDiscount(double runningTotal, Customer customer){
        if (customer.hasLoyaltyCard()){
            runningTotal *= 0.98;
        }
        return runningTotal;
    }



    public double bogofDiscount(double runningTotal) {
        ArrayList<Product> copyOfProducts = new ArrayList<>(products);

        double subTotal = 0.0;
        int numberOfProductsToCalculate = getNumberOfProducts();

        if (copyOfProducts.size() > 1 ) {

            for (int counterOne = 0; counterOne < numberOfProductsToCalculate; counterOne++ ) {
                Product tempProduct = copyOfProducts.get(counterOne);

                for (int counterTwo = 1; counterTwo < numberOfProductsToCalculate; counterTwo++) {
                    Product secondTempProduct = copyOfProducts.get(counterTwo);

                    if (tempProduct == secondTempProduct) {
                        copyOfProducts.remove(tempProduct);
                        copyOfProducts.remove(secondTempProduct);
                        numberOfProductsToCalculate -= 2;
                        subTotal += tempProduct.getPrice();
                    }
                }
            }

            for (Product product : copyOfProducts) {
                subTotal += product.getPrice();

            }
            return subTotal;

        } else return runningTotal;

    }


}
