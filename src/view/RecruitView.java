/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class RecruitView extends JFrame {
    private JTextField namaTextField, writingTextField, codingTextField, interviewTextField;
    private JComboBox pathComboBox;
    private JButton addButton, updateButton, deleteButton, clearButton;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public RecruitView() {
        setTitle("Sistem Rekruitmen PT. OOP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        String[] columnNames = {"ID", "Nama", "Path", "Writing", "Coding", "Interview", "Score", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel formPanel = new JPanel(new GridLayout(9, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setPreferredSize(new Dimension(250, 0));
        
        JPanel namaInputPanel =  new JPanel(new GridLayout(2, 1, 0, 0));
        namaInputPanel.add(new JLabel("Nama"));
        namaTextField = new JTextField();
        namaInputPanel.add(namaTextField);
        formPanel.add(namaInputPanel);
        
        JPanel pathInputPanel =  new JPanel(new GridLayout(2, 1, 0, 0));
        pathInputPanel.add(new JLabel("Path"));
        String[] paths = {"Android Developer", "Web Developer"};
        pathComboBox = new JComboBox<>(paths);
        pathInputPanel.add(pathComboBox);
        formPanel.add(pathInputPanel);
        
        JPanel writingInputPanel =  new JPanel(new GridLayout(2, 1, 0, 0));
        writingInputPanel.add(new JLabel("Writing"));
        writingTextField = new JTextField();
        writingInputPanel.add(writingTextField);
        formPanel.add(writingInputPanel);
        
        JPanel codingInputPanel =  new JPanel(new GridLayout(2, 1, 0, 0));
        codingInputPanel.add(new JLabel("Coding"));
        codingTextField = new JTextField();
        codingInputPanel.add(codingTextField);
        formPanel.add(codingInputPanel);
        
        JPanel interviewInputPanel =  new JPanel(new GridLayout(2, 1, 0, 0));
        interviewInputPanel.add(new JLabel("Interview"));
        interviewTextField = new JTextField();
        interviewInputPanel.add(interviewTextField);
        formPanel.add(interviewInputPanel);
        
        addButton = new JButton("Add");
        formPanel.add(addButton);
        updateButton = new JButton("Update");
        formPanel.add(updateButton);
        deleteButton = new JButton("Delete");
        formPanel.add(deleteButton);
        clearButton = new JButton("Clear");
        formPanel.add(clearButton);
        
        clearButton.addActionListener(e -> {
            clearForm();
        });
        
        add(formPanel, BorderLayout.EAST);
    }
    
    public static void main(String[] args) {
        new RecruitView().setVisible(true);
    }
    
    public void clearForm() {
        namaTextField.setText("");
        pathComboBox.setSelectedIndex(0);
        writingTextField.setText("");
        codingTextField.setText("");
        interviewTextField.setText("");
        table.clearSelection();
    }

    public JTextField getNamaTextField() {
        return namaTextField;
    }

    public void setNamaTextField(JTextField namaTextField) {
        this.namaTextField = namaTextField;
    }

    public JTextField getWritingTextField() {
        return writingTextField;
    }

    public void setWritingTextField(JTextField writingTextField) {
        this.writingTextField = writingTextField;
    }

    public JTextField getCodingTextField() {
        return codingTextField;
    }

    public void setCodingTextField(JTextField codingTextField) {
        this.codingTextField = codingTextField;
    }

    public JTextField getInterviewTextField() {
        return interviewTextField;
    }

    public void setInterviewTextField(JTextField interviewTextField) {
        this.interviewTextField = interviewTextField;
    }

    public JComboBox getPathComboBox() {
        return pathComboBox;
    }

    public void setPathComboBox(JComboBox pathComboBox) {
        this.pathComboBox = pathComboBox;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    
    
}
