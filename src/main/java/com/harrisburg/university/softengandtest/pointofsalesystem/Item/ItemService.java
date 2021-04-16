package com.harrisburg.university.softengandtest.pointofsalesystem.Item;


import com.harrisburg.university.softengandtest.pointofsalesystem.Employee.Employee;
import com.harrisburg.university.softengandtest.pointofsalesystem.Employee.EmployeeRepository;
import com.harrisburg.university.softengandtest.pointofsalesystem.Exception.ProcessException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Item> getAllItems() throws ProcessException {
        List<Item> items = new ArrayList<>();
        try {
            itemRepository.findAll().forEach(items::add);
        }
        catch (NullPointerException ne){
            throw new ProcessException("Database has no entry");
        }
        return items;
    }

    public Item addItem(Item item){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        item.setPurchaseDate(LocalDateTime.now().format(formatter));
        return itemRepository.save(item);
    }

    public Item sellItem(SoldItem soldItem) throws ProcessException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Employee employee;
        Item item = itemRepository.findItemByItemNumber(soldItem.getItemNumber());
        if(item==null){
            log.error("Unable to find the item, you are trying to sell.");
            throw new ProcessException("Unable to find the item, you are trying to sell.");
        }
        if(soldItem.getSellingPrice()==0)
            throw new ProcessException("Item Selling Price not specified");
        else
            item.setSellingPrice(soldItem.getSellingPrice());

        if(item.getQty()==0)
            throw new ProcessException("Item not available");
        else
            item.setQty(item.getQty()-1);

        item.setSellingDate(LocalDateTime.now().format(formatter));
        item.setLastReturnDate(LocalDateTime.now().plusDays(7).format(formatter));
        item.setSold(true);
        item.setEmployeeId(soldItem.getEmployeeId());
        if(soldItem.getEmployeeId()!=null){
            employee = employeeRepository.findByEmployeeId(soldItem.getEmployeeId());
            employee.setSalesCommission((float) (soldItem.getSellingPrice()*0.02) + employee.getSalesCommission());
        }

        System.out.println("Item Sold, updating inventory.....");
        if(item.getSellingPrice()-item.getBuyingPrice()>0)
            System.out.println("Congratulation, item is sold at profit");
        else
            System.out.println("Item is sold at loss");
        return itemRepository.save(item);
    }

    public ReturnItem returnItem(long itemNumber) throws ProcessException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Item item = itemRepository.findItemByItemNumber(itemNumber);
        ReturnItem returnItem = new ReturnItem();
        if(item==null){
            log.error("Unable to find the item in the database.");
            throw new ProcessException("Unable to find the item in the database.");
        }
        if(LocalDateTime.now().isAfter(LocalDateTime.parse(item.getLastReturnDate(),formatter)))
        {
            log.error("Return Date is already passed.");
            throw new ProcessException("Return Date is already passed.");
        }
        else{
            returnItem.setItemNumber(item.getItemNumber());
            returnItem.setRefundAmount(item.getSellingPrice());

            item.setSold(false);
            item.setQty(item.getQty()+1);
            item.setLastReturnDate(null);
            item.setSellingDate(null);
            itemRepository.save(item);
            log.info("Refunded amount is {}: ", item.getSellingPrice());
        }
        return returnItem;
    }
}
