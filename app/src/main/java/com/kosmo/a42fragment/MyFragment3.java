package com.kosmo.a42fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //자바코드로 프레그먼트를 추가할 때 inflate()의 세번쨰 인자는 false 로 처리한다.
        final View view = inflater.inflate(R.layout.my_fragment3, container, false);

        //화면의 버튼을 누르면 토스트를 띄워준다.
        ((Button)view.findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),
                        "세번째 프레그먼트 입니다.",
                        Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
