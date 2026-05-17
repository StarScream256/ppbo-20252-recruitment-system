/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class WebDeveloper extends Recruit implements Penilaian {

    public WebDeveloper(String nama, String path, int writing, int coding, int interview) {
        super(nama, path, writing, coding, interview);
    }

    @Override
    public float hitungNilaiAkhir() {
        return (getWriting() + getCoding() + getInterview()) / 3.0f;
    }

    @Override
    public String tentukanStatus() {
        return (hitungNilaiAkhir() >= 85) ? "DITERIMA" : "TIDAK DITERIMA";
    }
}
