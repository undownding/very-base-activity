# very-base-activity

[![Jit Pack](https://img.shields.io/github/tag/undownding/very-base-activity.svg?label=JitPack)](https://jitpack.io/#undownding/very-base-activity/0.1)

An activity to solve StatusBar color, Toolbar shadow(or Toolbar elevation), and swipe back in all Android version.

### Useage:

#### Modify your build.gradle:

```groovy
repositories {
    // ...
    maven { url "https://jitpack.io" }
}
    
dependencies {
    compile 'com.github.undownding:very-base-activity:0.1'
}
```

#### Use custom theme for target activity

```xml
<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:supportsRtl="true"
    android:theme="@style/Theme.BaseUI" >
    <activity
        android:name=".MainActivity"
        android:label="@string/app_name"
        android:theme="@style/Theme.BaseUI.NoActionBar" >
    </activity>
  </application>
```

#### Change Activity's parent class

```java
public class MainActivity extends VeryBaseActivity {
...
```
