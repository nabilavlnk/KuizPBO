/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuiz;

/**
 *
 * @author Asus
 */
public class MVC {
    public void Anggota(){
        ViewAnggota viewAnggota = new ViewAnggota();
        Model model = new Model();
        Controller controller = new Controller(model, viewAnggota);
    }
    
    public void Buku(){
        ViewBuku viewBuku = new ViewBuku();
        Model model = new Model();
        Controller controller = new Controller(model, viewBuku);
    }
    
    public void Karyawan(){
        ViewKaryawan viewKaryawan = new ViewKaryawan();
        Model model = new Model();
        Controller controller = new Controller(model, viewKaryawan);
    }
    
    public void Pengembalian(){
        ViewPeminjaman viewPeminjaman = new ViewPeminjaman();
        Model model = new Model();
        Controller controller = new Controller(model, viewPeminjaman);
    }

    
}

