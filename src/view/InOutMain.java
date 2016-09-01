/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author SEMH
 */
public class InOutMain extends javax.swing.JFrame {

    /**
     * Creates new form InOut
     */
    public InOutMain() {
        initComponents();
       setDateAndTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eid = new javax.swing.JTextField();
        date = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eid.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        eid.setForeground(new java.awt.Color(0, 0, 255));
        eid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });
        getContentPane().add(eid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 197, 40));

        date.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 120, 40));

        msg.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 255, 255));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        msg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msgMouseClicked(evt);
            }
        });
        msg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                msgKeyPressed(evt);
            }
        });
        getContentPane().add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 195, 40));

        time.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 120, 40));

        jLabel1.setFont(new java.awt.Font("Leelawadee", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USER ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 70, 40));

        jLabel2.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void msgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msgKeyPressed

    }//GEN-LAST:event_msgKeyPressed

    private void msgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msgMouseClicked
      
    }//GEN-LAST:event_msgMouseClicked

    private void eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidActionPerformed
        try {
            Date d = new Date();
            String sdf = new SimpleDateFormat("yyyy-MM-dd").format(d);

            String sdf2 = new SimpleDateFormat("hh:mm:ss").format(d);
            String timelbl = date.getText();
            String st = timelbl.substring(0, 2);
            
            System.out.println(st);
            int i = Integer.parseInt(st);
            String s = null;
            if (i <= 9) {
                s = "Good";
            } 
            else if(i>9)
            {
            eid.setEnabled(false);
            }
            MyDb.set("insert into inout(userid,date,intime,details) values('" + eid.getText() + "','" + sdf + "','" + sdf2 + "','" + s + "')");
            
            msg.setText("Welcome");
        } catch (Exception ex) { 

            try {
                Date d = new Date();

                SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
                MyDb.set("update inout set outtime='" + sdf2.format(d) + "' where eid='" + eid.getText() + "'");
                msg.setText("Good Buy");
            } catch (Exception ex1) {
                Logger.getLogger(InOutMain.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }//GEN-LAST:event_eidActionPerformed

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
            java.util.logging.Logger.getLogger(InOutMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InOutMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InOutMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InOutMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InOutMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JTextField eid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
  Date d;
    SimpleDateFormat sdf1;
    SimpleDateFormat sdf2;
    
    private void setDateAndTime() {
        try {
            Timer t = new Timer(1000, new ActionListener() {
                
                
                public void actionPerformed(ActionEvent e) {
                  d = new Date();
                  sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                  date.setText(sdf1.format(d));
                  sdf2 = new SimpleDateFormat("hh:mm:ss");
                  
                  time.setText(sdf2.format(d));
                  String s1 = sdf2.format(d).substring(0, 2);
                  String s2 = sdf2.format(d).substring(3, 5);
                  int t1 = Integer.parseInt(s1);
                  int t2 = Integer.parseInt(s2);
//                    System.out.println(s1+""+s2);
                  if(t1 == 9 && t2 == 00)
                  {
                  eid.setEnabled(false);
                  } 
                  else if(t1 == 7 && t2 == 00)
                  {
                  eid.setEnabled(true);
                  }
                  d = null;
                  sdf1 = null;
                  sdf2 = null;
                  System.gc();
                }
            });
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}