# RelativeCardView
Normal CardView holds the property of FrameLayout but this one will provide the property of the RelativeLayout.

[![](https://jitpack.io/v/mmb4rn0/RelativeCardView.svg)](https://jitpack.io/#mmb4rn0/RelativeCardView)

# Download
Grab via gradle-
  Step 1. Add the JitPack repository to your build file
  ```grovy
   allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```  
  Step 2. Add the dependency 
  ```grovy	
   dependencies {
	        compile 'com.github.mmb4rn0:RelativeCardView:v1.0.0'
	}
  ```
or via Maven-
  Step 1. Add the JitPack repository to your build file
  ```xml
   <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  ```
  Step 2. Add the dependency
  ```xml
   <dependency>
	    <groupId>com.github.mmb4rn0</groupId>
	    <artifactId>RelativeCardView</artifactId>
	    <version>v1.0.0</version>
	</dependency>
  ```

# Sample Code
```xml
<com.mmbarno.relativecard.RelativeCardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="40dp"
        app:cardBackgroundColor="#FFFFFF"
        app:cardCornerRadius="10dp"
        app:cardElevation="5dp"
        app:contentPadding="40dp">

        <TextView
            android:id="@+id/tv_left"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:text="Left Text"
            android:textSize="26sp" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignTop="@+id/tv_left"
            android:layout_alignBottom="@+id/tv_left"
            android:gravity="center_vertical"
            android:layout_marginLeft="10dp"
            android:layout_marginStart="10dp"
            android:layout_toRightOf="@+id/tv_left"
            android:layout_toEndOf="@+id/tv_left"
            android:text="Right Text" />

    </com.mmbarno.relativecard.RelativeCardView>
   ```
   
   #License
   
   MIT License

Copyright (c) 2017 Manzur E Mehedi Barno

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
