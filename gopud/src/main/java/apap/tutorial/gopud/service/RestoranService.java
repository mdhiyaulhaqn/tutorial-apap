package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;

public interface RestoranService {

    // Method untuk menambah Restoran
    void addRestoran(RestoranModel restoran);

    // Method untuk mendapatkan semua data Restoran yang tersimpan
    List<RestoranModel> getRestoranList();

    // Method untuk mendapatkan data sebuah Restoran berdasarkan idRestoran
    RestoranModel getRestoranByIdRestoran(String idRestoran);

    //Method untuk menghapus restoran
    RestoranModel deleteRestoranByIdRestoran(String idRestoran);

}
