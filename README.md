# Torchlight App Documentation

## Table of Contents

- [Introduction](#introduction)
- [Functionality](#functionality)
- [Code Explanation](#code-explanation)
  - [Importing Required Packages](#importing-required-packages)
  - [Initializing Variables](#initializing-variables)
  - [Setting Up OnClickListener](#setting-up-onclicklistener)
  - [Torch Control with Error Handling](#torch-control-with-error-handling)
- [Conclusion](#conclusion)

## Introduction

This Torchlight App is a user-friendly Android application created using Kotlin and native views components. Its core objective is to exemplify the interaction between Android applications and hardware devices, illustrating how hardware features can be controlled and utilized effectively within an app's context. By focusing on controlling the device's torchlight functionality, the app showcases the implementation of hardware communication through Android development. This documentation provides a comprehensive overview of the app's features, code structure, and functionality.

## Functionality

The primary functionality of the Torchlight App includes:

1. Turning on the torchlight when the app starts (if it's not already on).
2. Toggling the torchlight on and off by pressing the button in the app's UI.
3. Displaying a "ON" or "OFF" message in a toast notification when the torchlight state changes.

## Code Explanation

### Importing Required Packages

```kotlin
import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
```

Here, necessary Android packages are imported, including classes for managing the camera and UI elements.

### Initializing Variables

```kotlin
var count = 0
```

The variable `count` is used to keep track of the torchlight's state (on or off).

### Setting Up OnClickListener

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    val torch: Button = findViewById(R.id.torchSwitch)
    val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
    val cameraID = cameraManager.cameraIdList[0]
    
    torch.setOnClickListener {
        // ...
    }
}
```

In the `onCreate` method of the `MainActivity`, the UI elements are initialized, including the torchlight button (`torch`) and the camera manager (`cameraManager`).

### Torch Control with Error Handling

```kotlin
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
```

Within the `OnClickListener`, the app attempts to toggle the torchlight on and off. It uses a `try-catch` block to handle any exceptions that might occur during the process. If an exception is caught, a toast message displays an error with the specific error message.

## Conclusion

The Torchlight App showcases how to control the torchlight of an Android device using a simple button UI. The code demonstrates the use of the camera manager to control the torchlight, while also implementing error handling to gracefully manage exceptions that might arise during the torchlight control process.

---
