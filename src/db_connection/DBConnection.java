/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package db_connection;
import java.sql.*;

/**
 *
 * @author macbook
 */
public class DBConnection {
    
    private static Connection con = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        connectionDB();
        show();
    }
    
    private static void connectionDB(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e){
        System.err.println("Driver Tidak ditemukan... " +e);
        }
        //Untuk koneksi ke MySQL
        String userid = "root";
        String password = "";
        //silahkan digant url-nya, tapi tergantung nama databasenya
        //formatnya: “jdbc:tipeDatabase://server:port/namaDatabase”
        String url = "jdbc:mysql://localhost:3306/rentalcd";
        try {
        con = DriverManager.getConnection(url, userid,password);
        }catch(SQLException e) {
        System.err.println("DataBase Gak Ada, atau ID/Password gagal " +
        e.getMessage());
        }
        }
    
        private static void show() {
        try {
            Statement stat = con.createStatement();
            ResultSet rSet = stat.executeQuery("SELECT * FROM anggota");

            System.out.println("ISI TABEL anggota :");
            System.out.printf("%-5s %-15s %-30s %-15s\n", "ID", "Nama", "Alamat", "Telp");
            System.out.println("--------------------------------------------------------------");

            while (rSet.next()) {
                String id = rSet.getString("id");
                String nama = rSet.getString("nama");
                String alamat = rSet.getString("alamat");
                String telp = rSet.getString("telp");

                System.out.printf("%-5s %-15s %-30s %-15s\n", id, nama, alamat, telp);
            }

                stat.close();
            } catch (SQLException se) {
                System.out.println("SQL salah: " + se);
            } catch (Exception e) {
                System.out.println("Pesan error: " + e);
    }
}
}
