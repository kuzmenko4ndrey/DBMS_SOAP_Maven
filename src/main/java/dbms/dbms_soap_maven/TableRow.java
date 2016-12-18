/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.dbms_soap_maven;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neophron
 */
public class TableRow {

    protected static class Cell<T> {

        private T data;

        protected Cell() {
            data = null;
        }

        protected void set(T newdata) {
            data = newdata;
        }

        protected T get() {
            return data;
        }

    }

    private final ArrayList<Cell> cells;
    private final TableScheme scheme;

    protected static TableRow createRow(String tableScheme, List<Object> data) {
        //ArrayList<Cell> c = new ArrayList<>();
        /*
        some parse shit
        c.add(new Cell<Type>);
         */
//        TableRow r = new TableRow(c);
//        if (r.setData(data)) {
//            return r;
//        } else {
//            return null;
//        }
        return null;
    }

    protected TableRow getClone() {
        ArrayList<Cell> c = new ArrayList<>();
        for (int i = 0; i < cells.size(); i++) {
            c.add(new Cell());
        }
        return new TableRow(c, scheme);
    }

    protected TableRow(ArrayList<Cell> c, TableScheme scheme) {
        cells = c;
        this.scheme = scheme;
    }

    protected boolean setData(List<String> data) {
        for (int i = 0; i < cells.size(); i++) {
            if (scheme.classCastChecker(data.get(i), i) == null) {
                return false;
            }
            cells.get(i).set(scheme.classCastChecker(data.get(i), i));
        }
        return true;
    }
    
    protected ArrayList<String> getData() {
        ArrayList<String> alo = new ArrayList<>();
        for (Cell c : cells) {
            alo.add(c.data.toString());
        }
        return alo;
    }
    
    @Override
    public String toString() {
        String res = "";
        for (Cell c : cells) {
            res += c.data.toString() + ";";
        }
        return res;
    }

    @Override
    public boolean equals(Object tr) {
        try {
            TableRow r = (TableRow) tr;
            for (int i = 0; i < cells.size(); i++) {
                if (!cells.get(i).data.equals(r.cells.get(i).data)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException ex) {
            return false;
        }
    }

}
