import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class library implements ActionListener {
    static JFrame f, f1, f2, f3, f4, f5, f6, f7, f8, f9;
    static JLabel L1, L2, L3;
    static JTextField T, T1, t3, t4,t5,t6;
    static JButton B, B1, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17,b18,b19;
    JTable table = new JTable();



    library() {

        //Frame 10 BOOK RETURN FRAME
        f9 = new JFrame();
        JLabel f9l1=new JLabel(" Your Name");
        JLabel f9l2=new JLabel(" Book Name");
        b18=new JButton("Return");
        b18.setBounds(100,300,70,40);
        b18.addActionListener(this);
        t5=new JTextField();
        t6=new JTextField();
        f9l1.setBounds(40,40,100,40);
        t5.setBounds(40,80,100,40);
        f9l2.setBounds(40,120,100,40);
        t6.setBounds(40,160,100,40);
        f9.setSize(300, 400);
        f9.setLocation(400, 60);
        f9.setVisible(false);
        f9.setLayout(null);
        B17 = new JButton("Back");
        B17.setBounds(20, 10, 80, 20);
        B17.addActionListener(this);
        f9.add(B17);
        f9.add(f9l1);
        f9.add(f9l2);
        f9.add(t5);
        f9.add(t6);
        f9.add(b18);
        //Frame 09 BOOK ISSUE FRAME
        f8 = new JFrame("BOOK ISSUE");
        b19=new JButton("Return");
        b19.addActionListener(this);
        b19.setBounds(100,300,80,50);
        f8.setSize(800, 400);
        f8.setLocation(400, 60);
        f8.setVisible(false);
        f8.setLayout(null);
        B16 = new JButton("Back");
        B16.setBounds(20, 330, 80, 20);
        B16.addActionListener(this);
        f8.add(B16);
        f8.add(b19);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(10,11,712,226);
        f8.add(scrollPane);
        scrollPane.setViewportView(table);
        //FRAME03
        f2 = new JFrame("CATEGORY");
        f2.setSize(900, 300);
        //  f2.setLocation(400, 60);
        f2.setVisible(false);
        f2.setLayout(null);
        t3 = new JTextField();
        t4 = new JTextField();

        JLabel f6l1 = new JLabel("Your  Name");
        JLabel f6l2 = new JLabel("Book Name");
        f6l1.setBounds(500, 40, 100, 30);
        t3.setBounds(500, 80, 100, 20);
        f6l2.setBounds(500, 120, 100, 30);
        t4.setBounds(500, 160, 100, 20);

        B10 = new JButton("Back");
        B10.setBounds(20, 10, 80, 20);
        B10.addActionListener(this);
        f2.add(B10);


        JLabel hi1 = new JLabel("History:  1.A personal History   2.A New History     3.The Great Partition");
        hi1.setBounds(10, 20, 400, 30);

        JLabel mo1 = new JLabel("Motivation: 1.Think and Grow Rich    2.The Power of Habit    3.Outliers");
        mo1.setBounds(10, 60, 400, 30);

        JLabel ur1 = new JLabel("Urdu:  1.Pir e kamil    2.Zindagi   3.Aak din");
        ur1.setBounds(10, 100, 400, 30);

        JLabel en1 = new JLabel("English:  1.The outsider    2.The Giver  3.Great expectations");
        en1.setBounds(10, 140, 400, 30);
        f2.add(mo1);
        f2.add(ur1);
        f2.add(hi1);
        f2.add(en1);
        f2.add(f6l1);
        f2.add(f6l2);
        f2.add(t3);
        f2.add(t4);


        //frame 02
        f1 = new JFrame("LIBRARY MANAGEMENT");
        f1.setSize(300, 400);
        f1.setLocation(400, 60);
        f1.setVisible(false);
        f1.setLayout(null);
        B1 = new JButton("Category");
        B1.setBounds(90, 60, 120, 30);
        B1.addActionListener(this);
        f1.add(B1);

        B3 = new JButton("Book issue");
        B3.setBounds(90, 120, 120, 30);
        B3.addActionListener(this);
        f1.add(B3);
        B4 = new JButton("Book Return");
        B4.setBounds(90, 180, 120, 30);
        B4.addActionListener(this);
        f1.add(B4);
        B5 = new JButton("Logout");
        B5.setBounds(150, 300, 120, 20);
        f1.add(B5);
        B5.addActionListener(this);
        //FRAME01
        f = new JFrame("library management");
        f.setSize(700, 450);
        f.setLocation(400, 60);
        f.setVisible(true);
        f.setLayout(null);
        L1 = new JLabel("LIBRARY MANAGEMENT");
        L1.setBounds(250, 25, 550, 50);
        f.add(L1);
        L2 = new JLabel("USERNAME");
        L2.setBounds(200, 80, 500, 50);
        f.add(L2);
        L3 = new JLabel("PASSWORD");
        L3.setBounds(200, 120, 500, 50);
        f.add(L3);
        T = new JTextField();
        T.setBounds(300, 90, 120, 20);
        f.add(T);
        T1 = new JTextField();
        T1.setBounds(300, 130, 120, 20);
        f.add(T1);
        B = new JButton("LOGIN");
        B.setBounds(330, 170, 120, 20);
        B.addActionListener(this);
        f.add(B);
    }

    public static void main(String[] args) {
        new library();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B) {
            String x, y;
            x = T.getText();
            y = T1.getText();
            int z = 0;
         try{
            Connection con = jdbc.create();
            Statement st = con.createStatement();
            String q = "select us,pass from login";
            ResultSet rs = st.executeQuery(q);
            ResultSetMetaData rsd = rs.getMetaData();
            int col = rsd.getColumnCount();
            String[] colname = new String[col];
            for (int i = 0; i < col; i++) {
                colname[i] = rsd.getColumnName(i + 1);
            }

            String em = "", pas = "";
            while (rs.next()) {
                em = rs.getString(1);
                pas = rs.getString(2);
                if (Objects.equals(em, x) && Objects.equals(pas, y)) {
                    z = 1;
                    break;
                }


            }
            if (Objects.equals(z, 0) || Objects.equals(em, "") || Objects.equals(pas, "")) {
                JOptionPane.showMessageDialog(null, "username or password is incorrect");

            }}
         catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "not done");
            }
              if (Objects.equals(z, 1)) {


            f.setVisible(false);
            f1.setVisible(true);
            }
        }


        if (e.getSource() == B1) {
            f1.setVisible(false);
            f2.setVisible(true);
        }
        if (e.getSource() == B6) {
            f2.setVisible(false);
            f3.setVisible(true);
        }
        if (e.getSource() == B7) {
            f2.setVisible(false);
            f4.setVisible(true);
        }
        if (e.getSource() == B8) {
            f2.setVisible(false);
            f5.setVisible(true);
        }
        if (e.getSource() == B9) {
            f2.setVisible(false);
            f6.setVisible(true);
        }
        if (e.getSource() == B10) {

            try {
                Connection con = jdbc.create();
                String q = "insert into book(name,book)values (?,?)";
                PreparedStatement stm = con.prepareStatement(q);
                stm.setString(1, t3.getText());
                stm.setString(2, t4.getText());
                stm.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            f2.setVisible(false);
            f1.setVisible(true);
        }
        if (e.getSource() == B11) {
            f3.setVisible(false);
            f2.setVisible(true);
        }

        if (e.getSource() == B3) {
b19.setEnabled(true);
            f1.setVisible(false);
            f8.setVisible(true);
        }
        if(e.getSource()==b19){
            try {
                Connection con = jdbc.create();
                Statement st = con.createStatement();
                String q = "select * from book";

                ResultSet rs = st.executeQuery(q);
                ResultSetMetaData rsd = rs.getMetaData();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int col = rsd.getColumnCount();
                String[] colname = new String[col];
                for (int i = 0; i < col; i++) {
                    colname[i] = rsd.getColumnName(i + 1);
                }
                model.setColumnIdentifiers(colname);
                String nam, iss;
                while (rs.next()) {
                    nam = rs.getString(1);
                    iss = rs.getString(2);
                    String[] row = {nam, iss};
                    model.addRow(row);
                }
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            b19.setEnabled(false);
        }
        if (e.getSource() == B9) {
            f1.setVisible(false);
            f9.setVisible(true);
        }
        if (e.getSource() == B12) {
            f4.setVisible(false);
            f2.setVisible(true);
        }
        if (e.getSource() == B13) {
            f5.setVisible(false);
            f2.setVisible(true);
        }
        if (e.getSource() == B14) {
            f6.setVisible(false);
            f2.setVisible(true);
        }
        if (e.getSource() == B15) {
            f7.setVisible(false);
            f1.setVisible(true);
        }
        if (e.getSource() == B16) {
            f8.setVisible(false);
            f1.setVisible(true);
        }
        if (e.getSource() == B17) {
            f9.setVisible(false);
            f1.setVisible(true);
        }
        if(e.getSource()==b18){
            try {
                Connection con=jdbc.create();
                String q="delete from book where name=? and book = ?";
                PreparedStatement st=con.prepareStatement(q);
                st.setString(1,t5.getText());
                st.setString(2,t6.getText());

                st.executeUpdate();
                JOptionPane.showMessageDialog(null,"done");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"not");
                ex.printStackTrace();
            }
        }
        if (e.getSource() == B4) {
            f1.setVisible(false);
            f9.setVisible(true);
        }
        if(e.getSource()==B5){
            f1.setVisible(false);
            f.setVisible(true);
        }
    }
}