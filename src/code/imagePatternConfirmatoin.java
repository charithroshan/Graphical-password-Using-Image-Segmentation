/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class imagePatternConfirmatoin extends javax.swing.JFrame {
    
    public static String user_name = "null";
    public BufferedImage image;
    public int attempts = 3;
    
    private Connection con = null;
    private PreparedStatement statement = null;
    ResultSet rs = null;
    private List<Integer> pattern = new ArrayList<Integer>();
    private List<Integer> pattern_for_confirm = new ArrayList<Integer>();

    /**
     * Creates new form imagePatternConfirmatoin
     */
    public imagePatternConfirmatoin() throws IOException {
        initComponents();
        
        loadImage();
        getContentPane().remove(getContentPane);
        revalidate();
        try{
            imageSplitter(image, 4);
        }catch(Exception e){
            e.printStackTrace();
        }
        revalidate();
    }
    public imagePatternConfirmatoin(String name, List<Integer> pattern_to_confirm) throws IOException {
        initComponents();
        user_name = name;
        pattern_for_confirm = pattern_to_confirm;
        
        loadImage();
        getContentPane().remove(getContentPane);
        revalidate();
        try{
            imageSplitter(image, 4);
        }catch(Exception e){
            e.printStackTrace();
        }
        revalidate();
    }
    public imagePatternConfirmatoin(String name, List<Integer> pattern_to_confirm, int attempt) throws IOException {
        initComponents();
        user_name = name;
        attempts = attempt;
        pattern_for_confirm = pattern_to_confirm;
        
        loadImage();
        getContentPane().remove(getContentPane);
        revalidate();
        try{
            imageSplitter(image, 4);
        }catch(Exception e){
            e.printStackTrace();
        }
        revalidate();
    }
    
    private void loadImage(){
        try{
            image = ImageIO.read(new File("src\\Images\\" + user_name + ".jpg"));
            System.out.println(image.getClass().getSimpleName());
            imageSplitter(image, 4);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addPattern(){
        
        con = DBConnection.connectDB();
        try{
            statement = con.prepareStatement("insert into user (name, pattern, image) values(?, ?, ?)");
            statement.setString(1, user_name);
            statement.setString(2, pattern.toString());
            statement.setString(3, user_name + ".jpg");
            statement.execute(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void imageSplitter(BufferedImage inputImage, int rowsandcolumns) throws IOException {
            
        JPanel buf = new JPanel();
        buf.setName("imagePanel");
        buf.setSize(getContentPane.getWidth()+10,getContentPane.getHeight()+10);
        

        BufferedImage image =new BufferedImage(getContentPane.getWidth(),getContentPane.getHeight(), inputImage.getType());
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(inputImage, 0, 0,getContentPane.getWidth(),getContentPane.getHeight(),null);
        buf.setLayout(new GridLayout(rowsandcolumns, rowsandcolumns));
        g2d.dispose();
        // reads in file as an image

        int rows = rowsandcolumns; // You should decide the values for rows and cols// variables
        int columns = rowsandcolumns;
        int chunks = rows * columns;
        int chunkWidth = image.getWidth() / columns; // determines the chunk
                                                        // width and height
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        // initialize array to store 4 new images
        BufferedImage images[] = new BufferedImage[chunks];

        // For loop for rows
        for (int x = 0; x < rows; x++) {
            // For loop for columns
            for (int y = 0; y < columns; y++) {

                // Creates subimages of the main image and stores them in the
                // order of Quadrant II, III, I, IV
                images[count] = image.getSubimage((y * chunkWidth), (x * chunkHeight), chunkWidth, chunkHeight);
                count++;
            }
        }
        // For Loop that writes the each of the 4 new images from the array.
        for (int i = 1; i < images.length + 1; i++) {
            // ImageIO.write(images[i - 1], "jpg", new File("image" + i +
            // ".jpg"));
            JLabel imageLabel = new JLabel(new ImageIcon(images[i - 1]));
            imageLabel.setName(i + "");
            imageLabel.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Mouse clicked of clicks: " + imageLabel.getName().toString());
                    imageLabel.setEnabled(false);
                    imageLabel.removeMouseListener(this);
                    pattern.add(Integer.parseInt(imageLabel.getName()));
                    System.out.println(pattern);
                }
            });
            buf.add(imageLabel);

        }
//            JPanel button_panel = new JPanel();
//            button_panel.setName("imagePanel");
//            button_panel.setSize(50, 50);
//            
//            JButton accept_button = new JButton();
//            accept_button.setText("Accept");
//            accept_button.setName("accept_button");
//            accept_button.setSize(20, 20);
//            button_panel.add(accept_button);

        getContentPane().add(buf); 
//            getContentPane().add(button_panel);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        getContentPane = new javax.swing.JPanel();
        accept = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane.setBackground(new java.awt.Color(200, 200, 200));

        javax.swing.GroupLayout getContentPaneLayout = new javax.swing.GroupLayout(getContentPane);
        getContentPane.setLayout(getContentPaneLayout);
        getContentPaneLayout.setHorizontalGroup(
            getContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );
        getContentPaneLayout.setVerticalGroup(
            getContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        getContentPane().add(getContentPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 412, -1));

        accept.setBackground(new java.awt.Color(125, 125, 125));
        accept.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accept.setText("Confirm");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });
        getContentPane().add(accept, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 396, 129, 50));

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        if(pattern_for_confirm.size() > 3 && attempts > 1){
            try{
                if(pattern.equals(pattern_for_confirm)){
                    addPattern();
                    JOptionPane.showMessageDialog(null, "Registration Succesed", "Succesed" , JOptionPane.INFORMATION_MESSAGE);
                    LoginFrame login = new LoginFrame();
                    login.setVisible(true);
                    this.dispose();
                        
                }else{
                    attempts--;
                    String infoMessage = "Your pattern is wrong, only " + attempts + " left";
                    String titleBar = "Wrong Pattern";
                    JOptionPane.showMessageDialog(null, infoMessage, "Alert!  " + titleBar, JOptionPane.WARNING_MESSAGE);
                    
                    imagePatternConfirmatoin recalling = new imagePatternConfirmatoin(user_name, pattern_for_confirm, attempts);
                    recalling.setVisible(true);
                    this.dispose();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            String infoMessage = "You have no attempts left, Please retry entering new pattern";
            String titleBar = "Wrong Pattern";
            JOptionPane.showMessageDialog(null, infoMessage, "Alert!  " + titleBar, JOptionPane.WARNING_MESSAGE);
            Register register = new Register(user_name);
            register.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_acceptActionPerformed

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
            java.util.logging.Logger.getLogger(imagePatternConfirmatoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(imagePatternConfirmatoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(imagePatternConfirmatoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(imagePatternConfirmatoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new imagePatternConfirmatoin().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(imagePatternConfirmatoin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JPanel getContentPane;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
