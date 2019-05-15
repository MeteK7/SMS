
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MeteK
 */
public class AdminForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     */
    public AdminForm() {
        initComponents();
    }

    /*private void PublishLectures(String tcNum, String lectureId, String choice, String credit){
        String query="INSERT INTO STUDLECTCHOICE (TCNUM, LECTUREID, CHOICE, CREDIT) values(?,?,?,?)";
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
            try{
                Connection con = DriverManager.getConnection(host,userName,userPass);
                PreparedStatement st=con.prepareStatement(query);
                st.setString(1,tcNum);
                st.setString(2,lectureId);
                st.setString(3,choice);
                st.setString(4,credit);
                st.setString(5,cmbDept);
                st.setString(6,pw);
                st.setString(7,txtLecturerRegYear.getText());
                st.setString(8,txtLecturerCity.getText());
                st.setString(9,txtLecturerDistrict.getText());
                st.setString(10,txtLecturerAddress.getText());
                st.setString(11,schoolNum);
                st.setString(12,txtLecturerTcNum.getText());
                st.setString(13,"0");
                st.executeUpdate();
                con.close();
                JOptionPane.showInputDialog("Successful!");
                txtLecturerSchoolNum.setText(schoolNum);
            }
            catch ( SQLException err ) {
                JOptionPane.showInputDialog("Error!");
            }

    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabAdminLecturer = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnStudRegForm = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudentInfo = new javax.swing.JTable();
        btnFetchStudents = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnLecturerRegForm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLecturerInfo = new javax.swing.JTable();
        btnFetchLecturers = new javax.swing.JButton();
        btnSetSupervisor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnFetchLessons = new javax.swing.JButton();
        btnLectPublish = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLectureInfo = new javax.swing.JTable();
        rdbFirstSem = new javax.swing.JRadioButton();
        rdbSecondSem = new javax.swing.JRadioButton();
        lblEduYear = new javax.swing.JLabel();
        txtEduYear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        btnStudRegForm.setText("REGISTER");
        btnStudRegForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudRegFormActionPerformed(evt);
            }
        });
        jPanel1.add(btnStudRegForm);
        btnStudRegForm.setBounds(10, 30, 125, 52);

        tblStudentInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "SURNAME", "TC NUMBER", "FACULTY", "DEPARTMENT", "E-MAIL", "PHONE NUMBER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStudentInfo);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(163, 11, 920, 759);

        btnFetchStudents.setText("FETCH");
        btnFetchStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchStudentsActionPerformed(evt);
            }
        });
        jPanel1.add(btnFetchStudents);
        btnFetchStudents.setBounds(10, 100, 125, 55);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\8478.jpg")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, -6, 1100, 800);

        tabAdminLecturer.addTab("STUDENT", jPanel1);

        jPanel2.setLayout(null);

        btnLecturerRegForm.setText("REGISTER");
        btnLecturerRegForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLecturerRegFormActionPerformed(evt);
            }
        });
        jPanel2.add(btnLecturerRegForm);
        btnLecturerRegForm.setBounds(10, 30, 125, 52);

        tblLecturerInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "SURNAME", "EMAIL", "DEPARTMENT", "TC NUMBER", "SUPERVISOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLecturerInfo);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(164, 10, 920, 760);

        btnFetchLecturers.setText("FETCH");
        btnFetchLecturers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchLecturersActionPerformed(evt);
            }
        });
        jPanel2.add(btnFetchLecturers);
        btnFetchLecturers.setBounds(10, 100, 125, 55);

        btnSetSupervisor.setText("Set Supervisor");
        btnSetSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetSupervisorActionPerformed(evt);
            }
        });
        jPanel2.add(btnSetSupervisor);
        btnSetSupervisor.setBounds(10, 173, 125, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\8478.jpg")); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, -6, 1100, 800);

        tabAdminLecturer.addTab("LECTURER", jPanel2);

        jPanel3.setLayout(null);

        btnFetchLessons.setText("FETCH");
        btnFetchLessons.setMaximumSize(new java.awt.Dimension(81, 23));
        btnFetchLessons.setMinimumSize(new java.awt.Dimension(81, 23));
        btnFetchLessons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchLessonsActionPerformed(evt);
            }
        });
        jPanel3.add(btnFetchLessons);
        btnFetchLessons.setBounds(10, 30, 130, 50);

        btnLectPublish.setText("Publish");
        btnLectPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLectPublishActionPerformed(evt);
            }
        });
        jPanel3.add(btnLectPublish);
        btnLectPublish.setBounds(10, 100, 130, 50);

        tblLectureInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "NAME", "SEMESTER", "TYPE", "CREDIT", "AKTS", "TEACHER TC"
            }
        ));
        jScrollPane2.setViewportView(tblLectureInfo);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(166, 11, 920, 760);

        rdbFirstSem.setForeground(new java.awt.Color(255, 255, 255));
        rdbFirstSem.setText("SEMESTER 1");
        rdbFirstSem.setOpaque(false);
        jPanel3.add(rdbFirstSem);
        rdbFirstSem.setBounds(20, 210, 100, 23);

        rdbSecondSem.setForeground(new java.awt.Color(255, 255, 255));
        rdbSecondSem.setText("SEMESTER 2");
        rdbSecondSem.setOpaque(false);
        jPanel3.add(rdbSecondSem);
        rdbSecondSem.setBounds(20, 240, 100, 23);

        lblEduYear.setForeground(new java.awt.Color(255, 255, 255));
        lblEduYear.setText("YEAR:");
        jPanel3.add(lblEduYear);
        lblEduYear.setBounds(20, 170, 30, 14);
        jPanel3.add(txtEduYear);
        txtEduYear.setBounds(70, 170, 70, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\8478.jpg")); // NOI18N
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, -6, 1100, 810);

        tabAdminLecturer.addTab("LECTURES", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabAdminLecturer, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabAdminLecturer, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1136, 887));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLecturerRegFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecturerRegFormActionPerformed
        LecturerRegForm lectRegFrame=new LecturerRegForm();
        lectRegFrame.setVisible(true);
    }//GEN-LAST:event_btnLecturerRegFormActionPerformed

    private void btnStudRegFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudRegFormActionPerformed
        StudentRegForm studRegFrame=new StudentRegForm();
        studRegFrame.setVisible(true);
    }//GEN-LAST:event_btnStudRegFormActionPerformed

    private void btnFetchLessonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFetchLessonsActionPerformed
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM LECTURES ";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            /*tblLectureInfo.setModel(DbUtils.resultSetToTableModel(rs));*/ //This code is for taking all the rows from db including column names.
            DefaultTableModel tm=(DefaultTableModel)tblLectureInfo.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("CODE"),rs.getString("NAME"),rs.getString("SEMESTER"),rs.getString("TYPE"),rs.getString("CREDIT"),rs.getString("AKTS"),rs.getString("TEACHERTC")};
                tm.addRow(o);
            }        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnFetchLessonsActionPerformed

    private void btnFetchLecturersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFetchLecturersActionPerformed
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            
            String sql="SELECT * FROM LECTURERINFO ";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();

            DefaultTableModel tm=(DefaultTableModel)tblLecturerInfo.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("EMAIL"),rs.getString("DEPARTMENT"),rs.getString("TCNUM"),rs.getInt("SUPERVISOR")};
                tm.addRow(o);
            }
                       
            /*String sql="SELECT * FROM LECTURERINFO ";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            tblLecturerInfo.setModel(DbUtils.resultSetToTableModel(rs));  //This code for fetching all the datas including column names.  */
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnFetchLecturersActionPerformed

    private void btnSetSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetSupervisorActionPerformed
        int columnTC = 4; //12 is the column of TC numbers in the Database.
        int columnDept=3;
        int row = tblLecturerInfo.getSelectedRow();
        String valueTC = tblLecturerInfo.getModel().getValueAt(row, columnTC).toString();
        String valueDept=tblLecturerInfo.getModel().getValueAt(row,columnDept).toString();
        JOptionPane.showInputDialog(valueTC);
        JOptionPane.showInputDialog(valueDept);
        
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass); //We have a connection here.
            
            String sqlClear="UPDATE LECTURERINFO SET SUPERVISOR=0 WHERE DEPARTMENT=?";  //We are clearing the old supervisor of the department.
            PreparedStatement stmtClear=con.prepareStatement(sqlClear);
            
            // set the preparedstatement parameters
            stmtClear.setString(1, valueDept);      
            
            stmtClear.executeUpdate();// execute the java preparedstatement
            
            String sql="UPDATE LECTURERINFO SET SUPERVISOR=1 WHERE TCNUM= ? AND DEPARTMENT=?";//We are assigning the new supervisor of the department.
            PreparedStatement stmt=con.prepareStatement(sql);
            
            // set the preparedstatement parameters
            stmt.setString(1, valueTC);
            stmt.setString(2, valueDept);      
            
            stmt.executeUpdate();// execute the java preparedstatement
          
            con.close();            
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSetSupervisorActionPerformed

    private void btnFetchStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFetchStudentsActionPerformed
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            
            String sql="SELECT * FROM STUDENTINFO";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();

            DefaultTableModel tm=(DefaultTableModel)tblStudentInfo.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("TCNUM"),rs.getString("FACULTY"),rs.getString("DEPARTMENT"),rs.getString("EMAIL"),rs.getString("PHONENUM")};
                tm.addRow(o);
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnFetchStudentsActionPerformed

    private void btnLectPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLectPublishActionPerformed
        boolean selected = rdbFirstSem.isSelected();
        int semester;
        int eduYear=Integer.parseInt(txtEduYear.getText());
        if (selected)
            semester=1;
 
        else 
            semester=2;
        
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass); //We have a connection here.
            String sql="UPDATE STUDENTINFO SET FETCHDATA=1, FETCHSEMESTER="+semester+",APPROVAL=0, EDUYEAR="+eduYear+""; 
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.executeUpdate();// execute the java preparedstatement               
            con.close();                      
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }          
    }//GEN-LAST:event_btnLectPublishActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFetchLecturers;
    private javax.swing.JButton btnFetchLessons;
    private javax.swing.JButton btnFetchStudents;
    private javax.swing.JButton btnLectPublish;
    private javax.swing.JButton btnLecturerRegForm;
    private javax.swing.JButton btnSetSupervisor;
    private javax.swing.JButton btnStudRegForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEduYear;
    private javax.swing.JRadioButton rdbFirstSem;
    private javax.swing.JRadioButton rdbSecondSem;
    private javax.swing.JTabbedPane tabAdminLecturer;
    private javax.swing.JTable tblLectureInfo;
    private javax.swing.JTable tblLecturerInfo;
    private javax.swing.JTable tblStudentInfo;
    private javax.swing.JTextField txtEduYear;
    // End of variables declaration//GEN-END:variables
}
