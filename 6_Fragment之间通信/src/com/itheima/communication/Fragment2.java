package com.itheima.communication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

	private TextView tView;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment2, null);
		
		tView = (TextView) view.findViewById(R.id.tv);
		
		return view;
	}
	
	
	//�޸�textviewֵ�ķ���
	public void setText(String content){
		tView.setText(content);
	}
}
