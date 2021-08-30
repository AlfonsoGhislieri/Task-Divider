# Task Divider

### Video Demo:  
https://www.youtube.com/watch?v=QoK3JMEjaHY&t=1s

### Description:

I decided to create an Android Application called "Task Divider" which divides tasks 
for users. This was achieved using Android Studio and Java, I used this as an opportunity to learn a
language and is the first application I have ever created.

### Main:
<p>
The main class makes the first Fragment show when the app is launched by the user and hides 
the action bar. </p>

### Fragment1:
<p>
The Fragment1 class takes care of storing the data inputted by the user. When the user fills in a 
editText field and clicks the appropriate button, the OnClick method adds the data to either of 
the two empty ArrayLists: "users" and "tasks". Users are required to input a minimum of 1 task 
and 2 users, with no maximum, and no empty fields can be submitted. 

Once the user clicks the continue button (if the minimum requirements mentioned above have been met), 
the two lists are stored in Bundles and prepared to passed on to Fragment2. The view will then
transition to showing Fragment2 to the user.</p>

### Fragment2:
<p>
Fragment2 receives the "users" and "tasks" lists passed on from Fragment1 and prepares the data.

The calculate() method does most of the heavy lifting of the app. This is where the tasks are 
randomly assigned to the users using a 2d Array: "dividedTasks". Firstly, for each user inputted,
a list is added to "dividedTasks" with the first entry being the name of the user. Secondly,
it iterates through every task and randomly assigns the task to one of the lists inside 
"dividedTasks". Thus, dividedTasks will have several lists, each containing one each user and any 
tasks randomly assigned to it. Finally, the calculate() will convert the 2d array back into a
1d array and returns it.

Fragment 2 will then show the user a ListView of the result of the calculate() method and 
gives the user the option to reset everything and go back to Fragment1 by clicking the "reset" button. </p>







