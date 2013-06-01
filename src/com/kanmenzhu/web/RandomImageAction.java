package com.kanmenzhu.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 将文字用指定的字体，颜色和大小，嵌入指定图片的指定位置,调用参数:
 * text:  　　　要嵌的文字
 * imageFile: 　JPG图片的虚拟路径
 * x: 　　　　　文字输出的起始X坐标位置
 * fontStyle: 　字体风格(斜体,粗体等)
 * fontName: 　字体名称(如仿宋体,宋体等)
 */

public class RandomImageAction extends ActionSupport{

	protected Logger logger=LoggerFactory.getLogger(getClass());
	
	private static final long serialVersionUID = -4370389071409471544L;
	/**图片保存在session中的名称*/
	public static final String IMG_SESSION_NAME="imageVerifySession";
    //背景字符集
    private char[] backSourceChar= {'*','.',',','~','^'};
    int backSouceCharLength = backSourceChar.length;
    float maxRotate = 0.3f;
    float maxScalePlus = 0.1f;
    int yoffset = 4;
    int xoffset = 2;

    /**输出流*/
    private ByteArrayInputStream inputStream;

    /**
     * 生成图片验证码,并将验证码保存到HttpSession sessionName 中
     * @param session HttpSession
     * @param sessionName session名称
     * @return 输出流
     */
    @Override
    public String execute() throws Exception{
    	HttpServletResponse response=ServletActionContext.getResponse();
    	int x = 0;                      //坐标
    	int fontSize=18;				//最小字体
        String fontStyle = "";          //字体风格(斜体,粗体等)
        String fontName = "";           //字体名称
        int lineNum = 0;				//干扰线条数


        try {
            x = 5;
            if(x > 5) x = 5;
            lineNum = 5;
            fontSize = 18;
            if(fontSize < 18) fontSize = 18;
                fontName = "System";
        } catch (Exception e) {
            e.printStackTrace();
        }

        int actualFontStyle = "italic".equalsIgnoreCase(fontStyle)?Font.ITALIC:("bold".equalsIgnoreCase(fontStyle)?Font.BOLD:("plain".equalsIgnoreCase(fontStyle)?Font.PLAIN:Font.BOLD));

    	  // 设置图片的长宽
    	  int width = 86, height = 20;
    	  //设置文字区域的高度，要留出4象素给类似g这样的字符
    	  int textAreaHeight = height - 3;
    	  //设置备选字符
    	  //String base = "235678abcdefhkmnprsuvwxyzBCDEFGHJKLMNPQRSTUVWXYZ";
    	  String base = "0123456789";
    	  //备选字符的长度
    	  int length = base.length();
    	  //创建内存图像
    	  BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    	  // 获取图形上下文
    	  Graphics g = image.getGraphics();
    	  //创建随机类的实例
    	  Random random = new Random();
    	  // 设定图像背景色(因为是做背景，所以偏淡)
    	  g.setColor(getRandColor(random, 200, 250));
    	  g.fillRect(0, 0, width, height);
    	  //备选字体
//    	  String[] fontTypes = {
//    	      "Arial Black", "Elephant", "Felix Titling", "Tahoma", "Rockwell"};
//    	  String[] fontTypes = {
//        	      "Elephant"};
    	  String[] fontTypes = {"Elephant"};
    	  int fontTypesLength = fontTypes.length;
    	  //在图片背景上增加噪点
    	  g.setColor(getRandColor(random, 160, 200));
    	  g.setFont(new Font("Times New Roman", actualFontStyle, fontSize));
    	  for (int i = 0; i < 6; i++) {
    		  for (int j = 0; j <= width / 14; j++) {
    			  g.drawString(String.valueOf(backSourceChar[random.nextInt(backSouceCharLength)]), j * 14, 5 * (i + 2));
    		  }
    	  }
    	  //产生随机横线
//    	  for (int i = 0; i < lineNum; i++) {
//    		  g.setColor(getRandColor(random, 10, 150));
//    		  g.drawLine(random.nextInt(width),random.nextInt(height),random.nextInt(width),random.nextInt(height));
//    	  }
    	  //取随机产生的认证码(4个字符)
    	  //保存生成的字符串
    	  String sRand = "";
    	  float preX = x;
    	  float preRotate = 0;
    	  float preScale = 0;
    	  float rotate = 0;
    	  float scale = 0;
//    	  g.setColor(getRandColor(random, 10, 150));
//    	  g.setFont(new Font("Elephant", actualFontStyle, 18));
//    	  g.drawString("jjjj",0,18);
    	  Graphics2D g2 = (Graphics2D)g;
    	  for (int i = 0; i < 4; i++) {
    	    int start = random.nextInt(length);
    	    String rand = base.substring(start, start + 1);
    	    sRand += rand;
    	  //设置字体的颜色
    	    g.setColor(getRandColor(random, 10, 150));
    	  //设置字体
    	    //int randFontSize = fontSize + random.nextInt(textAreaHeight-fontSize+4);
    	    int randFontSize = textAreaHeight-fontSize > 0?fontSize + random.nextInt(textAreaHeight-fontSize):textAreaHeight;
    	    Font tmpFont = null;
    	    //if(fontName == null)
    	    	tmpFont = new Font(fontTypes[random.nextInt(fontTypesLength)], actualFontStyle, randFontSize);
    	    //else
    	    	//tmpFont = new Font(fontName, Font.BOLD, randFontSize);
    	    //g.setFont(tmpFont);
    	    //将此字符画到图片上
    	    rotate = getRandomRotate(random);
    	    scale = getRandomScale(random);
    	    if(i==0){
    	    	preRotate = rotate;
        	    preScale = scale;
        	    if(rotate>0) g2.translate(20*rotate, 0);//首字母若右倾，则左边留空
    	    }
    	    float tmpint = drawBoxedString(g2, rand, tmpFont,rotate,scale,preRotate,preScale,i);
    	    preX = preX+tmpint;
    	    preRotate = rotate;
    	    preScale = scale;
    	  }
    	  //将认证码存入session
    	  response.setHeader("P3P","CP=CAO PSA OUR IDC DSP COR ADM DEVi TAIi PSD IVAi IVDi CONi HIS IND CNT");
    	  ActionContext.getContext().getSession().put(IMG_SESSION_NAME,sRand);
          if (logger.isDebugEnabled())
              logger.debug("生成的验证码是： "+ ActionContext.getContext().getSession().get(IMG_SESSION_NAME));

          //输出数据流
          g.dispose ();
          
          ByteArrayOutputStream output = new ByteArrayOutputStream();
          ImageOutputStream iout = ImageIO.createImageOutputStream(output);
          ImageIO.write(image, "JPEG", iout);
          iout.close();
          output.close();
          ByteArrayInputStream in = new ByteArrayInputStream(output.toByteArray());
          this.inputStream=in;
          return SUCCESS;

    }
    private float getRandomRotate(Random random){
    	float tmp = random.nextFloat();
    	if(tmp > maxRotate) tmp = maxRotate;
    	return (random.nextBoolean()?1:-1)* tmp;
    }

    private float getRandomScale(Random random){
    	float tmp = random.nextFloat();
    	if(tmp > maxScalePlus) tmp = maxScalePlus;
    	return 1+(random.nextBoolean()?1:-1)* tmp;
    }
//  生成随机颜色
    Color getRandColor(Random random, int fc, int bc) {
      if (fc > 255) fc = 255;
      if (bc > 255) bc = 255;
      int r = fc + random.nextInt(bc - fc);
      int g = fc + random.nextInt(bc - fc);
      int b = fc + random.nextInt(bc - fc);
      return new Color(r, g, b);
    }

    /**
     * 获得request中指定名称的参数值,若有中文乱码问题请增加转码部分
     * @param request ServletRequest对象
     * @param paramName 参数名称
     * @return 如果该变量值存在则返回该值，否则返回""
     */
    public String getParameter(ServletRequest request, String paramName) {
        String temp = request.getParameter(paramName);
        if (temp != null && !temp.equals("")) {
            //若有中文问题，在此添加转码代码，例：temp = new String(temp.getBytes("8859_1"), "GB2312");
            return temp;
        } else {
            return "";
        }
    }

    /**
     * 获得request中的int型参数值
     * @param request ServletRequest对象
     * @param paramName 参数名称
     * @param defaultNum 默认值，如果没有返回该值
     * @return 如果该参数值存在则返回其转换为int型的值，否则返回defaultNum
     */
    public int getIntParameter(ServletRequest request, String paramName, int defaultNum) {
        String temp = request.getParameter(paramName);
        if (temp != null && !temp.equals("")) {
            int num = defaultNum;
            try {
                num = Integer.parseInt(temp);
            } catch (Exception ignored) {
            }
            return num;
        } else {
            return defaultNum;
        }
    }
    protected float drawBoxedString(Graphics2D g2,
    	      String s, Font mFont, float rotate,float scale,float preRotate,float preScale,int index) {
    	    g2.setFont(mFont);
    	    if(index > 0){
    	    	g2.translate(xoffset+(rotate>preRotate?(rotate-preRotate)*10:0)+(scale>1?(scale-1)*10:0),0);
    	    	//System.out.println("zheng:"+(xoffset+(rotate>preRotate?(rotate-preRotate)*10:0)));
    	    }else
    	    	g2.translate(xoffset+(rotate>0?rotate*10:0)+(scale>1?(scale-1)*20:0),0);
    	    g2.scale(scale,1f/scale);
    	    g2.rotate(rotate);
    	    //FontRenderContext frc = g2.getFontRenderContext();
    	    //TextLayout subLayout = new TextLayout(s, mFont, frc);
    	    //float advance = subLayout.getAdvance();
            float advance = 14;
    	    //Rectangle2D bounds = subLayout.getBounds();
            //System.out.println("boundy"+bounds.getY());
    	    //System.out.println(s+":"+rotate+"|"+preRotate+"|"+(rotate-preRotate)+"|"+(rotate-preRotate)*10+"|"+(scale>1?(scale-1)*10:0)+"|"+(xoffset+(rotate>preRotate?(rotate-preRotate)*10:0)+(scale>1?(scale-1)*10:0))+"|"+(3-(Math.abs(rotate))*4+(float)-bounds.getY())+"|"+bounds.getY()+"|"+(Math.abs(rotate))*4+"|"+((xoffset+(rotate-preRotate)*10 > 0?xoffset+(rotate-preRotate)*10:0)+(scale-1>0?(scale-1)*10:0)));
    	    //g2.drawString(s, 0, 5-(0.3f+rotate)*5+(float)-bounds.getY()+(scale-1)*20);
            g2.drawString(s, 0, 5-(0.3f+rotate)*5+(float)-(-13)+(scale-1)*20);
    	    g2.rotate(-rotate);
    	    g2.scale(1f/scale,scale);
    	    g2.translate(advance,0);
    	    return advance;
    	  }
	/**输出流*/
	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
}
