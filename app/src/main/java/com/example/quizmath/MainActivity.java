package com.example.quizmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan kuis
    String[] pertanyaan_kuis = new String[]{
            "1. 16 + 17 =",
            "2. 24 : 4 =",
            "3. 15 - 20 =",
            "4. 20 + 35 =",
            "5. 35 - 15 =?",

    };
    //pilihan jawaban a, b, c, d;
    String[] pilihan_jawaban = new String[] {
            "23","30","15","33",
            "7","6","10","12",
            "-5","5","15","10",
            "56","57","55","58",
            "15","20","34","23",
    };

    //jawaban yang benar
    String [] jawaban_benar = new String[]{
            "33",
            "6",
            "-5",
            "55",
            "20",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;



    }
    public void next(View view){
        if (PilihanA.isChecked()||PilihanB.isChecked()||PilihanC.isChecked()||PilihanD.isChecked()){
            RadioButton jawaban_user = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if (nomor<pertanyaan_kuis.length){
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor*4)+0]);
                PilihanB.setText(pilihan_jawaban[(nomor*4)+1]);
                PilihanC.setText(pilihan_jawaban[(nomor*4)+2]);
                PilihanD.setText(pilihan_jawaban[(nomor*4)+3]);

            }
            else {
                hasil=benar * 20;
                Intent selesai = new Intent(getApplicationContext(),HasilQuiz.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this, "Pilih Jawaban dulu", Toast.LENGTH_SHORT).show();
        }
    }
}
