package yazlab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class gosterme extends JFrame implements ActionListener {

    DefaultTableModel model = new DefaultTableModel();
    private static int satir, sütun;
    private static int sonSatir, sonSütun;
    private static double anaMatris[][];
    private static double tutMatris[][];
    private static int sonuc;
    private static JButton yeniMatris, gosterMatris, hesapla;
    private static JPanel secimPanel[] = new JPanel[8];
    private static JTextField girisAlani[][];

    gosterme() {
        satir = 0;
        sütun = 0;
        anaMatris = new double[0][0];
        secimBolge();
    }

    private static boolean sayimi(String str) {
        int tut;
        if (str.length() == '0') {
            return false;
        }

        for (tut = 0; tut < str.length(); tut++) {
            if (str.charAt(tut) != '+' && str.charAt(tut) != '-'
                    && !Character.isDigit(str.charAt(tut))) {
                return false;
            }
        }
        return true;
    }

    private static void MatrisinBoyutu() {
        JTextField satirAlani = new JTextField(5);
        JTextField sütunAlani = new JTextField(5);

        JPanel secimPanel[] = new JPanel[2];
        secimPanel[0] = new JPanel();
        secimPanel[1] = new JPanel();

        secimPanel[0].add(new JLabel("Lütfen Matrisin Boyutlarını Girin"));
        secimPanel[1].add(new JLabel("Sütun Sayisini Giriniz"));
        secimPanel[1].add(satirAlani);
        secimPanel[1].add(Box.createHorizontalStrut(25));
        secimPanel[1].add(new JLabel("Satir Sayisini Giriniz"));
        secimPanel[1].add(sütunAlani);

        sonuc = JOptionPane.showConfirmDialog(null, secimPanel, null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        sonSatir = satir;
        sonSütun = sütun;

        if (sonuc == 0) {
            if (satirAlani.getText().equals("")) {
                satir = 0;
            } else {
                if (sayimi(satirAlani.getText())) {
                    satir = Integer.parseInt(satirAlani.getText());

                } else {
                    JOptionPane.showMessageDialog(null, "Yanlış Değerler Girdiniz");
                    satir = sonSatir;
                    sütun = sonSütun;
                    return;
                }
            }
            if (sayimi(sütunAlani.getText())) {
                sütun = Integer.parseInt(sütunAlani.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Yanlış Değerler Girdiniz");
                satir = sonSatir;
                sütun = sonSütun;
                return;
            }
            if (satir == sütun) {
                JOptionPane.showConfirmDialog(null, "Lütfen Kare Olmayan Bir Matris Boyutu Giriniz", "Hata!", JOptionPane.PLAIN_MESSAGE);
                satir = sonSatir;
                sütun = sonSütun;
            }
            if (satir < 1 || sütun < 1) {
                JOptionPane.showConfirmDialog(null, "Yanlış Boyut Değerleri Girdiniz", "Hata!", JOptionPane.PLAIN_MESSAGE);
                satir = sonSatir;
                sütun = sonSütun;
            } else {
                tutMatris = anaMatris;
                anaMatris = new double[sütun][satir];
                if (!elemanlar(anaMatris, "Matrisinizin Elemanlarını Girin")) {

                    anaMatris = tutMatris;
                }
            }

        } else if (sonuc == 1) {
            satir = sonSatir;
            sütun = sonSütun;
        }
    }

    private static boolean elemanlar(double matris[][], String title) {
        int tut, tut1;
        String tutString;

        JPanel secimPanel[] = new JPanel[sütun + 2];
        secimPanel[0] = new JPanel();
        secimPanel[0].add(new Label(title));
        secimPanel[secimPanel.length - 1] = new JPanel();
        secimPanel[secimPanel.length - 1].add(new Label("Boşluklara 0 değeri atanacaktır"));
        girisAlani = new JTextField[matris.length][matris[0].length];

        for (tut = 1; tut <= matris.length; tut++) {
            secimPanel[tut] = new JPanel();

            for (tut1 = 0; tut1 < matris[0].length; tut1++) {
                girisAlani[tut - 1][tut1] = new JTextField(3);
                secimPanel[tut].add(girisAlani[tut - 1][tut1]);

                if (tut1 < matris[0].length - 1) {
                    secimPanel[tut].add(Box.createHorizontalStrut(15));
                }

            }

        }

        sonuc = JOptionPane.showConfirmDialog(null, secimPanel, null, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (sonuc == 0) {
            metinKontrol(girisAlani);
            for (tut = 0; tut < matris.length; tut++) {
                for (tut1 = 0; tut1 < matris[0].length; tut1++) {
                    tutString = girisAlani[tut][tut1].getText();

                    if (degerDouble(tutString)) {
                        matris[tut][tut1] = Double.parseDouble(girisAlani[tut][tut1].getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "Yanlış Değerler Girdiniz");
                        satir = sonSatir;
                        sütun = sonSütun;

                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private static void metinKontrol(JTextField alan[][]) {
        for (int tut = 0; tut < alan.length; tut++) {
            for (int tut1 = 0; tut1 < alan[0].length; tut1++) {
                if (alan[tut][tut1].getText().equals("")) {
                    alan[tut][tut1].setText("0");
                }
            }
        }
    }

    private static boolean degerDouble(String str) {
        int tut;
        if (str.length() == '0') {
            return false;
        }

        for (tut = 0; tut < str.length(); tut++) {
            if (str.charAt(tut) != '+' && str.charAt(tut) != '-'
                    && str.charAt(tut) != '.'
                    && !Character.isDigit(str.charAt(tut))) {
                return false;
            }
        }
        return true;
    }

    private void secimBolge() {
        int tut;
        for (tut = 0; tut < secimPanel.length; tut++) {
            secimPanel[tut] = new JPanel();
        }
        gosterMatris = new JButton("Matrisi Göster");
        gosterMatris.setPreferredSize(new Dimension(150, 35));
        gosterMatris.addActionListener(this);
        secimPanel[1].add(gosterMatris);
        yeniMatris = new JButton("Yeni Matris");
        yeniMatris.setPreferredSize(new Dimension(100, 35));
        yeniMatris.addActionListener(this);
        secimPanel[0].add(yeniMatris);
        hesapla = new JButton("Hesapla");
        hesapla.setPreferredSize(new Dimension(100, 35));
        hesapla.addActionListener(this);
        secimPanel[2].add(hesapla);

        JOptionPane.showConfirmDialog(null, secimPanel, null, JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    private static void gosterMatris(double[][] matrix, String title) {
        int tut, tut1;

        JPanel secimPanel[] = new JPanel[matrix.length + 1];
        secimPanel[0] = new JPanel();
        secimPanel[0].add(new JLabel(title));

        for (tut = 1; tut <= matrix.length; tut++) {
            secimPanel[tut] = new JPanel();

            for (tut1 = 0; tut1 < matrix[0].length; tut1++) {
                if (matrix[tut - 1][tut1] == -0) {
                    matrix[tut - 1][tut1] = 0;
                }
                secimPanel[tut].add(new JLabel(String.format("%.2f", matrix[tut - 1][tut1])));

                if (tut1 < matrix[0].length - 1) {
                    secimPanel[tut].add(Box.createHorizontalStrut(15));
                }

            }

        }

        if (satir == 0 || sütun == 0) {
            JOptionPane.showMessageDialog(null, "Matris Girşi Yapmadınız", "mesaj", 1);

        } else {

            JOptionPane.showMessageDialog(null, secimPanel, null, JOptionPane.PLAIN_MESSAGE, null);

        }
    }

    private static void hesapla(double matris[][]) {
        int satir = matris.length;
        int sütun = matris[0].length;
        System.out.println("satir :" + satir + " sütun :" + sütun);
        double transpozMatris[][] = new double[sütun][satir];
        double[][] carpimMatris = new double[sütun][sütun];

        System.out.println("------- TRANSPOZE MATRİSİMİZ -------");
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sütun; j++) {
                transpozMatris[j][i] = matris[i][j];
            }
        }

        if (satir > sütun) {
            int sayac = 0;
            System.out.println("");
            System.out.println("-------ÇARPIM MATRİSİMİZ--------");
            Carpma s = new Carpma();
            carpimMatris = s.carpma(transpozMatris, anaMatris);
            sayac = sayac + (satir * sütun);
            double[][] kopyaMatris = new double[carpimMatris.length][carpimMatris[0].length];
            for (int i = 0; i < carpimMatris.length; i++) {
                for (int j = 0; j < carpimMatris[0].length; j++) {
                    kopyaMatris[i][j] = carpimMatris[i][j];
                }
            }
            System.out.println("-----CARPİM MATRİSİNİN TERSİ------");

            double[][] birimMatris = new double[sütun][sütun];
            for (int i = 0; i < sütun; i++) {
                for (int j = 0; j < sütun; j++) {
                    if (i == j) {
                        birimMatris[i][j] = 1;
                    } else {
                        birimMatris[i][j] = 0;
                    }
                }
            }
            double doga, koru;
            for (int i = 0; i < sütun; i++) {
                doga = carpimMatris[i][i];
                for (int j = 0; j < sütun; j++) {
                    carpimMatris[i][j] = carpimMatris[i][j] / doga;
                    birimMatris[i][j] = birimMatris[i][j] / doga;
                    sayac = sayac + 2;
                }
                for (int x = 0; x < sütun; x++) {
                    if (x != i) {
                        koru = carpimMatris[x][i];
                        for (int j = 0; j < sütun; j++) {
                            carpimMatris[x][j] = carpimMatris[x][j] - (carpimMatris[i][j] * koru);
                            birimMatris[x][j] = birimMatris[x][j] - (birimMatris[i][j] * koru);
                            sayac = sayac + 4;
                        }
                    }

                }
            }

            System.out.println("ANA MATRİSİMİZİN TERSİ");
            double[][] sonMatris = new double[sütun][satir];
            sonMatris = s.carpma(birimMatris, transpozMatris);
            for (int i = 0; i < sonMatris.length; i++) {
                for (int j = 0; j < sonMatris[0].length; j++) {
                    System.out.print(sonMatris[i][j]);
                }
                System.out.println();
            }
            canlan(matris, transpozMatris, kopyaMatris, birimMatris, sonMatris, sayac);

        }
        if (sütun > satir) {
            int sayac = 0;
            System.out.println("-------ÇARPIM MATRİSİMİZ--------");
            Carpma s = new Carpma();
            carpimMatris = s.carpma(anaMatris, transpozMatris);
            sayac = sayac + (satir * sütun);
            double[][] kopyaMatris = new double[carpimMatris.length][carpimMatris[0].length];
            for (int i = 0; i < carpimMatris.length; i++) {
                for (int j = 0; j < carpimMatris[0].length; j++) {
                    kopyaMatris[i][j] = carpimMatris[i][j];
                }
            }
            double[][] birimMatris = new double[satir][satir];
            for (int i = 0; i < satir; i++) {
                for (int j = 0; j < satir; j++) {
                    if (i == j) {
                        birimMatris[i][j] = 1;
                    } else {
                        birimMatris[i][j] = 0;
                    }
                }
            }

            double doga, koru;
            for (int i = 0; i < satir; i++) {
                doga = carpimMatris[i][i];
                for (int j = 0; j < satir; j++) {
                    carpimMatris[i][j] = carpimMatris[i][j] / doga;
                    birimMatris[i][j] = birimMatris[i][j] / doga;
                    sayac = sayac + 2;
                }
                for (int x = 0; x < satir; x++) {
                    if (x != i) {
                        koru = carpimMatris[x][i];
                        for (int j = 0; j < satir; j++) {
                            carpimMatris[x][j] = carpimMatris[x][j] - (carpimMatris[i][j] * koru);
                            birimMatris[x][j] = birimMatris[x][j] - (birimMatris[i][j] * koru);
                            sayac = sayac + 4;
                        }
                    }

                }
            }
            double[][] sonMatris = new double[satir][sütun];
            System.out.println("ANA MATRİSİMİZİN TERSİ");
            sonMatris = s.carpma(transpozMatris, birimMatris);
            for (int i = 0; i < sonMatris.length; i++) {
                for (int j = 0; j < sonMatris[0].length; j++) {
                    System.out.print(sonMatris[i][j] + "       ");
                }
                System.out.println("");
            }
            canlan(matris, transpozMatris, kopyaMatris, birimMatris, sonMatris, sayac);
        }

    }

    private static void yeniMatris() {
        MatrisinBoyutu();
    }

    public static void canlan(double anaMatris[][], double transMatris[][], double carpimMatris[][], double tersMatris[][], double sonMatris[][], int sayi) {

        int tut, tut1;             //temprature variable

        JPanel secimPanel[] = new JPanel[anaMatris.length + 1];
        JPanel secimPanel1[] = new JPanel[transMatris.length + 1];
        JPanel secimPanel2[] = new JPanel[carpimMatris.length + 1];
        JPanel secimPanel3[] = new JPanel[tersMatris.length + 1];
        JPanel secimPanel4[] = new JPanel[sonMatris.length + 1];
        secimPanel[0] = new JPanel();

        for (tut = 1; tut <= anaMatris.length; tut++) {
            secimPanel[tut] = new JPanel();

            for (tut1 = 0; tut1 < anaMatris[0].length; tut1++) {
                if (anaMatris[tut - 1][tut1] == -0) {
                    anaMatris[tut - 1][tut1] = 0;
                }
                secimPanel[tut].add(new JLabel(String.format("%.2f", anaMatris[tut - 1][tut1])));

                if (tut1 < anaMatris[0].length - 1) {
                    secimPanel[tut].add(Box.createHorizontalStrut(15));
                }

            }

        }

        for (tut = 1; tut <= transMatris.length; tut++) {
            secimPanel1[tut] = new JPanel();

            for (tut1 = 0; tut1 < transMatris[0].length; tut1++) {
                if (transMatris[tut - 1][tut1] == -0) {
                    transMatris[tut - 1][tut1] = 0;
                }
                secimPanel1[tut].add(new JLabel(String.format("%.2f", transMatris[tut - 1][tut1])));

                if (tut1 < transMatris[0].length - 1) {
                    secimPanel1[tut].add(Box.createHorizontalStrut(15));
                }

            }

        }

        for (tut = 1; tut <= carpimMatris.length; tut++) {
            secimPanel2[tut] = new JPanel();

            for (tut1 = 0; tut1 < carpimMatris[0].length; tut1++) {
                if (carpimMatris[tut - 1][tut1] == -0) {
                    carpimMatris[tut - 1][tut1] = 0;
                }
                secimPanel2[tut].add(new JLabel(String.format("%.2f", carpimMatris[tut - 1][tut1])));

                if (tut1 < carpimMatris[0].length - 1) {
                    secimPanel2[tut].add(Box.createHorizontalStrut(15));
                }

            }

        }

        for (tut = 1; tut <= tersMatris.length; tut++) {
            secimPanel3[tut] = new JPanel();

            for (tut1 = 0; tut1 < tersMatris[0].length; tut1++) {
                if (tersMatris[tut - 1][tut1] == -0) {
                    tersMatris[tut - 1][tut1] = 0;
                }
                secimPanel3[tut].add(new JLabel(String.format("%.2f", tersMatris[tut - 1][tut1])));

                if (tut1 < tersMatris[0].length - 1) {
                    secimPanel3[tut].add(Box.createHorizontalStrut(15));
                }

            }

        }

        for (tut = 1; tut <= sonMatris.length; tut++) {
            secimPanel4[tut] = new JPanel();

            for (tut1 = 0; tut1 < sonMatris[0].length; tut1++) {
                if (sonMatris[tut - 1][tut1] == -0) {
                    sonMatris[tut - 1][tut1] = 0;
                }
                secimPanel4[tut].add(new JLabel(String.format("%.2f", sonMatris[tut - 1][tut1])));

                if (tut1 < sonMatris[0].length - 1) {
                    secimPanel4[tut].add(Box.createHorizontalStrut(15)); // a spacer
                }

            }//end col loop

        }//end row loop

        JOptionPane.showMessageDialog(null, secimPanel, "ANAMATRİS", JOptionPane.PLAIN_MESSAGE, null);
        JOptionPane.showMessageDialog(null, secimPanel1, "TRANSPOZE MATRİS", JOptionPane.PLAIN_MESSAGE, null);
        JOptionPane.showMessageDialog(null, secimPanel2, "ÇARPİM MATRİS", JOptionPane.PLAIN_MESSAGE, null);
        JOptionPane.showMessageDialog(null, secimPanel3, "CARPİMİN TERSİ", JOptionPane.PLAIN_MESSAGE, null);
        JOptionPane.showMessageDialog(null, secimPanel4, "ANA MATRİSİN TERSİ", JOptionPane.PLAIN_MESSAGE, null);
        JOptionPane.showMessageDialog(null, sayi, "TOPLAM İŞLEM SAYISI", JOptionPane.PLAIN_MESSAGE, null);

    }

    public static void main(String[] args) {
        gosterme m1 = new gosterme();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yeniMatris) {
            yeniMatris();
        }
        if (e.getSource() == gosterMatris) {
            gosterMatris(anaMatris, "Girilen Matris");
        }
        if (e.getSource() == hesapla) {
            hesapla(anaMatris);
        }
    }
}
