package com.example.bolamagica;





import java.util.Random;
import android.support.v7.app.ActionBarActivity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class BolaMagicaActivity extends ActionBarActivity {
	int x;
	public TextView tv2;
	String a[] = { "si", "En mi opinión, si", "Es cierto", "Es decididamente así", "Probablemente", 
			"Buen pronóstico", "Todo apunta a que sí", "Sin duda",
			"Sí - definitivamente","Debes confiar en ello","Respuesta vaga, vuelve a intentarlo",
			"Pregunta en otro momento","Ser mejor que no te lo diga ahora",
			"No puedo predecirlo ahora","Concentrate y vuelve a preguntar",
			"No cuentes con ello", "Mi respuesta es no",
			" Mis fuentes me dicen que no", "Las perspectivas no son buenas",
	"Muy dudoso"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bola_magica);
		tv2= (TextView) findViewById(R.id.tv2);
	}

	public void onClick(View v) {
		
		
		tv2.setText(a[x]);
		Random rnd = new Random();
		x = rnd.nextInt(a.length);
		
		

		
	playSound();
	animateBall();
	}
	
	private void playSound(){
		
	    MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.magicball);
	    mediaPlayer.start();
	    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

	        
	        public void onCompletion(MediaPlayer mp) {
	            mp.release();

	        }
	    });
	}
private void animateBall(){
		
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(R.drawable.ball_animation);
		AnimationDrawable anidra = (AnimationDrawable) imageView.getDrawable();
		if(anidra.isRunning())
			anidra.stop();
		
		anidra.start();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bola_magica, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
