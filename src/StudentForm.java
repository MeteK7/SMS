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
        Welcoming();
        LectureApproval();
        LoadTblSchedule();
        LoadTblExamSchedule();
        LoadTblAnnouncement();
        LoadTblExamResult();
        
    }
    
    private void Welcoming(){
        String name="", surname="", fullname;
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDENTINFO WHERE TCNUM='"+ studTc +"'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                name=rs.getString("NAME");
                surname=rs.getString("SURNAME");
            }
            
            fullname=name+" "+surname;
            
            lblFullName.setText(fullname);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }     
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
    
    private String FindNameUsingTc(String tc,String position){
         String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        String sql;
        String fullName="";

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            
            if ("lecturer".equals(position)) {
                sql="SELECT * FROM LECTURERINFO WHERE TCNUM='"+ tc +"'";
            }
            else
                sql="SELECT * FROM ASSISTANTINFO WHERE TCNUMBER='"+ tc +"'";
            
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
            fullName=rs.getString("NAME")+" "+rs.getString("SURNAME");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }         
    
    
    return fullName;
    
    }
    
    private int VerifyPassing(String lectureCode){
         String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        String sql="SELECT * FROM STUDLECTCHOICE WHERE TCNUM='"+ studTc +"'AND LECTURECODE='"+ lectureCode +"'";
        int repeat=0;

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
           
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
              /*JOptionPane.showInputDialog("INSIDE OF VERIFYPASSING WHILE LOOP!!!");
                JOptionPane.showInputDialog("LECTURE CODE FROM PARAMETER"+lectureCode);
                JOptionPane.showInputDialog("LECTURE CODE FROM DB"+rs.getString("LECTURECODE"));
                JOptionPane.showInputDialog(rs.getString("STATUS"));*/
                if ("FAILED".equals(rs.getString("STATUS"))) {
                    repeat=rs.getInt("REPEAT");
                    repeat=repeat+1;
                }
                else {
                    repeat=-1;
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    
    return repeat;
    
    }
    private int FetchEduYear(){
         String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        String sql="SELECT * FROM STUDENTINFO WHERE TCNUM='"+ studTc +"'";
        int eduYear=0;

        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
           
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                eduYear=rs.getInt("EDUYEAR");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    
    return eduYear;    
    
    }
            
            
    /*private void UpdateLecture(int repeat, String lectureCode, String newSemester){
        String host ="jdbc:derby://localhost:1527/SchoolDataBase";
        String userName="school";
        String userPass="123456";
        
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass); //We have a connection here.


            String sql="UPDATE STUDLECTCHOICE SET STATUS='Unknown', REPEAT="+repeat+",SEMESTER="+newSemester+"  WHERE TCNUM='"+ studTc +"' AND LECTURECODE='"+lectureCode+"'"; //This code owerwrite to the old lecture informations. Improve here you should add the new same lesson but the repeat will be different!!!
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.executeUpdate();// execute the java preparedstatement               
            con.close();                      
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }         
 
    
    }*/
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
    
    private void LoadTblExamSchedule(){
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
             
                String sql="SELECT * FROM EXAMSCHEDULE WHERE LECTUREDAY='"+ days[counter] +"'";
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
        
        DefaultTableModel tm=(DefaultTableModel)tblExamSchedule.getModel();
        
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
        jScrollPane5 = new javax.swing.JScrollPane();
        tblExamSchedule = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
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

        tblSchedule.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        tblSchedule.setRowHeight(32);
        jScrollPane2.setViewportView(tblSchedule);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(531, 368, 740, 370);

        tblExamSchedule.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tblExamSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "20.05.2019 MONDAY", "21.05.2019 TUESDAY", "22.05.2019 WEDNESDAY", "23.05.2019 THURSDAY", "24.05.2019 FRIDAY"
            }
        ));
        tblExamSchedule.setRowHeight(32);
        jScrollPane5.setViewportView(tblExamSchedule);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(20, 370, 500, 370);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("EXAM SCHEDULE");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 314, 210, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("WEEKLY SCHEDULE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(540, 320, 230, 40);

        lblFullName.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblFullName.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(lblFullName);
        lblFullName.setBounds(70, 120, 350, 80);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 153, 153));
        lblWelcome.setText("WELCOME");
        jPanel1.add(lblWelcome);
        lblWelcome.setBounds(20, 20, 290, 90);

        tblAnnoun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        tblAnnoun.setRowHeight(24);
        jScrollPane3.setViewportView(tblAnnoun);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(420, 11, 850, 290);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MeteK\\Desktop\\Lessons\\Java Programming\\SchoolManagementSystem\\Abstract-Background-White.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -2, 1180, 760);

        jTabbedPane1.addTab("start", jPanel1);

        jPanel2.setLayout(null);

        tblStudLectInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "LECTURE NAME", "TYPE", "CREDIT", "AKTS", "CHOICE", "TEACHER", "ASSISTANT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStudLectInfo);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(250, 10, 1020, 590);

        btnLectFetch.setText("FETCH");
        btnLectFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLectFetchActionPerformed(evt);
            }
        });
        jPanel2.add(btnLectFetch);
        btnLectFetch.setBounds(10, 11, 230, 54);

        btnStudShow.setText("SHOW");
        btnStudShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudShowActionPerformed(evt);
            }
        });
        jPanel2.add(btnStudShow);
        btnStudShow.setBounds(10, 83, 230, 53);

        btnStudLectUpdate.setText("UPDATE");
        btnStudLectUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudLectUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnStudLectUpdate);
        btnStudLectUpdate.setBounds(10, 154, 230, 57);

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(0, 51, 255));
        jPanel2.add(lblInfo);
        lblInfo.setBounds(390, 620, 650, 80);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1320, 852));
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
        String teacherFullName;
        String assistantFullName;
        semester=FetchSemester();
        String unknownTc;
        String unknownAssistTc;
        int eduYear=FetchEduYear();
        try{
            Connection con=DriverManager.getConnection(host, userName,userPass);
            String sql="SELECT * FROM STUDLECTCHOICE WHERE TCNUM='"+ studTc +"' AND SEMESTER='"+semester+"' AND EDUYEAR="+eduYear+""; //Please improve this query according to also the education year!!!
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();

            /*tblStudLectInfo.setModel(DbUtils.resultSetToTableModel(rs));  This code for fetching all the datas including column names.*/
            DefaultTableModel tm=(DefaultTableModel)tblStudLectInfo.getModel();
            tm.setRowCount(0);

            while(rs.next()){
                unknownTc=rs.getString("TEACHERTC");
                unknownAssistTc=rs.getString("ASSISTANTTC");
                teacherFullName=FindNameUsingTc(unknownTc,"lecturer");
                assistantFullName=FindNameUsingTc(unknownAssistTc,"assistant");
                /*JOptionPane.showInputDialog(assistantFullName);*/
                Object o[]={rs.getString("LECTURECODE"),rs.getString("LECTURENAME"),rs.getString("TYPE"),rs.getString("CREDIT"),rs.getString("AKTS"),rs.getBoolean("CHOICE"),teacherFullName,assistantFullName};
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
        String query="INSERT INTO STUDLECTCHOICE (TCNUM, LECTUREID, LECTURECODE, LECTURENAME, TYPE, CREDIT, AKTS, CHOICE, SEMESTER, CONFIRMATION,TEACHERTC, ASSISTANTTC, STATUS, REPEAT,EDUYEAR) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String lectureCode;
        String lectureId;
        String lectureName;
        String lectureType;
        String lectureCredit;
        String lectureAkts;
        String lecturerTc;
        String assistantTc;
        Boolean lectureChoice;
        int eduYear;
        int repeat;
        int currSemester;
        semester=FetchSemester();

        try
        {
            Connection con = DriverManager.getConnection(host,userName,userPass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LECTURES WHERE SEMESTER="+semester+"");/* */
            while ( rs.next() ) {
                repeat=0;
                lectureCode = rs.getString("CODE");
                lectureId = rs.getString("ID");
                lectureName = rs.getString("NAME");
                lectureType = rs.getString("TYPE");
                lectureCredit = rs.getString("CREDIT");
                lectureAkts = rs.getString("AKTS");
                lecturerTc=rs.getString("TEACHERTC");
                assistantTc=rs.getString("ASSISTANTTC");
                lectureChoice = false;
                currSemester=rs.getInt("SEMESTER");
                
                repeat=VerifyPassing(lectureCode);
                
                eduYear=FetchEduYear();
                
                /*JOptionPane.showInputDialog("Repeat: "+repeat);
                JOptionPane.showInputDialog("Semester from Database: "+currSemester);
                JOptionPane.showInputDialog("Semester from fetchsemester method: "+semester);*/
                if (repeat!=-1) {
                    /*rs = stmt.executeQuery("SELECT * FROM LECTURES WHERE SEMESTER="+semester+"");*/
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
                        st.setString(12,assistantTc);
                        st.setString(13,"Unknown");
                        st.setInt(14,(repeat));
                        st.setInt(15, eduYear);
                        st.executeUpdate();

                    }
                    catch ( SQLException err ) {
                        JOptionPane.showInputDialog("Error!");
                    }

                }
                /*else{
                   JOptionPane.showInputDialog("Lesson COde: "+lectureCode+"  REPEAT: "+repeat);
                   UpdateLecture(repeat,lectureCode,Integer.toString(semester));
                }*/
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblAnnoun;
    private javax.swing.JTable tblExamResult;
    private javax.swing.JTable tblExamSchedule;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTable tblStudLectInfo;
    // End of variables declaration//GEN-END:variables
}
