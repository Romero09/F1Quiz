package com.example.android.f1quiz;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //global score for answers
    int correct = 0;
    int incorrect = 0;

    //Question 1 global var.
    int Q1incorrect;
    int Q1correct;

    //Question 2 global var.
    int Q2incorrect;
    int Q2correct;

    //Question 3 global var.
    int Q3incorrect;
    int Q3correct;

    //Question 4 global var.
    int Q4incorrect;
    int Q4correct;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRadioButtonsQ1();
        setRadioButtonsQ4();



    }

    //Question 1
    public void setRadioButtonsQ1() {
        //checking wich radio button is checked
        RadioGroup radioGroup1 = findViewById(R.id.radio1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    //incorrect
                    case R.id.radio_max:
                        Q1incorrect = 1;
                        Q1correct = 0;
                        break;
                    //Its correct answer
                    case R.id.radio_fer:
                        Q1incorrect = 1;
                        Q1correct = 0;
                        break;
                    //incorrect
                    case R.id.radio_seb:
                        Q1incorrect = 0;
                        Q1correct = 1;
                        break;
                }
            }
        });
    }


    //Question 2
    public void question2(View view){

        //saving checkbox resault in boolean var.
        CheckBox boxNico = findViewById(R.id.box_nico);
        boolean boxNicoChecked = boxNico.isChecked();

        CheckBox boxFer = findViewById(R.id.box_fer);
        boolean boxFerChecked = boxFer.isChecked();

        CheckBox boxMax = findViewById(R.id.box_max);
        boolean boxMaxChecked = boxMax.isChecked();

        CheckBox boxFel = findViewById(R.id.box_fel);
        boolean boxFelChecked = boxFel.isChecked();

        CheckBox boxSeb = findViewById(R.id.box_seb);
        boolean boxSebChecked = boxSeb.isChecked();

        CheckBox boxDan = findViewById(R.id.box_dan);
        boolean boxDanChecked = boxDan.isChecked();

        //If this two booleans is true - answer is correct.
        if (boxMaxChecked && boxSebChecked) {
            Q2correct = 1;
            Q2incorrect = 0;

            //If some no one checked than all scoes is 0, i will works in case if some one will
            //answer, and than change his opinion.
        }else if (!boxMaxChecked && !boxNicoChecked && !boxFerChecked && !boxFelChecked && !boxSebChecked && !boxDanChecked){
            Q2correct = 0;
            Q2incorrect = 0;

            //in all other cases, answer is incorrect
        }else{
            Q2correct = 0;
            Q2incorrect =1;
        }



    }

    public void question3(View view) {
        EditText teamName = findViewById(R.id.question_3_text);
        String teamNameText = teamName.getText().toString();

        //correct answer
        if (teamNameText.equals("Williams")) {
            Q3correct = 1;
            Q3incorrect = 0;

        //if nothing is typed
        } else if (teamNameText.equals("")) {
            Q3correct = 0;
            Q3incorrect = 0;

        //in other cases answer is incorrect
        } else {
            Q3correct = 0;
            Q3incorrect = 1;

        }

    }

    //Question 4
    public void setRadioButtonsQ4() {
        //checking wich radio button is checked
        RadioGroup radioGroup2 = findViewById(R.id.radio2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    //incorrect
                    case R.id.radio_ham:
                        Q4incorrect = 1;
                        Q4correct = 0;
                        break;
                    //Its correct answer
                    case R.id.radio_ric:
                        Q4incorrect = 0;
                        Q4correct = 1;
                        break;
                    //incorrect
                    case R.id.radio_rai:
                        Q4incorrect = 1;
                        Q4correct = 0;
                        break;
                }
            }
        });
    }


    //submit answers method tho show quantity of correct and incorrect answers
    public void submit (View view) {
        //starts method for question 2
        question2(view );

        //starts method for question 3
        question3(view );

        //counts correct/incorrect answers
        correct += Q1correct + Q2correct + Q3correct + Q4correct;
        incorrect += Q1incorrect + Q2incorrect + Q3incorrect + Q4incorrect;


        //Message that shows score
        Toast score = Toast.makeText(this, "Correct: " + correct + " Incorrect: " + incorrect, Toast.LENGTH_SHORT);
        score.show();

        //resets score for new try
        correct = 0;
        incorrect = 0;

    }

}
