package pl.edu.mimuw.sikora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import pl.edu.mimuw.sikora.recognition.Recognition;

public class RecordingActivity extends ActionBarActivity {

    private Recognition recognition = new Recognition(this);  // TODO pomyśleć nad jakimś callbackiem ("java callback")

    public void giveRecognized(String birdName) {
        if (birdName.equals("Parus major")) {
            ImageButton recognizedBird = (ImageButton) findViewById(R.id.recognizedBird);
            recognizedBird.setImageResource(R.drawable.sikora);
        } else if (birdName.equals("Emberiza citrinella")) {
            ImageButton recognizedBird = (ImageButton) findViewById(R.id.recognizedBird);
            recognizedBird.setImageResource(R.drawable.trznadel);
        } else {
            ImageButton recognizedBird = (ImageButton) findViewById(R.id.recognizedBird);
            recognizedBird.setImageResource(0);
            //recognizedBird.setImageDrawable(null); // TODO zobaczyć co się stanie :D
        }
    }

    public void startRecording() {
        recognition.start();
        ImageButton recordingButton = (ImageButton) findViewById(R.id.recordingButton);
        recordingButton.setImageResource(R.drawable.abc_btn_rating_star_on_mtrl_alpha);
    }

    public void stopRecording() {
        recognition.stop();
        ImageButton recordingButton = (ImageButton) findViewById(R.id.recordingButton);
        recordingButton.setImageResource(R.drawable.abc_btn_rating_star_off_mtrl_alpha);
    }

    public void recordingButtonClick(View view) {
        if (!recognition.isRecording()) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recording, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
