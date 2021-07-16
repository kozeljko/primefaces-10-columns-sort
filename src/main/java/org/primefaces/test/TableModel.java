package org.primefaces.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableModel {

    private List<Date> dates;
    private Map<Date, Map<Long, Double>> rows = new HashMap<>();

    public TableModel(List<Date> dates) {
        this.dates = dates;
    }

    public Double getValue(Date rowKey, Long columnKey) {
        if (rowKey == null) {
            System.out.println("Row key is null.");
        }

        Map<Long, Double> row = getRow(rowKey);
        return row == null ? null : row.get(columnKey);
    }

    public Map<Long, Double> getRow(Date rowKey) {
        return rows.get(rowKey);
    }

    public void addValue(Date date, Long columnModel, Double value) {
        Map<Long, Double> row = rows.computeIfAbsent(date, o -> new HashMap<>());
        row.put(columnModel, value);
    }

    public List<Date> getDates() {
        return dates;
    }
}
