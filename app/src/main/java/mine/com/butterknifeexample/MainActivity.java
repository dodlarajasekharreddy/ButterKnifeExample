package mine.com.butterknifeexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.id_name_edit_text)
    EditText nameEdit;
    @BindView(R.id.id_designation_edit_text)EditText designationEdit;
    @BindView(R.id.id_salary_edit_text) EditText salaryEdit;
    @BindView(R.id.id_experience_edit_text) EditText experienceEdit;
    @BindView(R.id.submit_button)
    Button submitButton;
    @BindView(R.id.textview1)
    TextView textView1;
    @BindView(R.id.textview2) TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(nameEdit)&&validate(designationEdit)&&validate(salaryEdit)&&validate(experienceEdit)) {
                    display();
                }
            }
        });
    }

    private void display() {
        String name=nameEdit.getText().toString().trim();
        String designation= designationEdit.getText().toString().trim();
        String salary=salaryEdit.getText().toString().trim();
        String experience =experienceEdit.getText().toString().trim();
        textView1.setText("Your name is "+name+" working as "+designation);
        textView2.setText("with salary "+salary+" have experience of "+experience+" months");
    }

    private boolean validate(EditText edit) {
        if(edit.getText().toString().trim().length()>0){
            return true;
        }
        edit.setError("Please fill This");
        edit.requestFocus();
        return false;
    }
    //my name is ashish
}
