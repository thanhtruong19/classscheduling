package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LenLichLopHocPhanDAO81{

    public static List<String> getCourses() throws SQLException {
        List<String> courses = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();
        String query = "SELECT tenMon FROM monhoc";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            courses.add(rs.getString("tenMon"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return courses;
    }

    public static List<String> getRooms() throws SQLException {
        List<String> rooms = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();
        String query = "SELECT tenPhongHoc FROM phonghoc";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            rooms.add(rs.getString("tenPhongHoc"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return rooms;
    }

    public static List<String> getTimeSlots() throws SQLException {
        List<String> timeSlots = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();
        String query = "SELECT KhungGio FROM giohoc ORDER BY idGioHoc";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            timeSlots.add(rs.getString("KhungGio"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return timeSlots;
    }

     public static List<Object[]> getClassSchedules(String selectedCourse) throws SQLException {
        List<Object[]> schedules = new ArrayList<>();
        Connection conn = DatabaseConnector.getConnection();
        String query = "SELECT tenLop, phongHoc, khungGio FROM lophocphan where tenLop = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, selectedCourse);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            schedules.add(new Object[]{rs.getString("tenLop"), rs.getString("phongHoc"), rs.getString("khungGio"), "Sửa Xóa"});
        }
        rs.close();
        stmt.close();
        conn.close();
        return schedules;
    }
     public static void saveClassSchedule(String tenLop, String phongHoc, String khungGio) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();
        String query = "INSERT INTO lophocphan (tenLop, phongHoc, khungGio) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, tenLop);
        stmt.setString(2, phongHoc);
        stmt.setString(3, khungGio);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public static void deleteClassSchedule(String tenLop, String phongHoc, String khungGio) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();
        String query = "DELETE FROM lophocphan WHERE tenLop = ? AND phongHoc = ? AND khungGio = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, tenLop);
        stmt.setString(2, phongHoc);
        stmt.setString(3, khungGio);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}

