package com.example.torchlightapp

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

var count=0
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val torch:Button=findViewById(R.id.torchSwitch)
        val cameraManager=getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraID=cameraManager.cameraIdList[0]

        torch.setOnClickListener {
            try {
            if (count % 2 == 0) {
                cameraManager.setTorchMode(cameraID, true)
                Toast.makeText(this, "ON", Toast.LENGTH_LONG).show()
                count++
            } else {
                cameraManager.setTorchMode(cameraID, false)
                Toast.makeText(this, "OFF", Toast.LENGTH_LONG).show()
                count++
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
        }
    }
}


