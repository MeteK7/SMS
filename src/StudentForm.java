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

public class StudentForm extends javax.swing.JFrame {

    String semester="1";
    String lessonConfirm="0";
    public StudentForm() {
        initComponents();
        /*DisplayTable();*/
        
    }
    
    String studTc;
    public StudentForm(String tc){
        initComponents();
        studTc=tc;
    }
    
    private void DisplayTable(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM LECTURES WHERE SEMESTER='"+ semester +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            /*tblStudLectInfo.setModel(DbUtils.resultSetToTableModel(rs));  This code for fetching all the datas including column names.*/
            DefaultTableModel tm=(DefaultTableModel)tblStudLectInfo.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("CODE"),rs.getString("NAME"),rs.getString("TYPE"),rs.getString("CREDIT"),rs.getString("AKTS"),rs.getBoolean("CHOICE")};
                tm.addRow(o);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudLectInfo = new javax.swing.JTable();
        btnLectFetch = new javax.swing.JButton();
        btnStudShow = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("start", jPanel1);

        tblStudLectInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODE", "LECTURE NAME", "TYPE", "CREDIT", "AKTS", "CHOICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStudLectInfo);

        btnLectFetch.setText("FETCH");
        btnLectFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLectFetchActionPerformed(evt);
            }
        });

        btnStudShow.setText("SHOW");
        btnStudShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLectFetch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStudShow, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLectFetch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStudShow, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("course pre-registration", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("summer term pre-registration", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("monitoring success", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("results of exam", jPanel5);

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

        setSize(new java.awt.Dimension(887, 642));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudShowActionPerformed
     
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            JOptionPane.showInputDialog("Entered before con!");
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDLECTCHOICE WHERE TCNUM='"+ studTc +"' AND SEMESTER='"+semester+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            JOptionPane.showInputDialog("Entered to try!");
            
            /*tblStudLectInfo.setModel(DbUtils.resultSetToTableModel(rs));  This code for fetching all the datas including column names.*/
            DefaultTableModel tm=(DefaultTableModel)tblStudLectInfo.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("LECTURECODE"),rs.getString("LECTURENAME"),rs.getString("TYPE"),rs.getString("CREDIT"),rs.getString("AKTS"),rs.getBoolean("CHOICE")};
                tm.addRow(o);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnStudShowActionPerformed

    private void btnLectFetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLectFetchActionPerformed
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
      
        String lectureCode;
        String lectureId;
        String lectureName;
        String lectureType;
        String lectureCredit;
        String lectureAkts;
        Boolean lectureChoice;
        
        /*if (rdbSecondSem.isSelected()) {
            semester="2";
        }
        else
            semester="1";*/
        
        try
            {
                Connection con = DriverManager.getConnection(host,userName,userPass);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM LECTURES WHERE SEMESTER=1");
                while ( rs.next() ) {
                    lectureCode = rs.getString("CODE");
                    lectureId = rs.getString("ID");
                    lectureName = rs.getString("NAME");
                    lectureType = rs.getString("TYPE");
                    lectureCredit = rs.getString("CREDIT");                    
                    lectureAkts = rs.getString("AKTS");
                    lectureChoice = false;
                    
                    String query="INSERT INTO STUDLECTCHOICE (TCNUM, LECTUREID, LECTURECODE, LECTURENAME, TYPE, CREDIT, AKTS, CHOICE,SEMESTER,CONFIRMATION) values(?,?,?,?,?,?,?,?,?,?)";
            
                    try{
                        JOptionPane.showInputDialog("Entered nested try!");
                        PreparedStatement st=con.prepareStatement(query);
                        st.setString(1,studTc);
                        st.setString(2,lectureId);
                        st.setString(3,lectureCode);
                        st.setString(4,lectureName);
                        st.setString(5,lectureType);
                        st.setString(6,lectureCredit);
                        st.setString(7,lectureAkts);
                        st.setBoolean(8,lectureChoice);
                        st.setString(9,semester);
                        st.setString(10,lessonConfirm);
                        st.executeUpdate();
                        
                        JOptionPane.showInputDialog("Entered!");
                    }
                    catch ( SQLException err ) {
                        JOptionPane.showInputDialog("Error!");
                    }                    

                }
                con.close();
            }

        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        
        
    }//GEN-LAST:event_btnLectFetchActionPerformed

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
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLectFetch;
    private javax.swing.JButton btnStudShow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblStudLectInfo;
    // End of variables declaration//GEN-END:variables
}
