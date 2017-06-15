package semesterprojekt2ekg;

import java.awt.*;
import static java.awt.Color.*;
import javax.swing.*;

public class Gui extends javax.swing.JPanel {

    private boolean start = false;
    private boolean EKG = false;
    private JFrame helpFrame = null;
    private Graf graph;

    public Gui(Graf g) {
        initComponents();
        graph = g;
        stopButton.setVisible(false);
        //Stopknappen vises ikke når programmet åbnes

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        statiskEkgButton = new javax.swing.JButton();
        bpmtxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);

        startButton.setBackground(new java.awt.Color(102, 102, 102));
        startButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("Påbegynd undersøgelse");
        startButton.setActionCommand("start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setBackground(new java.awt.Color(102, 102, 102));
        stopButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        stopButton.setForeground(new java.awt.Color(255, 255, 255));
        stopButton.setActionCommand("stop");
        stopButton.setLabel("Afslut undersøgelse");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        statiskEkgButton.setBackground(new java.awt.Color(102, 102, 102));
        statiskEkgButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        statiskEkgButton.setForeground(new java.awt.Color(255, 255, 255));
        statiskEkgButton.setText("Tidligere EKG");
        statiskEkgButton.setActionCommand("statisk");
        statiskEkgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statiskEkgButtonActionPerformed(evt);
            }
        });

        bpmtxt.setEditable(false);
        bpmtxt.setBackground(new java.awt.Color(0, 0, 0));
        bpmtxt.setFont(new java.awt.Font("Century Gothic", 1, 70)); // NOI18N
        bpmtxt.setForeground(new java.awt.Color(255, 255, 255));
        bpmtxt.setText("PULS");
        bpmtxt.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        bpmtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpmtxtActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("bpm");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/semesterprojekt2ekg/heartecg.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HR");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(bpmtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(statiskEkgButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(497, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bpmtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statiskEkgButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        
        startButton.setVisible(false);
        stopButton.setVisible(true);
        setStart(true);
        
        //Når startButton er er falsk=ikke vist er stop.Button true=vist
    }//GEN-LAST:event_startButtonActionPerformed

    private void statiskEkgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statiskEkgButtonActionPerformed
        setEKG(true);
        JOptionPane.showMessageDialog(helpFrame, "Denne del af kode er ikke implementeret endnu");
    }//GEN-LAST:event_statiskEkgButtonActionPerformed

    private void bpmtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpmtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bpmtxtActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        setStart(false);
        startButton.setVisible(true);
        stopButton.setVisible(false);

        //Når startButton er true=vist og stopButton er false=ikke vist
    }//GEN-LAST:event_stopButtonActionPerformed

    public void setPuls(double puls) {
        bpmtxt.setText("" + puls);
        //Repaint graf?
    }

    public void getInterval() {
        //læser interval brugeren ønsker at tegne statisk graf over
    }

    public void setStart(boolean value) {
        start = value;
        //Vi sætter den bolske værdi start til den værdi der er angivet som parameter
    }

    public boolean getStart() {
        return start;
        //Fortæller om der er trykket på startknap eller ej 
    }
    
    public void setGraf(){
        graph.repaint();
    }

    public void setEKG(boolean value) {
        EKG = value;
        //Vi sætter den bolske værdi EKG til den værdi der er angivet som parameter
    }

    public boolean getEKG() {
        return EKG;
        //Fortæller om der er trykket på EKGknap eller ej 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bpmtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton startButton;
    private javax.swing.JButton statiskEkgButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Ruminddeling
        g.setColor(white);

        // Vandret hvid linje.
        g.fillRect(0, 484, 1350, 2);
        // Lodret hvid linje.
        g.fillRect(627, 515, 2, 240);

        // Grid  
        //Lyst rektangel
        g.setColor(darkGray);
        g.drawRect(55, 65, 1252, 340);

        g.setColor(lightGray);
        int yo1 = 65;
        int yo2 = 75;
        int xos = 123 + 55;
        int xod = 123;

        //Korte mørke streger oppe.
        g.drawLine(xos + (0 * xod), yo1, xos + (0 * xod), yo2);
        g.drawLine(xos + (1 * xod), yo1, xos + (1 * xod), yo2);
        g.drawLine(xos + (2 * xod), yo1, xos + (2 * xod), yo2);
        g.drawLine(xos + (3 * xod), yo1, xos + (3 * xod), yo2);
        g.drawLine(xos + (4 * xod), yo1, xos + (4 * xod), yo2);
        g.drawLine(xos + (5 * xod), yo1, xos + (5 * xod), yo2);
        g.drawLine(xos + (6 * xod), yo1, xos + (6 * xod), yo2);
        g.drawLine(xos + (7 * xod), yo1, xos + (7 * xod), yo2);
        g.drawLine(xos + (8 * xod), yo1, xos + (8 * xod), yo2);

        int yn1 = 395;
        int yn2 = 405;

        //Korte mørke streger nede.
        g.drawLine(xos + (0 * xod), yn1, xos + (0 * xod), yn2);
        g.drawLine(xos + (1 * xod), yn1, xos + (1 * xod), yn2);
        g.drawLine(xos + (2 * xod), yn1, xos + (2 * xod), yn2);
        g.drawLine(xos + (3 * xod), yn1, xos + (3 * xod), yn2);
        g.drawLine(xos + (4 * xod), yn1, xos + (4 * xod), yn2);
        g.drawLine(xos + (5 * xod), yn1, xos + (5 * xod), yn2);
        g.drawLine(xos + (6 * xod), yn1, xos + (6 * xod), yn2);
        g.drawLine(xos + (7 * xod), yn1, xos + (7 * xod), yn2);
        g.drawLine(xos + (8 * xod), yn1, xos + (8 * xod), yn2);

        int xl1 = 55;
        int xl2 = 65;
        int xrs = 99;
        int xrd = 34;

        //Korte mørke streger venstre.
        g.drawLine(xl1, xrs + (0 * xrd), xl2, xrs + (0 * xrd));
        g.drawLine(xl1, xrs + (1 * xrd), xl2, xrs + (1 * xrd));
        g.drawLine(xl1, xrs + (2 * xrd), xl2, xrs + (2 * xrd));
        g.drawLine(xl1, xrs + (3 * xrd), xl2, xrs + (3 * xrd));
        g.drawLine(xl1, xrs + (4 * xrd), xl2, xrs + (4 * xrd));
        g.drawLine(xl1, xrs + (5 * xrd), xl2, xrs + (5 * xrd));
        g.drawLine(xl1, xrs + (6 * xrd), xl2, xrs + (6 * xrd));
        g.drawLine(xl1, xrs + (7 * xrd), xl2, xrs + (7 * xrd));
        g.drawLine(xl1, xrs + (8 * xrd), xl2, xrs + (8 * xrd));

        int xr1 = 1275;
        int xr2 = 1307;

        //Korte mørke streger højre.
        g.drawLine(xr1, xrs + (0 * xrd), xr2, xrs + (0 * xrd));
        g.drawLine(xr1, xrs + (1 * xrd), xr2, xrs + (1 * xrd));
        g.drawLine(xr1, xrs + (2 * xrd), xr2, xrs + (2 * xrd));
        g.drawLine(xr1, xrs + (3 * xrd), xr2, xrs + (3 * xrd));
        g.drawLine(xr1, xrs + (4 * xrd), xr2, xrs + (4 * xrd));
        g.drawLine(xr1, xrs + (5 * xrd), xr2, xrs + (5 * xrd));
        g.drawLine(xr1, xrs + (6 * xrd), xr2, xrs + (6 * xrd));
        g.drawLine(xr1, xrs + (7 * xrd), xr2, xrs + (7 * xrd));
        g.drawLine(xr1, xrs + (8 * xrd), xr2, xrs + (8 * xrd));

        int xh1 = 66;
        int xh2 = 1296;

        g.setColor(darkGray);

        //Lange lyse horisontale streger
        g.drawLine(xh1, xrs + (0 * xrd), xh2, xrs + (0 * xrd));
        g.drawLine(xh1, xrs + (1 * xrd), xh2, xrs + (1 * xrd));
        g.drawLine(xh1, xrs + (2 * xrd), xh2, xrs + (2 * xrd));
        g.drawLine(xh1, xrs + (3 * xrd), xh2, xrs + (3 * xrd));
        g.drawLine(xh1, xrs + (4 * xrd), xh2, xrs + (4 * xrd));
        g.drawLine(xh1, xrs + (5 * xrd), xh2, xrs + (5 * xrd));
        g.drawLine(xh1, xrs + (6 * xrd), xh2, xrs + (6 * xrd));
        g.drawLine(xh1, xrs + (7 * xrd), xh2, xrs + (7 * xrd));
        g.drawLine(xh1, xrs + (8 * xrd), xh2, xrs + (8 * xrd));

        int xv1 = 75;
        int xv2 = 395;

        //Lange lyse vertikale streger
        g.drawLine(xos + (0 * xod), xv1, xos + (0 * xod), xv2);
        g.drawLine(xos + (1 * xod), xv1, xos + (1 * xod), xv2);
        g.drawLine(xos + (2 * xod), xv1, xos + (2 * xod), xv2);
        g.drawLine(xos + (3 * xod), xv1, xos + (3 * xod), xv2);
        g.drawLine(xos + (4 * xod), xv1, xos + (4 * xod), xv2);
        g.drawLine(xos + (5 * xod), xv1, xos + (5 * xod), xv2);
        g.drawLine(xos + (6 * xod), xv1, xos + (6 * xod), xv2);
        g.drawLine(xos + (7 * xod), xv1, xos + (7 * xod), xv2);
        g.drawLine(xos + (8 * xod), xv1, xos + (8 * xod), xv2);
        
        
        //int y
        //x-axis value
        g.setColor(white);
        g.drawString("05,00", (0*xos)+(3*14-5), 425);
        g.drawString("04,50", (1*xos)-(1*14), 425);
        g.drawString("04,00", (2*xos)-(5*14), 425);
        g.drawString("03,50", (3*xos)-(9*14), 425);
        g.drawString("03,00", (4*xos)-(13*14), 425);
        g.drawString("02,50", (5*xos)-(17*14), 425);
        g.drawString("02,00", (6*xos)-(21*14-3), 425);
        g.drawString("01,50", (7*xos)-(26*14-20), 425);
        g.drawString("01,00", (8*xos)-(27*14+20), 425);
        g.drawString("00,50", (9*xos)-(31*14+20), 425);
        g.drawString("00,00", (10*xos)-(35*14), 425);
        
        g.drawString("(Tid siden måling i sekunder)", (5*xos)-(17*18-5), 455);
    }

}
