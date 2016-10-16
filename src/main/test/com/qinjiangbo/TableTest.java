package com.qinjiangbo;

import com.google.common.collect.*;
import org.junit.Test;

/**
 * Date: 16/10/2016
 * Author: qinjiangbo@github.io
 */
public class TableTest {

    @Test
    public void testHashTable() {
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

    @Test
    public void testArrayTable() {
        Table<String, Integer, String> table = ArrayTable.create(Lists.newArrayList("A", "B", "C"), Lists.newArrayList(1, 2, 3));
        table.put("A", 2, "A2");
        table.put("B", 1, "B1");
        System.out.println(table.column(2));
        System.out.println(table.row("B"));
    }

    @Test
    public void testTreeBasedTable() {
        Table<String, Integer, String> table = TreeBasedTable.create();
        table.put("A", 1, "A");
        table.put("C", 1, "E");
        table.put("B", 1, "D");
        System.out.println(table.column(1));
        System.out.println(table.row("C"));
    }

}
