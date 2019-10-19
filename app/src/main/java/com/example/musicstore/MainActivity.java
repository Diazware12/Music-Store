package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    ListView listView;

    String instrumentName[] = {
            "Fender Deluxe Stratocaster",
            "Taylor 214ce-CF Deluxe Coprafera",
            "Nord Electro 6D 61",
            "TAMA RM52KH6C-CCM Rhythm Mate",
            "Squier Bronco Bass Guitar",
            "Akai MPD 218 Pad Controller",
            "MEINL Percussion MCAJ100BK-MA",
            "Pioneer DDJ-WeGO4 Compact DJ Controller",
            "Pioneer PLX-500 Professional Turntable, Black",
            "Blue Microphones Yeti USB Microphone"};


    String instrumentDetails[] = {
            "There is arguably no electric guitar more ingrained in modern culture than the Fender Stratocaster. Its contoured body, innovative tremolo bridge, and sparkling trio of single-coil pickups combine in an instrument that has been embraced by players of all genres since it appeared in the 1950s.",
            "Taylor Guitars was founded in 1974 by Bob Taylor and Kurt Listug, and has grown into the leading global builder of premium acoustic guitars. Renowned for blending modern, innovative manufacturing techniques with a master craftsman's attention to detail, Taylor acoustic guitars are widely considered among the best-sounding and easiest to play in the world, with Bob himself being known throughout the musical instrument industry as the visionary acoustic guitar manufacturer.",
            "The Nord Electro 6 combines Nord's award-winning emulations of vintage electro-mechanical and acoustic instruments in an ultra-portable package. With 3 independent sound sections, a new streamlined user interface and the addition of Seamless Transitions, the Electro 6 is the most powerful and flexible Electro ever - a refined modern classic.",
            "Tama began manufacturing drums in 1965 under the name \"Star Drums\", and Star continues to be used in the names of Tama's drum models to this day. Tama were one of the first manufacturers to offer super heavy-duty hardware, and drum mounting systems that did not intrude into the shell. Tama's drums and hardware are world renowned as among the best available",
            "Fender have been making high quality, low-cost instruments under the Squier brand since the early 1980s. Squier instruments are widely known to be exceptional value for money, meaning you can own a classic without breaking the bank! The Squier Bronco is the perfect starter bass for students. With its slim 30\"-scale neck and lightweight body, it is an easy-to-play bass featuring a double-cutaway body, maple neck and fretboard, and a single-coil pickup, with master volume and tone controls. It delivers a great tone and feel and represents solid value that no other bass can match",
            "The MPD218 is a MIDI-over-USB pad controller perfect for producers, programmers, musicians and DJs alike. Its intuitive blend of MPC controls and technologies mesh with easy USB connectivity to bring the feel of classic beat making into the world of computer music production.",
            "Founded by Roland Meinl in 1951 and initially producing wind instruments, the first MEINL cymbals appeared in 1952 and were cut from large metal sheets, hammered, lathed and drilled by hand by Roland Meinl himself, who then personally transported them, on the luggage carrier of his bicycle, to the railway station for shipment. MEINL has since gone from such humble origins to become a world leader in percussion instruments.",
            "Perfect for beginners to take their first steps into the world of DJ-ing with the compact DDJ-WeGO4. Learn to mix seamlessly with tactile controls and jog wheels for scratching. And use the sampler, Hot Cues and Pad FX inherited from professional hardware to bring more creativity to your sets. Just plug in your laptop, tablet or smartphone and start to play.",
            "The Pioneer PLX-500 Direct Drive Turntable inherits the layout of the PLX-1000 professional turntable and delivers a warm, clear analogue sound. It's the perfect turntable if you want to start playing with vinyl or if you just want to listen to your record collection at home. Solidly built with excellent vibration damping and precise audio playback, this high-torque deck has a USB out so you can make digital recordings of your vinyl collection with the free rekordbox software. You can also combine the PLX-500 with the rekordbox dvs Plus Pack, a compatible mixer and the RB-VS1-K Control Vinyl to play and scratch with digital files.",
            "They shaid it couldn’t exist – but it does. The best-selling Yeti USB Microphone from Blue Microphones features a visual design inspired by classic recording equipment, with a stylish, retro design tat will complement any computer system. Its metal grille and shiny frame recall the look of vintage mics, but with 21st-century technology inside. Being built on a hinge means you can adjust and pivot the microphone in relation to the sound source, improving sound quality. Once you have it at the desired angle, you can secure it in place using the set screws. You can create unparalleled recordings with your computer using the Yeti’s proprietary tri-capsule technology."
    };

    int instrumentImages[] = {
            R.drawable.fender,
            R.drawable.taylor_guitar,
            R.drawable.nord_electro,
            R.drawable.tama,
            R.drawable.squier_bass,
            R.drawable.akai,
            R.drawable.meinl_cajon,
            R.drawable.pioneer_dj1,
            R.drawable.pioneer_dj2,
            R.drawable.blue_yeti
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListViewInstrument);

        ListInstrumentAdapter adapter = new ListInstrumentAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("title",instrumentName[i]);
                intent.putExtra("subtitle",instrumentDetails[i]);
                intent.putExtra("image",instrumentImages[i]);

                startActivity(intent);
            }
        });

    }

    private class ListInstrumentAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return instrumentImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = getLayoutInflater().inflate(R.layout.instrument_row,null);

            TextView name = v.findViewById(R.id.textView1);
            TextView description = v.findViewById(R.id.textView2);
            ImageView image = v.findViewById(R.id.img_instrument);

            name.setText(instrumentName[i]);
            description.setText(instrumentDetails[i]);
            image.setImageResource(instrumentImages[i]);

            return v;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //membaca file menu dan tambahin icon
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item)
    {
        int id = item.getItemId();

        if (id==R.id.profilepic)
        {
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
            return  false;
        }

        return super.onOptionsItemSelected(item);
    }
}
