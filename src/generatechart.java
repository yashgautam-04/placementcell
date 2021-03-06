
import java.awt.Color;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class generatechart extends javax.swing.JFrame {
int rnum=0,cid1=0;
    /**
     * Creates new form generatechart
     */
    public generatechart() {
        initComponents();
        getContentPane().setBackground(Color.green);
    }

    public generatechart(int a, int cid) {
           initComponents();
           rnum = a;
           cid1 = cid;
           showdata();
           showdata1();
    }
    void showdata()
    {
        try
        {
             myconnection obj=new myconnection();
                String q = "select * from tbaggregate";
                PreparedStatement pst = obj.db.prepareStatement(q);
                ResultSet rs = pst.executeQuery();
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                String n;
                int cans,incans,unatt;
                while(rs.next() ) 
      {
          n=""+rs.getInt("rnum");
          cans=rs.getInt("correctans");
          incans=rs.getInt("incorrectans");
          unatt=rs.getInt("unattempted");
          dataset.setValue(cans,n,"correct answer");
          dataset.setValue(incans, n, "incorrect answer");
          dataset.setValue(unatt, n, "unattempted");
      }
      JFreeChart barChart = ChartFactory.createBarChart(
         "STUDENT MARKS STATIStICS", 
         "Category", "Score", 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);  //legend tooltil path        
      
      
      int width = 640; /* Width of the image */
      int height = 480; /* Height of the image */ 
      File BarChart = new File( "BarChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
            ImageIcon img = new ImageIcon("BarChart.jpeg");
            jLabel1.setIcon(img);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    void showdata1()
    {
        try
        {
        
      /* Create MySQL Database Connection */
     myconnection obj=new myconnection();
     String q = "select * from tbaggregate where rnum=? and cid=?";
                PreparedStatement pst;
     pst=obj.db.prepareStatement(q);
     pst.setInt(1,rnum);
     pst.setInt(2,cid1);
      ResultSet rs = pst.executeQuery();
      String n;
      int cans,incans,unatt;
      DefaultPieDataset dataset = new DefaultPieDataset( );
      while(rs.next() ) 
      {
          n=""+rs.getInt("rnum");
          cans = rs.getInt("correctans");
          incans = rs.getInt("incorrectans");
          unatt = rs.getInt("unattempted");
         dataset.setValue("correct",cans);
         dataset.setValue("incorrect",incans);
         dataset.setValue("unattempted",unatt);
      }
        JFreeChart chart = ChartFactory.createPieChart(
         "Result",  // chart title           
         dataset,         // data           
         true,            // include legend          
         true,           
         false );
      int width = 560; /* Width of the image */
      int height = 370; /* Height of the image */ 
      File pieChart = new File( "Pie_Chart.jpeg" );
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
      ImageIcon img = new ImageIcon("Pie_Chart.jpeg");
            jLabel2.setIcon(img);
        }
        catch(Exception f)
        {
            System.out.println(f.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(209, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(generatechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generatechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generatechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generatechart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generatechart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
