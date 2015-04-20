package pl.edu.mimuw.sikora.recognition;
/**
 * Created by arek on 20.04.15.
 */

import java.util.Random;

import pl.edu.mimuw.sikora.RecordingActivity;

public class Recognition {

    private RecordingActivity recordingActivity;
    private boolean recording = false;

    private Random random = new Random();

    private Thread thread;

    public void start() {
        recording = true;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (recording) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    recordingActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int x = random.nextInt() % 5;
                            if (x == 0) {
                                recordingActivity.giveRecognized("Whatever...");
                            } else if (x % 2 == 0) {
                                recordingActivity.giveRecognized("Parus major");
                            } else {
                                recordingActivity.giveRecognized("Emberiza citrinella");
                            }
                        }
                    });
                }
            }
        });
        thread.start();
    }

    public void stop() {
//        thread.interrupt();
        recording = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Recognition(RecordingActivity recordingActivity) {
        this.recordingActivity = recordingActivity;
    }

    public boolean isRecording() {
        return recording;
    }

    private void recognize() {

    }
}
