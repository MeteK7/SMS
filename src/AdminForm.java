
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        jPanel2 = new javax.swing.JPanel();
        btnLecturerRegForm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLecturerInfo = new javax.swing.JTable();
        btnFetchLecturers = new javax.swing.JButton();
        btnSetSupervisor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnFetchLessons = new javax.swing.JButton();
        btnLectPublish = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLectureInfo = new javax.swing.JTable();
        rdbFirstSem = new javax.swing.JRadioButton();
        rdbSecondSem = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStudRegForm.setText("REGISTER");
        btnStudRegForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudRegFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStudRegForm, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(728, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnStudRegForm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(549, Short.MAX_VALUE))
        );

        tabAdminLecturer.addTab("STUDENT", jPanel1);

        btnLecturerRegForm.setText("REGISTER");
        btnLecturerRegForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLecturerRegFormActionPerformed(evt);
            }
        });

        tblLecturerInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLecturerInfo);

        btnFetchLecturers.setText("FETCH");
        btnFetchLecturers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchLecturersActionPerformed(evt);
            }
        });

        btnSetSupervisor.setText("Set Supervisor");
        btnSetSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetSupervisorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLecturerRegForm, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnFetchLecturers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSetSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLecturerRegForm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFetchLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSetSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabAdminLecturer.addTab("LECTURER", jPanel2);

        btnFetchLessons.setText("FETCH");
        btnFetchLessons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchLessonsActionPerformed(evt);
            }
        });

        btnLectPublish.setText("Publish");
        btnLectPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLectPublishActionPerformed(evt);
            }
        });

        jButton3.setText("jButton1");

        tblLectureInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblLectureInfo);

        rdbFirstSem.setText("SEMESTER 1");

        rdbSecondSem.setText("SEMESTER 2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFetchLessons, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLectPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdbFirstSem)
                    .addComponent(rdbSecondSem))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFetchLessons, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLectPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbFirstSem)
                        .addGap(5, 5, 5)
                        .addComponent(rdbSecondSem)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
        );

        tabAdminLecturer.addTab("LECTURES", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabAdminLecturer)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabAdminLecturer)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(904, 720));
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
            tblLectureInfo.setModel(DbUtils.resultSetToTableModel(rs));
        
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
            tblLecturerInfo.setModel(DbUtils.resultSetToTableModel(rs));
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnFetchLecturersActionPerformed

    private void btnSetSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetSupervisorActionPerformed
        int columnTC = 11; //11 is the column of TC numbers in the Database.
        int columnDept=4;
        int row = tblLecturerInfo.getSelectedRow();
        String valueTC = tblLecturerInfo.getModel().getValueAt(row, columnTC).toString();
        String valueDept=tblLecturerInfo.getModel().getValueAt(row,columnDept).toString();
        JOptionPane.showInputDialog(valueTC);
        JOptionPane.showInputDialog(valueDept);
        
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="UPDATE LECTURERINFO SET SUPERVISOR=1 WHERE TCNUM= ? AND DEPARTMENT=?";
            PreparedStatement stmt=con.prepareStatement(sql);
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

    private void btnLectPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLectPublishActionPerformed

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
    private javax.swing.JButton btnLectPublish;
    private javax.swing.JButton btnLecturerRegForm;
    private javax.swing.JButton btnSetSupervisor;
    private javax.swing.JButton btnStudRegForm;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdbFirstSem;
    private javax.swing.JRadioButton rdbSecondSem;
    private javax.swing.JTabbedPane tabAdminLecturer;
    private javax.swing.JTable tblLectureInfo;
    private javax.swing.JTable tblLecturerInfo;
    // End of variables declaration//GEN-END:variables
}
