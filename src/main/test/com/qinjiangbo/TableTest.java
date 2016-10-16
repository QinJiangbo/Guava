package com.qinjiangbo;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

/**
 * Date: 16/10/2016
 * Author: qinjiangbo@github.io
 */
public class TableTest {

    @Test
    public void testTable() {
        Table<String, Integer, String> table = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                table.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        System.out.println(table.column(2));
        System.out.println(table.row("B"));
        System.out.println(table.get("B", 2));

        System.out.println(table.contains("D", 1));
        System.out.println(table.containsColumn(3));
        System.out.println(table.containsRow("C"));
        System.out.println(table.columnMap());
        System.out.println(table.rowMap());
    }
}
