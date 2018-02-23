package com.company.test.web.item;

import com.company.test.entity.Item;
import com.haulmont.cuba.gui.components.AbstractFrame;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

public class Frame extends AbstractFrame {
    @Inject
    private Datasource<Item> itemDs;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        itemDs.setItem((Item) params.get("item"));
    }
}