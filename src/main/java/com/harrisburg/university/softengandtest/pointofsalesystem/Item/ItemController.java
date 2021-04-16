package com.harrisburg.university.softengandtest.pointofsalesystem.Item;

import com.harrisburg.university.softengandtest.pointofsalesystem.Exception.ProcessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method=RequestMethod.GET, value="/items")
    public List<Item> getAllItem() throws ProcessException {
        return itemService.getAllItems();
    }

    @RequestMapping(method=RequestMethod.POST, value="/addItem", headers = "Accept=application/json")
    public Item addItem(@RequestBody Item item){
        System.out.println("Item added successfully!");
        return itemService.addItem(item);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/sellItem", headers = "Accept=application/json")
    public Item sellItem(@RequestBody SoldItem soldItem) throws ProcessException {
        return itemService.sellItem(soldItem);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/returnItem/{itemNumber}", headers = "Accept=application/json")
    public ReturnItem returnItem(@PathVariable int itemNumber) throws ProcessException {
        return itemService.returnItem(itemNumber);
    }

}
