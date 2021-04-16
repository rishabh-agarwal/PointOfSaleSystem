package com.harrisburg.university.softengandtest.pointofsalesystem;

import com.harrisburg.university.softengandtest.pointofsalesystem.Exception.ProcessException;
import com.harrisburg.university.softengandtest.pointofsalesystem.Item.Item;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemTest {


    @Test
    public void given_valid_item_when_isValid_thenReturn_true() throws ProcessException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Item item = new Item();
        item.setSize("Large");
        item.setQty(2);
        item.setBrandName("old navy");
        item.setBuyingPrice(12);
        item.setSold(false);
        item.setColor("red");
        item.setItemName("shirt");
        item.setPurchaseDate(LocalDateTime.now().format(formatter));
        Assert.assertTrue(item.isValid());
    }

    @Test(expected = ProcessException.class)
    public void given_invalid_item_when_missingPurchaseDate_thenReturn_ProcessException() throws ProcessException {
        Item item = new Item();
        item.setSize("Large");
        item.setQty(2);
        item.setBrandName("old navy");
        item.setBuyingPrice(12);
        item.setSold(false);
        item.setColor("red");
        item.setItemName("shirt");
        Assert.assertTrue(item.isValid());
    }

    @Test(expected = ProcessException.class)
    public void given_invalid_item_when_missingPurchaseDateAndQty_thenReturn_ProcessException() throws ProcessException {
        Item item = new Item();
        item.setSize("Large");
        item.setBrandName("old navy");
        item.setBuyingPrice(12);
        item.setSold(false);
        item.setColor("red");
        item.setItemName("shirt");
        Assert.assertTrue(item.isValid());
    }

}
