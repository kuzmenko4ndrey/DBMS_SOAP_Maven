/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.dbms_soap_maven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Neophron
 */
@WebService(endpointInterface = "dbms.dbms_soap_maven.IDBM")
public class DBM implements IDBM {

    private DB db;

    @Override
    public void createNewDB(String name) {
        db = new DB(name);
    }

    @Override
    public void loadDBFrom(String path) throws FileNotFoundException {
        db = DB.load(path);
    }

    @Override
    public DB getDB() {
        return db;
    }

    @Override
    public void writeHello() {
        System.out.println("Hello");
    }

    @Override
    public boolean addTable(String tname, String[] tscheme) {
        TableScheme ts = new TableScheme();
        for (String se : tscheme) {
            String[] sh = se.split(";");
            ts.add(sh[0], sh[1]);
        }
        return db.addTable(tname, ts);
    }

    @Override
    public void dropTable(String tname) {
        db.dropTable(tname);
    }

    @Override
    public boolean addRow(String tname, String[] data) {
        ArrayList<String> d = new ArrayList<>(Arrays.asList(data));
        return db.addRow(tname, d);
    }

    @Override
    public void deleteRow(String tname, int n) {
        db.deleteRow(tname, n);
    }

    @Override
    public void deleteRepeatedRows(String tname) {
        db.deleteRepeatedRows(tname);
    }

    @Override
    public String[] tableToStringArray(String tname) {
        ArrayList<String> al = db.tableToStringArray(tname);
        String[] res = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }

    @Override
    public String[] getDiffBetwnTabls(String tname1, String tname2) {
        ArrayList<String> al = db.getDiffBetwnTabls(tname1, tname2);
        String[] res = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }

    @Override
    public void save(String path) throws FileNotFoundException, IOException {
        db.save();
    }

    @Override
    public String[] getTableNames() {
        ArrayList<String> al = db.getTableNames();
        String[] res = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }

    @Override
    public String[][] getTableData(String tname) {
        ArrayList<ArrayList<String>> al = db.getTableData(tname);
        String[][] res = new String[al.size()][al.get(0).size()];
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                res[i][j] = al.get(i).get(j);
            }
        }
        return res;
    }

    @Override
    public int getPictureIndex(String tname) {
        return db.getPictureIndex(tname);
    }

}
