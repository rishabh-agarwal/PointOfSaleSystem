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
public class ReturnItem {

    @Id
    @Column(nullable = false)
    private long itemNumber;

    @Column(nullable = false)
    private float refundAmount;

}
