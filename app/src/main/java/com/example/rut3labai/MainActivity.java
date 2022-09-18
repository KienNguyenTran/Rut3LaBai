package com.example.rut3labai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rutbai;
    private ImageView labai1;
    private ImageView labai2;
    private ImageView labai3;
    private TextView thongbao;

    private int sonut = 0;
    private int darut = 0;
    private boolean batay = true;
    private String chuoithongbao ="";
    ArrayList<String> cacladarut = new ArrayList<String>();
    int manghinhbai[][]={
            {R.drawable.b2fv,
                    R.drawable.ca,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                    R.drawable.cj,R.drawable.cq,R.drawable.ck},
            {R.drawable.b2fv,
                    R.drawable.da,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
                    R.drawable.dj,R.drawable.dq,R.drawable.dk},
            {R.drawable.b2fv,
                    R.drawable.ha,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
                    R.drawable.hj,R.drawable.hq,R.drawable.hk},
            {R.drawable.b2fv,
                    R.drawable.sa,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
                    R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
                    R.drawable.sj,R.drawable.sq,R.drawable.sk}
    };
    String mangtenbai[][]={
            {"rỗng",
                    "Ách chuồn","2 chuồn","3 chuồn","4 chuồn","5 chuồn",
                    "6 chuồn","7 chuồn","8 chuồn","9 chuồn","10 chuồn",
                    "J chuồn","Q chuồn","K chuồn"},
            {"rỗng",
                    "Ách rô","2 rô","3 rô","4 rô","5 rô",
                    "6 rô","7 rô","8 rô","9 rô","10 rô",
                    "J rô","Q rô","K rô"},
            {"rỗng",
                    "Ách cơ","2 cơ","3 cơ","4 cơ","5 cơ",
                    "6 cơ","7 cơ","8 cơ","9 cơ","10 cơ",
                    "J cơ","Q cơ","K cơ"},
            {"rỗng",
                    "Ách bích","2 bích","3 bích","4 bích","5 bích",
                    "6 bích","7 bích","8 bích","9 bích","10 bích",
                    "J bích","Q bích","K bích"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rutbai=(Button)findViewById(R.id.rutbai);
        labai1=(ImageView)findViewById(R.id.labai1);
        labai2=(ImageView)findViewById(R.id.labai2);
        labai3=(ImageView)findViewById(R.id.labai3);
        thongbao=(TextView)findViewById(R.id.txtthongbao);

        rutbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(darut==0)//lan dau hoac rut lai
                {
                    darut=0;
                    sonut=0;
                    batay=true;
                    chuoithongbao="";
                    labai1.setImageResource(R.drawable.b2fv);
                    labai2.setImageResource(R.drawable.b2fv);
                    labai3.setImageResource(R.drawable.b2fv);
                    cacladarut.clear();
                }
                darut++; //dem so lan rut
                //tao ngau nhien
                Random rd=new Random();
                int x,y;
                //tao ngau nhien bao vao ArrayList de xet xem co bi trung khong
                while(true)
                {
                    x=rd.nextInt(4);//0->3 (b-a+1)+a;
                    y=rd.nextInt(13)+1;//1->13
                    if(cacladarut.contains(mangtenbai[x][y])==false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }
                //chi can y<11 lap tuc khong con la batay nua
                if(y<11)
                    batay=false;
                if(darut==1)
                {
                    sonut+=(y<10)?y:0;
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==2)
                {
                    sonut+=(y<10)?y:0;
                    labai2.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==3)
                {
                    sonut+=(y<10)?y:0;
                    int kq=sonut%10;
                    darut=0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao+=", Số nút là "+ kq;
                    //rutbai.setEnabled(false);
                }
                thongbao.setText("Các lá đã rút là "+cacladarut.toString()
                        +chuoithongbao +", Ba con tây: "+batay);
            }
        });
    }
}