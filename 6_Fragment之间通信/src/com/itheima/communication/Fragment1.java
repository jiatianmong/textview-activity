package com.itheima.communication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment1, null);
		//[1]�ҵ���ť���õ���¼� 
		view.findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Toast.makeText(getActivity(), "jagjajgl", 1).show();
				//[2]�޸�Fragment2����textview��ֵ 
				Fragment2 f2 = (Fragment2) getActivity().getFragmentManager().findFragmentByTag("f2");
				f2.setText("haahha");
				
			}
		});
		
		return view;
	}
}
