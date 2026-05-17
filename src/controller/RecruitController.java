/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AndroidDeveloper;
import model.Recruit;
import model.RecruitDAO;
import model.WebDeveloper;
import view.RecruitView;

/**
 *
 * @author asus
 */
public class RecruitController {
    private RecruitView view;
    private RecruitDAO dao;
    private int selectedId = -1;

    public RecruitController(RecruitView view, RecruitDAO dao) {
        this.view = view;
        this.dao = dao;

        loadTableData();

        this.view.getAddButton().addActionListener(e -> insertData());
        this.view.getUpdateButton().addActionListener(e -> updateData());
        this.view.getDeleteButton().addActionListener(e -> deleteData());
        this.view.getClearButton().addActionListener(e -> {
            this.view.clearForm();
            selectedId = -1;
        });

        this.view.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.getTable().getSelectedRow();
                if (row != -1) {
                    selectedId = Integer.parseInt(view.getTable().getValueAt(row, 0).toString());
                    view.getNamaTextField().setText(view.getTable().getValueAt(row, 1).toString());
                    view.getPathComboBox().setSelectedItem(view.getTable().getValueAt(row, 2).toString());
                    view.getWritingTextField().setText(view.getTable().getValueAt(row, 3).toString());
                    view.getCodingTextField().setText(view.getTable().getValueAt(row, 4).toString());
                    view.getInterviewTextField().setText(view.getTable().getValueAt(row, 5).toString());
                }
            }
        });
    }

    private void loadTableData() {
        DefaultTableModel model = view.getTableModel();
        model.setRowCount(0);

        List<Recruit> list = dao.index();
        for (Recruit r : list) {
            Object[] rowData = {
                r.getId(),
                r.getNama(),
                r.getPath(),
                r.getWriting(),
                r.getCoding(),
                r.getInterview(),
                r.getScore(),
                r.getStatus()
            };
            model.addRow(rowData);
        }
    }

    private void insertData() {
        try {
            String nama = view.getNamaTextField().getText();
            String path = view.getPathComboBox().getSelectedItem().toString();
            
            if (nama.trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int writing = Integer.parseInt(view.getWritingTextField().getText());
            int coding = Integer.parseInt(view.getCodingTextField().getText());
            int interview = Integer.parseInt(view.getInterviewTextField().getText());

            float score = 0;
            String status = "";
            
            if (path.equals("Android Developer")) {
                AndroidDeveloper ad = new AndroidDeveloper(nama, path, writing, coding, interview);
                score = ad.hitungNilaiAkhir();
                status = ad.tentukanStatus();
            } else {
                WebDeveloper wd = new WebDeveloper(nama, path, writing, coding, interview);
                score = wd.hitungNilaiAkhir();
                status = wd.tentukanStatus();
            }

            Recruit recruit = new Recruit();
            recruit.setNama(nama);
            recruit.setPath(path);
            recruit.setWriting(writing);
            recruit.setCoding(coding);
            recruit.setInterview(interview);
            recruit.setScore(score);
            recruit.setStatus(status);

            dao.create(recruit);

            JOptionPane.showMessageDialog(view, "Data berhasil ditambahkan!");
            view.clearForm();
            loadTableData();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Pastikan nilai berupa angka bulat!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateData() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(view, "Pilih baris data di tabel terlebih dahulu!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String nama = view.getNamaTextField().getText();
            String path = view.getPathComboBox().getSelectedItem().toString();
            
            if (nama.trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int writing = Integer.parseInt(view.getWritingTextField().getText());
            int coding = Integer.parseInt(view.getCodingTextField().getText());
            int interview = Integer.parseInt(view.getInterviewTextField().getText());

            float score = 0;
            String status = "";
            
            if (path.equals("Android Developer")) {
                AndroidDeveloper ad = new AndroidDeveloper(nama, path, writing, coding, interview);
                score = ad.hitungNilaiAkhir();
                status = ad.tentukanStatus();
            } else {
                WebDeveloper wd = new WebDeveloper(nama, path, writing, coding, interview);
                score = wd.hitungNilaiAkhir();
                status = wd.tentukanStatus();
            }

            Recruit recruit = new Recruit();
            recruit.setId(selectedId);
            recruit.setNama(nama);
            recruit.setPath(path);
            recruit.setWriting(writing);
            recruit.setCoding(coding);
            recruit.setInterview(interview);
            recruit.setScore(score);
            recruit.setStatus(status);
            
            dao.update(recruit);

            JOptionPane.showMessageDialog(view, "Data berhasil diperbarui!");
            view.clearForm();
            selectedId = -1;
            loadTableData();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Pastikan nilai berupa angka bulat!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteData() {
        if (selectedId == -1) {
            JOptionPane.showMessageDialog(view, "Pilih baris data di tabel terlebih dahulu!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(selectedId);
            JOptionPane.showMessageDialog(view, "Data berhasil dihapus!");
            view.clearForm();
            selectedId = -1;
            loadTableData();
        }
    }
}