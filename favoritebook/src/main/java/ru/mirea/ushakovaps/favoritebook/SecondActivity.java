package ru.mirea.ushakovaps.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView bookView = findViewById(R.id.devFavBook);
            String bookName = extras.getString(MainActivity.KEY);
            bookView.setText(String.format("Любимые книги разработчика: %s", bookName));
        }
    }

    public void returnBook(View view) {
        EditText editText = findViewById(R.id.editBook);
        String text = editText.getText().toString();

        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}