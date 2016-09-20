package com.example.Textview1;

import java.lang.reflect.Field;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Activity1 extends Activity {

	public Activity1() {
		// TODO Auto-generated constructor stub
	}

	public int getResouceId(String name) {

		try {
			// 根据资源的id名获得field的对象，使用反射机制来实现
			Field field = R.drawable.class.getField(name);

			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1);
		setTitle("activity1");
		TextView textview = (TextView) findViewById(R.id.textview);
		textview.setBackgroundColor(Color.WHITE);
		String html = "图像1<img src='i1'/>图像2<img src='i2'/>图像3<img src='i3'/><p>";
		html+="图像4<a href='http://www.baidu.com'><img src='i4'/></a>图像5<img src='i5'/> ";
		
		CharSequence charSequence = Html.fromHtml(html, new ImageGetter() {
			
			@Override
			public Drawable getDrawable(String source) {
				// TODO Auto-generated method stub
				//获得系统资源信息
				Drawable drawable = getResources().getDrawable(getResouceId(source));
				if(source.equals("i3")){
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth()/2, drawable.getIntrinsicHeight()/2);	
				}else{
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());	
				}
				return drawable;
			}
		}, null);
		textview.setText(charSequence);
		textview.setMovementMethod(LinkMovementMethod.getInstance());
		
		
	}
}
