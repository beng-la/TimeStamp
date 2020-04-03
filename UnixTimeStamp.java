package top.xiaolizi.a01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class UnixTimeStamp {
	public static void main(String[] args) {
		new MainJFrame().createJFrameWindow();
	}
}

class MainJFrame extends JFrame{
	public void createJFrameWindow() {
		JFrame jf = new JFrame();
		final int II = 18;
		Dimension dim = getToolkit().getScreenSize();     //获取尺寸
        jf.setBounds(dim.width/8,dim.height/8,dim.width/4,dim.height/4);//窗口大小和位置
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);			//点击右上角执行的操作
		jf.setTitle("Unix时间戳获取");						//title
		JLabel jl = new JLabel("点击获取时间戳");				//提示
		JLabel jl2 =new JLabel("点击清空");
		JTextArea[] jt = new JTextArea[II];		
		for(int i3=0;i3<II;i3++) {
			jt[i3]=new JTextArea();
			jt[i3].setColumns(10);					//行数
			jt[i3].setRows(1);						
		}
		JButton getB = new JButton("GET");					//按钮
		Long[] stamp = new Long[II];
		int[] i = new int[1];
		getB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
//                 jf.dispose();               //关闭窗口并释放资源
            	Long startTs = System.currentTimeMillis(); 		//获取时间戳
                stamp[i[0]] = startTs;
                jt[i[0]].replaceSelection(""+stamp[i[0]]);
                i[0]++;
            }	
        });
		JButton reSet = new JButton("RESET");
		reSet.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				i[0]=0;
				for(int i1=0;i1<II;i1++){
		            jt[i1].setText("");
		        }
			}
		});	
		jf.setLayout(new FlowLayout(1,10,10));//设置布局管理器	
		Container c = jf.getContentPane();
		c.add(getB);
		c.add(jl);
		c.add(reSet);
		c.add(jl2);
		for(int a=0;a<II;a++) {
			c.add(jt[a]);
		}
		jf.setVisible(true);								//窗口可见性
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);			//点击右上角执行的操作
	}	
}