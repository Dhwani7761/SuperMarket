
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dhwani
 */
public class AllFruits extends javax.swing.JFrame {
     public static String dppath ="E:/Night_Fury/Sem 4/JAVA/OnlineGroceryShopping/java.accdb";
    public static Connection con = null;
    public static Statement s = null;
    public static ResultSet rs = null;
        
    /**
     * Creates new form AllFruits
     */
    private ArrayList<String> ar = new ArrayList<String>();
   //private ArrayList<Integer> ar1 = new ArrayList<Integer>();
    public AllFruits() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
          try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + dppath);
            Statement st = con.createStatement();
            String str = "Select * from Item_Purchase WHERE Category_Id = 3";
            rs = st.executeQuery(str);
            System.out.println(str);
            // for (int i = 0; i < rs.getRow(); i++) {
            int i = 0;
            while (rs.next()) {
                java.awt.Checkbox itemCheckbox = new java.awt.Checkbox();
                itemCheckbox.setBackground(new java.awt.Color(255, 255, 255));
                itemCheckbox.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
                //itemCheckbox.setLabel("  Garlic Paste (Rs.42 / 200gm)");
                itemCheckbox.setLabel(rs.getString("Item_Name"));

                System.out.println(rs.getString("Item_Name") + "(Rs. " + rs.getString("Price") + "/ " + rs.getString("Per_grams_or_unit") + ")");
             
                itemCheckbox.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        itemClicked(evt);
                    }
                });
                jPanel1.add(itemCheckbox);
                itemCheckbox.setBounds(500,(i*60)+300,300,500);

                ////
                java.awt.Label itemLabel = new java.awt.Label();
                itemLabel.setAlignment(java.awt.Label.CENTER);
                itemLabel.setBackground(new java.awt.Color(255, 255, 255));
                itemLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
                itemLabel.setText("(Rs. " + rs.getString("Price") + "/ " + rs.getString("Per_grams_or_unit") + ")");
                jPanel1.add(itemLabel);
                itemLabel.setBounds(500, (i * 60) + 300, 300, 500);
                //getContentPane().add(itemLabel);
                jPanel1.add(itemLabel);
                i++;
            }
        } catch (Exception e) {
        }
    }   private void itemClicked(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            System.out.println(evt.getItem().toString());
            ar.add(evt.getItem().toString());
            //ar1.add(evt.getItem());
            System.out.println(ar);

        } else {
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jLabel1.setText("All Fruits");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(370, 80, 220, 67);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/onlinegroceryshopping/1_friuts copy.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, -6, 1030, 220);

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/onlinegroceryshopping/Back.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 630, 70, 70);

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/onlinegroceryshopping/AddToCart.jpg"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(460, 630, 70, 70);

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/onlinegroceryshopping/ProceedToCart.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(790, 630, 70, 70);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 210, 1020, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new VegetablesAndFriuts().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + dppath);
            Statement st = con.createStatement();

            for (i = 0; i < ar.size(); i++) {
                String str = "insert into Cart(Item_Name,Price) values('" + ar.get(i).toString() +");";
                System.out.println(str);
                st.executeUpdate(str);
            }
        } catch (Exception es) {

        }
        //for each
        //insert into cart 
        for (i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        
       }
        JOptionPane.showMessageDialog(this , "Items Added to Cart");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
       new MyCart().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AllFruits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllFruits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllFruits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllFruits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllFruits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
