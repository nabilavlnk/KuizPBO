/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Kuiz {
    public static void main(String[] args) {
        GUI g = new GUI();       
     
    }
}

class GUI extends JFrame {
   //final JTextField fnama = new JTextField(10);
   //final JPasswordField fpass = new JPasswordField(10);
   
   JButton btnAnggota = new JButton(" INPUT ANGGOTA ");
   JButton btnBuku = new JButton(" INPUT BUKU ");
   JButton btnKaryawan = new JButton(" INPUT KARYAWAN ");
   JButton btnPeminjaman = new JButton(" INPUT PEMINJAMAN ");

public GUI() {
setTitle("Login");
	setDefaultCloseOperation(3);
	setSize(700,400);
        setLocation(500,275);
setLayout(null);
add(btnAnggota);
btnAnggota.setBounds(20,20,250,70);
add(btnBuku);
btnBuku.setBounds(400,20,250,70);
add(btnKaryawan);
btnKaryawan.setBounds(20,100,250,70);
add(btnPeminjaman);
btnPeminjaman.setBounds(400,100,250,70);

        
        btnAnggota.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
    MVC mvc = new MVC();
    mvc.Anggota();
    dispose();

        }
   });
        btnBuku.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
    MVC mvc = new MVC();
    mvc.Buku();
    dispose();

        }
   });
        
        btnKaryawan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
    MVC mvc = new MVC();
    mvc.Karyawan();
    dispose();

        }
   });
        
         btnPeminjaman.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
    MVC mvc = new MVC();
    mvc.Pengembalian();
    dispose();

        }
   });
        
        
        setVisible(true);
}
}
