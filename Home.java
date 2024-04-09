package newproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.ImageIcon;

public class Home extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	public Home() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 555);
		setResizable(false);
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			}
		};
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Màu
		Color customColor1 = new Color(113, 170, 117);// Màu xanh nhạt
		Color customColor2 = new Color(246, 246, 246);// Màu nền nhập

		
		 // BẢNG ĐIỀU KHIỂN
		JLayeredPane layeredHome = new JLayeredPane();
		layeredHome.setBackground(customColor1);
		layeredHome.setBounds(0, 0, 150, 518);
		contentPane.add(layeredHome);
		
		
		// cái layer bên trái
		JPanel rightpanel = new JPanel(); 
		rightpanel.setBounds(0, 0, 150, 518);
		rightpanel.setBackground(customColor1); 
		layeredHome.add(rightpanel, JLayeredPane.DEFAULT_LAYER);
		
		
		// logo đại diện
		JLabel lblNewLabel_4 = new JLabel("");
		ImageIcon icon2 = new ImageIcon("D:\\image\\logo1.png");
		Image image2 = icon2.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblNewLabel_4.setIcon(new ImageIcon(image2));
		lblNewLabel_4.setBounds(30, 0, 80, 80); // Sửa kích thước label
		layeredHome.add(lblNewLabel_4, JLayeredPane.DRAG_LAYER);
		
		
		// logo nút home
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon icon = new ImageIcon("D:\\image\\house.png");
		Image image = icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(image));
		lblNewLabel_1.setBounds(15, 92, 21, 19); // Sửa kích thước label
		layeredHome.add(lblNewLabel_1, JLayeredPane.DRAG_LAYER);
		
		// Nút home
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(10, 82, 115, 36);
		layeredHome.add(btnNewButton_3, JLayeredPane.DRAG_LAYER);
		
		// logo menu
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon icon1 = new ImageIcon("D:\\image\\menu.png");
		Image image1 = icon1.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(image1));
		lblNewLabel_2.setBounds(15, 139, 21, 19); // Sửa kích thước label
		layeredHome.add(lblNewLabel_2, JLayeredPane.DRAG_LAYER);
		
		// nút Menu
		JButton btnNewButton_4 = new JButton("Menu");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(10, 133, 115, 36);
		layeredHome.add(btnNewButton_4, JLayeredPane.DRAG_LAYER);
		
		// Nút "Nhân sự"
        JButton btnPersonnel = new JButton("Personnel");
        btnPersonnel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maNhanVien = DangNhap.layMaNhanVien();
                if (maNhanVien == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập trước khi truy cập nhân sự.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!kiemTraChucVu(maNhanVien)) {
                    JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập phần nhân sự.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                setVisible(false);
                Personnel personnel = new Personnel();
                personnel.setVisible(true);
            }
        });
        btnPersonnel.setBackground(new Color(255, 255, 255));
        btnPersonnel.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPersonnel.setBounds(10, 184, 115, 36);
        layeredHome.add(btnPersonnel, JLayeredPane.DRAG_LAYER);
		
		// BẢNG DOANH THU THÁNG
		JLayeredPane layeredHome1 = new JLayeredPane();
		layeredHome1.setBackground(customColor1);
		layeredHome1.setBounds(160, 11, 171, 106);
		contentPane.add(layeredHome1);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(113, 170, 117));
		panel1.setBounds(0, 0, 171, 106);
		layeredHome1.add(panel1, JLayeredPane.DEFAULT_LAYER);
		
		NonEditableTableModel model1 = new NonEditableTableModel();
		model1.addColumn("Tổng tiền");
		
		JTable table_1 = new JTable(model1);
		
		JLabel lblNewLabel1 = new JLabel("Doanh thu tổng");
		lblNewLabel1.setBounds(20, 71, 141, 24);
		panel1.add(lblNewLabel1);

		table_1 = new JTable();
		table_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		table_1.setBackground(new Color(113, 170, 117));
		table_1.setBounds(10, 11, 151, 40);
		panel1.add(table_1);

		try {
		    Connection connection = DriverManager.getConnection(ConnectDB.url, ConnectDB.user, ConnectDB.password);
		    String query = "SELECT SUM(TONGTIEN) AS TONG_TIEN FROM HOADON";
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);

		    // Đổ dữ liệu từ ResultSet vào bảng
		    while (resultSet.next()) {
		        model1.addRow(new Object[]{resultSet.getString("TONG_TIEN")});
		    }

		    table_1.setModel(model1);

		    // Đóng kết nối
		    resultSet.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		// BẢNG DOANH THU NGÀY
		JLayeredPane layeredHome2 = new JLayeredPane();
		layeredHome2.setBackground(customColor1);
		layeredHome2.setBounds(350, 11, 171, 106);
		contentPane.add(layeredHome2);
		
		NonEditableTableModel model2 = new NonEditableTableModel();
		model2.addColumn("Tổng tiền");
		
		JTable table_2 = new JTable(model2);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(113, 170, 117));
		panel2.setBounds(0, 0, 171, 106);
		layeredHome2.add(panel2, JLayeredPane.DEFAULT_LAYER);

		JLabel lblNewLabel2 = new JLabel("Doanh thu ngày");
		lblNewLabel2.setBounds(20, 71, 141, 24);
		panel2.add(lblNewLabel2);

		table_2 = new JTable();
		table_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		table_2.setBackground(new Color(113, 170, 117));
		table_2.setBounds(10, 11, 151, 40);
		panel2.add(table_2);

		try {
			Connection connection = DriverManager.getConnection(ConnectDB.url, ConnectDB.user, ConnectDB.password);
		    String query = "SELECT SUM(TONGTIEN) AS TONG_TIEN FROM HOADON WHERE CAST(NGAYLAP AS DATE) = CAST(GETDATE() AS DATE)";
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);


		    // Đổ dữ liệu từ ResultSet vào bảng
		    while (resultSet.next()) {
		        model2.addRow(new Object[]{resultSet.getString("TONG_TIEN")});
		    }

		    table_2.setModel(model2);

		    // Đóng kết nối
		    resultSet.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		
		
		// Bảng hóa đơn
		JTable billTable = new JTable();
		billTable.setFont(new Font("SansSerif", Font.PLAIN, 12));

		// Thanh cuộn cho bảng hóa đơn
		JScrollPane scrollPane = new JScrollPane(billTable);
		scrollPane.setBounds(160, 149, 716, 358);
		contentPane.add(scrollPane);

		// Lấy dữ liệu hóa đơn từ cơ sở dữ liệu và hiển thị trên bảng
		try {
			Connection connection = DriverManager.getConnection(ConnectDB.url, ConnectDB.user, ConnectDB.password);
		    String query = "SELECT * FROM HOADON";
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);

		    // Tạo model cho bảng hóa đơn
		    NonEditableTableModel billModel = new NonEditableTableModel();
		    ResultSetMetaData metaData = resultSet.getMetaData();
		    int columnCount = metaData.getColumnCount();
		    
		    // Thêm tên cột vào model
		    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		        billModel.addColumn(metaData.getColumnName(columnIndex));
		    }
		    
		    // Thêm dữ liệu từ ResultSet vào model
		    while (resultSet.next()) {
		        Object[] rowData = new Object[columnCount];
		        for (int i = 0; i < columnCount; i++) {
		            rowData[i] = resultSet.getObject(i + 1);
		        }
		        billModel.addRow(rowData);
		    }
		    
		    // Đặt model cho bảng hóa đơn
		    billTable.setModel(billModel);

		    // Đóng kết nối
		    resultSet.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}
	
	// Phương thức kiểm tra chức vụ của người dùng
    private boolean kiemTraChucVu(String maNhanVien) {
        boolean coQuyen = false;
        String query = "SELECT MACV FROM NhanVien WHERE MANV = ? AND (MACV = 'CV1' OR MACV = 'CV2')"; // Kiểm tra mã chức vụ có phải là CV1 hoặc CV5

        try (Connection connection = DriverManager.getConnection(ConnectDB.url, ConnectDB.user, ConnectDB.password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maNhanVien);
            ResultSet resultSet = preparedStatement.executeQuery();

            coQuyen = resultSet.next(); // Nếu có kết quả từ truy vấn, tức là người dùng có chức vụ quản lý hoặc chủ
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return coQuyen;
    }
    
    
}
