/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aksno
 */
public class datawisata {
    private Integer Place_Id;
    private String Place_Name;
    private String Description;
    private String Category;
    private String City;
    private String Price;
    private String Rating;
    private String Review;

    public Integer getId() {
        return Place_Id;
    }

    public void setId(Integer Place_Id) {
        this.Place_Id = Place_Id;
    }

    public String getNama() {
        return Place_Name;
    }

    public void setNama(String Place_Name) {
        this.Place_Name = Place_Name;
    }

    public String getDeskripsi() {
        return Description;
    }

    public void setDeskripsi(String Description) {
        this.Description = Description;
    }

    public String getKategori() {
        return Category;
    }

    public void setKategori(String Category) {
        this.Category = Category;
    }

    public String getKota() {
        return City;
    }

    public void setKota(String City) {
        this.City = City;
    }

    public String getHarga() {
        return Price;
    }

    public void setHarga(String Price) {
        this.Price = Price;
    }

    public String getNilai() {
        return Rating;
    }

    public void setNilai(String Rating) {
        this.Rating = Rating;
    }
    
    public String getReview(){
        return Review;
    }
    
    public void getReview(String Review){
        this.Review = Review;
    }


}
