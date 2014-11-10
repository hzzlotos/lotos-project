package cn.newtouch.session.Check;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private static int        WIDTH            = 60;

    private static int        HEIGHT           = 20;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // 设置属性
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 画图
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics gra = image.getGraphics();
        char[] rands = this.generateCheckCode();
        this.drawBackground(gra);
        this.drawRands(gra, rands);
        gra.dispose();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", bos);
        byte[] buf = bos.toByteArray();
        response.setContentLength(buf.length);
        bos.close();

        // 写进response
        ServletOutputStream sos = response.getOutputStream();
        sos.write(buf);
        sos.close();

        // 写进session
        HttpSession session = request.getSession();
        session.setAttribute("checkCode", new String(rands));
    }

    private char[] generateCheckCode()
    {
        String chars = "0123456789";
        char[] rands = new char[4];
        for (int i = 0; i < 4; i++)
        {
            int rand = (int) (Math.random() * 10);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

    private void drawBackground(Graphics gra)
    {
        gra.setColor(new Color(0xDCDCDC));
        gra.fillRect(0, 0, WIDTH, HEIGHT);
        int x, y, red, green, blue;
        for (int i = 0; i < 120; i++)
        {
            x = (int) (Math.random() * WIDTH);
            y = (int) (Math.random() * HEIGHT);
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            gra.setColor(new Color(red, green, blue));
            gra.drawOval(x, y, 1, 0);
        }
    }

    private void drawRands(Graphics gra, char[] rands)
    {
        gra.setColor(Color.BLACK);
        gra.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
        gra.drawString("" + rands[0], 1, 17);
        gra.drawString("" + rands[1], 16, 15);
        gra.drawString("" + rands[2], 31, 18);
        gra.drawString("" + rands[3], 46, 16);
        System.out.println(rands);
    }
}