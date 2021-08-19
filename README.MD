#Getting pixels:

Send ice as arugment to play ice breaker sudoku game

###1st possibility:
run this command in a new tab in the IDE:
`print selectRegion()`
and select something on the screen that makes sense for you
It prints something like that:
Region[119,176 147x69]@Screen(0) E:Y, T:3,0

###2nd possibility: (more accurate)
put this command in a new tab in the IDE:
`print Env.getMouseLocation()`

the usage is a bit more complicated, since you cannot use the mouse ;-)
-- make visible on the screen, what you are interested on
-- move the mouse to the point of interest
-- go back to Sikuli IDE using the keyboard (ctrl-tab on windows, cmd-tab on Mac)
-- press ctrl-R/cmd-R to run the script
It prints something like that:
(117,128)
which is your (x,y)

###3rd possibility: 
capture image by using below command
`import shutil
img = capture(651,49, 66, 27)`

The image is under temp location:

`C:\Users\xxxx\AppData\Local\Temp\Sikulix_689679812\sikuliximage-1627179709478.png`





