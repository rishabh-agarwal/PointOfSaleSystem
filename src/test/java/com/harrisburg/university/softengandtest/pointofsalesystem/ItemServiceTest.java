package com.harrisburg.university.softengandtest.pointofsalesystem;

import com.harrisburg.university.softengandtest.pointofsalesystem.Exception.ProcessException;
import com.harrisburg.university.softengandtest.pointofsalesystem.Item.Item;
import com.harrisburg.university.softengandtest.pointofsalesystem.Item.ItemService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class ItemServiceTest {

    private ItemService itemService = new ItemService();
    private ItemService itemServiceMock = Mockito.mock(ItemService.class);

    @Test(expected = ProcessException.class)
    public void given_noItemInDb_when_getAllItem_then_return_Exception() throws ProcessException {
        List<Item> items = itemService.getAllItems();
    }


}
