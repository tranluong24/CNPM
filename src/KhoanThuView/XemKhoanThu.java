/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package KhoanThuView;

import KhoanThuController.XemKhoanThuController;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DongTienModel;
import model.HoKhauModel;
import model.KhoanThu;
import view.KhoanThuView;

/**
 *
 * @author MY PC
 */
public class XemKhoanThu extends javax.swing.JFrame {

    /**
     * Creates new form XemKhoanThu
     */
    XemKhoanThuController xemKT;
    private JFrame parentJframe;
    DefaultTableModel table;
    String makhoanthu ="";
    public XemKhoanThu(JFrame parent, String maKhoanThu, String loaiKhoanThu) {
        initComponents();
        this.parentJframe = parent;
        this.makhoanthu = maKhoanThu;
        
        this.setLocationRelativeTo(null);
        xemKT = new XemKhoanThuController(this);
        table = (DefaultTableModel)jTable1.getModel();
        
        xemKT.getKhoanThu(maKhoanThu, loaiKhoanThu);
        xemKT.getDanhSachCanThu(maKhoanThu);
        
        Dimension fixedSize = new Dimension(776, 632);
        jPanel3.setPreferredSize(fixedSize);
        jPanel3.setMinimumSize(fixedSize);
        jPanel3.setMaximumSize(fixedSize);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        
        this.setVisible(true);
    }
    
    public void hienThiKhoanThu(KhoanThu kt){
        
        
        this.TenKhoanThu2.setText(kt.getTenKhoanThu());
        
        
        this.LoaiKhoanThu.setSelectedItem(kt.getLoaiKhoanThu());
        this.LoaiKhoanThu.setEnabled(false);
        
        if(this.LoaiKhoanThu.getSelectedItem().equals("Phí dịch vụ")||LoaiKhoanThu.getSelectedItem().equals("Phí quản lý")){
            this.DonGia.setVisible(true);
            this.jLabel15.setVisible(true);
            this.jLabel14.setVisible(true);
            this.CongTy.setVisible(false);
            this.jLabel16.setVisible(false);
            this.DichVu.setVisible(false);
            this.jLabel17.setVisible(false);
            this.Oto.setVisible(false);
            this.jLabel18.setVisible(false);
            this.XeMay.setVisible(false);
            this.jLabel19.setVisible(false);
            this.jLabel20.setVisible(false);
            this.jLabel24.setVisible(false);
            this.ThuDuocText.setVisible(false);
            this.DonGia.setText(kt.getDonGia()+"");
        }else if(this.LoaiKhoanThu.getSelectedItem().equals("Phí gửi xe")){
            this.Oto.setVisible(true);
            this.jLabel18.setVisible(true);
            this.XeMay.setVisible(true);
             this.jLabel19.setVisible(true);
                this.DonGia.setVisible(false);
                this.jLabel15.setVisible(false);
                this.jLabel14.setVisible(false);
                 this.CongTy.setVisible(false);
                this.jLabel16.setVisible(false);
                 this.DichVu.setVisible(false);
                 this.jLabel17.setVisible(false);
            this.jLabel24.setVisible(false);
            this.ThuDuocText.setVisible(false);
            this.jLabel20.setVisible(true);
                    this.Oto.setText(kt.getOto()+"");
                    this.XeMay.setText(kt.getXemay()+"");
        }else if(this.LoaiKhoanThu.getSelectedItem().equals("Phí thu hộ")){
                             this.CongTy.setVisible(true);
                this.jLabel16.setVisible(true);
                 this.DichVu.setVisible(true);
                 this.jLabel17.setVisible(true);
            this.DonGia.setVisible(false);
            this.jLabel15.setVisible(false);
            this.jLabel14.setVisible(false);
            this.Oto.setVisible(false);
            this.jLabel18.setVisible(false);
            this.XeMay.setVisible(false);
             this.jLabel19.setVisible(false);
            this.jLabel20.setVisible(false);
            this.jLabel24.setVisible(false);
            this.ThuDuocText.setVisible(false);            
            this.CongTy.setText(kt.getTenCongTy());
            this.DichVu.setSelectedItem(kt.getDichVu());
            this.DichVu.setEnabled(false);
        }else if(this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp")){
            this.jLabel24.setVisible(true);
            this.ThuDuocText.setVisible(true);            
            this.DonGia.setVisible(false);
            this.jLabel15.setVisible(false);
            this.jLabel14.setVisible(false);
            this.CongTy.setVisible(false);
            this.jLabel16.setVisible(false);
            this.DichVu.setVisible(false);
            this.jLabel17.setVisible(false);
            this.Oto.setVisible(false);
            this.jLabel18.setVisible(false);
            this.XeMay.setVisible(false);
            this.jLabel19.setVisible(false);
            this.jLabel20.setVisible(false);    
            this.ThuDuocText.setText(kt.getTongThu()+"");
        }
        
        this.idText.setText(kt.getIdKhoanThu());
        this.NgayBatDau.setText(kt.getNgayBatDau()+"");
        this.TrangThai.setText(kt.getTrangThai());
        

        System.out.println(kt.getDichVu()+" "+kt.getLoaiKhoanThu());
    }
    
    public void hienThiDanhSachCanThu(ArrayList<DongTienModel> list){
      int countDaDong = 0;
      for(DongTienModel i : list){
        if(i.getTrangThai().equals("Đã đóng") && this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp")){
        table.addRow(new Object[]{i.getSoNha(),i.getTenChuHo(),i.getSoTien(), i.getTrangThai(),i.getNgayDong()});
        if(i.getTrangThai().equals("Đã đóng"))
                countDaDong++;
        }
        if(!this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp")){
            table.addRow(new Object[]{i.getSoNha(),i.getTenChuHo(),i.getSoTien(), i.getTrangThai(),i.getNgayDong()});
            if(i.getTrangThai().equals("Đã đóng"))
                countDaDong++;
        }
      }
      
      this.dathu.setText(countDaDong+"");
      this.tong.setText(list.size()+"");
      this.chuathu.setText(list.size()-countDaDong+"");
      
      
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TenKhoanThu2 = new javax.swing.JTextField();
        NgayBatDau = new javax.swing.JTextField();
        TrangThai = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        LoaiKhoanThu = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        DonGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CongTy = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        DichVu = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        XeMay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Oto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        tong = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        dathu = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        chuathu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        ThuDuocText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khoản thu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel9.setText("Tên khoản thu");

        jLabel10.setText("Loại khoản thu");

        jLabel11.setText("Ngày bắt đầu:");

        jLabel12.setText("Trạng thái");

        TenKhoanThu2.setEditable(false);
        TenKhoanThu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenKhoanThu2ActionPerformed(evt);
            }
        });

        NgayBatDau.setEditable(false);
        NgayBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NgayBatDauActionPerformed(evt);
            }
        });

        TrangThai.setEditable(false);
        TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrangThaiActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setText("ID: ");

        idText.setEditable(false);

        LoaiKhoanThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phí dịch vụ", "Phí quản lý", "Phí đóng góp", "Phí gửi xe", "Phí thu hộ" }));
        LoaiKhoanThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoaiKhoanThuActionPerformed(evt);
            }
        });

        jLabel14.setText("Đơn giá:");

        DonGia.setEditable(false);
        DonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DonGiaActionPerformed(evt);
            }
        });

        jLabel15.setText("( đơn vị: nghìn Đồng/m2 )");

        jLabel16.setText("Tên công ty cấp");

        CongTy.setEditable(false);
        CongTy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CongTyActionPerformed(evt);
            }
        });

        jLabel17.setText("Tên dịch vụ:");

        DichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Điện", "Nước", "Internet" }));

        jLabel18.setText("Giá xe máy: ");

        XeMay.setEditable(false);
        XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XeMayActionPerformed(evt);
            }
        });

        jLabel19.setText("Giá ô tô: ");

        Oto.setEditable(false);
        Oto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtoActionPerformed(evt);
            }
        });

        jLabel20.setText("( đơn vị: nghìn Đồng/xe)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số nhà", "Tên chủ hộ", "Số tiền", "Trạng thái", "Ngày đóng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel21.setText("Tổng: ");

        tong.setEditable(false);

        jLabel22.setText("Đã thu:");

        dathu.setEditable(false);

        jLabel23.setText("Chưa thu:");

        chuathu.setEditable(false);
        chuathu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuathuActionPerformed(evt);
            }
        });

        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Hoàn thành");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel24.setText("Thu được:");

        ThuDuocText.setEditable(false);
        ThuDuocText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThuDuocTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tong, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dathu, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chuathu, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TrangThai)
                                            .addComponent(NgayBatDau)
                                            .addComponent(LoaiKhoanThu, 0, 267, Short.MAX_VALUE)
                                            .addComponent(CongTy)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel15)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(ThuDuocText, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Oto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(TenKhoanThu2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 92, Short.MAX_VALUE)
                                        .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(47, 47, 47))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TenKhoanThu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(LoaiKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ThuDuocText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CongTy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(XeMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(Oto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(chuathu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(dathu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TenKhoanThu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenKhoanThu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenKhoanThu2ActionPerformed

    private void NgayBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NgayBatDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NgayBatDauActionPerformed

    private void TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrangThaiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            KhoanThuView mainView = new KhoanThuView();
            this.setVisible(false);
            mainView.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LoaiKhoanThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoaiKhoanThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoaiKhoanThuActionPerformed

    private void DonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DonGiaActionPerformed

    private void CongTyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CongTyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CongTyActionPerformed

    private void XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XeMayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XeMayActionPerformed

    private void OtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OtoActionPerformed

    private void chuathuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuathuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chuathuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.xemKT.xoaKhoanThu(makhoanthu);
        this.dispose();
        KhoanThuView viewMain = new KhoanThuView();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if((Integer.parseInt(this.tong.getText())==Integer.parseInt(this.dathu.getText()) && Integer.parseInt(this.tong.getText())!=0) || this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp"))
            xemKT.hoanThanhKhoanThu(makhoanthu);
        else{
            JOptionPane.showMessageDialog(this, "Khoản thu " +makhoanthu+ " chưa hoàn thành");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ThuDuocTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThuDuocTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThuDuocTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CongTy;
    private javax.swing.JComboBox<String> DichVu;
    private javax.swing.JTextField DonGia;
    private javax.swing.JComboBox<String> LoaiKhoanThu;
    private javax.swing.JTextField NgayBatDau;
    private javax.swing.JTextField Oto;
    private javax.swing.JTextField TenKhoanThu2;
    private javax.swing.JTextField ThuDuocText;
    private javax.swing.JTextField TrangThai;
    private javax.swing.JTextField XeMay;
    private javax.swing.JTextField chuathu;
    private javax.swing.JTextField dathu;
    private javax.swing.JTextField idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tong;
    // End of variables declaration//GEN-END:variables
}
