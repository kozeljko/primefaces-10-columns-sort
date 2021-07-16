package org.primefaces.test;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private List<Date> dates;
    private List<ColumnModel> columns;
    private TableModel tableModel;

    @PostConstruct
    public void init() {
        System.out.println("Test");
        string = "Welcome to PrimeFaces!!!";

        // Create columns and dates
        columns = IntStream.range(1, 5).mapToObj(o -> new ColumnModel((long)o, "Column_" + o)).collect(Collectors.toList());
        dates = IntStream.range(1, 5).mapToObj(o -> Instant.now().plus((long)o, ChronoUnit.DAYS)).map(Date::from).collect(Collectors.toList());

        double value = 0.0;
        tableModel = new TableModel(dates);
        for (Date date : dates) {
            for (ColumnModel columnModel : columns) {
                tableModel.addValue(date, columnModel.getKeyId(), value);

                value += 1.0;
            }
        }
    }

    public String getString() {
        return string;
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public TableModel getTableModel() {
        return tableModel;
    }
}
