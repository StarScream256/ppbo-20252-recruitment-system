/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class RecruitDAO {
    private Connection connection;
    
    public RecruitDAO() {
        this.connection = DatabaseConnection.getConnection();
    }
    
    public List<Recruit> index() {
        List recruits = new ArrayList<>();
        String query = "SELECT * FROM recruit";
        
        try (
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                Recruit r  = new Recruit();
                r.setId(rs.getInt("id"));
                r.setNama(rs.getString("nama"));
                r.setPath(rs.getString("path"));
                r.setWriting(rs.getInt("writing"));
                r.setCoding(rs.getInt("coding"));
                r.setInterview(rs.getInt("interview"));
                r.setScore(rs.getFloat("score"));
                r.setStatus(rs.getString("status"));
                
                recruits.add(r);
            }
        } catch (SQLException e) {
            System.err.println("[ERROR]-[DB}-[INDEX] Failed to retrieve data from recruit table: " + e.getMessage());
            e.printStackTrace();
        }
        return recruits;
    }
    
    public void create(Recruit recruit) {
        String query = "INSERT INTO"
            + " recruit (nama, path, writing, coding, interview, score, status)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, recruit.getNama());
            pstmt.setString(2, recruit.getPath());
            pstmt.setInt(3, recruit.getWriting());
            pstmt.setInt(4, recruit.getCoding());
            pstmt.setInt(5, recruit.getInterview());
            pstmt.setFloat(6, recruit.getScore());
            pstmt.setString(7, recruit.getStatus());
            
            pstmt.executeUpdate();
            System.out.println("[SUCCESS]-[DB}-[INSERT] Successfully added new recruit data");
        } catch (SQLException e) {
            System.err.println("[ERROR]-[DB}-[INSERT] Failed to insert data into recruit table");
            e.printStackTrace();
        }
    }
    
    public void update(Recruit recruit) {
        String query = "UPDATE recruit SET"
            + " nama = ?, path = ?, writing = ?, coding = ?, interview = ?, score = ?, status = ?"
            + " WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, recruit.getNama());
            pstmt.setString(2, recruit.getPath());
            pstmt.setInt(3, recruit.getWriting());
            pstmt.setInt(4, recruit.getCoding());
            pstmt.setInt(5, recruit.getInterview());
            pstmt.setFloat(6, recruit.getScore());
            pstmt.setString(7, recruit.getStatus());
            pstmt.setInt(8, recruit.getId());
            
            pstmt.executeUpdate();
            System.out.println("[SUCCESS]-[DB}-[UPDATE] Successfully updated recruit data");
        } catch (SQLException e) {
            System.err.println("[ERROR]-[DB}-[UPDATE] Failed to update data into recruit table");
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        String query = "DELETE FROM recruit WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("[SUCCESS]-[DB}-[DELETE] Successfully delete recruit data with id=" + id);
        } catch (SQLException e) {
            System.err.println("[ERROR]-[DB}-[DELETE] Failed to delete data from recruit table witth id=" + id);
            e.printStackTrace();
        }
    }
}
