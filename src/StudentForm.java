import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentForm extends javax.swing.JFrame {

    public StudentForm() {
        initComponents();
        /*DisplayTable();*/
        
    }
    int semester;
    String studTc;
    String studDept;
    public StudentForm(String tc,String dept){
        studTc=tc;
        studDept=dept;
        initComponents();
        LectureApproval();
        LoadTblSchedule();
        LoadTblAnnouncement();
        LoadTblExamResult();
        
    }
    
    private int FetchSemester(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDENTINFO WHERE TCNUM='"+ studTc +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                semester=rs.getInt("FETCHSEMESTER");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }    
    
        return semester;
    }
    private void LoadTblExamResult(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDLECTCHOICE WHERE TCNUM='"+ studTc +"' AND SEMESTER='"+ cmbSemester.getSelectedItem()+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)tblExamResult.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
            
            Object o[]={rs.getString("LECTURENAME"),rs.getString("MIDTERM"),rs.getString("PROJECT"),rs.getString("FINAL"),rs.getString("AVERAGE"),rs.getString("LETTERGRADE")};
            tm.addRow(o);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    
    
    
    
    
    }
    private void LoadTblAnnouncement(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM ANNOUNCEMENT WHERE DEPARTMENT='"+ studDept +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)tblAnnoun.getModel();
            
            while(rs.next()){
            
            Object o[]={rs.getString("LECTURERNAME"),rs.getString("ANNOUNCEMENT"),rs.getString("LINK")};
            tm.addRow(o);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }
    
    private void LoadTblSchedule(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        Connection con;
        
        int counter = 0;
        int dayAmount = 5;
        int[] lectPerDay=new int[]{0,0,0,0,0};
        String[] days = new String[] {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
        String[] monday=new String[10];
        String[] tuesday=new String[10];
        String[] wednesday=new String[10];
        String[] thursday=new String[10];
        String[] friday=new String[10];
    
        while(counter<dayAmount){
            try{
                con=DriverManager.getConnection(host, userName,userPass);
             
                String sql="SELECT * FROM SCHEDULE WHERE LECTUREDAY='"+ days[counter] +"'";
                PreparedStatement stmt=con.prepareStatement(sql);
                ResultSet rs=stmt.executeQuery();
                                

                /*tblStudLectInfo.setModel(DbUtils.resultSetToTableModel(rs));  This code for fetching all the datas including column names.*/
                

                while(rs.next()){
                    if ("MONDAY".equals(days[counter])) {
                        monday[lectPerDay[0]]=rs.getString("LECTURECODE")+"  "+rs.getString("TIME");
                        lectPerDay[0]=lectPerDay[0]+1;
                        /*Object o[]={"",rs.getString("LECTURECODE")};
                        tm.addRow(o);*/
                    }
                    else if("TUESDAY".equals(days[counter])){
                        tuesday[lectPerDay[1]]=rs.getString("LECTURECODE")+"  "+rs.getString("TIME");
                        lectPerDay[1]=lectPerDay[1]+1;                
                    }
                    else if("WEDNESDAY".equals(days[counter])){
                        wednesday[lectPerDay[2]]=rs.getString("LECTURECODE")+"  "+rs.getString("TIME");
                        lectPerDay[2]=lectPerDay[2]+1;              
                    }
                    else if("THURSDAY".equals(days[counter])){
                        thursday[lectPerDay[3]]=rs.getString("LECTURECODE")+"  "+rs.getString("TIME");
                        lectPerDay[3]=lectPerDay[3]+1;                 
                    }
                    else{
                        friday[lectPerDay[4]]=rs.getString("LECTURECODE")+"  "+rs.getString("TIME");
                        lectPerDay[4]=lectPerDay[1]+1;                
                    }

                }

            } 
            
            catch (HeadlessException | SQLException e) 
            {
            JOptionPane.showMessageDialog(null, e);
            }   
            
            counter=counter+1;
        }
        int i=0;
        
        DefaultTableModel tm=(DefaultTableModel)tblSchedule.getModel();
        
        while(i<monday.length || i<tuesday.length || i<wednesday.length || i<thursday.length || i<friday.length)   //IMPROVE THIS PART METE !!!
        {
            Object o[]={monday[i],tuesday[i],wednesday[i],thursday[i],friday[i]};
            tm.addRow(o);    
            
            i=i+1;
        }
    
    
    }

    private void LectureApproval(){
     
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        int approval=0;
        int fetch=0;
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDENTINFO WHERE TCNUM='"+ studTc +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                approval=rs.getInt("APPROVAL");
                fetch=rs.getInt("FETCHDATA");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }    
        
        if (fetch==0) {
            btnLectFetch.setEnabled(false);
        }  
        
        switch (approval) {
            case 0:
                lblInfo.setText("WAITING FOR APPROVAL");
                break;
            case 1:
                lblInfo.setText("Your lectures are approved!");
                btnStudLectUpdate.setEnabled(false);
                break;
            default:
                lblInfo.setText("Please choose your lectures from your list.");
                break;
        }
       

    }
    
    private void UpdateFetchFromDb(){ 
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass); //We have a connection here.
            String sql="UPDATE STUDENTINFO SET FETCHDATA=0 WHERE TCNUM='"+ studTc +"'"; 
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.executeUpdate();// execute the java preparedstatement               
            con.close();                      
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }      
    
        btnLectFetch.setEnabled(false);
    
    }
    
    /*private void DisplayTable(){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM LECTURES WHERE SEMESTER='"+ semester +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            //tblStudLectInfo.setModel(DbUtils.resultSetToTableModel(rs));  This code for fetching all the datas including column names.
            DefaultTableModel tm=(DefaultTableModel)tblStudLectInfo.getModel();
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[]={rs.getString("CODE"),rs.getString("NAME"),rs.getString("TYPE"),rs.getString("CREDIT"),rs.getString("AKTS"),rs.getBoolean("CHOICE")};
                tm.addRow(o);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        

    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAnnoun = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudLectInfo = new javax.swing.JTable();
        btnLectFetch = new javax.swing.JButton();
        btnStudShow = new javax.swing.JButton();
        btnStudLectUpdate = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblExamResult = new javax.swing.JTable();
        cmbSemester = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSchedule.setRowHeight(22);
        jScrollPane2.setViewportView(tblSchedule);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(531, 368, 647, 379);

        tblAnnoun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher", "Announcement", "Link"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAnnoun);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 11, 1164, 351);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\Abstract-Background-White.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -2, 1180, 760);

        jTabbedPane1.addTab("start", jPanel1);

        jPanel2.setLayout(null);

        tblStudLectInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(536, 11, 648, 402);

        btnLectFetch.setText("FETCH");
        btnLectFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLectFetchActionPerformed(evt);
            }
        });
        jPanel2.add(btnLectFetch);
        btnLectFetch.setBounds(10, 11, 347, 54);

        btnStudShow.setText("SHOW");
        btnStudShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudShowActionPerformed(evt);
            }
        });
        jPanel2.add(btnStudShow);
        btnStudShow.setBounds(10, 83, 347, 53);

        btnStudLectUpdate.setText("UPDATE");
        btnStudLectUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudLectUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnStudLectUpdate);
        btnStudLectUpdate.setBounds(10, 154, 347, 57);

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(0, 51, 255));
        jPanel2.add(lblInfo);
        lblInfo.setBounds(536, 456, 638, 65);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\Abstract-Background-White.jpg")); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, -2, 1180, 760);

        jTabbedPane1.addTab("course pre-registration", jPanel2);

        jPanel5.setLayout(null);

        tblExamResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lecture Name", "Midterm", "Project", "Final", "Average", "Letter Grade"
            }
        ));
        tblExamResult.setRowHeight(50);
        jScrollPane4.setViewportView(tblExamResult);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(10, 44, 1164, 699);

        cmbSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        cmbSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemesterActionPerformed(evt);
            }
        });
        jPanel5.add(cmbSemester);
        cmbSemester.setBounds(10, 11, 112, 27);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\Abstract-Background-White.jpg")); // NOI18N
        jPanel5.add(jLabel3);
        jLabel3.setBounds(0, -2, 1180, 760);

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

        setSize(new java.awt.Dimension(1225, 843));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemesterActionPerformed
        LoadTblExamResult();
    }//GEN-LAST:event_cmbSemesterActionPerformed

    private void btnStudLectUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudLectUpdateActionPerformed

        int choiceColumn = 5;
        int lectCodeColumn = 0;
        int currentRow = 0;
        int rowAmount=tblStudLectInfo.getRowCount();

        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass); //We have a connection here.

            while(currentRow<rowAmount){
                String lectCode=tblStudLectInfo.getModel().getValueAt(currentRow,lectCodeColumn).toString();
                String tempChoice=tblStudLectInfo.getModel().getValueAt(currentRow,choiceColumn).toString();
                Boolean valueChoice=Boolean.parseBoolean(tempChoice);
                String sql="UPDATE STUDLECTCHOICE SET CHOICE= '" + valueChoice +"' WHERE TCNUM='"+ studTc +"' AND LECTURECODE='"+ lectCode +"'";  //We are clearing the old supervisor of the department.
                PreparedStatement stmt=con.prepareStatement(sql);

                stmt.executeUpdate();// execute the java preparedstatement

                currentRow=currentRow+1;
            }
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnStudLectUpdateActionPerformed

    private void btnStudShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudShowActionPerformed

        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";

        semester=FetchSemester();

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDLECTCHOICE WHERE TCNUM='"+ studTc +"' AND SEMESTER='"+semester+"'"; //Please improve this query according to also the education year!!!
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();

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
        String query="INSERT INTO STUDLECTCHOICE (TCNUM, LECTUREID, LECTURECODE, LECTURENAME, TYPE, CREDIT, AKTS, CHOICE,SEMESTER,CONFIRMATION,TEACHERTC) values(?,?,?,?,?,?,?,?,?,?,?)";

        String lectureCode;
        String lectureId;
        String lectureName;
        String lectureType;
        String lectureCredit;
        String lectureAkts;
        String lecturerTc;
        Boolean lectureChoice;

        semester=FetchSemester();

        try
        {
            Connection con = DriverManager.getConnection(host,userName,userPass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LECTURES WHERE SEMESTER="+semester+"");
            while ( rs.next() ) {
                lectureCode = rs.getString("CODE");
                lectureId = rs.getString("ID");
                lectureName = rs.getString("NAME");
                lectureType = rs.getString("TYPE");
                lectureCredit = rs.getString("CREDIT");
                lectureAkts = rs.getString("AKTS");
                lecturerTc=rs.getString("TEACHERTC");
                lectureChoice = false;

                try{
                    PreparedStatement st=con.prepareStatement(query);
                    st.setString(1,studTc);
                    st.setString(2,lectureId);
                    st.setString(3,lectureCode);
                    st.setString(4,lectureName);
                    st.setString(5,lectureType);
                    st.setString(6,lectureCredit);
                    st.setString(7,lectureAkts);
                    st.setBoolean(8,lectureChoice);
                    st.setString(9, Integer.toString(semester));
                    st.setString(10,lessonConfirm);
                    st.setString(11,lecturerTc);
                    st.executeUpdate();

                }
                catch ( SQLException err ) {
                    JOptionPane.showInputDialog("Error!");
                }

            }
            con.close();

            UpdateFetchFromDb();
        }

        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnLectFetchActionPerformed
    
    String lessonConfirm="0";

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
    private javax.swing.JButton btnStudLectUpdate;
    private javax.swing.JButton btnStudShow;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTable tblAnnoun;
    private javax.swing.JTable tblExamResult;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTable tblStudLectInfo;
    // End of variables declaration//GEN-END:variables
}
