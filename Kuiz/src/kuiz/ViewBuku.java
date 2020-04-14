/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuiz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewBuku extends JFrame {
    JLabel lKode = new JLabel(" Kode Buku : ");
    JTextField tfKode = new JTextField();
    JLabel lNamaBuku = new JLabel(" Nama Buku : ");
    JTextField tfNamaBuku = new JTextField();
    JLabel lPengarang = new JLabel(" Pengarang : ");
    JTextField tfPengarang = new JTextField();
    JLabel lPenerbit = new JLabel(" Penerbit : ");
    JTextField tfPenerbit = new JTextField();
    JLabel lTahun = new JLabel(" Tahun : ");
    JTextField tfTahun = new JTextField();
    JButton btnRefresh = new JButton(" REFRESH ");
    JButton btnSimpan = new JButton(" SIMPAN ");
    JButton btnCari = new JButton(" CARI ");
    JTextField tfSearch = new JTextField();
    JButton btnHapus = new JButton(" HAPUS ");
    JButton btnKeluar = new JButton(" KELUAR ");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode Buku","Nama Buku","Pengarang","Penerbit","Tahun"};
    
    public ViewBuku(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800,550);
        
        add(lKode);
        lKode.setBounds(10,30,300,20);
        add(tfKode);
        tfKode.setBounds(200,30,200,20);
        add(lNamaBuku);
        lNamaBuku.setBounds(10,60,300,20);
        add(tfNamaBuku);
        tfNamaBuku.setBounds(200,60,200,20);
        add(lPengarang);
        lPengarang.setBounds(10,90,300,20);
        add(tfPengarang);
        tfPengarang.setBounds(200,90,200,20);
        add(lPenerbit);
        lPenerbit.setBounds(10,120,300,20);
        add(tfPenerbit);
        tfPenerbit.setBounds(200,120,200,20);
        add(lTahun);
        lTahun.setBounds(10,150,300,20);
        add(tfTahun);
        tfTahun.setBounds(200,150,200,20);
        add(btnRefresh);
        btnRefresh.setBounds(500,100,100,20);
        add(btnSimpan);
        btnSimpan.setBounds(610,100,100,20);
        add(btnHapus);
        btnHapus.setBounds(500,150,100,20);
        add(btnKeluar);
        btnKeluar.setBounds(610,150,100,20);
        add(btnCari);
        btnCari.setBounds(500,200,100,20);
        add(tfSearch);
        tfSearch.setBounds(610,200,100,20);
        
        
        add(scrollPane);
        scrollPane.setBounds(10,250,650,180);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setVisible(true);
    }
    
    public String getKode(){
        return tfKode.getText();
    }
    public String getNamaBuku(){
        return tfNamaBuku.getText();
    }
    public String getPengarang(){
        return tfPengarang.getText();
    }
    public String getPenerbit(){
        return tfPenerbit.getText();
    }
    public String getTahun(){
        return tfTahun.getText();
    }
    public String getSearch(){
       return tfSearch.getText();
   }
    
}
