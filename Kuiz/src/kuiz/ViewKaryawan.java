/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuiz;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ViewKaryawan extends JFrame{
    JLabel lNIK = new JLabel(" NIK : ");
    JTextField tfNIK = new JTextField();
    JLabel lNamaKry = new JLabel(" Nama Karyawan : ");
    JTextField tfNamaKry = new JTextField();
    JLabel lJenisKel = new JLabel(" Jenis Kelamin : ");
    JRadioButton cbPria = new JRadioButton("Laki-laki ");
    JRadioButton cbWanita = new JRadioButton("Perempuan ");
    JLabel lGolongan = new JLabel(" Golongan : ");
    JTextField tfGolongan = new JTextField();
    JLabel lJabatan = new JLabel(" Jabatan : ");
    JTextField tfJabatan = new JTextField();
    JLabel lTunjangan  = new JLabel(" Tunjangan : ");
    JTextField tfTunjangan = new JTextField();
    JLabel lGaji = new JLabel(" Gaji : ");
    JTextField tfGaji = new JTextField();
    JButton btnRefresh = new JButton(" REFRESH ");
    JButton btnSimpan = new JButton(" SIMPAN ");
    JButton btnHapus = new JButton(" HAPUS ");
    JButton btnKeluar = new JButton(" KELUAR ");
    JButton btnCari = new JButton(" CARI ");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIK","Nama","Jenis Kelamin","Golongan","Jabatan","Tunjangan", "Gaji"};
    
    public ViewKaryawan(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable (tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800,650);
        
        add(lNIK);
        lNIK.setBounds(10,30,300,20);
        add(tfNIK);
        tfNIK.setBounds(200,30,200,20);
        add(lNamaKry);
        lNamaKry.setBounds(10,60,300,20);
        add(tfNamaKry);
        tfNamaKry.setBounds(200,60,200,20);
        add(lJenisKel);
        lJenisKel.setBounds(10,90,300,20);
        add(cbPria);
        cbPria.setBounds(200,90,100,20);
        add(cbWanita);
        cbWanita.setBounds(300,90,100,20);
        add(lGolongan);
        lGolongan.setBounds(10,120,300,20);
        add(tfGolongan);
        tfGolongan.setBounds(200,120,200,20);
        add(lJabatan);
        lJabatan.setBounds(10,150,300,20);
        add(tfJabatan);
        tfJabatan.setBounds(200,150,200,20);
        add(lTunjangan);
        lTunjangan.setBounds(10,180,300,20);
        add(tfTunjangan);
        tfTunjangan.setBounds(200,180,200,20);
        add(lGaji);
        lGaji.setBounds(10,210,300,20);
        add(tfGaji);
        tfGaji.setBounds(200,210,200,20);      
        add(btnRefresh);
        btnRefresh.setBounds(500,100,100,20);
        add(btnSimpan);
        btnSimpan.setBounds(630,100,100,20);
        add(btnHapus);
        btnHapus.setBounds(500,150,100,20);
        add(btnKeluar);
        btnKeluar.setBounds(630,150,100,20);
        add(btnCari);
        btnCari.setBounds(565,200,100,20);
        
        add(scrollPane);
        scrollPane.setBounds(20,270,650,180);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setVisible(true);
    }
    
    public String getNIK(){
        return tfNIK.getText();
    }
    public String getNamaKry(){
        return tfNamaKry.getText();
    }
    public String getJenisKel(){
        if(cbPria.isSelected())
            return cbPria.getText();
        else if(cbWanita.isSelected())
            return cbWanita.getText();
        else
            return null;
    }
    public String getGolongan(){
        return tfGolongan.getText();
    }
    public String getJabatan(){
        return tfJabatan.getText();
    }
    public String getTunjangan(){
        return tfTunjangan.getText();
    }
    public String getGaji(){
        return tfGaji.getText();
    }

}
