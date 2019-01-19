package yazlab2;

import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class RastgeleMAtris extends javax.swing.JFrame {

    private int M, N;
    private final double matris[][] = new double[M][N];
    private final double tmatris[][] = new double[N][M];

    public RastgeleMAtris() {
        initComponents();
        Random ran = new Random();
        int M, N;
        int sayac = 0;
        M = ran.nextInt(5) + 1;
        N = ran.nextInt(5) + 1;
        while (M == N) {
            M = ran.nextInt(5) + 1;
        }
        double matris[][] = new double[M][N];
        double tmatris[][] = new double[N][M];
        double smatris[][] = new double[N][M];
        System.out.println("Satır:" + M + " " + "Sütun:" + N);
        if (M < N) {
            double cmatris[][] = new double[M][M];
            //Matrisi Belirleme ve Transpozunu Alma
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    matris[i][j] = ran.nextInt(9) + 1;
                    tmatris[j][i] = matris[i][j];
                }
            }
            System.out.println("MATRİS");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matris[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("MATRİSİN TRANSPOZU");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(tmatris[i][j] + " ");
                }
                System.out.println();
            }

            //Matrisi Transpozuyla Çarpma
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < N; k++) {
                        cmatris[i][j] += matris[i][k] * tmatris[k][j];
                        sayac++;
                    }
                }
            }
            System.out.println("MATRİSLE TRANSPOZUN ÇARPIMI");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(cmatris[i][j] + " ");
                }
                System.out.println();
            }
            //Matrisin Tersini Alma
            double[][] bmatris = new double[M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == j) {
                        bmatris[i][j] = 1;
                    } else {
                        bmatris[i][j] = 0;
                    }
                }
            }
            double doga, koru;
            for (int i = 0; i < M; i++) {
                doga = cmatris[i][i];
                for (int j = 0; j < M; j++) {
                    cmatris[i][j] = cmatris[i][j] / doga;
                    bmatris[i][j] = bmatris[i][j] / doga;
                    sayac++;
                }
                for (int x = 0; x < M; x++) {
                    if (x != i) {
                        koru = cmatris[x][i];
                        for (int j = 0; j < M; j++) {
                            cmatris[x][j] = cmatris[x][j] - (cmatris[i][j] * koru);
                            bmatris[x][j] = bmatris[x][j] - (bmatris[i][j] * koru);
                            sayac++;
                        }
                    }

                }
            }
            System.out.println("BİRİM MATRİS");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(cmatris[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("İKİ MATRİSİN ÇARPIMININ TERSİ");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(bmatris[i][j] + " ");
                }
                System.out.println();
            }
            //Matrisin Transpozuyla Matrisin Tersini Çarpma
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < M; k++) {
                        smatris[i][j] += tmatris[i][k] * bmatris[k][j];
                        sayac++;
                    }
                }
            }
            System.out.println("TERS MATRİSİN MATRİSİN TRANSPOZU İLE ÇARPIMI");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(smatris[i][j] + " ");
                }
                System.out.println();
            }
        }
        if (N < M) {
            double cmatris[][] = new double[N][N];
            //Matrisi Belirleme ve Transpozunu Alma
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    matris[i][j] = ran.nextInt(9) + 1;
                    tmatris[j][i] = matris[i][j];
                }
            }
            System.out.println("MATRİS");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matris[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("MATRİSİN TRANSPOZU");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(tmatris[i][j] + " ");
                }
                System.out.println();
            }
            //Matrisi Transpozuyla Çarpma
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        cmatris[i][j] += tmatris[i][k] * matris[k][j];
                        sayac++;
                    }
                }
            }
            System.out.println("MATRİSLE TRANSPOZUN ÇARPIMI");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(cmatris[i][j] + " ");
                }
                System.out.println();
            }
            //Matrisin Tersini Alma
            double[][] bmatris = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        bmatris[i][j] = 1;
                    } else {
                        bmatris[i][j] = 0;
                    }
                }
            }
            double doga, koru;
            for (int i = 0; i < N; i++) {
                doga = cmatris[i][i];
                for (int j = 0; j < N; j++) {
                    cmatris[i][j] = cmatris[i][j] / doga;
                    bmatris[i][j] = bmatris[i][j] / doga;
                    sayac++;
                }
                for (int x = 0; x < N; x++) {
                    if (x != i) {
                        koru = cmatris[x][i];
                        for (int j = 0; j < N; j++) {
                            cmatris[x][j] = cmatris[x][j] - (cmatris[i][j] * koru);
                            bmatris[x][j] = bmatris[x][j] - (bmatris[i][j] * koru);
                            sayac++;
                        }
                    }

                }
            }
            System.out.println("BİRİM MATRİS");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(cmatris[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("İKİ MATRİSİN ÇARPIMININ TERSİ");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(bmatris[i][j] + " ");
                }
                System.out.println();
            }
            //Matrisin Transpozuyla Matrisin Tersini Çarpma
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < N; k++) {
                        smatris[i][j] += bmatris[i][k] * tmatris[k][j];
                        sayac++;
                    }
                }
            }
            System.out.println("TERS MATRİSİN MATRİSİN TRANSPOZU İLE ÇARPIMI");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(smatris[i][j] + " ");
                }
                System.out.println();
            }

        }
        System.out.println("Yapılan İşlemlerin Sayısı:" + sayac);
        if (N > 0) {
            String deg = Double.toString(matris[0][0]);
            jLabel1.setText(deg);
        }
        if (N > 1) {
            String deg = Double.toString(matris[0][1]);
            jLabel2.setText(deg);
        }
        if (N > 2) {
            String deg = Double.toString(matris[0][2]);
            jLabel3.setText(deg);
        }
        if (N > 3) {
            String deg = Double.toString(matris[0][3]);
            jLabel5.setText(deg);
        }
        if (N > 4) {
            String deg = Double.toString(matris[0][4]);
            jLabel7.setText(deg);
        }
        if (M > 1) {
            String deg = Double.toString(matris[1][0]);
            jLabel8.setText(deg);
        }
        if (M > 2) {
            String deg = Double.toString(matris[2][0]);
            jLabel13.setText(deg);
        }
        if (M > 3) {
            String deg = Double.toString(matris[3][0]);
            jLabel18.setText(deg);
        }
        if (M > 4) {
            String deg = Double.toString(matris[4][0]);
            jLabel23.setText(deg);
        }
        if (M > 1 && N > 1) {
            String deg = Double.toString(matris[1][1]);
            jLabel9.setText(deg);
        }
        if (M > 2 && N > 1) {
            String deg = Double.toString(matris[2][1]);
            jLabel14.setText(deg);
        }
        if (M > 3 && N > 1) {
            String deg = Double.toString(matris[3][1]);
            jLabel19.setText(deg);
        }
        if (M > 4 && N > 1) {
            String deg = Double.toString(matris[4][1]);
            jLabel24.setText(deg);
        }
        if (M > 1 && N > 2) {
            String deg = Double.toString(matris[1][2]);
            jLabel10.setText(deg);
        }
        if (M > 2 && N > 2) {
            String deg = Double.toString(matris[2][2]);
            jLabel15.setText(deg);
        }
        if (M > 3 && N > 2) {
            String deg = Double.toString(matris[3][2]);
            jLabel20.setText(deg);
        }
        if (M > 4 && N > 2) {
            String deg = Double.toString(matris[4][2]);
            jLabel25.setText(deg);
        }
        if (M > 1 && N > 3) {
            String deg = Double.toString(matris[1][3]);
            jLabel11.setText(deg);
        }
        if (M > 2 && N > 3) {
            String deg = Double.toString(matris[2][3]);
            jLabel16.setText(deg);
        }
        if (M > 3 && N > 3) {
            String deg = Double.toString(matris[3][3]);
            jLabel21.setText(deg);
        }
        if (M > 4 && N > 3) {
            String deg = Double.toString(matris[4][3]);
            jLabel26.setText(deg);
        }
        if (M > 1 && N > 4) {
            String deg = Double.toString(matris[1][4]);
            jLabel12.setText(deg);
        }
        if (M > 2 && N > 4) {
            String deg = Double.toString(matris[2][4]);
            jLabel17.setText(deg);
        }
        if (M > 3 && N > 4) {
            String deg = Double.toString(matris[3][4]);
            jLabel22.setText(deg);
        }
        if (M > 4 && N > 4) {
            String deg = Double.toString(matris[4][4]);
            jLabel27.setText(deg);
        }

        if (M > 0) {
            String deg = Double.toString(smatris[0][0]);
            jLabel30.setText(deg);
        }
        if (M > 1) {
            String deg = Double.toString(smatris[0][1]);
            jLabel35.setText(deg);
        }
        if (M > 2) {
            String deg = Double.toString(smatris[0][2]);
            jLabel40.setText(deg);
        }
        if (M > 3) {
            String deg = Double.toString(smatris[0][3]);
            jLabel45.setText(deg);
        }
        if (M > 4) {
            String deg = Double.toString(smatris[0][4]);
            jLabel50.setText(deg);
        }
        if (N > 1) {
            String deg = Double.toString(smatris[1][0]);
            jLabel31.setText(deg);
        }
        if (N > 2) {
            String deg = Double.toString(smatris[2][0]);
            jLabel32.setText(deg);
        }
        if (N > 3) {
            String deg = Double.toString(smatris[3][0]);
            jLabel33.setText(deg);
        }
        if (N > 4) {
            String deg = Double.toString(smatris[4][0]);
            jLabel34.setText(deg);
        }
        if (N > 1 && M > 1) {
            String deg = Double.toString(smatris[1][1]);
            jLabel36.setText(deg);
        }
        if (N > 2 && M > 1) {
            String deg = Double.toString(smatris[2][1]);
            jLabel37.setText(deg);
        }
        if (N > 3 && M > 1) {
            String deg = Double.toString(smatris[3][1]);
            jLabel38.setText(deg);
        }
        if (N > 4 && M > 1) {
            String deg = Double.toString(smatris[4][1]);
            jLabel39.setText(deg);
        }
        if (N > 1 && M > 2) {
            String deg = Double.toString(smatris[1][2]);
            jLabel41.setText(deg);
        }
        if (N > 2 && M > 2) {
            String deg = Double.toString(smatris[2][2]);
            jLabel42.setText(deg);
        }
        if (N > 3 && M > 2) {
            String deg = Double.toString(smatris[3][2]);
            jLabel43.setText(deg);
        }
        if (N > 4 && M > 2) {
            String deg = Double.toString(smatris[4][2]);
            jLabel44.setText(deg);
        }
        if (N > 1 && M > 3) {
            String deg = Double.toString(smatris[1][3]);
            jLabel46.setText(deg);
        }
        if (N > 2 && M > 3) {
            String deg = Double.toString(smatris[2][3]);
            jLabel47.setText(deg);
        }
        if (N > 3 && M > 3) {
            String deg = Double.toString(smatris[3][3]);
            jLabel48.setText(deg);
        }
        if (N > 4 && M > 3) {
            String deg = Double.toString(smatris[4][3]);
            jLabel49.setText(deg);
        }
        if (N > 1 && M > 4) {
            String deg = Double.toString(smatris[1][4]);
            jLabel51.setText(deg);
        }
        if (N > 2 && M > 4) {
            String deg = Double.toString(smatris[2][4]);
            jLabel52.setText(deg);
        }
        if (N > 3 && M > 4) {
            String deg = Double.toString(smatris[3][4]);
            jLabel53.setText(deg);
        }
        if (N > 4 && M > 4) {
            String deg = Double.toString(smatris[4][4]);
            jLabel54.setText(deg);
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

        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 255));
        jLabel28.setText("MATRİS");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 255));
        jLabel29.setText("MATRİSİN TERSİ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel9)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel10)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel11)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel14)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel15)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel16)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel18)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel19)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel20)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel21)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel23)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel24)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel25)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel26)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel30)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel35)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel40)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel45)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel50))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel31)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel36)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel41)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel46)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel32)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel37)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel42)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel47)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel33)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel38)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel43)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel48)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel53))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel34)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel39)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel44)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel49)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel54)))
                .addContainerGap(649, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel28)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(46, 46, 46)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel35)
                    .addComponent(jLabel40)
                    .addComponent(jLabel45)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel36)
                    .addComponent(jLabel41)
                    .addComponent(jLabel46)
                    .addComponent(jLabel51))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel37)
                    .addComponent(jLabel42)
                    .addComponent(jLabel47)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel38)
                    .addComponent(jLabel43)
                    .addComponent(jLabel48)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel39)
                    .addComponent(jLabel44)
                    .addComponent(jLabel49)
                    .addComponent(jLabel54))
                .addContainerGap(259, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(RastgeleMAtris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RastgeleMAtris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RastgeleMAtris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RastgeleMAtris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RastgeleMAtris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
