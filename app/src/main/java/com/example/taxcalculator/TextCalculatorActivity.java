package com.example.taxcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TextCalculatorActivity extends AppCompatActivity {

    TextInputEditText etIncome;
    MaterialButton btnCalculate;
    TextView tvResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etIncome = findViewById(R.id.etIncome);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sIncome = etIncome.getText().toString();
/*
                if (sIncome.length()>0){

                    double income = Double.parseDouble(sIncome);
                    double tex = 0;

                    if (income<=350000){
                        tvResult.setText("✅ সুসংবাদ!\nআপনার বার্ষিক আয় এখনো করযোগ্য সীমার নিচে রয়েছে।\nআপনাকে আয়কর প্রদান করতে হবে না।\nতবে ভবিষ্যতে আয় বৃদ্ধি পেলে নিয়মিত যাচাই করুন।\n\n🎯 আপনি বর্তমানে করমুক্ত আয়ের আওতায় আছেন।");
                        return;
                    }

                    double texblanceIncome = income - 350000;

                    if (texblanceIncome <= 100000){

                        tex = texblanceIncome * 0.05;

                    } else if (texblanceIncome <= 500000) {

                        tex = (100000 * 0.05) + ((texblanceIncome - 100000) * 0.10);

                    } else if (texblanceIncome <= 1000000) {

                        tex = (100000 * 0.05) + (400000 * 0.10) + ((texblanceIncome - 500000) * 0.15);

                    }else {

                        tex = (100000 * 0.05) + (400000 * 0.10) + (500000 * 0.15) + (texblanceIncome - 1000000) *
                    }
                }

 */
                if (sIncome.length() > 0) {

                    double income = Double.parseDouble(sIncome);
                    double tax = 0;

                    if (income <= 350000) {
                        tvResult.setText("✅ সুসংবাদ!\nআপনার বার্ষিক আয় এখনো করযোগ্য সীমার নিচে রয়েছে।\nআপনাকে আয়কর প্রদান করতে হবে না।\nতবে ভবিষ্যতে আয় বৃদ্ধি পেলে নিয়মিত যাচাই করুন।\n\n🎯 আপনি বর্তমানে করমুক্ত আয়ের আওতায় আছেন।");
                        return;
                    }

                    double taxableIncome = income - 350000;

                    if (taxableIncome <= 100000) {
                        tax = taxableIncome * 0.05;

                    } else if (taxableIncome <= 400000) {
                        tax = (100000 * 0.05) + ((taxableIncome - 100000) * 0.10);

                    } else if (taxableIncome <= 800000) {
                        tax = (100000 * 0.05) + (300000 * 0.10) + ((taxableIncome - 400000) * 0.15);

                    } else if (taxableIncome <= 1300000) {
                        tax = (100000 * 0.05) + (300000 * 0.10) + (400000 * 0.15) + ((taxableIncome - 800000) * 0.20);

                    } else {
                        tax = (100000 * 0.05) + (300000 * 0.10) + (400000 * 0.15) + (500000 * 0.20) + ((taxableIncome - 1300000) * 0.25);
                    }

                    tvResult.setText("🎉 অভিনন্দন!\nআপনার বার্ষিক আয় করযোগ্য সীমা অতিক্রম করেছে।\nআপনাকে আয়কর প্রদান করতে হবে।\n\n🧾 হিসাব অনুযায়ী মোট করের পরিমাণ: " + tax + " টাকা।\n\n🇧🇩 দেশ গঠনে আপনার অবদান আমাদের জন্য গর্বের।");
                }

            }
        });
    }
}