/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dodaa
 */
public class Account {
    
    private int customerId;
    private List<Purchase> purchases;
    private List<Offer> offersTotal;

    public Account(int customerId, List<Purchase> purchases, List<Offer> offersTotal) throws Exception {
        setCustomerId(customerId);
        setPurchases(purchases);
        setOffersTotal(offersTotal);
    }

    public List<Offer> getOffersTotal() {
        return offersTotal;
    }

    public void setOffersTotal(List<Offer> offersTotal) {
        this.offersTotal = offersTotal;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) throws Exception {
        if (purchases == null)
            throw new Exception("purchases are required");
        this.purchases = purchases;
    }
    
    public List<Purchase> getValidPurchasesAtDate(SmartDate date) {
        List<Purchase> validPurchases = new ArrayList<>();
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).isStillValidAt(date)) {
                validPurchases.add(purchases.get(i));
            }
        }
        return validPurchases;
    }
    
    public Offer getInfoConsoAt(SmartDate date) throws Exception {
        
        List<Purchase> validPurchases = getValidPurchasesAtDate(date);
        Offer cumulated = validPurchases.get(0).getOffer().cumulate(validPurchases.get(1).getOffer());
        for (int i = 2; i < validPurchases.size(); i++) {
            cumulated = cumulated.cumulate(validPurchases.get(i).getOffer());
        }
        return cumulated;
    }
}
