package com.example.muziki
//import android.os.Bundle
//import kotlinx.android.synthetic.main.activity_main.*
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.example.muziki.R
import com.example.muziki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable:Runnable
    private lateinit var binding :ActivityMainBinding
    private var handler: Handler = Handler()
    private var pause:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start the media player
        findViewById<Button>(R.id.playBtn).setOnClickListener{
            if(pause){
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false
                Toast.makeText(this,"media playing",Toast.LENGTH_SHORT).show()
            }else{

                mediaPlayer = MediaPlayer.create(applicationContext,R.raw.school_bell)
                mediaPlayer.start()
                Toast.makeText(this,"media playing",Toast.LENGTH_SHORT).show()

            }
            initializeSeekBar()
            binding.playBtn.isEnabled = false
            binding.pauseBtn.isEnabled = true
            binding.stopBtn.isEnabled = true

            mediaPlayer.setOnCompletionListener {
                binding.playBtn.isEnabled = true
                binding.pauseBtn.isEnabled = false
                binding.stopBtn.isEnabled = false
                Toast.makeText(this,"end",Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player
        binding.pauseBtn.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                pause = true
                binding.apply {
                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = true
                }
                Toast.makeText(this,"media pause",Toast.LENGTH_SHORT).show()
            }
        }
        // Stop the media player
        binding.stopBtn.setOnClickListener{
            if(mediaPlayer.isPlaying || pause.equals(true)){
                pause = false
                binding.seek_bar.setProgress(0)
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()
                handler.removeCallbacks(runnable)
                binding.apply {
                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = false
                    binding.tv_pass.text = ""
                    binding.tv_due.text = ""
                }
                Toast.makeText(this,"media stop",Toast.LENGTH_SHORT).show()
            }
        }
        // Seek bar change listener
        binding.seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }
    // Method to initialize seek bar and audio stats
    private fun initializeSeekBar() {
        binding.seek_bar.max = mediaPlayer.seconds

        runnable = Runnable {
            binding.seek_bar.progress = mediaPlayer.currentSeconds

            binding.tv_pass.text = "${mediaPlayer.currentSeconds} sec"
            val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
            binding.tv_due.text = "$diff sec"

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }
}
// Creating an extension property to get the media player time duration in seconds
val MediaPlayer.seconds:Int
    get() {
        return this.duration / 1000
    }
// Creating an extension property to get media player current position in seconds
val MediaPlayer.currentSeconds:Int
    get() {
        return this.currentPosition/1000
    }