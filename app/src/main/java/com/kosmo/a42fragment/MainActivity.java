package com.kosmo.a42fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kosmo.a42fragment.MyFragment3;
import com.kosmo.a42fragment.R;

public class MainActivity extends AppCompatActivity {

    //프레그먼트 관리자 및 자바코드로 교체할 프레그먼트 선언
    FragmentManager fragmentManager;
    MyFragment1 myFragment1;
    MyFragment2 myFragment2;
    MyFragment3 myFragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼객체 생성 및 리스너 부착
        Button btn1Frag = (Button)findViewById(R.id.btnFirstFragment);
        Button btn2Frag = (Button)findViewById(R.id.btnSecondFragment);
        Button btn3Frag = (Button)findViewById(R.id.btnThirdFragment);
        btn1Frag.setOnClickListener(listener);
        btn2Frag.setOnClickListener(listener);
        btn3Frag.setOnClickListener(listener);

        //프레그먼트 교체를 위한 매너져 객체 생성
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //프레그먼트 객체 생성
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();

        //첫번째 프레그먼트로 Bundle객체를 통해 데이터를 전달함.
        Bundle bundle = new Bundle();//번들객체 생성
        //데이터저장
        bundle.putString("KOSMO", "한국소프트웨어인재개발원");
        //데이터전달
        myFragment1.setArguments(bundle);
        //프레그먼트 교체 및 적용
        /*
        앰이 첫실행일때 fragment1을 화면에 즉시 적용한다.
            replace()는 교체, commit()은 적용.
         */
        fragmentTransaction.replace(R.id.bottomLayout, myFragment1).commit();
    }//// onCreate End

    //리스너정의
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /*
            버튼 클릭시 전달된 View객체를 통해 리소스 아이디를 가져올수 있다.
            버튼을 구분하여 해당 프레그먼트로 교체 및 적용한다.
             */
            if(view.getId() == R.id.btnFirstFragment) {
                fragmentManager.beginTransaction().replace(R.id.bottomLayout, myFragment1).commit();
            }
            else if(view.getId() == R.id.btnSecondFragment) {
                fragmentManager.beginTransaction().replace(R.id.bottomLayout, myFragment2).commit();
            }
            else if(view.getId() == R.id.btnThirdFragment) {
                fragmentManager.beginTransaction().replace(R.id.bottomLayout, myFragment3).commit();
            }
        }
    };
    //프레그먼트1, 2는 내부클랙스로 정의함.
    public static class MyFragment1 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            //자바코드로 프레그먼트를 붙일 시 세번쨰 인자 반드시 false 로 해야함. 그렇지 않으면 ANR 발생
            View view = inflater.inflate(R.layout.my_fragment1, container, false);

            //데이터 받기 - 버튼을 눌렀을 때 받은 데이터 출력
            Button button1 = view.findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*
                    프레그먼트 교체시 번들객체를 통해 전달되었던 데이터를 아래와 같이 받을수 잇다.
                     */
                    Bundle bundle = getArguments();
                    String value = bundle.getString("KOSMO");
                    Toast.makeText(view.getContext(), value, Toast.LENGTH_LONG).show();
                }
            });
            return view;
        }
    }

    public static class MyFragment2 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.my_fragment2, container, false);

            ((Button)view.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "두번째 프레그먼트 입니다.",
                            Toast.LENGTH_LONG).show();
                }
            });
            return view;
        }
    }
}



























