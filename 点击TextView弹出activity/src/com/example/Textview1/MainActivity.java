package com.example.Textview1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import com.example.Textview1.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView textview1 = (TextView) findViewById(R.id.textview1);
		TextView textview2 = (TextView) findViewById(R.id.textview2);
		TextView textview3 = (TextView) findViewById(R.id.textview3);
		TextView textview4 = (TextView) findViewById(R.id.textview4);
		String text1 = "显示第一个activity";
		String text2 = "显示第二个activity";

		//主要用来拆分字符串
		SpannableString spannableString1 = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);

		spannableString1.setSpan(new ClickableSpan() {			
			public void onClick(View widget) {
				Intent intent = new Intent(MainActivity.this,Activity1.class);
				startActivity(intent);								
			}
		}, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		spannableString2.setSpan(new ClickableSpan() {			
			public void onClick(View widget) {
				Intent intent = new Intent(MainActivity.this,Activity2.class);
				startActivity(intent);			  					
			}
		}, 0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);		
		
		
		textview1.setText(spannableString1);
		textview2.setText(spannableString2);
		textview1.setMovementMethod(LinkMovementMethod.getInstance());
		textview2.setMovementMethod(LinkMovementMethod.getInstance());
		
		
		SpannableString msp = new SpannableString("字体测试字体大小一半两倍前景色背景色正常粗体斜体粗斜体下划线删除线x1x2电话邮件网站短信彩信地图X轴综合/bot");
		
		 //设置字体(default,default-bold,monospace,serif,sans-serif)   
        msp.setSpan(new TypefaceSpan("monospace"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        msp.setSpan(new TypefaceSpan("serif"), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
          
        //设置字体大小（绝对值,单位：像素）    
        msp.setSpan(new AbsoluteSizeSpan(20), 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        msp.setSpan(new AbsoluteSizeSpan(20,true), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。   
          
        //设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍   
        msp.setSpan(new RelativeSizeSpan(0.5f), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //0.5f表示默认字体大小的一半   
        msp.setSpan(new RelativeSizeSpan(2.0f), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //2.0f表示默认字体大小的两倍   
          
        //设置字体前景色   
        msp.setSpan(new ForegroundColorSpan(Color.MAGENTA), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置前景色为洋红色   
          
        //设置字体背景色   
        msp.setSpan(new BackgroundColorSpan(Color.CYAN), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置背景色为青色   
       
        //设置字体样式正常，粗体，斜体，粗斜体   
        msp.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), 18, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //正常   
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体   
        msp.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 22, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //斜体   
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 24, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗斜体   
          
        //设置下划线 
        msp.setSpan(new UnderlineSpan(), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
          
        //设置删除线   
        msp.setSpan(new StrikethroughSpan(), 30, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        
        //设置上下标   
        msp.setSpan(new SubscriptSpan(), 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //下标      
        msp.setSpan(new SuperscriptSpan(), 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);   //上标               
          
        //超级链接（需要添加setMovementMethod方法附加响应）   
        msp.setSpan(new URLSpan("tel:4155551212"), 37, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //电话      
        msp.setSpan(new URLSpan("mailto:webmaster@google.com"), 39, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //邮件      
        msp.setSpan(new URLSpan("http://www.baidu.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //网络     
        msp.setSpan(new URLSpan("sms:4155551212"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //短信   使用sms:或者smsto:   
        msp.setSpan(new URLSpan("mms:4155551212"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //彩信   使用mms:或者mmsto:   
        msp.setSpan(new URLSpan("geo:38.899533,-77.036476"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //地图      
          
        //设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍   
        msp.setSpan(new ScaleXSpan(2.0f), 49, 51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变
      
        //设置项目符号   
        msp.setSpan(new BulletSpan(android.text.style.BulletSpan.STANDARD_GAP_WIDTH,Color.GREEN), 0 ,msp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //第一个参数表示项目符号占用的宽度，第二个参数为项目符号的颜色   
  
        //设置图片   
        Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);   
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());    
        msp.setSpan(new ImageSpan(drawable), 53, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
          
        textview3.setText(msp);  
        textview3.setMovementMethod(LinkMovementMethod.getInstance());   
        
        
        CharSequence fromHtml = Html.fromHtml("7月22日上午，李克强总理在钓鱼台芳华苑同世界银行行长金墉、国际货币基金组织总裁拉加德、世界贸易组织总干事阿泽维多、国际劳工组织总干事莱德、经济合作与发展组织秘书长古里亚、金融稳定理事会主席卡尼举行圆桌对话会。");
        textview4.setText(fromHtml);
        textview4.setMovementMethod(LinkMovementMethod.getInstance());
        
        
        
        
        
	} 

	
}
