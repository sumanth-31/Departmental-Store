import java.lang.StringBuilder;
import java.lang.Object;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Monicas extends JFrame implements ActionListener {
    JButton add, modify, display, del, Bill, billproduct;
    JTextField username, pname, pprice, pquan, ppno, newu, givenam, retam, billtotal, total;
    JPasswordField password, newp;
    JButton login, addit, back, delit, modit, displayit, passb, adminid, showall, billing;
    JPanel passp, check, item, menu, billpanel, panel1, last, finalbill;
    JLabel user, pass, itemn, itemp, itemq, itemno, newpass, newuser, retaml, givenaml;
    product pr;
    int count = 3;
    float billsum = 0;
    DefaultTableModel billtable;
    JTable billtab;
    JScrollPane pane;
    String str;

    Monicas() {
        setBackground(Color.BLACK);
        pr = new product();

        // Admin login page
        username = new JTextField();
        adminid = new JButton("Change Admin ID");
        newuser = new JLabel("New Username");
        newu = new JTextField();
        newp = new JPasswordField();
        newpass = new JLabel("New Password!");
        user = new JLabel("Admin Username");
        pass = new JLabel("Admin Password");
        password = new JPasswordField();
        passb = new JButton("Create Admin ID");
        passp = new JPanel();
        login = new JButton("Login");
        login.addActionListener(this);
        last = new JPanel();
        check = new JPanel();
        check.setLayout(new GridLayout(5, 1));
        check.add(user);
        check.add(username);
        check.add(pass);
        check.add(password);
        check.add(login);
        adminid.addActionListener(this);
        adminid.setBackground(Color.BLACK);
        adminid.setForeground(Color.WHITE);

        add(last);

        // UI
        user.setForeground(Color.WHITE);
        user.setBackground(Color.BLACK);
        pass.setForeground(Color.WHITE);
        pass.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        Font font = new Font("courier", Font.PLAIN, 24);
        adminid.setFont(font);
        user.setFont(font);
        pass.setFont(font);
        login.setFont(font);
        last.setBackground(Color.BLACK);
        username.setFont(font);
        password.setFont(font);

        // showall
        showall = new JButton("Display all items");

        // second page
        add = new JButton("Add Product");
        modify = new JButton("Modify Product details");
        del = new JButton("Delete Product");
        display = new JButton("Display Product");
        add.addActionListener(this);
        del.addActionListener(this);
        display.addActionListener(this);
        billing = new JButton("Billing");
        modify.addActionListener(this);
        menu = new JPanel();
        menu.setLayout(new GridLayout(7, 1));
        menu.add(add);
        menu.add(modify);
        menu.add(del);
        menu.add(display);
        menu.add(showall);
        menu.add(billing);
        menu.add(adminid);
        back = new JButton("Back");
        back.addActionListener(this);
        // UI
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        modify.setForeground(Color.WHITE);
        modify.setBackground(Color.BLACK);
        del.setForeground(Color.WHITE);
        del.setBackground(Color.BLACK);
        menu.setForeground(Color.WHITE);
        menu.setBackground(Color.BLACK);
        menu.add(adminid);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBackground(Color.BLACK);
        add.setFont(font);
        modify.setFont(font);
        del.setFont(font);
        display.setFont(font);

        // add/delete item
        item = new JPanel();
        itemn = new JLabel("Product Name");
        itemp = new JLabel("Product Price");
        itemq = new JLabel("Product Quantity");
        itemno = new JLabel("Product number");
        pname = new JTextField();
        pprice = new JTextField();
        pquan = new JTextField();
        ppno = new JTextField();
        item.setLayout(new GridLayout(5, 2));
        item.add(itemn);
        item.add(pname);
        item.add(itemp);
        item.add(pprice);
        item.add(itemq);
        item.add(pquan);
        item.add(itemno);
        item.add(ppno);
        item.add(back);
        displayit = new JButton("Display product");
        displayit.addActionListener(this);
        addit = new JButton("add product");
        addit.addActionListener(this);
        delit = new JButton("delete product");
        delit.addActionListener(this);
        modit = new JButton("modify product");
        modit.addActionListener(this);
        // UI
        itemn.setForeground(Color.WHITE);
        itemn.setBackground(Color.BLACK);
        itemno.setForeground(Color.WHITE);
        itemno.setBackground(Color.BLACK);
        itemp.setForeground(Color.WHITE);
        itemp.setBackground(Color.BLACK);
        itemq.setForeground(Color.WHITE);
        itemq.setBackground(Color.BLACK);
        item.setForeground(Color.WHITE);
        item.setBackground(Color.BLACK);
        displayit.setForeground(Color.WHITE);
        displayit.setBackground(Color.BLACK);
        addit.setForeground(Color.WHITE);
        addit.setBackground(Color.BLACK);
        delit.setForeground(Color.WHITE);
        delit.setBackground(Color.BLACK);
        modit.setForeground(Color.WHITE);
        modit.setBackground(Color.BLACK);
        itemn.setFont(font);
        itemp.setFont(font);
        itemq.setFont(font);
        itemno.setFont(font);
        displayit.setFont(font);
        delit.setFont(font);
        modit.setFont(font);
        pprice.setFont(font);
        pname.setFont(font);
        ppno.setFont(font);
        pquan.setFont(font);

        // Panel1
        panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.setForeground(Color.WHITE);
        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(itemn);
        panel1.add(pname);
        panel1.add(back);

        // new password ui
        passp.setLayout(new GridLayout(6, 1));
        passp.setForeground(Color.WHITE);
        passp.setBackground(Color.BLACK);
        passb.addActionListener(this);
        newu.setFont(font);
        newp.setFont(font);
        newuser.setFont(font);
        newpass.setFont(font);
        passb.setFont(font);
        newuser.setForeground(Color.WHITE);
        newuser.setBackground(Color.BLACK);
        newpass.setForeground(Color.WHITE);
        newpass.setBackground(Color.BLACK);
        passb.setForeground(Color.WHITE);
        passb.setBackground(Color.BLACK);
        passp.add(newuser);
        passp.add(newu);
        passp.add(newpass);
        passp.add(newp);
        File fl = new File("D:/shoplogin.dat");
        if (fl.exists())
            passb.setText("Change Admin ID");
        passp.add(passb);
        last.add(passp);

        // showall

        showall.setForeground(Color.WHITE);
        showall.setBackground(Color.BLACK);
        showall.setFont(font);
        showall.addActionListener(this);

        // Billpanel
        billing.addActionListener(this);
        billpanel = new JPanel();
        finalbill = new JPanel();
        finalbill.setLayout(new GridLayout(3, 2));
        billpanel.setLayout(new GridLayout(5, 2));
        billtable = new DefaultTableModel();
        billtab = new JTable(billtable);
        billproduct = new JButton("Add Product");
        billproduct.addActionListener(this);
        Bill = new JButton("Bill");
        Bill.addActionListener(this);
        givenam = new JTextField();
        retam = new JTextField();
        billtotal = new JTextField();
        total = new JTextField();
        retaml = new JLabel("Return Amount:");
        givenaml = new JLabel("Given Amount:");
        total.setFont(font);
        billing.setFont(font);
        Bill.setFont(font);
        billproduct.setFont(font);
        givenam.setFont(font);
        retam.setFont(font);
        retaml.setBackground(Color.BLACK);
        retaml.setForeground(Color.WHITE);
        retaml.setFont(font);
        givenaml.setBackground(Color.BLACK);
        givenaml.setForeground(Color.WHITE);
        givenaml.setFont(font);
        billpanel.setBackground(Color.BLACK);
        billpanel.setForeground(Color.WHITE);
        Bill.setBackground(Color.BLACK);
        Bill.setForeground(Color.WHITE);
        billproduct.setBackground(Color.BLACK);
        billproduct.setForeground(Color.WHITE);
        billtotal.setBackground(Color.BLACK);
        billtotal.setForeground(Color.WHITE);
        billing.setBackground(Color.BLACK);
        billing.setForeground(Color.WHITE);
        finalbill.setBackground(Color.BLACK);
        finalbill.setForeground(Color.WHITE);
        pane = new JScrollPane(billtab);

        last.setLayout(new GridLayout(2, 1));

        admin();
    }

    void admin() {
        File fl = new File("D:/shoplogin.dat");
        File file = new File("D:/shopstock.dat");
        if (fl.exists()) {
            last.removeAll();
            last.add(check);
            revalidate();
            repaint();

        }

        else {
            if (file.exists()) {
                file.delete();
            }
            last.removeAll();
            last.add(passp);
            JOptionPane.showMessageDialog(this, "CREATE AN ADMIN ID TO ACCESS THE DATA", "",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void passcheck() {
        String u = username.getText();
        StringBuilder us = new StringBuilder();
        char charpass[] = password.getPassword();
        String p = new String(charpass);
        String u1, p1;
        u1 = new String();
        p1 = new String();
        StringBuilder pa = new StringBuilder();
        LoginData ld;
        File fl = new File("D:/shoplogin.dat");
        try (FileInputStream fin = new FileInputStream(fl); ObjectInputStream oin = new ObjectInputStream(fin);) {
            ld = (LoginData) oin.readObject();
            us = ld.uname;
            pa = ld.pass;
            us = decrypt(us, 6);
            pa = decrypt(pa, 6);
            u1 = us.toString();
            p1 = pa.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "AN ERROR OCCURED!", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        if ((u.equals(u1)) && (p.equals(p1))) {
            showmenu();
        } else {

            count--;
            JOptionPane.showMessageDialog(this, count + " trials left ", "Wrong Credentials!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getSource() == adminid) {
                last.removeAll();
                passp.add(back);
                last.add(passp);
                revalidate();
                repaint();
            }

            if (e.getSource() == showall) {
                enableit();
                all();

            }

            if (e.getSource() == passb) {
                StringBuilder u, p;
                char charp[] = newp.getPassword();
                String strp = new String(charp);
                LoginData ld = new LoginData();
                File fl = new File("D:/shoplogin.dat");
                try (FileOutputStream fout = new FileOutputStream(fl);
                        ObjectOutputStream oout = new ObjectOutputStream(fout);) {
                    if (((u = new StringBuilder(newu.getText())).equals(""))
                            || ((p = new StringBuilder(strp)).equals("")))
                        JOptionPane.showMessageDialog(this, "ENTER VALID CREDENTIALS!", "WARNING!",
                                JOptionPane.WARNING_MESSAGE);
                    else {
                        u = encrypt(u, 6);
                        p = encrypt(p, 6);
                        ld.pass = p;
                        ld.uname = u;
                        oout.writeObject(ld);

                        JOptionPane.showMessageDialog(this, "DONE!", "STATUS", JOptionPane.INFORMATION_MESSAGE);
                        last.removeAll();
                        last.add(check);
                        revalidate();
                        repaint();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "AN ERROR OCCURED!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }

            if (e.getSource() == login) {
                passcheck();

                if (count == 0) {
                    login.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Too Many Failed Attempts!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            String n;
            float p;
            int q, no;
            if (e.getSource() == add) {
                enableit();
                last.removeAll();
                itemset();
                last.add(item);
                last.add(addit);
                last.revalidate();
                last.repaint();

            }
            if (e.getSource() == addit) {
                enableit();
                n = pname.getText();
                p = Float.parseFloat(pprice.getText());
                q = Integer.parseInt(pquan.getText());
                no = Integer.parseInt(ppno.getText());
                addp(n, p, q, no);
                clear();
            }
            if (e.getSource() == del) {
                disableit();
                last.removeAll();
                panel1set();
                last.add(panel1);
                last.add(delit);
                last.revalidate();
                last.repaint();

            }
            if (e.getSource() == delit) {
                n = pname.getText();
                delp(n);
                revalidate();
                repaint();
            }
            if (e.getSource() == modify) {
                enableit();
                last.removeAll();
                itemset();
                item.remove(ppno);
                item.remove(itemno);
                last.add(item);
                last.add(modit);
                last.revalidate();
                last.repaint();

            }
            if (e.getSource() == modit) {
                enableit();
                n = pname.getText();
                p = Float.parseFloat(pprice.getText());
                q = Integer.parseInt(pquan.getText());
                modp(n, p, q);
                clear();
            }
            if (e.getSource() == display) {
                disableit();
                last.removeAll();
                panel1set();
                last.add(panel1);
                last.add(displayit);
                last.revalidate();
                last.repaint();

            }
            if (e.getSource() == displayit) {
                n = pname.getText();
                displayp(n);
                last.removeAll();
                itemset();
                last.add(item);
                last.add(displayit);
                revalidate();
                repaint();
            }
            if (e.getSource() == back) {
                enableit();
                showmenu();
                clear();
            }

            if (e.getSource() == billing) {
                enableit();
                billsum = 0;
                billset();
                billtable.setRowCount(0);
                billtable.setColumnCount(0);
                givenam.setText("");
                total.setText("Total = " + String.valueOf(billsum));
                last.removeAll();
                Font font = new Font("courier", Font.PLAIN, 24);
                billtab.setSize(new Dimension(500, 500));
                billtab.setFont(font);
                billtable.addColumn("NAME");
                billtable.addColumn("QUANTITY");
                billtable.addColumn("PRICE PER 1");
                billtable.addColumn("TOTAL");
                billtab.setRowHeight(30);
                last.add(pane);
                total.setEditable(false);
                billpanel.add(back);
                last.add(billpanel);
                last.revalidate();
                last.repaint();
                clear();

            }

            if (e.getSource() == billproduct) {
                if (Integer.parseInt(pquan.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Quantity can't be negative!", "WARNING!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                enableit();
                float itemsum = 0;
                n = pname.getText();
                q = Integer.parseInt(pquan.getText());
                if (itemcheck(n, -1)) {

                    if (q > pr.quan) {
                        if (pr.quan == 0)
                            JOptionPane.showMessageDialog(this, "Product is out of stock!", "STOCK-WARNING!",
                                    JOptionPane.WARNING_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(this, "Limited stock available!", "STOCK-WARNING",
                                    JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    itemsum += (q * pr.price);
                    billsum += itemsum;
                    billtable(pr.name, q, pr.price, itemsum);
                    total.setText("Total = " + String.valueOf(billsum));
                    last.revalidate();
                    last.repaint();
                    modp(pr.name, pr.price, (pr.quan - q));
                } else {
                    JOptionPane.showMessageDialog(this, "PRODUCT NOT FOUND!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                }
                clear();

            }
            if (e.getSource() == Bill) {
                enableit();
                float givenamount, returnamount;
                givenamount = Float.parseFloat(givenam.getText());
                givenam.setEditable(false);
                retam.setEditable(false);
                retam.setText(String.valueOf(givenamount - billsum));
                last.remove(billpanel);
                finalbill.add(back);
                last.add(finalbill);
                givenam.setEditable(true);
                last.revalidate();
                last.repaint();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ENTER VALID DETAILS!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void addp(String name, float price, int amount, int number) {
        File fl = new File("D:/shopstock.dat");
        product p = new product();
        if (price < 0 || amount < 0 || number < 0) {
            JOptionPane.showMessageDialog(this, "ANY OF THE ABOVE ATTRIBUTES CAN'T BE NEGATIVE", "WARNNING!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (itemcheck(name, number)) {
            JOptionPane.showMessageDialog(this, "A PRODUCT WITH SIMILAR NAME OR NUMBER EXISTS", "WARNING!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        p.name = name;
        p.pno = number;
        p.quan = amount;
        p.price = price;

        ArrayList<product> list = new ArrayList<product>();
        if (fl.exists()) {
            try (FileInputStream fin = new FileInputStream(fl); ObjectInputStream oin = new ObjectInputStream(fin);) {
                list = (ArrayList<product>) oin.readObject();
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }

        }

        list.add(p);
        try (FileOutputStream fout = new FileOutputStream(fl);
                ObjectOutputStream oout = new ObjectOutputStream(fout);) {
            oout.writeObject(list);

        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
        clear();
        JOptionPane.showMessageDialog(this, "DONE!", "STATUS", JOptionPane.INFORMATION_MESSAGE);
        showmenu();

    }

    public void delp(String name) {

        File fl = new File("D:/shopstock.dat");
        ArrayList<product> al = new ArrayList();

        ArrayList<product> al1 = new ArrayList();
        if (!(itemcheck(name, -1))) {
            JOptionPane.showMessageDialog(this, "PRODUCT NOT FOUND!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (fl.exists()) {
            try (FileInputStream fin = new FileInputStream(fl); ObjectInputStream oin = new ObjectInputStream(fin);) {
                al = (ArrayList<product>) oin.readObject();
                for (product p : al) {
                    if (!(p.name.equals(name)))
                        al1.add(p);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "AN ERROR OCCURED!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            try (FileOutputStream fout = new FileOutputStream(fl);
                    ObjectOutputStream oout = new ObjectOutputStream(fout);) {
                oout.writeObject(al1);
            } catch (Exception ex1) {
                JOptionPane.showMessageDialog(this, "AN ERROR OCCURED!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "DONE!", "STATUS", JOptionPane.INFORMATION_MESSAGE);

        } else
            JOptionPane.showMessageDialog(this, "SHOP IS OUT OF STOCK.NO PRODUCTS TO DELETE!", "ERROR",
                    JOptionPane.ERROR_MESSAGE);

    }

    public void modp(String name, float price, int amount) {
        String s;
        int number;
        File fl = new File("D:/shopstock.dat");
        if (price < 0 || amount < 0) {
            JOptionPane.showMessageDialog(this, "ANY OF THE ABOVE ATTRIBUTES CAN'T BE NEGATIVE", "WARNNING!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!(fl.exists())) {
            JOptionPane.showMessageDialog(this, "SHOP IS OUT OF STOCK.NO PRODUCTS TO MODIFY!", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!(itemcheck(name, -1))) {
            JOptionPane.showMessageDialog(this, "PRODUCT NOT FOUND!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (amount <= 10) {
            if (amount == 0)
                JOptionPane.showMessageDialog(this, "Product is now out of stock!", "STOCK-WARNING!",
                        JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(this, "Product running out of stock,only few left!", "STOCK-WARNING!",
                    JOptionPane.WARNING_MESSAGE);
        }
        number = Integer.parseInt(ppno.getText());
        product p = new product();
        p.price = price;
        p.name = name;
        p.pno = number;
        p.quan = amount;
        ArrayList<product> al = new ArrayList();
        ArrayList<product> al1 = new ArrayList();
        try (FileInputStream fin = new FileInputStream(fl); ObjectInputStream oin = new ObjectInputStream(fin);) {
            al = (ArrayList<product>) oin.readObject();
            for (product p1 : al) {
                if (!(p1.name.equals(name)))
                    al1.add(p1);
            }
            al1.add(p);
            JOptionPane.showMessageDialog(this, "DONE!", "STATUS", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (FileOutputStream fout = new FileOutputStream(fl);
                ObjectOutputStream oout = new ObjectOutputStream(fout);) {
            oout.writeObject(al1);
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }

    public void displayp(String name) {
        int c = 0;
        clear();
        String s;
        if (itemcheck(name, -1))
            c++;
        if (c == 0)
            JOptionPane.showMessageDialog(this, "PRODUCT NOT FOUND!", "ERROR", JOptionPane.ERROR_MESSAGE);

    }

    public void all() {
        DefaultTableModel table = new DefaultTableModel();
        JTable tab = new JTable(table);
        Font font = new Font("courier", Font.PLAIN, 24);
        tab.setSize(new Dimension(500, 500));
        tab.setFont(font);
        table.addColumn("NAME");
        table.addColumn("PRICE");
        table.addColumn("QUANTITY");
        table.addColumn("NUMBER");
        ArrayList<product> al = new ArrayList();
        String s1[] = new String[4];
        File fl = new File("D:/shopstock.dat");
        if (fl.exists()) {
            try (FileInputStream fin = new FileInputStream(fl); ObjectInputStream oin = new ObjectInputStream(fin);) {
                al = (ArrayList<product>) oin.readObject();
                for (product p : al) {
                    s1[0] = p.name;
                    s1[1] = String.valueOf(p.price);
                    s1[2] = String.valueOf(p.quan);
                    s1[3] = String.valueOf(p.pno);
                    table.addRow(s1);

                }
                tab.setRowHeight(30);
                JScrollPane js = new JScrollPane(tab);
                last.removeAll();
                last.add(js);
                last.add(back);
                revalidate();
                repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERROR OCCURED!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else
            JOptionPane.showMessageDialog(this, "SHOP IS OUT OF STOCK.NO PRODUCTS TO SHOW!", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void billtable(String name, int quan, float price, float total) {
        String s1[] = new String[4];
        s1[0] = name;
        s1[1] = String.valueOf(quan);
        s1[2] = String.valueOf(price);
        s1[3] = String.valueOf(total);
        billtable.addRow(s1);

    }

    public void clear() {
        pprice.setText("");
        pquan.setText("");
        pname.setText("");
        ppno.setText("");
    }

    public void showmenu() {
        last.removeAll();
        last.add(menu);
        last.revalidate();
        last.repaint();
    }

    public boolean itemcheck(String name, int number) {
        File fl = new File("D:/shopstock.dat");
        ArrayList<product> al;
        if (fl.exists()) {

            try (

                    FileInputStream fin = new FileInputStream(fl);
                    ObjectInputStream oin = new ObjectInputStream(fin);) {
                al = (ArrayList<product>) oin.readObject();
                for (product p1 : al) {

                    if (p1.pno == number || p1.name.equals(name)) {
                        pr = p1;
                        pname.setText(p1.name);
                        ppno.setText(String.valueOf(p1.pno));
                        pprice.setText(String.valueOf(p1.price));
                        pquan.setText(String.valueOf(p1.quan));
                        return true;
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
        return false;

    }

    public void itemset() {
        item.add(itemn);
        item.add(pname);
        item.add(itemp);
        item.add(pprice);
        item.add(itemq);
        item.add(pquan);
        item.add(itemno);
        item.add(ppno);
        item.add(back);
    }

    public void panel1set() {
        panel1.add(itemn);
        panel1.add(pname);
        panel1.add(back);
    }

    public void disableit() {
        pquan.setEditable(false);
        pprice.setEditable(false);
        ppno.setEditable(false);

    }

    public void enableit() {
        pquan.setEditable(true);
        pprice.setEditable(true);
        ppno.setEditable(true);

    }

    StringBuilder encrypt(StringBuilder input, int n) {
        StringBuilder output = new StringBuilder(input.toString());
        int i = 0, len = 0, j;
        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 97 && input.charAt(i) <= 122) {
                if ((input.charAt(i) + n) > 122) {
                    j = 122 - input.charAt(i);
                    output.setCharAt(i, (char) (96 + n - j - 32));
                } else
                    output.setCharAt(i, (char) (input.charAt(i) + n - 32));
            } else if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
                if ((input.charAt(i) + n) > 90) {
                    j = 90 - input.charAt(i);
                    output.setCharAt(i, (char) (64 + n - j + 32));
                } else
                    output.setCharAt(i, (char) (input.charAt(i) + n + 32));
            } else if (input.charAt(i) >= 48 && input.charAt(i) <= 57)
                output.setCharAt(i, input.charAt(i));
        }
        return output;

    }

    StringBuilder decrypt(StringBuilder input, int n) {
        StringBuilder output = new StringBuilder(input.toString());
        int i = 0, j, len = 0;

        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 97 && input.charAt(i) <= 122) {
                if (input.charAt(i) - n < 97) {
                    j = n - (input.charAt(i) - 96);
                    output.setCharAt(i, (char) (90 - j));
                } else
                    output.setCharAt(i, (char) (input.charAt(i) - n - 32));
            } else if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
                if (input.charAt(i) - n < 65) {
                    j = n - (input.charAt(i) - 64);
                    output.setCharAt(i, (char) (122 - j));
                } else
                    output.setCharAt(i, (char) (input.charAt(i) - n + 32));

            } else
                output.setCharAt(i, input.charAt(i));
        }
        return output;
    }

    public void billset() {
        billpanel.removeAll();
        finalbill.add(givenaml);
        finalbill.add(givenam);
        finalbill.add(retaml);
        finalbill.add(retam);
        finalbill.add(back);
        billpanel.add(itemn);
        billpanel.add(pname);
        billpanel.add(itemq);
        billpanel.add(pquan);
        billpanel.add(billproduct);
        billpanel.add(total);
        billpanel.add(givenaml);
        billpanel.add(givenam);
        billpanel.add(Bill);
        billpanel.add(back);

    }

    public static void main(String args[]) {
        Monicas obj = new Monicas();
        obj.setTitle("KryTez Store");
        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
        obj.setVisible(true);

    }

}
