/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class RegistrationPanel extends javax.swing.JPanel {

    public BufferedImage i;
    public static int x;
    public static int y;
    
    public static File f;

    public RegistrationPanel() {
        initComponents();
        System.out.println("size"+ imagePanel.getHeight()+" "+imagePanel.getWidth());
        imagePanel.setSize(new Dimension(20,20));
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
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 200, 200));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setForeground(new java.awt.Color(153, 0, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagePanel.setBackground(new java.awt.Color(200, 200, 200));
        imagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(125, 125, 125)));
        add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 400));

        jButton2.setBackground(new java.awt.Color(125, 125, 125));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Load Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 423, 120, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
               
             try
                {
                JFileChooser chooser = new JFileChooser("C:\\Users\\Charith\\Pictures");
                int returnVal = chooser.showOpenDialog(this);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    f = chooser.getSelectedFile();
                    i = ImageIO.read(f);
                    //getContentPane().removeAll();
                    imageSplitter(i, 4);
                }
                //revalidate();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void imageSplitter(BufferedImage inputImage, int rowsandcolumns) throws IOException {
                
            BufferedImage image =new BufferedImage(imagePanel.getWidth(),imagePanel.getHeight(), inputImage.getType());
            Graphics2D g2d = image.createGraphics();
            g2d.drawImage(inputImage, 0, 0,imagePanel.getWidth(),imagePanel.getHeight(),null);
            //getContentPane().setLayout(new GridLayout(rowsandcolumns, rowsandcolumns));
            g2d.dispose();
            // reads in file as an image
            
            int rows = rowsandcolumns; // You should decide the values for rows and cols variables
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
//             For Loop that writes the each of the 4 new images from the array.
//            for (int i = 1; i < images.length + 1; i++) {
//                 ImageIO.write(images[i - 1], "jpg", new File("image" + i + ".jpg"));
//                 getContentPane().add(new JLabel(new ImageIcon(images[i - 1])));
//
//            }
        }
        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}