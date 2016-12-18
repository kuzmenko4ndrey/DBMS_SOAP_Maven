/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.dbms_soap_maven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Neophron
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IDBM {

    @WebMethod
    void createNewDB(String name);

    @WebMethod
    DB getDB();

    @WebMethod
    void loadDBFrom(String path) throws FileNotFoundException;

    @WebMethod
    public void writeHello();

    @WebMethod
    public boolean addTable(String tname, String[] tscheme);

    @WebMethod
    public void dropTable(String tname);

    @WebMethod
    public boolean addRow(String tname, String[] data);

    @WebMethod
    public void deleteRow(String tname, int n);

    @WebMethod
    public void deleteRepeatedRows(String tname);

    @WebMethod
    public String[] tableToStringArray(String tname);

    @WebMethod
    public String[] getDiffBetwnTabls(String tname1, String tname2);

    @WebMethod
    public void save(String path) throws FileNotFoundException, IOException;

    @WebMethod
    public String[] getTableNames();

    @WebMethod
    public String[][] getTableData(String tname);

    @WebMethod
    public int getPictureIndex(String tname);

}
