###Image Slideshow - JavaFX

This is a simple image slideshow project in JavaFX.  

##Some issues/challenges I faced during this task include but not limited to:

### 1. Repetitive boiler plate code
### 2. For this task, managing state was relatively simple. However if a similar 
### application grows in scope, managing the state could prove difficult in the way it is implemented here
### 3. I currently do not have unit tests for the task. So there could be issues or bugs I may have overlooked

What I would like to implement going forward:

1. Unit Testing the controllers would take first priority
2. Break down methods inside controllers
3. Somehow "de-couple" the controllers.
4. Centralized place to manage state 
5. Progress Bar


## How to run the application (and set up for IntelliJ):
1. Clone the repo
2. Open the project in your favorite IDE (I used IntelliJ for my development so I'll put the installation set up for IntelliJ below)
3. If you do not have JavaFX installed already:
   1. Download the JavaFX SDK from here: https://gluonhq.com/products/javafx/
   2. Extract the file to a location. (Remember the location)
   3. Create a new JavaFX project in IntelliJ (File > New Project > JavaFX project > Finish)
   4. This will set up a small boilerplate JavaFX code. You will still get errors though. Continue reading:
   5. Add your SDK Library - File > Project Structure > Libraries > "+" > 
      1. Select the location where you extracted the SDK
      2. Expand the SDK folder
      3. Select the "lib" folder
      4. Click "Ok" on next few prompts
      5. All errors should now go away
   6. Add VM options. Go to https://openjfx.io/openjfx-docs/
      1. Select JavaFx and IntelliJ > Non-modular from IDE
      2. Scroll down on the page and copy the text in "Add VM Options" for the command prompt/terminal
      3. Go to IntelliJ > Run > Edit Configurations > paste the above copied text in VM Options
      4. In the copied path, there is a text: /path/to/javafx-sdk-17.0.1/lib (for Mac/Linux) or "\path\to\javafx-sdk-17.0.1\lib" (for windows)
      5. Replace that with path to lib to the SDK you downloaded in step 1
      6. Click "Apply" > "OK".
      7. Assuming you have followed the steps above, your application should be ready to run. 
      8. To run the application, simply click on the "Play" (Run) button in IntelliJ.
4. If you have already installed JavaFX, then simply load in the application into your IDE and click "Play"

How to navigate the application?
It is quite simple. When you run the application, a dialog box asks you to open the directory to choose your images.
1. Click Open
2. Select a folder which has your .jpg pictures
3. Click "Open"
4. This should start the image slideshow if there were .jpg in your chosen folder or the directories within
5. You can pause/reset the slideshow
6. If the program does not find any files with ".jpg" extension, a "File Not Found" picture will be shown and no controls (play/pause/reset)
will be present. (Credit for "File not found" picture: Alamy stock images)





