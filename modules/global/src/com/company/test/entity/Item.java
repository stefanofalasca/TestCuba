package com.company.test.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "TEST_ITEM")
@Entity(name = "test$Item")
public class Item extends StandardEntity {
    private static final long serialVersionUID = 6383036886961644486L;

    @Column(name = "TEST1")
    protected String test1;

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest1() {
        return test1;
    }


}