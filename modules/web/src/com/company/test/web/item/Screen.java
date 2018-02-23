package com.company.test.web.item;

import com.company.test.entity.Item;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.GridLayout;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Screen extends AbstractWindow {
    @Inject
    private CollectionDatasource<Item, UUID> itemsDs;

    @Inject
    private GridLayout mainGrid;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        itemsDs.refresh();
        int nRows=5;
        int nCols=5;
        mainGrid.setRows(nRows);
        mainGrid.setColumns(nCols);

        int riga=0, colonna=0;
        itemsDs.refresh();

        for (Object entity : itemsDs.getItems()) {
            if ((colonna*riga+colonna)<nRows*nCols) {
                Frame c = (Frame) openFrame(null, "test$Frame", ParamsMap.of("item", entity));

                mainGrid.add(c, colonna, riga);
                if (colonna + 1 > nCols - 1) {
                    colonna = 0;
                    riga++;
                } else
                    colonna++;
            }

        }
    }
}