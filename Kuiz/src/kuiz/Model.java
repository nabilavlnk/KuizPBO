/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Model {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kuiz";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public Model(){
    try{
    Class.forName(JDBC_DRIVER);
    koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
    System.out.println("Berhasil");
    }
    catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    System.out.println("Koneksi Gagal");    
    }
    }
    
    public void insertAnggota(String nis, String nama, String ttl, String kelamin, String agama, String daftar, String berlaku, String kelas){
    try{
    String query = "INSERT INTO `anggota` (`NIS`, `Nama`, `Ttl`, `Kelamin`, `Agama`, `Daftar`, `Berlaku`, `Kelas`) VALUES ('"+nis+"', '"+nama+"', '"+ttl+"', '"+kelamin+"', '"+agama+"', '"+daftar+"', '"+berlaku+"', '"+kelas+"')";
    statement = (Statement) koneksi.createStatement();
    statement.executeUpdate(query);
    System.out.println("Berhasil Ditambahkan");
    JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }
    catch(Exception sql){
    System.out.println(sql.getMessage());
    JOptionPane.showMessageDialog(null, sql.getMessage());
    }
    }
    
    public String[][] readAnggota(){
    try{
    int jmlData = 0;
    String data[][] = new String[getBanyakDataAnggota()][8];
    String query = "Select * from `anggota`";
    ResultSet resultSet = statement.executeQuery(query);
    while (resultSet.next()){
    data[jmlData][0] = resultSet.getString("NIS");
    data[jmlData][1] = resultSet.getString("Nama");
    data[jmlData][2] = resultSet.getString("Ttl");
    data[jmlData][3] = resultSet.getString("Kelamin");
    data[jmlData][4] = resultSet.getString("Agama");
    data[jmlData][5] = resultSet.getString("Daftar");
    data[jmlData][6] = resultSet.getString("Berlaku");
    data[jmlData][7] = resultSet.getString("Kelas");
    jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
    
    public int getBanyakDataAnggota(){
    int jmlData = 0;
    try{
    statement = koneksi.createStatement();
    String query = "Select * from `anggota`";
    ResultSet resultSet = statement.executeQuery(query);
    while(resultSet.next()){
    jmlData++;
    }
    return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
    }
    }
    
    public void deleteAnggota (String nis){
    try{
    String query = "DELETE FROM `anggota` WHERE `NIS` = '"+nis+"'";
    statement = koneksi.createStatement();
    statement.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }
    
    public int getBanyakDataSearchAnggota(String getSearch){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `anggota` where `NIS` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchAnggota(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchAnggota(getSearch)][8];
        String query="Select * from `anggota` where `NIS` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("NIS : ");
            data[jmlData][1] = resultSet.getString("Nama Anggota : ");
            data[jmlData][2] = resultSet.getString("TTL : ");
            data[jmlData][3] = resultSet.getString("Jenis Kelamin : ");
            data[jmlData][4] = resultSet.getString("Agama : ");
            data[jmlData][5] = resultSet.getString("Tanggal Daftar : ");
            data[jmlData][6] = resultSet.getString("Tanggal Berlaku : ");
            data[jmlData][7] = resultSet.getString("Kelas : ");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

    
    public void insertBuku(String kode, String namabuku, String pengarang, String penerbit, String tahun){
    try{
    String query = "INSERT INTO `buku` (`Kode`, `Namabuku`, `Pengarang`, `Penerbit`, `Tahun`) VALUES ('"+kode+"', '"+namabuku+"', '"+pengarang+"', '"+penerbit+"', '"+tahun+"')";
    statement = (Statement) koneksi.createStatement();
    statement.executeUpdate(query);
    System.out.println("Berhasil Ditambahkan");
    JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }
    catch(Exception sql){
    System.out.println(sql.getMessage());
    JOptionPane.showMessageDialog(null, sql.getMessage());
    }
    }
    
     public String[][] readBuku(){
    try{
    int jmlData = 0;
    String data[][] = new String[getBanyakDataBuku()][5];
    String query = "Select * from `buku`";
    ResultSet resultSet = statement.executeQuery(query);
    while (resultSet.next()){
    data[jmlData][0] = resultSet.getString("Kode");
    data[jmlData][1] = resultSet.getString("Namabuku");
    data[jmlData][2] = resultSet.getString("Pengarang");
    data[jmlData][3] = resultSet.getString("Penerbit");
    data[jmlData][4] = resultSet.getString("Tahun");
    jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
     }
     
    public int getBanyakDataBuku(){
    int jmlData = 0;
    try{
    statement = koneksi.createStatement();
    String query = "Select * from `buku`";
    ResultSet resultSet = statement.executeQuery(query);
    while(resultSet.next()){
    jmlData++;
    }
    return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
    }
    }
    
    public void deleteBuku (String kode){
    try{
    String query = "DELETE FROM `buku` WHERE `Kode` = '"+kode+"'";
    statement = koneksi.createStatement();
    statement.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }
    
    public int getBanyakDataSearchBuku(String getSearch){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `buku` where `Kode` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchBuku(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchBuku(getSearch)][5];
        String query="Select * from `Buku` where `Kode` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("Kode Buku : ");
            data[jmlData][1] = resultSet.getString("Nama Buku : ");
            data[jmlData][2] = resultSet.getString("Pengarang : ");
            data[jmlData][3] = resultSet.getString("Penerbit : ");
            data[jmlData][4] = resultSet.getString("Tahun : ");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

public void insertKaryawan(String nik, String namakaryawan, String jkaryawan, String golongan, String jabatan, String tunjangan, String gaji){
    try{
    String query = "INSERT INTO `karyawan` (`NIK`, `Namakaryawan`, `JKaryawan`, `Golongan`, `Jabatan`, `Tunjangan`, `Gaji`) VALUES ('"+nik+"', '"+namakaryawan+"', '"+jkaryawan+"', '"+golongan+"','"+jabatan+"', '"+tunjangan+"', '"+gaji+"')";
    statement = (Statement) koneksi.createStatement();
    statement.executeUpdate(query);
    System.out.println("Berhasil Ditambahkan");
    JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }
    catch(Exception sql){
    System.out.println(sql.getMessage());
    JOptionPane.showMessageDialog(null, sql.getMessage());
    }
    }

 public String[][] readKaryawan(){
    try{
    int jmlData = 0;
    String data[][] = new String[getBanyakDataKaryawan()][8];
    String query = "Select * from `karyawan`";
    ResultSet resultSet = statement.executeQuery(query);
    while (resultSet.next()){
    data[jmlData][0] = resultSet.getString("NIK");
    data[jmlData][1] = resultSet.getString("Namakaryawan");
    data[jmlData][3] = resultSet.getString("JKaryawan");
    data[jmlData][4] = resultSet.getString("Golongan");
    data[jmlData][5] = resultSet.getString("Jabatan");
    data[jmlData][6] = resultSet.getString("Tunjangan");
    data[jmlData][7] = resultSet.getString("Gaji");
    jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
 
 public int getBanyakDataKaryawan(){
    int jmlData = 0;
    try{
    statement = koneksi.createStatement();
    String query = "Select * from `karyawan`";
    ResultSet resultSet = statement.executeQuery(query);
    while(resultSet.next()){
    jmlData++;
    }
    return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
    }
    }
 
 public void deleteKaryawan (String nik){
    try{
    String query = "DELETE FROM `karyawan` WHERE `NIK` = '"+nik+"'";
    statement = koneksi.createStatement();
    statement.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }
 
 public int getBanyakDataSearchKaryawan(String getSearch){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `karyawan` where `NIK` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchKaryawan(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchKaryawan(getSearch)][8];
        String query="Select * from `karyawan` where `NIK` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("NIK");
            data[jmlData][1] = resultSet.getString("Namakaryawan");
            data[jmlData][3] = resultSet.getString("Jenis Kelamin");
            data[jmlData][4] = resultSet.getString("Golongan");
            data[jmlData][5] = resultSet.getString("Jabatan");
            data[jmlData][6] = resultSet.getString("Tunjangan");
            data[jmlData][7] = resultSet.getString("Gaji");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

public void insertPeminjaman(String nopeminjam, String nis, String nama, String kelas, String kodebuku, String namabuku, String penerbit, String tglpinjam, String tglkembali, String lama, String denda, String petugas, String nik){
    try{
    String query = "INSERT INTO `peminjaman` (`Nopeminjam`, `NIS`, `Nama`, `Kelas`, `Kodebuku`, `Namabuku`, `Penerbit`, `TglPinjam`, `TglKembali`,`Lama`, `Denda`, `Petugas`, `NIK`) VALUES ('"+nopeminjam+"', '"+nis+"', '"+nama+"', '"+kelas+"', '"+kodebuku+"', '"+namabuku+"', '"+penerbit+"', '"+tglpinjam+"', '"+tglkembali+"', '"+lama+"', '"+denda+"', '"+petugas+"', '"+nik+"')";
    statement = (Statement) koneksi.createStatement();
    statement.executeUpdate(query);
    System.out.println("Berhasil Ditambahkan");
    JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }
    catch(Exception sql){
    System.out.println(sql.getMessage());
    JOptionPane.showMessageDialog(null, sql.getMessage());
    }
    }

 public String[][] readPeminjaman(){
    try{
    int jmlData = 0;
    String data[][] = new String[getBanyakDataPeminjaman()][13];
    String query = "Select * from `peminjaman`";
    ResultSet resultSet = statement.executeQuery(query);
    while (resultSet.next()){
    data[jmlData][0] = resultSet.getString("Nopeminjam");
    data[jmlData][1] = resultSet.getString("NIS");
    data[jmlData][2] = resultSet.getString("Nama");
    data[jmlData][3] = resultSet.getString("Kelas");
    data[jmlData][4] = resultSet.getString("Kodebuku");
    data[jmlData][5] = resultSet.getString("Namabuku");
    data[jmlData][6] = resultSet.getString("Penerbit");
    data[jmlData][7] = resultSet.getString("TglPinjam");
    data[jmlData][8] = resultSet.getString("TglKembali");
    data[jmlData][9] = resultSet.getString("Lama");
    data[jmlData][10] = resultSet.getString("Denda");
    data[jmlData][11] = resultSet.getString("Petugas");
    data[jmlData][12] = resultSet.getString("NIK");
    jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
 
 public int getBanyakDataPeminjaman(){
    int jmlData = 0;
    try{
    statement = koneksi.createStatement();
    String query = "Select * from `peminjaman`";
    ResultSet resultSet = statement.executeQuery(query);
    while(resultSet.next()){
    jmlData++;
    }
    return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
    }
    }
 
 public void deletePeminjaman (String nopeminjam){
    try{
    String query = "DELETE FROM `peminjaman` WHERE `Nopeminjam` = '"+nopeminjam+"'";
    statement = koneksi.createStatement();
    statement.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }
 
 public int getBanyakDataSearchPeminjaman(String getSearch){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `peminjaman` where `Nopeminjam` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] searchPeminjaman(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearchKaryawan(getSearch)][13];
        String query="Select * from `peminjaman` where `Nopeminjam` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("No Peminjam : ");
    data[jmlData][1] = resultSet.getString("NIS : ");
    data[jmlData][2] = resultSet.getString("Nama Peminjam : ");
    data[jmlData][3] = resultSet.getString("Kelas : ");
    data[jmlData][4] = resultSet.getString("Kode Buku : ");
    data[jmlData][5] = resultSet.getString("Nama Buku : ");
    data[jmlData][6] = resultSet.getString("Penerbit : ");
    data[jmlData][7] = resultSet.getString("Tanggal Pinjam : ");
    data[jmlData][8] = resultSet.getString("Tanggal Kembali : ");
    data[jmlData][9] = resultSet.getString("Lama Pinjam : ");
    data[jmlData][10] = resultSet.getString("Denda : ");
    data[jmlData][11] = resultSet.getString("Petugas : ");
    data[jmlData][12] = resultSet.getString("NIK Petugas : ");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

    void insertAnggota(String nis, String nama, String ttl, String jeniskel1, String jeniskel2, String agama, String kelas, String tanggal, String berlaku) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
