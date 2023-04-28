import javax.swing.*;
import java.awt.*;

public class FallingItemFrame extends JFrame {

    FallingItemPanel panel;
    Double acceleration, velocity, angle;
    FallingItemFrame(Double acceleration, Double velocity, Double angle) {
        this.acceleration = acceleration;
        this.velocity = velocity;
        this.angle = Math.toRadians(angle);
        this.setSize(new Dimension(800, 800));
        this.setResizable(false);
        this.setLayout(null);

        panel = new FallingItemPanel();

        this.add(panel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    private class FallingItemPanel extends JPanel {

        double flightTime, flightLength, maxHigh;
        Point pos;
        FallingItemPanel() {
            this.setSize(800,800);
            this.flightTime = 2 * velocity * Math.sin(angle) / acceleration;
            System.out.println(flightTime);

            this.pos = new Point(100, 695);
            this.flightLength = Math.pow(velocity, 2) * Math.pow(Math.sin(angle), 2) / (2 * acceleration);
            this.maxHigh = Math.pow(velocity, 2) * Math.pow(Math.sin(angle), 2) / acceleration;
            System.out.println("Max High " + maxHigh);
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(0, 700, 800, 700);
            g2d.setPaint(Color.RED);
            g2d.drawOval((int) pos.getX(), (int) pos.getY(), 1, 1);

            Point maxPoint = new Point(100, 700);
            double counter = 0;
            while (counter < flightTime) {
                counter += 0.05;
                pos = getCurrentPos(counter);
                g2d.drawOval((int) pos.getX(), (int) pos.getY(), 1, 1);
                if (pos.getY() < maxPoint.getY()) {
                    maxPoint.setLocation(pos);
                }
            }

            g2d.setPaint(Color.GREEN);
            g2d.setStroke(new BasicStroke(4));
            g2d.fillOval((int)maxPoint.getX(), (int)maxPoint.getY(), 4, 4);

        }

        Point getCurrentPos(double time) {
            return new Point(
                    (int) (velocity * Math.cos(angle) * time) + 100,
                    700 -  (int) (velocity * Math.sin(angle) * time - (acceleration * Math.pow(time, 2) / 2))
            );
        }
    }


}
