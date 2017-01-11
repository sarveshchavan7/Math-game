package sarveshchavan777.quizgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by LENOVO on 12/12/2016.
 */

public class MenuOptions extends Activity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_menu);
        b1 = (Button) findViewById(R.id.btnsimple);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuOptions.this, QuestionActivity.class);
                startActivity(intent);
            }
        });

    }
}
