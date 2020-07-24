package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton previousButton;
    private ImageView me;
    private TextView questionTextView;

    private int currentQuestion = 0;
    private Question[] questionBank = new Question[]{
            new Question(R.string.question_1,false),
            new Question(R.string.question_2,false),
            new Question(R.string.question_3,true),
            new Question(R.string.question_4,true),
            new Question(R.string.question_5,true),
            new Question(R.string.question_6,true),
            new Question(R.string.question_7,true),
            new Question(R.string.question_8,false),
            new Question(R.string.question_9,false),
            new Question(R.string.question_10,true),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionTextView = findViewById((R.id.answer_text_view));
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.previous_button);

        falseButton.setOnClickListener(this); //register our button to listen to clicks
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                //Toast.makeText(MainActivity.this,"True", Toast.LENGTH_SHORT).show();
                checkAnswer(true);
                break;

            case R.id.next_button:

                currentQuestion = (currentQuestion + 1) % questionBank.length;
                updateQuestion();
                break;

            case R.id.previous_button:
                if(currentQuestion>0)
                {
                    currentQuestion = (currentQuestion - 1) % questionBank.length;
                    updateQuestion();
                }

                break;

        }

    }

    private void updateQuestion()
    {
        Log.d("Current","onClick: " + currentQuestion);
        questionTextView.setText(questionBank[currentQuestion].getAnswerResid());
    }

    private void checkAnswer(boolean check)
    {
        boolean answerisTrue = questionBank[currentQuestion].isAnswerTrue();
        int toastMessageId = 0;

        if(check == answerisTrue){
            toastMessageId = R.string.correct_answer;
        }
        else{
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this,toastMessageId,Toast.LENGTH_SHORT).show();

    }
}