
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MeteK
 */
public class LecturerForm extends javax.swing.JFrame {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    
    public LecturerForm() {
        initComponents();
    }
    
    String lecturerTc;
    String lecturerDept;
    int lecturerAuthority;
    public LecturerForm(String tc,String dept,int supervisor){
        initComponents();
        lecturerTc=tc;
        lecturerDept=dept;
        lecturerAuthority=supervisor;
        if (lecturerAuthority==0) {
            btnLectConfirm.setEnabled(false);
        }
        LoadCmbStudInfo();
        LoadTblStudInfos();        
    }    
    
    String studName;
    String studSurname;
    String studFullName;
    String studTcNum;
    
    
    private void LoadTblSpecificLectures(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDLECTCHOICE WHERE TCNUM='"+ studTcNum +"' AND TEACHERTC='"+lecturerTc+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            /*tblStudLectInfo.setModel(DbUtils.resultSetToTableModel(rs));  This code for fetching all the datas including column names.*/
            DefaultTableModel tm=(DefaultTableModel)tblSpecLectures.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("LECTURECODE"),rs.getString("LECTURENAME"),rs.getString("CREDIT"),rs.getString("SEMESTER"),rs.getString("MIDTERM"),rs.getString("FINAL"),rs.getString("PROJECT"),rs.getString("AVERAGE"),rs.getString("GRADE")};
                tm.addRow(o);
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    }
        private void LoadTblConfirmStudent(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDLECTCHOICE WHERE TCNUM='"+ studTcNum +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            /*tblStudLectInfo.setModel(DbUtils.resultSetToTableModel(rs));  This code for fetching all the datas including column names.*/
            DefaultTableModel tm=(DefaultTableModel)tblStudChoices.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("LECTURECODE"),rs.getString("LECTURENAME"),rs.getString("TYPE"),rs.getString("CREDIT"),rs.getBoolean("CHOICE")/*,rs.getBoolean("CONFIRMATION")*/};
                tm.addRow(o);
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    
    
    
    }
    private void LoadCmbStudInfo(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDENTINFO WHERE DEPARTMENT = '" + lecturerDept +"'";
            /*Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);*/
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                studName = rs.getString("NAME");
                studSurname = rs.getString("SURNAME");
                /*studTcNum=rs.getString("TCNUM");*/
                studFullName=studName+" "+studSurname;
                
                cmbStudName.addItem(studFullName); 
                cmbGradeSName.addItem(studFullName); 
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
 
    }
    

    private void LoadTblStudInfos(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDENTINFO WHERE DEPARTMENT = '" + lecturerDept +"'";
            
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();

            DefaultTableModel tm=(DefaultTableModel)tblStudInfos.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("NAME"),rs.getString("SURNAME"),rs.getString("EMAIL"),rs.getString("PHONENUM"),rs.getString("SCHOOLNUM"),rs.getString("REGYEAR")};
                tm.addRow(o);
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
    }
    

    
    private void LoadCmbStudTcNum(String studFullName){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        String tempFullName;
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDENTINFO WHERE DEPARTMENT = '" + lecturerDept +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) { 
                tempFullName=rs.getString("NAME")+" "+rs.getString("SURNAME");
                if (studFullName.equals(tempFullName)) {    //IMPROVE THIS BLOCK OF CODE!!!
                    studTcNum = rs.getString("TCNUM");
                    cmbGradeSTcNum.addItem(studTcNum);
                }

            }            
                                
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
    }
    
    private void LoadCmbStudTcConfirm(String studFullName){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        String tempFullName;
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDENTINFO WHERE DEPARTMENT = '" + lecturerDept +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) { 
                tempFullName=rs.getString("NAME")+" "+rs.getString("SURNAME");
                if (studFullName.equals(tempFullName)) {    //IMPROVE THIS BLOCK OF CODE!!!
                    studTcNum = rs.getString("TCNUM");
                    cmbStudTcNum.addItem(studTcNum);
                }

            }            
                                
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
    }    
    
    private double CalculateAverage(double mid, String proj, double fin){
        
        double avg;
        
        if ("".equals(proj)) {
            avg=(mid+fin)/2;
        }
        else{
            double project=Double.parseDouble(proj);
            avg=(mid+project+fin)/3;
        } 
        
        String tempAvg=df2.format(avg);
        avg=Double.parseDouble(tempAvg);
        
        return avg;
    
    }
    
    private double CalculateLetterGrade(double avg){
        double pointGrade;
        
        if (avg>=90 && avg<=100) {
            pointGrade=4.0;
        }
        else if(avg>=80 && avg<90){
            pointGrade=3.0;
        }
        else if(avg>=70 && avg<80){
            pointGrade=2.0;
        }
        else if(avg>=60 && avg<70){
            pointGrade=1.0;
        }
        else
            pointGrade=0.0;
        
        String tempPointGrade=df2.format(pointGrade);
        pointGrade=Double.parseDouble(tempPointGrade);
        
        return pointGrade;
    }
    
    private String CalculateLetter(double letterGrade){
        String letter;
        
        if (letterGrade==4.0) {
            letter="A";
        }
        else if(letterGrade==3.0){
            letter="B";
        }
        else if(letterGrade==2.0){
            letter="C";
        }
        else if(letterGrade==1.0){
            letter="D";
        }
        else
            letter="F";
        
        return letter;
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cmbGradeSName = new javax.swing.JComboBox<>();
        cmbGradeSTcNum = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSpecLectures = new javax.swing.JTable();
        lblLectureCode = new javax.swing.JLabel();
        lblLectureCredit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMid = new javax.swing.JTextField();
        txtProject = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblAverage = new javax.swing.JLabel();
        lblLetterGrade = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudInfos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbStudName = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudChoices = new javax.swing.JTable();
        btnLectConfirm = new javax.swing.JButton();
        cmbStudTcNum = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        cmbGradeSName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGradeSNameActionPerformed(evt);
            }
        });
        jPanel2.add(cmbGradeSName);
        cmbGradeSName.setBounds(10, 11, 193, 34);

        cmbGradeSTcNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGradeSTcNumActionPerformed(evt);
            }
        });
        jPanel2.add(cmbGradeSTcNum);
        cmbGradeSTcNum.setBounds(10, 63, 193, 36);

        tblSpecLectures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LECTURE CODE", "LECTURE NAME", "CREDIT", "SEMESTER", "MIDTERM", "FINAL", "PROJECT", "AVERAGE", "GRADE"
            }
        ));
        tblSpecLectures.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSpecLecturesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSpecLectures);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(323, 11, 771, 515);
        jPanel2.add(lblLectureCode);
        lblLectureCode.setBounds(10, 143, 62, 31);
        jPanel2.add(lblLectureCredit);
        lblLectureCredit.setBounds(109, 143, 65, 31);

        jLabel1.setText("MIDTERM:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 201, 62, 38);

        jLabel2.setText("PROJECT:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 257, 62, 38);

        jLabel3.setText("FINAL:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 313, 62, 37);
        jPanel2.add(txtMid);
        txtMid.setBounds(90, 201, 84, 38);
        jPanel2.add(txtProject);
        txtProject.setBounds(90, 257, 84, 38);
        jPanel2.add(txtFinal);
        txtFinal.setBounds(90, 313, 84, 37);

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);
        btnSave.setBounds(238, 379, 57, 48);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear);
        btnClear.setBounds(10, 379, 65, 48);

        lblAverage.setText("AVERAGE:");
        jPanel2.add(lblAverage);
        lblAverage.setBounds(10, 445, 164, 45);

        lblLetterGrade.setText("LETTERGRADE:");
        jPanel2.add(lblLetterGrade);
        lblLetterGrade.setBounds(10, 501, 164, 43);

        btnPrev.setText("PREVIEW");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrev);
        btnPrev.setBounds(81, 380, 151, 47);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\33462.jpg")); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 1100, 710);

        jTabbedPane1.addTab("GRADE INPUT", jPanel2);

        jPanel3.setLayout(null);

        tblStudInfos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NAME", "SURNAME", "E-MAIL", "PHONE NUMBER", "SCHOOL NUMBER", "REG YEAR"
            }
        ));
        jScrollPane2.setViewportView(tblStudInfos);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 11, 690, 686);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\33462.jpg")); // NOI18N
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 0, 1100, 710);

        jTabbedPane1.addTab("STUDENT INFOS", jPanel3);

        jPanel1.setLayout(null);

        cmbStudName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStudNameActionPerformed(evt);
            }
        });
        jPanel1.add(cmbStudName);
        cmbStudName.setBounds(10, 11, 193, 34);

        tblStudChoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODE", "NAME", "TYPE", "CREDIT", "CHOICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStudChoices);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(540, 11, 536, 697);

        btnLectConfirm.setText("CONFIRM");
        btnLectConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLectConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(btnLectConfirm);
        btnLectConfirm.setBounds(10, 166, 79, 64);

        cmbStudTcNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStudTcNumActionPerformed(evt);
            }
        });
        jPanel1.add(cmbStudTcNum);
        cmbStudTcNum.setBounds(10, 78, 193, 37);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\33462.jpg")); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 1100, 710);

        jTabbedPane1.addTab("STUDENT LECTURES", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1145, 797));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnLectConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLectConfirmActionPerformed
        String studTc=cmbStudTcNum.getSelectedItem().toString();
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass); //We have a connection here.
            String sql="UPDATE STUDENTINFO SET APPROVAL=1 WHERE TCNUM='"+ studTc +"'"; 
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.executeUpdate();// execute the java preparedstatement               
            con.close();                      
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }            
    }//GEN-LAST:event_btnLectConfirmActionPerformed

    private void cmbGradeSNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGradeSNameActionPerformed
        cmbGradeSTcNum.removeAllItems();
        LoadCmbStudTcNum(cmbGradeSName.getSelectedItem().toString());
    }//GEN-LAST:event_cmbGradeSNameActionPerformed

    private void cmbStudNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStudNameActionPerformed
        cmbStudTcNum.removeAllItems();
        LoadCmbStudTcConfirm(cmbStudName.getSelectedItem().toString());
    }//GEN-LAST:event_cmbStudNameActionPerformed

    private void cmbGradeSTcNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGradeSTcNumActionPerformed
        LoadTblSpecificLectures();               
    }//GEN-LAST:event_cmbGradeSTcNumActionPerformed
    
    
    private void tblSpecLecturesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSpecLecturesMouseClicked
        DefaultTableModel model=(DefaultTableModel)tblSpecLectures.getModel();
        int selectedRowIndex=tblSpecLectures.getSelectedRow();
        
        lblLectureCode.setText(model.getValueAt(selectedRowIndex,0).toString());
        lblLectureCredit.setText(model.getValueAt(selectedRowIndex,2).toString());
    }//GEN-LAST:event_tblSpecLecturesMouseClicked
    private void ClearView(){
        txtMid.setText("");
        txtProject.setText("");
        txtFinal.setText("");
        lblLectureCode.setText("");
        lblLectureCredit.setText("");     
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        ClearView();
    }//GEN-LAST:event_btnClearActionPerformed
    
    double studAverage;
    double pointGrade;
    String letterGrade;
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        DefaultTableModel model=(DefaultTableModel)tblSpecLectures.getModel();
        int selectedRowIndex=tblSpecLectures.getSelectedRow();
        String lectureCode=model.getValueAt(selectedRowIndex,0).toString();

        String studTc=cmbGradeSTcNum.getSelectedItem().toString();
        double studMidterm=Double.parseDouble(txtMid.getText());
        double studProject;
        double studFinal=Double.parseDouble(txtFinal.getText());
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        if ("".equals(txtProject.getText())) {
            studProject=00;
        }
        else
            studProject=Double.parseDouble(txtProject.getText());
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass); //We have a connection here.
            String sql="UPDATE STUDLECTCHOICE SET MIDTERM="+studMidterm+", PROJECT="+studProject+", FINAL="+studFinal+", AVERAGE="+studAverage+", POINTGRADE="+pointGrade+", LETTERGRADE='"+letterGrade+"' WHERE TCNUM='"+ studTc +"' AND LECTURECODE='"+lectureCode+"'"; 
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.executeUpdate();// execute the java preparedstatement               
            con.close();                      
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        } 
        
        LoadTblSpecificLectures();
        ClearView();
    }//GEN-LAST:event_btnSaveActionPerformed


    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        double studMidterm=Double.parseDouble(txtMid.getText());
        /*double studProject=Double.parseDouble(txtProject.getText());*/
        String studProject=txtProject.getText();
        double studFinal=Double.parseDouble(txtFinal.getText());

        
        studAverage=CalculateAverage(studMidterm,studProject,studFinal);
        
        lblAverage.setText("AVERAGE: "+studAverage);
        
        pointGrade=CalculateLetterGrade(studAverage);
        
        letterGrade=CalculateLetter(pointGrade);
        
        lblLetterGrade.setText("LETTERGRADE: "+letterGrade+" --- "+pointGrade);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void cmbStudTcNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStudTcNumActionPerformed
        LoadTblConfirmStudent(); 
    }//GEN-LAST:event_cmbStudTcNumActionPerformed

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
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLectConfirm;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbGradeSName;
    private javax.swing.JComboBox<String> cmbGradeSTcNum;
    private javax.swing.JComboBox<String> cmbStudName;
    private javax.swing.JComboBox<String> cmbStudTcNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAverage;
    private javax.swing.JLabel lblLectureCode;
    private javax.swing.JLabel lblLectureCredit;
    private javax.swing.JLabel lblLetterGrade;
    private javax.swing.JTable tblSpecLectures;
    private javax.swing.JTable tblStudChoices;
    private javax.swing.JTable tblStudInfos;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtMid;
    private javax.swing.JTextField txtProject;
    // End of variables declaration//GEN-END:variables
}
