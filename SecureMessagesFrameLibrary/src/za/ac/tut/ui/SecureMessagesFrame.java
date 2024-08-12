/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ui;



import za.ac.tut.message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SecureMessagesFrame extends JFrame {

    private JPanel p1;
    private JLabel tit;
    private JPanel p2;
    private JPanel p02;
    private JPanel p002;
    private JTextArea are1;
    private JScrollPane sc;
    private JTextArea are2;
    private JScrollPane sc1;
    private JMenuBar bar;
    private JMenu f;
    private JMenuItem open;
    private JMenuItem ency;
    private JMenuItem sav;
    private JMenuItem cle;
    private JMenuItem exi;
    private Message message;

    public SecureMessagesFrame() {
        this.setTitle("Secure Messages");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        Font fo = new Font("Calisto MT", 2, 21);

        bar = new JMenuBar();
        f = new JMenu("File");
        open = new JMenuItem("Open file...");
        open.addActionListener(new OpeAction());
        ency = new JMenuItem("Encrypt Message...");
        ency.addActionListener(new EncryptAction());
        sav = new JMenuItem("Save Encrypted message...");
        sav.addActionListener(new SaveAction());
        cle = new JMenuItem("Clear");
        cle.addActionListener(new ClearAction());
        exi = new JMenuItem("Exit");
        exi.addActionListener(new ExitAction());
        f.add(open);
        f.add(ency);
        f.add(sav);
        f.add(cle);
        f.add(exi);
        bar.add(f);
        this.setJMenuBar(bar);

        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tit = new JLabel("Message Encryptor");
        tit.setFont(fo);
        tit.setForeground(Color.BLUE);
        p1.add(tit);

        p2 = new JPanel(new GridLayout(1, 2));
        p02 = new JPanel();
        p02.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Plain Message"));
        are1 = new JTextArea(23, 30);
        sc = new JScrollPane(are1);
        sc.setPreferredSize(are1.getPreferredSize());
        p02.add(sc);

        p002 = new JPanel();
        p002.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Encrypted Message"));
        are2 = new JTextArea(23, 30);
        are2.setEditable(false);
        sc1 = new JScrollPane(are2);
        sc1.setPreferredSize(are2.getPreferredSize());
        p002.add(sc1);

        p2.add(p02);
        p2.add(p002);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.setVisible(true);

        message = new Message("");
    }

    private class EncryptAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String plainText = are1.getText();
            message.setPlainMessage(plainText);
            are2.setText(message.getEncryptedMessage());
        }
    }

    private class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc;
            File file;
            BufferedWriter bw;
            String line;
            
            fc = new JFileChooser();
            int val = fc.showSaveDialog(SecureMessagesFrame.this);
            if(val == JFileChooser.APPROVE_OPTION){
                try {
                    file= fc.getSelectedFile();
                    bw = new BufferedWriter(new FileWriter(file,true));
                    line= are2.getText();
                    bw.newLine();
                    bw.write(line);
                    bw.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
                }catch(IOException exx){
                    JOptionPane.showMessageDialog(getRootPane(), exx.getMessage());
                }
            }
        }
    }

    private class ClearAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            message.clearMessages();
            are1.setText("");
            are2.setText("");
        }
    }

    private class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class OpeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            int show = chooser.showOpenDialog(SecureMessagesFrame.this);
            if (show == JFileChooser.APPROVE_OPTION) {
                File select = chooser.getSelectedFile();
                try (FileInputStream fis = new FileInputStream(select)) {
                    byte[] data = new byte[(int) select.length()];
                    fis.read(data);
                    String plainText = new String(data, "UTF-8");
                    are1.setText(plainText);
                    message.setPlainMessage(plainText);
                } catch (IOException exx) {
                    JOptionPane.showConfirmDialog(getRootPane(), exx.getMessage());
                }
            }
        }
    }

   
}

