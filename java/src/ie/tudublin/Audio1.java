package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
         ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
         ab = ai.mix; 

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

    }

    float off = 0;

    public void draw()
    {

        
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2;
        float cy = height / 2;

        switch (mode) {
			case 0:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, i, halfH - f);                    
                }
                break;
        case 1:
            background(0);            
            break;

        }

        

        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        

    let mode = 0;

function keyPressed() {
  if (key == ' ') {
    if (sound.isPlaying()) {
      sound.pause();
    } else {
      sound.loop();
    }
  } else if (key == '0') {
    mode = 0;
  } else if (key == '1') {
    mode = 1;
  } else if (key == '2') {
    mode = 2;
  } else if (key == '3') {
    mode = 3;
  } else if (key == '4') {
    mode = 4;
  } else if (key == '5') {
    mode = 5;
  }
}

function draw() {
    // Get the latest sound data
    let spectrum = fft.analyze();
    let waveform = fft.waveform();
  
    // Lerp the waveform values into the lerpedBuffer array
    for (let i = 0; i < waveform.length; i++) {
      lerpedBuffer[i] = lerp(lerpedBuffer[i], waveform[i], 0.1);
    }
  
    // Choose which visualization to draw based on the mode variable
    if (mode == 0) {
      // Wavy lines
      for (let i = 0; i < lerpedBuffer.length - 1; i++) {
        let x1 = map(i, 0, lerpedBuffer.length, 0, width);
        let x2 = map(i + 1, 0, lerpedBuffer.length, 0, width

      }
    }
}
let lerpedBuffer = [];

function draw() {
  // Get the latest sound data
  let spectrum = fft.analyze();
  let waveform = fft.waveform();

  // Lerp the waveform values into the lerpedBuffer array
  for (let i = 0; i < waveform.length; i++) {
    lerpedBuffer[i] = lerp(lerpedBuffer[i], waveform[i], 0.1);
  }

  // Use the lerpedBuffer values to draw the visualizations
  // ...
}

  

}
