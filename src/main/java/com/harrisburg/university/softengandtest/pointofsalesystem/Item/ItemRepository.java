package com.harrisburg.university.softengandtest.pointofsalesystem.Item;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface ItemRepository extends CrudRepository<Item, Id> {

    Item findItemByItemNumber(Long itemNumber);
}
