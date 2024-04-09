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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class Personnel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	private JTable table_1;
	private JTable table_2;	
	
	public Personnel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 555);
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
				setVisible(false);	
				Home home = new Home();
				home.setVisible(true);
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
		
		// logo nhân sự
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon icon3 = new ImageIcon("D:\\image\\human.png");
		Image image3 = icon3.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(image3));
		lblNewLabel_3.setBounds(15, 190, 21, 19); // Sửa kích thước label
		layeredHome.add(lblNewLabel_3, JLayeredPane.DRAG_LAYER);
		
		JButton btnNewButton_5 = new JButton("Personnel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(10, 184, 115, 36);
		layeredHome.add(btnNewButton_5, JLayeredPane.DRAG_LAYER);
		
		 // BẢNG dưới
		JLayeredPane layeredown = new JLayeredPane();
		layeredown.setBackground(customColor1);
		layeredown.setBounds(160, 380, 400, 138);
		contentPane.add(layeredown);
		
		// icon add
		JLabel lblNewLabel_add = new JLabel("  ");
		ImageIcon iconadd = new ImageIcon("D:\\image\\add.png");
		Image imageadd = iconadd.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		lblNewLabel_add.setIcon(new ImageIcon(imageadd));
		lblNewLabel_add.setBounds(16, 15, 20, 30);
		layeredown.add(lblNewLabel_add, JLayeredPane.DRAG_LAYER);
		
		
		//nút add
	    JButton btnNewButtonAdd = new JButton("THÊM NHÂN VIÊN");
	    btnNewButtonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
				Add add = new Add();
				add.setVisible(true);
			}
		});
	    btnNewButtonAdd.setBackground(new Color(255, 255, 255));
	    btnNewButtonAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
	    btnNewButtonAdd.setBounds(10, 10, 150, 43);
	    layeredown.add(btnNewButtonAdd, JLayeredPane.DRAG_LAYER);
	    
	    // icon edit
	    JLabel lblNewLabel_edit = new JLabel("  ");
	    ImageIcon iconedit = new ImageIcon("D:\\image\\edit.png");
		Image imageEdit = iconedit.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		lblNewLabel_edit.setIcon(new ImageIcon(imageEdit));
		lblNewLabel_edit.setBounds(16, 75, 20, 30);
		layeredown.add(lblNewLabel_edit, JLayeredPane.DRAG_LAYER);
		
		
		//nút EDIT
	    JButton btnNewButtonEdit = new JButton("SỬA THÔNG TIN");
	    btnNewButtonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
				EditP editP = new EditP();
				editP.setVisible(true);
			}
		});
	    btnNewButtonEdit.setBackground(new Color(255, 255, 255));
	    btnNewButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
	    btnNewButtonEdit.setBounds(10, 70, 150, 43);
	    layeredown.add(btnNewButtonEdit, JLayeredPane.DRAG_LAYER);
	    
	    //icon delete
	    JLabel lblNewLabel_del = new JLabel("  ");
	    ImageIcon iconeDel = new ImageIcon("D:\\image\\del.png");
		Image imageDel = iconeDel.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		lblNewLabel_del.setIcon(new ImageIcon(imageDel));
		lblNewLabel_del.setBounds(195, 15, 20, 30);
		layeredown.add(lblNewLabel_del, JLayeredPane.DRAG_LAYER);
		
		
		//nút XÓA
	    JButton btnNewButtonDel = new JButton("XÓA");
	    btnNewButtonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
				DeleteP delete = new DeleteP();
				delete.setVisible(true);
			}
		});
	    btnNewButtonDel.setBackground(new Color(255, 255, 255));
	    btnNewButtonDel.setFont(new Font("Tahoma", Font.BOLD, 11));
	    btnNewButtonDel.setBounds(190, 10, 150, 43);
	    layeredown.add(btnNewButtonDel, JLayeredPane.DRAG_LAYER);
	    
	    
		// Bảng nhân sự
		JTable perTable = new JTable();
		perTable.setFont(new Font("SansSerif", Font.PLAIN, 12));

		// Thanh cuộn cho bảng hóa đơn
		JScrollPane scrollPane = new JScrollPane(perTable);
		scrollPane.setBounds(160, 11, 916, 358);
		contentPane.add(scrollPane);

		// Lấy dữ liệu hóa đơn từ cơ sở dữ liệu và hiển thị trên bảng
		try {
			Connection connection = DriverManager.getConnection(ConnectDB.url, ConnectDB.user, ConnectDB.password);
		    String query = "SELECT * FROM NhanVien";
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
		    perTable.setModel(billModel);

		    // Đóng kết nối
		    resultSet.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

	}
}
