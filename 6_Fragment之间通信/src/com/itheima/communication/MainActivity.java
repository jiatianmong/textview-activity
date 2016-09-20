package com.itheima.communication;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;

@SuppressLint("CommitTransaction")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]��ȡFragment�Ĺ�����
		FragmentManager fragmentManager = getFragmentManager();
		//[2]�������� 
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		//[3]��̬�滻
		transaction.replace(R.id.ll1, new Fragment1(),"f1");
		transaction.replace(R.id.ll2, new Fragment2(),"f2");
		
		//[4]���һ�� �ǵ�commit
		transaction.commit();
		
		
	}


}
