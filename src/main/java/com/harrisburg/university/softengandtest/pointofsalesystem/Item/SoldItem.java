package com.harrisburg.university.softengandtest.pointofsalesystem.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SoldItem {

    @Id
    @Column(nullable = false)
    private long itemNumber;

    @Column(nullable = false)
    private float sellingPrice;

    @Column(nullable = false)
    private Integer employeeId;

}
