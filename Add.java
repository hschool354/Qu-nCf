package newproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import newproject.Menu;

import java.awt.Canvas;
import java.awt.TextField;
import java.awt.SystemColor;

public class Add extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txtUsername;
    private JTextField txtMaCV;
    private JTextField txtBDate;
    private JTextField txtGender;
    private JTextField txtsdt;
    private JTextField txtgmail;
    private JTextField txtDC;
    private JTextField passwordField;
    private JButton btnNewButton_1;
    private JComboBox<String> genderComboBox;

    
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 719, 510);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(128, 128, 64));
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Màu
        Color customColor1 = new Color(113, 170, 117);//Màu vàng
        Color customColor2 = new Color(246, 246, 246);//Màu nền nhập
		
		JPanel toppanel = new JPanel();
        toppanel.setLayout(null);
        toppanel.setBackground(customColor1);
        toppanel.setBounds(0, 0, 705, 117);
        contentPane.add(toppanel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(261, 72, 455, 45);
        toppanel.add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(223, 84, 40, 33);
        toppanel.add(panel_2);
        
        //Bảng Đăng ký
        JLabel lblNewLabel = new JLabel("THÊM NHÂN VIÊN");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(20, 45, 130, 23);
        toppanel.add(lblNewLabel);
        
        
        //Bảng nhập tên tài khoản
        txtUsername = new JTextField();
        txtUsername.setText("Username");
        txtUsername.setBounds(10, 148, 306, 37);
        txtUsername.setBackground(customColor2);
        txtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("Username")) {
                    txtUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().isEmpty()) {
                    txtUsername.setText("Username");
                }
            }
        });
        txtUsername.setColumns(10);
        contentPane.add(txtUsername);
        
        
        //Bảng nhập tên Mã Chức Vụ;
        txtMaCV = new JTextField();
        txtMaCV.setText("Mã Chức Vụ");
        txtMaCV.setBounds(10,196,306,37);
        txtMaCV.setBackground(customColor2);
        txtMaCV.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtMaCV.getText().equals("Mã Chức Vụ")) {
                	txtMaCV.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtMaCV.getText().isEmpty()) {
                	txtMaCV.setText("Mã Chức Vụ");
                }
            }
        });
        txtMaCV.setColumns(10);
        contentPane.add(txtMaCV);
        
        
        //Bảng nhập tên Ngày Sinh
        txtBDate = new JTextField();
        txtBDate.setText("Ngày Sinh");
        txtBDate.setBounds(10,244,306,37);
        txtBDate.setBackground(customColor2);
        txtBDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtBDate.getText().equals("Ngày Sinh")) {
                	txtBDate.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtBDate.getText().isEmpty()) {
                	txtBDate.setText("Ngày Sinh");
                }
            }
        });
        txtBDate.setColumns(10);
        contentPane.add(txtBDate);
		
        
        //Nhập gmail
        txtgmail = new JTextField();
        txtgmail.setText("Gmail");
        txtgmail.setBounds(10, 340, 306, 37);
        txtgmail.setBackground(customColor2);
        txtgmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtgmail.getText().equals("Gmail")) {
                	txtgmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtgmail.getText().isEmpty()) {
                	txtgmail.setText("Gmail");
                }
            }
        });
        txtgmail.setColumns(10);
        contentPane.add(txtgmail);
        
        
        //Nhập sdt
        txtsdt = new JTextField();
        txtsdt.setText("Số điện thoại");
        txtsdt.setBounds(10, 292, 306, 37);
        txtsdt.setBackground(customColor2);
        txtsdt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtsdt.getText().equals("Số điện thoại")) {
                	txtsdt.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtsdt.getText().isEmpty()) {
                	txtsdt.setText("Số điện thoại");
                }
            }
        });
        txtsdt.setColumns(10);
        contentPane.add(txtsdt);
        
        
        //NÚT nhập địa chỉ
        txtDC = new JTextField();
        txtDC.setText("Địa chỉ");
        txtDC.setBounds(327, 148, 306, 37);
        txtDC.setBackground(customColor2);
        txtDC.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtDC.getText().equals("Địa Chỉ")) {
                	txtDC.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtDC.getText().isEmpty()) {
                	txtDC.setText("Địa chỉ");
                }
            }
        });
        txtDC.setColumns(10);
        contentPane.add(txtDC);
        
     // Tạo JComboBox cho giới tính
        String[] genders = {"Nam", "Nữ"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(326, 199, 150, 30);
        contentPane.add(genderComboBox);
        
     // Xử lý sự kiện khi chọn giới tính
        genderComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị được chọn từ JComboBox
                String selectedGender = (String) genderComboBox.getSelectedItem();
                
                // Chuyển đổi giới tính thành giá trị 1 hoặc 0
                int genderValue = selectedGender.equals("Nam") ? 1 : 0;
                
                // Lưu giá trị vào cơ sở dữ liệu hoặc thực hiện các xử lý khác
                // Gọi phương thức performHome() hoặc thực hiện xử lý trực tiếp ở đây
            }
        });
        
        JButton btnQL = new JButton("Quay Lại");
        btnQL.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 
        		setVisible(false);	
				Personnel personnel = new Personnel();
				personnel.setVisible(true);
        	}
        });
        btnQL.setBounds(220, 411, 96, 29);
        contentPane.add(btnQL);
        
        // NÚT ĐĂNG KÝ
        JButton btnNewButton = new JButton("Thêm Nhân Viên");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		performHome();
        	}
        });
        btnNewButton.setBounds(10, 414, 96, 23);
        btnNewButton.setBackground(Color.BLACK); 
        btnNewButton.setForeground(SystemColor.textHighlightText);
        contentPane.add(btnNewButton);
	}
	
	private String newMANV() {
        String latestID = "NV000"; // Mã nhân viên mặc định
        String query = "SELECT MAX(MANV) FROM NhanVien"; // Truy vấn lấy mã nhân viên lớn nhất từ cơ sở dữ liệu

        try (Connection connection = DriverManager.getConnection(ConnectDB.url, ConnectDB.user, ConnectDB.password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                String maxID = resultSet.getString(1); // Lấy mã nhân viên lớn nhất từ kết quả truy vấn
                if (maxID != null) {
                    // Tách phần số từ mã nhân viên lớn nhất
                    int num = Integer.parseInt(maxID.substring(2)) + 1;
                    latestID = String.format("NV%03d", num); // Format lại mã nhân viên mới
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return latestID;
    }
	
	public void performHome() {
        try (Connection connection = DriverManager.getConnection(ConnectDB.url, ConnectDB.user, ConnectDB.password)) {
            String inputMANV = newMANV();
            String inputUsername = txtUsername.getText();
            String inputMaCV = txtMaCV.getText();
            String inputBDate = txtBDate.getText();
            String inputsdt = txtsdt.getText();
            String inputgmail = txtgmail.getText();
            String inputDC = txtDC.getText();
            String selectedGender = (String) genderComboBox.getSelectedItem();
            int genderValue = selectedGender.equals("Nam") ? 1 : 0;

            String insertQuery = "INSERT INTO NhanVien (MANV, TENNV, MACV, NGAYSINH, GIOITINH, SODT, EMAIL, DIACHI, NGAYNGHI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, inputMANV);
                insertStatement.setString(2, inputUsername);
                insertStatement.setString(3, inputMaCV);
                insertStatement.setString(4, inputBDate);
                insertStatement.setInt(5, genderValue);
                insertStatement.setString(6, inputsdt);
                insertStatement.setString(7, inputgmail);
                insertStatement.setString(8, inputDC);
                insertStatement.setString(9, "2024-04-03"); // Change to a valid date or adjust as needed

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Registration successful! MaNV: " + inputMANV);
                    setVisible(false);	
					Personnel personnel = new Personnel();
					personnel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Registration failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}