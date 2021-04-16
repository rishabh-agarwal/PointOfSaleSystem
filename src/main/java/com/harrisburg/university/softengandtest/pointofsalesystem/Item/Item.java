package com.harrisburg.university.softengandtest.pointofsalesystem.Item;

import com.harrisburg.university.softengandtest.pointofsalesystem.Exception.ProcessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long itemNumber;

    @Column
    private String itemName;

    @Column
    private String brandName;

    @Column
    private int qty;

    @Column
    private String color;

    @Column
    private int employeeId;

    @Column
    private float buyingPrice;

    @Column(nullable = true)
    private float sellingPrice;

    @Column
    private String size;

    @Column
    private String purchaseDate;

    @Column
    private String lastReturnDate;

    @Column
    boolean isSold = false;

    @Column(nullable = true)
    private String sellingDate;

    public boolean isValid() throws ProcessException {

        if(itemName == null){
            throw new ProcessException("Item name cannot be null");
        }
        if(brandName == null){
            throw new ProcessException("brandName cannot be null");
        }
        if(qty == 0){
            throw new ProcessException("qty cannot be null");
        }
        if(color == null){
            throw new ProcessException("color cannot be null");
        }
        if(buyingPrice == 0){
            throw new ProcessException("buyingPrice cannot be null");
        }
        if(size == null){
            throw new ProcessException("size cannot be null");
        }
        if(purchaseDate == null){
            throw new ProcessException("purchaseDate cannot be null");
        }

        return true;
    }
}
