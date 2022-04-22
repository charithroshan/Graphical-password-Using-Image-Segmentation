/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package code;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author user
 */
public class Menu extends javax.swing.JFrame {

     JMenuBar menuBar;
    ButtonGroup pictureGroup, problemsGroup;
    BufferedImage picture1img, picture2img, picture3img;
    JMenu choiceOfThreePictures, numberOfProblems;
    JRadioButtonMenuItem picture1, picture2, picture3, fourProblems, nineProblems, sixteenProblems;
    private String picture1Address = "20201126_232453.jpg";
    private String picture2Address = "20201126_232635.jpg";
    private String picture3Address = "PicsArt_12-04-11.16.31.jpg";
    KeyStroke picture1HotKey, picture2HotKey, picture3HotKey, fourProblemsHotKey, nineProblemsHotKey, sixteenProblemsHotKey;
    public Menu() {
        // Create the menu bar.
        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(50,50));
        setJMenuBar(menuBar);

        // Create Picture choices on Menu Bar and make Mnemonic 
        choiceOfThreePictures = new JMenu("Picture Choices");
        choiceOfThreePictures.setMnemonic(KeyEvent.VK_J);

        // Add Picture choices on Menu Bar
        menuBar.add(choiceOfThreePictures);

        // Create MenuItems onto Picture choices
        pictureGroup = new ButtonGroup();

        // Create button and accelerator for picture 1
        picture1 = new JRadioButtonMenuItem("Picture 1");
        picture1HotKey = KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK);
        picture1.setAccelerator(picture1HotKey);

        // Create button and accelerator for picture 2
        picture2 = new JRadioButtonMenuItem("Picture 2");
        picture2HotKey = KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_DOWN_MASK);
        picture2.setAccelerator(picture2HotKey);

        // Create button and accelerator for picture 3
        picture3 = new JRadioButtonMenuItem("Picture 3");
        picture3HotKey = KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.CTRL_DOWN_MASK);
        picture3.setAccelerator(picture3HotKey);

        // Add Picture Choices to Picutre choices menu
        choiceOfThreePictures.add(picture1);
        pictureGroup.add(picture1);
        choiceOfThreePictures.add(picture2);
        pictureGroup.add(picture2);
        choiceOfThreePictures.add(picture3);
        pictureGroup.add(picture3);

        // Create Number Of Problems on Menu Bar and make Mnemonic
        numberOfProblems = new JMenu("Number Of Problems");
        numberOfProblems.setMnemonic(KeyEvent.VK_T);

        // Add Number Of problems on Menu Bar
        menuBar.add(numberOfProblems);

        // Create Menu Items onto Number Of problems
        problemsGroup = new ButtonGroup();

        // Create button and accelerator for fourProblems 
        fourProblems = new JRadioButtonMenuItem("4");
        fourProblemsHotKey = KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.CTRL_DOWN_MASK);
        fourProblems.setAccelerator(fourProblemsHotKey);

        // Create button and accelertor for nineProblems
        nineProblems = new JRadioButtonMenuItem("9");
        nineProblemsHotKey = KeyStroke.getKeyStroke(KeyEvent.VK_F9, KeyEvent.CTRL_DOWN_MASK);
        nineProblems.setAccelerator(nineProblemsHotKey);

        // Create button and accelerator for sixteenProblems
        sixteenProblems = new JRadioButtonMenuItem("16");
        sixteenProblemsHotKey = KeyStroke.getKeyStroke(KeyEvent.VK_F12, KeyEvent.CTRL_DOWN_MASK);
        sixteenProblems.setAccelerator(sixteenProblemsHotKey);

        // Add Number Of problems onto menu
        numberOfProblems.add(fourProblems);
        problemsGroup.add(fourProblems);
        numberOfProblems.add(nineProblems);
        problemsGroup.add(nineProblems);
        numberOfProblems.add(sixteenProblems);
        problemsGroup.add(sixteenProblems);

        // Start creating ActionListeners for pictures
        picture1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Working");
                try {
                    picture1img = ImageIO.read(new File(picture1Address));
                    getContentPane().removeAll();
                    getContentPane().add(new JLabel(new ImageIcon(picture1img)));
                    revalidate();
                } catch (IOException e) {
                    System.out.println("Couldn't find image.");
                }
            }
        });
        picture2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Working");
                try {
                    picture2img = ImageIO.read(new File(picture2Address));
                    getContentPane().removeAll();
                    getContentPane().add(new JLabel(new ImageIcon(picture2img)));
                    revalidate();
                } catch (IOException e) {
                    System.out.println("Couldn't find image.");
                }
            }
        });
        picture3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Working");
                try {
                    picture3img = ImageIO.read(new File(picture3Address));
                    getContentPane().removeAll();
                    getContentPane().add(new JLabel(new ImageIcon(picture3img)));
                    revalidate();

                } catch (IOException e) {
                    System.out.println("Couldn't find image.");
                }
            }
        });
        // Create Action Listeners for problems
        fourProblems.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if (picture1.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture1Address, 2);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } else if (picture2.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture2Address, 2);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } else if (picture3.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture3Address, 2);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        nineProblems.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if (picture1.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture1Address, 3);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } else if (picture2.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture2Address, 3);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } else if (picture3.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture3Address, 3);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        sixteenProblems.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if (picture1.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture1Address, 4);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } else if (picture2.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture2Address, 4);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } else if (picture3.isSelected()){
                    try {
                        getContentPane().removeAll();
                        imageSplitter(picture3Address, 4);
                        revalidate();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    // Image Splitter Method
        public void imageSplitter(String filename, int rowsandcolumns) throws IOException {
            getContentPane().setLayout(new GridLayout(rowsandcolumns, rowsandcolumns));
            // reads in file as an image
            BufferedImage image = ImageIO.read(new File(filename));
            int rows = rowsandcolumns; // You should decide the values for rows and cols
                            // variables
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
                    images[count] = image.getSubimage((x * chunkWidth), (y * chunkHeight), chunkWidth, chunkHeight);
                    count++;
                }
            }
            // For Loop that writes the each of the 4 new images from the array.
            for (int i = 1; i < images.length + 1; i++) {
                // ImageIO.write(images[i - 1], "jpg", new File("image" + i +
                // ".jpg"));
                getContentPane().add(new JLabel(new ImageIcon(images[i - 1])));

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Menu mb = new Menu();
        mb.setSize(900, 700);
        mb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mb.setVisible(true);
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
