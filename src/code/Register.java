/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import jdk.nashorn.internal.ir.LexicalContextNode;

/**
 *
 * @author user
 */
public class Register extends javax.swing.JFrame {
    
    public BufferedImage image;
    public static int x;
    public static int y;
    public static String user_name = null;
    
    public static File f;
    
    private Connection con = null;
    private PreparedStatement statement = null;

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        jButton2.setVisible(false);
    }
    public Register(String name) {
        initComponents();
        jButton2.setVisible(false);
        user_name = name;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 200, 200));

        imagePanel.setBackground(new java.awt.Color(200, 200, 200));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(125, 125, 125));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Load Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(125, 125, 125));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Accept");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
            {
                JFileChooser chooser = new JFileChooser("C:\\Users\\Charith\\Pictures");
                chooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter jpeg = new FileNameExtensionFilter("Image JPEG", "jpeg");
                FileNameExtensionFilter jpg = new FileNameExtensionFilter("Image JPG", "jpg");
                FileNameExtensionFilter png = new FileNameExtensionFilter("Image PNG", "png");
                chooser.addChoosableFileFilter(jpg);
                chooser.addChoosableFileFilter(png);
                chooser.addChoosableFileFilter(jpeg);
                int returnVal = chooser.showOpenDialog(this);
                
                jButton1.setVisible(false);
                getContentPane().remove(jButton1);
                getContentPane().remove(imagePanel);
                revalidate();
                    
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    f = chooser.getSelectedFile();
                    image = ImageIO.read(f);
                    System.out.println(image.getClass().getSimpleName());
                    imageSplitter(image, 4);
                }
                revalidate();
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(pattern.size() > 3){
            try{
                ImageIO.write(image, "jpg", new File("src\\Images\\" + user_name + ".jpg"));
                JOptionPane.showMessageDialog(null, "Ok", "Alert!  " , JOptionPane.WARNING_MESSAGE);
                imagePatternConfirmatoin imagepattern = new imagePatternConfirmatoin(user_name, pattern);
                imagepattern.setVisible(true);
                this.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            String infoMessage = "Please select at least 4 picture chunks";
            String titleBar = "Select Pattern";
            JOptionPane.showMessageDialog(null, infoMessage, "Alert!  " + titleBar, JOptionPane.WARNING_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
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
        JPanel  buf = new JPanel();    
        buf.setName("imagePanel");
        buf.setSize(imagePanel.getWidth()+10,imagePanel.getHeight()+10);
        

        BufferedImage image =new BufferedImage(imagePanel.getWidth(),imagePanel.getHeight(), inputImage.getType());
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(inputImage, 0, 0,imagePanel.getWidth(),imagePanel.getHeight(),null);
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

        jButton2.setVisible(true);

        getContentPane().add(buf); 
//            getContentPane().add(button_panel);
            
    }
    
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
    private List<Integer> pattern = new ArrayList<Integer>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
