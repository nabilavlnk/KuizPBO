/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuiz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class Controller {
    
    //Model model;
    //viewAnggota anggota;
    //viewBuku buku;
    //viewKaryawan karyawan;
    //viewPengembalian kembali;
    
    Model model;
    ViewAnggota viewAnggota;
    ViewKaryawan viewKaryawan;
    ViewBuku viewBuku;
    ViewPeminjaman viewPeminjaman;
    
    public Controller(Model model, ViewAnggota viewAnggota){
    this.model = model;
    this.viewAnggota = viewAnggota;
    
    if(model.getBanyakDataAnggota()!=0){
    String dataAnggota[][] = model.readAnggota();
    viewAnggota.tabel.setModel((new JTable(dataAnggota, viewAnggota.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewAnggota.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewAnggota.getNis().equals("")
            || viewAnggota.getNama().equals("")
            || viewAnggota.getTTL().equals("")
            || viewAnggota.getJenisKel().equals("")
            || viewAnggota.getAgama().equals("")
            || viewAnggota.getKelas().equals("")
            || viewAnggota.getTanggal().equals("")
            || viewAnggota.getBerlaku().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String nis = viewAnggota.getNis();
    String nama = viewAnggota.getNama();
    String ttl = viewAnggota.getTTL();
    String jeniskel = viewAnggota.getJenisKel();
    String agama = viewAnggota.getAgama();
    String kelas = viewAnggota.getKelas();
    String tanggal = viewAnggota.getTanggal();
    String berlaku = viewAnggota.getBerlaku();
    
    model.insertAnggota(nis,nama,ttl,jeniskel,agama,kelas,tanggal,berlaku);
    viewAnggota.tfNis.setText("");
    viewAnggota.tfNama.setText("");
    viewAnggota.tfTTL.setText("");
    viewAnggota.cmbAgama.setSelectedItem("");
    viewAnggota.tfKelas.setText("");
    viewAnggota.tfTanggal.setText("");
    viewAnggota.tfBerlaku.setText("");
    
    String dataAnggota[][] = model.readAnggota();
    viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
    }
    }
    });
    
    viewAnggota.btnRefresh.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataAnggota[][] = model.readAnggota();
            viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
                
            viewAnggota.tfNis.setText(null);
            viewAnggota.tfNama.setText(null);
            viewAnggota.tfTTL.setText(null);
            viewAnggota.cbPria.setText(null);
            viewAnggota.cbWanita.setText(null);
            viewAnggota.cmbAgama.setSelectedItem(null);
            viewAnggota.tfKelas.setText(null);
            viewAnggota.tfTanggal.setText(null);
            viewAnggota.tfBerlaku.setText(null);
        }
    });
    
    viewAnggota.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewAnggota.tabel.getSelectedRow();
                int kolom = viewAnggota.tabel.getSelectedColumn();
                String dataterpilih = viewAnggota.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus NIS "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    model.deleteAnggota(dataterpilih);
                    String dataAnggota[][] = model.readAnggota();
                    viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
    
    viewAnggota.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
    
    }
    public Controller(Model model, ViewBuku viewBuku){
    this.model = model;
    this.viewBuku = viewBuku;
    
    if(model.getBanyakDataBuku()!=0){
    String dataBuku[][] = model.readBuku();
    viewBuku.tabel.setModel((new JTable(dataBuku, viewBuku.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewBuku.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewBuku.getKode().equals("")
            || viewBuku.getNamaBuku().equals("")
            || viewBuku.getPengarang().equals("")
            || viewBuku.getPenerbit().equals("")
            || viewBuku.getTahun().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String kode = viewBuku.getKode();
    String namabuku = viewBuku.getNamaBuku();
    String pengarang = viewBuku.getPengarang();
    String penerbit = viewBuku.getPenerbit();
    String tahun = viewBuku.getTahun();
    
    model.insertBuku(kode,namabuku,pengarang,penerbit,tahun);
    viewBuku.tfKode.setText("");
    viewBuku.tfNamaBuku.setText("");
    viewBuku.tfPengarang.setText("");
    viewBuku.tfPenerbit.setText("");
    viewBuku.tfTahun.setText("");
    
    String dataBuku[][] = model.readBuku();
    viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
    }
    }
    });
    
    viewBuku.btnRefresh.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataBuku[][] = model.readBuku();
            viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
                
            viewBuku.tfKode.setText(null);
            viewBuku.tfNamaBuku.setText(null);
            viewBuku.tfPengarang.setText(null);
            viewBuku.tfPenerbit.setText(null);
            viewBuku.tfTahun.setText(null);
        }
    });
    
    viewBuku.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewBuku.tabel.getSelectedRow();
                int kolom = viewBuku.tabel.getSelectedColumn();
                String dataterpilih = viewBuku.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus Kode "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    model.deleteBuku(dataterpilih);
                    String dataBuku[][] = model.readBuku();
                    viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
    
    viewBuku.btnCari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewBuku.getSearch();
                String dataBuku[][] = model.searchBuku(getSearch);
                    viewBuku.tabel.setModel(new JTable (dataBuku, viewBuku.namaKolom).getModel());
                 }
        }); 
    viewBuku.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
}
    
    public Controller(Model model, ViewKaryawan viewKaryawan){
    this.model = model;
    this.viewKaryawan = viewKaryawan;
    
    if(model.getBanyakDataKaryawan()!=0){
    String dataKaryawan[][] = model.readKaryawan();
    viewKaryawan.tabel.setModel((new JTable(dataKaryawan, viewKaryawan.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewKaryawan.tfGolongan.addKeyListener(new KeyAdapter(){
          @Override
          public void keyPressed(KeyEvent e){
              if(e.getKeyCode() == KeyEvent.VK_ENTER){
                  if(viewKaryawan.getGolongan().equals("1")){
                      String jabatan = "Ketua";
                      viewKaryawan.tfJabatan.setText(jabatan);
                      String tunjangan = "500.000";
                      viewKaryawan.tfTunjangan.setText(tunjangan);
                      String gaji = "1.000.000";
                      viewKaryawan.tfGaji.setText(gaji);
                  }
                  else if(viewKaryawan.getGolongan().equals("2")){
                      String jabatan = "Wakil Ketua";
                      viewKaryawan.tfJabatan.setText(jabatan);
                      String tunjangan = "300.000";
                      viewKaryawan.tfTunjangan.setText(tunjangan);
                      String gaji = "700.000";
                      viewKaryawan.tfGaji.setText(gaji);
                  }
                  else {
                      String jabatan = "Magang";
                      viewKaryawan.tfJabatan.setText(jabatan);
                      String tunjangan = "0";
                      viewKaryawan.tfTunjangan.setText(tunjangan);
                      String gaji = "500.000";
                      viewKaryawan.tfGaji.setText(gaji);
                  }
                  String jabatan = viewKaryawan.tfJabatan.getText();
                  String tunjangan = viewKaryawan.tfTunjangan.getText();
                  String gaji = viewKaryawan.tfGaji.getText();
            } 
          }
       });
    
    viewKaryawan.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewKaryawan.tabel.getSelectedRow();
                int kolom = viewKaryawan.tabel.getSelectedColumn();
                String dataterpilih = viewKaryawan.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus NIK "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    model.deleteKaryawan(dataterpilih);
                    String dataKaryawan[][] = model.readKaryawan();
                    viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });

   viewKaryawan.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewKaryawan.getNIK().equals("")
            || viewKaryawan.getNamaKry().equals("")
            || viewKaryawan.getJenisKel().equals("")
            || viewKaryawan.getGolongan().equals("")
            || viewKaryawan.getJabatan().equals("")
            || viewKaryawan.getTunjangan().equals("")
            || viewKaryawan.getGaji().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String nik = viewKaryawan.getNIK();
    String namakry = viewKaryawan.getNamaKry();
    String jenkelkry = viewKaryawan.getJenisKel();
    String golongan = viewKaryawan.getGolongan();
    String jabatan = viewKaryawan.getJabatan();
    String tunjangan = viewKaryawan.getTunjangan();
    String gaji = viewKaryawan.getGaji();
    
    model.insertKaryawan(nik,namakry,jenkelkry,golongan,jabatan,tunjangan,gaji);
    viewKaryawan.tfNIK.setText("");
    viewKaryawan.tfNamaKry.setText("");
    viewKaryawan.tfGolongan.setText("");
    viewKaryawan.tfJabatan.setText("");
    viewKaryawan.tfTunjangan.setText("");
    viewKaryawan.tfGaji.setText("");
    
    String dataKaryawan[][] = model.readKaryawan();
    viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
    }
    }
    });
   
   viewKaryawan.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
   
    }
    
   public Controller(Model model, ViewPeminjaman viewPeminjaman){
    this.model = model;
    this.viewPeminjaman = viewPeminjaman;
    
    if(model.getBanyakDataPeminjaman()!=0){
    String dataPeminjaman[][] = model.readPeminjaman();
    viewPeminjaman.tabel.setModel((new JTable(dataPeminjaman, viewPeminjaman.namaKolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewPeminjaman.btnSimpan.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewPeminjaman.getNo().equals("")
            || viewPeminjaman.getNis().equals("")
            || viewPeminjaman.getNama().equals("")
            || viewPeminjaman.getKelas().equals("")
            || viewPeminjaman.getKode().equals("")
            || viewPeminjaman.getNamaBuku().equals("")
            || viewPeminjaman.getPenerbit().equals("")
            || viewPeminjaman.getTglPinjam().equals("")
            || viewPeminjaman.getTglKembali().equals("")
            || viewPeminjaman.getLama().equals("")
            || viewPeminjaman.getDenda().equals("")
            || viewPeminjaman.getPetugas().equals("")
            || viewPeminjaman.getNIK().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String no = viewPeminjaman.getNo();
    String nis = viewPeminjaman.getNis();
    String nama = viewPeminjaman.getNama();
    String kelas = viewPeminjaman.getKelas();
    String kode = viewPeminjaman.getKode();
    String namabuku = viewPeminjaman.getNamaBuku();
    String penerbit = viewPeminjaman.getPenerbit();
    String tglpinjam = viewPeminjaman.getTglPinjam();
    String tglkembali = viewPeminjaman.getTglKembali();
    String lama = viewPeminjaman.getLama();
    String denda = viewPeminjaman.getDenda();
    String petugas = viewPeminjaman.getPetugas();
    String nik = viewPeminjaman.getNIK();
    
    model.insertPeminjaman(no,nis,nama,kelas,kode,namabuku,penerbit,tglpinjam,tglkembali,lama,denda,petugas,nik);
    viewPeminjaman.tfNo.setText("");
    viewPeminjaman.tfNis.setText("");
    viewPeminjaman.tfKelas.setText("");
    viewPeminjaman.tfKode.setText("");
    viewPeminjaman.tfNamaBuku.setText("");
    viewPeminjaman.tfPenerbit.setText("");
    viewPeminjaman.tfTglPinjam.setText("");
    viewPeminjaman.tfTglKembali.setText("");
    viewPeminjaman.tfLama.setText("");
    viewPeminjaman.tfDenda.setText("");
    viewPeminjaman.tfPetugas.setText("");
    viewPeminjaman.tfNIK.setText("");
    
    String dataPeminjaman[][] = model.readPeminjaman();
    viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
    }
    }
    });
    
    viewPeminjaman.btnRefresh.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataPeminjaman[][] = model.readPeminjaman();
            viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
                
            viewPeminjaman.tfNo.setText(null);
            viewPeminjaman.tfNis.setText(null);
            viewPeminjaman.tfKelas.setText(null);
            viewPeminjaman.tfKode.setText(null);
            viewPeminjaman.tfNamaBuku.setText(null);
            viewPeminjaman.tfPenerbit.setText(null);
            viewPeminjaman.tfTglPinjam.setText(null);
            viewPeminjaman.tfTglKembali.setText(null);
            viewPeminjaman.tfLama.setText(null);
            viewPeminjaman.tfDenda.setText(null);
            viewPeminjaman.tfPetugas.setText(null);
            viewPeminjaman.tfNIK.setText(null);
        }
    });
    
    viewPeminjaman.btnHapus.addActionListener((ActionEvent e) -> {
           
                int baris = viewPeminjaman.tabel.getSelectedRow();
                int kolom = viewPeminjaman.tabel.getSelectedColumn();
                String dataterpilih = viewPeminjaman.tabel.getValueAt(baris, 0).toString();
                
                System.out.println(dataterpilih);
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus No "+dataterpilih+ "?"," Pilih Opsi", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0){
                    model.deletePeminjaman(dataterpilih);
                    String dataPeminjaman[][] = model.readPeminjaman();
                    viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Hapus");
                }
        });
    
    viewPeminjaman.btnKeluar.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
}
  
}
